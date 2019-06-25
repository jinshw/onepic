package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.TrafficHistoryInfo;
import com.ykkj.weiyi.pojo.TrafficInfo;

import java.util.List;

public interface TrafficInfoService {

    /**
     * 查询拥堵排名信息
     *
     * @return
     */
    List<TrafficInfo> findList(TrafficInfo trafficInfo);

    List<String> findHistoryList(TrafficHistoryInfo trafficHistoryInfo);



}
