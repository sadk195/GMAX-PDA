package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class M51_DTL_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== m41 스캔 데이터 변수 ==//
    private M51_DTL vItem;

    //== View 선언(EditText) ==//
    private EditText QR_Code,work_fr_dt,work_to_dt;
    private String tx_QR_Code="";

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(Button) ==//
    private Button btn_end,btn_query;

    //== View 선언(ImageView) ==//
    private ImageView img_barcode;

    //== View 선언(CheckBox) ==//
    private CheckBox chk_custom;

    //== 날짜 관련 변수 선언 ==//
    private Calendar cal1, cal2;


    //== ActivityForResult 관련 변수 선언 ==//
    private final int M51_DTL_REQUEST_CODE = 0;

    //== ListView Adapter 선언 ==//
    M51_DTL_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m51_dtl);

        this.initializeView();

        this.initializeCalendar();

        this.initializeListener();

        this.initializeData();

    }

    private void initializeData() {

        start();
    }

    private void initializeCalendar() {
        cal1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal1.setTime(new Date());
        cal1.add(Calendar.DATE, -5);

        cal2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal2.setTime(new Date());

        work_fr_dt.setText(df.format(cal1.getTime()));
        work_to_dt.setText(df.format(cal2.getTime()));

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

        work_fr_dt    = (EditText) findViewById(R.id.work_fr_dt);
        work_to_dt = (EditText) findViewById(R.id.work_to_dt);

        btn_end    = (Button) findViewById(R.id.btn_end);
        chk_custom  = (CheckBox) findViewById(R.id.custom);
        img_barcode     = (ImageView) findViewById(R.id.img_barcode);


        //== Adapter 선언 ==//
        ListViewAdapter = new M51_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);


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
                Intent intent = TGSClass.ChangeView(getPackageName(), M52_DTL_Activity.class);
                startActivityForResult(intent, 0);
            }
        });
        //== 바코드 이벤트 ==//
        img_barcode.setOnClickListener(qrClickListener);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int cnt, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int cnt) {
                if (s.length() > 0) { //do your work here }
                    //start();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                start();
            }
        };
        work_fr_dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupDate(v, work_fr_dt, cal1);
            }
        });

        work_to_dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupDate(v, work_to_dt, cal2);
            }
        });
        work_fr_dt.addTextChangedListener(textWatcher);
        work_to_dt.addTextChangedListener(textWatcher);
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

                        dbSave();

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
                System.out.println("sJson:"+sJson);

                for (int idx = 0; idx <ja.length(); idx++) {
                    JSONObject jObject = ja.getJSONObject(idx);

                    M51_DTL item = new M51_DTL();
                   // item.setNO(idx+1);
                    item.setFABRIC           (jObject.getString("FABRIC"));
                    item.setFABRIC_NO           (jObject.getString("FABRIC_NO"));
                    item.setWIDTH           (jObject.getString("WIDTH"));
                    item.setLENGTH          (jObject.getString("LENGTH"));
                    item.setINSRT_DT        (jObject.getString("INSRT_DT"));

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

                String sql = "EXEC DBO.XUSP_BLANKET_M51_GET_ANDROID";
                sql += " @DT_FROM ='"+work_fr_dt.getText().toString()+"',";
                sql += " @DT_TO ='"+work_to_dt.getText().toString()+"',";
                sql += " @TYPE ='R'";

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
    private void dbSave() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M51_SET_ANDROID ";
                sql += " @QR	       ='" +tx_QR_Code + "',";
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





    /*private void SetTempQR(){
        List<String> stringList = GetTempData("M51");
        List<String[]> tempDatas = new ArrayList<>();

        for(String temp : stringList){

            String[] tempData = temp.split(" // ");
            tempDatas.add(tempData);
        }

        for(String[] temp : tempDatas){


            try{
                vItem = new M50_DTL();
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

                    //SetSaveTempData(vItem.QR_VALUE_ALL,"M51");

                    //TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오",5000);
                    return;
                }
               *//* else if (err.equals("TRUE")) {

                    M50_DTL item = new M50_DTL();
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
                }*//*

            }
            catch (JSONException e){

            }
        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M51_DTL_REQUEST_CODE:

                default:
                    break;
            }
        }
    }


}