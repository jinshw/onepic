package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.RoadZd;
import com.ykkj.weiyi.pojo.TrafficInfo;

import java.util.List;

public interface TrafficInfoService {

    /**
     * 查询拥堵排名信息
     * @return
     */
    public List<TrafficInfo> findList(TrafficInfo trafficInfo);
}
