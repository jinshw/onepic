package com.ykkj.weiyi.service.impl;

import cn.hutool.core.io.file.FileReader;
import com.ykkj.weiyi.dao.NBaoAttrDao;
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
    public List<String> getAttributeField(){
        List<String> list = new ArrayList();
        FileReader fileReader = new FileReader("nbaofield.json");
        list = fileReader.readLines();
        return list;
    }

    public List findList(NBaoAttr nBaoAttr){
        return nBaoAttrDao.findList(nBaoAttr);
    }

    public String queryLenght(NBaoAttr nBaoAttr){
        return nBaoAttrDao.queryLenght(nBaoAttr);
    }

    public String findRoadNUM(NBaoRoadJSDJNUM pojo){
        return nBaoAttrDao.findRoadNUM(pojo);
    }

    public Integer findBirdgeNUM(NBaoBirdgeNUM pojo){
        return nBaoAttrDao.findBirdgeNUM(pojo);
    }
    public Integer findSmallBirdgeNUM(NBaoSmallBridgeNUM pojo){
        return nBaoAttrDao.findSmallBridgeNUM(pojo);
    }

    public Integer findSuiDaoNUM(NBaoSuiDaoNUM pojo){
        return nBaoAttrDao.findSuiDaoNUM(pojo);
    }
}
