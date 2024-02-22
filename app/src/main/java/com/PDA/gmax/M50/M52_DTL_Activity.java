package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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


public class M52_DTL_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== m41 스캔 데이터 변수 ==//
    private M52_DTL vItem;

    //== View 선언(EditText) ==//
    private EditText QR_Code ,con_dt_fr, con_dt_to,edtItemCD;

    //== View 선언(Button) ==//
    private Button btn_end;

    private String tx_QR_Code="";

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(ImageView) ==//
    private ImageView img_barcode;

    //== ActivityForResult 관련 변수 선언 ==//
    private final int M52_DTL_REQUEST_CODE = 0;

    //== ListView Adapter 선언 ==//
    M52_DTL_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    //== 날짜 관련 변수 선언 ==//
    private Calendar cal1, cal2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m52_dtl);

        this.initializeView();

        this.initializeCalendar();

        this.initializeListener();

        this.initializeData();

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
        con_dt_fr       = (EditText) findViewById(R.id.con_dt_fr);
        con_dt_to       = (EditText) findViewById(R.id.con_dt_to);

        listview    = (ListView) findViewById(R.id.listPacking);

        img_barcode     = (ImageView) findViewById(R.id.img_barcode);

        //== Adapter 선언 ==//
        ListViewAdapter = new M52_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

    }

    private void initializeData() {

        con_dt_fr.setText(df.format(cal1.getTime()));
        con_dt_to.setText(df.format(cal2.getTime()));

        start();
    }


    private void initializeCalendar() {
        cal1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal1.setTime(new Date());
        cal1.add(Calendar.MONTH, -1);

        cal2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal2.setTime(new Date());
    }



    private void initializeListener() {

        con_dt_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupDate(v, con_dt_fr, cal1);
            }
        });

        con_dt_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupDate(v, con_dt_to, cal2);
            }
        });

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

                        dbSave(tx_QR_Code);

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

                    M52_DTL item = new M52_DTL();
                    item.setNO(idx+1);
                    item.setITEM_NM            (jObject.getString("ITEM_NM"));
                    item.setLENGTH          (jObject.getString("LENGTH"));
                    item.setINPUT_DT        (jObject.getString("INPUT_DT"));

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

                String sql = "EXEC DBO.XUSP_FABRIC_M52_GET_ANDROID";
                sql += " @DT_FR ='"+con_dt_fr.getText()+"',";//원단 넓이
                sql += " @DT_TO ='"+con_dt_to.getText()+"'";//원단 넓이


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
    private void dbSave(String lot_no) {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_FABRIC_M52_SET_ANDROID ";
                sql += " @CUD_FLAG     ='C',";//현재 공장 코드 번호
                sql += " @LOT_NO	   ='" + lot_no + "',";
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M52_DTL_REQUEST_CODE:

                default:
                    break;
            }
        }
    }


}