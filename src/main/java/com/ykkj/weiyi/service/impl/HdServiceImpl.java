package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.ProjectInfoMapper;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoExample;
import com.ykkj.weiyi.service.HdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HdServiceImpl implements HdService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    public List<ProjectInfo> find(String type) {
        return projectInfoMapper.selectByExample(new ProjectInfoExample());
    }
}
