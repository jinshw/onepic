package com.ykkj.weiyi.pojo;

public class Symptom {
    private String symptomId;

    private String symptomName;

    private String symptomCode;
    
    private String symptomRange;

    public String getSymptomId() {
        return symptomId;
    }


	public void setSymptomId(String symptomId) {
        this.symptomId = symptomId == null ? null : symptomId.trim();
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName == null ? null : symptomName.trim();
    }

    public String getSymptomCode() {
        return symptomCode;
    }

    public void setSymptomCode(String symptomCode) {
        this.symptomCode = symptomCode == null ? null : symptomCode.trim();
    }

	public String getSymptomRange() {
		return symptomRange;
	}

	public void setSymptomRange(String symptomRange) {
		this.symptomRange = symptomRange;
	}
    
}