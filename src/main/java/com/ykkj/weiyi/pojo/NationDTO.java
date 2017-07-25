package com.ykkj.weiyi.pojo;

/**
 * 民族字典表(PF_NATION)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class NationDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7568777721430355630L;
    
    /** 民族ID */
    private String nId;
    
    /** 民族名称 */
    private String nName;
    
    /** 排序值 */
    private Integer nOrder;
    
    /**
     * 获取民族ID
     * 
     * @return 民族ID
     */
    public String getNId() {
        return this.nId;
    }
     
    /**
     * 设置民族ID
     * 
     * @param nId
     *          民族ID
     */
    public void setNId(String nId) {
        this.nId = nId;
    }
    
    /**
     * 获取民族名称
     * 
     * @return 民族名称
     */
    public String getNName() {
        return this.nName;
    }
     
    /**
     * 设置民族名称
     * 
     * @param nName
     *          民族名称
     */
    public void setNName(String nName) {
        this.nName = nName;
    }
    
    /**
     * 获取排序值
     * 
     * @return 排序值
     */
    public Integer getNOrder() {
        return this.nOrder;
    }
     
    /**
     * 设置排序值
     * 
     * @param nOrder
     *          排序值
     */
    public void setNOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }
}