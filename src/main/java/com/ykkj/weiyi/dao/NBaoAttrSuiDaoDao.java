package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.NBaoAttrBridge;
import com.ykkj.weiyi.pojo.NBaoAttrSuiDao;

import java.util.List;

@DataSource("dataSourceOrcODS")
public interface NBaoAttrSuiDaoDao {
    List<NBaoAttrSuiDao> findList(NBaoAttrSuiDao nBaoAttrSuiDao);
}
