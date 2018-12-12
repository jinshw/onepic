package com.ykkj.weiyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * 获取实时路况有效信息
 * @throws IOException
 */
@Controller
@RequestMapping({"/rttTra"})
public class RttDataTransferController {

    /**
     * 中转服务-通过url获取实时路况数据流
     * @throws IOException
     */
    @RequestMapping(value = "/getRttDataByCodeAndKind")
    @ResponseBody
    public String getRttDataByCodeAndKind(@RequestParam(value = "adcode", required = true) String areaCode,
                                  @RequestParam(value = "kind", required = true) String kindLevel) {
        String res = "";
        try {
            String urlStr = "http://newte.sh.1251225243.clb.myqcloud.com/TEGateway/123456/RTICTraffic.xml?bizcode=xjjtysxx6bc624asdb98asdhjdf12&version=1701&datatype=14&format=1&adcode=" + areaCode+"&kind="+kindLevel;
            URL url = new URL(urlStr);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line;
            }
            in.close();
        } catch (Exception e) {
            //logger.error("error in wapaction,and e is " + e.getMessage());
        }
        return res;
    }


}