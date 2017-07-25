package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 严重精神障碍患者随访服务记录表(PF_FOLLOW_PSYCHOSIS)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class FollowPsychosisDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1661813937947902368L;
    
    /** 精神障碍表ID */
    private String fpId;
    
    /** 姓名 */
    private String fpName;
    
    /** 编号 */
    private String fpCode;
    
    /** 随访日期 */
    private Date followDate;
    
    /** 如失访，原因:1外出打工  2迁居他处  3走失  4连续3次未访到  5其他  */
    private Integer lostReason;
    
    /** 死亡日期 */
    private Date deathDate;
    
    /** 躯体疾病:1染病和寄生虫病  2肿瘤 3心脏病 4脑血管病 5呼吸系统疾病 6消化系统疾病 7其他疾病 9不详 */
    private Integer bodyDeathSick;
    
    /** 其他死亡原因:2自杀 3他杀 4意外 5精神疾病相关并发症 6其他 */
    private Integer otherDeath;
    
    /** 危险性:0 （0级） 1（1级） 2(2级)  3(3级)  4(4级)  5（5级）    */
    private Integer danger;
    
    /** 目前症状:1幻觉 2交流困难 3猜疑 4喜怒无常  5行为怪异  6兴奋话多 7伤人毁物 8悲观厌世  9无故外走 10自语自笑  11孤僻懒散 12其他    */
    private String currentSymptoms;
    
    /** 目前症状:其他 */
    private String currentSymptomsOther;
    
    /** 自知力:1自知力完全    2自知力不全    3自知力缺失     */
    private Integer insight;
    
    /** 睡眠情况:1良好    2一般    3较差 */
    private Integer sleep;
    
    /** 饮食情况:1良好    2一般    3较差 */
    private Integer diet;
    
    /** 个人生活料理 1良好    2一般    3较差            */
    private Integer life;
    
    /** 家务劳动:1良好    2一般    3较差 */
    private Integer housework;
    
    /** 生产劳动及工作 1良好    2一般    3较差   9此项不适用 */
    private Integer work;
    
    /** 学习能力 1良好    2一般    3较差 */
    private Integer study;
    
    /** 社会人际交往:1良好    2一般    3较差 */
    private Integer contact;
    
    /** 轻度滋事（默认0）次 */
    private Integer trouble;
    
    /** 肇事（默认0）次 */
    private Integer accident;
    
    /** 肇祸（默认0）次 */
    private Integer zhaohuo;
    
    /** 其他危害行为（默认0）次 */
    private Integer otherPractice;
    
    /** 自伤（默认0）次 */
    private Integer selfInjury;
    
    /** 自杀未遂（默认0）次 */
    private Integer suicide;
    
    /** 关锁情况:1期间无关锁   2关锁  3期间关锁已解除  */
    private Integer lockDoor;
    
    /** 住院情况:0期间未住院  1目前正在住院  2期间曾住院，现未住院  */
    private Integer hospital;
    
    /** 末次出院时间 */
    private Date lastHospital;
    
    /** 实验室检查 1 无 2 有 */
    private Integer labCheck;
    
    /** 实验室检查内容 */
    private String labCheckTxt;
    
    /** 服药依从性:1按医嘱规律服药  2间断服药  3不服药  4医嘱勿需服药 */
    private Integer medicationCompliance;
    
    /**  药物不良反应 1 无 2 有 */
    private Integer adverseReactions;
    
    /** 药物不良反应内容 */
    private String adverseReactionsTxt;
    
    /** 治疗效果 1痊愈  2 好转   3 无变化   4 加重      */
    private Integer treatmentEffect;
    
    /** 是否转诊 1 否 2 是 */
    private Integer isRefer;
    
    /** 转诊原因 */
    private String referReason;
    
    /** 转诊至机构及科室 */
    private String referOrignDepart;
    
    /** 康复措施 1生活劳动能力2职业训练3学习能力4社会交往5其他 */
    private String rehabilitationMeasures;
    
    /** 其他健康措施 */
    private String rehabilitationMeasuresOther;
    
    /** 本次随访分类:1不稳定  2基本稳定  3稳定  */
    private Integer followClass;
    
    /** 下次随访时间 */
    
    private Date nextFollowTime;
    
    /** 随访医生 */
    private String followDoctor;

    /** json数据保存*/
    private String jsonobj;

    /**
     * Getter for property 'jsonobj'.
     *
     * @return Value for property 'jsonobj'.
     */
    public String getJsonobj() {
        return jsonobj;
    }

    /**
     * Setter for property 'jsonobj'.
     *
     * @param jsonobj Value to set for property 'jsonobj'.
     */
    public void setJsonobj(String jsonobj) {
        this.jsonobj = jsonobj;
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
     * 获取姓名
     * 
     * @return 姓名
     */
    public String getFpName() {
        return this.fpName;
    }
     
    /**
     * 设置姓名
     * 
     * @param fpName
     *          姓名
     */
    public void setFpName(String fpName) {
        this.fpName = fpName;
    }
    
    /**
     * 获取编号
     * 
     * @return 编号
     */
    public String getFpCode() {
        return this.fpCode;
    }
     
    /**
     * 设置编号
     * 
     * @param fpCode
     *          编号
     */
    public void setFpCode(String fpCode) {
        this.fpCode = fpCode;
    }
    
    /**
     * 获取随访日期
     * 
     * @return 随访日期
     */
    public Date getFollowDate() {
        return this.followDate;
    }
     
    /**
     * 设置随访日期
     * 
     * @param followDate
     *          随访日期
     */
    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }
    
    /**
     * 获取如失访，原因:1外出打工  2迁居他处  3走失  4连续3次未访到  5其他 
     * 
     * @return 如失访
     */
    public Integer getLostReason() {
        return this.lostReason;
    }
     
    /**
     * 设置如失访，原因:1外出打工  2迁居他处  3走失  4连续3次未访到  5其他 
     * 
     * @param lostReason
     *          如失访，原因:1外出打工  2迁居他处  3走失  4连续3次未访到  5其他 
     */
    public void setLostReason(Integer lostReason) {
        this.lostReason = lostReason;
    }
    
    /**
     * 获取死亡日期
     * 
     * @return 死亡日期
     */
    public Date getDeathDate() {
        return this.deathDate;
    }
     
    /**
     * 设置死亡日期
     * 
     * @param deathDate
     *          死亡日期
     */
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
    
    /**
     * 获取躯体疾病:1染病和寄生虫病  2肿瘤 3心脏病 4脑血管病 5呼吸系统疾病 6消化系统疾病 7其他疾病 9不详
     * 
     * @return 躯体疾病
     */
    public Integer getBodyDeathSick() {
        return this.bodyDeathSick;
    }
     
    /**
     * 设置躯体疾病:1染病和寄生虫病  2肿瘤 3心脏病 4脑血管病 5呼吸系统疾病 6消化系统疾病 7其他疾病 9不详
     * 
     * @param bodyDeathSick
     *          躯体疾病:1染病和寄生虫病  2肿瘤 3心脏病 4脑血管病 5呼吸系统疾病 6消化系统疾病 7其他疾病 9不详
     */
    public void setBodyDeathSick(Integer bodyDeathSick) {
        this.bodyDeathSick = bodyDeathSick;
    }
    
    /**
     * 获取其他死亡原因:2自杀 3他杀 4意外 5精神疾病相关并发症 6其他
     * 
     * @return 其他死亡原因
     */
    public Integer getOtherDeath() {
        return this.otherDeath;
    }
     
    /**
     * 设置其他死亡原因:2自杀 3他杀 4意外 5精神疾病相关并发症 6其他
     * 
     * @param otherDeath
     *          其他死亡原因:2自杀 3他杀 4意外 5精神疾病相关并发症 6其他
     */
    public void setOtherDeath(Integer otherDeath) {
        this.otherDeath = otherDeath;
    }
    
    /**
     * 获取危险性:0 （0级） 1（1级） 2(2级)  3(3级)  4(4级)  5（5级）   
     * 
     * @return 危险性
     */
    public Integer getDanger() {
        return this.danger;
    }
     
    /**
     * 设置危险性:0 （0级） 1（1级） 2(2级)  3(3级)  4(4级)  5（5级）   
     * 
     * @param danger
     *          危险性:0 （0级） 1（1级） 2(2级)  3(3级)  4(4级)  5（5级）   
     */
    public void setDanger(Integer danger) {
        this.danger = danger;
    }
    
    /**
     * 获取目前症状:1幻觉 2交流困难 3猜疑 4喜怒无常  5行为怪异  6兴奋话多 7伤人毁物 8悲观厌世  9无故外走 10自语自笑  11孤僻懒散 12其他   
     * 
     * @return 目前症状
     */
    public String getCurrentSymptoms() {
        return this.currentSymptoms;
    }
     
    /**
     * 设置目前症状:1幻觉 2交流困难 3猜疑 4喜怒无常  5行为怪异  6兴奋话多 7伤人毁物 8悲观厌世  9无故外走 10自语自笑  11孤僻懒散 12其他   
     * 
     * @param currentSymptoms
     *          目前症状:1幻觉 2交流困难 3猜疑 4喜怒无常  5行为怪异  6兴奋话多 7伤人毁物 8悲观厌世  9无故外走 10自语自笑  11孤僻懒散 12其他   
     */
    public void setCurrentSymptoms(String currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }
    
    public String getCurrentSymptomsOther() {
		return currentSymptomsOther;
	}
    

	public void setCurrentSymptomsOther(String currentSymptomsOther) {
		this.currentSymptomsOther = currentSymptomsOther;
	}
	

	/**
     * 获取自知力:1自知力完全    2自知力不全    3自知力缺失    
     * 
     * @return 自知力
     */
    public Integer getInsight() {
        return this.insight;
    }
     
    /**
     * 设置自知力:1自知力完全    2自知力不全    3自知力缺失    
     * 
     * @param insight
     *          自知力:1自知力完全    2自知力不全    3自知力缺失    
     */
    public void setInsight(Integer insight) {
        this.insight = insight;
    }
    
    /**
     * 获取睡眠情况:1良好    2一般    3较差
     * 
     * @return 睡眠情况
     */
    public Integer getSleep() {
        return this.sleep;
    }
     
    /**
     * 设置睡眠情况:1良好    2一般    3较差
     * 
     * @param sleep
     *          睡眠情况:1良好    2一般    3较差
     */
    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }
    
    /**
     * 获取饮食情况:1良好    2一般    3较差
     * 
     * @return 饮食情况
     */
    public Integer getDiet() {
        return this.diet;
    }
     
    /**
     * 设置饮食情况:1良好    2一般    3较差
     * 
     * @param diet
     *          饮食情况:1良好    2一般    3较差
     */
    public void setDiet(Integer diet) {
        this.diet = diet;
    }
    
    /**
     * 获取个人生活料理 1良好    2一般    3较差           
     * 
     * @return 个人生活料理 1良好    2一般    3较差           
     */
    public Integer getLife() {
        return this.life;
    }
     
    /**
     * 设置个人生活料理 1良好    2一般    3较差           
     * 
     * @param life
     *          个人生活料理 1良好    2一般    3较差           
     */
    public void setLife(Integer life) {
        this.life = life;
    }
    
    /**
     * 获取家务劳动:1良好    2一般    3较差
     * 
     * @return 家务劳动
     */
    public Integer getHousework() {
        return this.housework;
    }
     
    /**
     * 设置家务劳动:1良好    2一般    3较差
     * 
     * @param housework
     *          家务劳动:1良好    2一般    3较差
     */
    public void setHousework(Integer housework) {
        this.housework = housework;
    }
    
    /**
     * 获取生产劳动及工作 1良好    2一般    3较差   9此项不适用
     * 
     * @return 生产劳动及工作 1良好    2一般    3较差   9此项不适用
     */
    public Integer getWork() {
        return this.work;
    }
     
    /**
     * 设置生产劳动及工作 1良好    2一般    3较差   9此项不适用
     * 
     * @param work
     *          生产劳动及工作 1良好    2一般    3较差   9此项不适用
     */
    public void setWork(Integer work) {
        this.work = work;
    }
    
    /**
     * 获取学习能力 1良好    2一般    3较差
     * 
     * @return 学习能力 1良好    2一般    3较差
     */
    public Integer getStudy() {
        return this.study;
    }
     
    /**
     * 设置学习能力 1良好    2一般    3较差
     * 
     * @param study
     *          学习能力 1良好    2一般    3较差
     */
    public void setStudy(Integer study) {
        this.study = study;
    }
    
    /**
     * 获取社会人际交往:1良好    2一般    3较差
     * 
     * @return 社会人际交往
     */
    public Integer getContact() {
        return this.contact;
    }
     
    /**
     * 设置社会人际交往:1良好    2一般    3较差
     * 
     * @param contact
     *          社会人际交往:1良好    2一般    3较差
     */
    public void setContact(Integer contact) {
        this.contact = contact;
    }
    
    /**
     * 获取轻度滋事（默认0）次
     * 
     * @return 轻度滋事（默认0）次
     */
    public Integer getTrouble() {
        return this.trouble;
    }
     
    /**
     * 设置轻度滋事（默认0）次
     * 
     * @param trouble
     *          轻度滋事（默认0）次
     */
    public void setTrouble(Integer trouble) {
        this.trouble = trouble;
    }
    
    /**
     * 获取肇事（默认0）次
     * 
     * @return 肇事（默认0）次
     */
    public Integer getAccident() {
        return this.accident;
    }
     
    /**
     * 设置肇事（默认0）次
     * 
     * @param accident
     *          肇事（默认0）次
     */
    public void setAccident(Integer accident) {
        this.accident = accident;
    }
    
    /**
     * 获取肇祸（默认0）次
     * 
     * @return 肇祸（默认0）次
     */
    public Integer getZhaohuo() {
        return this.zhaohuo;
    }
     
    /**
     * 设置肇祸（默认0）次
     * 
     * @param zhaohuo
     *          肇祸（默认0）次
     */
    public void setZhaohuo(Integer zhaohuo) {
        this.zhaohuo = zhaohuo;
    }
    
    /**
     * 获取其他危害行为（默认0）次
     * 
     * @return 其他危害行为（默认0）次
     */
    public Integer getOtherPractice() {
        return this.otherPractice;
    }
     
    /**
     * 设置其他危害行为（默认0）次
     * 
     * @param otherPractice
     *          其他危害行为（默认0）次
     */
    public void setOtherPractice(Integer otherPractice) {
        this.otherPractice = otherPractice;
    }
    
    /**
     * 获取自伤（默认0）次
     * 
     * @return 自伤（默认0）次
     */
    public Integer getSelfInjury() {
        return this.selfInjury;
    }
     
    /**
     * 设置自伤（默认0）次
     * 
     * @param selfInjury
     *          自伤（默认0）次
     */
    public void setSelfInjury(Integer selfInjury) {
        this.selfInjury = selfInjury;
    }
    
    /**
     * 获取自杀未遂（默认0）次
     * 
     * @return 自杀未遂（默认0）次
     */
    public Integer getSuicide() {
        return this.suicide;
    }
     
    /**
     * 设置自杀未遂（默认0）次
     * 
     * @param suicide
     *          自杀未遂（默认0）次
     */
    public void setSuicide(Integer suicide) {
        this.suicide = suicide;
    }
    
    /**
     * 获取关锁情况:1期间无关锁   2关锁  3期间关锁已解除 
     * 
     * @return 关锁情况
     */
    public Integer getLockDoor() {
        return this.lockDoor;
    }
     
    /**
     * 设置关锁情况:1期间无关锁   2关锁  3期间关锁已解除 
     * 
     * @param lockDoor
     *          关锁情况:1期间无关锁   2关锁  3期间关锁已解除 
     */
    public void setLockDoor(Integer lockDoor) {
        this.lockDoor = lockDoor;
    }
    
    /**
     * 获取住院情况:0期间未住院  1目前正在住院  2期间曾住院，现未住院 
     * 
     * @return 住院情况:0期间未住院  1目前正在住院  2期间曾住院
     */
    public Integer getHospital() {
        return this.hospital;
    }
     
    /**
     * 设置住院情况:0期间未住院  1目前正在住院  2期间曾住院，现未住院 
     * 
     * @param hospital
     *          住院情况:0期间未住院  1目前正在住院  2期间曾住院，现未住院 
     */
    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }
    
    /**
     * 获取末次出院时间
     * 
     * @return 末次出院时间
     */
    public Date getLastHospital() {
        return this.lastHospital;
    }
     
    /**
     * 设置末次出院时间
     * 
     * @param lastHospital
     *          末次出院时间
     */
    public void setLastHospital(Date lastHospital) {
        this.lastHospital = lastHospital;
    }
    
    /**
     * 获取实验室检查 1 无 2 有
     * 
     * @return 实验室检查 1 无 2 有
     */
    public Integer getLabCheck() {
        return this.labCheck;
    }
     
    /**
     * 设置实验室检查 1 无 2 有
     * 
     * @param labCheck
     *          实验室检查 1 无 2 有
     */
    public void setLabCheck(Integer labCheck) {
        this.labCheck = labCheck;
    }
    
    /**
     * 获取实验室检查内容
     * 
     * @return 实验室检查内容
     */
    public String getLabCheckTxt() {
        return this.labCheckTxt;
    }
     
    /**
     * 设置实验室检查内容
     * 
     * @param labCheckTxt
     *          实验室检查内容
     */
    public void setLabCheckTxt(String labCheckTxt) {
        this.labCheckTxt = labCheckTxt;
    }
    
    /**
     * 获取服药依从性:1按医嘱规律服药  2间断服药  3不服药  4医嘱勿需服药
     * 
     * @return 服药依从性
     */
    public Integer getMedicationCompliance() {
        return this.medicationCompliance;
    }
     
    /**
     * 设置服药依从性:1按医嘱规律服药  2间断服药  3不服药  4医嘱勿需服药
     * 
     * @param medicationCompliance
     *          服药依从性:1按医嘱规律服药  2间断服药  3不服药  4医嘱勿需服药
     */
    public void setMedicationCompliance(Integer medicationCompliance) {
        this.medicationCompliance = medicationCompliance;
    }
    
    /**
     * 获取 药物不良反应 1 无 2 有
     * 
     * @return  药物不良反应 1 无 2 有
     */
    public Integer getAdverseReactions() {
        return this.adverseReactions;
    }
     
    /**
     * 设置 药物不良反应 1 无 2 有
     * 
     * @param adverseReactions
     *           药物不良反应 1 无 2 有
     */
    public void setAdverseReactions(Integer adverseReactions) {
        this.adverseReactions = adverseReactions;
    }
    
    /**
     * 获取药物不良反应内容
     * 
     * @return 药物不良反应内容
     */
    public String getAdverseReactionsTxt() {
        return this.adverseReactionsTxt;
    }
     
    /**
     * 设置药物不良反应内容
     * 
     * @param adverseReactionsTxt
     *          药物不良反应内容
     */
    public void setAdverseReactionsTxt(String adverseReactionsTxt) {
        this.adverseReactionsTxt = adverseReactionsTxt;
    }
    
    /**
     * 获取治疗效果 1痊愈  2 好转   3 无变化   4 加重     
     * 
     * @return 治疗效果 1痊愈  2 好转   3 无变化   4 加重     
     */
    public Integer getTreatmentEffect() {
        return this.treatmentEffect;
    }
     
    /**
     * 设置治疗效果 1痊愈  2 好转   3 无变化   4 加重     
     * 
     * @param treatmentEffect
     *          治疗效果 1痊愈  2 好转   3 无变化   4 加重     
     */
    public void setTreatmentEffect(Integer treatmentEffect) {
        this.treatmentEffect = treatmentEffect;
    }
    
    /**
     * 获取是否转诊 1 否 2 是
     * 
     * @return 是否转诊 1 否 2 是
     */
    public Integer getIsRefer() {
        return this.isRefer;
    }
     
    /**
     * 设置是否转诊 1 否 2 是
     * 
     * @param isRefer
     *          是否转诊 1 否 2 是
     */
    public void setIsRefer(Integer isRefer) {
        this.isRefer = isRefer;
    }
    
    /**
     * 获取转诊原因
     * 
     * @return 转诊原因
     */
    public String getReferReason() {
        return this.referReason;
    }
     
    /**
     * 设置转诊原因
     * 
     * @param referReason
     *          转诊原因
     */
    public void setReferReason(String referReason) {
        this.referReason = referReason;
    }
    
    /**
     * 获取转诊至机构及科室
     * 
     * @return 转诊至机构及科室
     */
    public String getReferOrignDepart() {
        return this.referOrignDepart;
    }
     
    /**
     * 设置转诊至机构及科室
     * 
     * @param referOrignDepart
     *          转诊至机构及科室
     */
    public void setReferOrignDepart(String referOrignDepart) {
        this.referOrignDepart = referOrignDepart;
    }
    
    /**
     * 获取康复措施 1生活劳动能力2职业训练3学习能力4社会交往5其他
     * 
     * @return 康复措施 1生活劳动能力2职业训练3学习能力4社会交往5其他
     */
    public String getRehabilitationMeasures() {
        return this.rehabilitationMeasures;
    }
     
    /**
     * 设置康复措施 1生活劳动能力2职业训练3学习能力4社会交往5其他
     * 
     * @param rehabilitationMeasures
     *          康复措施 1生活劳动能力2职业训练3学习能力4社会交往5其他
     */
    public void setRehabilitationMeasures(String rehabilitationMeasures) {
        this.rehabilitationMeasures = rehabilitationMeasures;
    }
    
    /**
     * 获取其他健康措施
     * 
     * @return 其他健康措施
     */
    public String getRehabilitationMeasuresOther() {
        return this.rehabilitationMeasuresOther;
    }
     
    /**
     * 设置其他健康措施
     * 
     * @param rehabilitationMeasuresOther
     *          其他健康措施
     */
    public void setRehabilitationMeasuresOther(String rehabilitationMeasuresOther) {
        this.rehabilitationMeasuresOther = rehabilitationMeasuresOther;
    }
    
    /**
     * 获取本次随访分类:1不稳定  2基本稳定  3稳定 
     * 
     * @return 本次随访分类
     */
    public Integer getFollowClass() {
        return this.followClass;
    }
     
    /**
     * 设置本次随访分类:1不稳定  2基本稳定  3稳定 
     * 
     * @param followClass
     *          本次随访分类:1不稳定  2基本稳定  3稳定 
     */
    public void setFollowClass(Integer followClass) {
        this.followClass = followClass;
    }
    
    /**
     * 获取下次随访时间
     * 
     * @return 下次随访时间
     */
    public Date getNextFollowTime() {
        return this.nextFollowTime;
    }
     
    /**
     * 设置下次随访时间
     * 
     * @param nextFollowTime
     *          下次随访时间
     */
    public void setNextFollowTime(Date nextFollowTime) {
        this.nextFollowTime = nextFollowTime;
    }
    
    /**
     * 获取随访医生
     * 
     * @return 随访医生
     */
    public String getFollowDoctor() {
        return this.followDoctor;
    }
     
    /**
     * 设置随访医生
     * 
     * @param followDoctor
     *          随访医生
     */
    public void setFollowDoctor(String followDoctor) {
        this.followDoctor = followDoctor;
    }
}