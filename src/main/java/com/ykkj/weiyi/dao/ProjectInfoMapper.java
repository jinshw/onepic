package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoExample;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInfoMapper {
    int countByExample(ProjectInfoExample example);

    int deleteByExample(ProjectInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectInfoWithBLOBs record);

    int insertSelective(ProjectInfoWithBLOBs record);

    List<ProjectInfoWithBLOBs> selectByExampleWithBLOBs(ProjectInfoExample example);

    List<ProjectInfo> selectByExample(ProjectInfoExample example);

    ProjectInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectInfoWithBLOBs record, @Param("example") ProjectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectInfoWithBLOBs record, @Param("example") ProjectInfoExample example);

    int updateByExample(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);

    int updateByPrimaryKeySelective(ProjectInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectInfoWithBLOBs record);

    int updateByPrimaryKey(ProjectInfo record);

}