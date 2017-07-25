package com.ykkj.weiyi.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class OutPatient implements Serializable {

    /** identifier field */
    private String patientId;

    /** nullable persistent field */
    private String id;

    /** nullable persistent field */
    private Integer otype;

    /** nullable persistent field */
    private String patientName;

    /** nullable persistent field */
    private Integer sex;

    /** nullable persistent field */
    private Date birthday;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String idNum;

    /** nullable persistent field */
    private String idType;

    /** nullable persistent field */
    private String city;

    /** persistent field */
    private Integer bindcardcnt;

    /** default constructor */
    public OutPatient() {
    }

    /** minimal constructor */
    public OutPatient(String id, Integer bindcardcnt) {
        this.id = id;
        this.bindcardcnt = bindcardcnt;
    }
    
	public OutPatient(String patientId, String id, Integer otype,
			String patientName, Integer sex, Date birthday, String mobile,
			String idNum, String idType, String city, Integer bindcardcnt) {
		super();
		this.patientId = patientId;
		this.id = id;
		this.otype = otype;
		this.patientName = patientName;
		this.sex = sex;
		this.birthday = birthday;
		this.mobile = mobile;
		this.idNum = idNum;
		this.idType = idType;
		this.city = city;
		this.bindcardcnt = bindcardcnt;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOtype() {
		return otype;
	}

	public void setOtype(Integer otype) {
		this.otype = otype;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBindcardcnt() {
		return bindcardcnt;
	}

	public void setBindcardcnt(Integer bindcardcnt) {
		this.bindcardcnt = bindcardcnt;
	}

}
