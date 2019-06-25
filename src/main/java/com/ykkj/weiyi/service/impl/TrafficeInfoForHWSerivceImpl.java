package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.TrafficInfoMapper;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.service.TrafficeInfoForHWSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DataSource("dataSourceMysTow")
public class TrafficeInfoForHWSerivceImpl implements TrafficeInfoForHWSerivce {
    @Autowired
    private TrafficInfoMapper trafficInfoMapper;

    public Integer findNums(){
        return trafficInfoMapper.findNums();
    }

    public String findMaxTime(){
        return trafficInfoMapper.findMaxTime();
    }
}
