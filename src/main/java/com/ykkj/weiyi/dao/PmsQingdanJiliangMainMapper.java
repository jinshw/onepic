package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.PmsQingdanJiliangMain;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangMainExample;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangMainWithBLOBs;

public interface PmsQingdanJiliangMainMapper
{
    int countByExample(PmsQingdanJiliangMainExample example);

    int deleteByExample(PmsQingdanJiliangMainExample example);

    int deleteByPrimaryKey(String id);

    int insert(PmsQingdanJiliangMainWithBLOBs record);

    int insertSelective(PmsQingdanJiliangMainWithBLOBs record);

    List<PmsQingdanJiliangMainWithBLOBs> selectByExampleWithBLOBs(
            PmsQingdanJiliangMainExample example);

    List<PmsQingdanJiliangMain> selectByExample(
            PmsQingdanJiliangMainExample example);

    PmsQingdanJiliangMainWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(
            @Param("record") PmsQingdanJiliangMainWithBLOBs record,
            @Param("example") PmsQingdanJiliangMainExample example);

    int updateByExampleWithBLOBs(
            @Param("record") PmsQingdanJiliangMainWithBLOBs record,
            @Param("example") PmsQingdanJiliangMainExample example);

    int updateByExample(@Param("record") PmsQingdanJiliangMain record,
            @Param("example") PmsQingdanJiliangMainExample example);

    int updateByPrimaryKeySelective(PmsQingdanJiliangMainWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsQingdanJiliangMainWithBLOBs record);

    int updateByPrimaryKey(PmsQingdanJiliangMain record);

    void deleteAll();

    void insertPmsQingdanJiliangMain(List<PmsQingdanJiliangMainWithBLOBs> pqjlm);

    String findPmsQingdanJiliangMainMaxInserttime();

    Object findPmsQingdanJiliangMainById(String id);

    void deletePmsQingdanJiliangMainById(String id);

}