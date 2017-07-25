package com.ykkj.weiyi.pojo;

import java.util.Date;

public class Message {

	private String mId;
	
	private String mtId;
	
	private String id;
	
	private String mTitle;
	
	private String mContent;
	
	private String mUrl;
	
	private Date mPushTime;
	
	private Integer isRead;
	
	private Integer messageCount;
	
	private String mTime;
	
	

	public String getmTime() {
		return mTime;
	}

	public void setmTime(String mTime) {
		this.mTime = mTime;
	}

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}



	public String getMtId() {
		return mtId;
	}

	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public String getmUrl() {
		return mUrl;
	}

	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}

	public Date getmPushTime() {
		return mPushTime;
	}

	public void setmPushTime(Date mPushTime) {
		this.mPushTime = mPushTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	
	
	
	
}
