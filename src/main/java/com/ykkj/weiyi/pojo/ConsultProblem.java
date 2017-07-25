package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class ConsultProblem {

	private String cpId;
	
	private String udpId;
	
	private String patientId;
	
	private String doctorName;
	
	private String patientName;
	
	private String cpTitle;
	
	private String cpIntroduce;
	
	private Integer isShow;
	
	private Integer isOver;
	
	private Timestamp  createTime;
	
	private Integer recordNum;
	
	private Integer isAdopt;
	
	private String createPerson;
	//人员ID
	private String doctorId;
	
	private int corFee;
	
	private int orderState;
	//患者头像
	private String headimg;
	
	
	
	

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public int getCorFee() {
		return corFee;
	}

	public void setCorFee(int corFee) {
		this.corFee = corFee;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getUdpId() {
		return udpId;
	}

	public void setUdpId(String udpId) {
		this.udpId = udpId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getCpTitle() {
		return cpTitle;
	}

	public void setCpTitle(String cpTitle) {
		this.cpTitle = cpTitle;
	}

	public String getCpIntroduce() {
		return cpIntroduce;
	}

	public void setCpIntroduce(String cpIntroduce) {
		this.cpIntroduce = cpIntroduce;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsOver() {
		return isOver;
	}

	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(Integer recordNum) {
		this.recordNum = recordNum;
	}

	public Integer getIsAdopt() {
		return isAdopt;
	}

	public void setIsAdopt(Integer isAdopt) {
		this.isAdopt = isAdopt;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	
	
	
	
	
}
