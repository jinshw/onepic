package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 气象
 */
public class Weather {
    public Integer id;
    // 1:radar,2:rain2h,3:cldasreal（实况降水）,4:ec_forecast(未来7天)
    public Integer type;
    // 时间间隔
    public Integer pointtime;
    //时间间隔单位 d天，h小时，m分钟，s秒
    public String pointunit;
    public String imgname;
    public String startlat;
    public String startlon;
    public String endlat;
    public String endlon;
    public Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPointtime() {
        return pointtime;
    }

    public void setPointtime(Integer pointtime) {
        this.pointtime = pointtime;
    }

    public String getPointunit() {
        return pointunit;
    }

    public void setPointunit(String pointunit) {
        this.pointunit = pointunit;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getStartlat() {
        return startlat;
    }

    public void setStartlat(String startlat) {
        this.startlat = startlat;
    }

    public String getStartlon() {
        return startlon;
    }

    public void setStartlon(String startlon) {
        this.startlon = startlon;
    }

    public String getEndlat() {
        return endlat;
    }

    public void setEndlat(String endlat) {
        this.endlat = endlat;
    }

    public String getEndlon() {
        return endlon;
    }

    public void setEndlon(String endlon) {
        this.endlon = endlon;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
