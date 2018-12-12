package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.DelInfo;
import com.ykkj.weiyi.pojo.DelInfoExample;
import com.ykkj.weiyi.pojo.TrafficInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrafficInfoMapper {
    public List<TrafficInfo> findList(@Param("pojo") TrafficInfo trafficInfo);
}