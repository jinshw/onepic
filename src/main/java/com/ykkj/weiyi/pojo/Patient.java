package com.ykkj.weiyi.pojo;

import java.util.Date;



/**
 * 就诊人实体类
 * Created by Administrator on 2016/8/18 0018.
 */
public class Patient {
    //就诊人ID
    private String patientId;
    //用户人ID
    private String userId;
    //就诊人名称
    private String patientName;
    //性别
    private Integer sex;
    //出生日期
    private Date birthDay;
    //证件类型
    private String idType;
    //证件号码
    private String idNum;
    //常驻城市
    private String city;
    //绑卡数量
    private Integer bindCardCnt;
    //默认1是自己，其他表示其他就诊人
    private Integer otype;
    //电话
    private String mobile;
    

    /**
     * 扩展字段
     */
    //值
    private String value;
    //标题
    private String title;
    //就诊卡号
    private String medicalcard;
    //户卡号
    private String familyCode;
    //年龄
    private Integer age;
    //医生患者关联表id
    private String ftId;
    //签约状态
    private String status;
    //签约具名地址
    private  String familyAddress;
    //头像
    private String headImg;
    //居民标签
    private String sign;
    //有效期
    private Date endDate;
    
    private String code;
    
    
    
    
    
    
    


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFtId() {
		return ftId;
	}

	public void setFtId(String ftId) {
		this.ftId = ftId;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBindCardCnt() {
        return bindCardCnt;
    }

    public void setBindCardCnt(Integer bindCardCnt) {
        this.bindCardCnt = bindCardCnt;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getOtype() {
        return otype;
    }

    public void setOtype(Integer otype) {
        this.otype = otype;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMedicalcard() {
        return medicalcard;
    }

    public void setMedicalcard(String medicalcard) {
        this.medicalcard = medicalcard;
    }
}
