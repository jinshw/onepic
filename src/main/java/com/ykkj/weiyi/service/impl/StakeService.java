package com.ykkj.weiyi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.ykkj.weiyi.pojo.Stake;
import com.ykkj.weiyi.dao.StakeDao;

@Service
public class StakeService{

    @Resource
    private StakeDao stakeDao;

    public int insert(Stake pojo){
        return stakeDao.insert(pojo);
    }

    public int insertSelective(Stake pojo){
        return stakeDao.insertSelective(pojo);
    }

    public int insertList(List<Stake> pojos){
        return stakeDao.insertList(pojos);
    }

    public int update(Stake pojo){
        return stakeDao.update(pojo);
    }
    public List<Stake> queryStakeByLocation(Map map){
        return stakeDao.queryStakeByLocation(map);
    }
}
