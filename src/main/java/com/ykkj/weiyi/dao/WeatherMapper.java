package com.ykkj.weiyi.dao;

import com.ykkj.weiyi.pojo.TrafficInfo;
import com.ykkj.weiyi.pojo.Weather;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WeatherMapper {
    public List<Weather> findAllList(Weather weather);
}