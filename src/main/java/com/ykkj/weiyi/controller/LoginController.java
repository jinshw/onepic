package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jinshw on 2016/7/22.
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setID("11796661b3054dd6aa974c68f98728c3");
        user.setName("金生旺");
        user.setMobile("15901335890");
        user.setPassword("96e79218965eb72c92a549dd5a330112");
        user.setOpenId("oz34ywpuL_jcMsKym9PPqrdgbj_M");
        request.getSession().setAttribute("CUR_USER", user);
        request.getSession().setAttribute("openId", user.getOpenId());

        return "bill/test";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "main/index";
    }


}
