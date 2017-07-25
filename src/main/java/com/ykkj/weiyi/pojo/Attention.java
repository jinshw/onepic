package com.ykkj.weiyi.pojo;

import java.sql.Timestamp;

public class Attention {
	    //关注表的唯一键ID
	    private String id;
	    //是否关注
	    private Integer flag;
        //关注id
		private String followId;
		 //员工唯一键id
		private String docId;
		//员工名字
		private String docName;
		//擅长
		private String docGoods;
		//员工职称
		private String docTitle;
		//科室名称
		private String departId;
		
		private String hisDepartId;
		
		private String departName;
		
		private String emplooyeeLogo;
		
		//医院ID
		private String hospId;
		//医院名称
		private String hospName;
		//关注时间
		private Timestamp followTime;
		
		public String getEmplooyeeLogo() {
			return emplooyeeLogo;
		}
		public void setEmplooyeeLogo(String emplooyeeLogo) {
			this.emplooyeeLogo = emplooyeeLogo;
		}
		public String getDepartId() {
			return departId;
		}
		public void setDepartId(String departId) {
			this.departId = departId;
		}
		public String getHisDepartId() {
			return hisDepartId;
		}
		public void setHisDepartId(String hisDepartId) {
			this.hisDepartId = hisDepartId;
		}
		public String getHospId() {
			return hospId;
		}
		public void setHospId(String hospId) {
			this.hospId = hospId;
		}
		public String getFollowId() {
			return followId;
		}
		public void setFollowId(String followId) {
			this.followId = followId;
		}
		public String getDocName() {
			return docName;
		}
		public void setDocName(String docName) {
			this.docName = docName;
		}
		public String getDocTitle() {
			return docTitle;
		}
		public void setDocTitle(String docTitle) {
			this.docTitle = docTitle;
		}
		public String getDepartName() {
			return departName;
		}
		public void setDepartName(String departName) {
			this.departName = departName;
		}
		public String getHospName() {
			return hospName;
		}
		public void setHospName(String hospName) {
			this.hospName = hospName;
		}
		public String getDocGoods() {
			return docGoods;
		}
		public void setDocGoods(String docGoods) {
			this.docGoods = docGoods;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Timestamp getFollowTime() {
			return followTime;
		}
		public void setFollowTime(Timestamp followTime) {
			this.followTime = followTime;
		}
		public String getDocId() {
			return docId;
		}
		public void setDocId(String docId) {
			this.docId = docId;
		}
		

}
