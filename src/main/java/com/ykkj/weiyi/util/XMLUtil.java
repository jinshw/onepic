package com.ykkj.weiyi.util;

import org.apache.commons.lang.StringUtils;

public class XMLUtil {

	public static String getValueFromReturnXML(String source, String key) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		int be = source.indexOf(key);
		if (be == -1)
			return null;
		int en = source.lastIndexOf("/" + key);
		source = source.substring(be + key.length() + 1, en - 1);
		return source;
	}
	
	public static void main(String[] args) {
		String a = "<BRID>3846624</BRID><MZH>1604211504</MZH>";
		String value = getValueFromReturnXML(a, "MZH");
		System.out.println(value);
	}
}
