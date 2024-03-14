package com.PDA.gmax.M50;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.PDA.gmax.BaseActivity;
import com.PDA.gmax.R;
import com.PDA.gmax.TGSClass;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class M50_Activity extends BaseActivity {

    //== Intent에서 받을 값 선언 ==//
    private String vMenuID, vMenuNm, vMenuRemark, vStartCommand;

    //== View 선언(Button) ==//
//    private Button btn_save, btn_query, btn_menu;
    MaterialToolbar materialToolbar;
    MaterialButton btn_m51, btn_m52, btn_m53,btn_m54,btn_m55;
//    ExtendedFloatingActionButton btn_menu;

    //== Grant 관련 변수 ==//
    private String ADMIN_CHK = "N", W_IN = "N", M51 = "N", M52 = "N", M53 = "N",M54 = "N",M55 = "N";     //Grant

    //== ActivityForResult 관련 변수 ==//
    private final int M51_DTL_REQUEST_CODE = 1, M52_DTL_REQUEST_CODE = 2
            , M53_DTL_REQUEST_CODE = 3,M54_DTL_REQUEST_CODE=4,M55_QUERY_REQUEST_CODE=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m50);

        this.initializeView();

        this.initializeListener();

        this.initializeData();
    }

    private void initializeView() {
        //== BaseActivity 에서 SESSION 값 셋팅 ==//
        this.init();

        //== Intent 값 바인딩 ==//
        vMenuID         = getIntent().getStringExtra("MENU_ID");
        vMenuNm         = getIntent().getStringExtra("MENU_NM");
        vMenuRemark     = getIntent().getStringExtra("MENU_REMARK");
        vStartCommand   = getIntent().getStringExtra("START_COMMAND"); //다음 페이지에 가지고 넘어갈 코드

        //== ID값 바인딩 ==//
        materialToolbar = findViewById(R.id.materialToolbar);

        btn_m51        = findViewById(R.id.btn_Rea_Stored);           // 1. 리즐링 원단 입고
        btn_m52        = findViewById(R.id.btn_US_Stored);            // 2. 미국수입 원단 투입
        btn_m53        = findViewById(R.id.btn_JS_Stored);            // 3. 일본수입 원단 투입
        btn_m54        = findViewById(R.id.btn_Fabric_Pro_Input);      // 4. 원단 투입
        btn_m55        = findViewById(R.id.btn_Fabric_Stock);          // 5. 재고현황

//        btn_menu        = findViewById(R.id.btn_menu);                             // 메뉴
    }

    private void initializeListener() {
        //== Click 이벤트 만들기 ==//
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btn_m51) {     // MAT원단 입고
                    if (start_grant("M51")) {
                        String sMenuName = "메뉴 > 원단관리 > 리즐링 원단 입고";

                        Intent intent = TGSClass.ChangeView(getPackageName(), M51_DTL_Activity.class);
                        intent.putExtra("MENU_ID", "M51");
                        intent.putExtra("MENU_NM", sMenuName);
                        intent.putExtra("MENU_REMARK", vMenuRemark);
                        intent.putExtra("START_COMMAND", vStartCommand);
                        startActivityForResult(intent, M51_DTL_REQUEST_CODE);
                    }
                } else if (v == btn_m52) {    // SEAL 원단 입고
                    if (start_grant("M52")) {
                        String sMenuName = "메뉴 > 원단 관리 > 미국 수입 원단 입고";

                        Intent intent = TGSClass.ChangeView(getPackageName(), M52_DTL_Activity.class);
                        intent.putExtra("MENU_ID", "M52");
                        intent.putExtra("MENU_NM", sMenuName);
                        intent.putExtra("MENU_REMARK", vMenuRemark);
                        intent.putExtra("START_COMMAND", vStartCommand);
                        startActivityForResult(intent, M52_DTL_REQUEST_CODE);
                    }
                }
                else if (v == btn_m53) {    // 원단 투입
                    if (start_grant("M53")) {
                        String sMenuName = "메뉴 > 원단 관리 > 일본 수입 원단 입고";

                        Intent intent = TGSClass.ChangeView(getPackageName(), M53_DTL_Activity.class);
                        intent.putExtra("MENU_ID", "M53");
                        intent.putExtra("MENU_NM", sMenuName);
                        intent.putExtra("MENU_REMARK", vMenuRemark);
                        intent.putExtra("START_COMMAND", vStartCommand);
                        startActivityForResult(intent, M53_DTL_REQUEST_CODE);
                    }
                }
                else if (v == btn_m54) {    // 재고현황
                    if (start_grant("M54")) {
                        String sMenuName = "메뉴 > 원단 관리 > 원단 투입";

                        Intent intent = TGSClass.ChangeView(getPackageName(), M54_HDR_Activity.class);
                        intent.putExtra("MENU_ID", "M54");
                        intent.putExtra("MENU_NM", sMenuName);
                        intent.putExtra("MENU_REMARK", vMenuRemark);
                        intent.putExtra("START_COMMAND", vStartCommand);
                        startActivityForResult(intent, M54_DTL_REQUEST_CODE);
                    }
                }
                else if (v == btn_m55) {    // 재고현황
                    if (start_grant("M55")) {
                        String sMenuName = "메뉴 > 원단 관리 > 재고현황";

                        Intent intent = TGSClass.ChangeView(getPackageName(), M55_QUERY_Activity.class);
                        intent.putExtra("MENU_ID", "M55");
                        intent.putExtra("MENU_NM", sMenuName);
                        intent.putExtra("MENU_REMARK", vMenuRemark);
                        intent.putExtra("START_COMMAND", vStartCommand);
                        startActivityForResult(intent, M55_QUERY_REQUEST_CODE);
                    }
                }

            }
        };
        btn_m51.setOnClickListener(clickListener);
        btn_m52.setOnClickListener(clickListener);
        btn_m53.setOnClickListener(clickListener);
        btn_m54.setOnClickListener(clickListener);
        btn_m55.setOnClickListener(clickListener);

//        btn_menu.setOnClickListener(clickListener);

        //== 이벤트 부여 ==//
        //== AppBar Navigation Icon Click Listener ==//
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getContentDescription().equals(materialToolbar.getNavigationContentDescription())) {
                    // 저장 후 결과 값 돌려주기
                    Intent resultIntent = new Intent();
                    // 부른 Activity에게 결과 값 반환
                    setResult(RESULT_CANCELED, resultIntent);
                    // 현재 Activity 종료
                    finish();
                }
            }
        });
    }

    private void initializeData() {
        getGrant(vUSER_ID);
    }

    private boolean start_grant(final String MenuID) {
        try {
            JSONArray ja = new JSONArray(sJson_grant);

            for (int idx = 0; idx < ja.length(); idx++) {
                JSONObject jObject = ja.getJSONObject(idx);

                final String LEVEL_CD = jObject.getString("LEVEL_CD");

                ADMIN_CHK = LEVEL_CD.equals("ADMIN") || ADMIN_CHK.equals("Y") ? "Y" : "N";
                W_IN = LEVEL_CD.equals("W_IN") || W_IN.equals("Y") ? "Y" : "N";
                M51 = LEVEL_CD.equals("M51") || M51.equals("Y") ? "Y" : "N";
                M52 = LEVEL_CD.equals("M52") || M52.equals("Y") ? "Y" : "N";
                M53 = LEVEL_CD.equals("M53") || M53.equals("Y") ? "Y" : "N";
                M54 = LEVEL_CD.equals("M54") || M54.equals("Y") ? "Y" : "N";
                M55 = LEVEL_CD.equals("M55") || M55.equals("Y") ? "Y" : "N";

            }

            if (ADMIN_CHK.equals("N") && W_IN.equals("N")) {
                if (MenuID.equals("M51") && M51.equals("N")) {
                    TGSClass.AlertMessage(getApplicationContext(), "리즐링 원단 입고 메뉴에 대한 접속 권한이 없습니다.");
                    return false;
                } else if (MenuID.equals("M52") && M52.equals("N")) {
                    TGSClass.AlertMessage(getApplicationContext(), "미국 수입 원단 입고 메뉴에 대한 접속 권한이 없습니다.");
                    return false;
                } else if (MenuID.equals("M53") && M53.equals("N")) {
                    TGSClass.AlertMessage(getApplicationContext(), "일본 수입 원단 입고 메뉴에 대한 접속 권한이 없습니다.");
                    return false;
                } else if (MenuID.equals("M54") && M54.equals("N")) {
                    TGSClass.AlertMessage(getApplicationContext(), "원단 투입 메뉴에 대한 접속 권한이 없습니다.");
                    return false;
                }else if (MenuID.equals("M55") && M55.equals("N")) {
                    TGSClass.AlertMessage(getApplicationContext(), "재고 현황 메뉴에 대한 접속 권한이 없습니다.");
                    return false;
                }
            }
            return true;
        } catch (JSONException exJson) {
            TGSClass.AlertMessage(getApplicationContext(), "catch : exJson");
            return false;
        } catch (Exception ex) {
            TGSClass.AlertMessage(getApplicationContext(), "catch : ex");
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case M51_DTL_REQUEST_CODE:
                    //Log.d("OK", "M11_HDR");
                    break;
                case M52_DTL_REQUEST_CODE:
                    //Log.d("OK", "M12_QUERY");
                    break;
                case M53_DTL_REQUEST_CODE:
                    //Log.d("OK", "M12_QUERY");
                    break;
                case M54_DTL_REQUEST_CODE:
                    //Log.d("OK", "M12_QUERY");
                    break;
                case M55_QUERY_REQUEST_CODE:
                    //Log.d("OK", "M12_QUERY");
                    break;
                default:
                    break;
            }
        } else if (resultCode == RESULT_CANCELED) {
            switch (requestCode) {
                case M51_DTL_REQUEST_CODE:
                    //Log.d("CANCELED", "M11_HDR");
                    break;
                case M52_DTL_REQUEST_CODE:
                    //Log.d("CANCELED", "M12_QUERY");
                    break;
                case M53_DTL_REQUEST_CODE:
                    //Log.d("CANCELED", "M12_QUERY");
                    break;
                case M54_DTL_REQUEST_CODE:
                    //Log.d("CANCELED", "M12_QUERY");
                    break;
                case M55_QUERY_REQUEST_CODE:
                    //Log.d("CANCELED", "M12_QUERY");
                    break;

                default:
                    break;
            }
        }
    }
}
