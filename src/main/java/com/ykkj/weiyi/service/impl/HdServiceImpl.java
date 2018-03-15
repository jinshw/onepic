package com.ykkj.weiyi.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ykkj.weiyi.dao.DirectInfoMapper;
import com.ykkj.weiyi.dao.JdpzInfoMapper;
import com.ykkj.weiyi.dao.PmsComPactListingMapper;
import com.ykkj.weiyi.dao.PmsIssueInfoMapper;
import com.ykkj.weiyi.dao.PmsPlanInputZbMapper;
import com.ykkj.weiyi.dao.PmsQingdanJiliangMainMapper;
import com.ykkj.weiyi.dao.PmsQingdanJiliangMapper;
import com.ykkj.weiyi.dao.ProjectInfoMapper;
import com.ykkj.weiyi.dao.SectInfoMapper;
import com.ykkj.weiyi.dao.SupervisionInfoMapper;
import com.ykkj.weiyi.pojo.DirectInfo;
import com.ykkj.weiyi.pojo.DirectInfoExample;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.JdpzInfo;
import com.ykkj.weiyi.pojo.PmsComPactListing;
import com.ykkj.weiyi.pojo.PmsIssueInfo;
import com.ykkj.weiyi.pojo.PmsPlanInputZbWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangMainWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoExample;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfo;
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

    @Autowired
    private PmsIssueInfoMapper pmsIssueInfoMapper;

    @Autowired
    private PmsQingdanJiliangMainMapper pmsQingdanJiliangMainMapper;

    @Autowired
    private PmsQingdanJiliangMapper pmsQingdanJiliangMapper;

    @Autowired
    private PmsComPactListingMapper pmsComPactListingMapper;

    @Autowired
    private JdpzInfoMapper jdpzInfoMapper;

    @Autowired
    private PmsPlanInputZbMapper pmsPlanInputZbInfoMapper;

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

    @Override
    public DirectInfo findDirectInfoByProjectId(String id)
    {
        // TODO Auto-generated method stub
        return directInfoMapper.findDirectInfoByProjectId(id);
    }

    @Override
    public List<SupervisionInfoWithBLOBs> findSupervisionInfoByProjectId(
            String id)
    {
        // TODO Auto-generated method stub
        return supervisionInfoMapper.findSupervisionInfoByProjectId(id);
    }

    @Override
    public List<SectInfo> findSectInfoByDirectId(String id)
    {
        // TODO Auto-generated method stub
        return sectInfoMapper.findSectInfoByDirectId(id);
    }

    @Override
    public void deleteAllPmsIssueInfo()
    {
        // TODO Auto-generated method stub
        pmsIssueInfoMapper.deleteAll();
    }

    @Override
    public void insertPmsIssueInfo(PmsIssueInfo pii)
    {
        // TODO Auto-generated method stub
        pmsIssueInfoMapper.insert(pii);
    }

    @Override
    public void deleteAllPmsQingdanJiliangMain()
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMainMapper.deleteAll();
    }

    @Override
    public void insertPmsQingdanJiliangMain(
            List<PmsQingdanJiliangMainWithBLOBs> pqjlm)
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMainMapper.insertPmsQingdanJiliangMain(pqjlm);
    }

    @Override
    public void deleteAllPmsQingdanJiliang()
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMapper.deleteAll();
    }

    @Override
    public void insertPmsQingdanJiliang(List<PmsQingdanJiliangWithBLOBs> pqj)
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMapper.insertPmsQingdanJiliang(pqj);
    }

    @Override
    public void deleteAllPmsComPactListing()
    {
        // TODO Auto-generated method stub
        pmsComPactListingMapper.deleteAll();
    }

    @Override
    public void insertPmsComPactListing(List<PmsComPactListing> PCPLList)
    {
        // TODO Auto-generated method stub
        pmsComPactListingMapper.insert(PCPLList);
    }

    @Override
    public String findPmsIssueInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return pmsIssueInfoMapper.findPmsIssueInfoMaxInserttime();
    }

    @Override
    public Object findPmsIssueInfoById(String id)
    {
        // TODO Auto-generated method stub
        return pmsIssueInfoMapper.findPmsIssueInfoById(id);
    }

    @Override
    public void deletePmsIssueInfoById(String id)
    {
        // TODO Auto-generated method stub
        pmsIssueInfoMapper.deletePmsIssueInfoById(id);
    }

    @Override
    public String findPmsQingdanJiliangMainMaxInserttime()
    {
        // TODO Auto-generated method stub
        return pmsQingdanJiliangMainMapper
                .findPmsQingdanJiliangMainMaxInserttime();
    }

    @Override
    public Object findPmsQingdanJiliangMainById(String id)
    {
        // TODO Auto-generated method stub
        return pmsQingdanJiliangMainMapper.findPmsQingdanJiliangMainById(id);
    }

    @Override
    public void deletePmsQingdanJiliangMainById(String id)
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMainMapper.deletePmsQingdanJiliangMainById(id);
    }

    @Override
    public String findPmsQingdanJiliangMaxInserttime()
    {
        // TODO Auto-generated method stub
        return pmsQingdanJiliangMapper.findPmsQingdanJiliangMaxInserttime();
    }

    @Override
    public Object findPmsQingdanJiliangById(String id)
    {
        // TODO Auto-generated method stub
        return pmsQingdanJiliangMapper.findPmsQingdanJiliangById(id);
    }

    @Override
    public void deletePmsQingdanJiliangById(String id)
    {
        // TODO Auto-generated method stub
        pmsQingdanJiliangMapper.deletePmsQingdanJiliangById();
    }

    @Override
    public String findPmsComPactListingMaxInserttime()
    {
        // TODO Auto-generated method stub
        return pmsComPactListingMapper.findPmsComPactListingMaxInserttime();
    }

    @Override
    public Object findPmsComPactListingById(String id)
    {
        // TODO Auto-generated method stub
        return pmsComPactListingMapper.findPmsComPactListingById();
    }

    @Override
    public void deletePmsComPactListingById(String id)
    {
        // TODO Auto-generated method stub
        pmsComPactListingMapper.deletePmsComPactListingById();
    }

    @Override
    public Object findPmsJdpzInfoById(String id)
    {
        // TODO Auto-generated method stub
        return jdpzInfoMapper.findPmsJdpzInfoById(id);
    }

    @Override
    public void deleteJdpzInfoById(String id)
    {
        // TODO Auto-generated method stub
        jdpzInfoMapper.deleteJdpzInfoById(id);
    }

    @Override
    public void insertJdpzInfoList(List<JdpzInfo> jdpzInfo)
    {
        // TODO Auto-generated method stub
        jdpzInfoMapper.insertJdpzInfoList(jdpzInfo);
    }

    @Override
    public void deleteAllJdpzInfo()
    {
        // TODO Auto-generated method stub
        jdpzInfoMapper.deleteAllJdpzInfo();
    }

    @Override
    public String findJdpzInfoMaxInserttime()
    {
        // TODO Auto-generated method stub
        return jdpzInfoMapper.findJdpzInfoMaxInserttime();
    }

    @Override
    public void deleteAllPmsPlanInputZbinfo()
    {
        // TODO Auto-generated method stub
        pmsPlanInputZbInfoMapper.deleteAllPmsPlanInputZbinfo();
    }

    @Override
    public void insertPmsPlanInputZbList(List<PmsPlanInputZbWithBLOBs> pPIZList)
    {
        // TODO Auto-generated method stub
        pmsPlanInputZbInfoMapper.insertPmsPlanInputZbList(pPIZList);
    }
}
