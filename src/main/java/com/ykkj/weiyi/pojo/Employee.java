package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Employee {
    //主键唯一ID
	private String id;
	//科室ID
	private String departId;
	//员工编码
	private String employeeCode;
	//员工姓名
	private String employeeName;
	//性别
	private String sex;
	//出生年月日
	private Date birth;
	//学历
	private String education;
	//参加工作时间
	private Timestamp takeWorkTime;
	//执业资格取得时间
	private Timestamp getTime;
	//执业资格证编码
	private String certificateTime;
	//职务
	private String hisoffice;
	//手机
	private String phone;
	//邮箱
	private String email;
	//简介
	private String brief;
	//擅长领域
	private String goodsArea;
	//学术成就
	private String academicSuccess;
	//咨询费
	private Integer conFee;
	//会诊费
	private Integer groupFee;
	//转诊费(分)
	private Integer referralFee;
	//头像
	private String headImg;
	//毕业证书
	private String graduationCertificate;
	//职称证书
	private String professionalCertificate;
	//身份证号
	private String idcard;
	//职称
	private String positionalTitles;
	//所属医院
	private String hospName;
	//所属科室
	private String departName;
	//提问次数
	private Integer question;
	//回答次数
	private Integer  answer;
	//好评度
	private Integer goodStar;
	//是否开通家庭医生：0 关闭（默认） 1 开通
     private int  isOpenDoctor;
	//是否开通咨询问诊:0 关闭 1 开通
	 private int  isAsk;
	//是否接受咨询
	private Integer isConsult;
	//医生端ID
	private String udpId;
    //家庭医生费用
    private Integer signFee;
    //是否接受上门
    private Integer isVisit;
    //上门费用
    private Integer visitFee;
   //是否接受转诊
    private Integer isReferral;
    
    private String hisDepartmentId;
    
    private String  hospId;
    
    private Integer isConnHis;
    
    private String doctorQr;
    
    
    
    
	public String getDoctorQr() {
		return doctorQr;
	}
	public void setDoctorQr(String doctorQr) {
		this.doctorQr = doctorQr;
	}
	public Integer getIsConnHis() {
		return isConnHis;
	}
	public void setIsConnHis(Integer isConnHis) {
		this.isConnHis = isConnHis;
	}
	public String getHospId() {
		return hospId;
	}
	public void setHospId(String hospId) {
		this.hospId = hospId;
	}
	public String getHisDepartmentId() {
		return hisDepartmentId;
	}
	public void setHisDepartmentId(String hisDepartmentId) {
		this.hisDepartmentId = hisDepartmentId;
	}
	public Integer getSignFee() {
		return signFee;
	}
	public void setSignFee(Integer signFee) {
		this.signFee = signFee;
	}
	public Integer getIsVisit() {
		return isVisit;
	}
	public void setIsVisit(Integer isVisit) {
		this.isVisit = isVisit;
	}
	public Integer getVisitFee() {
		return visitFee;
	}
	public void setVisitFee(Integer visitFee) {
		this.visitFee = visitFee;
	}
	public Integer getIsReferral() {
		return isReferral;
	}
	public void setIsReferral(Integer isReferral) {
		this.isReferral = isReferral;
	}
	public Integer getIsConsult() {
			return isConsult;
		}
		public void setIsConsult(Integer isConsult) {
			this.isConsult = isConsult;
		}
		public String getUdpId() {
			return udpId;
		}
		public void setUdpId(String udpId) {
			this.udpId = udpId;
		}
	public int getIsOpenDoctor() {
		return isOpenDoctor;
	}
	public void setIsOpenDoctor(int isOpenDoctor) {
		this.isOpenDoctor = isOpenDoctor;
	}
	public int getIsAsk() {
		return isAsk;
	}
	public void setIsAsk(int isAsk) {
		this.isAsk = isAsk;
	}
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public Integer getGoodStar() {
		return goodStar;
	}
	public void setGoodStar(Integer goodStar) {
		this.goodStar = goodStar;
	}
	public String getHospName() {
		return hospName;
	}
	public void setHospName(String hospName) {
		this.hospName = hospName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Timestamp getTakeWorkTime() {
		return takeWorkTime;
	}
	public void setTakeWorkTime(Timestamp takeWorkTime) {
		this.takeWorkTime = takeWorkTime;
	}
	public Timestamp getGetTime() {
		return getTime;
	}
	public void setGetTime(Timestamp getTime) {
		this.getTime = getTime;
	}
	public String getCertificateTime() {
		return certificateTime;
	}
	public void setCertificateTime(String certificateTime) {
		this.certificateTime = certificateTime;
	}
	public String getHisoffice() {
		return hisoffice;
	}
	public void setHisoffice(String hisoffice) {
		this.hisoffice = hisoffice;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getGoodsArea() {
		return goodsArea;
	}
	public void setGoodsArea(String goodsArea) {
		this.goodsArea = goodsArea;
	}
	public String getAcademicSuccess() {
		return academicSuccess;
	}
	public void setAcademicSuccess(String academicSuccess) {
		this.academicSuccess = academicSuccess;
	}
	public Integer getConFee() {
		return conFee;
	}
	public void setConFee(Integer conFee) {
		this.conFee = conFee;
	}
	public Integer getGroupFee() {
		return groupFee;
	}
	public void setGroupFee(Integer groupFee) {
		this.groupFee = groupFee;
	}
	public Integer getReferralFee() {
		return referralFee;
	}
	public void setReferralFee(Integer referralFee) {
		this.referralFee = referralFee;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getGraduationCertificate() {
		return graduationCertificate;
	}
	public void setGraduationCertificate(String graduationCertificate) {
		this.graduationCertificate = graduationCertificate;
	}
	public String getProfessionalCertificate() {
		return professionalCertificate;
	}
	public void setProfessionalCertificate(String professionalCertificate) {
		this.professionalCertificate = professionalCertificate;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPositionalTitles() {
		return positionalTitles;
	}
	public void setPositionalTitles(String positionalTitles) {
		this.positionalTitles = positionalTitles;
	}

}
