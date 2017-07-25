package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 疾病(PF_SICKNESS)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class SicknessDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3461084166447467511L;
    
    /** 疾病ID */
    private String snId;
    
    /** 个人信息主键ID */
    private String piId;
    
    /**  2高血压   3糖尿病   4冠心病   5慢性阻塞性肺疾病 　6恶性肿瘤   7脑卒中  8重性精神疾病　9结核病  10肝炎  11其他法定传染病 12职业病13其他 */
    private String snName;
    
    /** 确诊时间 */
    
    private Date diagnoseTime;
    
    /** 疾病详情*/
    
    private String content;
    
    /**
     * 获取疾病ID
     * 
     * @return 疾病ID
     */
    public String getSnId() {
        return this.snId;
    }
     
    /**
     * 设置疾病ID
     * 
     * @param snId
     *          疾病ID
     */
    public void setSnId(String snId) {
        this.snId = snId;
    }
    
    /**
     * 获取个人信息主键ID
     * 
     * @return 个人信息主键ID
     */
    public String getPiId() {
        return this.piId;
    }
     
    /**
     * 设置个人信息主键ID
     * 
     * @param piId
     *          个人信息主键ID
     */
    public void setPiId(String piId) {
        this.piId = piId;
    }
    
    /**
     * 获取 2高血压   3糖尿病   4冠心病   5慢性阻塞性肺疾病 　6恶性肿瘤   7脑卒中  8重性精神疾病　9结核病  10肝炎  11其他法定传染病 12职业病13其他
     * 
     * @return  2高血压   3糖尿病   4冠心病   5慢性阻塞性肺疾病 　6恶性肿瘤   7脑卒中  8重性精神疾病　9结核病  10肝炎  11其他法定传染病 12职业病13其他
     */
    public String getSnName() {
        return this.snName;
    }
     
    /**
     * 设置 2高血压   3糖尿病   4冠心病   5慢性阻塞性肺疾病 　6恶性肿瘤   7脑卒中  8重性精神疾病　9结核病  10肝炎  11其他法定传染病 12职业病13其他
     * 
     * @param snName
     *           2高血压   3糖尿病   4冠心病   5慢性阻塞性肺疾病 　6恶性肿瘤   7脑卒中  8重性精神疾病　9结核病  10肝炎  11其他法定传染病 12职业病13其他
     */
    public void setSnName(String snName) {
        this.snName = snName;
    }
    
    /**
     * 获取确诊时间
     * 
     * @return 确诊时间
     */
    public Date getDiagnoseTime() {
        return this.diagnoseTime;
    }
     
    /**
     * 设置确诊时间
     * 
     * @param diagnoseTime
     *          确诊时间
     */
    public void setDiagnoseTime(Date diagnoseTime) {
        this.diagnoseTime = diagnoseTime;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}