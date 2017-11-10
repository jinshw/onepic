package com.ykkj.weiyi.pojo;

public class DirectInfoWithBLOBs extends DirectInfo {
    private String context;

    private String memo;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}