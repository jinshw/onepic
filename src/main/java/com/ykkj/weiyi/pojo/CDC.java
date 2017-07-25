package com.ykkj.weiyi.pojo;

public class CDC {

    private String cdcId;

    private String cdcName;

    private String cdcAddress;

    private Integer cdcNum;

    private String cdcMobile;

    private String cdcImg;

    /**
     * 扩展字段
     **/
    // 已经预约数量
    private Integer overnum;
    //可以预约字段
    private Integer activenum;

    public Integer getOvernum() {
        return overnum;
    }

    public String getCdcImg() {
        return cdcImg;
    }

    public void setCdcImg(String cdcImg) {
        this.cdcImg = cdcImg;
    }

    public void setOvernum(Integer overnum) {
        this.overnum = overnum;
    }

    public Integer getActivenum() {
        return activenum;
    }

    public void setActivenum(Integer activenum) {
        this.activenum = activenum;
    }

    public String getCdcMobile() {
        return cdcMobile;
    }

    public void setCdcMobile(String cdcMobile) {
        this.cdcMobile = cdcMobile;
    }

    public String getCdcId() {
        return cdcId;
    }

    public void setCdcId(String cdcId) {
        this.cdcId = cdcId;
    }

    public String getCdcName() {
        return cdcName;
    }

    public void setCdcName(String cdcName) {
        this.cdcName = cdcName;
    }

    public String getCdcAddress() {
        return cdcAddress;
    }

    public void setCdcAddress(String cdcAddress) {
        this.cdcAddress = cdcAddress;
    }

    public Integer getCdcNum() {
        return cdcNum;
    }

    public void setCdcNum(Integer cdcNum) {
        this.cdcNum = cdcNum;
    }


}
