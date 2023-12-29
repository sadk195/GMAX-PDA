package com.PDA.gmax.S10;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

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


public class S12_CPY_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;
    private String intent_req_no,intent_carton_no;

    //== S12_LOT와 주고 받을 변수 선언 ==//
    private ArrayList<S12_PKG> vItems;

    //== View 선언(Spinner) ==//
    private Spinner cpy_carton_no,cpy_req_no;

    private int selected_no = 0;

    //== View 선언(ListView) ==//
    private ListView listview;

    //== Spinner 관련 변수 선언 ==//
    private String str_dn_req_no="",str_carton_no = "";

    //== View 선언(Button) ==//
    private Button btn_end,btn_cpy;

    private EditText org_req_no,org_carton,cpy_bp_nm;


    //== ListView Adapter 선언 ==//
    S12_CPY_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s12_cpy);

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

        //== 값 바인딩 ==//
        intent_req_no     = getIntent().getStringExtra("REQ_NO");
        intent_carton_no  = getIntent().getStringExtra("CARTON_NO");
        vItems        = (ArrayList<S12_PKG>) getIntent().getSerializableExtra("Adapter");

        //== ID값 바인딩 ==//
        listview        = (ListView) findViewById(R.id.listPacking);

        cpy_req_no      = (Spinner) findViewById(R.id.cpy_req_no);
        //cpy_carton_no   = (Spinner) findViewById(R.id.cpy_carton_no);
        org_req_no      = (EditText) findViewById(R.id.org_req_no);
        org_carton      = (EditText) findViewById(R.id.org_carton);
        cpy_bp_nm       = (EditText) findViewById(R.id.cpy_bp_nm);


        btn_cpy         = (Button) findViewById(R.id.btn_cpy);
        btn_end         = (Button) findViewById(R.id.btn_end);

        //== Adapter 선언 ==//
        ListViewAdapter = new S12_CPY_ListViewAdapter();
    }

    private void initializeListener() {

        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                finish();
            }
        });

        btn_cpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check_Copy();
            }
        });

    }

    private void initializeData() {
        //공정 리스트 콤보 값을 초기화 한다.
        //dbQuery_getCartonCombo();
        dbQuery_getReqCombo();

        org_req_no.setText(intent_req_no);
        org_carton.setText(intent_carton_no);

        //req_no.setText(tx_req_no);
        for(S12_PKG item : vItems){
            ListViewAdapter.addShipmentPKGItem(item);
        }
        listview.setAdapter(ListViewAdapter);
        ListViewAdapter.notifyDataSetChanged();

    }


    //LOT번호 스캔하여 데이터 저장
    private void dbSave() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {
                String sql = " EXEC DBO.XUSP_MES_S2002PA2_COPY_CONT ";
                sql += " @PLANT_CD = '" + vPLANT_CD + "'";
                sql += " ,@DN_REQ_NO = '" + intent_req_no + "'";
                sql += " ,@COPY_REQ_NO = '" + str_dn_req_no + "'";
                sql += " ,@CONT_NO = '" + intent_carton_no + "'";
                sql += " ,@USER_ID = '" + vUSER_ID + "'";
                sql += ";";

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

            if (!sJson.equals("")) {
                try {
                    JSONArray ja = new JSONArray(sJson);
                    String jmessage ="";
                    for (int idx = 0; idx < ja.length(); idx++) {
                        JSONObject jObject = ja.getJSONObject(idx);

                        jmessage           = jObject.getString("Column1");         //품번
                    }

                    if(jmessage.contains("CONT_NO")){

                        jmessage = jmessage.replace("CONT_NO/","");
                        TGSClass.AlertMessage(getApplicationContext(), "출하요청 "+str_dn_req_no+"건의 "+jmessage+"번 Carton으로 이동 되었습니다.");
                        this.finish();
                    }
                    else{
                        TGSClass.AlertMessage(getApplicationContext(), jmessage);
                    }
                } catch (JSONException ex) {
                    //TGSClass.AlertMessage(this, ex.getMessage());
                } catch (Exception e1) {
                    TGSClass.AlertMessage(this, e1.getMessage(),5000);
                }
            }

        } catch (InterruptedException ex) {

        }
    }

    //spinner데이터 조회
    private void dbQuery_getCartonCombo() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery_getComboData = new Thread() {
            public void run() {
                String sql = "EXEC DBO.XUSP_MES_S2002PA2_COPY_LIST ";
                sql += "@PLANT_CD ='" + vPLANT_CD + "',";
                sql += "@DN_REQ_NO ='" + intent_req_no + "',";
                sql += "@CONT_NO ='"+intent_carton_no+"',"; //carton 번호 조회시 빈값으로 조회
                sql += "@USER_ID ='" + vUSER_ID + "'";
                sql += ";";

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
            GetComboData itemBase = new GetComboData();

            //첫번째 항목 빈값으로 처리하고 선택시 모든 데이터 표출되도록 표시
            //MINOR_NM에 SELECT 조건 저장

            GetComboData item = new GetComboData();
            item.setMINOR_CD("");
            item.setMINOR_NM("신규");
            item.setNUM(0);
            lstItem.add(item);

            for (int i = 0; i < ja.length(); i++) {

                //CartonCount++;

                JSONObject jObject = ja.getJSONObject(i);

                //final String vJOB_CD = jObject.getString("JOB_CD");
                final String vMINOR_CD  = jObject.getString("CODE");
                final String vMINOR_NM  = jObject.getString("NAME");

                item = new GetComboData();
                item.setMINOR_CD(vMINOR_CD);
                item.setMINOR_NM(vMINOR_NM);

                lstItem.add(item);
            }

            ArrayAdapter<GetComboData> adapter = new ArrayAdapter<GetComboData>(this, android.R.layout.simple_dropdown_item_1line, lstItem);

            cpy_carton_no.setAdapter(adapter);

            //로딩시 기본값 세팅
            cpy_carton_no.setSelection(adapter.getPosition(itemBase));
            //콤보박스 클릭 이벤트 정의
            cpy_carton_no.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    str_carton_no = ((GetComboData) parent.getSelectedItem()).getMINOR_CD();
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

    private void dbQuery_getReqCombo() {
        int CartonCount = 0;
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery_getComboData = new Thread() {
            public void run() {
                String sql = "EXEC DBO.XUSP_MES_S2002PA2_COPY_LIST ";
                sql += "@PLANT_CD ='" + vPLANT_CD + "',";
                sql += "@DN_REQ_NO ='" + intent_req_no + "',";
                sql += "@CONT_NO ='"+intent_carton_no+"',"; //carton 번호 조회시 빈값으로 조회
                sql += "@USER_ID ='" + vUSER_ID + "'";
                sql += ";";

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


            if(ja.length() == 0){
                TGSClass.AlertMessage(getApplicationContext(), "복사 가능한 출하요청이 없습니다.");
                this.finish();
            }

            final ArrayList<GetComboData> lstItem = new ArrayList<>();

            /*기본값 세팅*/
            GetComboData itemBase = new GetComboData();

            //첫번째 항목 빈값으로 처리하고 선택시 모든 데이터 표출되도록 표시
            //MINOR_NM에 SELECT 조건 저장

            GetComboData item = new GetComboData();
           /* item.setMINOR_CD("");
            item.setMINOR_NM("신규");
            item.setNUM(0);
            lstItem.add(item);*/

            for (int i = 0; i < ja.length(); i++) {

                CartonCount++;

                JSONObject jObject = ja.getJSONObject(i);

                //final String vJOB_CD = jObject.getString("JOB_CD");
                final String vMINOR_CD  = jObject.getString("CODE");
                final String vMINOR_NM  = jObject.getString("NAME");

                item = new GetComboData();
                item.setMINOR_CD(vMINOR_CD);
                item.setMINOR_NM(vMINOR_NM);

                lstItem.add(item);
            }
            cpy_req_no.setSelection(0);

            ArrayAdapter<GetComboData> adapter = new ArrayAdapter<GetComboData>(this, android.R.layout.simple_dropdown_item_1line, lstItem);

            cpy_req_no.setAdapter(adapter);

            //로딩시 기본값 세팅
            cpy_req_no.setSelection(adapter.getPosition(itemBase));
            //콤보박스 클릭 이벤트 정의
            cpy_req_no.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    str_dn_req_no = ((GetComboData) parent.getSelectedItem()).getMINOR_NM();
                    cpy_bp_nm.setText(((GetComboData) parent.getSelectedItem()).getMINOR_CD());
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

    //카톤 삭제시 확인메시지 표출
    private void Check_Copy() {
        new AlertDialog.Builder(this)
                .setTitle("carton삭제 확인")
                .setMessage("carton의 내용을 "+str_dn_req_no+"로 복사하시겠습니까?")
                .setIcon(android.R.drawable.ic_menu_save)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dbSave();

                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                })
                .show();
    }

}