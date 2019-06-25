package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.MQIBeanMapper;
import com.ykkj.weiyi.dao.TrafficInfoMapper;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.TrafficHistoryInfo;
import com.ykkj.weiyi.pojo.TrafficInfo;
import com.ykkj.weiyi.service.TrafficInfoService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Int;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@DataSource("dataSourceMys")
public class TrafficInfoServiceImpl implements TrafficInfoService {
    
    @Autowired
    private TrafficInfoMapper trafficInfoMapper;

    public List<TrafficInfo> findList(TrafficInfo trafficInfo) {
        System.out.println("trafficInfo.getOrderBy()===="+trafficInfo.getOrderBy());
        return trafficInfoMapper.findList(trafficInfo);
    }

    public List<String> findHistoryList(TrafficHistoryInfo trafficHistoryInfo){
        List<TrafficInfo> list = trafficInfoMapper.findHistoryList(trafficHistoryInfo);
        Iterator<TrafficInfo> iterator =  list.iterator();
        TrafficInfo trafficInfo = null;
        String niLinkID,niLinkLength;
        JSONArray jsonArray = null;
        List<String> idList = new ArrayList<>();
        while (iterator.hasNext()){
            trafficInfo = iterator.next();
            jsonArray = JSONArray.fromObject(trafficInfo.getIncludeStr());
            for(int i=0;i<jsonArray.size();i++){
                niLinkID = jsonArray.getJSONObject(i).getString("NILinkID");
                niLinkLength = jsonArray.getJSONObject(i).getString("NILinkLength");
                if(!idList.contains(niLinkID)){
                    idList.add(niLinkID);
                }
            }
        }
        return idList;
    }
}
