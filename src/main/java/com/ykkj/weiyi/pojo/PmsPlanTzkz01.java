package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PmsPlanTzkz01 {
    private String id;

    private String mId;

    private String monitorDept;

    private BigDecimal mtPactMoney;

    private String monitorleader;

    private String inspectionDept;

    private BigDecimal ipMoney;

    private String inspectionLeader;

    private String directorDept;

    private BigDecimal dtpactMoney;

    private String directoLeader;

    private Long sn;

    private Long page;

    private Long projectPlanDuration;

    private Date inserttime;

    private Date creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public String getMonitorDept() {
        return monitorDept;
    }

    public void setMonitorDept(String monitorDept) {
        this.monitorDept = monitorDept == null ? null : monitorDept.trim();
    }

    public BigDecimal getMtPactMoney() {
        return mtPactMoney;
    }

    public void setMtPactMoney(BigDecimal mtPactMoney) {
        this.mtPactMoney = mtPactMoney;
    }

    public String getMonitorleader() {
        return monitorleader;
    }

    public void setMonitorleader(String monitorleader) {
        this.monitorleader = monitorleader == null ? null : monitorleader.trim();
    }

    public String getInspectionDept() {
        return inspectionDept;
    }

    public void setInspectionDept(String inspectionDept) {
        this.inspectionDept = inspectionDept == null ? null : inspectionDept.trim();
    }

    public BigDecimal getIpMoney() {
        return ipMoney;
    }

    public void setIpMoney(BigDecimal ipMoney) {
        this.ipMoney = ipMoney;
    }

    public String getInspectionLeader() {
        return inspectionLeader;
    }

    public void setInspectionLeader(String inspectionLeader) {
        this.inspectionLeader = inspectionLeader == null ? null : inspectionLeader.trim();
    }

    public String getDirectorDept() {
        return directorDept;
    }

    public void setDirectorDept(String directorDept) {
        this.directorDept = directorDept == null ? null : directorDept.trim();
    }

    public BigDecimal getDtpactMoney() {
        return dtpactMoney;
    }

    public void setDtpactMoney(BigDecimal dtpactMoney) {
        this.dtpactMoney = dtpactMoney;
    }

    public String getDirectoLeader() {
        return directoLeader;
    }

    public void setDirectoLeader(String directoLeader) {
        this.directoLeader = directoLeader == null ? null : directoLeader.trim();
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getProjectPlanDuration() {
        return projectPlanDuration;
    }

    public void setProjectPlanDuration(Long projectPlanDuration) {
        this.projectPlanDuration = projectPlanDuration;
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