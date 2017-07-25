package com.ykkj.weiyi.pojo;

import java.util.Date;

public class ScheduleResult {
    private String rtId;

    private String id;

    private String srId;

    private Date rtDate;
    
    private String dateStr;

    private Integer weekNum;

    private String startTime;

    private String endTime;

    private Integer numCount;

    private String otId;

    private String departId;

    private Integer numType;

    private String classTypeId;

    private String rtMonth;

    private Integer isStopClass;
    

	public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId == null ? null : rtId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSrId() {
        return srId;
    }

    public void setSrId(String srId) {
        this.srId = srId == null ? null : srId.trim();
    }

    public Date getRtDate() {
        return rtDate;
    }

    public void setRtDate(Date rtDate) {
        this.rtDate = rtDate;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getNumCount() {
        return numCount;
    }

    public void setNumCount(Integer numCount) {
        this.numCount = numCount;
    }

    public String getOtId() {
        return otId;
    }

    public void setOtId(String otId) {
        this.otId = otId == null ? null : otId.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public Integer getNumType() {
        return numType;
    }

    public void setNumType(Integer numType) {
        this.numType = numType;
    }

    public String getClassTypeId() {
        return classTypeId;
    }

    public void setClassTypeId(String classTypeId) {
        this.classTypeId = classTypeId == null ? null : classTypeId.trim();
    }

    public Integer getIsStopClass() {
        return isStopClass;
    }

    public void setIsStopClass(Integer isStopClass) {
        this.isStopClass = isStopClass;
    }

    public String getRtMonth() {
        return rtMonth;
    }

    public void setRtMonth(String rtMonth) {
        this.rtMonth = rtMonth;
    }

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}


    
    
}