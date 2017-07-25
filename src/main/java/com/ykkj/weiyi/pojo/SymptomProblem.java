package com.ykkj.weiyi.pojo;

public class SymptomProblem {
    private String symptomId;

    private String problemId;

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId == null ? null : symptomId.trim();
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId == null ? null : problemId.trim();
    }
}