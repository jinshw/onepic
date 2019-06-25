package com.ykkj.weiyi.quartz;

import com.ykkj.weiyi.common.CommonMail;
import com.ykkj.weiyi.common.StaticUtils;
import com.ykkj.weiyi.pojo.SendMessage;
import com.ykkj.weiyi.service.TrafficInfoService;
import com.ykkj.weiyi.service.TrafficeInfoForHWSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
// @Lazy(false)
public class EmailTask {
    Logger logger = Logger.getLogger("emailTask");
    public SendMessage sendMessage = new SendMessage();
    public CommonMail commonMail =  CommonMail.getCommonMail();

    @Autowired
    private TrafficeInfoForHWSerivce trafficeInfoForHWSerivce;


    //    @Scheduled(cron = "0/10 * * * * ? ")
    public void runMethod() {
        checkRttServer();
    }

    /**
     * 校验拥堵信息服务
     * 注：拥堵信息表中最后插入时间和当前时间差距为10分钟以上，则拥堵服务已停止，需要重启
     */
    public void checkRttServer() {
        logger.info("checkRttServer start ...");
        int count = trafficeInfoForHWSerivce.findNums();
        if (count == 0) {
            sendMessage.setHost(StaticUtils.emailHost);
            sendMessage.setPort(StaticUtils.emailPort);
            sendMessage.setUserName(StaticUtils.emailUsername);
            sendMessage.setPassword(StaticUtils.emailPassword);
            sendMessage.setTo(StaticUtils.emailTo);
            String maxTime = trafficeInfoForHWSerivce.findMaxTime();
            sendMessage.setSubject("拥堵路况扩展服务异常问题");
            sendMessage.setMsg("拥堵路况扩展服务出现异常问题，请重启supermap iserver 扩展服务\r\n " +
                    "服务停止时间："+ maxTime +"  \r\n " +
                    "服务地址10.107.128.7，iserver软件路径：/supermap/soft/extend/supermap-iserver-9.0.1a-linux64");
            try {
                commonMail.sendTextMail(sendMessage);
            } catch (Exception e) {
                logger.info("发送邮件失败！");
                e.printStackTrace();
            }
        }

        logger.info("checkRttServer end ...");

    }

}
