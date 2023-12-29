package com.PDA.gmax;

public class GetComboData {
    private int NUM;
    private String MINOR_CD;
    private String MINOR_NM;
    private String UVN_MINOR_NM; //여러개 값을 보여줄때 MINOR_NM에 코드와 NM을 붙여서 표시하고 실제 NM은 이 값에 설정

    private String CHOICE;

    public int getNUM() {
        return NUM;
    }

    public void setNUM(int num) {
        this.NUM = num;
    }

    public String getMINOR_CD() {
        return MINOR_CD;
    }

    public void setMINOR_CD(String minor_cd) {
        this.MINOR_CD = minor_cd;
    }

    public String getMINOR_NM() {
        return MINOR_NM;
    }

    public void setMINOR_NM(String minor_nm) {
        this.MINOR_NM = minor_nm;
    }

    public String getUVN_MINOR_NM() {
        return UVN_MINOR_NM;
    }

    public void setUVN_MINOR_NM(String minor_nm) {
        this.UVN_MINOR_NM = minor_nm;
    }

    public String getCHOICE() {
        return CHOICE;
    }

    public void setCHOICE(String choice) {
        this.CHOICE = choice;
    }

    @Override
    /* Spinner 위젯에서 보여줄 값 세팅*/
    public String toString() {
        return MINOR_NM;
    }

}
