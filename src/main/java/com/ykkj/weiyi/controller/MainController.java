package com.ykkj.weiyi.controller;

import com.jayway.jsonpath.JsonPath;
import com.ykkj.weiyi.pojo.Roud;
import com.ykkj.weiyi.pojo.Stake;
import com.ykkj.weiyi.service.impl.RoudService;
import com.ykkj.weiyi.service.impl.StakeService;
import com.ykkj.weiyi.util.*;
import net.minidev.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private StakeService stakeService;
    @Autowired
    private RoudService roudService;

    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "main/index";
    }

    @RequestMapping("initStake")
    public String initStake(HttpServletRequest request, HttpServletResponse response) {
        return "main/initstake";
    }

    @RequestMapping("initRoadDict")
    public void initRoadDict(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = 0L, endTime = 0L;
        startTime = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("message", "success");
        String type = (String) request.getParameter("type");
        String url = "http://localhost:8090/iserver/services/data-zaijiandaolu4/rest/data/featureResults.rjson?returnContent=true";
        String param = "{\"getFeatureMode\":\"SQL\",\"targetEpsgCode\":4326,\"datasetNames\":[\"" +
                type +
                "\"],\"queryParameter\":{}}";
        APIHttpClient apiHttpClient = new APIHttpClient(url);

        String responseStr = apiHttpClient.post(param);
        JSONArray ja = JsonPath.read(responseStr, "$.features");
        Object[] objects = ja.toArray();
        JSONArray fieldNames, fieldValues;
        Roud roud = null;
        List<Roud> list = new ArrayList<Roud>();
        for (int i = 0; i < objects.length; i++) {
            fieldNames = JsonPath.read(responseStr, "$.features[" + i + "].fieldNames");
            fieldValues = JsonPath.read(responseStr, "$.features[" + i + "].fieldValues");
            Object[] _filedsNames = fieldNames.toArray();
            Object[] _fieldValues = fieldValues.toArray();
            int _index = _filedsNames.length;
            roud = new Roud();
            for (int j = (_index - 1); j >= 0; j--) {
                if (_filedsNames[j].equals("XMMC")) {// 线路名称
                    roud.setRoudname((String) _fieldValues[j]);
                }
                if (_filedsNames[j].equals("GLJB")) {//类型
                    roud.setRoudtype((String) _fieldValues[j]);
                }
                if (_filedsNames[j].equals("SMLENGTH")) {//类型
                    roud.setRoudlength(Double.valueOf((String) _fieldValues[j]));
                }
                if (_filedsNames[j].equals("SMID")) {//类型
                    roud.setSmid((String) _fieldValues[j]);
                }
            }
            roud.setRoudid(UUIDUtil.create32UpperUUID());
            list.add(roud);
        }
        roudService.insertList(list);
        endTime = System.currentTimeMillis();
        System.out.println("==执行耗费时间====" + (endTime - startTime));
        System.out.println("-------end-----");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());

    }

    /**
     * 查询道路信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("getRoud")
    public void getRoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("message", "success");

        String roudid = request.getParameter("roudid");
        String roudname = request.getParameter("roudname");
        String roudtype = request.getParameter("roudtype");
        String roudstatus = request.getParameter("roudstatus");
        String smid = request.getParameter("smid");


        Roud roud = new Roud();
        roud.setRoudid(roudid);
        roud.setRoudname(roudname);
        roud.setRoudtype(roudtype);
        roud.setRoudstatus(roudstatus == null ? 0 : Integer.valueOf(roudstatus));
        roud.setSmid(smid);

        List<Roud> list = roudService.find(roud);
        jsonObject.put("list", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping("getStake")
    public void getStake(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = 0L, endTime = 0L;
        startTime = System.currentTimeMillis();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("message", "success");
        String type = (String) request.getParameter("type");

        String url = "http://localhost:8090/iserver/services/data-zaijiandaolu4/rest/data/featureResults.rjson?returnContent=true";
//        String url = "http://localhost:8090/iserver/services/data-zhcs/rest/data/featureResults.rjson?returnContent=true";
        String param = "{\"getFeatureMode\":\"SQL\",\"targetEpsgCode\":4326,\"datasetNames\":[\"" +
                type +
                "\"],\"queryParameter\":{}}";
//        String param = "{\"getFeatureMode\":\"SQL\",\"targetEpsgCode\":4326,\"datasetNames\":[\"" +
//                "G7:G7" +
//                "\"],\"queryParameter\":{}}";
        APIHttpClient apiHttpClient = new APIHttpClient(url);

        String responseStr = apiHttpClient.post(param);
        FileUtils.writePageToFile(responseStr, "h:/json.json", "UTF-8");
        saveStake(responseStr);
        endTime = System.currentTimeMillis();

        System.out.println("==执行耗费时间====" + (endTime - startTime));
        System.out.println("-------end-----");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }

    /**
     * 保存桩号
     *
     * @param json
     */
    public void saveStake(String json) {
        DecimalFormat df = new DecimalFormat("######0.00");
        String stakeName = "", stakeType = "";
        int count = 0, _count = 1, result = 0;
        JSONArray ja = JsonPath.read(json, "$.features");
        Iterator<Object> it = ja.iterator();
        JSONArray fieldNames, fieldValues, points;
        Object[] _points;
        Stake stake = null;
        Map _point = null, _pointNext = null;
        List<Stake> list = null;
        double stakeLength = 0, totalLength = 0;
        while (it.hasNext()) {
            fieldNames = JsonPath.read(json, "$.features[" + count + "].fieldNames");
            fieldValues = JsonPath.read(json, "$.features[" + count + "].fieldValues");
            Object[] _filedsNames = fieldNames.toArray();
            Object[] _fieldValues = fieldValues.toArray();
            int _index = _filedsNames.length;
            for (int i = (_index - 1); i >= 0; i--) {
                if (_filedsNames[i].equals("XMMC")) {// 线路名称
                    stakeName = (String) _fieldValues[i];
                }
                if (_filedsNames[i].equals("GLJB")) {//类型
                    stakeType = (String) _fieldValues[i];
                }
            }

            points = JsonPath.read(json, "$.features[" + count + "].geometry.points");
            _points = points.toArray();
            _count = 1;
            totalLength = 0;
            list = new ArrayList<Stake>();
            for (int j = 0; j < _points.length; j++) {
                if (j == 0) {
                    _point = (Map) _points[0];
                    stake = new Stake();
                    stake.setStakeId(UUIDUtil.create32UpperUUID());
                    stake.setStakeName(stakeName);
                    stake.setStakeType(stakeType);
                    stake.setLon((Double) _point.get("x"));
                    stake.setLat((Double) _point.get("y"));
                    stake.setStakeLength((double) 0);
                    stake.setStakeNum(_count);
                    list.add(stake);
                } else {
                    _point = (Map) _points[j - 1];
                    _pointNext = (Map) _points[j];
                    stakeLength = LocationUtils.getDistanceVincenty(
                            Double.valueOf((Double) _point.get("x")),
                            Double.valueOf((Double) _point.get("y")),
                            Double.valueOf((Double) _pointNext.get("x")),
                            Double.valueOf((Double) _pointNext.get("y"))
                    );
                    totalLength = totalLength + stakeLength;
                    if (stakeLength > 90) { //计算两个坐标点距离，小于90米舍弃
                        _count = _count + 1;
                        stake = new Stake();
                        stake.setStakeId(UUIDUtil.create32UpperUUID());
                        stake.setStakeName(stakeName);
                        stake.setStakeType(stakeType);
                        stake.setLon((Double) _pointNext.get("x"));
                        stake.setLat((Double) _pointNext.get("y"));
                        stake.setStakeLength(Double.valueOf(df.format(totalLength)));
                        stake.setStakeNum(_count);
                        list.add(stake);
                    }
                }
            }
            count = count + 1;
            it.next();
            // 把桩号信息插入数据库
            result = stakeService.insertList(list);
        }
    }


    /**
     * 根据位置获取附近的两个点桩号
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("getPointsByLocation")
    public void getPointsByLocation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("message", "success");
        String location = request.getParameter("location");
        String stakeName = request.getParameter("stakeName");
        Map map = new HashMap();
        map.put("stakeName", stakeName);
        map.put("location", Integer.valueOf(location));
        List<Stake> list = stakeService.queryStakeByLocation(map);
        json.put("list", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json.toString());
    }


    @RequestMapping("uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "fileuploader/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
