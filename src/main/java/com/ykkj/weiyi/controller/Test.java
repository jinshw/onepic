package com.ykkj.weiyi.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;

        br = new BufferedReader(new FileReader(
                "src/json/mark_list.txt"
                ));// 读取原始json文件

        String s = null;
        StringBuffer sbf = new StringBuffer();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            sbf.append(s.trim());
//            JSONObject jsonObject = JSONObject.fromObject(s);

        }
        System.out.println("KKKKKKKKKKKKKKKKKKK");
        System.out.println(sbf.toString());
        JSONArray jsonArray = JSONArray.fromObject(sbf.toString());
        System.out.println(jsonArray.toString());
    }
}
