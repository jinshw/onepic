package com.ykkj.weiyi.service.impl;

import com.ykkj.weiyi.dao.MQIBeanMapper;
import com.ykkj.weiyi.dao.MqiValMapper;
import com.ykkj.weiyi.pojo.MQIBean;
import com.ykkj.weiyi.pojo.MqiVal;
import com.ykkj.weiyi.service.MQIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MQIServiceImpl implements MQIService {

    @Autowired
    private MQIBeanMapper mqiBeanMapper;
    @Autowired
    private MqiValMapper mqiValMapper;

    public void getGSMQI() {
        List<MqiVal> mqiVals = mqiValMapper.find();
        List gsList = mqiBeanMapper.findGS();
        List<MQIBean> rlist = getMQI(mqiVals, gsList);//获取有MQI的List
        // 更新数据库
        int result = 0;
        for (int i = 0; i < rlist.size(); i++) {
            result = 0;
            result = mqiBeanMapper.updateGS(rlist.get(i));
            if (result == 0) {
                System.out.println(rlist.get(i).getId());
            }
        }
        System.out.println("高速更新完成...");
    }

    private List<MQIBean> getMQI(List mqiVals, List tList) {
        List<MQIBean> rList = new ArrayList<MQIBean>();
        MqiVal mqiVal = null;
        MQIBean mqiBean = null;
        for (int i = 0; i < mqiVals.size(); i++) {
            mqiVal = (MqiVal) mqiVals.get(i);
            for (int j = 0; j < tList.size(); j++) {
                mqiBean = (MQIBean) tList.get(j);
                // 桩号是否在该MQI起止桩号内，存在true 不存在false
                if (isZHForMQI(mqiVal, mqiBean)) {
                    mqiBean.setMqi(mqiVal.getMqi());
                    rList.add(mqiBean);
                }
            }
        }
        return rList;
    }

    public boolean isZHForMQI(MqiVal mqiVal, MQIBean mqiBean) {
        boolean flag = false;
        String tempFX = "";
        switch (mqiBean.getLdlx()) {
            case "1.上行":
                tempFX = "上行";
                break;
            case "2.下行":
                tempFX = "下行";
                break;
            case "3.双向":
                tempFX = "上下行";
                break;
            default:
                break;
        }
        int scale = Integer.parseInt(mqiBean.getScale());
        int qdzh = Integer.parseInt(mqiVal.getQdzh());
        int zdzh = Integer.parseInt(mqiVal.getZdzh());

        if (mqiVal.getCode().trim().equals(mqiBean.getRoadcode().trim())
                && mqiVal.getFx().trim().equals(tempFX)
                && (scale >= qdzh && scale <= zdzh)
                ) {
            flag = true;
        }
        return flag;
    }

    public void getGDMQI() {
        List<MqiVal> mqiVals = mqiValMapper.find();
        List gdList = mqiBeanMapper.findGD();
        List<MQIBean> rlist = getMQI(mqiVals, gdList);//获取有MQI的List
        // 更新数据库
        int result = 0;
        for (int i = 0; i < rlist.size(); i++) {
            result = 0;
            result = mqiBeanMapper.updateGD(rlist.get(i));
            if (result == 0) {
                System.out.println(rlist.get(i).getId());
            }
        }
        System.out.println("国道更新完成...");


    }

    public void getSDMQI() {
        List<MqiVal> mqiVals = mqiValMapper.find();
        List sdList = mqiBeanMapper.findSD();
        List<MQIBean> rlist = getMQI(mqiVals, sdList);//获取有MQI的List
        // 更新数据库
        int result = 0;
        for (int i = 0; i < rlist.size(); i++) {
            result = 0;
            result = mqiBeanMapper.updateSD(rlist.get(i));
            if (result == 0) {
                System.out.println(rlist.get(i).getId());
            }
        }
        System.out.println("省道更新完成...");
    }

    public List<MqiVal> findMqiGS() {
        List list = new ArrayList();
        List templist = null;
        List sxlist = null;
        List<MqiVal> sxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxlistc = new ArrayList<MqiVal>();

        List xxlist = null;
        List<MqiVal> xxlisty = new ArrayList<MqiVal>();
        List<MqiVal> xxlistz = new ArrayList<MqiVal>();
        List<MqiVal> xxlistc = new ArrayList<MqiVal>();

        List sxxlist = null;
        List<MqiVal> sxxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistc = new ArrayList<MqiVal>();

        List<MqiVal> gsList = mqiValMapper.findGSMQI();
        MqiVal mqiVal = null;
        for (int i = 0; i < gsList.size(); i++) {
            mqiVal = (MqiVal) gsList.get(i);
            mqiVal.setFx("上行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxlisty = mqiValMapper.findMqiList(mqiVal);

            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            xxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            xxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            xxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("上下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxxlistc = mqiValMapper.findMqiList(mqiVal);

            sxlist = new ArrayList();
            xxlist = new ArrayList();
            sxxlist = new ArrayList();

            sxlist.add(concatMqiVal(sxlisty));
            sxlist.add(concatMqiVal(sxlistz));
            sxlist.add(concatMqiVal(sxlistc));

            xxlist.add(concatMqiVal(xxlisty));
            xxlist.add(concatMqiVal(xxlistz));
            xxlist.add(concatMqiVal(xxlistc));

            sxxlist.add(concatMqiVal(sxxlisty));
            sxxlist.add(concatMqiVal(sxxlistz));
            sxxlist.add(concatMqiVal(sxxlistc));

            templist = new ArrayList();
            templist.add(sxlist);
            templist.add(xxlist);
            templist.add(sxxlist);
            list.add(templist);
        }

        return list;
    }

    public List<MqiVal> findMqiGD() {
        List list = new ArrayList();
        List templist = null;
        List sxlist = null;
        List<MqiVal> sxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxlistc = new ArrayList<MqiVal>();

        List xxlist = null;
        List<MqiVal> xxlisty = new ArrayList<MqiVal>();
        List<MqiVal> xxlistz = new ArrayList<MqiVal>();
        List<MqiVal> xxlistc = new ArrayList<MqiVal>();

        List sxxlist = null;
        List<MqiVal> sxxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistc = new ArrayList<MqiVal>();

        List<MqiVal> gsList = mqiValMapper.findGDMQI();
        MqiVal mqiVal = null;
        for (int i = 0; i < gsList.size(); i++) {
            mqiVal = (MqiVal) gsList.get(i);
            mqiVal.setFx("上行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxlisty = mqiValMapper.findMqiList(mqiVal);

            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            xxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            xxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            xxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("上下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxxlistc = mqiValMapper.findMqiList(mqiVal);

            sxlist = new ArrayList();
            xxlist = new ArrayList();
            sxxlist = new ArrayList();

            sxlist.add(concatMqiVal(sxlisty));
            sxlist.add(concatMqiVal(sxlistz));
            sxlist.add(concatMqiVal(sxlistc));

            xxlist.add(concatMqiVal(xxlisty));
            xxlist.add(concatMqiVal(xxlistz));
            xxlist.add(concatMqiVal(xxlistc));

            sxxlist.add(concatMqiVal(sxxlisty));
            sxxlist.add(concatMqiVal(sxxlistz));
            sxxlist.add(concatMqiVal(sxxlistc));

            templist = new ArrayList();
            templist.add(sxlist);
            templist.add(xxlist);
            templist.add(sxxlist);
            list.add(templist);
        }

        return list;
    }

    public List<MqiVal> findMqiSD() {
        List list = new ArrayList();
        List templist = null;
        List sxlist = null;
        List<MqiVal> sxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxlistc = new ArrayList<MqiVal>();

        List xxlist = null;
        List<MqiVal> xxlisty = new ArrayList<MqiVal>();
        List<MqiVal> xxlistz = new ArrayList<MqiVal>();
        List<MqiVal> xxlistc = new ArrayList<MqiVal>();

        List sxxlist = null;
        List<MqiVal> sxxlisty = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistz = new ArrayList<MqiVal>();
        List<MqiVal> sxxlistc = new ArrayList<MqiVal>();

        List<MqiVal> gsList = mqiValMapper.findSDMQI();
        MqiVal mqiVal = null;
        for (int i = 0; i < gsList.size(); i++) {
            mqiVal = (MqiVal) gsList.get(i);
            mqiVal.setFx("上行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxlisty = mqiValMapper.findMqiList(mqiVal);

            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            xxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            xxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            xxlistc = mqiValMapper.findMqiList(mqiVal);


            mqiVal.setFx("上下行");
            mqiVal.setMinVal((double) 80);
            mqiVal.setMaxVal((double) 100);
            sxxlisty = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 70);
            mqiVal.setMaxVal((double) 80);
            sxxlistz = mqiValMapper.findMqiList(mqiVal);
            mqiVal.setMinVal((double) 0);
            mqiVal.setMaxVal((double) 70);
            sxxlistc = mqiValMapper.findMqiList(mqiVal);

            sxlist = new ArrayList();
            xxlist = new ArrayList();
            sxxlist = new ArrayList();

            sxlist.add(concatMqiVal(sxlisty));
            sxlist.add(concatMqiVal(sxlistz));
            sxlist.add(concatMqiVal(sxlistc));

            xxlist.add(concatMqiVal(xxlisty));
            xxlist.add(concatMqiVal(xxlistz));
            xxlist.add(concatMqiVal(xxlistc));

            sxxlist.add(concatMqiVal(sxxlisty));
            sxxlist.add(concatMqiVal(sxxlistz));
            sxxlist.add(concatMqiVal(sxxlistc));

            templist = new ArrayList();
            templist.add(sxlist);
            templist.add(xxlist);
            templist.add(sxxlist);
            list.add(templist);
        }

        return list;
    }

    public List<MqiVal> concatMqiVal(List<MqiVal> list) {
        List<MqiVal> rlist = new ArrayList<MqiVal>();
        if (list.size() > 1) {
            MqiVal preMqiVal = list.get(0);
            MqiVal mqiVal = null;
            MqiVal tempMqiVal = null;
            for (int i = 1; i < list.size(); i++) {
                mqiVal = list.get(i);
                if (preMqiVal.getZdzh().equals(mqiVal.getQdzh())) {// 上一个的终点桩号，与当前的起点桩号相等(说明连个线段是连续的)
                    preMqiVal.setZdzh(mqiVal.getZdzh());
                    if (i == (list.size() - 1)) {
                        rlist.add(preMqiVal);
                    }
                } else {
                    tempMqiVal = new MqiVal();
                    tempMqiVal.setQdzh(preMqiVal.getQdzh());
                    tempMqiVal.setZdzh(preMqiVal.getZdzh());
                    rlist.add(tempMqiVal);
                    if (i == (list.size() - 1)) {
                        rlist.add(mqiVal);
                    }
//                    rlist.add(mqiVal);
                    preMqiVal.setQdzh(mqiVal.getQdzh());
                    preMqiVal.setZdzh(mqiVal.getZdzh());
                }
            }
        } else {
            rlist = list;
        }
        return rlist;
    }

    public List<MqiVal> find(){
        List<MqiVal> mqiVals = mqiValMapper.find();
        return mqiVals;
    }

}
