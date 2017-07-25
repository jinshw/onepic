package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class PfTeam {

	private String teamId;
	
	private String HospId;
	
	private String teamName;
	
	private Timestamp modifyTime;
	
	private String modifyPerson; 
	
	private String address;
	
	private String contactWay;
	
	private Integer orderVal;
	
	private Integer openTeam;
	
	private Integer openPlayfrom;
	
	private Integer employCount;
	
	private String familyArea;
	
	private String teamLogo;
	
	private String manager;
	
	//扩展字段
	private String patientName;
	
	private String familyCode;
	
	private String patientId;
	
	private String remark;
	
	private Integer status;
	
	
	
	
	
	
	

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public String getFamilyArea() {
		return familyArea;
	}

	public void setFamilyArea(String familyArea) {
		this.familyArea = familyArea;
	}

	public String getTeamLogo() {
		return teamLogo;
	}

	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}

	public Integer getEmployCount() {
		return employCount;
	}

	public void setEmployCount(Integer employCount) {
		this.employCount = employCount;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getHospId() {
		return HospId;
	}

	public void setHospId(String hospId) {
		HospId = hospId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}


	public String getModifyPerson() {
		return modifyPerson;
	}

	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public Integer getOrderVal() {
		return orderVal;
	}

	public void setOrderVal(Integer orderVal) {
		this.orderVal = orderVal;
	}

	public Integer getOpenTeam() {
		return openTeam;
	}

	public void setOpenTeam(Integer openTeam) {
		this.openTeam = openTeam;
	}

	public Integer getOpenPlayfrom() {
		return openPlayfrom;
	}

	public void setOpenPlayfrom(Integer openPlayfrom) {
		this.openPlayfrom = openPlayfrom;
	}
	
	
}
