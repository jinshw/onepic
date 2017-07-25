package com.ykkj.weiyi.pojo;

import java.io.Serializable;

public class UserDoctorApp implements Serializable {
/**
 * 	医生用户ID
 */
private String udpId;
/**
 * 	登录手机号
 */
private String mobile;
/**
 * 登录密码	
 */
private String password;
/**
 * 真是姓名	
 */
private String nameTrue;
/**
 * 	性别
 */
private Integer sex;
/**
 * 	身份证号码（证件号码）
 */
private String idCard;
/**
 * 	证件类型：1 .身份证
 */
private String cardType;
/**
 * 	职业资格证编码
 */
private String certificate;
/**
 * 	职业资格证图片地址
 */
private String certificatepath;
/**
 * 	头像
 */
private String headImg;
/**
 * 	是否接收咨询:0 不接收 1 接收
 */
private Integer isConsult;
/**
 * 	是否接收签约:0 不接收 1 接收
 */
private Integer isSign;
/**
 * 	是否接收转诊:0 不接收 1 接收
 */
private Integer isReferral;
/**
 * 	是否接收上门:0 不接收 1接收
 */
private Integer isVisit;
//上门费用
private Integer visitFee;
//签约家庭医生费用
private Integer signFee;
//转诊
private Integer referralFee;
//咨询
private Integer conFee;

private String doctorQr;

private Integer openTeam;





public Integer getOpenTeam() {
	return openTeam;
}
public void setOpenTeam(Integer openTeam) {
	this.openTeam = openTeam;
}
public String getDoctorQr() {
	return doctorQr;
}
public void setDoctorQr(String doctorQr) {
	this.doctorQr = doctorQr;
}
public Integer getVisitFee() {
	return visitFee;
}
public void setVisitFee(Integer visitFee) {
	this.visitFee = visitFee;
}
public Integer getSignFee() {
	return signFee;
}
public void setSignFee(Integer signFee) {
	this.signFee = signFee;
}
public Integer getReferralFee() {
	return referralFee;
}
public void setReferralFee(Integer referralFee) {
	this.referralFee = referralFee;
}
public Integer getConFee() {
	return conFee;
}
public void setConFee(Integer conFee) {
	this.conFee = conFee;
}
public String getUdpId() {
	return udpId;
}
public void setUdpId(String udpId) {
	this.udpId = udpId;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNameTrue() {
	return nameTrue;
}
public void setNameTrue(String nameTrue) {
	this.nameTrue = nameTrue;
}
public Integer getSex() {
	return sex;
}
public void setSex(Integer sex) {
	this.sex = sex;
}
public String getIdCard() {
	return idCard;
}
public void setIdCard(String idCard) {
	this.idCard = idCard;
}
public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}
public String getCertificate() {
	return certificate;
}
public void setCertificate(String certificate) {
	this.certificate = certificate;
}
public String getCertificatepath() {
	return certificatepath;
}
public void setCertificatepath(String certificatepath) {
	this.certificatepath = certificatepath;
}
public String getHeadImg() {
	return headImg;
}
public void setHeadImg(String headImg) {
	this.headImg = headImg;
}
public Integer getIsConsult() {
	return isConsult;
}
public void setIsConsult(Integer isConsult) {
	this.isConsult = isConsult;
}
public Integer getIsSign() {
	return isSign;
}
public void setIsSign(Integer isSign) {
	this.isSign = isSign;
}
public Integer getIsReferral() {
	return isReferral;
}
public void setIsReferral(Integer isReferral) {
	this.isReferral = isReferral;
}
public Integer getIsVisit() {
	return isVisit;
}
public void setIsVisit(Integer isVisit) {
	this.isVisit = isVisit;
}

}
