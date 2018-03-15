package com.ykkj.weiyi.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.ykkj.weiyi.pojo.DirectInfo;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.JdpzInfo;
import com.ykkj.weiyi.pojo.PmsComPactListing;
import com.ykkj.weiyi.pojo.PmsIssueInfo;
import com.ykkj.weiyi.pojo.PmsPlanInputZbWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliang;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangMainWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfo;
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

    // 获取海德项目信息——所有
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

    // 获取海德指挥部信息——所有
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

    // 获取海德监理信息——所有
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

    // 获取海德标段信息——所有
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

    // 获取海德期号基本信息——所有
    @RequestMapping("getPmsIssueInfoHDALL")
    public void getPmsIssueInfoHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {

        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        // map.put("type", "1");
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSISSUEINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsIssueInfo pii;
            hdService.deleteAllPmsIssueInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pii = new PmsIssueInfo();
                hdTask.jsonToObj(pii, jsonObject);
                pii.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertPmsIssueInfo(pii);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取海德计量单主表信息——所有
    @RequestMapping("getPmsQingdanJiliangMainHDALL")
    public void getPmsQingdanJiliangMainHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {
        int listMaxCount = 500;
        int count = 0;
        List<PmsQingdanJiliangMainWithBLOBs> PQJMList = new ArrayList<PmsQingdanJiliangMainWithBLOBs>();
        HdTask hdTask = new HdTask();
        int id = 0;
        hdService.deleteAllPmsQingdanJiliangMain();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        String[] myTime = this.getMyTime(new Date(2012 - 1900, 1 - 1, 1),
                new Date(2018 - 1900, 1 - 1, 1), "yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < myTime.length - 1; i++)
        {
            map.put("type", "0");
            map.put("startTime", myTime[i]);
            map.put("endTime", myTime[i + 1]);
            System.out.println("i=" + i + "    sT=" + myTime[i] + "     eT="
                    + myTime[i + 1]);
            String datas = HttpUtils.URLGet(
                    StaticUtils.HD_PMSQINGDANJILIANGMAIN, map, "UTF-8");
            JSONObject res = JSONObject.fromObject(datas);
            if ("0".equals(res.getString("status")))
            {
                JSONArray jsonArray = res.getJSONArray("returnData");
                Iterator<JSONObject> iterator = jsonArray.iterator();
                JSONObject jsonObject;
                PmsQingdanJiliangMainWithBLOBs pqjm;
                while (iterator.hasNext())
                {
                    jsonObject = iterator.next();
                    pqjm = new PmsQingdanJiliangMainWithBLOBs();
                    hdTask.jsonToObj(pqjm, jsonObject);
                    pqjm.setCreattime(new Timestamp(new Date().getTime()));
                    PQJMList.add(pqjm);
                    count++;
                    if (count == listMaxCount)
                    {
                        System.out.println(1);
                        hdService.insertPmsQingdanJiliangMain(PQJMList);
                        count = 0;
                        PQJMList.clear();
                    }
                }
                if (!PQJMList.isEmpty())
                {
                    hdService.insertPmsQingdanJiliangMain(PQJMList);
                    PQJMList.clear();
                }
            }
            else
            {
                System.out.println(res);
            }
        }

    }

    // 测试
    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response)
            throws ParseException
    {
        int listMaxCount = 1;
        int count = 0;
        int flag = 0;
        List<PmsPlanInputZbWithBLOBs> PQJList = new ArrayList<PmsPlanInputZbWithBLOBs>();
        HdTask hdTask = new HdTask();
        int id = 0;
        // hdService.deleteAllPmsQingdanJiliang();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        String[] myTime = this.getMyTime(new Date(2012 - 1900, 1 - 1, 1),
                new Date(2018 - 1900, 1 - 1, 1), "yyyy-MM-dd HH:mm:ss");
        // startTime=2017-03-11%2001:01:01&endTime=2017-03-18%2001:01:01
        map.put("type", "0");
        map.put("startTime", "2012-07-19 01:01:01");
        map.put("endTime", "2012-07-26 01:01:01");
        System.out.println("sT=" + map.get("startTime") + "     eT="
                + map.get("endTime"));
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSPLANINPUTZB, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            String s = res.getString("returnData");
            System.out.println(s);
            JSONArray jsonArray = JSONArray.fromObject(s);
            // JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsPlanInputZbWithBLOBs pqj;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pqj = new PmsPlanInputZbWithBLOBs();
                hdTask.jsonToObj(pqj, jsonObject);
                pqj.setCreattime(new Timestamp(new Date().getTime()));
                PQJList.add(pqj);
                count++;
                if (count == listMaxCount)
                {
                    flag++;
                    System.out.println(1);
                    // hdService.insertPmsQingdanJiliang(PQJList);
                    count = 0;
                    PQJList.clear();
                    System.out.println(flag);
                }
            }
            if (!PQJList.isEmpty())
            {
                // hdService.insertPmsQingdanJiliang(PQJList);
                PQJList.clear();
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取海德计量单子表信息——所有
    @RequestMapping("getPmsQingdanJiliangHDALL")
    public void getPmsQingdanJiliangHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {
        int listMaxCount = 500;
        int count = 0;
        List<PmsQingdanJiliangWithBLOBs> PQJList = new ArrayList<PmsQingdanJiliangWithBLOBs>();
        HdTask hdTask = new HdTask();
        int id = 0;
        hdService.deleteAllPmsQingdanJiliang();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        String[] myTime = this.getMyTime(new Date(2012 - 1900, 1 - 1, 1),
                new Date(2018 - 1900, 1 - 1, 1), "yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < myTime.length - 1; i++)
        {
            map.put("type", "0");
            map.put("startTime", myTime[i]);
            map.put("endTime", myTime[i + 1]);
            System.out.println("i=" + i + "    sT=" + myTime[i] + "     eT="
                    + myTime[i + 1]);
            String datas = HttpUtils.URLGet(StaticUtils.HD_PMSQINGDANJILIANG,
                    map, "UTF-8");
            JSONObject res = JSONObject.fromObject(datas);
            if ("0".equals(res.getString("status")))
            {
                JSONArray jsonArray = res.getJSONArray("returnData");
                Iterator<JSONObject> iterator = jsonArray.iterator();
                JSONObject jsonObject;
                PmsQingdanJiliangWithBLOBs pqj;
                while (iterator.hasNext())
                {
                    jsonObject = iterator.next();
                    pqj = new PmsQingdanJiliangWithBLOBs();
                    hdTask.jsonToObj(pqj, jsonObject);
                    pqj.setCreattime(new Timestamp(new Date().getTime()));
                    PQJList.add(pqj);
                    count++;
                    if (count == listMaxCount)
                    {
                        System.out.println(1);
                        hdService.insertPmsQingdanJiliang(PQJList);
                        count = 0;
                        PQJList.clear();
                    }
                }
                if (!PQJList.isEmpty())
                {
                    hdService.insertPmsQingdanJiliang(PQJList);
                    PQJList.clear();
                }
            }
            else
            {
                System.out.println(res);
            }
        }

    }

    // 获取海德合同清单表信息——所有
    @RequestMapping("getPmsComPactListingHDALL")
    public void getPmsComPactListingHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {
        int listMaxCount = 500;
        int count = 0;
        List<PmsComPactListing> PCPLList = new ArrayList<PmsComPactListing>();
        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSCOMPACTLISTING, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsComPactListing pcml;
            hdService.deleteAllPmsComPactListing();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pcml = new PmsComPactListing();
                hdTask.jsonToObj(pcml, jsonObject);
                pcml.setCreattime(new Timestamp(new Date().getTime()));
                PCPLList.add(pcml);
                count++;
                if (count == listMaxCount)
                {
                    System.out.println(1);
                    hdService.insertPmsComPactListing(PCPLList);
                    count = 0;
                    PCPLList.clear();
                }
            }
            if (!PCPLList.isEmpty())
            {
                hdService.insertPmsComPactListing(PCPLList);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取预备费配置信息——所有
    @RequestMapping("getJdpzInfoHDALL")
    public void getJdpzInfoListingHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {
        int listMaxCount = 500;
        int count = 0;
        List<JdpzInfo> jdpzInfo = new ArrayList<JdpzInfo>();
        HdTask hdTask = new HdTask();
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        String datas = HttpUtils.URLGet(StaticUtils.HD_JDPZINFO, map, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            JdpzInfo jdpz;
            hdService.deleteAllJdpzInfo();
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                jdpz = new JdpzInfo();
                hdTask.jsonToObj(jdpz, jsonObject);
                jdpz.setCreattime(new Timestamp(new Date().getTime()));
                jdpzInfo.add(jdpz);
                count++;
                if (count == listMaxCount)
                {
                    System.out.println(1);
                    hdService.insertJdpzInfoList(jdpzInfo);
                    count = 0;
                    jdpzInfo.clear();
                }
            }
            if (!jdpzInfo.isEmpty())
            {
                hdService.insertJdpzInfoList(jdpzInfo);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取月报录入信息——所有
    @RequestMapping("getPmsPlaninputZbInfoHDALL")
    public void getPmsPlaninputZbInfoHDALL(HttpServletRequest request,
            HttpServletResponse response) throws ParseException
    {
        int listMaxCount = 500;
        int count = 0;
        List<PmsPlanInputZbWithBLOBs> PPIZList = new ArrayList<PmsPlanInputZbWithBLOBs>();
        HdTask hdTask = new HdTask();
        int id = 0;
        hdService.deleteAllPmsPlanInputZbinfo();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        String[] myTime = this.getMyTime(new Date(2012 - 1900, 1 - 1, 1),
                new Date(2018 - 1900, 1 - 1, 1), "yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < myTime.length - 1; i++)
        {
            map.put("type", "0");
            map.put("startTime", myTime[i]);
            map.put("endTime", myTime[i + 1]);
            System.out.println("i=" + i + "    sT=" + myTime[i] + "     eT="
                    + myTime[i + 1]);
            String datas = HttpUtils.URLGet(StaticUtils.HD_PMSPLANINPUTZB, map,
                    "UTF-8");
            JSONObject res = JSONObject.fromObject(datas);
            if ("0".equals(res.getString("status")))
            {
                String s = res.getString("returnData");
                System.out.println(s);
                JSONArray jsonArray = JSONArray.fromObject(s);
                Iterator<JSONObject> iterator = jsonArray.iterator();
                JSONObject jsonObject;
                PmsPlanInputZbWithBLOBs pqj;
                while (iterator.hasNext())
                {
                    jsonObject = iterator.next();
                    pqj = new PmsPlanInputZbWithBLOBs();
                    hdTask.jsonToObj(pqj, jsonObject);
                    pqj.setCreattime(new Timestamp(new Date().getTime()));
                    System.out.println(pqj.getInserttime());
                    PPIZList.add(pqj);
                    count++;
                    if (count == listMaxCount)
                    {
                        System.out.println(1);
                        hdService.insertPmsPlanInputZbList(PPIZList);
                        count = 0;
                        PPIZList.clear();
                    }
                }
                if (!PPIZList.isEmpty())
                {
                    hdService.insertPmsPlanInputZbList(PPIZList);
                    PPIZList.clear();
                }
            }
            else
            {
                System.out.println(res);
            }
        }

    }

    // 获取海德项目信息——增量
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

    // 获取海德指挥部信息——增量
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

    // 获取监理项目信息——增量
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

    // 获取海德标段信息——增量
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

    // 获取海德合同清单信息——增量
    @RequestMapping("getPmsComPactListingHDZL")
    public void getPmsComPactListingHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findPmsComPactListingMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSCOMPACTLISTING, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsComPactListing pcpl;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pcpl = new PmsComPactListing();
                hdTask.jsonToObj(pcpl, jsonObject);
                if (hdService.findPmsComPactListingById(pcpl.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deletePmsComPactListingById(pcpl.getId());
                    // System.out.println("修改成功");
                }
                pcpl.setCreattime(new Timestamp(new Date().getTime()));
                // hdService.insertPmsComPactListing(pcpl);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取海德计量单子表信息——增量
    @RequestMapping("getPmsQingdanJiliangHDZL")
    public void getPmsQingdanJiliangHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findPmsQingdanJiliangMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSQINGDANJILIANG, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsQingdanJiliang pqj;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pqj = new PmsQingdanJiliang();
                hdTask.jsonToObj(pqj, jsonObject);
                if (hdService.findPmsQingdanJiliangById(pqj.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deletePmsQingdanJiliangById(pqj.getId());
                    // System.out.println("修改成功");
                }
                pqj.setCreattime(new Timestamp(new Date().getTime()));
                // hdService.insertPmsQingdanJiliang(pqj);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取计量单主表信息——增量
    @RequestMapping("getPmsQingdanJiliangMainHDZL")
    public void getPmsQingdanJiliangMainHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {
        int listMaxCount = 500;
        int count = 0;
        List<PmsQingdanJiliangMainWithBLOBs> PQJMList = new ArrayList<PmsQingdanJiliangMainWithBLOBs>();
        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findPmsQingdanJiliangMainMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSQINGDANJILIANGMAIN,
                map, "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsQingdanJiliangMainWithBLOBs pqjm;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pqjm = new PmsQingdanJiliangMainWithBLOBs();
                hdTask.jsonToObj(pqjm, jsonObject);
                if (hdService.findPmsQingdanJiliangMainById(pqjm.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deletePmsQingdanJiliangMainById(pqjm.getId());
                    // System.out.println("修改成功");
                }
                pqjm.setCreattime(new Timestamp(new Date().getTime()));
                PQJMList.add(pqjm);
                count++;
                if (count == listMaxCount)
                {
                    System.out.println(1);
                    hdService.insertPmsQingdanJiliangMain(PQJMList);
                    count = 0;
                    PQJMList.clear();
                }
            }
            if (!PQJMList.isEmpty())
            {
                hdService.insertPmsQingdanJiliangMain(PQJMList);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取期号基本信息——增量
    @RequestMapping("getPmsIssueInfoHDZL")
    public void getPmsIssueInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findPmsIssueInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        System.out.println(st);
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_PMSISSUEINFO, map,
                "UTF-8");
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            PmsIssueInfo pii;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                pii = new PmsIssueInfo();
                hdTask.jsonToObj(pii, jsonObject);
                System.out.println(pii);
                if (hdService.findPmsIssueInfoById(pii.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deletePmsIssueInfoById(pii.getId());
                    // System.out.println("修改成功");
                }
                pii.setCreatetime(new Timestamp(new Date().getTime()));
                hdService.insertPmsIssueInfo(pii);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取预备费进度配置信息——增量
    @RequestMapping("getJdpzInfoHDZL")
    public void getJdpzInfoHDZL(HttpServletRequest request,
            HttpServletResponse response)
    {

        HdTask hdTask = new HdTask();
        String st = "";
        st = hdService.findJdpzInfoMaxInserttime();
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        System.out.println(st + ">??");
        int id = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datas = HttpUtils.URLGet(StaticUtils.HD_JDPZINFO, map, "UTF-8");
        System.out.println(datas);
        JSONObject res = JSONObject.fromObject(datas);
        if ("0".equals(res.getString("status")))
        {
            JSONArray jsonArray = res.getJSONArray("returnData");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            JSONObject jsonObject;
            JdpzInfo jdpz;
            List<JdpzInfo> jdpzInfo = new ArrayList<JdpzInfo>();
            int listMaxCount = 500;
            int count = 0;
            while (iterator.hasNext())
            {
                jsonObject = iterator.next();
                jdpz = new JdpzInfo();
                hdTask.jsonToObj(jdpz, jsonObject);
                if (hdService.findPmsJdpzInfoById(jdpz.getId()) != null)
                {
                    // System.out.println("id:" + pwb.getId() + "重复，修改中....");
                    hdService.deleteJdpzInfoById(jdpz.getId());
                    // System.out.println("修改成功");
                }
                jdpz.setCreattime(new Timestamp(new Date().getTime()));

                jdpzInfo.add(jdpz);
                count++;
                if (count == listMaxCount)
                {
                    hdService.insertJdpzInfoList(jdpzInfo);
                    count = 0;
                    jdpzInfo.clear();
                }
            }
            if (!jdpzInfo.isEmpty())
            {
                hdService.insertJdpzInfoList(jdpzInfo);
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 获取海德删除信息
    @RequestMapping("getDeleteInfoHD")
    public void getDeleteInfoHD(HttpServletRequest request,
            HttpServletResponse response)
    {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HdTask hdTask = new HdTask();
        Date data = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        String st = sf.format(calendar.getTime());
        // 配置参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "0");
        map.put("startTime", st);
        System.out.println(st);
        int id = 0;
        String datas = HttpUtils.URLGet(StaticUtils.HD_DELETETINFO, map,
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
                String type = jsonObject.getString("type");
                String deleteid = jsonObject.getString("id");
                String inserttime = jsonObject.getString("inserttime");
                switch (type)
                {
                case "1":
                    hdService.deleteProjectInfoByID(deleteid);
                    break;
                case "2":
                    hdService.deleteDirectInfoByID(deleteid);
                    break;
                case "3":
                    hdService.deleteSupervisionInfoByID(deleteid);
                    break;
                case "4":
                    hdService.deleteSectInfoByID(deleteid);
                    break;

                default:
                    break;
                }
            }
        }
        else
        {
            System.out.println(res);
        }
    }

    // 查询所有表的信息 并返回展示在前台
    @RequestMapping("checkall")
    public void checkall(HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONObject result = new JSONObject();
        result.put("status", "200");
        result.put("message", "成功");
        String id = request.getParameter("id");
        /*
         * if ("treeDemo".equals(id) || "treeDemoDZ".equals(id)) { id =
         * "4028a8835dc68068015de9af3262504f"; }
         */
        int a[] = new int[2000];
        try
        {
            ProjectInfo projectInfo = hdService.findProjectInfoByID(id);
            DirectInfo directInfo = hdService
                    .findDirectInfoByProjectId(projectInfo.getId());
            List<ProjectInfo> projectInfoList = new ArrayList<ProjectInfo>();
            List<DirectInfo> directInfoList = new ArrayList<DirectInfo>();
            List<SupervisionInfoWithBLOBs> supervisionInfoList = hdService
                    .findSupervisionInfoByProjectId(projectInfo.getId());
            List<SectInfo> sectInfoList = hdService
                    .findSectInfoByDirectId(directInfo.getId());
            projectInfoList.add(projectInfo);
            directInfoList.add(directInfo);
            // supervisionInfoList.add(supervisionInfo);
            // sectInfoList.add(sectInfo);

            JSONArray jsonArray = JSONFormat.formatDate(projectInfoList,
                    "yyyy-MM-dd", Date.class, null);
            JSONArray jsonArray1 = JSONFormat.formatDate(directInfoList,
                    "yyyy-MM-dd", Date.class, null);
            JSONArray jsonArray2 = JSONFormat.formatDate(supervisionInfoList,
                    "yyyy-MM-dd", Date.class, null);
            JSONArray jsonArray3 = JSONFormat.formatDate(sectInfoList,
                    "yyyy-MM-dd", Date.class, null);
            System.out.println(jsonArray3.toString());
            result.put("projectInfo", jsonArray.toString());
            result.put("directInfo", jsonArray1.toString());
            result.put("supervisionInfo", jsonArray2.toString());
            result.put("sectInfo", jsonArray3.toString());

            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public String[] getMyTime(Date stime, Date etime, String format)
    {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        System.out.println(sf.format(etime));
        long day = (etime.getTime() - stime.getTime()) / (24 * 60 * 60 * 1000);
        String[] myTime = new String[(int) (2 * day / 7 + 4)];
        myTime[0] = sf.format(stime);
        for (int j = 0, i = 0; j <= myTime.length - 2; i += 7, j++)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(stime);
            if (i % 2 == 1)
            {
                calendar.add(Calendar.DATE, +1);
            }
            else
            {
                calendar.add(Calendar.DATE, +7);
            }
            stime = calendar.getTime();
            myTime[j + 1] = sf.format(stime);
        }
        return myTime;

    }

}
