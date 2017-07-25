package com.ykkj.weiyi.pojo;

public class Attachment {
    private String amtId;

    private String amtName;

    private Integer amtSize;

    private Integer amtType;

    private String fileType;

    private String filePath;

    private String relationId;

    public String getAmtId() {
        return amtId;
    }

    public void setAmtId(String amtId) {
        this.amtId = amtId == null ? null : amtId.trim();
    }

    public String getAmtName() {
        return amtName;
    }

    public void setAmtName(String amtName) {
        this.amtName = amtName == null ? null : amtName.trim();
    }

    public Integer getAmtSize() {
        return amtSize;
    }

    public void setAmtSize(Integer amtSize) {
        this.amtSize = amtSize;
    }

    public Integer getAmtType() {
        return amtType;
    }

    public void setAmtType(Integer amtType) {
        this.amtType = amtType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }
}