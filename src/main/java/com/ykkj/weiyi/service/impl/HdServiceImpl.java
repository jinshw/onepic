package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.DirectInfoMapper;
import com.ykkj.weiyi.dao.ProjectInfoMapper;
import com.ykkj.weiyi.dao.SectInfoMapper;
import com.ykkj.weiyi.dao.SupervisionInfoMapper;
import com.ykkj.weiyi.pojo.*;
import com.ykkj.weiyi.service.HdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class HdServiceImpl implements HdService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private DirectInfoMapper directInfoMapper;

    @Autowired
    private SupervisionInfoMapper supervisionInfoMapper;

    @Autowired
    private SectInfoMapper sectInfoMapper;

    public List<ProjectInfoWithBLOBs> find(String type) {
        return projectInfoMapper.selectByExampleWithBLOBs(new ProjectInfoExample());
    }

    @Transactional
    public int insert(List<ProjectInfoWithBLOBs> list) {
        Iterator<ProjectInfoWithBLOBs> iterator = list.iterator();
        ProjectInfoWithBLOBs projectInfoWithBLOBs = null;
        int result = 0;
        while (iterator.hasNext()) {
            projectInfoWithBLOBs = iterator.next();
            // 临时改变id值
            projectInfoWithBLOBs.setId(Math.random() * 10 + "");
            projectInfoWithBLOBs.setCreatetime(new Date());
            projectInfoMapper.insert(projectInfoWithBLOBs);
        }
        return result;
    }

    public int insert(ProjectInfoWithBLOBs projectInfoWithBLOBs) {
        return projectInfoMapper.insert(projectInfoWithBLOBs);
    }

    public List<DirectInfoWithBLOBs> findDirectInfo(String type) {
        return directInfoMapper.selectByExampleWithBLOBs(new DirectInfoExample());
    }

    public int insertDirectInfo(DirectInfoWithBLOBs directInfoWithBLOBs) {
        return directInfoMapper.insert(directInfoWithBLOBs);
    }

    public List<SupervisionInfoWithBLOBs> findSupervisionInfo(String type) {
        return supervisionInfoMapper.selectByExampleWithBLOBs(new SupervisionInfoExample());
    }

    public int insertSupervisionInfo(SupervisionInfoWithBLOBs supervisionInfoWithBLOBs) {
        return supervisionInfoMapper.insert(supervisionInfoWithBLOBs);
    }

    public List<SectInfoWithBLOBs> findSectInfo(String type) {
        return sectInfoMapper.selectByExampleWithBLOBs(new SectInfoExample());
    }

    public int insertSectInfo(SectInfoWithBLOBs sectInfoWithBLOBs) {
        return sectInfoMapper.insert(sectInfoWithBLOBs);
    }
}
