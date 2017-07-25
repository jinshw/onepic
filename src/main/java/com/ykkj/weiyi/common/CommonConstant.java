package com.ykkj.weiyi.common;


/**
 * @文件名： CommonConstant.java
 * @功能: 常量记录
 * @描述: 定义和规范返回JSON时的Code码
 * @创建人： sunzhilei
 * @创建时间： 2015年4月10日,下午6:19:36
 * @修改人:
 * @修改时间: <修改时间>
 * @修改内容: <修改内容>
 * @版本： v1.0
 */
public abstract class CommonConstant {
	//操作状态码
	public static final String OPERATE_SUCCESS = "200"; // 默认成功
	public static final String OPERATE_FAILED = "500"; // 失败码
	
	//操作确认吗(1是2否)
	public static final Integer OPERATE_YES = 1; // 是
	public static final Integer OPERATE_NO = 2; // 否
	//栏目类型
	public static final Integer CHANNEL_TYPE_PT = 1; //普通栏目
	public static final Integer CHANNEL_TYPE_XN = 2; //虚拟栏目
	//模板类型:1列表2详情3特殊
	public static final Integer TCMSTPL_TYPE_LIST = 1; //列表
	public static final Integer TCMSTPL_TYPE_DETAIL = 2; //详情
	public static final Integer TCMSTPL_TYPE_SPECIAL = 3; // 特殊
	//发布平台：pc,h5,xml,json
	public static final String TCMSTPL_PLATFORM_PC = "pc"; //pc
	public static final String TCMSTPL_PLATFORM_H5 = "h5"; //h5
	public static final String TCMSTPL_PLATFORM_XML = "xml"; // xml
	public static final String TCMSTPL_PLATFORM_JSON = "json"; // json
	//内容类型1文章2图片3文件4视频5音频6专题
	public static final Integer TCMSTPL_CONTENTTYPE_ARTICLE = 1; //文章
	public static final Integer TCMSTPL_CONTENTTYPE_PIC = 2; //图片
	public static final Integer TCMSTPL_CONTENTTYPE_FILE = 3; // 文件
	public static final Integer TCMSTPL_CONTENTTYPE_VIDEO = 4; //视频
	public static final Integer TCMSTPL_CONTENTTYPE_VOICE = 5; //音频
	public static final Integer TCMSTPL_CONTENTTYPE_ZT = 6; // 专题
	//是否默认，1表示站点默认模板
	public static final Integer TCMSTPL_ISDEFAULT_YES = 1; //是
	
	public static class Static{
		public static final String PATH_PUBLISH_BEFORE = "/preview";//发布前资源路径前缀
		public static final String PATH_PUBLISH_AFTER = "/root";//发布后资源路径前缀
		public static final String PATH_TELPLATE = "/template";//模板存放相对路径
		public static final String PATH_UPLOAD = "/upload";//静态文件存放相对路径
		public static final String PATH_PAGES = "/pages";//页面存放相对路径
		public static final String SUFFIX_STATIC = ".html";//生成静态文件后缀
		public static final String PUBLICTPL_PATH = "/publictpl";
		
		/**急稿消息类型*/
	    public final static int MESSAGETYPE_URGENT=10;
	    /**普通发布类型*/
	    public final static int MESSAGEPRI_NORMAL=4;
	    /**其它发布类型（包括大发布操作、定时发布操作）*/
	    public final static int MESSAGEPRI_OTHER=1;
	    
	    /**memcached消息存取标识*/
	    public final static int MEMCACHED_PATTERN=1;
	    /**xml 文件消息存取标识*/
	    public final static int XMLFILE_PATTERN=2;
	    
	    /**预览标识*/
	    public final static int STATIC_TYPE_PREVIEW=0;
	    /**发布标识*/
	    public final static int STATIC_TYPE_PUBLISH=1;
	    /**下线标识*/
	    public final static int STATIC_TYPE_UNPUBLISH=2;
	}
}
