package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PmsIssueInfo {
    private String id;

    private String issueNo;

    private String issueName;

    private Date beginDate;

    private Date endDate;

    private BigDecimal currentMoneyPlan;

    private Long isCurrent;

    private BigDecimal planPer;

    private String bpmStatus;

    private String bpmStatusBak;

    private String bpmNodeId;

    private Date inserttime;

    private Date createtime;

    private byte[] sectId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo == null ? null : issueNo.trim();
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName == null ? null : issueName.trim();
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

    public BigDecimal getCurrentMoneyPlan() {
        return currentMoneyPlan;
    }

    public void setCurrentMoneyPlan(BigDecimal currentMoneyPlan) {
        this.currentMoneyPlan = currentMoneyPlan;
    }

    public Long getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Long isCurrent) {
        this.isCurrent = isCurrent;
    }

    public BigDecimal getPlanPer() {
        return planPer;
    }

    public void setPlanPer(BigDecimal planPer) {
        this.planPer = planPer;
    }

    public String getBpmStatus() {
        return bpmStatus;
    }

    public void setBpmStatus(String bpmStatus) {
        this.bpmStatus = bpmStatus == null ? null : bpmStatus.trim();
    }

    public String getBpmStatusBak() {
        return bpmStatusBak;
    }

    public void setBpmStatusBak(String bpmStatusBak) {
        this.bpmStatusBak = bpmStatusBak == null ? null : bpmStatusBak.trim();
    }

    public String getBpmNodeId() {
        return bpmNodeId;
    }

    public void setBpmNodeId(String bpmNodeId) {
        this.bpmNodeId = bpmNodeId == null ? null : bpmNodeId.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public byte[] getSectId() {
        return sectId;
    }

    public void setSectId(byte[] sectId) {
        this.sectId = sectId;
    }
}