package com.ykkj.weiyi.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ykkj.weiyi.pojo.*;
import com.ykkj.weiyi.service.NBaoAttrService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import scala.Int;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/nbattr")
public class NBaoAttrController {
    @Autowired
    private NBaoAttrService nBaoAttrService;

    @RequestMapping("/getattributefield")
    public void getAttributeField(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchType = request.getParameter("searchType");//road 道路，bridge 桥梁 ，suidao 隧道
        System.out.println("getattributefield....searchType="+searchType);
        List list = nBaoAttrService.getAttributeField(searchType);
        response.setContentType("application/json;charset=utf-8");
        String result = JSONUtil.toJsonStr(list);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("/find")
    public void findList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List list = null;
        String searchType = request.getParameter("searchType");//road 道路，bridge 桥梁 ，suidao 隧道
        //桥梁代码= roadcode + xzqh + code
        String year = request.getParameter("year");
        String code = request.getParameter("code");// 桥梁code
        String xzqh = request.getParameter("xzqh");// 桥梁行政区划 拼接桥梁
        String fsbm = request.getParameter("fsbm");//隧道代码：在searchType=suidao 不为空

        String roadcode = request.getParameter("roadcode");
        String startzh = request.getParameter("startzh");
        String endzh = request.getParameter("endzh");
        System.out.println("searchType=" + searchType + " fsbm=" + fsbm + " code=" + code + "  xzqh=" + xzqh + " roadcode=" + roadcode + "  startzh=" + startzh + " endzh=" + endzh);

        if (searchType.equals("road")) {
            NBaoAttr nBaoAttr = new NBaoAttr();
            nBaoAttr.setF_VC_LXBH(roadcode);
            nBaoAttr.setF_NB_GLLDQDZH(Float.valueOf(startzh));
            nBaoAttr.setF_NB_GLLDZDZH(Float.valueOf(endzh));
            if (year != null && year != "") {
                nBaoAttr.setF_NB_ND(Integer.valueOf(year));
            }
            System.out.println("road year==" + year);
            list = nBaoAttrService.findList(nBaoAttr);
        } else if (searchType.equals("bridge")) {
            String bridgeCode = roadcode + xzqh + code;
            NBaoAttrBridge nBaoAttrBridge = new NBaoAttrBridge();
            nBaoAttrBridge.setF_VC_QLDM(bridgeCode);
            nBaoAttrBridge.setF_NB_ND(Integer.valueOf(year));
            list = nBaoAttrService.findBridgeList(nBaoAttrBridge);
        } else {
            NBaoAttrSuiDao nBaoAttrSuiDao = new NBaoAttrSuiDao();
            nBaoAttrSuiDao.setF_NB_ND(Integer.valueOf(year));
            nBaoAttrSuiDao.setF_VC_SDDM(fsbm);
            System.out.println("fsbm222=" + fsbm);
            list = nBaoAttrService.findSuiDaoList(nBaoAttrSuiDao);
            System.out.println("suidao list=" + list.size());
        }

        response.setContentType("application/json;charset=utf-8");
        String result = JSONUtil.toJsonStr(list);

        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("/queryLength")
    public void queryLength(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String year = request.getParameter("year");
        String roadcode = request.getParameter("roadcode");
        System.out.println("year=="+year+"  roadcode==="+roadcode);
        NBaoAttr nBaoAttr = new NBaoAttr();
        nBaoAttr.setF_VC_LXBH(roadcode);

        if (year != null && year != "") {
            nBaoAttr.setF_NB_ND(Integer.valueOf(year));
        }
//        nBaoAttr.setF_NB_ND(2017);

        String result = nBaoAttrService.queryLenght(nBaoAttr);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("findRoadNUM")
    public void findRoadNUM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //F_NB_ND	NUMBER(4,0)	Yes		年度
        String year = request.getParameter("year");
        //F_VC_GLLCNDDDSZBDM	VARCHAR2(2)	Yes		"公路里程年底到达数指标代码
        String code = request.getParameter("code");
        //F_VC_XZDJDM	VARCHAR2(2)	Yes		"路线所属行政等级代码
        String type = request.getParameter("type");
        //F_VC_GLJSDJDM	VARCHAR2(4)	Yes		"公路技术等级代码
        String level = request.getParameter("level");

        NBaoRoadJSDJNUM nBaoRoadJSDJNUM = new NBaoRoadJSDJNUM();
        if (year != null && year != "") {
            nBaoRoadJSDJNUM.setF_nb_nd(Integer.valueOf(year));
        }
        nBaoRoadJSDJNUM.setF_vc_gllcndddszbdm(code);
        nBaoRoadJSDJNUM.setF_vc_xzdjdm(type);
        nBaoRoadJSDJNUM.setF_vc_gljsdjdm(level);

        String result = "";
        String num = nBaoAttrService.findRoadNUM(nBaoRoadJSDJNUM);

        System.out.println("findRoadNUM---year="+year+" code="+code+" type="+type+" level="+level +"  result="+num);
        result = num;
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("findBirdgeNUM")
    public void findBirdgeNUM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //F_NB_ND	NUMBER(4,0)	Yes		年度
        String year = request.getParameter("year");
        //F_VC_GLLCNDDDSZBDM	VARCHAR2(2)	Yes		"公路里程年底到达数指标代码
        String code = request.getParameter("code");
        //F_VC_XZDJDM	VARCHAR2(2)	Yes		"路线所属行政等级代码
        String type = request.getParameter("type");
        /**
         * F_VC_GLQLTJLXDM	VARCHAR2(3)	Yes		"公路桥梁统计类型代码
         * 01桥梁总计 011互通式立交桥 012特大桥 013大桥 014中桥 015小桥 02渡口 021机动渡口
         */
        String level = request.getParameter("level");

        /**
         * F_VC_TJDWDM	VARCHAR2(2)	Yes		"统计单位代码 1座 2延米 3处 4道"
         */
        String unit = request.getParameter("unit");

        NBaoBirdgeNUM nBaoBirdgeNUM = new NBaoBirdgeNUM();
        if (year != null && year != "") {
            nBaoBirdgeNUM.setF_nb_nd(Integer.valueOf(year));
        }
        nBaoBirdgeNUM.setF_vc_gllcndddszbdm(code);
        nBaoBirdgeNUM.setF_vc_xzdjdm(type);
        nBaoBirdgeNUM.setF_vc_glqltjlxdm(level);
        nBaoBirdgeNUM.setF_vc_tjdwdm(unit);

        String result = "";
        Integer num = nBaoAttrService.findBirdgeNUM(nBaoBirdgeNUM);

        System.out.println("findBirdgeNUM ---- year="+year+" code="+code+" type="+type+" level="+level+" unit="+unit +"  result="+num);

        result = String.valueOf(num);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("findSuiDaoNUM")
    public void findSuiDaoNUM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //F_NB_ND	NUMBER(4,0)	Yes		年度
        String year = request.getParameter("year");
        //F_VC_GLLCNDDDSZBDM	VARCHAR2(2)	Yes		"公路里程年底到达数指标代码
        String code = request.getParameter("code");
        //F_VC_XZDJDM	VARCHAR2(2)	Yes		"路线所属行政等级代码
        String type = request.getParameter("type");
        //F_VC_SDFLDM	VARCHAR2(2)	Yes		"隧道按长度的分类代码
        String level = request.getParameter("level");
        //F_VC_TJDWDM	VARCHAR2(2)	Yes		"统计单位代码  1座 2延米 3处 4道"
        String unit = request.getParameter("unit");


        NBaoSuiDaoNUM nBaoSuiDaoNUM = new NBaoSuiDaoNUM();
        if (year != null && year != "") {
            nBaoSuiDaoNUM.setF_nb_nd(Integer.valueOf(year));
        }
        nBaoSuiDaoNUM.setF_vc_gllcndddszbdm(code);
        nBaoSuiDaoNUM.setF_vc_xzdjdm(type);
        nBaoSuiDaoNUM.setF_vc_sdfldm(level);
        nBaoSuiDaoNUM.setF_vc_tjdwdm(unit);

        String result = "";
        Integer num = nBaoAttrService.findSuiDaoNUM(nBaoSuiDaoNUM);
        System.out.println("findSuiDaoNUM ---- year="+year+" code="+code+" type="+type+" level="+level+" unit="+unit +"  result="+num);
        result = String.valueOf(num);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }


    @RequestMapping("findSmallBirdgeNUM")
    public void findSmallBirdgeNUM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //F_NB_ND	NUMBER(4,0)	Yes		年度
        String year = request.getParameter("year");
        //F_VC_GLLCNDDDSZBDM	VARCHAR2(2)	Yes		"公路里程年底到达数指标代码
        String code = request.getParameter("code");
        //F_VC_XZDJDM	VARCHAR2(2)	Yes		"路线所属行政等级代码
        String type = request.getParameter("type");
        /**
         * F_VC_GLQLTJLXDM	VARCHAR2(3)	Yes		"公路桥梁统计类型代码
         * 01桥梁总计 011互通式立交桥 012特大桥 013大桥 014中桥 015小桥 02渡口 021机动渡口
         */
        String level = request.getParameter("level");//

        /**
         * F_VC_TJDWDM	VARCHAR2(2)	Yes		"统计单位代码 1座 2延米 3处 4道"
         */
        String unit = request.getParameter("unit");


        NBaoSmallBridgeNUM nBaoSmallBridgeNUM = new NBaoSmallBridgeNUM();
        if (year != null && year != "") {
            nBaoSmallBridgeNUM.setF_nb_nd(Integer.valueOf(year));// 2017
        }
        nBaoSmallBridgeNUM.setF_vc_gllcndddszbdm(code);// 2 本年年底到达数
        nBaoSmallBridgeNUM.setF_vc_xzdjdm(type);//
        nBaoSmallBridgeNUM.setF_vc_glqltjasynxlxdm(level);// 011危桥
        nBaoSmallBridgeNUM.setF_vc_tjdwdm(unit);//1 座

        String result = "";
        Integer num = nBaoAttrService.findSmallBirdgeNUM(nBaoSmallBridgeNUM);

        System.out.println("findSmallBirdgeNUM ---- year="+year+" code="+code+" type="+type+" level="+level+" unit="+unit +"  result="+num);
        result = String.valueOf(num);
        String callback = request.getParameter("callback");
        if (!StringUtils.isBlank(callback)) {
            result = callback + "(" + result + ")";
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }
}
