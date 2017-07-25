package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 高血压患者随访服务记录表(PF_FOLLOW_HYPERTENSION)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class FollowHypertensionDTO implements java.io.Serializable {
	/** 版本号 */
	private static final long serialVersionUID = 1745954397264838042L;

	/** 高血压随访表ID */
	private String fhId;

	/** 姓名 */
	private String fhName;

	/** 编号 */
	private String fhCode;

	/** 随访日期 */

	private Date followDate;

	/** 随访方式:1门诊 2家庭 3电话 */
	private Integer followType;

	/** 症状:1无症状2头痛头晕3恶心呕吐4眼花耳鸣5呼吸困难6心悸胸闷7鼻衄出血不止8四肢发麻9下肢水肿 */
	private String fhSymptom;

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

	/** 心率 */
	private String heartRate;

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

	/** 摄盐情况: 1 轻 2 中 3 重 */
	private Integer eatSalt;

	/** 心里调整:1良好 2一般 3差 */
	private Integer heartAdjust;

	/** 遵医行为:1良好 2一般 3差 */
	private Integer comply;

	/** 辅助检查 */
	private String assistCheck;

	/** 服药依从性:1规律2间断3不服药 */
	private Integer medicationCompliance;

	/** 药物不良反应:1无 2有 */
	private Integer drugReaction;

	/** 药物不良反应内容 */
	private String drugReactionContent;

	/** 此次随访分类:1控制满意2控制不满意3不良反应 4并发症 */
	private Integer followClass;

	/** 转诊原因 */
	private String referReason;

	/** 转诊机构及科别 */
	private String originDepart;

	/** 下次随访时间 */

	private Date nextFollowTime;

	/** 随访医生 */
	private String followDoctor;

	/** json数据保存 */
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
	 * @param jsonobj
	 *            Value to set for property 'jsonobj'.
	 */
	public void setJsonobj(String jsonobj) {
		this.jsonobj = jsonobj;
	}

	/**
	 * 获取高血压随访表ID
	 * 
	 * @return 高血压随访表ID
	 */
	public String getFhId() {
		return this.fhId;
	}

	/**
	 * 设置高血压随访表ID
	 * 
	 * @param fhId
	 *            高血压随访表ID
	 */
	public void setFhId(String fhId) {
		this.fhId = fhId;
	}

	/**
	 * 获取姓名
	 * 
	 * @return 姓名
	 */
	public String getFhName() {
		return this.fhName;
	}

	/**
	 * 设置姓名
	 * 
	 * @param fhName
	 *            姓名
	 */
	public void setFhName(String fhName) {
		this.fhName = fhName;
	}

	/**
	 * 获取编号
	 * 
	 * @return 编号
	 */
	public String getFhCode() {
		return this.fhCode;
	}

	/**
	 * 设置编号
	 * 
	 * @param fhCode
	 *            编号
	 */
	public void setFhCode(String fhCode) {
		this.fhCode = fhCode;
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
	 *            随访日期
	 */
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	/**
	 * 获取随访方式:1门诊 2家庭 3电话
	 * 
	 * @return 随访方式
	 */
	public Integer getFollowType() {
		return this.followType;
	}

	/**
	 * 设置随访方式:1门诊 2家庭 3电话
	 * 
	 * @param followType
	 *            随访方式:1门诊 2家庭 3电话
	 */
	public void setFollowType(Integer followType) {
		this.followType = followType;
	}

	/**
	 * 获取症状:1无症状2头痛头晕3恶心呕吐4眼花耳鸣5呼吸困难6心悸胸闷7鼻衄出血不止8四肢发麻9下肢水肿
	 * 
	 * @return 症状
	 */
	public String getFhSymptom() {
		return this.fhSymptom;
	}

	/**
	 * 设置症状:1无症状2头痛头晕3恶心呕吐4眼花耳鸣5呼吸困难6心悸胸闷7鼻衄出血不止8四肢发麻9下肢水肿
	 * 
	 * @param fhSymptom
	 *            症状:1无症状2头痛头晕3恶心呕吐4眼花耳鸣5呼吸困难6心悸胸闷7鼻衄出血不止8四肢发麻9下肢水肿
	 */
	public void setFhSymptom(String fhSymptom) {
		this.fhSymptom = fhSymptom;
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
	 *            其他症状
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
	 *            血压(mmHg)
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
	 *            当前体重kg
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
	 *            目标体重
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
	 *            当前体质指数
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
	 *            目标体质指数
	 */
	public void setWeightIndexTarget(String weightIndexTarget) {
		this.weightIndexTarget = weightIndexTarget;
	}

	/**
	 * 获取心率
	 * 
	 * @return 心率
	 */
	public String getHeartRate() {
		return this.heartRate;
	}

	/**
	 * 设置心率
	 * 
	 * @param heartRate
	 *            心率
	 */
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
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
	 *            其他体征
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
	 *            当前日吸烟量(支)
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
	 *            目标吸烟量
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
	 *            当前日饮酒量
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
	 *            目标日饮酒量
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
	 *            当前运动频率（次/周）
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
	 *            目标运动频率（次/周）
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
	 *            当前运动时间（分/天）
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
	 *            目标运动时间（分/天）
	 */
	public void setSportsTargetTime(Integer sportsTargetTime) {
		this.sportsTargetTime = sportsTargetTime;
	}

	/**
	 * 获取摄盐情况: 1 轻 2 中 3 重
	 * 
	 * @return 摄盐情况
	 */
	public Integer getEatSalt() {
		return this.eatSalt;
	}

	/**
	 * 设置摄盐情况: 1 轻 2 中 3 重
	 * 
	 * @param eatSalt
	 *            摄盐情况: 1 轻 2 中 3 重
	 */
	public void setEatSalt(Integer eatSalt) {
		this.eatSalt = eatSalt;
	}

	/**
	 * 获取心里调整:1良好 2一般 3差
	 * 
	 * @return 心里调整
	 */
	public Integer getHeartAdjust() {
		return this.heartAdjust;
	}

	/**
	 * 设置心里调整:1良好 2一般 3差
	 * 
	 * @param heartAdjust
	 *            心里调整:1良好 2一般 3差
	 */
	public void setHeartAdjust(Integer heartAdjust) {
		this.heartAdjust = heartAdjust;
	}

	/**
	 * 获取遵医行为:1良好 2一般 3差
	 * 
	 * @return 遵医行为
	 */
	public Integer getComply() {
		return this.comply;
	}

	/**
	 * 设置遵医行为:1良好 2一般 3差
	 * 
	 * @param comply
	 *            遵医行为:1良好 2一般 3差
	 */
	public void setComply(Integer comply) {
		this.comply = comply;
	}

	/**
	 * 获取辅助检查
	 * 
	 * @return 辅助检查
	 */
	public String getAssistCheck() {
		return this.assistCheck;
	}

	/**
	 * 设置辅助检查
	 * 
	 * @param assistCheck
	 *            辅助检查
	 */
	public void setAssistCheck(String assistCheck) {
		this.assistCheck = assistCheck;
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
	 *            服药依从性:1规律2间断3不服药
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
	 *            此次随访分类:1控制满意2控制不满意3不良反应 4并发症
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
	 *            转诊原因
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
	 *            转诊机构及科别
	 */
	public void setOriginDepart(String originDepart) {
		this.originDepart = originDepart;
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
	 *            下次随访时间
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
	 *            随访医生
	 */
	public void setFollowDoctor(String followDoctor) {
		this.followDoctor = followDoctor;
	}
}