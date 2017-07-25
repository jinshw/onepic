package com.ykkj.weiyi.pojo;

import java.util.Date;

/**
 * 
 * <p>Title: BillRecord<p>
 * <p>Description: 诊间支付记录表<p>
 * <p>Cpompany : yukang<p>
 * @author 	LTB
 * @date 	2016年10月27日 下午3:39:30
 * @version 1.0
 */
public class BillRecord {
    private String billOrderId;//诊间支付单号主键，唯一ID

    private String userId;//用户ID

    private String hospId;//医院ID

    private String settleCategory;//结算类型 微信：98、支付宝：99

    private String brid;//病人ID

    private String cardNum;//就诊卡号

    private String djh;//医院单据号

    private Float je;//单据结算金额（单位元）

    private Integer djlx;//单据类型，0-收费单，1-挂号单

    private String jsklb;//医院结算卡类别(传 微信)

    private Integer zfzt;//医院支付状态 0-待支付，1-已支付，2-已退费

    private String djdjhs;//收费单据号串，逗号分隔多个单据号
    
    private Date kdsj;//开单时间

    private String appid;//公众账号ID

    private String mchId;//商户号

    private String transactionId;//微信支付订单号

    private Integer totalFee;//微信订单金额

    private String timeEnd;//支付完成时间

    private String refundId;//微信退款单号

    private Integer refundFee;//微信退款金额
    
    private String resultCode;//业务结果SUCCESS/FAIL

    private Date modifyTime;//最后修改时间

    private Integer recordType;//交易记录状态 0-待支付，1-已支付，2-已退费

    private String yzids;//医嘱ID，格式为“医嘱ID1|医嘱ID2|……”

    public String getBillOrderId() {
        return billOrderId;
    }

    public void setBillOrderId(String billOrderId) {
        this.billOrderId = billOrderId == null ? null : billOrderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId == null ? null : hospId.trim();
    }

    public String getSettleCategory() {
        return settleCategory;
    }

    public void setSettleCategory(String settleCategory) {
        this.settleCategory = settleCategory == null ? null : settleCategory.trim();
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid == null ? null : brid.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh == null ? null : djh.trim();
    }

    public Float getJe() {
        return je;
    }

    public void setJe(Float je) {
        this.je = je;
    }

    public Integer getDjlx() {
        return djlx;
    }

    public void setDjlx(Integer djlx) {
        this.djlx = djlx;
    }

    public String getJsklb() {
        return jsklb;
    }

    public void setJsklb(String jsklb) {
        this.jsklb = jsklb == null ? null : jsklb.trim();
    }

    public Integer getZfzt() {
        return zfzt;
    }

    public void setZfzt(Integer zfzt) {
        this.zfzt = zfzt;
    }

    public String getDjdjhs() {
        return djdjhs;
    }

    public void setDjdjhs(String djdjhs) {
        this.djdjhs = djdjhs == null ? null : djdjhs.trim();
    }

    public Date getKdsj() {
        return kdsj;
    }

    public void setKdsj(Date kdsj) {
        this.kdsj = kdsj;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd == null ? null : timeEnd.trim();
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId == null ? null : refundId.trim();
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public String getYzids() {
        return yzids;
    }

    public void setYzids(String yzids) {
        this.yzids = yzids == null ? null : yzids.trim();
    }
}