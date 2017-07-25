package com.ykkj.weiyi.common;

/**
 *  发布平台类型
 *  @文件名：        PlatForm.java
 *  @版本：              v1.0
 */
public enum PlatForm {
	//发布平台类型1pc 2h5 3xml 4json
	pc("pc",1), h5("h5",2), xml("xml",3), json("json",4);

	private int value;
	private String name;

	private PlatForm(String name, int value) {
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
        for (PlatForm type : PlatForm.values()) {  
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
		System.out.println(PlatForm.pc);
		System.out.println(PlatForm.getName(1));
	}
}
