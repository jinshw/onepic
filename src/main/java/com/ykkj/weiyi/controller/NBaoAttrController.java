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
        List list = nBaoAttrService.getAttributeField();
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
        String roadcode = request.getParameter("roadcode");
        String startzh = request.getParameter("startzh");
        String endzh = request.getParameter("endzh");
        System.out.println("roadcode=" + roadcode + "  startzh=" + startzh + " endzh=" + endzh);
        NBaoAttr nBaoAttr = new NBaoAttr();
        nBaoAttr.setF_VC_LXBH(roadcode);
        nBaoAttr.setF_NB_GLLDQDZH(Float.valueOf(startzh));
        nBaoAttr.setF_NB_GLLDZDZH(Float.valueOf(endzh));
        List list = nBaoAttrService.findList(nBaoAttr);
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
        String roadcode = request.getParameter("roadcode");
        NBaoAttr nBaoAttr = new NBaoAttr();
        nBaoAttr.setF_VC_LXBH(roadcode);

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
