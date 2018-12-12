package com.ykkj.weiyi.controller;

import com.ykkj.weiyi.pojo.MapManage;
import com.ykkj.weiyi.service.MapManageService;
import com.ykkj.weiyi.util.JSONFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mapManage")
public class MapManageController {
    @Autowired
    private MapManageService mapManageService;

    @RequestMapping("/find")
    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        MapManage mapManage = new MapManage();
        List<MapManage> list = mapManageService.find(mapManage);
        JSONArray jsonArray = JSONFormat.formatDate(list,
                "yyyy-MM-dd HH:mm:ss", Date.class, null);
        jsonObject.put("marklist", jsonArray.toString());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }
}
