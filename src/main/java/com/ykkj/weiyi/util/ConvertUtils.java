package com.ykkj.weiyi.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 转换类型工具类
 *
 * @作者： 张晓东
 * @创建日期： 2015年10月26日
 *
 * @修改记录（修改时间、作者、原因）：
 */
public class ConvertUtils {

	public static int toInt(Object obj) {
		return toInt(obj, 0);
	}

	public static int toInt(Object obj, int defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Integer.parseInt(obj.toString());
	}

	public static long toLong(Object obj) {
		return toLong(obj, 0L);
	}

	public static long toLong(Object obj, long defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Long.parseLong(obj.toString());
	}

	public static float toFloat(Object obj) {
		return toFloat(obj, 0.0f);
	}

	public static float toFloat(Object obj, float defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Float.parseFloat(obj.toString());
	}

	public static double toDouble(Object obj) {
		return toDouble(obj, 0.0d);
	}

	public static double toDouble(Object obj, double defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Double.parseDouble(obj.toString());
	}

	public static Float createFloat(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Float.valueOf(obj.toString());
	}

	public static Double createDouble(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Double.valueOf(obj.toString());
	}

	public static Integer createInteger(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString()) || "null".equals(obj.toString())) {
			return null;
		}
		return Integer.valueOf(obj.toString());
	}

	public static Long createLong(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Long.valueOf(obj.toString());
	}

	public static BigInteger createBigInteger(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return new BigInteger(obj.toString());
	}

	public static BigDecimal createBigDecimal(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return new BigDecimal(obj.toString());
	}

	public static String createString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}
	
	public static Boolean createBoolean(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Boolean.valueOf(obj.toString());
	}
	
	public static JSONArray createJSONArray(Object obj) {
		if (obj == null) {
			return new JSONArray();
		}
		return JSONArray.fromObject(obj);
	}
	
	public static JSONObject createJSONObject(Object obj) {
		if (obj == null) {
			return new JSONObject();
		}
		return JSONObject.fromObject(obj);
	}

	public static Number min(Number... array) {
		Number min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i].doubleValue() < min.doubleValue()) {
				min = array[i];
			}
		}
		return min;
	}

	public static Number max(Number... array) {
		Number max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (array[j].doubleValue() > max.doubleValue()) {
				max = array[j];
			}
		}
		return max;
	}

	/**
	 * Long转换为日期date
	 */
	public static Calendar string2Date(String format, Long value) throws ParseException {
		Date date = new SimpleDateFormat(format).parse(String.valueOf(value));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * 功能描述：把List<Map>的某个Key转换成SQL语句中in格式的字符串<BR>
	 * @param list 
	 * @param key Map的某个Key
	 * @return 形如：('1','2','3'),如果为空返回('');
	 */
	public static String list2SqlInString(List<Map> list,String key) {
		if (list != null && list.size() > 0) {
			StringBuffer inString = new StringBuffer(" ");
			for (Map map : list) {
				if (map.containsKey(key)) {
					inString.append("'");
					inString.append(map.get(key) == null ? "" : map.get(key).toString());
					inString.append("',");
				} else {
					new RuntimeException("not contains key " + key);
				}
			}
			String in = inString.toString();
			in = StringUtils.equals(in, "") ? "''" : (in.endsWith(",") ? StringUtils.removeEnd(in, ",") : in);
			return "(" + in + ")";
		}
		return "(' ')";
	}
	
	public static void main(String[] args) {
		List<Map> list = new ArrayList<Map>();
		Map map = new HashMap();
		map.put("bxh","1");
		Map map2 = new HashMap();
		map2.put("bxh","2");
		Map map3 = new HashMap();
		map3.put("bxh","3");
		
		list.add(map);
		list.add(map3);
		list.add(map2);
		String nm="08";
		System.out.println("---"+Integer.valueOf(nm));
		
	}

}
