/**
 * <p>
 * FileName:NumberUtil.java
 * </p>
 * <p>
 * Description: 数字处理工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011-9-6
 * </p>
 * <p>
 * Company: 
 * </p>
 * 
 * @author 辛洪伟
 * @version 1.0
 */
package com.ykkj.weiyi.util;

public class NumberUtil {
	
	/**
	 * 字符串转换为整形
	 * @param str
	 * @param defaultValue
	 * @return
	 */
    public static int strToInt(String str,int defaultValue){
    	int result=0;
    	if(str!=null&&str.length()>0){
    		result=new Integer(str).intValue();
    	}else{
    		result=defaultValue;
    	}
    	return result;
    }
    
    public static int strToInt(String str){
    	return strToInt(str,0);
    }
    
    /**
	 * 字符串转换为长整形
	 * @param str
	 * @param defaultValue
	 * @return
	 */
    public static long strToLong(String str,int defaultValue){
    	long result=0l;
    	if(str!=null&&str.length()>0){
    		result=new Long(str).longValue();
    	}else{
    		result=defaultValue;
    	}
    	return result;
    }
    
    public static long strToLong(String str){
    	return strToInt(str,0);
    }
}
