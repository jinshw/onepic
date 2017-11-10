package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.ProjectInfo;

import java.util.List;

public interface HdService {

    /**
     * 查询项目信息
     * @param type 接口类型：0 只同步未同步的数据；1 全部同步；
     * @return
     */
    public List<ProjectInfo> find(String type);
}
