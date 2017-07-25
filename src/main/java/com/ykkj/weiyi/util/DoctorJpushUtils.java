package com.ykkj.weiyi.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/10/26 0026.
 */
public class DoctorJpushUtils {
    public static final String masterSecret = "e0fdb7e30b80072e4bac5f32";
    public static final String appKey = "6563ef3ccbf29be5a801ab8c";

    /**
     * 发送所有终端设备消息
     *
     * @param content 发送的信息
     * @return
     */
    public static PushPayload buildPushObject_all_all_alert(String content) {
        return PushPayload.alertAll(content);
    }

    /**
     * 按照别名发送所有设备的指定个人
     *
     * @param alias 别名
     * @param alert 发送的信息
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert(String alias, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }

    
    /*
     * 推送个人消息
     */
    public static boolean pushToObject(String userMobile,String mContent){
    	boolean flag = false;
    	JPushClient jpushClient = null;
        jpushClient = new JPushClient(masterSecret, appKey);
        PushPayload payload = buildPushObject_all_alias_alert(userMobile,mContent);
        try {
			PushResult result = jpushClient.sendPush(payload);
			if(result!=null){
				flag =true;
			}
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
    }
    
    
    /*
     * 推送系统消息
     */
    public static boolean pushToEveryOne(String mContent){
    	boolean flag = false;
    	JPushClient jpushClient = null;
        jpushClient = new JPushClient(masterSecret, appKey);
        PushPayload payload = buildPushObject_all_all_alert(mContent);
        try {
			PushResult result = jpushClient.sendPush(payload);
			if(result!=null){
				flag =true;
			}
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
    }
    
    
    
    
    
    public static void main(String[] args) {
        Logger LOG = Logger.getLogger(DoctorJpushUtils.class);
        JPushClient jpushClient = null;
        jpushClient = new JPushClient(masterSecret, appKey);
        //别名发送
        PushPayload payload = buildPushObject_all_alias_alert("18201322320", "今晚月色真美");

    //  PushPayload payload = buildPushObject_all_all_alert("万圣节快乐");//发送到全部设备

        try {
            PushResult result = jpushClient.sendPush(payload);
//            SMS sms = SMS.content("Test SMS", 0);
//            PushResult result = jpushClient.sendAndroidMessageWithAlias("Test SMS", "test sms", sms, "alias1");
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }
}
