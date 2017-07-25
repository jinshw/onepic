package com.ykkj.weiyi.pojo;

import java.util.Date;

public class OutUserCard {
    /**
     *
     */
    private Long id;

    /**
     * 患者(外部用户)ID
     */
    private String userid;

    /**
     * 医疗机构标识码
     */
    private String medicalcode;

    /**
     * 医疗卡
     */
    private String medicalcard;

    /**
     * 绑定时间
     */
    private Date binddate;

    /**
     * 持卡人手机号码
     */
    private String telephone;

    /**
     * 持卡人姓名
     */
    private String patientname;

    /**
     *
     */
    private String gender;

    /**
     * 卡类型
     */
    private String cardtype;

    /**
     * 身份证
     */
    private String chinacard;

    /**
     * 扩展字段
     */
    private String brid;// 病人ID

    private String mzh;//门诊号

    private String barCode;

    private String qrCode;

    private String patientId;//就诊人ID

    private Integer enabled;
    
    private String hospName;
    
    


    public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getMedicalcode() {
        return medicalcode;
    }

    public void setMedicalcode(String medicalcode) {
        this.medicalcode = medicalcode == null ? null : medicalcode.trim();
    }

    public String getMedicalcard() {
        return medicalcard;
    }

    public void setMedicalcard(String medicalcard) {
        this.medicalcard = medicalcard == null ? null : medicalcard.trim();
    }

    public Date getBinddate() {
        return binddate;
    }

    public void setBinddate(Date binddate) {
        this.binddate = binddate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getChinacard() {
        return chinacard;
    }

    public void setChinacard(String chinacard) {
        this.chinacard = chinacard == null ? null : chinacard.trim();
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getMzh() {
        return mzh;
    }

    public void setMzh(String mzh) {
        this.mzh = mzh;
    }
}