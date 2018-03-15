package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz03;
import com.ykkj.weiyi.pojo.PmsPlanTzkz03Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz03Mapper {
    int countByExample(PmsPlanTzkz03Example example);

    int deleteByExample(PmsPlanTzkz03Example example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanTzkz03 record);

    int insertSelective(PmsPlanTzkz03 record);

    List<PmsPlanTzkz03> selectByExample(PmsPlanTzkz03Example example);

    PmsPlanTzkz03 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz03 record, @Param("example") PmsPlanTzkz03Example example);

    int updateByExample(@Param("record") PmsPlanTzkz03 record, @Param("example") PmsPlanTzkz03Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz03 record);

    int updateByPrimaryKey(PmsPlanTzkz03 record);
}