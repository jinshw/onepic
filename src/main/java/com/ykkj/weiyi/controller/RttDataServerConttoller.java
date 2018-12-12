package com.ykkj.weiyi.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ykkj.weiyi.common.CommUtil;
import com.ykkj.weiyi.common.RticPropertiesUtils;
import com.ykkj.weiyi.common.XmlToJson;
import com.ykkj.weiyi.pojo.NBaoAttr;
import com.ykkj.weiyi.pojo.TrafficInfo;
import com.ykkj.weiyi.service.TrafficInfoService;
import com.ykkj.weiyi.util.FileUtils;
import com.ykkj.weiyi.util.StrUtil;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("rttServer")
public class RttDataServerConttoller {
    @Autowired
    private TrafficInfoService trafficInfoService;

    @RequestMapping("/find")
    public void queryLength(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TrafficInfo> list = new ArrayList<>();
        String orderBy = request.getParameter("orderBy");
        if(StringUtils.isEmpty(orderBy)){
            orderBy = "desc";
        }
        TrafficInfo trafficInfo = new TrafficInfo();
        trafficInfo.setOrderBy(orderBy);
        System.out.println("orderBy=="+orderBy);
        list = trafficInfoService.findList(trafficInfo);
        System.out.println("list=="+list);
        String result = JSONUtil.toJsonStr(list);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }


}
