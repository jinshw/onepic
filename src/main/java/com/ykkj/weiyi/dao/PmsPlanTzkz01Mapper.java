package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz01;
import com.ykkj.weiyi.pojo.PmsPlanTzkz01Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz01Mapper {
    int countByExample(PmsPlanTzkz01Example example);

    int deleteByExample(PmsPlanTzkz01Example example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanTzkz01 record);

    int insertSelective(PmsPlanTzkz01 record);

    List<PmsPlanTzkz01> selectByExample(PmsPlanTzkz01Example example);

    PmsPlanTzkz01 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz01 record, @Param("example") PmsPlanTzkz01Example example);

    int updateByExample(@Param("record") PmsPlanTzkz01 record, @Param("example") PmsPlanTzkz01Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz01 record);

    int updateByPrimaryKey(PmsPlanTzkz01 record);
}