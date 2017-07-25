package com.ykkj.weiyi.pojo;

/**
 * 用药情况表(PF_MEDICINE_SITUATION)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class MedicineSituationDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -4706467946004150072L;
    
    /** 用药情况表ID  */
    private String msId;
    
    /** 随访表ID */
    private String followId;
    
    /** 药物名称 */
    private String msName;
    
    /** 每日几次 */
    private Integer msCount;
    
    /** 每次多少mg */
    private String msMg;
    
    /** 排序 */
    private Integer msOrders;
    
    /**
     * 获取用药情况表ID 
     * 
     * @return 用药情况表ID 
     */
    public String getMsId() {
        return this.msId;
    }
     
    /**
     * 设置用药情况表ID 
     * 
     * @param msId
     *          用药情况表ID 
     */
    public void setMsId(String msId) {
        this.msId = msId;
    }
    
    /**
     * 获取随访表ID
     * 
     * @return 随访表ID
     */
    public String getFollowId() {
        return this.followId;
    }
     
    /**
     * 设置随访表ID
     * 
     * @param followId
     *          随访表ID
     */
    public void setFollowId(String followId) {
        this.followId = followId;
    }
    
    /**
     * 获取药物名称
     * 
     * @return 药物名称
     */
    public String getMsName() {
        return this.msName;
    }
     
    /**
     * 设置药物名称
     * 
     * @param msName
     *          药物名称
     */
    public void setMsName(String msName) {
        this.msName = msName;
    }
    
    /**
     * 获取每日几次
     * 
     * @return 每日几次
     */
    public Integer getMsCount() {
        return this.msCount;
    }
     
    /**
     * 设置每日几次
     * 
     * @param msCount
     *          每日几次
     */
    public void setMsCount(Integer msCount) {
        this.msCount = msCount;
    }
    
    /**
     * 获取每次多少mg
     * 
     * @return 每次多少mg
     */
    public String getMsMg() {
        return this.msMg;
    }
     
    /**
     * 设置每次多少mg
     * 
     * @param msMg
     *          每次多少mg
     */
    public void setMsMg(String msMg) {
        this.msMg = msMg;
    }
    
    /**
     * 获取排序
     * 
     * @return 排序
     */
    public Integer getMsOrders() {
        return this.msOrders;
    }
     
    /**
     * 设置排序
     * 
     * @param msOrders
     *          排序
     */
    public void setMsOrders(Integer msOrders) {
        this.msOrders = msOrders;
    }
}