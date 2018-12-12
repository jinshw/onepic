package com.ykkj.weiyi.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.ykkj.weiyi.pojo.RoadZd;
import com.ykkj.weiyi.service.RoadZdService;
import com.ykkj.weiyi.util.JSONFormat;
import com.ykkj.weiyi.util.StrUtil;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//import net.sf.json.util.JSONTokener;

/**
 * 获取实时路况有效信息
 * @throws IOException
 */
@Controller
@RequestMapping({"/rttZd"})
public class RoadZdController {
    @Autowired
    private RoadZdService roadZdService;
    //获取实时路况数据
    @RequestMapping(method = RequestMethod.POST, value = "/getRttZd")
    @ResponseBody
    public Map<String, Object> getRttByAdcodeJson() throws IOException {
        //String areaCode=request.getParameter("adCode");
        Map<String, Object> map = new TreeMap<String, Object>();
        try {

            //if (!StrUtil.isEmpty(typeCode)) {

                List<RoadZd> list = roadZdService.findByTypeCode();
                //RoadZd roadZd = roadZdService.selectByPrimaryKey("2386");
                if(!StrUtil.isEmpty(list) && list.size()>0){
                    map.put("state", "success");
                    map.put("result", list);
                }else{
                    map.put("state", "failure");
                    map.put("result", "无信息");
                }

                //map.put("resultEvent", mapEventResult);

            //} else {
                //map.put("state", "failure");
                //map.put("result", "无信息");
           // }


        } catch (Exception e) {
            map.put("state", "failure");
            map.put("result", "后台捕获异常："+e.getMessage());
            //logger.error("error in wapaction,and e is " + e.getMessage());
        }

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRttZdByJsonp")
    public void getRttByJsonp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "";
        Map<String, Object> map = new TreeMap<String, Object>();
        List<RoadZd> list = null;
//        RoadZd roadZdOne = new RoadZd();
//        RoadZd roadZdTwo= new RoadZd();
//        roadZdOne.setRoadcode("S249");
//        roadZdOne.setId("4796");
//        roadZdOne.setBlockedstart("0");
//        roadZdOne.setBlockedend("26");
//        roadZdOne.setInfoname("G30占道");
//        roadZdOne.setDirection("双向阻断");
//        roadZdOne.setReasoncontent("交通管制");
//        roadZdOne.setStarttime("2017-09-18");
//        roadZdOne.setEndtime("2017-09-18");
//
//        roadZdTwo.setRoadcode("G216");
//        roadZdTwo.setInfoname("G216占道");
//        roadZdTwo.setDirection("双向阻断");
//        roadZdTwo.setReasoncontent("交通管制");
//        roadZdTwo.setStarttime("2017-09-20");
//        roadZdTwo.setEndtime("2017-09-40");
//        list = new ArrayList<>();
//        list.add(roadZdOne);
//        list.add(roadZdTwo);
        try {
            list = roadZdService.findByTypeCode();
            if(!StrUtil.isEmpty(list) && list.size()>0){
                map.put("state", "success");
                map.put("result", list);
            }else{
                map.put("state", "failure");
                map.put("result", "无信息");
            }
        } catch (Exception e) {
            map.put("state", "failure");
            map.put("result", "后台捕获异常："+e.getMessage());
        }

        result = JSONUtil.toJsonStr(list);
        String callback = request.getParameter("callback");
        if(!StringUtils.isBlank(callback)){
            result = callback + "("+result+")";
            response.setContentType("text/javascript");
        }else{
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }


}