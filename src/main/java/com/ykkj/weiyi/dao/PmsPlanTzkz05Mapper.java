package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz05;
import com.ykkj.weiyi.pojo.PmsPlanTzkz05Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz05Mapper {
    int countByExample(PmsPlanTzkz05Example example);

    int deleteByExample(PmsPlanTzkz05Example example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsPlanTzkz05 record);

    int insertSelective(PmsPlanTzkz05 record);

    List<PmsPlanTzkz05> selectByExample(PmsPlanTzkz05Example example);

    PmsPlanTzkz05 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz05 record, @Param("example") PmsPlanTzkz05Example example);

    int updateByExample(@Param("record") PmsPlanTzkz05 record, @Param("example") PmsPlanTzkz05Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz05 record);

    int updateByPrimaryKey(PmsPlanTzkz05 record);
}