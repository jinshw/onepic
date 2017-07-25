package com.ykkj.weiyi.pojo;

import java.util.Date;

public class DomiciliaryRegister {
	// 户籍表ID
    private String drId;
    // 户口本号码
    private String drNum;
    // 户籍地址
    private String drAddress;
    // 联系电话
    private String phone;
    // 创建时间
    private Date createtime;
    // 就诊人身份证号码
    private String patIdcard;

    public String getDrId() {
        return drId;
    }

    public void setDrId(String drId) {
        this.drId = drId == null ? null : drId.trim();
    }

    public String getDrNum() {
        return drNum;
    }

    public void setDrNum(String drNum) {
        this.drNum = drNum == null ? null : drNum.trim();
    }

    public String getDrAddress() {
        return drAddress;
    }

    public void setDrAddress(String drAddress) {
        this.drAddress = drAddress == null ? null : drAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPatIdcard() {
        return patIdcard;
    }

    public void setPatIdcard(String patIdcard) {
        this.patIdcard = patIdcard == null ? null : patIdcard.trim();
    }
}