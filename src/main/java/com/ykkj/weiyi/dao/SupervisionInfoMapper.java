package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.SupervisionInfo;
import com.ykkj.weiyi.pojo.SupervisionInfoExample;
import com.ykkj.weiyi.pojo.SupervisionInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupervisionInfoMapper {
    int countByExample(SupervisionInfoExample example);

    int deleteByExample(SupervisionInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SupervisionInfoWithBLOBs record);

    int insertSelective(SupervisionInfoWithBLOBs record);

    List<SupervisionInfoWithBLOBs> selectByExampleWithBLOBs(SupervisionInfoExample example);

    List<SupervisionInfo> selectByExample(SupervisionInfoExample example);

    SupervisionInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SupervisionInfoWithBLOBs record, @Param("example") SupervisionInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SupervisionInfoWithBLOBs record, @Param("example") SupervisionInfoExample example);

    int updateByExample(@Param("record") SupervisionInfo record, @Param("example") SupervisionInfoExample example);

    int updateByPrimaryKeySelective(SupervisionInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SupervisionInfoWithBLOBs record);

    int updateByPrimaryKey(SupervisionInfo record);
}