package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz02;
import com.ykkj.weiyi.pojo.PmsPlanTzkz02Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz02Mapper {
    int countByExample(PmsPlanTzkz02Example example);

    int deleteByExample(PmsPlanTzkz02Example example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanTzkz02 record);

    int insertSelective(PmsPlanTzkz02 record);

    List<PmsPlanTzkz02> selectByExample(PmsPlanTzkz02Example example);

    PmsPlanTzkz02 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz02 record, @Param("example") PmsPlanTzkz02Example example);

    int updateByExample(@Param("record") PmsPlanTzkz02 record, @Param("example") PmsPlanTzkz02Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz02 record);

    int updateByPrimaryKey(PmsPlanTzkz02 record);
}