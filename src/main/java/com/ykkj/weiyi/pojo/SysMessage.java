package com.ykkj.weiyi.pojo;

import java.util.Date;

public class SysMessage {

	private String smId;
	
	private String smTitle;
	
	private String smContent;
	
	private String smUrl;
	
	private Date smPushTime;
	
	private Integer isRead;
	
	private String mtTime;
	


	public String getMtTime() {
		return mtTime;
	}

	public void setMtTime(String mtTime) {
		this.mtTime = mtTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getSmTitle() {
		return smTitle;
	}

	public void setSmTitle(String smTitle) {
		this.smTitle = smTitle;
	}

	public String getSmId() {
		return smId;
	}

	public void setSmId(String smId) {
		this.smId = smId;
	}

	public String getSmContent() {
		return smContent;
	}

	public void setSmContent(String smContent) {
		this.smContent = smContent;
	}

	public String getSmUrl() {
		return smUrl;
	}

	public void setSmUrl(String smUrl) {
		this.smUrl = smUrl;
	}

	public Date getSmPushTime() {
		return smPushTime;
	}

	public void setSmPushTime(Date smPushTime) {
		this.smPushTime = smPushTime;
	}
	
	
	
}
 