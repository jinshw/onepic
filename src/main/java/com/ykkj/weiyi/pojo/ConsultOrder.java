package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class ConsultOrder {

	private String corId;
	
	private String cpId;
	
	private int corFee;
	
	private int orderState;
	
	private Timestamp createTime;
	
	private String createPerson;
	
	private Timestamp payTime;
	
	private String payPerson;
	
	private String patientName;
	
	
	
	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getCorId() {
		return corId;
	}

	public void setCorId(String corId) {
		this.corId = corId;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public String getPayPerson() {
		return payPerson;
	}

	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}
	
}
