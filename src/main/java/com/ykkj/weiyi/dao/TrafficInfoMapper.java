package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.DelInfo;
import com.ykkj.weiyi.pojo.DelInfoExample;
import com.ykkj.weiyi.pojo.TrafficHistoryInfo;
import com.ykkj.weiyi.pojo.TrafficInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TrafficInfoMapper {
    public List<TrafficInfo> findList(@Param("pojo") TrafficInfo trafficInfo);

    public List<TrafficInfo> findHistoryList(@Param("pojo") TrafficHistoryInfo trafficHistoryInfo);

    public Integer findNums();

    public String findMaxTime();
}