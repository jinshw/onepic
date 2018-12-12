package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.MqiVal;
import com.ykkj.weiyi.service.MQIService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/mqi")
public class MQIController {
    @Autowired
    private MQIService mqiService;

    @RequestMapping("/gs")
    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        mqiService.getGSMQI();
        /*JSONArray jsonArray = JSONFormat.formatDate(list,
                "yyyy-MM-dd HH:mm:ss", Date.class, null);
        jsonObject.put("marklist", jsonArray.toString());*/
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping("/gd")
    public void getGD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        mqiService.getGDMQI();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping("/sd")
    public void getSD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        mqiService.getSDMQI();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping("/all")
    public void getALL(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        mqiService.getGSMQI();
        mqiService.getGDMQI();
        mqiService.getSDMQI();
        System.out.println("MQI更新完成");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping("/gsmqi")
    public void getGSMQI(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        List<MqiVal> gslist = mqiService.findMqiGS();
        System.out.println("获取GSMQI更新完成");
        jsonObject.put("gslist", gslist.toString());

        JSONArray jsonArr = JSONArray.fromObject(gslist);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonArr.toString());
    }

    @RequestMapping("/gdmqi")
    public void getGDMQI(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        List<MqiVal> gdlist = mqiService.findMqiGD();
        System.out.println("获取GSMQI更新完成");
        jsonObject.put("gslist", gdlist.toString());

        JSONArray jsonArr = JSONArray.fromObject(gdlist);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonArr.toString());
    }

    @RequestMapping("/sdmqi")
    public void getSDMQI(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        List<MqiVal> sdlist = mqiService.findMqiSD();
        System.out.println("获取GSMQI更新完成");
        jsonObject.put("gslist", sdlist.toString());

        JSONArray jsonArr = JSONArray.fromObject(sdlist);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonArr.toString());
    }
    @RequestMapping("/getmqi")
    public void getMQI(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        List<MqiVal> list = mqiService.find();
        System.out.println("获取ALLMQI更新完成");
        jsonObject.put("list", list.toString());
        JSONArray jsonArr = JSONArray.fromObject(list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonArr.toString());
    }




}
