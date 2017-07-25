package com.ykkj.weiyi.pojo;

import java.util.Date;

public class Department {
    private String departId;

    private String hospId;

    private String departCode;

    private String departName;

    private String parentId;

    private String longCode;

    private Date modifyTime;

    private String modifyPerson;

    private String address;

    private String contactWay;

    private Integer orderVal;

    private Integer isOutDepart;

    private Integer isMedicalDepart;

    private Integer isHospDepart;

    private Integer isAuxiliaryDepart;

    private Integer isAdminDepart;

    private String introduce;

    private String goodArea;
    
    private String hisDepartmentId;
    
    private String sdId;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode == null ? null : departCode.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getLongCode() {
        return longCode;
    }

    public void setLongCode(String longCode) {
        this.longCode = longCode == null ? null : longCode.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson == null ? null : modifyPerson.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public Integer getOrderVal() {
        return orderVal;
    }

    public void setOrderVal(Integer orderVal) {
        this.orderVal = orderVal;
    }

    public Integer getIsOutDepart() {
        return isOutDepart;
    }

    public void setIsOutDepart(Integer isOutDepart) {
        this.isOutDepart = isOutDepart;
    }

    public Integer getIsMedicalDepart() {
        return isMedicalDepart;
    }

    public void setIsMedicalDepart(Integer isMedicalDepart) {
        this.isMedicalDepart = isMedicalDepart;
    }

    public Integer getIsHospDepart() {
        return isHospDepart;
    }

    public void setIsHospDepart(Integer isHospDepart) {
        this.isHospDepart = isHospDepart;
    }

    public Integer getIsAuxiliaryDepart() {
        return isAuxiliaryDepart;
    }

    public void setIsAuxiliaryDepart(Integer isAuxiliaryDepart) {
        this.isAuxiliaryDepart = isAuxiliaryDepart;
    }

    public Integer getIsAdminDepart() {
        return isAdminDepart;
    }

    public void setIsAdminDepart(Integer isAdminDepart) {
        this.isAdminDepart = isAdminDepart;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getGoodArea() {
        return goodArea;
    }

    public void setGoodArea(String goodArea) {
        this.goodArea = goodArea == null ? null : goodArea.trim();
    }

	public String getHisDepartmentId() {
		return hisDepartmentId;
	}

	public void setHisDepartmentId(String hisDepartmentId) {
		this.hisDepartmentId = hisDepartmentId;
	}

	public String getSdId() {
		return sdId;
	}

	public void setSdId(String sdId) {
		this.sdId = sdId;
	}
    
}