package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.Weather;

import java.util.List;

public interface WeatherService {

    /**
     * 气象信息查询
     * @param weather
     * @return
     */
    public List<Weather> findAllList(Weather weather);
}
