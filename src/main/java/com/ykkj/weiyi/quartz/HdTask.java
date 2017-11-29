package com.ykkj.weiyi.quartz;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ykkj.weiyi.common.StaticUtils;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SupervisionInfoWithBLOBs;
import com.ykkj.weiyi.service.HdService;
import com.ykkj.weiyi.util.HttpUtils;

@Component
// @Lazy(false)
public class HdTask
{
    Logger logger = Logger.getLogger("hdTask");

    @Autowired
    private HdService hdService;

    // @Scheduled(cron = "0/5 * *  * * ? ")
    public void getDatas()
    {
        getProjectInfo();
//        getDirectInfo();
//        getSupervisionInfo();
//        getSectInfo();
    }

    /**
     * 获取项目信息
     */
    public void getProjectInfo()
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getProjectInfo 开始时间:" + sf.format(new Date()));
        String st = "";
        st = hdService.findProjectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETPROJECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        ProjectInfoWithBLOBs pwb;
        while (iterator.hasNext())
        {
            jsonObject = iterator.next();
            pwb = new ProjectInfoWithBLOBs();
            jsonToObj(pwb, jsonObject);
            int id = Integer.valueOf(pwb.getId());
            id++;
            pwb.setId(String.valueOf(id));
            if (hdService.findProjectInfoWithBLOBsByID(pwb.getId()) != null)
            {
                // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                hdService.deleteProjectInfoByID(pwb.getId());
                // System.out.println("修改成功");
            }
            pwb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insert(pwb);
        }

        logger.info("getProjectInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取指挥部信息
     */
    public void getDirectInfo()
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getDirectInfo 开始时间:" + sf.format(new Date()));
        String st = "";
        st = hdService.findDirectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETDIRECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        DirectInfoWithBLOBs dwb;
        while (iterator.hasNext())
        {
            jsonObject = iterator.next();
            dwb = new DirectInfoWithBLOBs();
            jsonToObj(dwb, jsonObject);
            int id = Integer.valueOf(dwb.getId());
            id++;
            dwb.setId(String.valueOf(id));
            if (hdService.findDirectInfoByID(dwb.getId()) != null)
            {
                /*
                 * System.out.println("DirectInfo id:" + dwb.getId() +
                 * "重复，修改中....");
                 */
                hdService.deleteDirectInfoByID(dwb.getId());
                /* System.out.println("修改成功"); */
            }
            dwb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertDirectInfo(dwb);
        }
        logger.info("getDirectInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取监理信息
     */
    public void getSupervisionInfo()
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getSupervisionInfo 开始时间:" + sf.format(new Date()));
        String st = "";
        st = hdService.findSupervisionInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSUPERVISIONINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        SupervisionInfoWithBLOBs swb;
        while (iterator.hasNext())
        {
            jsonObject = iterator.next();
            swb = new SupervisionInfoWithBLOBs();
            jsonToObj(swb, jsonObject);
            int id = Integer.valueOf(swb.getId());
            id++;
            swb.setId(String.valueOf(id));
            if (hdService.findSupervisionInfoByID(swb.getId()) != null)
            {
                /*
                 * System.out.println("getSupervisionInfo id:" + swb.getId() +
                 * "重复，修改中....");
                 */
                hdService.deleteSupervisionInfoByID(swb.getId());
                /* System.out.println("修改成功"); */
            }
            swb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertSupervisionInfo(swb);
        }
        logger.info("getSupervisionInfo 结束时间:" + sf.format(new Date()));
    }

    /**
     * 获取标段信息
     */
    public void getSectInfo()
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("getSectInfo 开始时间:" + sf.format(new Date()));
        String st = "";
        st = hdService.findSectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        JSONArray jsonArray = res.getJSONArray("returnData");
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject jsonObject;
        SectInfoWithBLOBs swb;
        while (iterator.hasNext())
        {
            jsonObject = iterator.next();
            swb = new SectInfoWithBLOBs();
            jsonToObj(swb, jsonObject);
            int id = Integer.valueOf(swb.getId());
            id++;
            swb.setId(String.valueOf(id));
            if (hdService.findSectInfoByID(swb.getId()) != null)
            {
                /*
                 * System.out.println("DirectInfo id:" + swb.getId() +
                 * "重复，修改中....");
                 */
                hdService.deleteSectInfoByID(swb.getId());
                /* System.out.println("修改成功"); */
            }
            swb.setCreatetime(new Timestamp(new Date().getTime()));
            hdService.insertSectInfo(swb);
        }
        logger.info("getSectInfo 结束时间:" + sf.format(new Date()));
    }

    public static <T> void jsonToObj(T obj, JSONObject jsonObject)
    {
        try
        {
            Class<?> clazz = obj.getClass();
            Field[] fsChild = clazz.getDeclaredFields();// 本类属性
            Field[] fsSuper = clazz.getSuperclass().getDeclaredFields();// 父类属性
            Field[] fs = (Field[]) ArrayUtils.addAll(fsChild, fsSuper);
            Double dtemp = null;
            for (Field field : fs)
            {
                String name = field.getName();
                Class<?> fieldType = field.getType();
                // String reqVal = (String) jsonObject.get(name);

                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd hh:mm:ss");
                // 过滤被final、static修饰的成员变量
                if ((field.getModifiers() & Modifier.FINAL) > 0
                        || (field.getModifiers() & Modifier.STATIC) > 0)
                {
                    continue;
                }
                // 取消所有私有变量的限制
                field.setAccessible(true);// 取消Field的访问检查
                /*
                 * if (name.equals("patroltime") && (reqVal != null &&
                 * !reqVal.equals(""))) {// 时间 field.set(obj,
                 * sdf.parse(reqVal)); } else
                 */
                if (fieldType == String.class && jsonObject.has(name))
                {
                    field.set(obj, jsonObject.getString(name));
                    // field.set(obj, reqVal);
                }
                else if (fieldType == Integer.class && jsonObject.has(name))
                {
                    field.set(obj, jsonObject.getInt(name));
                    // field.set(obj, NumberUtils.toInt(reqVal));
                }
                else if (fieldType == Double.class && jsonObject.has(name))
                {
                    field.set(obj, jsonObject.getDouble(name));
                    // field.set(obj, NumberUtils.toDouble(reqVal));
                }
                else if (fieldType == Float.class && jsonObject.has(name))
                {
                    dtemp = jsonObject.getDouble(name);
                    field.set(obj, Float.valueOf(jsonObject.getString(name)));
                }
                else if (fieldType == BigDecimal.class && jsonObject.has(name))
                {
                    field.set(obj, new BigDecimal(jsonObject.getString(name)));
                }
                else if (fieldType == Boolean.class && jsonObject.has(name))
                {
                    field.set(obj, jsonObject.getBoolean(name));
                    // field.set(obj, Boolean.valueOf(reqVal));
                }
                else if (fieldType == Date.class && jsonObject.has(name))
                {// 时间
                    field.set(obj, sdf.parse(jsonObject.getString(name)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
