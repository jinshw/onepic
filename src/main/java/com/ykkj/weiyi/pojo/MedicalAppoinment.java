package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class MedicalAppoinment {

	private String appointId;
	
	private String company;
	
	private String sex;
	
	private String idNum;
	
	private String mobile;
	
	private String cdcId;
	
	private String workType;
	
	private Timestamp createTime;
	
	private Date appointTime;
	
	private Integer age;
	
	private String id;
	
	private String userName;
	
	private String cdcName;
	
	private String cdcMobile;
	
	private String cdcAddress;

	private String appointTimeInterval;

	private Integer maState;

	private String yearStr;

	public String getYearStr() {
		return yearStr;
	}

	public void setYearStr(String yearStr) {
		this.yearStr = yearStr;
	}

	public String getAppointTimeInterval() {
		return appointTimeInterval;
	}

	public void setAppointTimeInterval(String appointTimeInterval) {
		this.appointTimeInterval = appointTimeInterval;
	}

	public Integer getMaState() {
		return maState;
	}
	public void setMaState(Integer maState) {
		this.maState = maState;
	}

	public String getCdcName() {
		return cdcName;
	}

	public void setCdcName(String cdcName) {
		this.cdcName = cdcName;
	}

	public String getCdcMobile() {
		return cdcMobile;
	}

	public void setCdcMobile(String cdcMobile) {
		this.cdcMobile = cdcMobile;
	}

	public String getCdcAddress() {
		return cdcAddress;
	}

	public void setCdcAddress(String cdcAddress) {
		this.cdcAddress = cdcAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public String getAppointId() {
		return appointId;
	}

	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCdcId() {
		return cdcId;
	}

	public void setCdcId(String cdcId) {
		this.cdcId = cdcId;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
