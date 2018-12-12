package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanYbf;
import com.ykkj.weiyi.pojo.PmsPlanYbfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanYbfMapper {
    int countByExample(PmsPlanYbfExample example);

    int deleteByExample(PmsPlanYbfExample example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanYbf record);

    int insertSelective(PmsPlanYbf record);

    List<PmsPlanYbf> selectByExample(PmsPlanYbfExample example);

    PmsPlanYbf selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanYbf record, @Param("example") PmsPlanYbfExample example);

    int updateByExample(@Param("record") PmsPlanYbf record, @Param("example") PmsPlanYbfExample example);

    int updateByPrimaryKeySelective(PmsPlanYbf record);

    int updateByPrimaryKey(PmsPlanYbf record);
}