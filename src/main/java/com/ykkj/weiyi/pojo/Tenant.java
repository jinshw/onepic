package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class Tenant {
	/**
	 * 	主键唯一标识
	 */
	private String tenantId;
	/**
	 * 	租户英文编码
	 */
	private String tenantCode;
	/**
	 * 	租户中文名称
	 */
	private String tenantName;
	/**
	 * 	租户APP唯一标识码
	 */
	private String tenantApp;
	/**
	 * 租户微信唯一标识码	
	 */
	private String tenantWx;
	/**
	 * 是否开通：0 未开通、1 开通	
	 */
	private Integer isopen;
	/**
	 * 	开通时间
	 */
	private Timestamp openTime;
	/**
	 * 最后修改时间	
	 */
	private Timestamp modifyTime;
	/**
	 * 最后修改人	
	 */
	private String modifyPerson;
	
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantCode() {
		return tenantCode;
	}
	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTenantApp() {
		return tenantApp;
	}
	public void setTenantApp(String tenantApp) {
		this.tenantApp = tenantApp;
	}
	public String getTenantWx() {
		return tenantWx;
	}
	public void setTenantWx(String tenantWx) {
		this.tenantWx = tenantWx;
	}
	public Integer getIsopen() {
		return isopen;
	}
	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}
	public Timestamp getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
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
}
