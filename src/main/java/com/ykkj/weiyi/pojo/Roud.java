package com.ykkj.weiyi.pojo;

public class Roud {
    private String roudid;
    private String roudname;
    private String roudtype;
    private Long roudlevel;
    private Double roudlength;
    private Integer roudstatus;
    private Double startlon;
    private Double startlat;
    private Double endlon;
    private Double endlat;
    private String parentid;
    private String smid;

    /**
     * Getter for property 'smid'.
     *
     * @return Value for property 'smid'.
     */
    public String getSmid() {
        return smid;
    }

    /**
     * Setter for property 'smid'.
     *
     * @param smid Value to set for property 'smid'.
     */
    public void setSmid(String smid) {
        this.smid = smid;
    }


    public String getRoudid() {
        return roudid;
    }

    public void setRoudid(String roudid) {
        this.roudid = roudid;
    }

    public String getRoudname() {
        return roudname;
    }

    public void setRoudname(String roudname) {
        this.roudname = roudname;
    }

    public String getRoudtype() {
        return roudtype;
    }

    public void setRoudtype(String roudtype) {
        this.roudtype = roudtype;
    }

    public Long getRoudlevel() {
        return roudlevel;
    }

    public void setRoudlevel(Long roudlevel) {
        this.roudlevel = roudlevel;
    }

    public Double getRoudlength() {
        return roudlength;
    }

    public void setRoudlength(Double roudlength) {
        this.roudlength = roudlength;
    }

    public Integer getRoudstatus() {
        return roudstatus;
    }

    public void setRoudstatus(Integer roudstatus) {
        this.roudstatus = roudstatus;
    }

    public Double getStartlon() {
        return startlon;
    }

    public void setStartlon(Double startlon) {
        this.startlon = startlon;
    }

    public Double getStartlat() {
        return startlat;
    }

    public void setStartlat(Double startlat) {
        this.startlat = startlat;
    }

    public Double getEndlon() {
        return endlon;
    }

    public void setEndlon(Double endlon) {
        this.endlon = endlon;
    }

    public Double getEndlat() {
        return endlat;
    }

    public void setEndlat(Double endlat) {
        this.endlat = endlat;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
