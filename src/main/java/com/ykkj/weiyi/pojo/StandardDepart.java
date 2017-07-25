package com.ykkj.weiyi.pojo;

public class StandardDepart {
    private String sdId;

    private String sdName;

    private String sdCode;

    public String getSdId() {
        return sdId;
    }

    public void setSdId(String sdId) {
        this.sdId = sdId == null ? null : sdId.trim();
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
    }

    public String getSdCode() {
        return sdCode;
    }

    public void setSdCode(String sdCode) {
        this.sdCode = sdCode == null ? null : sdCode.trim();
    }
}