package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ykkj.weiyi.pojo.Plot;

public interface PlotMapper {
    int insert(@Param("pojo") Plot pojo);

    int insertSelective(@Param("pojo") Plot pojo);

    int insertList(@Param("pojos") List<Plot> pojo);

    int update(@Param("pojo") Plot pojo);

    List<Plot> find(Plot plot);

    int delete(Plot plot);



}
