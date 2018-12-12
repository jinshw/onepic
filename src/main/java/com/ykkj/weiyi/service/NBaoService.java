package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.NBaoBean;

import java.util.List;

public interface NBaoService {

    public List findList(NBaoBean nBaoBean);

    public List<String> findRoadcode();
}
