package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.PlotMapper;
import com.ykkj.weiyi.pojo.Plot;
import com.ykkj.weiyi.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlotServiceImpl implements PlotService {

    @Autowired
    private PlotMapper plotMapper;

    public int insertSelective(Plot plot) {
        int dflag = plotMapper.delete(plot);
        return plotMapper.insertSelective(plot);
    }

    public List<Plot> find(Plot plot) {
        return plotMapper.find(plot);
    }

    public int delete(Plot plot){
        return plotMapper.delete(plot);
    }
}
