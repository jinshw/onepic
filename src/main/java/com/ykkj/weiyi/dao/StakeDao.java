package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.ykkj.weiyi.pojo.Stake;

public interface StakeDao {
    int insert(@Param("pojo") Stake pojo);

    int insertSelective(@Param("pojo") Stake pojo);

    int insertList(@Param("pojos") List<Stake> pojo);

    int update(@Param("pojo") Stake pojo);

    List<Stake> queryStakeByLocation(Map map);

}
