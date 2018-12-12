package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.PmsPlanTzkz04;
import com.ykkj.weiyi.pojo.PmsPlanTzkz04Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPlanTzkz04Mapper {
    int countByExample(PmsPlanTzkz04Example example);

    int deleteByExample(PmsPlanTzkz04Example example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsPlanTzkz04 record);

    int insertSelective(PmsPlanTzkz04 record);

    List<PmsPlanTzkz04> selectByExample(PmsPlanTzkz04Example example);

    PmsPlanTzkz04 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsPlanTzkz04 record, @Param("example") PmsPlanTzkz04Example example);

    int updateByExample(@Param("record") PmsPlanTzkz04 record, @Param("example") PmsPlanTzkz04Example example);

    int updateByPrimaryKeySelective(PmsPlanTzkz04 record);

    int updateByPrimaryKey(PmsPlanTzkz04 record);
}