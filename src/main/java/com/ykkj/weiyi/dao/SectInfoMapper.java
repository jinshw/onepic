package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.SectInfo;
import com.ykkj.weiyi.pojo.SectInfoExample;
import com.ykkj.weiyi.pojo.SectInfoWithBLOBs;

public interface SectInfoMapper
{
    int countByExample(SectInfoExample example);

    int deleteByExample(SectInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SectInfoWithBLOBs record);

    int insertSelective(SectInfoWithBLOBs record);

    List<SectInfoWithBLOBs> selectByExampleWithBLOBs(SectInfoExample example);

    List<SectInfo> selectByExample(SectInfoExample example);

    SectInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SectInfoWithBLOBs record,
            @Param("example") SectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SectInfoWithBLOBs record,
            @Param("example") SectInfoExample example);

    int updateByExample(@Param("record") SectInfo record,
            @Param("example") SectInfoExample example);

    int updateByPrimaryKeySelective(SectInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SectInfoWithBLOBs record);

    int updateByPrimaryKey(SectInfo record);

    String findSectInfoMaxInserttime();

    void deleteAll();

    List<SectInfo> findSectInfoByDirectId(String id);
}