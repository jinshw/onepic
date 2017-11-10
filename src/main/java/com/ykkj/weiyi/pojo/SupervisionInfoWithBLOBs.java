package com.ykkj.weiyi.pojo;

public class SupervisionInfoWithBLOBs extends SupervisionInfo {
    private String supervisionMemo;

    private String dwyjgk;

    public String getSupervisionMemo() {
        return supervisionMemo;
    }

    public void setSupervisionMemo(String supervisionMemo) {
        this.supervisionMemo = supervisionMemo == null ? null : supervisionMemo.trim();
    }

    public String getDwyjgk() {
        return dwyjgk;
    }

    public void setDwyjgk(String dwyjgk) {
        this.dwyjgk = dwyjgk == null ? null : dwyjgk.trim();
    }
}