package com.ykkj.weiyi.pojo;

public class PmsPlanTzkz07WithBLOBs extends PmsPlanTzkz07 {
    private String xxjdsm;

    private String problem;

    private String solveProblem;

    private String measuer;

    public String getXxjdsm() {
        return xxjdsm;
    }

    public void setXxjdsm(String xxjdsm) {
        this.xxjdsm = xxjdsm == null ? null : xxjdsm.trim();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getSolveProblem() {
        return solveProblem;
    }

    public void setSolveProblem(String solveProblem) {
        this.solveProblem = solveProblem == null ? null : solveProblem.trim();
    }

    public String getMeasuer() {
        return measuer;
    }

    public void setMeasuer(String measuer) {
        this.measuer = measuer == null ? null : measuer.trim();
    }
}