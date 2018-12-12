package com.ykkj.weiyi.pojo;

import java.sql.Time;

public class MapManage {
    private String id;
    //图层名称
    private String layerName;
    // 访问IP
    private String ip;
    // 访问端口号
    private String port;
    //访问路径
    private String uri;
    //服务类型:map,data
    private String serviceType;
    // 地图类型：1 矢量 2 影像
    private Integer mapType;
    //地图有效时间点
    private String effectiveDatetime;
    //  编码
    private String code;
    // 组名
    private String groupName;
    // 是否删除
    private Integer isDelete;

    private Integer orders;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getMapType() {
        return mapType;
    }

    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    public String getEffectiveDatetime() {
        return effectiveDatetime;
    }

    public void setEffectiveDatetime(String effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
