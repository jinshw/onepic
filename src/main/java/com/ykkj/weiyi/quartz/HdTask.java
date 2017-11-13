package com.ykkj.weiyi.quartz;

import com.ykkj.weiyi.pojo.*;
import com.ykkj.weiyi.service.HdService;
import com.ykkj.weiyi.util.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Component
//@Lazy(false)
public class HdTask {
    Logger logger = Logger.getLogger("hdTask");

    @Autowired
    private HdService hdService;

    //    @Scheduled(cron = "0/5 * *  * * ? ")
    public void getDatas() {
        getProjectInfo();
        getDirectInfo();
        getSupervisionInfo();
        getSectInfo();
    }

    /**
     * 获取项目信息
     */
    public void getProjectInfo() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getProjectInfo 开始时间:" + sf.format(new Date()));
        String datas = HttpUtils.URLGet("http://localhost:8081/onepic/hd/getProjectInfo", null, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        ProjectInfoWithBLOBs pwb;
        while (iterator.hasNext()) {
            jsonObject = iterator.next();
            pwb = new ProjectInfoWithBLOBs();
            jsonToObj(pwb, jsonObject);
            pwb.setId(Math.random() * 10 + "");
            pwb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insert(pwb);
        }

        logger.info("getProjectInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取指挥部信息
     */
    public void getDirectInfo() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getDirectInfo 开始时间:" + sf.format(new Date()));
        String datas = HttpUtils.URLGet("http://localhost:8081/onepic/hd/getDirectInfo", null, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        DirectInfoWithBLOBs dwb;
        while (iterator.hasNext()) {
            jsonObject = iterator.next();
            dwb = new DirectInfoWithBLOBs();
            jsonToObj(dwb, jsonObject);
            dwb.setId(Math.random() * 10 + "");
            dwb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertDirectInfo(dwb);
        }
        logger.info("getDirectInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取监理信息
     */
    public void getSupervisionInfo() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getSupervisionInfo 开始时间:" + sf.format(new Date()));
        String datas = HttpUtils.URLGet("http://localhost:8081/onepic/hd/getSupervisionInfo", null, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        SupervisionInfoWithBLOBs swb;
        while (iterator.hasNext()) {
            jsonObject = iterator.next();
            swb = new SupervisionInfoWithBLOBs();
            jsonToObj(swb, jsonObject);
            swb.setId(Math.random() * 10 + "");
            swb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertSupervisionInfo(swb);
        }
        logger.info("getSupervisionInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取标段信息
     */
    public void getSectInfo() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getSectInfo 开始时间:" + sf.format(new Date()));
        String datas = HttpUtils.URLGet("http://localhost:8081/onepic/hd/getSectInfo", null, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        SectInfoWithBLOBs swb;
        while (iterator.hasNext()) {
            jsonObject = iterator.next();
            swb = new SectInfoWithBLOBs();
            jsonToObj(swb, jsonObject);
            swb.setId(Math.random() * 10 + "");
            swb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertSectInfo(swb);
        }
        logger.info("getSectInfo 结束时间:" + sf.format(new Date()));
    }

    public static <T> void jsonToObj(T obj, JSONObject jsonObject) {
        try {
            Class<?> clazz = obj.getClass();
            Field[] fsChild = clazz.getDeclaredFields();// 本类属性
            Field[] fsSuper = clazz.getSuperclass().getDeclaredFields();// 父类属性
            Field[] fs = (Field[]) ArrayUtils.addAll(fsChild, fsSuper);
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
                } else if (fieldType == Date.class
                        && jsonObject.has(name)) {// 时间
                    field.set(obj, sdf.parse(jsonObject.getString(name)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
