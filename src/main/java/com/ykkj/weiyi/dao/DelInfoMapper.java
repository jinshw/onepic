package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.DelInfo;
import com.ykkj.weiyi.pojo.DelInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DelInfoMapper {
    int countByExample(DelInfoExample example);

    int deleteByExample(DelInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(DelInfo record);

    int insertSelective(DelInfo record);

    List<DelInfo> selectByExample(DelInfoExample example);

    DelInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DelInfo record, @Param("example") DelInfoExample example);

    int updateByExample(@Param("record") DelInfo record, @Param("example") DelInfoExample example);

    int updateByPrimaryKeySelective(DelInfo record);

    int updateByPrimaryKey(DelInfo record);
}