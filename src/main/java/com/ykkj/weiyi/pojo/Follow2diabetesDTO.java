package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 2型糖尿病患者随访服务记录表(PF_FOLLOW_2DIABETES)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class Follow2diabetesDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -7797931624136994386L;
    
    /** 2型糖尿病表ID */
    private String dId;
    
    /** 姓名 */
    private String dName;
    
    /** 编号 */
    private String dCode;
    
    /** 随访日期 */
    
    private Date followTime;
    
    /** 随访方式:1门诊2家庭3电话 */
    private Integer followType;
    
    /** 症状：1无症状 2多饮 3多食 4多尿 5视力模糊 6感染 7手脚麻木 8下肢浮肿 9体重明显下降 */
    private String symptom;
    
    /** 其他症状 */
    private String symptomOther;
    
    /** 血压(mmHg) */
    private Integer bloodPressure;
    
    /** 当前体重kg */
    private String weightCurrent;
    
    /** 目标体重 */
    private String weightTarget;
    
    /** 当前体质指数 */
    private String weightIndexCurrent;
    
    /** 目标体质指数 */
    private String weightIndexTarget;
    
    /** 1 未触及2 触及  */
    private Integer arteria;
    
    /** 其他体征 */
    private String signOther;
    
    /** 当前日吸烟量(支) */
    private Integer currentSmoke;
    
    /** 目标吸烟量 */
    private Integer targetSmoke;
    
    /** 当前日饮酒量 */
    private Integer currentDrink;
    
    /** 目标日饮酒量 */
    private Integer targetDrink;
    
    /** 当前运动频率（次/周） */
    private Integer sportsCurrentRate;
    
    /** 目标运动频率（次/周） */
    private Integer sportsTargetTate;
    
    /** 当前运动时间（分/天） */
    private Integer sportsCurrentTime;
    
    /** 目标运动时间（分/天） */
    private Integer sportsTargetTime;
    
    /** 当前主食量（克/天） */
    private Integer foodCurrent;
    
    /** 目标主食量（克/天） */
    private Integer foodTarget;
    
    /** 心里调整:1良好  2一般  3差 */
    private Integer heartAdjust;
    
    /** 遵医行为:1良好  2一般  3差 */
    private Integer comply;
    
    /** 空腹血糖mmol/L */
    private String fastingGlucose;
    
    /** 糖化血红蛋白% */
    private String glycosylatedHemoglobin;
    
    /** 糖化血红蛋白检查日 */
    
    private Date glycosylatedHemoglobinDate;
    
    /** 其他辅助检查 */
    private String otherAssistCheck;
    
    /** 服药依从性:1规律2间断3不服药 */
    private Integer medicationCompliance;
    
    /** 药物不良反应:1无 2有 */
    private Integer drugReaction;
    
    /** 药物不良反应内容 */
    private String drugReactionContent;
    
    /** 低血糖反应:1无 2 偶尔 3频繁 */
    private Integer hypoglycemiaReaction;
    
    /** 此次随访分类:1控制满意2控制不满意3不良反应 4并发症 */
    private Integer followClass;
    
    /** 转诊原因 */
    private String referReason;
    
    /** 转诊机构及科别 */
    private String originDepart;
    
    /** 胰岛素种类 */
    private String insulinType;
    
    /** 胰岛素用法用量 */
    private String insulinUse;
    
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
     * 获取2型糖尿病表ID
     * 
     * @return 2型糖尿病表ID
     */
    public String getDId() {
        return this.dId;
    }
     
    /**
     * 设置2型糖尿病表ID
     * 
     * @param dId
     *          2型糖尿病表ID
     */
    public void setDId(String dId) {
        this.dId = dId;
    }
    
    /**
     * 获取姓名
     * 
     * @return 姓名
     */
    public String getDName() {
        return this.dName;
    }
     
    /**
     * 设置姓名
     * 
     * @param dName
     *          姓名
     */
    public void setDName(String dName) {
        this.dName = dName;
    }
    
    /**
     * 获取编号
     * 
     * @return 编号
     */
    public String getDCode() {
        return this.dCode;
    }
     
    /**
     * 设置编号
     * 
     * @param dCode
     *          编号
     */
    public void setDCode(String dCode) {
        this.dCode = dCode;
    }
    
    /**
     * 获取随访日期
     * 
     * @return 随访日期
     */
    public Date getFollowTime() {
        return this.followTime;
    }
     
    /**
     * 设置随访日期
     * 
     * @param followTime
     *          随访日期
     */
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
    
    /**
     * 获取随访方式:1门诊2家庭3电话
     * 
     * @return 随访方式
     */
    public Integer getFollowType() {
        return this.followType;
    }
     
    /**
     * 设置随访方式:1门诊2家庭3电话
     * 
     * @param followType
     *          随访方式:1门诊2家庭3电话
     */
    public void setFollowType(Integer followType) {
        this.followType = followType;
    }
    
    /**
     * 获取症状：1无症状 2多饮 3多食 4多尿 5视力模糊 6感染 7手脚麻木 8下肢浮肿 9体重明显下降
     * 
     * @return 症状
     */
    public String getSymptom() {
        return this.symptom;
    }
     
    /**
     * 设置症状：1无症状 2多饮 3多食 4多尿 5视力模糊 6感染 7手脚麻木 8下肢浮肿 9体重明显下降
     * 
     * @param symptom
     *          症状：1无症状 2多饮 3多食 4多尿 5视力模糊 6感染 7手脚麻木 8下肢浮肿 9体重明显下降
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    
    /**
     * 获取其他症状
     * 
     * @return 其他症状
     */
    public String getSymptomOther() {
        return this.symptomOther;
    }
     
    /**
     * 设置其他症状
     * 
     * @param symptomOther
     *          其他症状
     */
    public void setSymptomOther(String symptomOther) {
        this.symptomOther = symptomOther;
    }
    
    /**
     * 获取血压(mmHg)
     * 
     * @return 血压(mmHg)
     */
    public Integer getBloodPressure() {
        return this.bloodPressure;
    }
     
    /**
     * 设置血压(mmHg)
     * 
     * @param bloodPressure
     *          血压(mmHg)
     */
    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    /**
     * 获取当前体重kg
     * 
     * @return 当前体重kg
     */
    public String getWeightCurrent() {
        return this.weightCurrent;
    }
     
    /**
     * 设置当前体重kg
     * 
     * @param weightCurrent
     *          当前体重kg
     */
    public void setWeightCurrent(String weightCurrent) {
        this.weightCurrent = weightCurrent;
    }
    
    /**
     * 获取目标体重
     * 
     * @return 目标体重
     */
    public String getWeightTarget() {
        return this.weightTarget;
    }
     
    /**
     * 设置目标体重
     * 
     * @param weightTarget
     *          目标体重
     */
    public void setWeightTarget(String weightTarget) {
        this.weightTarget = weightTarget;
    }
    
    /**
     * 获取当前体质指数
     * 
     * @return 当前体质指数
     */
    public String getWeightIndexCurrent() {
        return this.weightIndexCurrent;
    }
     
    /**
     * 设置当前体质指数
     * 
     * @param weightIndexCurrent
     *          当前体质指数
     */
    public void setWeightIndexCurrent(String weightIndexCurrent) {
        this.weightIndexCurrent = weightIndexCurrent;
    }
    
    /**
     * 获取目标体质指数
     * 
     * @return 目标体质指数
     */
    public String getWeightIndexTarget() {
        return this.weightIndexTarget;
    }
     
    /**
     * 设置目标体质指数
     * 
     * @param weightIndexTarget
     *          目标体质指数
     */
    public void setWeightIndexTarget(String weightIndexTarget) {
        this.weightIndexTarget = weightIndexTarget;
    }
    
    /**
     * 获取1 未触及2 触及 
     * 
     * @return 1 未触及2 触及 
     */
    public Integer getArteria() {
        return this.arteria;
    }
     
    /**
     * 设置1 未触及2 触及 
     * 
     * @param arteria
     *          1 未触及2 触及 
     */
    public void setArteria(Integer arteria) {
        this.arteria = arteria;
    }
    
    /**
     * 获取其他体征
     * 
     * @return 其他体征
     */
    public String getSignOther() {
        return this.signOther;
    }
     
    /**
     * 设置其他体征
     * 
     * @param signOther
     *          其他体征
     */
    public void setSignOther(String signOther) {
        this.signOther = signOther;
    }
    
    /**
     * 获取当前日吸烟量(支)
     * 
     * @return 当前日吸烟量(支)
     */
    public Integer getCurrentSmoke() {
        return this.currentSmoke;
    }
     
    /**
     * 设置当前日吸烟量(支)
     * 
     * @param currentSmoke
     *          当前日吸烟量(支)
     */
    public void setCurrentSmoke(Integer currentSmoke) {
        this.currentSmoke = currentSmoke;
    }
    
    /**
     * 获取目标吸烟量
     * 
     * @return 目标吸烟量
     */
    public Integer getTargetSmoke() {
        return this.targetSmoke;
    }
     
    /**
     * 设置目标吸烟量
     * 
     * @param targetSmoke
     *          目标吸烟量
     */
    public void setTargetSmoke(Integer targetSmoke) {
        this.targetSmoke = targetSmoke;
    }
    
    /**
     * 获取当前日饮酒量
     * 
     * @return 当前日饮酒量
     */
    public Integer getCurrentDrink() {
        return this.currentDrink;
    }
     
    /**
     * 设置当前日饮酒量
     * 
     * @param currentDrink
     *          当前日饮酒量
     */
    public void setCurrentDrink(Integer currentDrink) {
        this.currentDrink = currentDrink;
    }
    
    /**
     * 获取目标日饮酒量
     * 
     * @return 目标日饮酒量
     */
    public Integer getTargetDrink() {
        return this.targetDrink;
    }
     
    /**
     * 设置目标日饮酒量
     * 
     * @param targetDrink
     *          目标日饮酒量
     */
    public void setTargetDrink(Integer targetDrink) {
        this.targetDrink = targetDrink;
    }
    
    /**
     * 获取当前运动频率（次/周）
     * 
     * @return 当前运动频率（次/周）
     */
    public Integer getSportsCurrentRate() {
        return this.sportsCurrentRate;
    }
     
    /**
     * 设置当前运动频率（次/周）
     * 
     * @param sportsCurrentRate
     *          当前运动频率（次/周）
     */
    public void setSportsCurrentRate(Integer sportsCurrentRate) {
        this.sportsCurrentRate = sportsCurrentRate;
    }
    
    /**
     * 获取目标运动频率（次/周）
     * 
     * @return 目标运动频率（次/周）
     */
    public Integer getSportsTargetTate() {
        return this.sportsTargetTate;
    }
     
    /**
     * 设置目标运动频率（次/周）
     * 
     * @param sportsTargetTate
     *          目标运动频率（次/周）
     */
    public void setSportsTargetTate(Integer sportsTargetTate) {
        this.sportsTargetTate = sportsTargetTate;
    }
    
    /**
     * 获取当前运动时间（分/天）
     * 
     * @return 当前运动时间（分/天）
     */
    public Integer getSportsCurrentTime() {
        return this.sportsCurrentTime;
    }
     
    /**
     * 设置当前运动时间（分/天）
     * 
     * @param sportsCurrentTime
     *          当前运动时间（分/天）
     */
    public void setSportsCurrentTime(Integer sportsCurrentTime) {
        this.sportsCurrentTime = sportsCurrentTime;
    }
    
    /**
     * 获取目标运动时间（分/天）
     * 
     * @return 目标运动时间（分/天）
     */
    public Integer getSportsTargetTime() {
        return this.sportsTargetTime;
    }
     
    /**
     * 设置目标运动时间（分/天）
     * 
     * @param sportsTargetTime
     *          目标运动时间（分/天）
     */
    public void setSportsTargetTime(Integer sportsTargetTime) {
        this.sportsTargetTime = sportsTargetTime;
    }
    
    /**
     * 获取当前主食量（克/天）
     * 
     * @return 当前主食量（克/天）
     */
    public Integer getFoodCurrent() {
        return this.foodCurrent;
    }
     
    /**
     * 设置当前主食量（克/天）
     * 
     * @param foodCurrent
     *          当前主食量（克/天）
     */
    public void setFoodCurrent(Integer foodCurrent) {
        this.foodCurrent = foodCurrent;
    }
    
    /**
     * 获取目标主食量（克/天）
     * 
     * @return 目标主食量（克/天）
     */
    public Integer getFoodTarget() {
        return this.foodTarget;
    }
     
    /**
     * 设置目标主食量（克/天）
     * 
     * @param foodTarget
     *          目标主食量（克/天）
     */
    public void setFoodTarget(Integer foodTarget) {
        this.foodTarget = foodTarget;
    }
    
    /**
     * 获取心里调整:1良好  2一般  3差
     * 
     * @return 心里调整
     */
    public Integer getHeartAdjust() {
        return this.heartAdjust;
    }
     
    /**
     * 设置心里调整:1良好  2一般  3差
     * 
     * @param heartAdjust
     *          心里调整:1良好  2一般  3差
     */
    public void setHeartAdjust(Integer heartAdjust) {
        this.heartAdjust = heartAdjust;
    }
    
    /**
     * 获取遵医行为:1良好  2一般  3差
     * 
     * @return 遵医行为
     */
    public Integer getComply() {
        return this.comply;
    }
     
    /**
     * 设置遵医行为:1良好  2一般  3差
     * 
     * @param comply
     *          遵医行为:1良好  2一般  3差
     */
    public void setComply(Integer comply) {
        this.comply = comply;
    }
    
    /**
     * 获取空腹血糖mmol/L
     * 
     * @return 空腹血糖mmol/L
     */
    public String getFastingGlucose() {
        return this.fastingGlucose;
    }
     
    /**
     * 设置空腹血糖mmol/L
     * 
     * @param fastingGlucose
     *          空腹血糖mmol/L
     */
    public void setFastingGlucose(String fastingGlucose) {
        this.fastingGlucose = fastingGlucose;
    }
    
    /**
     * 获取糖化血红蛋白%
     * 
     * @return 糖化血红蛋白%
     */
    public String getGlycosylatedHemoglobin() {
        return this.glycosylatedHemoglobin;
    }
     
    /**
     * 设置糖化血红蛋白%
     * 
     * @param glycosylatedHemoglobin
     *          糖化血红蛋白%
     */
    public void setGlycosylatedHemoglobin(String glycosylatedHemoglobin) {
        this.glycosylatedHemoglobin = glycosylatedHemoglobin;
    }
    
    /**
     * 获取糖化血红蛋白检查日
     * 
     * @return 糖化血红蛋白检查日
     */
    public Date getGlycosylatedHemoglobinDate() {
        return this.glycosylatedHemoglobinDate;
    }
     
    /**
     * 设置糖化血红蛋白检查日
     * 
     * @param glycosylatedHemoglobinDate
     *          糖化血红蛋白检查日
     */
    public void setGlycosylatedHemoglobinDate(Date glycosylatedHemoglobinDate) {
        this.glycosylatedHemoglobinDate = glycosylatedHemoglobinDate;
    }
    
    /**
     * 获取其他辅助检查
     * 
     * @return 其他辅助检查
     */
    public String getOtherAssistCheck() {
        return this.otherAssistCheck;
    }
     
    /**
     * 设置其他辅助检查
     * 
     * @param otherAssistCheck
     *          其他辅助检查
     */
    public void setOtherAssistCheck(String otherAssistCheck) {
        this.otherAssistCheck = otherAssistCheck;
    }
    
    /**
     * 获取服药依从性:1规律2间断3不服药
     * 
     * @return 服药依从性
     */
    public Integer getMedicationCompliance() {
        return this.medicationCompliance;
    }
     
    /**
     * 设置服药依从性:1规律2间断3不服药
     * 
     * @param medicationCompliance
     *          服药依从性:1规律2间断3不服药
     */
    public void setMedicationCompliance(Integer medicationCompliance) {
        this.medicationCompliance = medicationCompliance;
    }
    
    /**
     * 获取药物不良反应:1无 2有
     * 
     * @return 药物不良反应
     */
    public Integer getDrugReaction() {
        return this.drugReaction;
    }

	/**
	 * 设置药物不良反应:1无 2有
	 * 
	 * @param drugReaction
	 *            药物不良反应:1无 2有
	 */
	public void setDrugReaction(Integer drugReaction) {
		this.drugReaction = drugReaction;
	}

	public String getDrugReactionContent() {
		return drugReactionContent;
	}
	

	public void setDrugReactionContent(String drugReactionContent) {
		this.drugReactionContent = drugReactionContent;
	}
	

	/**
	 * 获取低血糖反应:1无 2 偶尔 3频繁
	 * 
	 * @return 低血糖反应
	 */
	public Integer getHypoglycemiaReaction() {
		return this.hypoglycemiaReaction;
	}

    /**
     * 设置低血糖反应:1无 2 偶尔 3频繁
     * 
     * @param hypoglycemiaReaction
     *          低血糖反应:1无 2 偶尔 3频繁
     */
    public void setHypoglycemiaReaction(Integer hypoglycemiaReaction) {
        this.hypoglycemiaReaction = hypoglycemiaReaction;
    }
    
    /**
     * 获取此次随访分类:1控制满意2控制不满意3不良反应 4并发症
     * 
     * @return 此次随访分类
     */
    public Integer getFollowClass() {
        return this.followClass;
    }
     
    /**
     * 设置此次随访分类:1控制满意2控制不满意3不良反应 4并发症
     * 
     * @param followClass
     *          此次随访分类:1控制满意2控制不满意3不良反应 4并发症
     */
    public void setFollowClass(Integer followClass) {
        this.followClass = followClass;
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
     * 获取转诊机构及科别
     * 
     * @return 转诊机构及科别
     */
    public String getOriginDepart() {
        return this.originDepart;
    }
     
    /**
     * 设置转诊机构及科别
     * 
     * @param originDepart
     *          转诊机构及科别
     */
    public void setOriginDepart(String originDepart) {
        this.originDepart = originDepart;
    }
    
    /**
     * 获取胰岛素种类
     * 
     * @return 胰岛素种类
     */
    public String getInsulinType() {
        return this.insulinType;
    }
     
    /**
     * 设置胰岛素种类
     * 
     * @param insulinType
     *          胰岛素种类
     */
    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }
    
    /**
     * 获取胰岛素用法用量
     * 
     * @return 胰岛素用法用量
     */
    public String getInsulinUse() {
        return this.insulinUse;
    }
     
    /**
     * 设置胰岛素用法用量
     * 
     * @param insulinUse
     *          胰岛素用法用量
     */
    public void setInsulinUse(String insulinUse) {
        this.insulinUse = insulinUse;
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