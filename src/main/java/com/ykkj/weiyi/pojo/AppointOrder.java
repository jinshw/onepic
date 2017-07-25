package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 预约挂号订单表实体类（PF_APPOINT_ORDER）
 * Created by Administrator on 2016/8/19 0019.
 */
public class AppointOrder {
    //挂号订单主键ID
    private String appointOrderId;
    //医院ID
    private String hospId;
    //医院名称
    private String hospName;
    //科室ID
    private String departId;
    //科室名称
    private String departName;
    //医生ID
    private String doctorId;
    //医生名称
    private String doctorName;
	//医生职称
    private String doctorTitle;
	//就诊人ID
    private String patientId;
    //就诊人名称
    private String patientName;
    //就诊卡号
    private String cardNum;
	//就诊日期
    private String regDate;
    //就诊时间段
    private String visitTime;
	//挂号类型：1 预约挂号 2 当天挂号
    private Integer appointType;
    //挂号费用（分）
    private String regFee;
    //诊疗费（分）
    private String treatFee;
    //	挂号费用（单位元）
    private Float fee;
    //订单状态：	0待支付	1已支付	2已取消	3已退费 	4已预约 --- his支付状态
    private Integer orderType;
    //订单创建时间
    private Date orderTime;
    //最后修改时间
    private Date modifyTime;
    //操作人员
    private String optPersion;
    //HIS系统订单号
    private String hisOrderId;
	//第三方平台流水号
	private String orderPayId;
	//支付方式 ALIPAY ----支付宝 WECHAT----微信
    private String payMode;
	//公众账号ID
    private String appId;
	//随机字符串
    private String nonceStr;
	//签名
    private String sign;
	//业务结果：	SUCCESS/微信支付成功  REFUND/管理员退款，UREFUND/用户自退款，EXREFUND/his系统错误退款，FAREFUND/微信退款失败 --- 微信支付状态
    private String resultCode;
	//号源生成结果表ID
	private String resultId;
	//就诊号
	private String printmsg;

	public String getAppointOrderId() {
        return appointOrderId;
    }

    public void setAppointOrderId(String appointOrderId) {
        this.appointOrderId = appointOrderId == null ? null : appointOrderId.trim();
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName == null ? null : hospName.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle == null ? null : doctorTitle.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate == null ? null : regDate.trim();
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime == null ? null : visitTime.trim();
    }

    public Integer getAppointType() {
        return appointType;
    }

    public void setAppointType(Integer appointType) {
        this.appointType = appointType;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee == null ? null : regFee.trim();
    }

    public String getTreatFee() {
        return treatFee;
    }

    public void setTreatFee(String treatFee) {
        this.treatFee = treatFee == null ? null : treatFee.trim();
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOptPersion() {
        return optPersion;
    }

    public void setOptPersion(String optPersion) {
        this.optPersion = optPersion == null ? null : optPersion.trim();
    }

    public String getHisOrderId() {
        return hisOrderId;
    }

    public void setHisOrderId(String hisOrderId) {
        this.hisOrderId = hisOrderId == null ? null : hisOrderId.trim();
    }

    public String getOrderPayId() {
        return orderPayId;
    }

    public void setOrderPayId(String orderPayId) {
        this.orderPayId = orderPayId == null ? null : orderPayId.trim();
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr == null ? null : nonceStr.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

	public String getPrintmsg() {
		return printmsg;
	}

	public void setPrintmsg(String printmsg) {
		this.printmsg = printmsg;
	}
    
}