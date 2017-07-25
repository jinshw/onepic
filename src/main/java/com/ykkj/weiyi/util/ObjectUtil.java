/**
 * <p>
 * FileName:ObjectUtil.java
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011-9-5
 * </p>
 * <p>
 * Company: 
 * </p>
 * 
 * @author 辛洪伟
 * @version 1.0
 */
package com.ykkj.weiyi.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ObjectUtil {
	/**
	 * 判断集合
	 * @param col
	 * @return
	 */
	public static boolean isEmpty(Collection<?> col) {
		if (col != null && col.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 判断map是否为空
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?,?> map){
		if(map!=null&&map.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断文件数组
	 * @param files
	 * @return
	 */
	public static boolean isEmpty(File[] files){
		if(files!=null&&files.length>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 将json转成map
	 * @param jsonObj
	 * @return
	 */
	public static Map<String,Object> jsonTransMap(JSONObject jsonObj){
		Map<String,Object> result=new HashMap<String,Object>();
		if(jsonObj!=null){
		    Set<Entry<String,Object>> set = jsonObj.entrySet();
		    for(Entry<String,Object> entry:set){
			    result.put(entry.getKey(), entry.getValue());
		    }
		}
		return result;
	}
	
	/**
	 * 将json转成map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String,Object> jsonTransMap(String jsonStr){
		JSONObject jsonObj=JSON.parseObject(jsonStr);
		return jsonTransMap(jsonObj);
	}
	
	/**
	 * 将字符串转换为列表
	 * @param str 原字符串
	 * @return 转换后的列表结果
	 * @throws Exception
	 */
	public static List<Long> strToList(String str) throws Exception{
		List<Long> result=new ArrayList<Long>();
		if(str!=null&&str.trim().length()>0){
			String[] array=str.split(",");
			for(String tmp:array){
				result.add(StringValueUtils.getLong(tmp));
			}
		}
		return result;
	}
	
	/**
     * 取list指定某范围数据
     * @param list list数据
     * @return 字符串结果
     */
    public static List<Long> limitList(List<Long> list,int begin,int end) throws Exception{
    	List<Long> result=new ArrayList<Long>();
    	if(list!=null&&list.size()>0){
    		for(int i=begin;i<end;i++){
    		    result.add(list.get(i));	
    		}
    	}
    	return result;
    }
    
    /**
     * 从map中获取int值
     * @param key
     * @param map
     * @return
     */
    public static int getInt(String key,Map<String,Object> map){
    	int result=0;
    	Integer str=(Integer)map.get(key);
    	if(str==null){
    		result=0;
    	}else{
    		result=str;
    	}
    	return result;
    }
    
    /**
     * 从map中获取long值
     * @param key
     * @param map
     * @return
     */
    public static long getLong(String key,Map<String,Object> map){
    	long result=0l;
    	Long str=(Long)map.get(key);
    	if(str==null){
    		result=0l;
    	}else{
    		result=str;
    	}
    	return result;
    }
    /**
     * 从map中获取String值
     * @param key
     * @param map
     * @return
     */
    public static String getString(String key,Map<String,Object> map){
    	String str=(String)map.get(key);
    	if(str==null){
    		str="";
    	}
    	return str;
    }
    
    /**
     * 将list转化成字符串
     * @param list
     * @return
     * @throws Exception
     */
    public static String listToStr(List<Long> list) throws Exception{
		StringBuffer result=new StringBuffer("");
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				if(i!=0){
					result.append(",");
				}
				result.append(list.get(i));
			}
		}
		return result.toString();
	}
    
	
}
