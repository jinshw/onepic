package com.ykkj.weiyi.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ykkj.weiyi.common.StaticUtils;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SupervisionInfoWithBLOBs;
import com.ykkj.weiyi.quartz.HdTask;
import com.ykkj.weiyi.service.HdService;
import com.ykkj.weiyi.util.HttpUtils;
import com.ykkj.weiyi.util.JSONFormat;

@Controller
@RequestMapping("hd")
public class HdDataController
{

    @Autowired
    private HdService hdService;

    @RequestMapping("getProjectInfo")
    public void getProjectInfo(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        System.out.println(request.getParameter("type") + "getProjectInfo");
        try
        {
            List<ProjectInfoWithBLOBs> list = hdService.find("0");
            JSONArray jsonArray = JSONFormat.formatDate(list,
                    "yyyy-MM-dd HH:mm:ss", Date.class, null);
            result.put("returnData", jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @RequestMapping("getDirectInfo")
    public void getDirectInfo(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        try
        {
            List<DirectInfoWithBLOBs> list = hdService.findDirectInfo("0");
            JSONArray jsonArray = JSONFormat.formatDate(list,
                    "yyyy-MM-dd HH:mm:ss", Date.class, null);
            result.put("returnData", jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @RequestMapping("getSupervisionInfo")
    public void getSupervisionInfo(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        try
        {
            List<SupervisionInfoWithBLOBs> list = hdService
                    .findSupervisionInfo("0");
            JSONArray jsonArray = JSONFormat.formatDate(list,
                    "yyyy-MM-dd HH:mm:ss", Date.class, null);
            result.put("returnData", jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @RequestMapping("getSectInfo")
    public void getSectInfo(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        try
        {
            List<SectInfoWithBLOBs> list = hdService.findSectInfo("0");
            JSONArray jsonArray = JSONFormat.formatDate(list,
                    "yyyy-MM-dd HH:mm:ss", Date.class, null);
            result.put("returnData", jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @RequestMapping("getProjectInfoHDALL")
    public void getProjectInfoHDALL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETPROJECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);

        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            ProjectInfoWithBLOBs pwb;
            hdService.deleteAllProjectInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pwb = new ProjectInfoWithBLOBs();
                hdTask.jsonToObj(pwb, jsonObject);
                pwb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insert(pwb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getDirectInfoHDALL")
    public void getDirectInfoHDALL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETDIRECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            DirectInfoWithBLOBs dwb;
            hdService.deleteAllDirectInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                dwb = new DirectInfoWithBLOBs();
                hdTask.jsonToObj(dwb, jsonObject);
                dwb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertDirectInfo(dwb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getSupervisionInfoHDALL")
    public void getSupervisionInfoHDALL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSUPERVISIONINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        System.out.println(res + "!!!!");
        JSONArray jsonArray = res.getJSONArray("returnData");
        if ("0".equals(res.getString("status")))
        {
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            SupervisionInfoWithBLOBs swb;
            hdService.deleteAllSupervisionInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                swb = new SupervisionInfoWithBLOBs();
                hdTask.jsonToObj(swb, jsonObject);
                swb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertSupervisionInfo(swb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getSectInfoHDALL")
    public void getSectInfoHDALL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            SectInfoWithBLOBs swb;
            hdService.deleteAllSectInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                swb = new SectInfoWithBLOBs();
                hdTask.jsonToObj(swb, jsonObject);
                swb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertSectInfo(swb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getProjectInfoHDZL")
    public void getProjectInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findProjectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETPROJECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            ProjectInfoWithBLOBs pwb;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pwb = new ProjectInfoWithBLOBs();
                hdTask.jsonToObj(pwb, jsonObject);
                if (hdService.findProjectInfoWithBLOBsByID(pwb.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deleteProjectInfoByID(pwb.getId());
                    // System.out.println("修改成功");
                }
                pwb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insert(pwb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getDirectInfoHDZL")
    public void getDirectInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findDirectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETDIRECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            DirectInfoWithBLOBs dwb;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                dwb = new DirectInfoWithBLOBs();
                hdTask.jsonToObj(dwb, jsonObject);
                if (hdService.findDirectInfoByID(dwb.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deleteDirectInfoByID(dwb.getId());
                    // System.out.println("修改成功");
                }
                dwb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertDirectInfo(dwb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getSupervisionInfoHDZL")
    public void getSupervisionInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findSupervisionInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        System.out.println(st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSUPERVISIONINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            SupervisionInfoWithBLOBs swb;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                swb = new SupervisionInfoWithBLOBs();
                hdTask.jsonToObj(swb, jsonObject);
                if (hdService.findSupervisionInfoByID(swb.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deleteSupervisionInfoByID(swb.getId());
                    // System.out.println("修改成功");
                }
                swb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertSupervisionInfo(swb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("getSectInfoHDZL")
    public void getSectInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findSectInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        System.out.println(st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_GETSECTINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            SectInfoWithBLOBs swb;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                swb = new SectInfoWithBLOBs();
                hdTask.jsonToObj(swb, jsonObject);
                if (hdService.findSectInfoByID(swb.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deleteSectInfoByID(swb.getId());
                    // System.out.println("修改成功");
                }
                swb.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertSectInfo(swb);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    @RequestMapping("checkall")
    public void checkall(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "200");
        result.put("message", "成功");
        String id = request.getParameter("id");
        if ("treeDemo".equals(id))
        {
            id = "4028a8835dc68068015de9af3262504f";
        }
        try
        {
            ProjectInfo projectInfo = hdService.findProjectInfoByID(id);
            List<ProjectInfo> projectInfoList = new ArrayList<ProjectInfo>();
            projectInfoList.add(projectInfo);
            JSONArray jsonArray = JSONFormat.formatDate(projectInfoList,
                    "yyyy-MM-dd HH:mm:ss", Date.class, null);
            System.out.println(jsonArray.toString());
            result.put("returnData", jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
