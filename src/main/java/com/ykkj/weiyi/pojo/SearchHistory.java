package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class SearchHistory {
	/**
	 * 主键
	 */
	private String  id;
	/**
	 * 内容
	 */
	private String  content;
	/**
	 * 类型
	 */
	private Integer type ;
	/**
	 * 用户ID
	 */
	private String  userId;
	/**
	 * 搜索时间
	 */
	private Timestamp searchTime  ;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Timestamp getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Timestamp searchTime) {
		this.searchTime = searchTime;
	}
	
}
