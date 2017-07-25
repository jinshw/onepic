package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class ConsultRecord {

	private String crdId;
	
	private String cpId;
	
	private String udpId;
	
	private String patientId;
	
	private Timestamp sendTime;
	
	private String sendContent;
	
	private Integer type;
	
	private String userId;
	
	private String doctorId;
	
	private Integer sendPort;
	
	private String filePath;
	
	private String patientName;
	
	private String doctorName;
	
	private String doctorImg;
	
	private String userImg;
	
	
	

	public String getDoctorImg() {
		return doctorImg;
	}

	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getCrdId() {
		return crdId;
	}

	public void setCrdId(String crdId) {
		this.crdId = crdId;
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

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getSendPort() {
		return sendPort;
	}

	public void setSendPort(Integer sendPort) {
		this.sendPort = sendPort;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
