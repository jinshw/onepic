package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.WeatherMapper;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.TrafficInfo;
import com.ykkj.weiyi.pojo.Weather;
import com.ykkj.weiyi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource("dataSourceMys")
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    public List<Weather> findAllList(Weather weather) {
        return weatherMapper.findAllList(weather);
    }
}
