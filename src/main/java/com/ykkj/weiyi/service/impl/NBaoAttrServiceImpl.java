package com.ykkj.weiyi.service.impl;

import cn.hutool.core.io.file.FileReader;
import com.ykkj.weiyi.dao.NBaoAttrBridgeDao;
import com.ykkj.weiyi.dao.NBaoAttrDao;
import com.ykkj.weiyi.dao.NBaoAttrSuiDaoDao;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.*;
import com.ykkj.weiyi.service.NBaoAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@DataSource("dataSourceOrcODS")
public class NBaoAttrServiceImpl implements NBaoAttrService {

    @Autowired
    NBaoAttrDao nBaoAttrDao;
    @Autowired
    NBaoAttrBridgeDao nBaoAttrBridgeDao;
    @Autowired
    NBaoAttrSuiDaoDao nBaoAttrSuiDaoDao;

    public List<String> getAttributeField(String searchType) {
        String fileName = "";
        if (searchType.equals("road")) {
            fileName = "nbaofield.json";
        } else if (searchType.equals("bridge")) {
            fileName = "bridgefield.json";
        } else {
            fileName = "suidaofield.json";
        }
        List<String> list = new ArrayList();
        FileReader fileReader = new FileReader(fileName);
        list = fileReader.readLines();
        return list;
    }

    public List findList(NBaoAttr nBaoAttr) {
        return nBaoAttrDao.findList(nBaoAttr);
    }

    public String queryLenght(NBaoAttr nBaoAttr) {
        return nBaoAttrDao.queryLenght(nBaoAttr);
    }

    public String findRoadNUM(NBaoRoadJSDJNUM pojo) {
        return nBaoAttrDao.findRoadNUM(pojo);
    }

    public Integer findBirdgeNUM(NBaoBirdgeNUM pojo) {
        return nBaoAttrDao.findBirdgeNUM(pojo);
    }

    public Integer findSmallBirdgeNUM(NBaoSmallBridgeNUM pojo) {
        return nBaoAttrDao.findSmallBridgeNUM(pojo);
    }

    public Integer findSuiDaoNUM(NBaoSuiDaoNUM pojo) {
        return nBaoAttrDao.findSuiDaoNUM(pojo);
    }

    public List findBridgeList(NBaoAttrBridge nBaoAttrBridge) {
        return nBaoAttrBridgeDao.findList(nBaoAttrBridge);
    }

    public List findSuiDaoList(NBaoAttrSuiDao nBaoAttrSuiDao) {
        System.out.println("NBaoAttrSuiDao service...");
        return nBaoAttrSuiDaoDao.findList(nBaoAttrSuiDao);
    }
}
