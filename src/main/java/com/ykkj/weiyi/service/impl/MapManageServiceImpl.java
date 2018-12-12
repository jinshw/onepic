package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.MapManageMapper;
import com.ykkj.weiyi.pojo.MapManage;
import com.ykkj.weiyi.service.MapManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapManageServiceImpl implements MapManageService {
    @Autowired
    private MapManageMapper mapManageMapper;

    public List<MapManage> find(MapManage mapManage) {
        return mapManageMapper.find(mapManage);
    }
}
