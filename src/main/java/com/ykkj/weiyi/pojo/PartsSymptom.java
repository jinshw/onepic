package com.ykkj.weiyi.pojo;

public class PartsSymptom {
    private String partId;

    private String symptomId;

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId == null ? null : partId.trim();
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId == null ? null : symptomId.trim();
    }
}