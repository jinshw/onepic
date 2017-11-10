package com.ykkj.weiyi.pojo;

public class ProjectInfoWithBLOBs extends ProjectInfo {
    private String projectDescript;

    private String buildContent;

    private String moneyComposition;

    private String availabilityMoney;

    private String projectApproval;

    private String projectMemo;

    private String overview;

    private String xmjshyyyzhyxy;

    private String ztjdap;

    public String getProjectDescript() {
        return projectDescript;
    }

    public void setProjectDescript(String projectDescript) {
        this.projectDescript = projectDescript == null ? null : projectDescript.trim();
    }

    public String getBuildContent() {
        return buildContent;
    }

    public void setBuildContent(String buildContent) {
        this.buildContent = buildContent == null ? null : buildContent.trim();
    }

    public String getMoneyComposition() {
        return moneyComposition;
    }

    public void setMoneyComposition(String moneyComposition) {
        this.moneyComposition = moneyComposition == null ? null : moneyComposition.trim();
    }

    public String getAvailabilityMoney() {
        return availabilityMoney;
    }

    public void setAvailabilityMoney(String availabilityMoney) {
        this.availabilityMoney = availabilityMoney == null ? null : availabilityMoney.trim();
    }

    public String getProjectApproval() {
        return projectApproval;
    }

    public void setProjectApproval(String projectApproval) {
        this.projectApproval = projectApproval == null ? null : projectApproval.trim();
    }

    public String getProjectMemo() {
        return projectMemo;
    }

    public void setProjectMemo(String projectMemo) {
        this.projectMemo = projectMemo == null ? null : projectMemo.trim();
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }

    public String getXmjshyyyzhyxy() {
        return xmjshyyyzhyxy;
    }

    public void setXmjshyyyzhyxy(String xmjshyyyzhyxy) {
        this.xmjshyyyzhyxy = xmjshyyyzhyxy == null ? null : xmjshyyyzhyxy.trim();
    }

    public String getZtjdap() {
        return ztjdap;
    }

    public void setZtjdap(String ztjdap) {
        this.ztjdap = ztjdap == null ? null : ztjdap.trim();
    }
}