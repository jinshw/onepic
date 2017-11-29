package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.Iterator;

public class Num {
    public static void main(String[] args){
        BigDecimal n = new BigDecimal("3.00168040312345E9");
        float f =  Float.valueOf("3.001680403E9");
        String datas = "{ \"status\": \"0\",\"returnData\":[{appf:3.001680403E9,apps:\"3.001680403E9\"},{appf:3.00168040388E9,apps:\"3.00168040388E9\"}]}";
        JSONObject res = JSONObject.fromObject(datas);
        JSONObject jsonObject;
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        BigDecimal bigDecimal;
        while (iterator.hasNext()) {
            jsonObject = iterator.next();
            System.out.println(jsonObject.getString("appf"));
            System.out.println(jsonObject.getString("apps"));
            bigDecimal = new BigDecimal(jsonObject.getString("apps"));
            System.out.println(bigDecimal);
        }

        System.out.println(3.001680403E9);
        System.out.println(3.001680403E9+"");
//        System.out.println(n.floatValue());
//        System.out.println(n.doubleValue());
//        System.out.println(f);
    }
}
