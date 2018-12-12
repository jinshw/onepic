package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz06;
import com.ykkj.weiyi.pojo.PmsPlanTzkz06Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz06Mapper {
    int countByExample(PmsPlanTzkz06Example example);

    int deleteByExample(PmsPlanTzkz06Example example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanTzkz06 record);

    int insertSelective(PmsPlanTzkz06 record);

    List<PmsPlanTzkz06> selectByExample(PmsPlanTzkz06Example example);

    PmsPlanTzkz06 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz06 record, @Param("example") PmsPlanTzkz06Example example);

    int updateByExample(@Param("record") PmsPlanTzkz06 record, @Param("example") PmsPlanTzkz06Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz06 record);

    int updateByPrimaryKey(PmsPlanTzkz06 record);
}