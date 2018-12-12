package com.ykkj.weiyi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ykkj.weiyi.pojo.MQIBean;

public interface MQIBeanMapper {
    int insert(@Param("pojo") MQIBean pojo);

    int insertSelective(@Param("pojo") MQIBean pojo);

    int insertList(@Param("pojos") List<MQIBean> pojo);

    int updateGS(MQIBean pojo);

    int updateGD(MQIBean pojo);

    int updateSD(MQIBean pojo);

    List<MQIBean> findGS();

    List<MQIBean> findGD();

    List<MQIBean> findSD();

}
