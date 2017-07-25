package com.ykkj.weiyi.common;


import com.ykkj.weiyi.pojo.PFServiceInterface;

import java.util.Map;

/**
 * 系统初始化数据方法
 * Created by Administrator on 2016/8/24 0024.
 */
public class SysInitInfo {
    public static Map PF_SERVICE_INFO = null;

    public SysInitInfo(Map map) {
        PF_SERVICE_INFO = map;
    }

    public static void setPfServiceInfo(Map map) {
        PF_SERVICE_INFO = map;
    }

    /**
     * 根据医院ID获取接口服务信息
     * @param hospId
     * @return
     */
    public static PFServiceInterface getPfServiceInfo(String hospId) {
        PFServiceInterface pfServiceInterface = null;
        Map map = SysInitInfo.PF_SERVICE_INFO;
        if (map == null) {
            pfServiceInterface = new PFServiceInterface();
        }else{
            pfServiceInterface = (PFServiceInterface) map.get(hospId);
        }
        return pfServiceInterface;
    }
}
