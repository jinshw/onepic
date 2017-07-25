package com.ykkj.weiyi.pojo;

import java.util.Date;

public class ConsultproDoctor {
	private String cpId;

	private String udpId;

	private String patientId;

	private String doctorName;

	private String patientName;

	private Integer isOver;

	private Date createTime;

	private Integer recordNum;

	private Integer isAdopt;

	private String createPerson;

	private String cpTitle;

	private String cpIntroduce;

	private String patientPic;

	private String doctorPic;
	
	private String teamId;
	
	private String teamName;

	private String urlPic;// 头像地址

	private String doctorId;// 医生ID
	

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId == null ? null : cpId.trim();
	}

	public String getUdpId() {
		return udpId;
	}

	public void setUdpId(String udpId) {
		this.udpId = udpId == null ? null : udpId.trim();
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId == null ? null : patientId.trim();
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName == null ? null : doctorName.trim();
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName == null ? null : patientName.trim();
	}

	public Integer getIsOver() {
		return isOver;
	}

	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
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
		this.createPerson = createPerson == null ? null : createPerson.trim();
	}

	public String getCpTitle() {
		return cpTitle;
	}

	public void setCpTitle(String cpTitle) {
		this.cpTitle = cpTitle == null ? null : cpTitle.trim();
	}

	public String getCpIntroduce() {
		return cpIntroduce;
	}

	public void setCpIntroduce(String cpIntroduce) {
		this.cpIntroduce = cpIntroduce == null ? null : cpIntroduce.trim();
	}

	public String getCpId() {
		return cpId;
	}

	public String getPatientPic() {
		return patientPic;
	}

	public void setPatientPic(String patientPic) {
		this.patientPic = patientPic;
	}

	public String getDoctorPic() {
		return doctorPic;
	}

	public void setDoctorPic(String doctorPic) {
		this.doctorPic = doctorPic;
	}

	public String getUrlPic() {
		return urlPic;
	}

	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
}