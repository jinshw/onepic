package com.ykkj.weiyi.pojo;

import java.util.Date;

public class JdpzInfo {
    private String id;

    private String zbCode;

    private Long zbYear;

    private String parentCode;

    private String zbName;

    private String zbUnit;

    private String zbPrice;

    private Long zbType;

    private Date inserttime;

    private Date creattime;

    private String jbyq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getZbCode() {
        return zbCode;
    }

    public void setZbCode(String zbCode) {
        this.zbCode = zbCode == null ? null : zbCode.trim();
    }

    public Long getZbYear() {
        return zbYear;
    }

    public void setZbYear(Long zbYear) {
        this.zbYear = zbYear;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getZbName() {
        return zbName;
    }

    public void setZbName(String zbName) {
        this.zbName = zbName == null ? null : zbName.trim();
    }

    public String getZbUnit() {
        return zbUnit;
    }

    public void setZbUnit(String zbUnit) {
        this.zbUnit = zbUnit == null ? null : zbUnit.trim();
    }

    public String getZbPrice() {
        return zbPrice;
    }

    public void setZbPrice(String zbPrice) {
        this.zbPrice = zbPrice == null ? null : zbPrice.trim();
    }

    public Long getZbType() {
        return zbType;
    }

    public void setZbType(Long zbType) {
        this.zbType = zbType;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getJbyq() {
        return jbyq;
    }

    public void setJbyq(String jbyq) {
        this.jbyq = jbyq == null ? null : jbyq.trim();
    }
}