package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PmsPlanTzkz03 {
    private String id;

    private String mId;

    private String item;

    private String sn;

    private BigDecimal gspfJine;

    private BigDecimal lastyearWctz;

    private BigDecimal bnKhjh;

    private BigDecimal byFjjh;

    private BigDecimal byWctzSjcz;

    private BigDecimal byWctzZhgs;

    private BigDecimal zbyWctzSjcz;

    private BigDecimal zbyWctzZhgs;

    private Date insertTime;

    private Date creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public BigDecimal getGspfJine() {
        return gspfJine;
    }

    public void setGspfJine(BigDecimal gspfJine) {
        this.gspfJine = gspfJine;
    }

    public BigDecimal getLastyearWctz() {
        return lastyearWctz;
    }

    public void setLastyearWctz(BigDecimal lastyearWctz) {
        this.lastyearWctz = lastyearWctz;
    }

    public BigDecimal getBnKhjh() {
        return bnKhjh;
    }

    public void setBnKhjh(BigDecimal bnKhjh) {
        this.bnKhjh = bnKhjh;
    }

    public BigDecimal getByFjjh() {
        return byFjjh;
    }

    public void setByFjjh(BigDecimal byFjjh) {
        this.byFjjh = byFjjh;
    }

    public BigDecimal getByWctzSjcz() {
        return byWctzSjcz;
    }

    public void setByWctzSjcz(BigDecimal byWctzSjcz) {
        this.byWctzSjcz = byWctzSjcz;
    }

    public BigDecimal getByWctzZhgs() {
        return byWctzZhgs;
    }

    public void setByWctzZhgs(BigDecimal byWctzZhgs) {
        this.byWctzZhgs = byWctzZhgs;
    }

    public BigDecimal getZbyWctzSjcz() {
        return zbyWctzSjcz;
    }

    public void setZbyWctzSjcz(BigDecimal zbyWctzSjcz) {
        this.zbyWctzSjcz = zbyWctzSjcz;
    }

    public BigDecimal getZbyWctzZhgs() {
        return zbyWctzZhgs;
    }

    public void setZbyWctzZhgs(BigDecimal zbyWctzZhgs) {
        this.zbyWctzZhgs = zbyWctzZhgs;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}