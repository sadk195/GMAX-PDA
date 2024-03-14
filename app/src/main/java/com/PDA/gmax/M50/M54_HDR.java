package com.PDA.gmax.M50;

import java.io.Serializable;

public class M54_HDR implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.

     /*
     * CODE
     * AREA_DENSITY	          //순번
     * LOT_NO	              //품번
     * ROLL_NO                //품명
     * WIDTH		           //규격
     * LENGTH                 //수량
     * QR_VALUE_ALL            //확인수량
     * STATUS                  //검사여부
     * */

    private String WK_ORD_NO;
    private String ITEM_CD;
    private String ITEM_NM;

    private String H_CODE;
    private String MAT;
    private String SEAL;

    private String QTY;


    public String getWK_ORD_NO(){return WK_ORD_NO;}

    public void setWK_ORD_NO(String wk_ord_no ) { WK_ORD_NO = wk_ord_no; }

    public String getITEM_CD(){return ITEM_CD;}

    public void setITEM_CD(String item_cd) { ITEM_CD = ITEM_NM; }

    public String getITEM_NM(){return ITEM_NM;}

    public void setITEM_NM(String item_nm) { ITEM_NM = item_nm; }


    public String getMAT(){return MAT;}

    public void setMAT(String mat) { MAT = mat; }

    public String getSEAL(){return SEAL;}

    public void setSEAL(String seal) { SEAL = seal; }

    public String getH_CODE(){return H_CODE;}

    public void setH_CODE(String h_CODE) { H_CODE = h_CODE; }

    public String getQTY(){return QTY;}

    public void setQTY(String qty) { QTY = qty;}








}



