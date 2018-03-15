package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.PmsQingdanJiliang;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangExample;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangWithBLOBs;

public interface PmsQingdanJiliangMapper
{
    int countByExample(PmsQingdanJiliangExample example);

    int deleteByExample(PmsQingdanJiliangExample example);

    int deleteByPrimaryKey(String id);

    int insert(PmsQingdanJiliangWithBLOBs record);

    int insertSelective(PmsQingdanJiliangWithBLOBs record);

    List<PmsQingdanJiliangWithBLOBs> selectByExampleWithBLOBs(
            PmsQingdanJiliangExample example);

    List<PmsQingdanJiliang> selectByExample(PmsQingdanJiliangExample example);

    PmsQingdanJiliangWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(
            @Param("record") PmsQingdanJiliangWithBLOBs record,
            @Param("example") PmsQingdanJiliangExample example);

    int updateByExampleWithBLOBs(
            @Param("record") PmsQingdanJiliangWithBLOBs record,
            @Param("example") PmsQingdanJiliangExample example);

    int updateByExample(@Param("record") PmsQingdanJiliang record,
            @Param("example") PmsQingdanJiliangExample example);

    int updateByPrimaryKeySelective(PmsQingdanJiliangWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsQingdanJiliangWithBLOBs record);

    int updateByPrimaryKey(PmsQingdanJiliang record);

    void deleteAll();

    void insertPmsQingdanJiliang(List<PmsQingdanJiliangWithBLOBs> pqj);

    String findPmsQingdanJiliangMaxInserttime();

    Object findPmsQingdanJiliangById(String id);

    void deletePmsQingdanJiliangById();
}