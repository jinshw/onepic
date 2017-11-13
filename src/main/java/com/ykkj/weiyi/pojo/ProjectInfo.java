package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class ProjectInfo {
    private String id;

    private String sysDeptId;

    private String projectNo;

    private String projectName;

    private String buildAdd;

    private String projectType;

    private String projectLeader;

    private String projectLeaderTel;

    private String engineer;

    private String engineerTel;

    private String conductorName;

    private String conductorAdd;

    private String conductorTel;

    private String ownerName;

    private String ownerAdd;

    private String ownerTel;

    private String zxbmc;

    private String zxbdz;

    private String zxbdh;

    private String tenderName;

    private String tenderAdd;

    private String tenderTel;

    private String designName;

    private String designAdd;

    private String designTel;

    private Float projectTotalinversted;

    private Float projectTotalLen;

    private Integer projectPlanDuration;

    private Integer lagDay;

    private Date beginDay;

    private Date endDay;

    private Date completionDay;

    private Float approveEstimate;

    private Float budget;

    private String uploadId;

    private String projectPropertyA;

    private String projectPropertyB;

    private String projectPropertyC;

    private Integer sortorder;

    private String xmlxdzh;

    private String xmlxrxm;

    private String lxrdh;

    private String xmzhgdwjfgld;

    private String chbshjpfwh;

    private String shgtpfwh;

    private Date chbshjpfshj;

    private Date shgtpfrq;

    private String qdzhh;

    private String jshzhh;

    private String jshgm;

    private String zhyjshbzh;

    private String jshdw;

    private String jshdwdz;

    private String jshdwdh;

    private String gchgm;

    private String jshbzh;

    private Integer roleType;

    private String area;

    private String qianqixmisbn;

    private String qianqixmmc;

    private Date bgxyqdshj;

    private Float zhdbcfhj;

    private String zqDzfzr;

    private String zqXsfzr;

    private String zqZhbld;

    private String zqXmfzr;

    private String belongCities;

    private Integer issuance;

    private Timestamp createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSysDeptId() {
        return sysDeptId;
    }

    public void setSysDeptId(String sysDeptId) {
        this.sysDeptId = sysDeptId == null ? null : sysDeptId.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getBuildAdd() {
        return buildAdd;
    }

    public void setBuildAdd(String buildAdd) {
        this.buildAdd = buildAdd == null ? null : buildAdd.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    public String getProjectLeaderTel() {
        return projectLeaderTel;
    }

    public void setProjectLeaderTel(String projectLeaderTel) {
        this.projectLeaderTel = projectLeaderTel == null ? null : projectLeaderTel.trim();
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer == null ? null : engineer.trim();
    }

    public String getEngineerTel() {
        return engineerTel;
    }

    public void setEngineerTel(String engineerTel) {
        this.engineerTel = engineerTel == null ? null : engineerTel.trim();
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName == null ? null : conductorName.trim();
    }

    public String getConductorAdd() {
        return conductorAdd;
    }

    public void setConductorAdd(String conductorAdd) {
        this.conductorAdd = conductorAdd == null ? null : conductorAdd.trim();
    }

    public String getConductorTel() {
        return conductorTel;
    }

    public void setConductorTel(String conductorTel) {
        this.conductorTel = conductorTel == null ? null : conductorTel.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerAdd() {
        return ownerAdd;
    }

    public void setOwnerAdd(String ownerAdd) {
        this.ownerAdd = ownerAdd == null ? null : ownerAdd.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public String getZxbmc() {
        return zxbmc;
    }

    public void setZxbmc(String zxbmc) {
        this.zxbmc = zxbmc == null ? null : zxbmc.trim();
    }

    public String getZxbdz() {
        return zxbdz;
    }

    public void setZxbdz(String zxbdz) {
        this.zxbdz = zxbdz == null ? null : zxbdz.trim();
    }

    public String getZxbdh() {
        return zxbdh;
    }

    public void setZxbdh(String zxbdh) {
        this.zxbdh = zxbdh == null ? null : zxbdh.trim();
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName == null ? null : tenderName.trim();
    }

    public String getTenderAdd() {
        return tenderAdd;
    }

    public void setTenderAdd(String tenderAdd) {
        this.tenderAdd = tenderAdd == null ? null : tenderAdd.trim();
    }

    public String getTenderTel() {
        return tenderTel;
    }

    public void setTenderTel(String tenderTel) {
        this.tenderTel = tenderTel == null ? null : tenderTel.trim();
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName == null ? null : designName.trim();
    }

    public String getDesignAdd() {
        return designAdd;
    }

    public void setDesignAdd(String designAdd) {
        this.designAdd = designAdd == null ? null : designAdd.trim();
    }

    public String getDesignTel() {
        return designTel;
    }

    public void setDesignTel(String designTel) {
        this.designTel = designTel == null ? null : designTel.trim();
    }

    public Float getProjectTotalinversted() {
        return projectTotalinversted;
    }

    public void setProjectTotalinversted(Float projectTotalinversted) {
        this.projectTotalinversted = projectTotalinversted;
    }

    public Float getProjectTotalLen() {
        return projectTotalLen;
    }

    public void setProjectTotalLen(Float projectTotalLen) {
        this.projectTotalLen = projectTotalLen;
    }

    public Integer getProjectPlanDuration() {
        return projectPlanDuration;
    }

    public void setProjectPlanDuration(Integer projectPlanDuration) {
        this.projectPlanDuration = projectPlanDuration;
    }

    public Integer getLagDay() {
        return lagDay;
    }

    public void setLagDay(Integer lagDay) {
        this.lagDay = lagDay;
    }

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Date getCompletionDay() {
        return completionDay;
    }

    public void setCompletionDay(Date completionDay) {
        this.completionDay = completionDay;
    }

    public Float getApproveEstimate() {
        return approveEstimate;
    }

    public void setApproveEstimate(Float approveEstimate) {
        this.approveEstimate = approveEstimate;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId == null ? null : uploadId.trim();
    }

    public String getProjectPropertyA() {
        return projectPropertyA;
    }

    public void setProjectPropertyA(String projectPropertyA) {
        this.projectPropertyA = projectPropertyA == null ? null : projectPropertyA.trim();
    }

    public String getProjectPropertyB() {
        return projectPropertyB;
    }

    public void setProjectPropertyB(String projectPropertyB) {
        this.projectPropertyB = projectPropertyB == null ? null : projectPropertyB.trim();
    }

    public String getProjectPropertyC() {
        return projectPropertyC;
    }

    public void setProjectPropertyC(String projectPropertyC) {
        this.projectPropertyC = projectPropertyC == null ? null : projectPropertyC.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public String getXmlxdzh() {
        return xmlxdzh;
    }

    public void setXmlxdzh(String xmlxdzh) {
        this.xmlxdzh = xmlxdzh == null ? null : xmlxdzh.trim();
    }

    public String getXmlxrxm() {
        return xmlxrxm;
    }

    public void setXmlxrxm(String xmlxrxm) {
        this.xmlxrxm = xmlxrxm == null ? null : xmlxrxm.trim();
    }

    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh == null ? null : lxrdh.trim();
    }

    public String getXmzhgdwjfgld() {
        return xmzhgdwjfgld;
    }

    public void setXmzhgdwjfgld(String xmzhgdwjfgld) {
        this.xmzhgdwjfgld = xmzhgdwjfgld == null ? null : xmzhgdwjfgld.trim();
    }

    public String getChbshjpfwh() {
        return chbshjpfwh;
    }

    public void setChbshjpfwh(String chbshjpfwh) {
        this.chbshjpfwh = chbshjpfwh == null ? null : chbshjpfwh.trim();
    }

    public String getShgtpfwh() {
        return shgtpfwh;
    }

    public void setShgtpfwh(String shgtpfwh) {
        this.shgtpfwh = shgtpfwh == null ? null : shgtpfwh.trim();
    }

    public Date getChbshjpfshj() {
        return chbshjpfshj;
    }

    public void setChbshjpfshj(Date chbshjpfshj) {
        this.chbshjpfshj = chbshjpfshj;
    }

    public Date getShgtpfrq() {
        return shgtpfrq;
    }

    public void setShgtpfrq(Date shgtpfrq) {
        this.shgtpfrq = shgtpfrq;
    }

    public String getQdzhh() {
        return qdzhh;
    }

    public void setQdzhh(String qdzhh) {
        this.qdzhh = qdzhh == null ? null : qdzhh.trim();
    }

    public String getJshzhh() {
        return jshzhh;
    }

    public void setJshzhh(String jshzhh) {
        this.jshzhh = jshzhh == null ? null : jshzhh.trim();
    }

    public String getJshgm() {
        return jshgm;
    }

    public void setJshgm(String jshgm) {
        this.jshgm = jshgm == null ? null : jshgm.trim();
    }

    public String getZhyjshbzh() {
        return zhyjshbzh;
    }

    public void setZhyjshbzh(String zhyjshbzh) {
        this.zhyjshbzh = zhyjshbzh == null ? null : zhyjshbzh.trim();
    }

    public String getJshdw() {
        return jshdw;
    }

    public void setJshdw(String jshdw) {
        this.jshdw = jshdw == null ? null : jshdw.trim();
    }

    public String getJshdwdz() {
        return jshdwdz;
    }

    public void setJshdwdz(String jshdwdz) {
        this.jshdwdz = jshdwdz == null ? null : jshdwdz.trim();
    }

    public String getJshdwdh() {
        return jshdwdh;
    }

    public void setJshdwdh(String jshdwdh) {
        this.jshdwdh = jshdwdh == null ? null : jshdwdh.trim();
    }

    public String getGchgm() {
        return gchgm;
    }

    public void setGchgm(String gchgm) {
        this.gchgm = gchgm == null ? null : gchgm.trim();
    }

    public String getJshbzh() {
        return jshbzh;
    }

    public void setJshbzh(String jshbzh) {
        this.jshbzh = jshbzh == null ? null : jshbzh.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getQianqixmisbn() {
        return qianqixmisbn;
    }

    public void setQianqixmisbn(String qianqixmisbn) {
        this.qianqixmisbn = qianqixmisbn == null ? null : qianqixmisbn.trim();
    }

    public String getQianqixmmc() {
        return qianqixmmc;
    }

    public void setQianqixmmc(String qianqixmmc) {
        this.qianqixmmc = qianqixmmc == null ? null : qianqixmmc.trim();
    }

    public Date getBgxyqdshj() {
        return bgxyqdshj;
    }

    public void setBgxyqdshj(Date bgxyqdshj) {
        this.bgxyqdshj = bgxyqdshj;
    }

    public Float getZhdbcfhj() {
        return zhdbcfhj;
    }

    public void setZhdbcfhj(Float zhdbcfhj) {
        this.zhdbcfhj = zhdbcfhj;
    }

    public String getZqDzfzr() {
        return zqDzfzr;
    }

    public void setZqDzfzr(String zqDzfzr) {
        this.zqDzfzr = zqDzfzr == null ? null : zqDzfzr.trim();
    }

    public String getZqXsfzr() {
        return zqXsfzr;
    }

    public void setZqXsfzr(String zqXsfzr) {
        this.zqXsfzr = zqXsfzr == null ? null : zqXsfzr.trim();
    }

    public String getZqZhbld() {
        return zqZhbld;
    }

    public void setZqZhbld(String zqZhbld) {
        this.zqZhbld = zqZhbld == null ? null : zqZhbld.trim();
    }

    public String getZqXmfzr() {
        return zqXmfzr;
    }

    public void setZqXmfzr(String zqXmfzr) {
        this.zqXmfzr = zqXmfzr == null ? null : zqXmfzr.trim();
    }

    public String getBelongCities() {
        return belongCities;
    }

    public void setBelongCities(String belongCities) {
        this.belongCities = belongCities == null ? null : belongCities.trim();
    }

    public Integer getIssuance() {
        return issuance;
    }

    public void setIssuance(Integer issuance) {
        this.issuance = issuance;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}