package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ykkj.weiyi.pojo.MqiVal;

public interface MqiValMapper {
    int insert(@Param("pojo") MqiVal pojo);

    int insertSelective(@Param("pojo") MqiVal pojo);

    int insertList(@Param("pojos") List<MqiVal> pojo);

    int update(@Param("pojo") MqiVal pojo);

    List<MqiVal> find();

    List<MqiVal> findGSMQI();

    List<MqiVal> findGDMQI();

    List<MqiVal> findSDMQI();

    List<MqiVal> findMqiList(MqiVal mqiVal);
}
