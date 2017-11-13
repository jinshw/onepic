package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.*;

import java.util.List;

public interface HdService {

    /**
     * 查询项目信息
     * @param type 接口类型：0 只同步未同步的数据；1 全部同步；
     * @return
     */
    public List<ProjectInfoWithBLOBs> find(String type);

    /**
     * 插入项目信息数据集合
     * @param list
     * @return
     */
    public int insert(List<ProjectInfoWithBLOBs> list);

    /**
     * 插入项目信息数据
     * @param projectInfoWithBLOBs
     * @return
     */
    public int insert(ProjectInfoWithBLOBs projectInfoWithBLOBs);

    /**
     * 查询指挥部信息数据
     * @param type
     * @return
     */
    public List<DirectInfoWithBLOBs> findDirectInfo(String type);

    /**
     * 插入指挥部信息数据
     * @param directInfoWithBLOBs
     * @return
     */
    public int insertDirectInfo(DirectInfoWithBLOBs directInfoWithBLOBs);

    /**
     * 获取监理信息数据
     * @param type
     * @return
     */
    public List<SupervisionInfoWithBLOBs> findSupervisionInfo(String type);

    /**
     * 插入监理信息数据
     * @param supervisionInfoWithBLOBs
     * @return
     */
    public int insertSupervisionInfo(SupervisionInfoWithBLOBs supervisionInfoWithBLOBs);

    /**
     * 获取标段信息数据
     * @param type
     * @return
     */
    public List<SectInfoWithBLOBs> findSectInfo(String type);

    /**
     * 插入标段信息数据
     * @param sectInfoWithBLOBs
     * @return
     */
    public int insertSectInfo(SectInfoWithBLOBs sectInfoWithBLOBs);

}
