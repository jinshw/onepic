package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 档案关联表(PF_RECORDS_REL)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class RecordsRelDTO implements java.io.Serializable {

	/** 档案关联表ID */
	private String rrId;

	/** 具名健康档案表ID */
	private String hrId;

	/** 1 个人基本信息 2 健康体检 3 糖尿病 4 高血压 5 精神障碍 */
	private Integer type;

	/** 0 未随访 1 已随访 2 随访中*/
	private Integer isFollow;

	/** 创建日期 */
	private Date createDate;

	/** 关联的档案ID */
	private String recordId;

	/** 开始日期 */
	private Date startDate;

	/** 结束日期 */
	private Date endDate;

	/** 随访周期(月) */
	private Integer followCycle;

	/** 随访日期 */
	private Date followDate;

	/**
	 * 获取档案关联表ID
	 * 
	 * @return 档案关联表ID
	 */
	public String getRrId() {
		return this.rrId;
	}

	/**
	 * 设置档案关联表ID
	 * 
	 * @param rrId
	 *            档案关联表ID
	 */
	public void setRrId(String rrId) {
		this.rrId = rrId;
	}

	/**
	 * 获取具名健康档案表ID
	 * 
	 * @return 具名健康档案表ID
	 */
	public String getHrId() {
		return this.hrId;
	}

	/**
	 * 设置具名健康档案表ID
	 * 
	 * @param hrId
	 *            具名健康档案表ID
	 */
	public void setHrId(String hrId) {
		this.hrId = hrId;
	}

	/**
	 * 获取1 个人基本信息 2 健康体检 3 糖尿病 4 高血压 5 精神障碍
	 * 
	 * @return 1 个人基本信息 2 健康体检 3 糖尿病 4 高血压 5 精神障碍
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * 设置1 个人基本信息 2 健康体检 3 糖尿病 4 高血压 5 精神障碍
	 * 
	 * @param type
	 *            1 个人基本信息 2 健康体检 3 糖尿病 4 高血压 5 精神障碍
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取0 未随访 1 已随访
	 * 
	 * @return 0 未随访 1 已随访
	 */
	public Integer getIsFollow() {
		return this.isFollow;
	}

	/**
	 * 设置0 未随访 1 已随访
	 * 
	 * @param isFollow
	 *            0 未随访 1 已随访
	 */
	public void setIsFollow(Integer isFollow) {
		this.isFollow = isFollow;
	}

	/**
	 * 获取创建日期
	 * 
	 * @return 创建日期
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 设置创建日期
	 * 
	 * @param createDate
	 *            创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取关联的档案ID
	 * 
	 * @return 关联的档案ID
	 */
	public String getRecordId() {
		return this.recordId;
	}

	/**
	 * 设置关联的档案ID
	 * 
	 * @param recordId
	 *            关联的档案ID
	 */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getFollowCycle() {
		return followCycle;
	}

	public void setFollowCycle(Integer followCycle) {
		this.followCycle = followCycle;
	}

	public Date getFollowDate() {
		return followDate;
	}

	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

}