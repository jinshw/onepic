package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 个人信息表(PF_PERSON_INFO)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class PersonInfoDTO implements java.io.Serializable {

    /** 个人信息主键ID */
    private String piId;
    
    /** 姓名 */
    private String name;
    
    /** 编号 */
    private String code;
    
    /** 性别 */
    private Integer sex;
    
    /** 出生日期 */
    
    private Date birthday;
    
    /** 身份证号 */
    private String idCode;
    
    /** 工作单位 */
    private String piUnit;
    
    /** 本人电话 */
    private String piTelphone;
    
    /** 联系人姓名 */
    private String contactName;
    
    /** 联系人电话 */
    private String contactTel;
    
    /** 常住类型:1、户籍   2、非户籍 */
    private Integer residentType;
    
    /** 民族:1、汉族  2、少数民族 */
    private String nation;
    
    /** 血型:1 A型   2 B型   3 O型   4 AB型  5不详 */
    private Integer bloodType;
    
    /** RH阴性:1否  2是  3不详  */
    private Integer bloodRh;
    
    /** 文化程度:1文盲及半文盲  2小学  3初中  4高中/技校/中专  5大学专科及以上  6不详 
             */
    private Integer culturalDegree;
    
    /** 职业：1国家机关、党群组织、企业、事业单位负责人 2专业技术人员 3办事人员和有关人员  4商业、服务业人员  5 农、林、牧、渔、水利业生产人员  6生产、运输设备操作人员及有关人员  7军人  8不便分类的其他从业人员 */
    private Integer profession;
    
    /** 婚姻状况：1未婚  2 已婚  3丧偶  4离婚  5未说明的婚姻状况 */
    private Integer marriageStatus;
    
    /** 医疗费用支付方式:1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗 
            4贫困救助  5商业医疗保险   6全公费  7全自费  8其他  */
    private String paymentType;
    
    /** 其他支付方式 */
    private String paymentOther;
    
    /** 药物过敏史:1无   有 2青霉素  3磺胺   4链霉素   5其他 */
    private Integer allergy;
    
    /** 其他药物过敏史 */
    private String allergyOther;
    
    /** 暴露史 :1无   有：2化学品    3毒物    4射线 */
    private Integer exposeHistory;
    
    /** 其他暴露史 */
    private String exposeHistoryList;
    
    /** 疾病:1 无 0 有 */
    private Integer sickness;
    
    /** 手术：1 无 2 有 */
    private Integer operation;
    
    /** 外伤：1无   2有 */
    private Integer wound;
    
    /** 输血：1无   2有 */
    private Integer bloodTran;
    
    /** 遗传病史:1 无 2 有 */
    private Integer geneticHistory;
    
    /** 遗传病名称 */
    private String geneticSickness;
    
    /** 残疾情况 */
    private String disable;
    
    /** 其他残疾情况 */
    private String disableOther;
    
    /** 厨房排风设施:1无       2油烟机   3换气扇   4烟囱 */
    private Integer kitchen;
    
    /** 燃料类型:1液化气   2煤       3天然气   4沼气   5柴火  6其他 */
    private Integer fuelType;
    
    /** 饮水:1自来水   2经净化过滤的水   3井水  4河湖水  5塘水 6其他 */
    private Integer water;
    
    /** 厕所:1卫生厕所 2一格或二格粪池式 3马桶  4露天粪坑  5简易棚厕 */
    private Integer toilet;
    
    /** 禽畜栏:1单设     2室内     3室外 */
    private Integer corral;
    
    /** json数据保存*/
    private String jsonobj;
    
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
     * 获取姓名
     * 
     * @return 姓名
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置姓名
     * 
     * @param name
     *          姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取编号
     * 
     * @return 编号
     */
    public String getCode() {
        return this.code;
    }
     
    /**
     * 设置编号
     * 
     * @param code
     *          编号
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * 获取性别
     * 
     * @return 性别
     */
    public Integer getSex() {
        return this.sex;
    }
     
    /**
     * 设置性别
     * 
     * @param sex
     *          性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    /**
     * 获取出生日期
     * 
     * @return 出生日期
     */
    public Date getBirthday() {
        return this.birthday;
    }
     
    /**
     * 设置出生日期
     * 
     * @param birthday
     *          出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    /**
     * 获取身份证号
     * 
     * @return 身份证号
     */
    public String getIdCode() {
        return this.idCode;
    }
     
    /**
     * 设置身份证号
     * 
     * @param idCode
     *          身份证号
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
    
    /**
     * 获取工作单位
     * 
     * @return 工作单位
     */
    public String getPiUnit() {
        return this.piUnit;
    }
     
    /**
     * 设置工作单位
     * 
     * @param piUnit
     *          工作单位
     */
    public void setPiUnit(String piUnit) {
        this.piUnit = piUnit;
    }
    
    /**
     * 获取本人电话
     * 
     * @return 本人电话
     */
    public String getPiTelphone() {
        return this.piTelphone;
    }
     
    /**
     * 设置本人电话
     * 
     * @param piTelphone
     *          本人电话
     */
    public void setPiTelphone(String piTelphone) {
        this.piTelphone = piTelphone;
    }
    
    /**
     * 获取联系人姓名
     * 
     * @return 联系人姓名
     */
    public String getContactName() {
        return this.contactName;
    }
     
    /**
     * 设置联系人姓名
     * 
     * @param contactName
     *          联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    /**
     * 获取联系人电话
     * 
     * @return 联系人电话
     */
    public String getContactTel() {
        return this.contactTel;
    }
     
    /**
     * 设置联系人电话
     * 
     * @param contactTel
     *          联系人电话
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }
    
    /**
     * 获取常住类型:1、户籍   2、非户籍
     * 
     * @return 常住类型
     */
    public Integer getResidentType() {
        return this.residentType;
    }
     
    /**
     * 设置常住类型:1、户籍   2、非户籍
     * 
     * @param residentType
     *          常住类型:1、户籍   2、非户籍
     */
    public void setResidentType(Integer residentType) {
        this.residentType = residentType;
    }
    
    /**
     * 获取民族:1、汉族  2、少数民族
     * 
     * @return 民族
     */
    public String getNation() {
        return this.nation;
    }
     
    /**
     * 设置民族:1、汉族  2、少数民族
     * 
     * @param nation
     *          民族:1、汉族  2、少数民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    /**
     * 获取血型:1 A型   2 B型   3 O型   4 AB型  5不详
     * 
     * @return 血型
     */
    public Integer getBloodType() {
        return this.bloodType;
    }
     
    /**
     * 设置血型:1 A型   2 B型   3 O型   4 AB型  5不详
     * 
     * @param bloodType
     *          血型:1 A型   2 B型   3 O型   4 AB型  5不详
     */
    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }
    
    /**
     * 获取RH阴性:1否  2是  3不详 
     * 
     * @return RH阴性
     */
    public Integer getBloodRh() {
        return this.bloodRh;
    }
     
    /**
     * 设置RH阴性:1否  2是  3不详 
     * 
     * @param bloodRh
     *          RH阴性:1否  2是  3不详 
     */
    public void setBloodRh(Integer bloodRh) {
        this.bloodRh = bloodRh;
    }
    
    /**
     * 获取文化程度:1文盲及半文盲  2小学  3初中  4高中/技校/中专  5大学专科及以上  6不详 
            
     * 
     * @return 文化程度
     */
    public Integer getCulturalDegree() {
        return this.culturalDegree;
    }
     
    /**
     * 设置文化程度:1文盲及半文盲  2小学  3初中  4高中/技校/中专  5大学专科及以上  6不详 
            
     * 
     * @param culturalDegree
     *          文化程度:1文盲及半文盲  2小学  3初中  4高中/技校/中专  5大学专科及以上  6不详 
            
     */
    public void setCulturalDegree(Integer culturalDegree) {
        this.culturalDegree = culturalDegree;
    }
    
    /**
     * 获取职业：1国家机关、党群组织、企业、事业单位负责人 2专业技术人员 3办事人员和有关人员  4商业、服务业人员  5 农、林、牧、渔、水利业生产人员  6生产、运输设备操作人员及有关人员  7军人  8不便分类的其他从业人员
     * 
     * @return 职业
     */
    public Integer getProfession() {
        return this.profession;
    }
     
    /**
     * 设置职业：1国家机关、党群组织、企业、事业单位负责人 2专业技术人员 3办事人员和有关人员  4商业、服务业人员  5 农、林、牧、渔、水利业生产人员  6生产、运输设备操作人员及有关人员  7军人  8不便分类的其他从业人员
     * 
     * @param profession
     *          职业：1国家机关、党群组织、企业、事业单位负责人 2专业技术人员 3办事人员和有关人员  4商业、服务业人员  5 农、林、牧、渔、水利业生产人员  6生产、运输设备操作人员及有关人员  7军人  8不便分类的其他从业人员
     */
    public void setProfession(Integer profession) {
        this.profession = profession;
    }
    
    /**
     * 获取婚姻状况：1未婚  2 已婚  3丧偶  4离婚  5未说明的婚姻状况
     * 
     * @return 婚姻状况
     */
    public Integer getMarriageStatus() {
        return this.marriageStatus;
    }
     
    /**
     * 设置婚姻状况：1未婚  2 已婚  3丧偶  4离婚  5未说明的婚姻状况
     * 
     * @param marriageStatus
     *          婚姻状况：1未婚  2 已婚  3丧偶  4离婚  5未说明的婚姻状况
     */
    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }
    
    /**
     * 获取医疗费用支付方式:1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗 
            4贫困救助  5商业医疗保险   6全公费  7全自费  8其他 
     * 
     * @return 医疗费用支付方式
     */
    public String getPaymentType() {
        return this.paymentType;
    }
     
    /**
     * 设置医疗费用支付方式:1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗 
            4贫困救助  5商业医疗保险   6全公费  7全自费  8其他 
     * 
     * @param paymentType
     *          医疗费用支付方式:1城镇职工基本医疗保险  2城镇居民基本医疗保险  3新型农村合作医疗 
            4贫困救助  5商业医疗保险   6全公费  7全自费  8其他 
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    /**
     * 获取其他支付方式
     * 
     * @return 其他支付方式
     */
    public String getPaymentOther() {
        return this.paymentOther;
    }
     
    /**
     * 设置其他支付方式
     * 
     * @param paymentOther
     *          其他支付方式
     */
    public void setPaymentOther(String paymentOther) {
        this.paymentOther = paymentOther;
    }
    
    /**
     * 获取药物过敏史:1无   有 2青霉素  3磺胺   4链霉素   5其他
     * 
     * @return 药物过敏史
     */
    public Integer getAllergy() {
        return this.allergy;
    }
     
    /**
     * 设置药物过敏史:1无   有 2青霉素  3磺胺   4链霉素   5其他
     * 
     * @param allergy
     *          药物过敏史:1无   有 2青霉素  3磺胺   4链霉素   5其他
     */
    public void setAllergy(Integer allergy) {
        this.allergy = allergy;
    }
    
    /**
     * 获取其他药物过敏史
     * 
     * @return 其他药物过敏史
     */
    public String getAllergyOther() {
        return this.allergyOther;
    }
     
    /**
     * 设置其他药物过敏史
     * 
     * @param allergyOther
     *          其他药物过敏史
     */
    public void setAllergyOther(String allergyOther) {
        this.allergyOther = allergyOther;
    }
    
    /**
     * 获取暴露史 :1无   有：2化学品    3毒物    4射线
     * 
     * @return 暴露史 :1无   有
     */
    public Integer getExposeHistory() {
        return this.exposeHistory;
    }
     
    /**
     * 设置暴露史 :1无   有：2化学品    3毒物    4射线
     * 
     * @param exposeHistory
     *          暴露史 :1无   有：2化学品    3毒物    4射线
     */
    public void setExposeHistory(Integer exposeHistory) {
        this.exposeHistory = exposeHistory;
    }
    
    public String getExposeHistoryList() {
		return exposeHistoryList;
	}

	public void setExposeHistoryList(String exposeHistoryList) {
		this.exposeHistoryList = exposeHistoryList;
	}

	/**
     * 获取疾病:1 无 0 有
     * 
     * @return 疾病
     */
    public Integer getSickness() {
        return this.sickness;
    }
     
    /**
     * 设置疾病:1 无 0 有
     * 
     * @param sickness
     *          疾病:1 无 0 有
     */
    public void setSickness(Integer sickness) {
        this.sickness = sickness;
    }
    
    /**
     * 获取手术：1 无 2 有
     * 
     * @return 手术
     */
    public Integer getOperation() {
        return this.operation;
    }
     
    /**
     * 设置手术：1 无 2 有
     * 
     * @param operation
     *          手术：1 无 2 有
     */
    public void setOperation(Integer operation) {
        this.operation = operation;
    }
    
    /**
     * 获取外伤：1无   2有
     * 
     * @return 外伤
     */
    public Integer getWound() {
        return this.wound;
    }
     
    /**
     * 设置外伤：1无   2有
     * 
     * @param wound
     *          外伤：1无   2有
     */
    public void setWound(Integer wound) {
        this.wound = wound;
    }
    
    /**
     * 获取输血：1无   2有
     * 
     * @return 输血
     */
    public Integer getBloodTran() {
        return this.bloodTran;
    }
     
    /**
     * 设置输血：1无   2有
     * 
     * @param bloodTran
     *          输血：1无   2有
     */
    public void setBloodTran(Integer bloodTran) {
        this.bloodTran = bloodTran;
    }
    
    /**
     * 获取遗传病史:1 无 2 有
     * 
     * @return 遗传病史
     */
    public Integer getGeneticHistory() {
        return this.geneticHistory;
    }
     
    /**
     * 设置遗传病史:1 无 2 有
     * 
     * @param geneticHistory
     *          遗传病史:1 无 2 有
     */
    public void setGeneticHistory(Integer geneticHistory) {
        this.geneticHistory = geneticHistory;
    }
    
    /**
     * 获取遗传病名称
     * 
     * @return 遗传病名称
     */
    public String getGeneticSickness() {
        return this.geneticSickness;
    }
     
    /**
     * 设置遗传病名称
     * 
     * @param geneticSickness
     *          遗传病名称
     */
    public void setGeneticSickness(String geneticSickness) {
        this.geneticSickness = geneticSickness;
    }
    
    /**
     * 获取残疾情况
     * 
     * @return 残疾情况
     */
    public String getDisable() {
        return this.disable;
    }
     
    /**
     * 设置残疾情况
     * 
     * @param disable
     *          残疾情况
     */
    public void setDisable(String disable) {
        this.disable = disable;
    }
    
    /**
     * 获取其他残疾情况
     * 
     * @return 其他残疾情况
     */
    public String getDisableOther() {
        return this.disableOther;
    }
     
    /**
     * 设置其他残疾情况
     * 
     * @param disableOther
     *          其他残疾情况
     */
    public void setDisableOther(String disableOther) {
        this.disableOther = disableOther;
    }
    
    /**
     * 获取厨房排风设施:1无       2油烟机   3换气扇   4烟囱
     * 
     * @return 厨房排风设施
     */
    public Integer getKitchen() {
        return this.kitchen;
    }
     
    /**
     * 设置厨房排风设施:1无       2油烟机   3换气扇   4烟囱
     * 
     * @param kitchen
     *          厨房排风设施:1无       2油烟机   3换气扇   4烟囱
     */
    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }
    
    /**
     * 获取燃料类型:1液化气   2煤       3天然气   4沼气   5柴火  6其他
     * 
     * @return 燃料类型
     */
    public Integer getFuelType() {
        return this.fuelType;
    }
     
    /**
     * 设置燃料类型:1液化气   2煤       3天然气   4沼气   5柴火  6其他
     * 
     * @param fuelType
     *          燃料类型:1液化气   2煤       3天然气   4沼气   5柴火  6其他
     */
    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }
    
    /**
     * 获取饮水:1自来水   2经净化过滤的水   3井水  4河湖水  5塘水 6其他
     * 
     * @return 饮水
     */
    public Integer getWater() {
        return this.water;
    }
     
    /**
     * 设置饮水:1自来水   2经净化过滤的水   3井水  4河湖水  5塘水 6其他
     * 
     * @param water
     *          饮水:1自来水   2经净化过滤的水   3井水  4河湖水  5塘水 6其他
     */
    public void setWater(Integer water) {
        this.water = water;
    }
    
    /**
     * 获取厕所:1卫生厕所 2一格或二格粪池式 3马桶  4露天粪坑  5简易棚厕
     * 
     * @return 厕所
     */
    public Integer getToilet() {
        return this.toilet;
    }
     
    /**
     * 设置厕所:1卫生厕所 2一格或二格粪池式 3马桶  4露天粪坑  5简易棚厕
     * 
     * @param toilet
     *          厕所:1卫生厕所 2一格或二格粪池式 3马桶  4露天粪坑  5简易棚厕
     */
    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }
    
    /**
     * 获取禽畜栏:1单设     2室内     3室外
     * 
     * @return 禽畜栏
     */
    public Integer getCorral() {
        return this.corral;
    }
     
    /**
     * 设置禽畜栏:1单设     2室内     3室外
     * 
     * @param corral
     *          禽畜栏:1单设     2室内     3室外
     */
    public void setCorral(Integer corral) {
        this.corral = corral;
    }

	public String getJsonobj() {
		return jsonobj;
	}

	public void setJsonobj(String jsonobj) {
		this.jsonobj = jsonobj;
	}
}