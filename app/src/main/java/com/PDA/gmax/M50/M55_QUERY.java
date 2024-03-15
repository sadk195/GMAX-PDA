package com.PDA.gmax.M50;

import java.io.Serializable;

public class M55_QUERY implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.

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

    private String FABRIC_NM;
    private String TYPE;
    private String WIDTH;
    private String LENGTH;
    private String QTY;


    public String getFABRIC_NM(){return FABRIC_NM;}

    public void setFABRIC_NM(String fabric_nm) { FABRIC_NM = fabric_nm;}

    public String getTYPE(){return TYPE;}

    public void setTYPE(String type) { TYPE = type;}

    public String getWIDTH(){return WIDTH;}

    public void setWIDTH(String width) { WIDTH = width;}

    public String getLENGTH(){return LENGTH;}

    public void setLENGTH(String length) { LENGTH = length;}

    public String getQTY(){return QTY;}

    public void setQTY(String qty) { QTY = qty;}








}








