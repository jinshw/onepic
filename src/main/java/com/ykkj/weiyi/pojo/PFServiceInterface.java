package com.ykkj.weiyi.pojo;

public class PFServiceInterface {
    /**
     * 接口信息表ID
     */
    private String sinfId;

    /**
     * 医院ID
     */
    private String hospId;

    /**
     * 接口服务名称
     */
    private String sinfName;

    /**
     * 服务地址URL
     */
    private String sinfUrl;

    /**
     * 与HIS约定KEY
     */
    private String keyValue;

    /**
     * ΢微信商户号ID
     */
    private String mchId;

    /**
     * 商户密钥KEY
     */
    private String mchKey;
    
    /**
     * 微信证书路径
     */
    private String certPath;

    /**
     * 是否调用HIS接口:默认0：未调用，1调用HIS，2 调用平台本地
     */
    private Integer connHis;

    /**
     * 支付方式：0 微信在线支付 1 线下窗口支付
     */
    private Integer payType;

    /**
     * 支付提醒信息
     */
    private String payPrompt;
    
    /**
     * APP企业应用ID
     */
    private String appAppid;
    
    /**
     * APP微信商户号ID
     */
    private String appMchId;
    
    /**
     * APP商户密钥KEY
     */
    private String appMchKey;
    
    /**
     * APP微信证书路径
     */
    private String appCertPath;
    
	public String getAppAppid() {
		return appAppid;
	}

	public void setAppAppid(String appAppid) {
		this.appAppid = appAppid;
	}

	public String getAppMchId() {
		return appMchId;
	}

	public void setAppMchId(String appMchId) {
		this.appMchId = appMchId;
	}

	public String getAppMchKey() {
		return appMchKey;
	}

	public void setAppMchKey(String appMchKey) {
		this.appMchKey = appMchKey;
	}

	public String getAppCertPath() {
		return appCertPath;
	}

	public void setAppCertPath(String appCertPath) {
		this.appCertPath = appCertPath;
	}

	public Integer getConnHis() {
		return connHis;
	}

	public void setConnHis(Integer connHis) {
		this.connHis = connHis;
	}

	public String getSinfId() {
        return sinfId;
    }

    public void setSinfId(String sinfId) {
        this.sinfId = sinfId == null ? null : sinfId.trim();
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getSinfName() {
        return sinfName;
    }

    public void setSinfName(String sinfName) {
        this.sinfName = sinfName == null ? null : sinfName.trim();
    }

    public String getSinfUrl() {
        return sinfUrl;
    }

    public void setSinfUrl(String sinfUrl) {
        this.sinfUrl = sinfUrl == null ? null : sinfUrl.trim();
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey == null ? null : mchKey.trim();
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath == null ? null : certPath.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayPrompt() {
        return payPrompt;
    }

    public void setPayPrompt(String payPrompt) {
        this.payPrompt = payPrompt;
    }
}