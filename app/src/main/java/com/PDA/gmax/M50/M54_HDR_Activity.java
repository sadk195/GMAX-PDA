package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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


public class M54_HDR_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== M42 스캔 데이터 변수 ==//
    private M54_DTL vItem;

    //== View 선언(EditText) ==//
    private EditText work_fr_dt,work_to_dt;
    private String tx_QR_Code="";

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(Button) ==//
    private Button btn_end;

    //== View 선언(ImageView) ==//
    private ImageView img_barcode;

    //== View 선언(CheckBox) ==//
    private CheckBox chk_custom;

    //== ActivityForResult 관련 변수 선언 ==//
    private final int M54_HDR_REQUEST_CODE = 0;


    //== 날짜 관련 변수 선언 ==//
    private Calendar cal1, cal2;


    //== ListView Adapter 선언 ==//
    M54_HDR_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m54_hdr);

        this.initializeView();

        this.initializeCalendar();

        this.initializeListener();

        this.initializeData();

    }

    private void initializeData() {
       start();
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
        work_fr_dt     = (EditText) findViewById(R.id.work_fr_dt);
        work_to_dt     = (EditText) findViewById(R.id.work_to_dt);

        listview    = (ListView) findViewById(R.id.listOrder);
        btn_end    = (Button) findViewById(R.id.btn_end);

        //== Adapter 선언 ==//
        ListViewAdapter = new M54_HDR_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

    }

    private void initializeCalendar() {
        cal1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal1.setTime(new Date());
        cal1.add(Calendar.MONTH, -1);

        cal2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, 10);

        work_fr_dt.setText(df.format(cal1.getTime()));
        work_to_dt.setText(df.format(cal2.getTime()));
    }

    private void initializeListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                M54_HDR vItem = (M54_HDR) parent.getItemAtPosition(position);

                //Toast.makeText(P_OEM11_Activity.this ,vSelectItem,Toast.LENGTH_LONG).show();

                Intent intent = TGSClass.ChangeView(getPackageName(), M54_DTL_Activity.class);
                intent.putExtra("HDR", vItem);

                startActivityForResult(intent, 0);
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {finish();}
        });
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
        dbQuery();
        if (!sJson.equals("")) {
            try {
                JSONArray ja = new JSONArray(sJson);

                // 빈 데이터 리스트 생성.
                //final ArrayList<String> items = new ArrayList<String>();

                M54_HDR_ListViewAdapter ListViewAdapter = new M54_HDR_ListViewAdapter();

                for (int idx = 0; idx < ja.length(); idx++) {
                    JSONObject jObject = ja.getJSONObject(idx);

                    M54_HDR item = new M54_HDR();
                    item.setWK_ORD_NO(jObject.getString("WK_ORD_NO"));    //지시번호
                    item.setITEM_CD(jObject.getString("ITEM_CD"));        //품목
                    item.setITEM_NM(jObject.getString("ITEM_NM"));        //품명
                    item.setMAT(jObject.getString("MAT"));                //MAT
                    item.setSEAL(jObject.getString("SEAL"));              //SEAL
                    item.setH_CODE(jObject.getString("HCODE"));           //H-CODE
                    item.setQTY(jObject.getString("QTY"));                //수량

                    ListViewAdapter.addItem(item);
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
                String sql = "EXEC DBO.XUSP_BLANKET_M54_HDR_GET_ANDROID";
                sql += " @DT_FROM ='"+work_fr_dt.getText().toString()+"',";
                sql += " @DT_TO ='"+work_to_dt.getText().toString()+"'";

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
                case M54_HDR_REQUEST_CODE:

                default:
                    break;
            }
        }
    }
}