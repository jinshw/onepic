package com.ykkj.weiyi.common;

import java.util.ResourceBundle;

/**
 * 静态常量类
 *
 * @作者: 张晓东 @创建日期： 2015年12月19日
 * @修改记录（修改时间、作者、原因）：
 */
public class StaticUtils {
    // 获取静态配置文件
    static ResourceBundle rb = ResourceBundle.getBundle("static");
    // 访问路径前半部分
    public static final String URL_PATH = rb.getString("url_path");// http://localhost:8080/cms
    public static final String HD_GETPROJECTINFO = rb
            .getString("hd_getProjectInfo");
    public static final String HD_GETDIRECTINFO = rb
            .getString("hd_getDirectInfo");
    public static final String HD_GETSUPERVISIONINFO = rb
            .getString("hd_getSupervisionInfo");
    public static final String HD_GETSECTINFO = rb.getString("hd_getSectInfo");
    public static final String HD_DELETETINFO = rb.getString("hd_deleteInfo");
    public static final String HD_PMSISSUEINFO = rb
            .getString("hd_pmsIssueInfo");
    public static final String HD_PMSQINGDANJILIANGMAIN = rb
            .getString("hd_pmsQingdanJiliangMain");
    public static final String HD_PMSQINGDANJILIANG = rb
            .getString("hd_pmsQingdanJiliang");
    public static final String HD_PMSCOMPACTLISTING = rb
            .getString("hd_pmsComPactListing");
    public static final String HD_JDPZINFO = rb.getString("hd_jdpzinfo");
    public static final String HD_PMSPLANINPUTZB = rb
            .getString("hd_pmsPlaninputZb");
    public static final String HD_PMSPLANTZKZ01INFO = rb
            .getString("hd_pmsPlanTzkz01Info");
    public static final String HD_PMSPLANTZKZ02INFO = rb
            .getString("hd_pmsPlanTzkz02Info");

    // email配置
    public static final String emailHost = rb.getString("email_host");
    public static final int emailPort = Integer.valueOf(rb.getString("email_port"));
    public static final String emailUsername = rb.getString("email_username");
    public static final String emailPassword = rb.getString("email_password");
    public static final String emailTo = rb.getString("email_to");

}
