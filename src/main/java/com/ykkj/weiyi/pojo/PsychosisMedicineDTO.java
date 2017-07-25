package com.ykkj.weiyi.pojo;

/**
 * 精神障碍药物管理(PF_PSYCHOSIS_MEDICINE)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class PsychosisMedicineDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7409929017914646751L;
    
    /** 精神障碍药物管理表ID */
    private String pmId;
    
    /** 精神障碍表ID */
    private String fpId;
    
    /** 药物名称 */
    private String pmName;
    
    /** 早晨用量mg */
    private String morning;
    
    /** 中午用量mg */
    private String noon;
    
    /** 晚上用量mg */
    private String night;
    
    /** 排序值 */
    private Integer pmOrders;
    
    /**
     * 获取精神障碍药物管理表ID
     * 
     * @return 精神障碍药物管理表ID
     */
    public String getPmId() {
        return this.pmId;
    }
     
    /**
     * 设置精神障碍药物管理表ID
     * 
     * @param pmId
     *          精神障碍药物管理表ID
     */
    public void setPmId(String pmId) {
        this.pmId = pmId;
    }
    
    /**
     * 获取精神障碍表ID
     * 
     * @return 精神障碍表ID
     */
    public String getFpId() {
        return this.fpId;
    }
     
    /**
     * 设置精神障碍表ID
     * 
     * @param fpId
     *          精神障碍表ID
     */
    public void setFpId(String fpId) {
        this.fpId = fpId;
    }
    
    /**
     * 获取药物名称
     * 
     * @return 药物名称
     */
    public String getPmName() {
        return this.pmName;
    }
     
    /**
     * 设置药物名称
     * 
     * @param pmName
     *          药物名称
     */
    public void setPmName(String pmName) {
        this.pmName = pmName;
    }
    
    /**
     * 获取早晨用量mg
     * 
     * @return 早晨用量mg
     */
    public String getMorning() {
        return this.morning;
    }
     
    /**
     * 设置早晨用量mg
     * 
     * @param morning
     *          早晨用量mg
     */
    public void setMorning(String morning) {
        this.morning = morning;
    }
    
    /**
     * 获取中午用量mg
     * 
     * @return 中午用量mg
     */
    public String getNoon() {
        return this.noon;
    }
     
    /**
     * 设置中午用量mg
     * 
     * @param noon
     *          中午用量mg
     */
    public void setNoon(String noon) {
        this.noon = noon;
    }
    
    /**
     * 获取晚上用量mg
     * 
     * @return 晚上用量mg
     */
    public String getNight() {
        return this.night;
    }
     
    /**
     * 设置晚上用量mg
     * 
     * @param night
     *          晚上用量mg
     */
    public void setNight(String night) {
        this.night = night;
    }
    
    /**
     * 获取排序值
     * 
     * @return 排序值
     */
    public Integer getPmOrders() {
        return this.pmOrders;
    }
     
    /**
     * 设置排序值
     * 
     * @param pmOrders
     *          排序值
     */
    public void setPmOrders(Integer pmOrders) {
        this.pmOrders = pmOrders;
    }
}