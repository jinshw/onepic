package com.ykkj.weiyi.controller;

import cn.hutool.json.JSONUtil;
import com.ykkj.weiyi.common.StaticUtils;
import com.ykkj.weiyi.pojo.Weather;
import com.ykkj.weiyi.service.WeatherService;
import com.ykkj.weiyi.util.HttpUtils;
import com.ykkj.weiyi.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weather")
@ResponseBody
public class WeatherController {
    public static String TOKEN = StaticUtils.WEATHER_TOKEN;
    public static String PASSWORD = StaticUtils.WEATHER_PASSWORD;
    public static String NONCE = StaticUtils.WEATHER_NONCE;

    public static String RADAR_NUMBER = StaticUtils.WEATHER_RADAR_NUMBER;

    public static String RAIN_2H_URL = StaticUtils.WEATHER_RAIN_2H_URL;
    public static String RAIN_2H_SUBURL = StaticUtils.WEATHER_RAIN_2H_SUBURL;

    public static String RADAR_SINGLE_URL = StaticUtils.WEATHER_RADAR_SINGLE_URL;
    public static String RADAR_SINGLE_SUBURL = StaticUtils.WEATHER_RADAR_SINGLE_SUBURL;

    public static String CLDASREAL_URL = StaticUtils.WEATHER_CLDASREAL_URL;
    public static String CLDASREAL_SUBURL = StaticUtils.WEATHER_CLDASREAL_SUBURL;

    public static String EC_FORECAST_URL = StaticUtils.WEATHER_EC_FORECAST_URL;
    public static String EC_FORECAST_SUBURL = StaticUtils.WEATHER_EC_FORECAST_SUBURL;

    @Autowired
    private WeatherService weatherService;

    // public static String TOKEN = "6072fd75f85c5632df9830c956d791b5";
    // public static String PASSWORD = "e346ef0472828e1182dafe8d0835e749";
    // public static String NONCE = "41f46b99497d46d4910baaa0e9b120d2";

    // public static String RADAR_NUMBER = "AZ9080,AZ9081,AZ9903,AZ9990,AZ9991,AZ9993,AZ9996,AZ9997,AZ9998,AZ9999,AZ9083,AZ9082";

    // public static String RAIN_2H_URL = "http://hydrometeo.mojicb.com/v1/radar/rain/full/json";
    // public static String RAIN_2H_SUBURL = "/v1/radar/rain/full/json";

    // public static String RADAR_SINGLE_URL = "https://datas.mojicb.com/tob-data-service/v1/radar/single/sic_img_url";
    // public static String RADAR_SINGLE_SUBURL = "/tob-data-service/v1/radar/single/sic_img_url";

    // public static String CLDASREAL_URL = "http://hydrometeo.mojicb.com/v1/cldas/real/json";
    // public static String CLDASREAL_SUBURL ="/v1/cldas/real/json";

    // public static String EC_FORECAST_URL = "http://hydrometeo.mojicb.com/v1/ec/forecast/json";
    // public static String EC_FORECAST_SUBURL ="/v1/ec/forecast/json";

    @RequestMapping(value = "/getRadarNum", method = RequestMethod.GET)
    @ResponseBody
    public String getRadarNum() {
        String suburl = "/tob-data-service/v1/info/radar-stations";
        String date = System.currentTimeMillis() + "";
        Map<String, String> map = new HashMap();
        map.put("password", PASSWORD);
        map.put("date", date);
        map.put("nonce", NONCE);
        map.put("suburl", suburl);
        String signature = getSignature(map);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-AC-Token", TOKEN);
        headerMap.put("X-Date", date);
        headerMap.put("X-AC-Nonce", NONCE);
        headerMap.put("X-AC-Signature", signature);

        for (String key : headerMap.keySet()) {
            String value = headerMap.get(key);
            System.out.println(key + ":" + value);
        }

        String url = "https://datas.mojicb.com/tob-data-service/v1/info/radar-stations";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("ids", RADAR_NUMBER);

        String datas = HttpUtils.URLGet(url, paramsMap, "utf-8", headerMap);
        // System.out.println(datas);
        return datas;
    }

    @RequestMapping(value = "/getRadarByOne", method = RequestMethod.GET)
    @ResponseBody
    public String getRadarByOne(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(RADAR_NUMBER);
        System.out.println(RADAR_SINGLE_URL);
        System.out.println(RADAR_SINGLE_SUBURL);
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
//        String suburl = "/tob-data-service/v1/radar/single/sic_img_url";
        Map<String, String> map = new HashMap();
        map.put("suburl", RADAR_SINGLE_SUBURL);
        Map<String, String> headerMap = getHeaderMap(map);
        for (String key : headerMap.keySet()) {
            String value = headerMap.get(key);
            System.out.println(key + ":" + value);
        }
//        String url = "https://datas.mojicb.com/tob-data-service/v1/radar/single/sic_img_url";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("ids", RADAR_NUMBER);
        paramsMap.put("dataType", "base");
        paramsMap.put("startTime", startTime);
        paramsMap.put("endTime", endTime);
        System.out.println(paramsMap.toString());
        System.out.println("RADAR_SINGLE_URL===" + RADAR_SINGLE_URL);
        String datas = HttpUtils.URLGet(RADAR_SINGLE_URL, paramsMap, "utf-8", headerMap);
//        System.out.println(datas);
        return datas;
    }


    public String getSignature(Map<String, String> map) {
        String signature = map.get("password") + "\n" + map.get("date") + "\n" + map.get("nonce") + "\n" + map.get("suburl");
        String md5 = MD5Util.getMD5String(signature);
        return md5;
    }

    /**
     * 获取Header公共参数
     *
     * @param map date:
     *            suburl
     * @return
     */
    public Map<String, String> getHeaderMap(Map<String, String> map) {
        String date = System.currentTimeMillis() + "";
        Map<String, String> headerMap = new HashMap<>();
        map.put("password", PASSWORD);
        map.put("date", date);
        map.put("nonce", NONCE);
        map.put("suburl", map.get("suburl"));
        String signature = getSignature(map);
        headerMap.put("X-AC-Token", TOKEN);
        headerMap.put("X-Date", date);
        headerMap.put("X-AC-Nonce", NONCE);
        headerMap.put("X-AC-Signature", signature);
        return headerMap;
    }

    @RequestMapping(value = "/getRadarRain2H", method = RequestMethod.POST)
    @ResponseBody
    public String getRadarRain2H(HttpServletRequest request, HttpServletResponse response) {
        String startLat = request.getParameter("startLat");
        String startLon = request.getParameter("startLon");
        String endLat = request.getParameter("endLat");
        String endLon = request.getParameter("endLon");

//        String suburl = "/v1/radar/rain/full/json";
        Map<String, String> map = new HashMap();
        map.put("suburl", RAIN_2H_SUBURL);
        Map<String, String> headerMap = getHeaderMap(map);

        for (String key : headerMap.keySet()) {
            String value = headerMap.get(key);
            System.out.println(key + ":" + value);
        }

//         = "http://hydrometeo.mojicb.com/v1/radar/rain/full/json";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("startLat", startLat);
        paramsMap.put("startLon", startLon);
        paramsMap.put("endLat", endLat);
        paramsMap.put("endLon", endLon);
        System.out.println(paramsMap.toString());

        String datas = HttpUtils.URLGet(RAIN_2H_URL, paramsMap, "utf-8", headerMap);
//        System.out.println(datas);
        return datas;
    }


    @RequestMapping(value = "/getCldasReal", method = RequestMethod.POST)
    @ResponseBody
    public String getCldasReal(HttpServletRequest request, HttpServletResponse response) {
        String startLat = request.getParameter("startLat");
        String startLon = request.getParameter("startLon");
        String endLat = request.getParameter("endLat");
        String endLon = request.getParameter("endLon");
        String elem = request.getParameter("elem");

        Map<String, String> map = new HashMap();
        map.put("suburl", CLDASREAL_SUBURL);
        Map<String, String> headerMap = getHeaderMap(map);

        for (String key : headerMap.keySet()) {
            String value = headerMap.get(key);
            System.out.println(key + ":" + value);
        }

        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("startLat", startLat);
        paramsMap.put("startLon", startLon);
        paramsMap.put("endLat", endLat);
        paramsMap.put("endLon", endLon);
        paramsMap.put("elem", elem);
        System.out.println(paramsMap.toString());

        String datas = HttpUtils.URLGet(CLDASREAL_URL, paramsMap, "utf-8", headerMap);
//         System.out.println(datas);
        return datas;
    }

    @RequestMapping(value = "/getEcForecast", method = RequestMethod.POST)
    @ResponseBody
    public String getEcForecast(HttpServletRequest request, HttpServletResponse response) {
        String startLat = request.getParameter("startLat");
        String startLon = request.getParameter("startLon");
        String endLat = request.getParameter("endLat");
        String endLon = request.getParameter("endLon");
        String elem = request.getParameter("elem");
        String forecastTime = request.getParameter("forecastTime");

        Map<String, String> map = new HashMap();
        map.put("suburl", EC_FORECAST_SUBURL);
        Map<String, String> headerMap = getHeaderMap(map);

        for (String key : headerMap.keySet()) {
            String value = headerMap.get(key);
            System.out.println(key + ":" + value);
        }

        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("startLat", startLat);
        paramsMap.put("startLon", startLon);
        paramsMap.put("endLat", endLat);
        paramsMap.put("endLon", endLon);
        paramsMap.put("elem", elem);
        paramsMap.put("forecastTime", forecastTime);
        System.out.println(paramsMap.toString());

        String datas = HttpUtils.URLGet(EC_FORECAST_URL, paramsMap, "utf-8", headerMap);
//         System.out.println(datas);
        return datas;
    }

    /**
     * 获取2小时内降水图片
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getRadarRain2HImg", method = RequestMethod.GET)
    @ResponseBody
    public List getRadarRain2HImg(HttpServletRequest request, HttpServletResponse response) {
        Weather weather = new Weather();
        weather.setType(2);
        List list = weatherService.findAllList(weather);
        return list;
    }

    /**
     * 获取实况降水图片
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCldasRealImg", method = RequestMethod.GET)
    @ResponseBody
    public List getCldasRealImg(HttpServletRequest request, HttpServletResponse response) {
        Weather weather = new Weather();
        weather.setType(3);
        List list = weatherService.findAllList(weather);
        return list;
    }

    /**
     * 获取7天内降水图片
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getEcForecastImg", method = RequestMethod.GET)
    @ResponseBody
    public List getEcForecastImg(HttpServletRequest request, HttpServletResponse response) {
        String pointtime = request.getParameter("pointtime");
        if (null == pointtime || pointtime == "") {
            pointtime = "1";
        }
        Weather weather = new Weather();
        weather.setType(4);
        weather.setPointtime(Integer.valueOf(pointtime));
        List list = weatherService.findAllList(weather);
        return list;
    }

    public static void main(String[] args) {
        String token = "6072fd75f85c5632df9830c956d791b5";
        String password = "e346ef0472828e1182dafe8d0835e749";
        String nonce = "41f46b99497d46d4910baaa0e9b120d2";
        String rain_2h_url = "http://hydrometeo.mojicb.com/v1/radar/rain/full/json";
        String rain_2h_suburl = "/v1/radar/rain/full/json";
        String date = "1571033733479";
        //    String date = System.currentTimeMillis() + "";

        WeatherController weatherController = new WeatherController();

        Map<String, String> map = new HashMap<String, String>();
        map.put("password", PASSWORD);
        map.put("date", date);
        map.put("nonce", NONCE);
        map.put("suburl", rain_2h_suburl);
        String signature = weatherController.getSignature(map);
        System.out.println(signature);

    }

}
