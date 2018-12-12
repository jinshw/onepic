package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.RoadZd;

import java.util.List;

@DataSource("dataSourceOrc")
public interface RoadZdMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoadZd record);

    int insertSelective(RoadZd record);

    RoadZd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoadZd record);

    int updateByPrimaryKey(RoadZd record);

    List<RoadZd> findByTypeCode(String sysDateTime);




}
