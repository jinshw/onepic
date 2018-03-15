package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.DirectInfo;
import com.ykkj.weiyi.pojo.DirectInfoExample;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;

public interface DirectInfoMapper
{
    int countByExample(DirectInfoExample example);

    int deleteByExample(DirectInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(DirectInfoWithBLOBs record);

    int insertSelective(DirectInfoWithBLOBs record);

    List<DirectInfoWithBLOBs> selectByExampleWithBLOBs(DirectInfoExample example);

    List<DirectInfo> selectByExample(DirectInfoExample example);

    DirectInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DirectInfoWithBLOBs record,
            @Param("example") DirectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") DirectInfoWithBLOBs record,
            @Param("example") DirectInfoExample example);

    int updateByExample(@Param("record") DirectInfo record,
            @Param("example") DirectInfoExample example);

    int updateByPrimaryKeySelective(DirectInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DirectInfoWithBLOBs record);

    int updateByPrimaryKey(DirectInfo record);

    String findDirectInfoMaxInserttime();

    void deleteAll();

    DirectInfo findDirectInfoByProjectId(String id);
}