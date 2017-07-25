package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class VerIsonApp {
private String fileId;
private String fileName;
private String filePath;
private String versionNo;
private int fileType;	
private int fileSize;	
private Timestamp createTime;
private int appType;
public String getFileId() {
	return fileId;
}
public void setFileId(String fileId) {
	this.fileId = fileId;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFilePath() {
	return filePath;
}
public void setFilePath(String filePath) {
	this.filePath = filePath;
}
public String getVersionNo() {
	return versionNo;
}
public void setVersionNo(String versionNo) {
	this.versionNo = versionNo;
}
public int getFileType() {
	return fileType;
}
public void setFileType(int fileType) {
	this.fileType = fileType;
}
public int getFileSize() {
	return fileSize;
}
public void setFileSize(int fileSize) {
	this.fileSize = fileSize;
}
public Timestamp getCreateTime() {
	return createTime;
}
public void setCreateTime(Timestamp createTime) {
	this.createTime = createTime;
}
public int getAppType() {
	return appType;
}
public void setAppType(int appType) {
	this.appType = appType;
}

}
