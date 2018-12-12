package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.MQIBeanMapper;
import com.ykkj.weiyi.dao.TrafficInfoMapper;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.TrafficInfo;
import com.ykkj.weiyi.service.TrafficInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficInfoServiceImpl implements TrafficInfoService {
    
    @Autowired
    private TrafficInfoMapper trafficInfoMapper;

    public List<TrafficInfo> findList(TrafficInfo trafficInfo) {
        System.out.println("trafficInfo.getOrderBy()===="+trafficInfo.getOrderBy());
        return trafficInfoMapper.findList(trafficInfo);
    }
}
