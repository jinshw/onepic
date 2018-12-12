package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.NBaoBeanMapper;
import com.ykkj.weiyi.pojo.NBaoBean;
import com.ykkj.weiyi.service.NBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NBaoServiceImpl implements NBaoService {
    @Autowired
    NBaoBeanMapper nBaoBeanMapper;

    public List findList(NBaoBean nBaoBean) {
        return nBaoBeanMapper.findList(nBaoBean);
    }

    public List<String> findRoadcode(){
        return nBaoBeanMapper.findRoadcode();
    }
}
