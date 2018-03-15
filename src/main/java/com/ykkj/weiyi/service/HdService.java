package com.ykkj.weiyi.service;

import java.util.List;

import com.ykkj.weiyi.pojo.DirectInfo;
import com.ykkj.weiyi.pojo.DirectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.JdpzInfo;
import com.ykkj.weiyi.pojo.PmsComPactListing;
import com.ykkj.weiyi.pojo.PmsIssueInfo;
import com.ykkj.weiyi.pojo.PmsPlanInputZbWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangMainWithBLOBs;
import com.ykkj.weiyi.pojo.PmsQingdanJiliangWithBLOBs;
import com.ykkj.weiyi.pojo.ProjectInfo;
import com.ykkj.weiyi.pojo.ProjectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SectInfo;
import com.ykkj.weiyi.pojo.SectInfoWithBLOBs;
import com.ykkj.weiyi.pojo.SupervisionInfoWithBLOBs;

public interface HdService
{

    /**
     * 查询项目信息
     * 
     * @param type
     *            接口类型：0 只同步未同步的数据；1 全部同步；
     * @return
     */
    public List<ProjectInfoWithBLOBs> find(String type);

    public ProjectInfoWithBLOBs findProjectInfoWithBLOBsByID(String id);

    /**
     * 插入项目信息数据集合
     * 
     * @param list
     * @return
     */
    public int insert(List<ProjectInfoWithBLOBs> list);

    /**
     * 删除项目信息数据ByID
     * 
     * @param list
     * @return
     */
    public int deleteProjectInfoByID(String id);

    public String findProjectInfoMaxInserttime();

    /**
     * 插入项目信息数据
     * 
     * @param projectInfoWithBLOBs
     * @return
     */
    public int insert(ProjectInfoWithBLOBs projectInfoWithBLOBs);

    /**
     * 查询指挥部信息数据
     * 
     * @param type
     * @return
     */
    public List<DirectInfoWithBLOBs> findDirectInfo(String type);

    /**
     * 插入指挥部信息数据
     * 
     * @param directInfoWithBLOBs
     * @return
     */
    public int insertDirectInfo(DirectInfoWithBLOBs directInfoWithBLOBs);

    /**
     * 获取监理信息数据
     * 
     * @param type
     * @return
     */
    public List<SupervisionInfoWithBLOBs> findSupervisionInfo(String type);

    /**
     * 插入监理信息数据
     * 
     * @param supervisionInfoWithBLOBs
     * @return
     */
    public int insertSupervisionInfo(
            SupervisionInfoWithBLOBs supervisionInfoWithBLOBs);

    /**
     * 获取标段信息数据
     * 
     * @param type
     * @return
     */
    public List<SectInfoWithBLOBs> findSectInfo(String type);

    /**
     * 插入标段信息数据
     * 
     * @param sectInfoWithBLOBs
     * @return
     */
    public int insertSectInfo(SectInfoWithBLOBs sectInfoWithBLOBs);

    public Object findDirectInfoByID(String id);

    public void deleteDirectInfoByID(String id);

    public String findDirectInfoMaxInserttime();

    public String findSupervisionInfoMaxInserttime();

    public void deleteSupervisionInfoByID(String id);

    public String findSectInfoMaxInserttime();

    public void deleteSectInfoByID(String id);

    public void deleteAllProjectInfo();

    public void deleteAllDirectInfo();

    public void deleteAllSupervisionInfo();

    public void deleteAllSectInfo();

    public SupervisionInfoWithBLOBs findSupervisionInfoByID(String id);

    public SectInfoWithBLOBs findSectInfoByID(String id);

    public ProjectInfo findProjectInfoByID(String id);

    public DirectInfo findDirectInfoByProjectId(String id);

    public List<SupervisionInfoWithBLOBs> findSupervisionInfoByProjectId(
            String id);

    public List<SectInfo> findSectInfoByDirectId(String id);

    public void deleteAllPmsIssueInfo();

    public void insertPmsIssueInfo(PmsIssueInfo pii);

    public void deleteAllPmsQingdanJiliangMain();

    public void insertPmsQingdanJiliangMain(
            List<PmsQingdanJiliangMainWithBLOBs> pQJMList);

    public void deleteAllPmsQingdanJiliang();

    public void insertPmsQingdanJiliang(List<PmsQingdanJiliangWithBLOBs> pQJList);

    public void deleteAllPmsComPactListing();

    public void insertPmsComPactListing(List<PmsComPactListing> pCPLList);

    public String findPmsIssueInfoMaxInserttime();

    public Object findPmsIssueInfoById(String id);

    public void deletePmsIssueInfoById(String id);

    public String findPmsQingdanJiliangMainMaxInserttime();

    public Object findPmsQingdanJiliangMainById(String id);

    public void deletePmsQingdanJiliangMainById(String id);

    public String findPmsQingdanJiliangMaxInserttime();

    public Object findPmsQingdanJiliangById(String id);

    public void deletePmsQingdanJiliangById(String id);

    public String findPmsComPactListingMaxInserttime();

    public Object findPmsComPactListingById(String id);

    public void deletePmsComPactListingById(String id);

    public Object findPmsJdpzInfoById(String id);

    public void deleteJdpzInfoById(String id);

    public void insertJdpzInfoList(List<JdpzInfo> jdpzInfo);

    public void deleteAllJdpzInfo();

    public String findJdpzInfoMaxInserttime();

    public void deleteAllPmsPlanInputZbinfo();

    public void insertPmsPlanInputZbList(List<PmsPlanInputZbWithBLOBs> pPIZList);

}
