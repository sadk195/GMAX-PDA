package com.PDA.gmax.M50;

import java.io.Serializable;

public class M54_DTL implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.


    private String STATUS;
    private String QTY;
    private String FABRIC_NM;
    private String WIDTH;
    private String LENGTH;
    private boolean CHK = false;


    public String getSTATUS(){return STATUS;}

    public void setSTATUS(String status) { STATUS = status; }
    public String getFABRIC_NM(){return FABRIC_NM;}

    public void setFABRIC_NM(String fabric_nm) { FABRIC_NM = fabric_nm; }

    public String getQTY(){return QTY;}
    public void setQTY(String qty) { QTY = qty;}
    public String getWIDTH(){return WIDTH;}

    public void setWIDTH(String width) { WIDTH = width; }

    public String getLENGTH(){return LENGTH;}

    public void setLENGTH(String length) { LENGTH = length;}








}



