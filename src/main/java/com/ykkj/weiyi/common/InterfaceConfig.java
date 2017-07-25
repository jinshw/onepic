package com.ykkj.weiyi.common;


/**
 * Created by jinshw on 2016/7/25.
 */
public class InterfaceConfig {

	/* ------------ 中心医院 begin ------------ */
    /**
     * HTTP 接口（包头中心医院）
     */
    public static final String HTTP_ADDRESS = "http://222.74.41.18:8885/ExternalServices/ZL_InformationService.asmx";
    public static final String HTTP_T_TOKEN = "6682FE192AAA63FB89A5E0EF689563B3";
    public static final String HTTP_T_KEY = "92544083A6B3FCC0";
    // 模块名称
    public static final String USERMANAGER_SERVICE = "UserManager";//用户管理模块
    public static final String OUTPATIENT_SERVICE = "OutPatient";//门诊业务模块
    public static final String INFORMATION_SERVICE = "Information";//数据服务模块
    public static final String HOSPITALIZATION_SERVICE = "Hospitalization";//住院业务模块
    // 4.3.1.挂号
    public static final String REGISTER_DEPART_QUERY = "Register.Depart.Query";// 4.3.1.1.	获取挂号科室
    public static final String REGISTER_SIGNALSOURCE_QUERY = "Register.SignalSource.Query";// 4.3.1.2.	获取挂号号源
    public static final String REGISTER_LOCK_MODIFY = "Register.Lock.Modify";//4.3.1.4.	锁定号源
    public static final String REGISTER_UNLOCK_MODIFY = "Register.UnLock.Modify";//4.3.1.5.	解锁号源
    public static final String REGISTER_CONFIRM_MODIFY = "Register.Confirm.Modify";//4.3.1.6.	挂号
    public static final String REGISTER_CANCELCHECK_QUERY = "Register.CancelCheck.Query";//4.3.1.7.	退号检查
    public static final String REGISTER_CANCEL_MODIFY = "Register.Cancel.Modify";//4.3.1.8.	退号
    public static final String REGISTER_LIMITINFO_QUERY = "Register.LimitInfo.Query";//4.3.1.9.	获取挂号限制条
    // 4.3.2 缴费
    public static final String PAYMENT_PAYRECEIPT_QUERY = "Payment.PayReceipt.Query";// 4.3.2.1.	获取缴费单据信息
    public static final String PAYMENT_SINGLEADVICERECEIPT_QUERY = "Payment.SingleAdviceReceipt.Query";//4.3.2.2.获取指定医嘱缴费详情
    public static final String PAYMENT_PAY_MODIFY = "Payment.Pay.Modify";//4.3.2.3.付款
    public static final String PAYMENT_CANCELCHECK_QUERY = "Payment.CancelCheck.Query";//4.3.2.4.	退费检查
    public static final String PAYMENT_CANCEL_MODIFY = "Payment.Cancel.Modify";//4.3.2.5.	退费
    // 4.4.1.	预交款
    public static final String PREPAYMENT_BALANCE_QUERY = "PrePayment.Balance.Query";//4.4.1.1.	获取病人预交款余额
    public static final String PREPAYMENT_RECORD_QUERY = "PrePayment.Record.Query";//4.4.1.2.	获取预交款缴款记录
    public static final String PREPAYMENT_PAY_QUERY = "PrePayment.Pay.Query";//4.4.1.3.	缴预交款
    public static final String PREPAYMENT_ALARMVALUE_QUERY = "PrePayment.AlarmValue.Query";//4.4.1.4.	获取预交款报警值
    // 4.4.2.	住院查询
    public static final String INFORMATION_RECORD_QUERY = "Information.Record.Query";//4.4.2.1.	获取历次住院记录
    public static final String INFORMATION_DETAIL_QUERY = "Information.Detail.Query";//4.4.2.2.	获取住院详情
    public static final String INFORMATION_PAYDETAIL_QUERY = "Information.PayDetail.Query";//4.4.2.3.	获取总费用清单
    public static final String INFORMATION_DAILYPAYDETAIL_QUERY = "Information.DailyPayDetail.Query";//4.4.2.4.	获取日费用清单
    // 4.4.3.	住院结帐
    public static final String BUSINESS_INSETTLEMENT_QUERY = "Business.InSettlement.Query";//4.4.3.1.	获取住院结帐数据
    public static final String BUSINESS_INSETTLEMENTCONFIRM_MODIFY = "Business.InsettlementConfirm.Modify";//4.4.3.2.	住院费用结算
    // 4.7.2.	业务数据
    public static final String BUSINESS_TRANSDATA_QUERY = "Business.TransData.Query";//4.7.2.5.	获取交易明细数据（按日）
    /* ------------ 中心医院 end ------------ */
    /** ------------------------------- 华丽的分界线 ------------------------------- **/
    /* ------------ 肿瘤医院、包钢三院 begin ------------ */
    /**
     * webService 接口（肿瘤医院）
     */
    public static final String WS_ADDRESS_ZL = "http://1.180.52.90:8888/his/service/lcjk365?wsdl";
    public static final String WS_URL_ZL = "http://www.100wit.com/ps－app/public/services/";
    public static final String WS_KEY_ZL = "08xASYBEtufTqjWdfdsfsdfdddXlSTaPwOq1aW5GdPziQ";
    public static final String WS_ADDRESS_APPOINTMENT = "http://1.180.52.90:8888/his/service/lcjk365?wsdl";
    public static final String WS_URL_APPOINTMENT = "http://1.180.52.90:8888/his/service/lcjk365";
    public static final String WS_KEY_APPOINTMENT = "08xASYBEtufTqjWdfdsfsdfdddXlSTaPwOq1aW5GdPziQ";
    //2.1.1 医院信息
    public static final String GET_HOSPITAL_INFO = "getHospitalInfo001";//2.1.1.1 医院信息查询接口001
    public static final String GET_DEPT_INFO = "getDeptInfo001";//2.1.1.2 科室信息查询接口001
    //2.2.1	挂号公共
    public static final String GETDEPTREGINFO_ONE = "getDeptRegInfo001";//2.2.1.1 科室挂号信息查询接口001
    public static final String GETDRREGINFO_ONE = "getDrRegInfo001";//2.2.1.2 医生挂号信息查询接口001
    public static final String GETDRREGSCHEDULEINFO_ONE = "getDrRegScheduleInfo001";//2.2.1.3 医生挂号班别信息查询接口001
    public static final String GETDRREGSCHEDULEINFO_TWO = "getDrRegScheduleInfo002";//2.2.1.4 医生挂号班别信息查询接口002
    public static final String GETDRREGTIMEINFO_ONE = "getDrRegTimeInfo001";//2.2.1.5 医生挂号分时号源信息接口001
    public static final String REGORDERCHECKIN_ONE = "regOrderCheckin001";//2.2.1.6 挂号订单报到取号接口001
    public static final String GETREGORDERINFO_ONE = "getRegOrderInfo001";//2.2.1.7 挂号订单查询接口001
    public static final String RETURNREFUNDNO_ONE = "returnRefundNo001";//2.2.1.8 退费回传退费单号接口001
    //2.2.2	预约挂号
    public static final String ADDPREREGORDER_ONE = "addPreRegOrder001";//2.2.2.1 生成预约挂号订单接口001
    public static final String CANCELPREREGORDER_ONE = "cancelPreRegOrder001";//2.2.2.2 取消预约挂号订单接口001
    public static final String PAYPREREGORDER_ONE = "payPreRegOrder001";//2.2.2.3 预约挂号订单支付接口001
    public static final String REFUNDPREREG_ONE = "refundPreReg001";//2.2.2.4 预约挂号订单退费接口001
    //2.2.3	当班挂号
    public static final String lockRegSeqToday_ONE = "lockRegSeqToday001";//2.2.3.1 当天挂号号源锁定接口001
    public static final String UNLOCKREGSEQTODAY_ONE = "unlockRegSeqToday001";//2.2.3.2 当天挂号解除锁定接口001
    public static final String ADDREGORDER_ONE = "addRegOrder001";//2.2.3.3 当天挂号接口001
    //2.2.4	诊间支付
    public static final String OUTPATIENT_GETPAYINFO = "outpatient.getPayInfo"; // 2.2.4.1 待缴费记录查询
    public static final String OUTPATIENT_GETPAYBILLFEE = "outpatient.getPaybillfee"; // 2.2.4.2 获取待缴费用信息
    public static final String OUTPATIENT_PAY = "outpatient.pay"; // 2.2.4.3 待缴费记录支付
    public static final String OUTPATIENT_GETCOMPLETEDPAYINFO = "outpatient.getCompletedPayInfo"; // 2.2.4.4 已缴费记录查询
    public static final String OUTPATIENT_GETCOMPLETEDPAYDETAILINFO = "outpatient.getCompletedPayDetailInfo"; // 2.2.4.5 已缴费记录明细查询
    public static final String OUTPATIENT_PAYCANCELMODIFY = "outpatient.payCancelModify"; // 2.2.4.9 退费
    /* ------------ 肿瘤医院、包钢三院 end ------------ */
}
