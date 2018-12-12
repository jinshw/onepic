package com.ykkj.weiyi.service;

import com.ykkj.weiyi.pojo.MqiVal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MQIService {

    public void getGSMQI();

    public void getGDMQI();

    public void getSDMQI();

    public List<MqiVal> findMqiGS();

    public List<MqiVal> findMqiGD();

    public List<MqiVal> findMqiSD();

    public List<MqiVal> find();
}
