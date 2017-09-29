package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.Plot;
import com.ykkj.weiyi.service.PlotService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("plot")
public class PlotController {
    @Autowired
    private PlotService plotService;

    /**
     * 新增标注信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("insert")
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("message", "success");
        String px = request.getParameter("pointx");
        String py = request.getParameter("pointy");
        String content = request.getParameter("content");
        String keycode = request.getParameter("keycode");
        Plot plot = new Plot();
        plot.setPointx(NumberUtils.toDouble(px));
        plot.setPointy(NumberUtils.toDouble(py));
        plot.setContent(content);
        plot.setKeycode(keycode);
        plot.setCreatetime(new Date());
        int rint = plotService.insertSelective(plot);
        if(rint <= 0){
            result.put("status", 500);
            result.put("message", "新增失败");
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(result.toString());
    }

    /**
     * 查询标注列表
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("find")
    public void find(HttpServletRequest request,HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("message", "success");
        String px = request.getParameter("pointx");
        String py = request.getParameter("pointy");
        String content = request.getParameter("content");
        String keycode = request.getParameter("keycode");
        Plot plot = new Plot();
        plot.setPointx(NumberUtils.toDouble(px));
        plot.setPointy(NumberUtils.toDouble(py));

        List<Plot> list = plotService.find(plot);
        result.put("list",list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(result.toString());
    }

    /**
     * 删除
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("delete")
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("message", "success");
        String px = request.getParameter("pointx");
        String py = request.getParameter("pointy");
        String content = request.getParameter("content");
        String keycode = request.getParameter("keycode");
        Plot plot = new Plot();
        plot.setPointx(NumberUtils.toDouble(px));
        plot.setPointy(NumberUtils.toDouble(py));
        int rint = plotService.delete(plot);
        result.put("rint",rint);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(result.toString());
    }

}
