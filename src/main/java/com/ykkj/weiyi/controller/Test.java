package com.ykkj.weiyi.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("name","zhagnsan");
        map.put("age","18");
        map.put("sex","2");
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key+":"+value);
        }












        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");

        List<String > rlist = new ArrayList<>();
        System.out.println(list.toString());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String id = iterator.next();
            if(!rlist.contains(id)){
                rlist.add(id);
            }
        }
        System.out.println(rlist.toString());
    }
}
