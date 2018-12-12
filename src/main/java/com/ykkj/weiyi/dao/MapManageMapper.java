package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ykkj.weiyi.pojo.MapManage;

public interface MapManageMapper {
    int insert(@Param("pojo") MapManage pojo);

    int insertSelective(@Param("pojo") MapManage pojo);

    int insertList(@Param("pojos") List<MapManage> pojo);

    int update(@Param("pojo") MapManage pojo);

    List<MapManage> find(MapManage mapManage);
}
