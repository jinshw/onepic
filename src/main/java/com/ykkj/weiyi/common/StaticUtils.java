package com.ykkj.weiyi.common;

import java.util.ResourceBundle;

/**
 * 静态常量类
 *
 * @作者: 张晓东 @创建日期： 2015年12月19日
 *
 * @修改记录（修改时间、作者、原因）：
 */
public class StaticUtils {
	// 获取静态配置文件
	static ResourceBundle bundle = ResourceBundle.getBundle("static");
	// 访问路径前半部分
	public static final String URL_PATH = bundle.getString("url_path");// http://localhost:8080/cms

}
