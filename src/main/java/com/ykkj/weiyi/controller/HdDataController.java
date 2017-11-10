package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.service.HdService;
import com.ykkj.weiyi.util.JSONFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("hd")
public class HdDataController {

    @Autowired
    private HdService hdService;

    @RequestMapping("getProjectInfo")
    public void getProjectInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");

        try {
            List<ProjectInfoWithBLOBs> list = hdService.find("0");
            JSONArray jsonArray = JSONFormat.formatDate(list,"yyyy-MM-dd HH:mm:ss",Date.class,null);
            result.put("returnData",jsonArray.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
