package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.PmsIssueInfo;
import com.ykkj.weiyi.pojo.PmsIssueInfoExample;

public interface PmsIssueInfoMapper
{
    int countByExample(PmsIssueInfoExample example);

    int deleteByExample(PmsIssueInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PmsIssueInfo record);

    int insertSelective(PmsIssueInfo record);

    List<PmsIssueInfo> selectByExampleWithBLOBs(PmsIssueInfoExample example);

    List<PmsIssueInfo> selectByExample(PmsIssueInfoExample example);

    PmsIssueInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsIssueInfo record,
            @Param("example") PmsIssueInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsIssueInfo record,
            @Param("example") PmsIssueInfoExample example);

    int updateByExample(@Param("record") PmsIssueInfo record,
            @Param("example") PmsIssueInfoExample example);

    int updateByPrimaryKeySelective(PmsIssueInfo record);

    int updateByPrimaryKeyWithBLOBs(PmsIssueInfo record);

    int updateByPrimaryKey(PmsIssueInfo record);

    void deleteAll();

    String findPmsIssueInfoMaxInserttime();

    Object findPmsIssueInfoById(String id);

    void deletePmsIssueInfoById(String id);
}