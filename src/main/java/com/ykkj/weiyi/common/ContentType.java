package com.ykkj.weiyi.common;

/**
 *  模板内容类型
 *  @文件名：        ContentType.java
 *  @版本：              v1.0
 */
public enum ContentType {
	//作品类型1文章2图片3文件4视频5音频6专题
	article("文章",1), pic("图片",2), file("文件",3), vedio("视频",4), audio("音频",5), special("专题",5);

	private int value;
	private String name;

	private ContentType(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 普通方法  获取name页面展示
    public static String getName(int value) {  
        for (ContentType type : ContentType.values()) {  
            if (type.getValue() == value) {  
                return type.name;  
            }  
        }  
        return null;  
    }  

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
	public static void main(String[] args) {
		System.out.println(ContentType.pic);
		System.out.println(ContentType.getName(1));
	}
}
