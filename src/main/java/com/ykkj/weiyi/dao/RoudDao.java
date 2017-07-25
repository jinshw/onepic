package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ykkj.weiyi.pojo.Roud;

public interface RoudDao {
    int insert(@Param("pojo") Roud pojo);

    int insertSelective(@Param("pojo") Roud pojo);

    int insertList(@Param("pojos") List<Roud> pojo);

    int update(@Param("pojo") Roud pojo);

    List<Roud> find(Roud roud);
}
