package com.ykkj.weiyi.pojo;

public class PmsQingdanJiliangMainWithBLOBs extends PmsQingdanJiliangMain {
    private String note;

    private String jsgs;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getJsgs() {
        return jsgs;
    }

    public void setJsgs(String jsgs) {
        this.jsgs = jsgs == null ? null : jsgs.trim();
    }
}