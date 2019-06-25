package com.ykkj.weiyi.pojo;

import com.ykkj.weiyi.common.StaticUtils;

public class SendMessage {
    public String host = "smtp.163.com";
    public int port = 25;
    public String userName = "jinshengwang2007@163.com";
    public String password = "jin6150090";
    public String to = "jinshengwang2007@163.com";
    public String subject = "test";
    public String msg = "test";


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
