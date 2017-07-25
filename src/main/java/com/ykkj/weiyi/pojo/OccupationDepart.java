package com.ykkj.weiyi.pojo;

public class OccupationDepart {
	/**
	 * 主键
	 */
	private String cdtId;
	/**
	 * 医生用户ID
	 */
	private String udpId;
	/**
	 * 科室ID
	 */
	private String departId;
	/**
	 * 医院ID
	 */
	private String hospId;
	/**
	 * 科室名称
	 */
	private String departName;
	/**
	 * 医院名称
	 */
	private String hospName;
	/**
	 * 排序值
	 */
	private Integer cdtOrder;
	public String getCdtId() {
		return cdtId;
	}
	public void setCdtId(String cdtId) {
		this.cdtId = cdtId;
	}
	public String getUdpId() {
		return udpId;
	}
	public void setUdpId(String udpId) {
		this.udpId = udpId;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getHospId() {
		return hospId;
	}
	public void setHospId(String hospId) {
		this.hospId = hospId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getHospName() {
		return hospName;
	}
	public void setHospName(String hospName) {
		this.hospName = hospName;
	}
	public Integer getCdtOrder() {
		return cdtOrder;
	}
	public void setCdtOrder(Integer cdtOrder) {
		this.cdtOrder = cdtOrder;
	}
	
}
