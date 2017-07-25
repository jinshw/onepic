package com.ykkj.weiyi.pojo;

import java.util.Date;

public class NumResult {
    private String resultId;

    private String id;

    private String rtId;

    private Date resultDate;

    private Integer isStop;

    private String numMonth;

    private Integer numCount;

    private Integer numOverCount;

    private String startTime;

    private String endTime;

    private Integer numType;
    
    private String dateStr;
    
    private Integer offset;
    
    private String departId;
    
    private String otId;
    
    private String departName;
    
    private String otName;
    
    private String numName;
    
    private String classTypeId;
    
    
    


	@Override
	public String toString() {
		return "NumResult [resultId=" + resultId + ", id=" + id + ", rtId="
				+ rtId + ", resultDate=" + resultDate + ", isStop=" + isStop
				+ ", numMonth=" + numMonth + ", numCount=" + numCount
				+ ", numOverCount=" + numOverCount + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", numType=" + numType
				+ ", dateStr=" + dateStr + ", offset=" + offset + ", departId="
				+ departId + ", otId=" + otId + ", departName=" + departName
				+ ", otName=" + otName + ", numName=" + numName
				+ ", classTypeId=" + classTypeId + "]";
	}

	public String getClassTypeId() {
		return classTypeId;
	}

	public void setClassTypeId(String classTypeId) {
		this.classTypeId = classTypeId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getOtName() {
		return otName;
	}

	public void setOtName(String otName) {
		this.otName = otName;
	}

	public String getNumName() {
		return numName;
	}

	public void setNumName(String numName) {
		this.numName = numName;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId == null ? null : rtId.trim();
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }

    public String getNumMonth() {
        return numMonth;
    }

    public void setNumMonth(String numMonth) {
        this.numMonth = numMonth == null ? null : numMonth.trim();
    }

    public Integer getNumCount() {
        return numCount;
    }

    public void setNumCount(Integer numCount) {
        this.numCount = numCount;
    }

    public Integer getNumOverCount() {
        return numOverCount;
    }

    public void setNumOverCount(Integer numOverCount) {
        this.numOverCount = numOverCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getNumType() {
        return numType;
    }

    public void setNumType(Integer numType) {
        this.numType = numType;
    }
}