package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class FamilyTeam {

	private String id;
	
	private String teamId;
	
	private String idCard;
	
	private String familyCode;
	
	private Integer status;
	
	private Integer isEffective;
	
	private Date endTime;
	
	private Date startTime;
	
	private Timestamp createTime;
	
	private String remark;
	
	private Integer vailTime;
	
	private String siganName;
	
	

	public String getSiganName() {
		return siganName;
	}

	public void setSiganName(String siganName) {
		this.siganName = siganName;
	}

	public Integer getVailTime() {
		return vailTime;
	}

	public void setVailTime(Integer vailTime) {
		this.vailTime = vailTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}



	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
