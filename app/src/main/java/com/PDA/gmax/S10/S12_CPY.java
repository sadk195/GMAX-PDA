package com.PDA.gmax.S10;

import java.io.Serializable;

public class S12_CPY implements Serializable {   //Serializable 객체를 파라미터로 다른 ACTIVITY에 전달할때 필요함.

     /*
     * SHIP_TO_PARTY_NM
     * MOV_TYPE_NM
     * SO_TYPE_NM
     * PLANT_NM
     * DN_NO
     * */

    public String DN_REQ_NO;
    public String BP_NM;
    public String PROMISE_DT;


    public String getDN_REQ_NO() { return DN_REQ_NO;}

    public void setDN_REQ_NO(String dn_Req_No) { DN_REQ_NO = dn_Req_No; }

    public String getBP_NM() { return BP_NM; }

    public void setBP_NM(String bp_nm) { BP_NM = bp_nm; }

    public String getPROMISE_DT() { return PROMISE_DT; }

    public void setPROMISE_DT(String promise_dt) { PROMISE_DT = promise_dt; }


}
