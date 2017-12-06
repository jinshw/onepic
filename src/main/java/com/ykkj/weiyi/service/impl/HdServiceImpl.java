package com.ykkj.weiyi.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ykkj.weiyi.dao.DirectInfoMapper;
import com.ykkj.weiyi.dao.ProjectInfoMapper;
import com.ykkj.weiyi.dao.SectInfoMapper;
import com.ykkj.weiyi.dao.SupervisionInfoMapper;
import com.ykkj.weiyi.pojo.DirectInfoExample;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoExample;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfoExample;
import com.ykkj.weiyi.pojo.SectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SupervisionInfoExample;
import com.ykkj.weiyi.pojo.SupervisionInfoWithBLOBs;
import com.ykkj.weiyi.service.HdService;

@Service
public class HdServiceImpl implements HdService
{
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private DirectInfoMapper directInfoMapper;

    @Autowired
    private SupervisionInfoMapper supervisionInfoMapper;

    @Autowired
    private SectInfoMapper sectInfoMapper;

    public List<ProjectInfoWithBLOBs> find(String type)
    {
        return projectInfoMapper
                .selectByExampleWithBLOBs(new ProjectInfoExample());
    }

    public ProjectInfoWithBLOBs findProjectInfoWithBLOBsByID(String id)
    {
        return projectInfoMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int insert(List<ProjectInfoWithBLOBs> list)
    {
        Iterator<ProjectInfoWithBLOBs> iterator = list.iterator();
        ProjectInfoWithBLOBs projectInfoWithBLOBs = null;
        int result = 0;
        while (iterator.hasNext())
        {
            projectInfoWithBLOBs = iterator.next();
            // 临时改变id值
            projectInfoWithBLOBs.setId(Math.random() * 10 + "");
            projectInfoWithBLOBs.setCreatetime(new Timestamp(new Date()
                    .getTime()));
            projectInfoMapper.insert(projectInfoWithBLOBs);
        }
        return result;
    }

    public int insert(ProjectInfoWithBLOBs projectInfoWithBLOBs)
    {
        return projectInfoMapper.insertSelective(projectInfoWithBLOBs);
    }

    public List<DirectInfoWithBLOBs> findDirectInfo(String type)
    {
        return directInfoMapper
                .selectByExampleWithBLOBs(new DirectInfoExample());
    }

    public int insertDirectInfo(DirectInfoWithBLOBs directInfoWithBLOBs)
    {
        return directInfoMapper.insert(directInfoWithBLOBs);
    }

    public List<SupervisionInfoWithBLOBs> findSupervisionInfo(String type)
    {
        return supervisionInfoMapper
                .selectByExampleWithBLOBs(new SupervisionInfoExample());
    }

    public int insertSupervisionInfo(
            SupervisionInfoWithBLOBs supervisionInfoWithBLOBs)
    {
        return supervisionInfoMapper.insert(supervisionInfoWithBLOBs);
    }

    public List<SectInfoWithBLOBs> findSectInfo(String type)
    {
        return sectInfoMapper.selectByExampleWithBLOBs(new SectInfoExample());
    }

    public int insertSectInfo(SectInfoWithBLOBs sectInfoWithBLOBs)
    {
        return sectInfoMapper.insert(sectInfoWithBLOBs);
    }

    @Override
    public int deleteProjectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        return projectInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String findProjectInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return projectInfoMapper.findProjectInfoMaxInserttime();
    }

    @Override
    public Object findDirectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        return directInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteDirectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        directInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String findDirectInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return directInfoMapper.findDirectInfoMaxInserttime();
    }

    @Override
    public String findSupervisionInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return supervisionInfoMapper.findSupervisionInfoMaxInserttime();
    }

    @Override
    public void deleteSupervisionInfoByID(String id)
    {
        // TODO Auto-generated method stub
        supervisionInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String findSectInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return sectInfoMapper.findSectInfoMaxInserttime();
    }

    @Override
    public void deleteSectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        sectInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAllProjectInfo()
    {
        // TODO Auto-generated method stub
        projectInfoMapper.deleteAll();
    }

    @Override
    public void deleteAllDirectInfo()
    {
        // TODO Auto-generated method stub
        directInfoMapper.deleteAll();
    }

    @Override
    public void deleteAllSupervisionInfo()
    {
        // TODO Auto-generated method stub
        supervisionInfoMapper.deleteAll();
    }

    @Override
    public void deleteAllSectInfo()
    {
        // TODO Auto-generated method stub
        sectInfoMapper.deleteAll();
    }

    @Override
    public SupervisionInfoWithBLOBs findSupervisionInfoByID(String id)
    {
        // TODO Auto-generated method stub
        return supervisionInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public SectInfoWithBLOBs findSectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        return sectInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProjectInfo findProjectInfoByID(String id)
    {
        // TODO Auto-generated method stub
        return projectInfoMapper.findProjectInfoByID(id);
    }

}
