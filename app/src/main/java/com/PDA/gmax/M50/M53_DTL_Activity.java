package com.PDA.gmax.M50;

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

import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;


public class M53_DTL_Activity extends BaseActivity {

    //== JSON 선언 ==//
    private String sJson = "",lJson = "", sJsonConfigSet = "", sJsonCombo = "";

    //== Intent에서 받을 변수 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== M42 스캔 데이터 변수 ==//
    private M53_DTL vItem;

    //== View 선언(EditText) ==//
    private EditText QR_Code;
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
    private final int M42_DTL_REQUEST_CODE = 0;
    int vIdx=-1;

    //== ListView Adapter 선언 ==//
    M53_DTL_ListViewAdapter ListViewAdapter; //데이터를 완전히 초기화 하는것이 아니라 수정처리 하기때문에 전역 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m42_dtl);

        this.initializeView();

        this.initializeListener();

        this.initializeData();

    }

    private void initializeData() {
       //start();
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
        QR_Code     = (EditText) findViewById(R.id.QR_Code);
        listview    = (ListView) findViewById(R.id.listPacking);
        img_barcode     = (ImageView) findViewById(R.id.img_barcode);

        btn_end    = (Button) findViewById(R.id.btn_end);
        chk_custom  = (CheckBox) findViewById(R.id.custom);

        //== Adapter 선언 ==//
        ListViewAdapter = new M53_DTL_ListViewAdapter();
        listview.setAdapter(ListViewAdapter);
        listview.setFocusable(false);

    }

    private void initializeListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                vIdx = position;
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {finish();}
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

                        dbSave();

                        QR_Code.setText("");
                        QR_Code.setSelection(QR_Code.getText().length());

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


    //리스트 데이터 조회
    private void dbSave() {
        ////////////////////////////// 웹 서비스 호출 시 쓰레드 사용 ////////////////////////////////////////////////////////
        Thread wkThd_dbQuery = new Thread() {
            public void run() {

                String sql = "EXEC DBO.XUSP_BLANKET_M41_SET_ANDROID ";
                sql += " @CUD_FLAG     ='U',";//현재 공장 코드 번호
                sql += " @FABRIC	       ='" + vItem.FABRIC + "',";
                sql += " @WIDTH		   ='" + vItem.WIDTH + "',";
                sql += " @LENGTH       ='" + vItem.LENGTH + "',";
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

        } catch (Exception e1) {
            TGSClass.AlertMessage(this, e1.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M42_DTL_REQUEST_CODE:

                default:
                    break;
            }
        }
    }
}