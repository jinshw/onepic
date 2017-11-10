package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;

import java.util.List;

public interface HdService {

    /**
     * 查询项目信息
     * @param type 接口类型：0 只同步未同步的数据；1 全部同步；
     * @return
     */
    public List<ProjectInfoWithBLOBs> find(String type);

    /**
     * 插入项目信息数据集合
     * @param list
     * @return
     */
    public int insert(List<ProjectInfoWithBLOBs> list);

    /**
     * 插入项目信息数据
     * @param projectInfoWithBLOBs
     * @return
     */
    public int insert(ProjectInfoWithBLOBs projectInfoWithBLOBs);
}
