package com.ykkj.weiyi.pojo;

import java.util.Date;

public class FamilyDoctor {
    private String familyDoctorId;

    private String id;

    private String scId;

    private String outId;

    private Integer status;

    private Integer isEffective;

    private Date endDate;

    private Date startDate;

    private Date createTime;

    private String patIdcard;

    private String remark;

    public String getFamilyDoctorId() {
        return familyDoctorId;
    }

    public void setFamilyDoctorId(String familyDoctorId) {
        this.familyDoctorId = familyDoctorId == null ? null : familyDoctorId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId == null ? null : scId.trim();
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId == null ? null : outId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPatIdcard() {
        return patIdcard;
    }

    public void setPatIdcard(String patIdcard) {
        this.patIdcard = patIdcard == null ? null : patIdcard.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}