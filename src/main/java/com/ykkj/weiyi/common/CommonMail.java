package com.ykkj.weiyi.common;

import com.ykkj.weiyi.pojo.SendMessage;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.Date;
import java.util.logging.Logger;

public class CommonMail {
    Logger logger = Logger.getLogger("CommonMail");
    private String host = "smtp.qq.com";
    private int port = 25;
    private String userName = "758896033@qq.com";
    private String password = "zcpnqbjujfnobeji";
    private String to = "758896033@qq.com";
//    private String userName = "jinshengwang2007@163.com";
//    private String password = "jin6150090";
//    private String to = "jinshengwang2007@163.com";

    private final static CommonMail COMMON_MAIL = new CommonMail();
    public SimpleEmail mail = new SimpleEmail();

    public static CommonMail getCommonMail() {
        return COMMON_MAIL;
    }

  /*
  public CommonMail() {
        this.host = StaticUtils.emailHost;
        this.port = StaticUtils.emailPort;
        this.userName = StaticUtils.emailUsername;
        this.password = StaticUtils.emailPassword;
        this.to = StaticUtils.emailTo;
        try {
            // 设置邮箱服务器信息
            mail.setSmtpPort(this.port);
            mail.setHostName(this.host);
            // 设置密码验证器
            mail.setAuthentication(this.userName, this.password);
            // 设置邮件发送者
            mail.setFrom(this.userName);
            // 设置邮件编码
            mail.setCharset("UTF-8");
            // 设置邮件接收者
            String[] tos = this.to.split(",");
            for (int i = 0; i < tos.length; i++) {
                mail.addTo(tos[i]);
            }

        } catch (EmailException e) {
            logger.info("CommonMail exception:"+e.getMessage());
            e.printStackTrace();
        }
    }

*/
    /**
     * 发送文本邮件
     *
     * @throws Exception
     */
    public void sendTextMail() throws Exception {
        SimpleEmail mail = new SimpleEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(port);
        mail.setHostName(host);
        // 设置密码验证器
        mail.setAuthentication(userName, password);
        // 设置邮件发送者
        mail.setFrom(userName);
        // 设置邮件接收者
//        mail.addTo(to);
        mail.addTo("jinshengwang2007@163.com");
        mail.addTo("758896033@qq.com");
        // 设置邮件编码
        mail.setCharset("UTF-8");
        // 设置邮件主题
        mail.setSubject("supermap iserver extends 扩展服务问题2222");
        // 设置邮件内容
        mail.setMsg("supermap iserver extends 扩展服务有问题，请重启3333");
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }

    public void sendTextMail(SendMessage sendMessage) throws Exception {
        SimpleEmail mail = new SimpleEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(sendMessage.getPort());
        mail.setHostName(sendMessage.getHost());
        // 设置密码验证器
        mail.setAuthentication(sendMessage.getUserName(), sendMessage.getPassword());
        // 设置邮件发送者
        mail.setFrom(sendMessage.getUserName());
        // 设置邮件接收者
        String[] tos = sendMessage.to.split(",");
        for (int i = 0; i < tos.length; i++) {
            mail.addTo(tos[i]);
        }

        // 设置邮件编码
        mail.setCharset("UTF-8");
        // 设置邮件主题
        mail.setSubject(sendMessage.getSubject());
        // 设置邮件内容
        mail.setMsg(sendMessage.getMsg());
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }


    public static void main(String[] args) throws Exception {
        CommonMail testMail = new CommonMail();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setTo("jinshengwang2007@163.com,758896033@qq.com");
        sendMessage.setSubject("服务错误通知");
        sendMessage.setMsg("服务错误通知，需要重启");
        testMail.sendTextMail();
    }

}
