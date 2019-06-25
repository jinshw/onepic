package com.ykkj.weiyi.dao;

import java.util.List;

import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.*;

@DataSource("dataSourceOrcODS")
public interface NBaoAttrDao {
    List<NBaoAttr> findList(NBaoAttr nBaoAttr);

    String queryLenght(NBaoAttr nBaoAttr);

    String findRoadNUM(NBaoRoadJSDJNUM pojo);

    String findRoadNUMGS(NBaoRoadJSDJNUM pojo);

    Integer findBirdgeNUM(NBaoBirdgeNUM pojo);

    Integer findSuiDaoNUM(NBaoSuiDaoNUM pojo);

    Integer findSmallBridgeNUM(NBaoSmallBridgeNUM pojp);
}
