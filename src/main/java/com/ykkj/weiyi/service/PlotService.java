package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.Plot;

import java.util.List;

public interface PlotService {
    /**
     * 新增标注信息
     * @return
     */
    public int insertSelective(Plot plot);

    /**
     * 查询标注信息
     * @return
     */
    public List<Plot> find(Plot plot);

    /**
     * 删除
     * @param plot
     * @return
     */
    public int delete(Plot plot);

}
