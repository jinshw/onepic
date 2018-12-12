package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.NBaoBean;
import com.ykkj.weiyi.pojo.Plot;
import com.ykkj.weiyi.service.NBaoService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("nbao")
public class NBaoController {
    @Autowired
    NBaoService nBaoService;

    /**
     * 查询年报信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("find")
    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("message", "success");
        String roadcode = request.getParameter("roadcode");
        String areacode = request.getParameter("areacode");
        String roadname = request.getParameter("roadname");
        String startname = request.getParameter("startname");
        String endname = request.getParameter("endname");
        String startzh = request.getParameter("startzh");
        String endzh = request.getParameter("endzh");
        String licheng = request.getParameter("licheng");
        String jscode = request.getParameter("jscode");
        String jslevel = request.getParameter("jslevel");
        String sfyfgs = request.getParameter("sfyfgs");
        String cdsl = request.getParameter("cdsl");
        String mcdm = request.getParameter("mcdm");
        String mclx = request.getParameter("mclx");
        String ljkd = request.getParameter("ljkd");
        String lmkdm = request.getParameter("lmkdm");
        String lmkdcm = request.getParameter("lmkdcm");
        String sjshisu = request.getParameter("sjshisu");
        String nxniandu = request.getParameter("nxniandu");
        String gzniandu = request.getParameter("gzniandu");
        String zjdxniandu = request.getParameter("zjdxniandu");
        String dllx = request.getParameter("dllx");
        String sfcgld = request.getParameter("sfcgld");
        String sfdtld = request.getParameter("sfdtld");
        String sfsfld = request.getParameter("sfsfld");
        String lxbh = request.getParameter("lxbh");
        String cfstartzh = request.getParameter("cfstartzh");
        String cfendzh = request.getParameter("cfendzh");
        String yhls = request.getParameter("yhls");
        String klhlc = request.getParameter("klhlc");
        String dmdm = request.getParameter("dmdm");
        String dmhz = request.getParameter("dmhz");
        String hdsl = request.getParameter("hdsl");
        String gydwmc = request.getParameter("gydwmc");
        String shcrk = request.getParameter("shcrk");
        String njrjtl = request.getParameter("njrjtl");
        String gdtzqlxbh = request.getParameter("gdtzqlxbh");
        String years = request.getParameter("years");

        NBaoBean nBaoBean = new NBaoBean();
        nBaoBean.setRoadcode(roadcode);
        nBaoBean.setAreacode(areacode);
        nBaoBean.setRoadname(roadname);
        nBaoBean.setStartname(startname);
        nBaoBean.setEndname(endname);
        nBaoBean.setStartzh(startzh);
        nBaoBean.setEndzh(endzh);
        nBaoBean.setLicheng(licheng);
        nBaoBean.setJscode(jscode);
        nBaoBean.setJslevel(jslevel);
        nBaoBean.setSfyfgs(sfyfgs);
        nBaoBean.setCdsl(cdsl);
        nBaoBean.setMcdm(mcdm);
        nBaoBean.setMclx(mclx);
        nBaoBean.setLjkd(ljkd);
        nBaoBean.setLmkdm(lmkdm);
        nBaoBean.setLmkdcm(lmkdcm);
        nBaoBean.setSjshisu(sjshisu);
        nBaoBean.setNxniandu(nxniandu);
        nBaoBean.setGzniandu(gzniandu);
        nBaoBean.setZjdxniandu(zjdxniandu);
        nBaoBean.setDllx(dllx);
        nBaoBean.setSfcgld(sfcgld);
        nBaoBean.setSfdtld(sfdtld);
        nBaoBean.setSfsfld(sfsfld);
        nBaoBean.setLxbh(lxbh);
        nBaoBean.setCfstartzh(cfstartzh);
        nBaoBean.setCfendzh(cfendzh);
        nBaoBean.setYhls(yhls);
        nBaoBean.setKlhlc(klhlc);
        nBaoBean.setDmdm(dmdm);
        nBaoBean.setDmhz(dmhz);
        nBaoBean.setHdsl(hdsl);
        nBaoBean.setGydwmc(gydwmc);
        nBaoBean.setShcrk(shcrk);
        nBaoBean.setNjrjtl(njrjtl);
        nBaoBean.setGdtzqlxbh(gdtzqlxbh);
        nBaoBean.setYears(years);
        List list = nBaoService.findList(nBaoBean);
        result.put("list", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(result.toString());
    }

    /**
     * 查询道路编码列表
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("findroadcode")
    public void findRoadcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("message", "success");
        List list = nBaoService.findRoadcode();
        result.put("list", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(result.toString());
    }
}
