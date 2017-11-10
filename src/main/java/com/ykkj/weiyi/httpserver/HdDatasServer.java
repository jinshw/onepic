package com.ykkj.weiyi.httpserver;

import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.service.impl.HdServiceImpl;
import com.ykkj.weiyi.util.HttpUtils;
import com.ykkj.weiyi.util.SpringContextUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.List;

public class HdDatasServer {

    public static void main(String[] args) {
        String datas = HttpUtils.URLGet("http://localhost:8081/onepic/hd/getProjectInfo", null, "UTF-8");
        System.out.println(datas);
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        System.out.println(jsonObject.getDouble("projectTotalinversted"));

        ProjectInfoWithBLOBs pwb = new ProjectInfoWithBLOBs();

        jsonToObj(pwb, jsonObject);
        System.out.println(pwb);



        // 手动加载spring
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-core.xml"});
        BeanFactory factory = (BeanFactory) context;
        HdServiceImpl hdServiceImpl = (HdServiceImpl ) factory.getBean("hdServiceImpl");

        List list = hdServiceImpl.find("0");
        ProjectInfoWithBLOBs projectInfoWithBLOBs = (ProjectInfoWithBLOBs) list.get(0);
        System.out.println(projectInfoWithBLOBs);

        hdServiceImpl.insert(pwb);
    }

    public static <T> void jsonToObj(T obj, JSONObject jsonObject) {
        try {
            Class<?> clazz = obj.getClass();
            Field[] fs = clazz.getDeclaredFields();
            Double dtemp = null;
            for (Field field : fs) {
                String name = field.getName();
                Class<?> fieldType = field.getType();
//                String reqVal = (String) jsonObject.get(name);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                // 过滤被final、static修饰的成员变量
                if ((field.getModifiers() & Modifier.FINAL) > 0
                        || (field.getModifiers() & Modifier.STATIC) > 0) {
                    continue;
                }
                // 取消所有私有变量的限制
                field.setAccessible(true);// 取消Field的访问检查
                /*if (name.equals("patroltime")
                        && (reqVal != null && !reqVal.equals(""))) {// 时间
                    field.set(obj, sdf.parse(reqVal));
                } else */
                if (fieldType == String.class
                        && jsonObject.has(name)) {
                    field.set(obj, jsonObject.getString(name));
//                    field.set(obj, reqVal);
                } else if (fieldType == Integer.class
                        && jsonObject.has(name)) {
                    field.set(obj, jsonObject.getInt(name));
//                    field.set(obj, NumberUtils.toInt(reqVal));
                } else if (fieldType == Double.class
                        && jsonObject.has(name)) {
                    field.set(obj, jsonObject.getDouble(name));
//                    field.set(obj, NumberUtils.toDouble(reqVal));
                } else if (fieldType == Float.class
                        && jsonObject.has(name)) {
                    dtemp = jsonObject.getDouble(name);
                    field.set(obj, dtemp.floatValue());
                } else if (fieldType == Boolean.class
                        && jsonObject.has(name)) {
                    field.set(obj, jsonObject.getBoolean(name));
//                    field.set(obj, Boolean.valueOf(reqVal));
                }else if (fieldType == Date.class
                        && jsonObject.has(name)){// 时间
                    field.set(obj, sdf.parse(jsonObject.getString(name)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
