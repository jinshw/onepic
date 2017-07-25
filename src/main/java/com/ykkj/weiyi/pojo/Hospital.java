package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

/**
 * Created by jinshw on 2016/7/27.
 */
public class Hospital {
    // 医院ID
    private String hospitalId;
    //医院编码
    private String hospitalCode;
    //医院名称
    private String hospitalName;
    // 租户ID
    //private String tenantId;
    // 父节点ID
    private String parentId;
    // 与HIS系统约定的KEY值
    private String key;
    // 长编码
    private String longCode;
    //最后修改时间
    private Timestamp modifyTime;
    //最后修改人
    private String modifyPerson;
    //医院等级
    private String hospGrade;
    //医院地址
    private String hospAddress;
    //省
    private String province;
    //市
    private String city;
    //县/区
    private String county;
    //机构类型：1卫生局 2
    private Integer hospType;
    //法人
    private String legal;
    //邮编
    private String zipCode;
    //联系电话
    private String telephone;
    //简介
    private String brief;
    //经度
    private Float longitude;
    //纬度
    private Float latitude;
    //Logo图
    private String logoImg;
    //是否调用HIS接口:默认0：未开通，1调用HIS，2 调用平台本地
    private Integer connHis;


    public String getHospGrade() {
        return hospGrade;
    }

    public void setHospGrade(String hospGrade) {
        this.hospGrade = hospGrade;
    }

    public String getHospAddress() {
        return hospAddress;
    }

    public void setHospAddress(String hospAddress) {
        this.hospAddress = hospAddress;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

   /* public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }*/

    public String getParentId() {
        return parentId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }


    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getHospType() {
        return hospType;
    }

    public void setHospType(Integer hospType) {
        this.hospType = hospType;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLongCode() {
        return longCode;
    }

    public void setLongCode(String longCode) {
        this.longCode = longCode;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    public Integer getConnHis() {
        return connHis;
    }

    public void setConnHis(Integer connHis) {
        this.connHis = connHis;
    }

}
