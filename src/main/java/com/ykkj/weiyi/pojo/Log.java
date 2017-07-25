package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;
public class Log {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 简介
	 */
    private String description;
    /**
	 * 方法名
	 */
    private String method;
    /**
	 * 类型
	 */
    private Integer type;
    /**
	 * 请求IP
	 */
    private String requestIp;
    /**
	 * 异常代码
	 */
    private String exceptionCode;
    /**
	 * 异常详细信息
	 */
    private String exceptionDetail;
    /**
	 * 参数
	 */
    private String params;
    /**
	 * 操作人
	 */
    private String createBy;
    /**
	 * 操作
	 */
    private String operation;
    /**
     * 操作时间
     */
    private Timestamp createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRequestIp() {
		return requestIp;
	}
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getExceptionDetail() {
		return exceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}