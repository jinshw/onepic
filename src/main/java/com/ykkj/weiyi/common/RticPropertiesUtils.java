package com.ykkj.weiyi.common;

import java.util.ResourceBundle;

/**
 * 实时路况静态配置类
 */
public class RticPropertiesUtils
{
    // 获取静态配置文件
    static ResourceBundle rtic = ResourceBundle.getBundle("rtic");
    // 访问路径前半部分
    public static final String AREA_CODES = rtic.getString("areaCodes");
    public static final String ROAD_KIND = rtic.getString("roadKind");
    public static final String RTIC_URL = rtic.getString("rticUrl");
}
