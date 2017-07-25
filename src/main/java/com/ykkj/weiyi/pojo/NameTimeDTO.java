package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 既往史名称时间表(PF_NAME_TIME)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class NameTimeDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5747286918757581023L;
    
    /** 既往史名称和时间ID */
    private String ntId;
    
    /** 个人信息主键ID */
    private String piId;
    
    /** 名称/原因 */
    private String ntName;
    
    /** 时间 */
    
    private Date ntTime;
    
    /** 类型：1 手术 2 外伤 3 输血 */
    private Integer type;
    
    /** 顺序 */
    private Integer ntOrders;
    
    /**
     * 获取既往史名称和时间ID
     * 
     * @return 既往史名称和时间ID
     */
    public String getNtId() {
        return this.ntId;
    }
     
    /**
     * 设置既往史名称和时间ID
     * 
     * @param ntId
     *          既往史名称和时间ID
     */
    public void setNtId(String ntId) {
        this.ntId = ntId;
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
     * 获取名称/原因
     * 
     * @return 名称/原因
     */
    public String getNtName() {
        return this.ntName;
    }
     
    /**
     * 设置名称/原因
     * 
     * @param ntName
     *          名称/原因
     */
    public void setNtName(String ntName) {
        this.ntName = ntName;
    }
    
    /**
     * 获取时间
     * 
     * @return 时间
     */
    public Date getNtTime() {
        return this.ntTime;
    }
     
    /**
     * 设置时间
     * 
     * @param ntTime
     *          时间
     */
    public void setNtTime(Date ntTime) {
        this.ntTime = ntTime;
    }
    
    /**
     * 获取类型：1 手术 2 外伤 3 输血
     * 
     * @return 类型
     */
    public Integer getType() {
        return this.type;
    }
     
    /**
     * 设置类型：1 手术 2 外伤 3 输血
     * 
     * @param type
     *          类型：1 手术 2 外伤 3 输血
     */
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * 获取顺序
     * 
     * @return 顺序
     */
    public Integer getNtOrders() {
        return this.ntOrders;
    }
     
    /**
     * 设置顺序
     * 
     * @param ntOrders
     *          顺序
     */
    public void setNtOrders(Integer ntOrders) {
        this.ntOrders = ntOrders;
    }
}