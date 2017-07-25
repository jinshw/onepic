package com.ykkj.weiyi.util;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class APIHttpClient {

    // 接口地址
    private static String apiURL = "http://localhost:8090/iserver/services/data-zhzdcs/rest/data/featureResults.rjson?returnContent=true";
    private Log logger = LogFactory.getLog(this.getClass());
    private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
    private HttpClient httpClient = null;
    private HttpPost method = null;
    private long startTime = 0L;
    private long endTime = 0L;
    private int status = 0;

    /**
     * 接口地址
     *
     * @param url
     */
    public APIHttpClient(String url) {

        if (url != null) {
            this.apiURL = url;
        }
        if (apiURL != null) {
            httpClient = new DefaultHttpClient();
            method = new HttpPost(apiURL);

        }
    }

    /**
     * 调用 API
     *
     * @param parameters
     * @return
     */
    public String post(String parameters) {
        String body = null;
        logger.info("parameters:" + parameters);

        if (method != null & parameters != null
                && !"".equals(parameters.trim())) {
            try {

                // 建立一个NameValuePair数组，用于存储欲传送的参数
                method.addHeader("Content-type", "application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
                startTime = System.currentTimeMillis();

                HttpResponse response = httpClient.execute(method);

                endTime = System.currentTimeMillis();
                int statusCode = response.getStatusLine().getStatusCode();

                logger.info("statusCode:" + statusCode);
                logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                if (statusCode != HttpStatus.SC_OK) {
                    logger.error("Method failed:" + response.getStatusLine());
                    status = 1;
                }

                // Read the response body
                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {
                // 网络错误
                status = 3;
            } finally {
                logger.info("调用接口状态：" + status);
            }

        }
        return body;
    }

    public static void main(String[] args) {
        APIHttpClient ac = new APIHttpClient(apiURL);
        String _p = "{\"getFeatureMode\":\"SQL\",\"targetEpsgCode\":4326,\"datasetNames\":[\"GLLX:GLLX\"],\"maxFeatures\":10,\"queryParameter\":{\"sortClause\":null,\"ids\":null,\"name\":\"Capital\",\"attributeFilter\":\"SMID%26lt;5\",\"groupClause\":null, \"linkItems\":null, \"joinItems\":null,\"fields\":null}}";
        String _rlt = ac.post(_p);
//        System.out.println(_rlt);
        JSONArray _arr = JsonPath.read(_rlt, "$.features[0].geometry.points");
        JSONArray fieldNames = JsonPath.read(_rlt,"$.features[0].fieldNames");
        Object[] _filedsNames =  fieldNames.toArray();
        JSONArray points = JsonPath.read(_rlt,"$.features[0].geometry.points");
        Object[] _points = points.toArray();
        Map _point = (Map) _points[1];
        Double d = (Double) _point.get("x");
        System.out.println(_points);
        DecimalFormat df = new DecimalFormat("######0.00");
        double dd = 4.2132130;

//        JSONObject json = JSONObject.fromObject(_rlt);
        System.out.println("-----------=====end======------------");
    }

    /**
     * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @return the endTime
     */
    public long getEndTime() {
        return endTime;
    }
}
