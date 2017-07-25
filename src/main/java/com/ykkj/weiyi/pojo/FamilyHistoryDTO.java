package com.ykkj.weiyi.pojo;

/**
 * 家族史(PF_FAMILY_HISTORY)
 * 
 * @author bianj
 * @version 1.0.0 2017-03-03
 */
public class FamilyHistoryDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7824535781354708444L;
    
    /** fh_id */
    private String fhId;
    
    /** 个人信息主键ID */
    private String piId;
    
    /** 家族成员名称 */
    private String fhName;
    
    /** 1父亲 2 母亲 3 兄弟姐妹 4 子女 */
    private Integer fhVal;
    
    /** 疾病: 2高血压  3糖尿病  4冠心病  5慢性阻塞性肺疾病  6恶性肿瘤  7脑卒中8重性精神疾病  9结核病  10肝炎  11先天畸形  12其他 */
    private String fhSickness;
    
    /** 填写内容 */
    private String contents;
    
    /**
     * 获取fh_id
     * 
     * @return fh_id
     */
    public String getFhId() {
        return this.fhId;
    }
     
    /**
     * 设置fh_id
     * 
     * @param fhId
     *          fh_id
     */
    public void setFhId(String fhId) {
        this.fhId = fhId;
    }
    
    /**
     * 获取个人信息主键ID
     * 
     * @return 个人信息主键ID
     */
    public String getPiId() {
        return this.piId;
    }
     
    /**
     * 设置个人信息主键ID
     * 
     * @param piId
     *          个人信息主键ID
     */
    public void setPiId(String piId) {
        this.piId = piId;
    }
    
    /**
     * 获取家族成员名称
     * 
     * @return 家族成员名称
     */
    public String getFhName() {
        return this.fhName;
    }
     
    /**
     * 设置家族成员名称
     * 
     * @param fhName
     *          家族成员名称
     */
    public void setFhName(String fhName) {
        this.fhName = fhName;
    }
    
    /**
     * 获取1父亲 2 母亲 3 兄弟姐妹 4 子女
     * 
     * @return 1父亲 2 母亲 3 兄弟姐妹 4 子女
     */
    public Integer getFhVal() {
        return this.fhVal;
    }
     
    /**
     * 设置1父亲 2 母亲 3 兄弟姐妹 4 子女
     * 
     * @param fhVal
     *          1父亲 2 母亲 3 兄弟姐妹 4 子女
     */
    public void setFhVal(Integer fhVal) {
        this.fhVal = fhVal;
    }
    
    /**
     * 获取疾病: 2高血压  3糖尿病  4冠心病  5慢性阻塞性肺疾病  6恶性肿瘤  7脑卒中8重性精神疾病  9结核病  10肝炎  11先天畸形  12其他
     * 
     * @return 疾病
     */
    public String getFhSickness() {
        return this.fhSickness;
    }
     
    /**
     * 设置疾病: 2高血压  3糖尿病  4冠心病  5慢性阻塞性肺疾病  6恶性肿瘤  7脑卒中8重性精神疾病  9结核病  10肝炎  11先天畸形  12其他
     * 
     * @param fhSickness
     *          疾病: 2高血压  3糖尿病  4冠心病  5慢性阻塞性肺疾病  6恶性肿瘤  7脑卒中8重性精神疾病  9结核病  10肝炎  11先天畸形  12其他
     */
    public void setFhSickness(String fhSickness) {
        this.fhSickness = fhSickness;
    }
    
    /**
     * 获取填写内容
     * 
     * @return 填写内容
     */
    public String getContents() {
        return this.contents;
    }
     
    /**
     * 设置填写内容
     * 
     * @param contents
     *          填写内容
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
}