package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.*;

import java.util.List;

public interface NBaoAttrService {

    /**
     * 获取年报属性字段接口
     *
     * @return
     */
    public List<String> getAttributeField();

    /**
     * 查询所有道路属性
     *
     * @return
     */
    public List findList(NBaoAttr nBaoAttr);

    /**
     * 查询道路总长度
     *
     * @param nBaoAttr
     * @return
     */
    public String queryLenght(NBaoAttr nBaoAttr);

    public String findRoadNUM(NBaoRoadJSDJNUM pojo);

    public Integer findBirdgeNUM(NBaoBirdgeNUM pojo);

    public Integer findSuiDaoNUM(NBaoSuiDaoNUM pojo);

    public Integer findSmallBirdgeNUM(NBaoSmallBridgeNUM pojo);

}
