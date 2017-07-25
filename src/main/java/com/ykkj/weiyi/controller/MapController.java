package com.ykkj.weiyi.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
@RequestMapping({"/map"})
public class MapController {


	//获取点Json数据
	@RequestMapping({"/getPointJson"})
	public void getPointJson( HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();

		BufferedReader br = null;
		StringBuffer sbf = new StringBuffer();
		try {
//			br = new BufferedReader(new FileReader(
//					"src/json/mark_list.txt"));// 读取原始json文件
//			br = new BufferedReader(new FileReader(
//					"D:\\jsonlist\\mark_list.txt"));// 读取原始json文件
			br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\jsonlist\\mark_list.txt"), "UTF-8"));
				String s = null;
				while ((s = br.readLine()) != null) {
					System.out.println(s);
					sbf.append(s.trim());
				}
				jsonObject.put("state", Integer.valueOf(500));
				jsonObject.put("message", "查询数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("state", Integer.valueOf(500));
			jsonObject.put("message", "系统异常,请稍后重试");
		}finally {
			br.close();
		}
		JSONArray jsonArray = JSONArray.fromObject(sbf.toString());
		jsonObject.put("marklist",jsonArray.toString());
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonObject.toString());
		
	}

}
