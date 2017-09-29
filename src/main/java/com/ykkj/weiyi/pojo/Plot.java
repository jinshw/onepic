package com.ykkj.weiyi.pojo;

import java.util.Date;

public class Plot {
    private Integer id;
    private Double pointx;
    private Double pointy;
    private String content;
    private String keycode;
    private Date createtime;
    private String createuser;

    public Integer getId() {
        return id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPointx() {
        return pointx;
    }

    public void setPointx(Double pointx) {
        this.pointx = pointx;
    }

    public Double getPointy() {
        return pointy;
    }

    public void setPointy(Double pointy) {
        this.pointy = pointy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }
}
