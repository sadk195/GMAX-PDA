package com.PDA.gmax.M40;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.PDA.gmax.BaseActivity;
import com.PDA.gmax.DBAccess;
import com.PDA.gmax.R;
import com.PDA.gmax.TGSClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;
import java.util.List;


public class M41_DTL_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== m41 스캔 데이터 변수 ==//
    private M40_DTL vItem;

    //== View 선언(EditText) ==//
    private EditText QR_Code;
    private String tx_QR_Code="";

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(Button) ==//
    private Button btn_end,btn_query;

    //== View 선언(ImageView) ==//
    private ImageView img_barcode;

    //== View 선언(CheckBox) ==//
    private CheckBox chk_custom;

    //== ActivityForResult 관련 변수 선언 ==//
    private final int M41_DTL_REQUEST_CODE = 0;

    //== ListView Adapter 선언 ==//
    M41_DTL_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m41_dtl);

        this.initializeView();

        this.initializeListener();

    }

    private void initializeView() {
        //== BaseActivity 에서 SESSION 값 셋팅 ==//
        this.init();

        //== Intent에서 값 가져오기 ==//
        vMenuID         = getIntent().getStringExtra("MENU_ID");
        vMenuNm         = getIntent().getStringExtra("MENU_NM");
        vMenuRemark     = getIntent().getStringExtra("MENU_REMARK");
        vStartCommand   = getIntent().getStringExtra("START_COMMAND"); //다음 페이지에 가지고 넘어갈 코드


        //== ID값 바인딩 ==//
        QR_Code       = (EditText) findViewById(R.id.QR_Code);
        listview    = (ListView) findViewById(R.id.listPacking);
        btn_query    = (Button) findViewById(R.id.btn_query);

        btn_end    = (Button) findViewById(R.id.btn_end);
        chk_custom  = (CheckBox) findViewById(R.id.custom);
        img_barcode     = (ImageView) findViewById(R.id.img_barcode);

        //== Adapter 선언 ==//
        ListViewAdapter = new M41_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

        //ListViewAdapter.notifyDataSetChanged();
        start();
    }





    private void initializeListener() {

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                finish();
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = TGSClass.ChangeView(getPackageName(), M41_QUERY_Activity.class);
                startActivityForResult(intent, 0);
            }
        });
        //== 바코드 이벤트 ==//
        img_barcode.setOnClickListener(qrClickListener);
        QR_Code.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {

                    try{
                        //바코드 입력시 텍스트 리프레시를 위해서 설정
                        String temp=QR_Code.getText().toString();//.replaceFirst(tx_QR_Code,"");
                        //temp="MD221104-001";
                        QR_Code.setText(temp);
                        tx_QR_Code=QR_Code.getText().toString();

                        //쿼리중복 방지(쓰레드 중복 방지)
                        if(!QueryOn){
                            return false;
                        }
                        QueryOn = false;
                        //중복방지 타이머 실행
                        SetTimerTask();

                        Scan_QR();

                        QR_Code.setText("");
                        QR_Code.setSelection(QR_Code.getText().length());

                        start();
                        return true;

                    }
                    catch(Exception e){
                        TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오");
                    }
                    return true;
                }

                return false;
            }
        }
        );
    }

    private void start() {
        //TGSClass.AlertMessage(getApplicationContext(), BP_CD.getOnItemSelectedListener().toString());
        dbQuery();

        if (!sJson.equals("")) {
            try {
                JSONArray ja = new JSONArray(sJson);
                ListViewAdapter.ClearItem();
                //for (int idx = ja.length()-1; idx > 0; idx--) {
                for (int idx = 0; idx <ja.length(); idx++) {
                    JSONObject jObject = ja.getJSONObject(idx);

                    M40_DTL item = new M40_DTL();
                    item.setNO(idx+1);
                    item.setCODE            (jObject.getString("CODE"));
                    item.setAREA_DENSITY    (jObject.getString("AREA_DENSITY"));
                    item.setLOT_NO          (jObject.getString("LOT_NO"));
                    item.setROLL_NO         (jObject.getString("ROLL_NO"));
                    item.setWIDTH           (jObject.getString("WIDTH"));
                    item.setLENGTH          (jObject.getString("LENGTH"));
                    item.setQR_VALUE_ALL    (jObject.getString("QR_VALUE_ALL"));
                    item.setSTATUS          (jObject.getString("STATUS"));

                    ListViewAdapter.addPkgItem(item);
                    ListViewAdapter.notifyDataSetChanged();
                }

                listview.setAdapter(ListViewAdapter);


            } catch (JSONException ex) {
                TGSClass.AlertMessage(this, ex.getMessage());
            } catch (Exception e1) {
                TGSClass.AlertMessage(this, e1.getMessage());

            }
        }
    }

    private void dbQuery() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M41_GET_ANDROID";
                sql += " @FLAG ='M41_HDR'";//원단 넓이

                DBAccess dba = new DBAccess(TGSClass.ws_name_space, TGSClass.ws_url);

                ArrayList<PropertyInfo> pParms = new ArrayList<>();

                PropertyInfo parm = new PropertyInfo();
                parm.setName("pSQL_Command");
                parm.setValue(sql);
                parm.setType(String.class);

                pParms.add(parm);

                sJson = dba.SendHttpMessage("GetSQLData", pParms);
            }
        };
        wkThd_dbQuery.start();   //스레드 시작
        try {
            wkThd_dbQuery.join();  //workingThread가 종료될때까지 Main 쓰레드를 정지함.

        } catch (InterruptedException ex) {

        }
    }

    //리스트 데이터 조회
    private void dbSave(String Datetime) {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M41_SET_ANDROID ";
                sql += " @CUD_FLAG     ='C',";//현재 공장 코드 번호
                sql += " @CODE	       ='" + vItem.CODE + "',";
                sql += " @AREA_DENSITY ='" + vItem.AREA_DENSITY + "',";
                sql += " @LOT_NO	   ='" + vItem.LOT_NO + "',";
                sql += " @ROLL_NO      ='" + vItem.ROLL_NO + "',";
                sql += " @WIDTH		   ='" + vItem.WIDTH + "',";
                sql += " @LENGTH       ='" + vItem.LENGTH + "',";
                sql += " @QR_VALUE_ALL ='" + vItem.QR_VALUE_ALL + "',";
                sql += " @FR_DT        ='" + Datetime +"',";
                sql += " @STATUS       ='R',";
                sql += " @USER_ID      = '" + vUSER_ID + "'";

                DBAccess dba = new DBAccess(TGSClass.ws_name_space, TGSClass.ws_url);

                ArrayList<PropertyInfo> pParms = new ArrayList<>();

                PropertyInfo parm = new PropertyInfo();
                parm.setName("pSQL_Command");
                parm.setValue(sql);
                parm.setType(String.class);

                pParms.add(parm);

                sJson = dba.SendHttpMessage("GetSQLData", pParms);
            }
        };
        wkThd_dbQuery.start();   //스레드 시작
        try {

            wkThd_dbQuery.join();  //workingThread가 종료될때까지 Main 쓰레드를 정지함.
        } catch (InterruptedException ex) {

        }
    }


    private void Scan_QR(){
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        try {
            dataSaveLog("입고 스캔","Resling");
            dataSaveLog(tx_QR_Code,"Resling");

            vItem = new M40_DTL();
            vItem.QR_VALUE_ALL = tx_QR_Code;

            String splited[] = vItem.QR_VALUE_ALL.split("%");
            vItem.CODE = splited[2].substring(1);
            vItem.AREA_DENSITY = vItem.CODE.substring(2,6);
            vItem.WIDTH = vItem.CODE.substring(6,10);

            vItem.LOT_NO = splited[3].substring(1,9);
            vItem.ROLL_NO = splited[3].substring(12,15);
            vItem.LENGTH = splited[7].substring(1);

            vItem.setSTATUS("R");

            dbSave("");

            String err ="";
            String err_name="";

            if (!sJson.equals("") && sJson.contains("ERR")) {
                JSONArray ja = new JSONArray(sJson);
                JSONObject jObject = ja.getJSONObject(0);
                err = jObject.getString("ERR");
                err_name = jObject.getString("ERR_NAME");
            }
            //일반오류
            if(err.equals("")){
                dataSaveLog("입고 오류(코드없음)","Resling");
                dataSaveLog(tx_QR_Code,"Resling");

                tx_QR_Code="";

                SetSaveTempData(vItem.QR_VALUE_ALL,"M41");

                TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오",5000);
                return;
            }
            else if (err.equals("TRUE")) {
                dataSaveLog("입고 성공","Resling");
                TGSClass.AlertMessage(getApplicationContext(),  err_name);

/*                int NO = ListViewAdapter.getCount()+1;


                M40_DTL item = new M40_DTL();
                item.setNO              (NO);
                item.setCODE            ( vItem.CODE);
                item.setAREA_DENSITY    (vItem.AREA_DENSITY);
                item.setLOT_NO          (vItem.LOT_NO);
                item.setROLL_NO         (vItem.ROLL_NO);
                item.setWIDTH           (vItem.WIDTH);
                item.setLENGTH          (vItem.LENGTH);
                item.setQR_VALUE_ALL    (vItem.QR_VALUE_ALL);
                item.setSTATUS          (vItem.STATUS);

                ListViewAdapter.addPkgItem(item);
                ListViewAdapter.notifyDataSetChanged();*/

                //저장못한 데이터 가져와서 처리
                SetTempQR();
            }
            //db오류
            else{
                dataSaveLog("입고 실패","Resling");
                dataSaveLog(err_name,"Resling");

                TGSClass.AlertMessage(getApplicationContext(), err_name,5000);

            }
            tx_QR_Code = vItem.LOT_NO;

        }
        catch (Exception e){
            dataSaveLog("스캔오류","Resling");
            dataSaveLog(e.getMessage(),"Resling");


            TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오",5000);
            return;
        }

    }


    private void SetTempQR(){
        List<String> stringList = GetTempData("M41");
        List<String[]> tempDatas = new ArrayList<>();

        for(String temp : stringList){

            String[] tempData = temp.split(" // ");
            tempDatas.add(tempData);
        }

        for(String[] temp : tempDatas){


            try{
                vItem = new M40_DTL();
                vItem.QR_VALUE_ALL = temp[1];

                String splited[] = vItem.QR_VALUE_ALL.split("%");
                vItem.CODE = splited[2].substring(1);
                vItem.AREA_DENSITY = vItem.CODE.substring(2,6);
                vItem.WIDTH = vItem.CODE.substring(6,10);

                vItem.LOT_NO = splited[3].substring(1,9);
                vItem.ROLL_NO = splited[3].substring(12,15);
                vItem.LENGTH = splited[7].substring(1);

                vItem.setSTATUS("R");

                //스캔한 당시 시간을 추가하여 저장
                dbSave(temp[0]);

                String err ="";
                String err_name="";



                //오류코드 추출
                if (!sJson.equals("") && sJson.contains("ERR")) {
                    JSONArray ja = new JSONArray(sJson);
                    JSONObject jObject = ja.getJSONObject(0);
                    err = jObject.getString("ERR");
                    err_name = jObject.getString("ERR_NAME");
                }

                //일반오류일 경우 다시 저장
                if(err.equals("")){

                    tx_QR_Code="";

                    //SetSaveTempData(vItem.QR_VALUE_ALL,"M41");

                    //TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오",5000);
                    return;
                }
               /* else if (err.equals("TRUE")) {

                    M40_DTL item = new M40_DTL();
                    item.setCODE            ( vItem.CODE);
                    item.setAREA_DENSITY    (vItem.AREA_DENSITY);
                    item.setLOT_NO          (vItem.LOT_NO);
                    item.setROLL_NO         (vItem.ROLL_NO);
                    item.setWIDTH           (vItem.WIDTH);
                    item.setLENGTH          (vItem.LENGTH);
                    item.setQR_VALUE_ALL    (vItem.QR_VALUE_ALL);
                    item.setSTATUS          (vItem.STATUS);

                    ListViewAdapter.addPkgItem(item);
                    ListViewAdapter.notifyDataSetChanged();
                }*/

            }
            catch (JSONException e){

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M41_DTL_REQUEST_CODE:

                default:
                    break;
            }
        }
    }


}