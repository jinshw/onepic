package com.ykkj.weiyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("testserver")
public class HttpTestController {

    @RequestMapping("getjson")
    public void getJson(HttpServletRequest request, HttpServletResponse response){
        String jsonstr =  request.getParameter("json");
        System.out.println(jsonstr);
    }
}
