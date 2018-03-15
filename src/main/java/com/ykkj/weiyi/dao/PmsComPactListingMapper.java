package com.ykkj.weiyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ykkj.weiyi.pojo.PmsComPactListing;
import com.ykkj.weiyi.pojo.PmsComPactListingExample;

public interface PmsComPactListingMapper
{
    int countByExample(PmsComPactListingExample example);

    int deleteByExample(PmsComPactListingExample example);

    int deleteByPrimaryKey(String id);

    int insert(List<PmsComPactListing> list);

    int insertSelective(PmsComPactListing record);

    List<PmsComPactListing> selectByExample(PmsComPactListingExample example);

    PmsComPactListing selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsComPactListing record,
            @Param("example") PmsComPactListingExample example);

    int updateByExample(@Param("record") PmsComPactListing record,
            @Param("example") PmsComPactListingExample example);

    int updateByPrimaryKeySelective(PmsComPactListing record);

    int updateByPrimaryKey(PmsComPactListing record);

    void deleteAll();

    String findPmsComPactListingMaxInserttime();

    Object findPmsComPactListingById();

    void deletePmsComPactListingById();
}