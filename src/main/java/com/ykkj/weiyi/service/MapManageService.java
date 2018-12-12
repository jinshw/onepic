package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.MapManage;
import com.ykkj.weiyi.pojo.OutPatient;
import com.ykkj.weiyi.pojo.OutUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract interface MapManageService {
    public List<MapManage> find(MapManage mapManage);
}
