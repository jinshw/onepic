package com.ykkj.weiyi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ykkj.weiyi.pojo.Roud;
import com.ykkj.weiyi.dao.RoudDao;

@Service
public class RoudService{

    @Resource
    private RoudDao roudDao;

    public int insert(Roud pojo){
        return roudDao.insert(pojo);
    }

    public int insertSelective(Roud pojo){
        return roudDao.insertSelective(pojo);
    }

    public int insertList(List<Roud> pojos){
        return roudDao.insertList(pojos);
    }

    public int update(Roud pojo){
        return roudDao.update(pojo);
    }

    public List<Roud> find(Roud roud){
        return roudDao.find(roud);
    }
}
