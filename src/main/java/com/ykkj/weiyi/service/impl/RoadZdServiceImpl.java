package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.RoadZdMapper;
import com.ykkj.weiyi.datasource.DataSource;
import com.ykkj.weiyi.pojo.RoadZd;
import com.ykkj.weiyi.service.RoadZdService;
import com.ykkj.weiyi.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@DataSource("dataSourceOrc")
public class RoadZdServiceImpl implements RoadZdService {

    @Autowired
    private RoadZdMapper roadZdMapper;
    public RoadZd selectByPrimaryKey(String id) {
        return roadZdMapper.selectByPrimaryKey(id);
    }

    public List<RoadZd> findByTypeCode() {
        SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sysDateTime =DateUtils.date2Str(time_sdf);
        return roadZdMapper.findByTypeCode(sysDateTime);
    }

}
