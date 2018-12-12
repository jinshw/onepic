package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.RoadZd;

import java.util.List;

public interface RoadZdService {

    /**
     * 查询标注信息
     * @return
     */
    public RoadZd selectByPrimaryKey(String id);
    /**
     * 查询标注信息
     * @return
     */
    public List<RoadZd> findByTypeCode();

}
