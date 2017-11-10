package com.ykkj.weiyi.pojo;

public class SectInfoWithBLOBs extends SectInfo {
    private String sectContent;

    private String zfbmc1;

    private String zfbmc2;

    public String getSectContent() {
        return sectContent;
    }

    public void setSectContent(String sectContent) {
        this.sectContent = sectContent == null ? null : sectContent.trim();
    }

    public String getZfbmc1() {
        return zfbmc1;
    }

    public void setZfbmc1(String zfbmc1) {
        this.zfbmc1 = zfbmc1 == null ? null : zfbmc1.trim();
    }

    public String getZfbmc2() {
        return zfbmc2;
    }

    public void setZfbmc2(String zfbmc2) {
        this.zfbmc2 = zfbmc2 == null ? null : zfbmc2.trim();
    }
}