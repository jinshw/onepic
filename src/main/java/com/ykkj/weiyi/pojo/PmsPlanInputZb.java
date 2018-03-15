package com.ykkj.weiyi.pojo;

import java.util.Date;

public class PmsPlanInputZb {
    private String id;

    private String entityId;

    private String entityType;

    private Long year;

    private Long month;

    private Long isSuance;

    private String updatePeople;

    private Date updateTime;

    private String updateAction;

    private Long userType;

    private String propertyA;

    private String propertyB;

    private String propertyC;

    private Date realStartDate;

    private Date realEndDate;

    private Long isSueno;

    private String uploadId;

    private String submitMan;

    private Date submitTime;

    private String bpmStatus;

    private Date inserttime;

    private Date creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId == null ? null : entityId.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getIsSuance() {
        return isSuance;
    }

    public void setIsSuance(Long isSuance) {
        this.isSuance = isSuance;
    }

    public String getUpdatePeople() {
        return updatePeople;
    }

    public void setUpdatePeople(String updatePeople) {
        this.updatePeople = updatePeople == null ? null : updatePeople.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction == null ? null : updateAction.trim();
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public String getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(String propertyA) {
        this.propertyA = propertyA == null ? null : propertyA.trim();
    }

    public String getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(String propertyB) {
        this.propertyB = propertyB == null ? null : propertyB.trim();
    }

    public String getPropertyC() {
        return propertyC;
    }

    public void setPropertyC(String propertyC) {
        this.propertyC = propertyC == null ? null : propertyC.trim();
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public Long getIsSueno() {
        return isSueno;
    }

    public void setIsSueno(Long isSueno) {
        this.isSueno = isSueno;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId == null ? null : uploadId.trim();
    }

    public String getSubmitMan() {
        return submitMan;
    }

    public void setSubmitMan(String submitMan) {
        this.submitMan = submitMan == null ? null : submitMan.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getBpmStatus() {
        return bpmStatus;
    }

    public void setBpmStatus(String bpmStatus) {
        this.bpmStatus = bpmStatus == null ? null : bpmStatus.trim();
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
}