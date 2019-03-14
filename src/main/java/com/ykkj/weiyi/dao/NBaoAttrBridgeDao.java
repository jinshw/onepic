package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.*;

import java.util.List;

@DataSource("dataSourceOrcODS")
public interface NBaoAttrBridgeDao {
    List<NBaoAttrBridge> findList(NBaoAttrBridge nBaoAttrBridge);
}
