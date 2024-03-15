package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.PDA.gmax.BaseActivity;
import com.PDA.gmax.DBAccess;
import com.PDA.gmax.GetComboData;
import com.PDA.gmax.R;
import com.PDA.gmax.TGSClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;


public class M55_QUERY_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== View 선언(EditText) ==//
    private EditText edt_length,edt_width;

    private Spinner fabric_nm;

    //== Spinner 관련 변수 선언 ==//
    private String str_fabric_nm = "";


    //== Spinner 관련 변수 선언 ==//
    private int selected_no = -1;

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(Button) ==//
    private Button btn_open,btn_hide,btn_query,btn_end;

    //== View 선언(DrawerLayout) ==//
    private DrawerLayout DrawerView;

    //== ActivityForResult 관련 변수 선언 ==//
    private final int M54_QUERY_REQUEST_CODE = 0;

    private CheckBox slit_item;

    //== ListView Adapter 선언 ==//
    M55_QUERY_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m55_query);

        this.initializeView();


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
        edt_length      = (EditText) findViewById(R.id.length);
        edt_width       = (EditText) findViewById(R.id.width);


        fabric_nm       = (Spinner) findViewById(R.id.fabric_nm);

        listview         = (ListView) findViewById(R.id.listOrder);
        btn_hide         = (Button) findViewById(R.id.btn_hide);
        btn_open         = (Button) findViewById(R.id.btn_open);
        btn_query        = (Button) findViewById(R.id.btn_query);

        slit_item        = (CheckBox) findViewById(R.id.slit_item);

        DrawerView       = (DrawerLayout) findViewById(R.id.drawer);

        btn_end          = (Button) findViewById(R.id.btn_end);
        //== Adapter 선언 ==//
        ListViewAdapter = new M55_QUERY_ListViewAdapter();
    }

    private void initializeListener() {
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

              finish();
            }
        });
        slit_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              start();
            }
        });
        btn_query.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        btn_open.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerView.openDrawer(Gravity.LEFT);
            }
        });
        btn_hide.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerView.closeDrawer(Gravity.LEFT);
            }
        });

    }

    private void initializeData(){
        dbQuery_getComboData();
        start();
    }

    //액티비티 시작,데이터 조회
    private void start() {
        if(slit_item.isChecked())
        {
            dbQuery("Y");
        }
        else{
            dbQuery("N");
        }

        if (!sJson.equals("")) {
            try {
                JSONArray ja = new JSONArray(sJson);

                // 빈 데이터 리스트 생성.
                ListViewAdapter.ClearItem();

                for (int idx = 0; idx < ja.length(); idx++) {

                    JSONObject jObject = ja.getJSONObject(idx);

                    M55_QUERY item = new M55_QUERY();
                    item.setFABRIC_NM       (jObject.getString("FABRIC_NM"));
                    item.setTYPE            (jObject.getString("TYPE"));
                    item.setWIDTH           (jObject.getString("WIDTH"));
                    item.setLENGTH          (jObject.getString("LENGTH"));
                    item.setQTY             (jObject.getString("QTY"));

                    ListViewAdapter.addPkgItem(item);
                }
                listview.setAdapter(ListViewAdapter);
                ListViewAdapter.notifyDataSetChanged();

                TGSClass.AlertMessage(getApplicationContext(), ja.length() + " 건 조회되었습니다.");

            } catch (JSONException ex) {
                TGSClass.AlertMessage(this, ex.getMessage());

            } catch (Exception e1) {
                TGSClass.AlertMessage(this, e1.getMessage());

            }
        }
    }

    //리스트 데이터 조회
    private void dbQuery(String slit_flag) {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M55_GET_ANDROID";
                sql += " @SLIT_FLAG ='"+slit_flag+"',";//원단 넓이
                sql += " @FABRIC_NM ='"+str_fabric_nm+"',";//원단 넓이
                sql += " @WIDTH ='"+edt_width.getText().toString()+"',";//원단 넓이
                sql += " @LENGTH ='"+edt_length.getText().toString()+"'";//원단 길이

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

    private void dbQuery_getComboData() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery_getComboData = new Thread() {
            public void run() {
                String sql = "EXEC DBO.XUSP_BLANKET_M55_GET_COMBODATA ";

                DBAccess dba = new DBAccess(TGSClass.ws_name_space, TGSClass.ws_url);

                ArrayList<PropertyInfo> pParms = new ArrayList<>();

                PropertyInfo parm = new PropertyInfo();
                parm.setName("pSQL_Command");
                parm.setValue(sql);
                parm.setType(String.class);

                pParms.add(parm);

                sJsonCombo = dba.SendHttpMessage("GetSQLData", pParms);
            }
        };
        wkThd_dbQuery_getComboData.start();   //스레드 시작
        try {
            wkThd_dbQuery_getComboData.join();  //workingThread가 종료될때까지 Main 쓰레드를 정지함.

        } catch (InterruptedException ex) {
            TGSClass.AlertMessage(getApplicationContext(), ex.getMessage());
        }

        try {
            JSONArray ja = new JSONArray(sJsonCombo);

            final ArrayList<GetComboData> lstItem = new ArrayList<>();

            /*기본값 세팅*/
            //GetComboData itemBase = new GetComboData();

            //첫번째 항목 빈값으로 처리하고 선택시 모든 데이터 표출되도록 표시
            //MINOR_NM에 SELECT 조건 저장

            GetComboData item = new GetComboData();
            item.setMINOR_CD("");
            item.setMINOR_NM("");
            item.setNUM(0);
            lstItem.add(item);

            for (int i = 0; i < ja.length(); i++) {

                JSONObject jObject = ja.getJSONObject(i);

                //final String vJOB_CD = jObject.getString("JOB_CD");
                final String vMINOR_CD  = jObject.getString("FABRIC_NM");
                final String vMINOR_NM  = jObject.getString("FABRIC_NM");

                item = new GetComboData();
                item.setMINOR_CD(vMINOR_CD);
                item.setMINOR_NM(vMINOR_NM);
                item.setNUM(i+1);
                lstItem.add(item);
            }

            ArrayAdapter<GetComboData> adapter = new ArrayAdapter<GetComboData>(this, android.R.layout.simple_dropdown_item_1line, lstItem);

            fabric_nm.setAdapter(adapter);

            //콤보박스 클릭 이벤트 정의
            fabric_nm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    str_fabric_nm = ((GetComboData) parent.getSelectedItem()).getMINOR_CD();
                    selected_no = ((GetComboData) parent.getSelectedItem()).getNUM();

                    start();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        } catch (JSONException ex) {
            TGSClass.AlertMessage(getApplicationContext(), ex.getMessage());
        } catch (Exception ex) {
            TGSClass.AlertMessage(getApplicationContext(), ex.getMessage());
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M54_QUERY_REQUEST_CODE:
                default:
                    break;
            }
        }
    }


}