package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ykkj.weiyi.pojo.NBaoBean;

public interface NBaoBeanMapper {
    int insert(@Param("pojo") NBaoBean pojo);

    int insertSelective(@Param("pojo") NBaoBean pojo);

    int insertList(@Param("pojos") List<NBaoBean> pojo);

    int update(@Param("pojo") NBaoBean pojo);

    List<NBaoBean> findList(NBaoBean nBaoBean);

    List<String> findRoadcode();



}
