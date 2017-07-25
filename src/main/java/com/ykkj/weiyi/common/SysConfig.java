package com.ykkj.weiyi.common;

/**
 * XML配置文件实体类,主要是用来解析项目的指定XML文件
 * @author	[ChenTianCao]
 * @version	[cms1.0, 2014-04-03]
 * @since	[cms1.0] 
 */
public class SysConfig {
	/**
	 * 配置项的id号
	 */
    private Long id;
    /**
	 * 配置项的名称
	 */
	private String name;
	/**
	 * 该配置项描述
	 */
	private String description;
	/**
	 * 该配置项值
	 */
	private String value;
	/**
	 * 该配置项模块Id
	 */
	private Long moduleid;
	/**
	 * 该配置项模块名称
	 */
	private String modulename;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Long getModuleid() {
		return moduleid;
	}
	
	public void setModuleid(Long moduleid) {
		this.moduleid = moduleid;
	}
	
	public String getModulename() {
		return modulename;
	}
	
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
}
