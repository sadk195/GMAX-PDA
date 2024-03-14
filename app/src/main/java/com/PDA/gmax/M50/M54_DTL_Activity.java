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


public class M54_DTL_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== View 선언(EditText) ==//
    private EditText bcd_fabric_no,txt_wk_ord_no,txt_mat,txt_seal;
    private String txt_fabric_no="";

    //== View 선언(ListView) ==//
    private ListView listview;

    //== View 선언(Button) ==//
    private Button btn_end,btn_del;

    //== View 선언(ImageView) ==//
    private ImageView img_barcode;


    //== ActivityForResult 관련 변수 선언 ==//
    private final int M54_DTL_REQUEST_CODE = 0;

    private M54_HDR vGetHDRItem;

    private M54_DTL selDTL;

    //== ListView Adapter 선언 ==//
    M54_DTL_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m54_dtl);

        this.initializeView();

        this.initializeListener();

        this.initializeData();

    }

    private void initializeData() {
        txt_wk_ord_no.setText(vGetHDRItem.getWK_ORD_NO());
        txt_mat.setText(vGetHDRItem.getMAT());
        txt_seal.setText(vGetHDRItem.getSEAL());

        dbQuery();

    }

    private void initializeView() {
        //== BaseActivity 에서 SESSION 값 셋팅 ==//
        this.init();

        //== Intent에서 값 가져오기 ==//
        vMenuID         = getIntent().getStringExtra("MENU_ID");
        vMenuNm         = getIntent().getStringExtra("MENU_NM");
        vMenuRemark     = getIntent().getStringExtra("MENU_REMARK");
        vStartCommand   = getIntent().getStringExtra("START_COMMAND"); //다음 페이지에 가지고 넘어갈 코드

        //== HDR 값 바인딩 ==//
        vGetHDRItem = (M54_HDR) getIntent().getSerializableExtra("HDR");

        //== ID값 바인딩 ==//
        listview        = (ListView) findViewById(R.id.listOrder);
        img_barcode     = (ImageView) findViewById(R.id.img_barcode);

        bcd_fabric_no   = (EditText) findViewById(R.id.bcd_fabric_no);
        txt_wk_ord_no   = (EditText) findViewById(R.id.txt_wk_ord_no);
        txt_mat         = (EditText) findViewById(R.id.txt_mat);
        txt_seal        = (EditText) findViewById(R.id.txt_seal);

        btn_end         = (Button) findViewById(R.id.btn_end);
        btn_del         = (Button) findViewById(R.id.btn_del);
        //== Adapter 선언 ==//
        ListViewAdapter = new M54_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

    }

    private void initializeListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                System.out.println("selDTL:"+(M54_DTL) parent.getItemAtPosition(position));
                selDTL = (M54_DTL) parent.getItemAtPosition(position);
                System.out.println("selDTL2:"+selDTL);

            }
        });
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {finish();}
        });
        btn_del.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                System.out.println("selDTL3:"+selDTL);

                if(selDTL == null)
                {
                    TGSClass.AlertMessage(getApplicationContext(), "투입 취소할 원단을 선택해 주세요.");
                    return;
                }
                if(!selDTL.getSTATUS().contains("투입")){
                    TGSClass.AlertMessage(getApplicationContext(), "투입상태의 원단을 선택해주세요.");
                    return;
                }
                if(Double.valueOf(selDTL.getQTY())<1){
                    TGSClass.AlertMessage(getApplicationContext(), "투입 취소할 원단이 없습니다.");
                    return;
                }
                dbDelete(selDTL.getFABRIC_NM(), selDTL.getWIDTH(), selDTL.getLENGTH());
                TGSClass.AlertMessage(getApplicationContext(), "원단 투입이 취소되었습니다.");

                dbQuery();
            }
        });
        //== 바코드 이벤트 ==//
        img_barcode.setOnClickListener(qrClickListener);
        bcd_fabric_no.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {

                    try{
                        //바코드 입력시 텍스트 리프레시를 위해서 설정
                        String temp=bcd_fabric_no.getText().toString();//.replaceFirst(tx_QR_Code,"");
                        //temp="MD221104-001";
                        bcd_fabric_no.setText(temp);
                        txt_fabric_no=bcd_fabric_no.getText().toString();

                        //쿼리중복 방지(쓰레드 중복 방지)
                        if(!QueryOn){
                            return false;
                        }
                        QueryOn = false;
                        //중복방지 타이머 실행
                        SetTimerTask();

                        //바코드 분리
                        String[] barcode = txt_fabric_no.split("\\$");
                        String f_type = "";

                        if(barcode.length == 3){
                            //원단 mat, seal 판단
                            if(barcode[0].equals(txt_mat.getText().toString())){
                                f_type = "M";
                            }
                            else if(barcode[0].equals(txt_seal.getText().toString())){
                                f_type = "S";
                            }
                            else{
                                return false;
                            }
                            dbSave(barcode[0],barcode[1],barcode[2]);

                        }

                        bcd_fabric_no.setText("");
                        bcd_fabric_no.setSelection(bcd_fabric_no.getText().length());
                        dbQuery();
                        TGSClass.AlertMessage(getApplicationContext(), "원단이 투입되었습니다.");

                        return true;

                    }
                    catch(Exception e){
                        TGSClass.AlertMessage(getApplicationContext(), " 오류가 발생하였습니다 다시 스캔하여주십시오");
                    }

                    return true;
                }

                return false;
            }
        });
    }


    private void dbQuery() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {
                String sql = "EXEC DBO.XUSP_BLANKET_M54_DTL_GET_ANDROID";
                sql += " @WK_ORD_NO ='"+txt_wk_ord_no.getText().toString()+"'";

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
            if (!sJson.equals("")) {
                try {
                    JSONArray ja = new JSONArray(sJson);

                    ListViewAdapter.ClearItem();

                    for (int idx = 0; idx < ja.length(); idx++) {
                        JSONObject jObject = ja.getJSONObject(idx);

                        M54_DTL item = new M54_DTL();
                        item.setSTATUS(jObject.getString("STATUS"));            //지시번호
                        item.setFABRIC_NM(jObject.getString("FABRIC_NM"));      //품목
                        item.setQTY(jObject.getString("QTY"));                  //품명
                        item.setLENGTH(jObject.getString("LENGTH"));            //MAT
                        item.setWIDTH(jObject.getString("WIDTH"));              //SEAL


                        ListViewAdapter.addPkgItem(item);
                    }

                    listview.setAdapter(ListViewAdapter);

                } catch (JSONException ex) {
                    TGSClass.AlertMessage(this, ex.getMessage());
                } catch (Exception e1) {
                    TGSClass.AlertMessage(this, e1.getMessage());
                }
            }
        } catch (InterruptedException ex) {

        }
    }

    //리스트 데이터 조회
    private void dbSave(String fabric_nm,String width, String Length) {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M54_SET_ANDROID ";
                sql += " @CUD_FLAG          ='U',";//현재 공장 코드 번호
                sql += " @WK_ORD_NO         ='" + txt_wk_ord_no.getText() + "',";
                sql += " @WIDTH	            ='" + width + "',";
                sql += " @LENGTH		    ='" + Length + "',";
                sql += " @FABRIC_NM	        ='" + fabric_nm + "',";
                sql += " @USER_ID           ='" + vUSER_ID + "'";

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

        } catch (Exception e1) {
            TGSClass.AlertMessage(this, e1.getMessage());
        }
    }

    private void dbDelete(String fabric_nm,String width, String Length) {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M54_SET_ANDROID ";
                sql += " @CUD_FLAG          ='D',";//현재 공장 코드 번호
                sql += " @WK_ORD_NO         ='" + txt_wk_ord_no.getText() + "',";
                sql += " @WIDTH	            ='" + width + "',";
                sql += " @LENGTH		    ='" + Length + "',";
                sql += " @FABRIC_NM	        ='" + fabric_nm + "',";
                sql += " @USER_ID           ='" + vUSER_ID + "'";

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

        } catch (Exception e1) {
            TGSClass.AlertMessage(this, e1.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M54_DTL_REQUEST_CODE:

                default:
                    break;
            }
        }
    }
}