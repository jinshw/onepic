package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 居民健康档案表(PF_HEALTH_RECORDS)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class HealthRecordsDTO implements java.io.Serializable {

    /** 具名健康档案表ID */
    private String hrId;
    
    /** 居民身份证号 */
    private String idCard;
    
    /** 姓名 */
    private String hrName;
    
    /** 现住址 */
    private String addressNow;
    
    /** 户籍住址 */
    private String addressRegister;
    
    /** 联系电话 */
    private String telphone;
    
    /** 乡镇（街道）名称 */
    private String townName;
    
    /** 村（居）委会名称 */
    private String villageName;
    
    /** 建档单位 */
    private String createUnit;
    
    /** 建档人 */
    private String createPerson;
    
    /** 责任医生 */
    private String liabilityDoctor;
    
    /** 建档日期 */
    
    private Date createDate;
    
    /**
     * 获取具名健康档案表ID
     * 
     * @return 具名健康档案表ID
     */
    public String getHrId() {
        return this.hrId;
    }
     
    /**
     * 设置具名健康档案表ID
     * 
     * @param hrId
     *          具名健康档案表ID
     */
    public void setHrId(String hrId) {
        this.hrId = hrId;
    }
    
    /**
     * 获取ID
     * 
     * @return 居民身份证号
     */
    public String getIdCard() {
        return this.idCard;
    }
     
    /**
     * 设置ID
     * 
     * @param patientId
     *          居民身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    /**
     * 获取姓名
     * 
     * @return 姓名
     */
    public String getHrName() {
        return this.hrName;
    }
     
    /**
     * 设置姓名
     * 
     * @param hrName
     *          姓名
     */
    public void setHrName(String hrName) {
        this.hrName = hrName;
    }
    
    /**
     * 获取现住址
     * 
     * @return 现住址
     */
    public String getAddressNow() {
        return this.addressNow;
    }
     
    /**
     * 设置现住址
     * 
     * @param addressNow
     *          现住址
     */
    public void setAddressNow(String addressNow) {
        this.addressNow = addressNow;
    }
    
    /**
     * 获取户籍住址
     * 
     * @return 户籍住址
     */
    public String getAddressRegister() {
        return this.addressRegister;
    }
     
    /**
     * 设置户籍住址
     * 
     * @param addressRegister
     *          户籍住址
     */
    public void setAddressRegister(String addressRegister) {
        this.addressRegister = addressRegister;
    }
    
    /**
     * 获取联系电话
     * 
     * @return 联系电话
     */
    public String getTelphone() {
        return this.telphone;
    }
     
    /**
     * 设置联系电话
     * 
     * @param telphone
     *          联系电话
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    
    /**
     * 获取乡镇（街道）名称
     * 
     * @return 乡镇（街道）名称
     */
    public String getTownName() {
        return this.townName;
    }
     
    /**
     * 设置乡镇（街道）名称
     * 
     * @param townName
     *          乡镇（街道）名称
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }
    
    /**
     * 获取村（居）委会名称
     * 
     * @return 村（居）委会名称
     */
    public String getVillageName() {
        return this.villageName;
    }
     
    /**
     * 设置村（居）委会名称
     * 
     * @param villageName
     *          村（居）委会名称
     */
    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
    
    /**
     * 获取建档单位
     * 
     * @return 建档单位
     */
    public String getCreateUnit() {
        return this.createUnit;
    }
     
    /**
     * 设置建档单位
     * 
     * @param createUnit
     *          建档单位
     */
    public void setCreateUnit(String createUnit) {
        this.createUnit = createUnit;
    }
    
    /**
     * 获取建档人
     * 
     * @return 建档人
     */
    public String getCreatePerson() {
        return this.createPerson;
    }
     
    /**
     * 设置建档人
     * 
     * @param createPerson
     *          建档人
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
    
    /**
     * 获取责任医生
     * 
     * @return 责任医生
     */
    public String getLiabilityDoctor() {
        return this.liabilityDoctor;
    }
     
    /**
     * 设置责任医生
     * 
     * @param liabilityDoctor
     *          责任医生
     */
    public void setLiabilityDoctor(String liabilityDoctor) {
        this.liabilityDoctor = liabilityDoctor;
    }
    
    /**
     * 获取建档日期
     * 
     * @return 建档日期
     */
    public Date getCreateDate() {
        return this.createDate;
    }
     
    /**
     * 设置建档日期
     * 
     * @param createDate
     *          建档日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}