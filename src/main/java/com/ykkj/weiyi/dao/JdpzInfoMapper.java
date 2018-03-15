package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.JdpzInfo;
import com.ykkj.weiyi.pojo.JdpzInfoExample;

public interface JdpzInfoMapper
{
    int countByExample(JdpzInfoExample example);

    int deleteByExample(JdpzInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(JdpzInfo record);

    int insertSelective(JdpzInfo record);

    List<JdpzInfo> selectByExampleWithBLOBs(JdpzInfoExample example);

    List<JdpzInfo> selectByExample(JdpzInfoExample example);

    JdpzInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JdpzInfo record,
            @Param("example") JdpzInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") JdpzInfo record,
            @Param("example") JdpzInfoExample example);

    int updateByExample(@Param("record") JdpzInfo record,
            @Param("example") JdpzInfoExample example);

    int updateByPrimaryKeySelective(JdpzInfo record);

    int updateByPrimaryKeyWithBLOBs(JdpzInfo record);

    int updateByPrimaryKey(JdpzInfo record);

    Object findPmsJdpzInfoById(String id);

    Object deleteJdpzInfoById(String id);

    void insertJdpzInfoList(List<JdpzInfo> jdpzInfo);

    void deleteAllJdpzInfo();

    String findJdpzInfoMaxInserttime();

}