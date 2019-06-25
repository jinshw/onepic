package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.List;

public class TrafficHistoryInfo {
    public String niLinkID;
    public String niLinkLength;

    public String startDateStr;
    public String endDateStr;

    public List<TrafficHistoryInfo> list = new ArrayList<>();
    public List<String> idList = new ArrayList<>();
    public List<String> lengthList = new ArrayList<>();


    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public List<String> getLengthList() {
        return lengthList;
    }

    public void setLengthList(List<String> lengthList) {
        this.lengthList = lengthList;
    }

    public String getNiLinkID() {
        return niLinkID;
    }

    public void setNiLinkID(String niLinkID) {
        this.niLinkID = niLinkID;
    }

    public String getNiLinkLength() {
        return niLinkLength;
    }

    public void setNiLinkLength(String niLinkLength) {
        this.niLinkLength = niLinkLength;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public List<TrafficHistoryInfo> getList() {
        return list;
    }

    public void setList(List<TrafficHistoryInfo> list) {
        this.list = list;
    }
}
