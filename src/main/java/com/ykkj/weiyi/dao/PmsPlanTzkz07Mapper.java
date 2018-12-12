package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz07;
import com.ykkj.weiyi.pojo.PmsPlanTzkz07Example;
import com.ykkj.weiyi.pojo.PmsPlanTzkz07WithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz07Mapper {
    int countByExample(PmsPlanTzkz07Example example);

    int deleteByExample(PmsPlanTzkz07Example example);

    int deleteByPrimaryKey(String id);

    int insert(PmsPlanTzkz07WithBLOBs record);

    int insertSelective(PmsPlanTzkz07WithBLOBs record);

    List<PmsPlanTzkz07WithBLOBs> selectByExampleWithBLOBs(PmsPlanTzkz07Example example);

    List<PmsPlanTzkz07> selectByExample(PmsPlanTzkz07Example example);

    PmsPlanTzkz07WithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz07WithBLOBs record, @Param("example") PmsPlanTzkz07Example example);

    int updateByExampleWithBLOBs(@Param("record") PmsPlanTzkz07WithBLOBs record, @Param("example") PmsPlanTzkz07Example example);

    int updateByExample(@Param("record") PmsPlanTzkz07 record, @Param("example") PmsPlanTzkz07Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz07WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsPlanTzkz07WithBLOBs record);

    int updateByPrimaryKey(PmsPlanTzkz07 record);
}