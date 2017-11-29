package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DirectInfo {
    private String id;

    private String projectId;

    private String directNo;

    private String sysDeptId;

    private String shortName;

    private String directAdd;

    private String directTel;

    private Date beginDate;

    private Date endDate;

    private Integer duration;

    private BigDecimal projectMoney;

    private String projectAdd;

    private String leader;

    private String leaderTel;

    private String uploadId;

    private BigDecimal propertyA;

    private String propertyB;

    private String propertyC;

    private Integer sortorder;

    private Integer roleType;

    private Date createtime;

    private Date inserttime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getDirectNo() {
        return directNo;
    }

    public void setDirectNo(String directNo) {
        this.directNo = directNo == null ? null : directNo.trim();
    }

    public String getSysDeptId() {
        return sysDeptId;
    }

    public void setSysDeptId(String sysDeptId) {
        this.sysDeptId = sysDeptId == null ? null : sysDeptId.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getDirectAdd() {
        return directAdd;
    }

    public void setDirectAdd(String directAdd) {
        this.directAdd = directAdd == null ? null : directAdd.trim();
    }

    public String getDirectTel() {
        return directTel;
    }

    public void setDirectTel(String directTel) {
        this.directTel = directTel == null ? null : directTel.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BigDecimal getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(BigDecimal projectMoney) {
        this.projectMoney = projectMoney;
    }

    public String getProjectAdd() {
        return projectAdd;
    }

    public void setProjectAdd(String projectAdd) {
        this.projectAdd = projectAdd == null ? null : projectAdd.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel == null ? null : leaderTel.trim();
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId == null ? null : uploadId.trim();
    }

    public BigDecimal getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(BigDecimal propertyA) {
        this.propertyA = propertyA;
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

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}