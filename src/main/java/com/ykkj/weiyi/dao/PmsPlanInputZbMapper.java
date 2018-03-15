package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.PmsPlanInputZb;
import com.ykkj.weiyi.pojo.PmsPlanInputZbExample;
import com.ykkj.weiyi.pojo.PmsPlanInputZbWithBLOBs;

public interface PmsPlanInputZbMapper
{
    int countByExample(PmsPlanInputZbExample example);

    int deleteByExample(PmsPlanInputZbExample example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanInputZbWithBLOBs record);

    int insertSelective(PmsPlanInputZbWithBLOBs record);

    List<PmsPlanInputZbWithBLOBs> selectByExampleWithBLOBs(
            PmsPlanInputZbExample example);

    List<PmsPlanInputZb> selectByExample(PmsPlanInputZbExample example);

    PmsPlanInputZbWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(
            @Param("record") PmsPlanInputZbWithBLOBs record,
            @Param("example") PmsPlanInputZbExample example);

    int updateByExampleWithBLOBs(
            @Param("record") PmsPlanInputZbWithBLOBs record,
            @Param("example") PmsPlanInputZbExample example);

    int updateByExample(@Param("record") PmsPlanInputZb record,
            @Param("example") PmsPlanInputZbExample example);

    int updateByPrimaryKeySelective(PmsPlanInputZbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsPlanInputZbWithBLOBs record);

    int updateByPrimaryKey(PmsPlanInputZb record);

    void deleteAllPmsPlanInputZbinfo();

    void insertPmsPlanInputZbList(List<PmsPlanInputZbWithBLOBs> pPIZList);
}