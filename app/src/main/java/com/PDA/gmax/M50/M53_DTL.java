package com.PDA.gmax.M50;

import java.io.Serializable;

public class M53_DTL implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.

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

    private int NO;
    private String FABRIC;
    private String FABRIC_NO;

    private String WIDTH;
    private String LENGTH;
    private String INSRT_DT;

    public String getNO(){return String.valueOf(NO);}

    public void setNO(int no ) { NO = no; }

    public String getFABRIC(){return FABRIC;}

    public void setFABRIC(String fabric) { FABRIC = fabric; }

    public String getFABRIC_NO(){return FABRIC_NO;}

    public void setFABRIC_NO(String fabric_no) { FABRIC_NO = fabric_no; }

    public String getWIDTH(){return WIDTH;}

    public void setWIDTH(String width) { WIDTH = width; }

    public String getLENGTH(){return LENGTH;}

    public void setLENGTH(String length) { LENGTH = length;}

    public String getINSRT_DT(){return INSRT_DT;}

    public void setINSRT_DT(String insrt_dt) { INSRT_DT = insrt_dt;}






}



