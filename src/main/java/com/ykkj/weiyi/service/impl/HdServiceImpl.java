package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.ProjectInfoMapper;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoExample;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
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

}
