package com.ykkj.weiyi.pojo;

public class OutVirtualCard {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String hospitalid;

    /**
     * 
     */
    private String signature;

    /**
     * 
     */
    private String patname;

    /**
     * 
     */
    private String patsex;

    /**
     * 
     */
    private String patage;

    /**
     * 
     */
    private String patbirth;

    /**
     * 
     */
    private String curraddrprovince;

    /**
     * 
     */
    private String curraddrcity;

    /**
     * 
     */
    private String curraddrcounty;

    /**
     * 
     */
    private String curraddrtownship;

    /**
     * 
     */
    private String homeaddress;

    /**
     * 
     */
    private String patmobile;

    /**
     * 
     */
    private String patidtype;

    /**
     * 
     */
    private String patidcard;

    /**
     * 
     */
    private String guardname;

    /**
     * 
     */
    private String guardidtype;

    /**
     * 
     */
    private String guardidcard;

    /**
     * 诊疗卡类型
     */
    private String patmedtype;

    /**
     * 诊疗卡卡号
     */
    private String patcardno;

    /**
     * 
     */
    private String noncestr;

    /**
     * HIS病人ID
     */
    private String brid;

    /**
     * HIS门诊号
     */
    private String mzh;
    
    /*
     * 就诊卡类型   9：就诊卡    3：虚拟卡
     */
    private String cardType;
    
    



	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname == null ? null : patname.trim();
    }

    public String getPatsex() {
        return patsex;
    }

    public void setPatsex(String patsex) {
        this.patsex = patsex == null ? null : patsex.trim();
    }

    public String getPatage() {
        return patage;
    }

    public void setPatage(String patage) {
        this.patage = patage == null ? null : patage.trim();
    }

    public String getPatbirth() {
        return patbirth;
    }

    public void setPatbirth(String patbirth) {
        this.patbirth = patbirth == null ? null : patbirth.trim();
    }

    public String getCurraddrprovince() {
        return curraddrprovince;
    }

    public void setCurraddrprovince(String curraddrprovince) {
        this.curraddrprovince = curraddrprovince == null ? null : curraddrprovince.trim();
    }

    public String getCurraddrcity() {
        return curraddrcity;
    }

    public void setCurraddrcity(String curraddrcity) {
        this.curraddrcity = curraddrcity == null ? null : curraddrcity.trim();
    }

    public String getCurraddrcounty() {
        return curraddrcounty;
    }

    public void setCurraddrcounty(String curraddrcounty) {
        this.curraddrcounty = curraddrcounty == null ? null : curraddrcounty.trim();
    }

    public String getCurraddrtownship() {
        return curraddrtownship;
    }

    public void setCurraddrtownship(String curraddrtownship) {
        this.curraddrtownship = curraddrtownship == null ? null : curraddrtownship.trim();
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public String getPatmobile() {
        return patmobile;
    }

    public void setPatmobile(String patmobile) {
        this.patmobile = patmobile == null ? null : patmobile.trim();
    }

    public String getPatidtype() {
        return patidtype;
    }

    public void setPatidtype(String patidtype) {
        this.patidtype = patidtype == null ? null : patidtype.trim();
    }

    public String getPatidcard() {
        return patidcard;
    }

    public void setPatidcard(String patidcard) {
        this.patidcard = patidcard == null ? null : patidcard.trim();
    }

    public String getGuardname() {
        return guardname;
    }

    public void setGuardname(String guardname) {
        this.guardname = guardname == null ? null : guardname.trim();
    }

    public String getGuardidtype() {
        return guardidtype;
    }

    public void setGuardidtype(String guardidtype) {
        this.guardidtype = guardidtype == null ? null : guardidtype.trim();
    }

    public String getGuardidcard() {
        return guardidcard;
    }

    public void setGuardidcard(String guardidcard) {
        this.guardidcard = guardidcard == null ? null : guardidcard.trim();
    }

    public String getPatmedtype() {
        return patmedtype;
    }

    public void setPatmedtype(String patmedtype) {
        this.patmedtype = patmedtype == null ? null : patmedtype.trim();
    }

    public String getPatcardno() {
        return patcardno;
    }

    public void setPatcardno(String patcardno) {
        this.patcardno = patcardno == null ? null : patcardno.trim();
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr == null ? null : noncestr.trim();
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid == null ? null : brid.trim();
    }

    public String getMzh() {
        return mzh;
    }

    public void setMzh(String mzh) {
        this.mzh = mzh == null ? null : mzh.trim();
    }
}