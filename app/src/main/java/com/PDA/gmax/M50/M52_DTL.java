package com.PDA.gmax.M50;

import java.io.Serializable;

public class M52_DTL implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.

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

    public int NO;
    public String ITEM_NM;
    public String LENGTH;
    public String INPUT_DT;
    public boolean CHK = false;

    public String getNO(){return String.valueOf(NO);}

    public void setNO(int no ) { NO = no; }

    public String getITEM_NM(){return ITEM_NM;}

    public void setITEM_NM(String item_nm ) { ITEM_NM = item_nm; }

    public String getINPUT_DT(){return INPUT_DT;}

    public void setINPUT_DT(String input_dt ) { INPUT_DT = input_dt; }

    public String getLENGTH(){return LENGTH;}

    public void setLENGTH(String length) { LENGTH = length;}

    public boolean getCHK() { return CHK;}

    public void setCHK(boolean chk) { CHK = chk; }







}



