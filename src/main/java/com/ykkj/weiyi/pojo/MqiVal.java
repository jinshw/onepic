package com.ykkj.weiyi.pojo;

public class MqiVal {
    private String code;
    private String fx;
    private String mqi;
    private String qdzh;
    private String zdzh;
    private Double minVal;
    private Double maxVal;

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getMqi() {
        return mqi;
    }

    public void setMqi(String mqi) {
        this.mqi = mqi;
    }

    public String getQdzh() {
        return qdzh;
    }

    public void setQdzh(String qdzh) {
        this.qdzh = qdzh;
    }

    public String getZdzh() {
        return zdzh;
    }

    public void setZdzh(String zdzh) {
        this.zdzh = zdzh;
    }
}
