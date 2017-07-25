/*
 * All rights reserved.
 */
package com.ykkj.weiyi.util;

import java.util.Date;
import java.util.Map;

import org.dom4j.Element;




/**
 * 从String字符串中获取相应的值
 *
 * @author Liudong
 * @version 1.0
 * Date:2003-12-4
 */
public class StringValueUtils
{
	/**
	 * 获取字符串中的int值,
	 * 如果在转换过程中出现任何错误则返回缺省值
	 *
	 * @param value 输入的字符串
	 * @param defaultValue 缺省值
	 * @return 对应的int值
	 */
	public static int getInt(String value, int defaultValue)
	{
		int result = defaultValue;
		try
		{
			result = Integer.parseInt(value);
		}
		catch (Exception ex)
		{
		}
		return result;
	}

    /**
     * 获取WebWork ActionContext中的参数
     * WebWork 中获取到的参数为Map的形式
     * key 是String类型
     * value是String[]类型的
     * 本函数固定取字符数组中的第一个值
     *
     * @param map parameters
     * @param key 要取的参数名称
     * @param defaultValue 缺省值
     * @return
     */
    public static int getWWPInt(Map map, String key, int defaultValue) {
        Object obj = map.get(key);
        if(obj == null)
            return defaultValue;
        else {
            if(obj instanceof String[]) {
                String[] sa = (String[])obj;
                if(sa == null || sa.length < 1)
                    return defaultValue;
                else {
                    String s = sa[0];
                    return getInt(s, defaultValue);
                }
            }
            else
                return defaultValue;
        }
    }

	/**
	 * 获取字符串中的int值,
	 * 如果在转换过程中出现任何错误则返回缺省值<b>0</b>
	 *
	 * @param value 输入的字符串
	 * @return 对应的int值
	 */
	public static int getInt(String value)
	{
		return getInt(value, 0);
	}

    public static int getWWPInt(Map map, String key) {
        return getWWPInt(map, key, 0);
    }

	/**
	 * 获取字符串中的long值,
	 * 如果在转换过程中出现任何错误则返回缺省值
	 *
	 * @param value 输入的字符串
	 * @param defaultValue 缺省值
	 * @return 对应的long值
	 */
	public static long getLong(String value, long defaultValue)
	{
		long result = defaultValue;
		try
		{
			result = Long.parseLong(value);
		}
		catch (Exception ex)
		{
		}
		return result;
	}

	/**
	 * 获取字符串中的long值,
	 * 如果在转换过程中出现任何错误则返回缺省值<b>0</b>
	 *
	 * @param value 输入的字符串
	 * @return 对应的long值
	 */
	public static long getLong(String value)
	{
		return getLong(value, 0L);
	}

	/**
	 * 获取字符串中的float值,
	 * 如果在转换过程中出现任何错误则返回缺省值
	 *
	 * @param value 输入的字符串
	 * @param defaultValue 缺省值
	 * @return 对应的float值
	 */
	public static float getFloat(String value, float defaultValue)
	{
		float result = defaultValue;
		try
		{
			result = Float.parseFloat(value);
		}
		catch (Exception ex)
		{
		}
		return result;
	}

	/**
	 * 获取字符串中的float值,
	 * 如果在转换过程中出现任何错误则返回缺省值<b>0.0</b>
	 *
	 * @param value 输入的字符串
	 * @return 对应的float值
	 */
	public static float getFloat(String value)
	{
		return getFloat(value, 0.0F);
	}

	/**
	 * 获取字符串中的double值,
	 * 如果在转换过程中出现任何错误则返回缺省值
	 *
	 * @param value 输入的字符串
	 * @param defaultValue 缺省值
	 * @return 对应的double值
	 */
	public static double getDouble(String value, double defaultValue)
	{
		double result = defaultValue;
		try
		{
			result = Double.parseDouble(value);
		}
		catch (Exception ex)
		{
		}
		return result;
	}

	/**
	 * 获取字符串中的double值,
	 * 如果在转换过程中出现任何错误则返回缺省值<b>0.0</b>
	 *
	 * @param value 输入的字符串
	 * @return 对应的double值
	 */
	public static double getDouble(String value)
	{
		return getDouble(value, 0.0D);
	}

	/**
	 * <p>
	 * 获取字符串中的boolean值,
	 * 如果在转换过程中出现任何错误则返回缺省值
	 * </p>
	 * <p>
	 * 其中:
	 * <ul>
	 *   <li>true</li>
	 *   <li>y</li>
	 *   <li>yes</li>
	 *   <li>1</li>
	 *   <li>on</li>
	 * </ul>
	 * 对应的字符串会返回true
	 * <ul>
	 *   <li>false</li>
	 *   <li>n</li>
	 *   <li>no</li>
	 *   <li>0</li>
	 *   <li>off</li>
	 * </ul>
	 * 对应的字符串会返回false
	 * </p>
	 *
	 * @param value 输入的字符串
	 * @param defaultValue 缺省值
	 * @return 对应的boolean值
	 */
	public static boolean getBoolean(String value, boolean defaultValue)
	{
		boolean result = defaultValue;
		if ("true".equalsIgnoreCase(value)
			|| "y".equalsIgnoreCase(value)
			|| "yes".equalsIgnoreCase(value)
			|| "1".equals(value)
			|| "on".equalsIgnoreCase(value))
		{
			result = true;
		}
		else if (
			"false".equals(value)
				|| "n".equals(value)
				|| "no".equalsIgnoreCase(value)
				|| "0".equals(value)
				|| "off".equalsIgnoreCase(value))
		{
			result = false;
		}
		return result;
	}

	/**
	 * <p>
	 * 获取字符串中的boolean值,
	 * 如果在转换过程中出现任何错误则返回缺省值<b>false</b>
	 * </p>
	 * <p>
	 * 其中:
	 * <ul>
	 *   <li>true</li>
	 *   <li>y</li>
	 *   <li>yes</li>
	 *   <li>1</li>
	 *   <li>on</li>
	 * </ul>
	 * 对应的字符串会返回true
	 * <ul>
	 *   <li>false</li>
	 *   <li>n</li>
	 *   <li>no</li>
	 *   <li>0</li>
	 *   <li>off</li>
	 * </ul>
	 * 对应的字符串会返回false
	 * </p>
	 *
	 * @param value 输入的字符串
	 * @return 对应的boolean值
	 */
	public static boolean getBoolean(String value)
	{
		return getBoolean(value, false);
	}

	/**
	 * 将类似于"2003-12-11 00:00:00"的字符串转化为"2003-12-11"
	 * @param str	原始的包含日期和时间的字符串
	 * @return   日期字符串
	 */
	public static String getDateFromStr(String str)
	{
		String date = null;
		char[] date1 = str.toCharArray();
		char[] date2 = new char[date1.length];
		for (int i = 0; i < date1.length - 9; i++)
		{
			date2[i] = date1[i];
		}
		date = String.copyValueOf(date2).trim();
		return date;
	}

    /**
     * 将输入的字符串按二进制转换为int类型
     * @param str 要转换的字符串
     * @return int类型值
     */
    public static int getIntFromString(String str)
    {
        int result = 0;
        try
        {
            result = Integer.parseInt(str, 2);
        }
        catch(Exception ex)
        {
        }
        return result;
    }

    /**
     * 将输入的字符串按二进制转换为long类型值
     * @param str 要转换的字符串
     * @return 转换后的long值
     */
    public static long getLongFromString(String str)
    {
        long result = 0;
        try
        {
            result = Long.parseLong(str, 2);
        }
        catch(Exception ex)
        {
        }
        return result;
    }
    
    /**
     * 遇到字符串为null时，转成""
     * @param str
     * @return
     */
    public static String nullToStr(Object obj){
    	if(obj==null||"null".equals(obj)){
    		return "";
    	}
    	return obj.toString();
    }
    
    /**
     * 判断字符串是否为空
     * @param obj
     * @return
     */
    public static boolean isNull(String str){
    	if(str==null||"null".equals(str)||"".equals(str)){
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * 判断对象是否为空，若为空返回空字符串
     * @param obj
     * @return
     */
    
    public static String fixNull(Object obj){
    	return obj==null?"":obj.toString();
    }
    
    /**
     * 获取WebWork ActionContext中的参数
     * WebWork 中获取到的参数为Map的形式
     * key 是String类型
     * value是String[]类型的
     * 本函数固定取字符数组中的第一个值
     *
     * @param map parameters
     * @param key 要取的参数名称
     * @param defaultValue 缺省值
     * @return
     */
    public static String getWWPString(Map map, String key, String defaultValue) {
        Object obj = map.get(key);
        if(obj == null)
            return defaultValue;
        else {
            if(obj instanceof String[]) {
                String[] sa = (String[])obj;
                if(sa == null || sa.length < 1)
                    return defaultValue;
                else {
                    return sa[0];
                }
            }
            else
                return defaultValue;
        }
    }

    public static String getWWPString(Map map, String key) {
        return getWWPString(map, key, "");
    }
    /**
     * 获取WebWork ActionContext中的参数
     * WebWork 中获取到的参数为Map的形式
     * key 是String类型
     * value是String[]类型的
     * 本函数固定取字符数组中的第一个值
     *
     * @param map parameters
     * @param key 要取的参数名称
     * @param defaultValue 缺省值
     * @return
     */
    public static String[] getWWPStringArray(Map map, String key, String[] defaultValue) {
        Object obj = map.get(key);
        if(obj == null)
            return defaultValue;
        else {
            if(obj instanceof String[]) {
                String[] sa = (String[])obj;

                    return sa;
            }
            else
                return defaultValue;
        }
    }
    
    /**
     * 取文件的扩展名
     * @param fileName 文件名 
     */
    public static String getFileExtraName(String fileName) {
		String result = null;
		try {
			int index = fileName.lastIndexOf(".");
			if (index > 0)
				result = fileName.substring(index + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    /**
     * 取文件的文件名（不需要扩展名）
     * @param fileName 文件名 
     */
    public static String getFileName(String fileName) {
		String result = null;
		try {
			int index = fileName.lastIndexOf(".");
			if (index > 0)
				result = fileName.substring(0,index);
			else
				result=fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
    public static String getTelDetail(String voicepath,String context) throws Exception{
    	String result="";
    	if(!isNull(voicepath)){
    	    String webUrl = SysConfigManager.getInstance().getProperty(
		    "/callcenter/modules/module[@id=1]/Parameter[@id=9]/value");
    	    String picUrl = SysConfigManager.getInstance().getProperty(
			"/callcenter/modules/module[@id=1]/Parameter[@id=7]/value");
    	    picUrl+= "/"+ context+ "/images/wav.gif";
			String filter = SysConfigManager
					.getInstance()
					.getProperty(
							"/callcenter/modules/module[@id=1]/Parameter[@id=9]/filter");
			
			String voicePath = voicepath == null ? "" : voicepath.toLowerCase().replaceAll("\\\\", "/");
			String filterVoicePath = voicePath.replace(filter, "");
			result="<a href='"+webUrl + filterVoicePath+"' target='_blank'><img src='"+picUrl+"'/></a>";
    	}
    	return result;
    }
    
    /**
     * 处理多元集成地址
     * @param url
     * @return
     */
    public static String dealEpsUrl(String url){
    	
    	if(url.startsWith("http://")){
    		int index=url.indexOf("//");
    		url = url.substring(index+2);
    		index = url.indexOf("/");
    		url = url.substring(index+1);
    		index = url.indexOf("/");
    		url = "duoyuan:" + url.substring(index);
    	}
    	return url;
    }
    
    /**
     * 计算多元集成子项的图片地址
     * @param preFixUrl
     * @param fileUrl
     * @return
     */
    public static String replaceUrl(String preFixUrl,String fileUrl) {
		try {
			if (fileUrl != null && !"".equals(fileUrl) && fileUrl.startsWith("duoyuan:")) {
				int index = fileUrl.indexOf("duoyuan:");
				fileUrl = preFixUrl + fileUrl.substring(index+8);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}
    
    /**
     * 字符串如果为null时，返回给定的默认值
     * @param str
     * @param defaultStr
     * @return
     */
    public static String nullTransDefault(String str,String defaultStr){
    	if(str==null||str.equalsIgnoreCase("null")){
    		return defaultStr;
    	}else{
    		return str;
    	}
    }
    
    /**
     * 默认值为空的处理
     * @param str
     * @return
     */
    public static String nullTransDefault(String str){
    	return nullTransDefault(str,"");
    }
    
    public static Date getElementDateValue(Element element,String propertyName,String defaultValue) throws Exception{
    	String tmp=getElementStrValue(element,propertyName,defaultValue);
    	Date result=null;
    	if(!ObjectUtil.isEmpty(tmp)){
    		result=DateTimeUtils.toDateTime(tmp);
    	}
    	return result;
    }
    
    public static int getElementIntValue(Element element,String propertyName,String defaultValue) throws Exception{
    	String tmp=getElementStrValue(element,propertyName,defaultValue);
    	return NumberUtil.strToInt(tmp);
    }
    
    public static String getElementStrValue(Element element,String propertyName,String defaultValue) throws Exception{
        Element ele=element.element(propertyName);
    	String value=null;
    	if(ele==null){
    		value=defaultValue;
    	}else{
    		value=nullTransDefault(ele.getText(), defaultValue);
    	}
    	return value;
    }
    
    /**
     * 取文件的文件名（带扩展名）
     * @param fileName 文件名 
     */
    public static String getFileFullName(String fileName) {
		String result = null;
		try {
			int index = fileName.lastIndexOf("/");
			if (index > -1){
				result = fileName.substring(index+1);
			}else{
				index=fileName.lastIndexOf("\\");
				if (index > 0){
					result = fileName.substring(index+1);
				}else{
					result=fileName;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
    /**
     * 转义美元符，正则表达式会有问题
     * @param str
     * @return
     */
    public static String transDollarStr(String str) {
		String sReturn = "";
		if (str != null && !"".equals(str.trim())) {
			if (str.indexOf('$', 0) > -1) {
				while (str.length() > 0) {
					if (str.indexOf('$', 0) > -1) {
						sReturn += str.subSequence(0, str.indexOf('$', 0));
						sReturn += "\\$";
						str = str.substring(str.indexOf('$', 0) + 1,
								str.length());
					} else {
						sReturn += str;
						str = "";
					}
				}
			} else {
				sReturn = str;
			}

		}
		return sReturn;
    }
    
    /**获取路径的前缀路径*/
    public static String getPrefixPath(String path){
    	String result = null;
		try {
			int index = path.lastIndexOf("/");
			if (index > 0)
				result = path.substring(0,index);
			else
				result=path;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }
    
    /**
     * 获取字符串中指定字符后的字符串
     * @param str
     * @param chara
     * @return
     * @throws Exception
     */
    public static String getLaterStrByChar(String str,char chara) throws Exception{
    	String result=null;
    	int index=str.indexOf(chara);
    	result=str.substring(index+1);
    	return result;
    }
    
    /**
     * 获取字符串中最后指定字符后的字符串
     * @param str
     * @param chara
     * @return
     * @throws Exception
     */
    public static String getLastStrByChar(String str,String separator) throws Exception{
    	String result=null;
    	int index=str.lastIndexOf(separator);
    	result=str.substring(index+1);
    	return result;
    }
    
    /**
     * 
     * @param type 0：单页、1：模板、2：组件、3：元素
     * @return
     */
	public static String getResourcePahtByType(int type){
		if(type==0){
			return "/data/danye";
		}else if(type==1){
			return "/data/moban";
		}else if(type==2){
			return "/data/zujian";
		}else if(type==3){
			return "/data/yuansu";
		}
		return "/data/temp";
	}
}
