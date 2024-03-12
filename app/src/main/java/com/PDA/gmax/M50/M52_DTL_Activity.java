package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText fabric_nm ,bcd_length, txt_width,bcd_run_no,txt_batch_no,work_fr_dt,work_to_dt;;

    //== View 선언(Button) ==//
    private Button btn_end,btn_save;

    private String tx_length="",tx_run_no="",tx_fabric_nm="";

    //== View 선언(ListView) ==//
    private ListView listview;


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

        fabric_nm       = (EditText) findViewById(R.id.fabric_nm);
        bcd_length      = (EditText) findViewById(R.id.bcd_length);
        txt_width       = (EditText) findViewById(R.id.txt_width);
        bcd_run_no      = (EditText) findViewById(R.id.bcd_run_no);
        txt_batch_no    = (EditText) findViewById(R.id.txt_batch_no);;

        work_fr_dt      = (EditText) findViewById(R.id.work_fr_dt);
        work_to_dt      = (EditText) findViewById(R.id.work_to_dt);

        btn_end         = (Button) findViewById(R.id.btn_end);
        btn_save        = (Button) findViewById(R.id.btn_save);


        listview    = (ListView) findViewById(R.id.listStored);

        //== Adapter 선언 ==//
        ListViewAdapter = new M52_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

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

        btn_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dbSave();
            }
        });

        fabric_nm.setOnKeyListener(new View.OnKeyListener() {@Override
           public boolean onKey(View v, int keyCode, KeyEvent event) {
               if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {

                   try{
                       //바코드 입력시 텍스트 리프레시를 위해서 설정
                       String temp=fabric_nm.getText().toString().replaceFirst(tx_fabric_nm,"");
                       //temp="MD221104-001";
                       fabric_nm.setText(temp);
                       tx_length=fabric_nm.getText().toString();

                       return true;

                   }
                   catch(Exception e){
                       System.out.println("err:"+e.getMessage());
                       TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오");
                   }
                   return true;
               }

               return false;
           }
       }
        );
        bcd_length.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {

                    try{
                        //바코드 입력시 텍스트 리프레시를 위해서 설정
                        String temp=bcd_length.getText().toString().replaceFirst(tx_length,"");
                        //temp="MD221104-001";
                        bcd_length.setText(temp);
                        tx_length=bcd_length.getText().toString();

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

        bcd_run_no.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {

                    try{
                        //바코드 입력시 텍스트 리프레시를 위해서 설정
                        String temp=bcd_run_no.getText().toString().replaceFirst(tx_run_no,"");

                        //temp="MD221104-001";
                        bcd_run_no.setText(temp);
                        tx_run_no=bcd_run_no.getText().toString();

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
                    item.setFABRIC          (jObject.getString("FABRIC"));
                    item.setFABRIC_NO       (jObject.getString("FABRIC_NO"));
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
                sql += " @TYPE ='U'";

                System.out.println("sql:"+sql);
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

                String sql = "EXEC DBO.XUSP_BLANKET_M52_SET_ANDROID ";
                sql += " @SAP_ID	   ='" + fabric_nm.getText().toString() + "',";
                sql += " @LENGTH       ='" + bcd_length.getText().toString() + "',";
                sql += " @WIDTH		   ='" + txt_width.getText().toString() + "',";
                sql += " @RUN_NO       ='" + bcd_run_no.getText().toString() + "',";
                sql += " @BATCH_NO      ='" + txt_batch_no.getText().toString() + "',";
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

            //입고처리후 컨트롤 초기화
            fabric_nm.setText("");
            bcd_length.setText("");
            txt_width.setText("");
            bcd_run_no.setText("");
            txt_batch_no.setText("");
            tx_length="";
            tx_run_no="";
            tx_fabric_nm="";

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