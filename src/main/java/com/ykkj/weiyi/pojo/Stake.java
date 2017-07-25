package com.ykkj.weiyi.pojo;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class Stake {
    //主键ID
    private String stakeId;
    // 线路名称
    private String stakeName = "";
    // 线路类型：SD(省道) GD（国道） GS（高速）
    private String stakeType = "";
    //桩序号
    private Integer stakeNum;
    //桩号（单位米）
    private Double stakeLength;
    // 经度
    private Double lon;
    // 纬度
    private Double lat;

    /**
     * Getter for property 'stakeId'.
     *
     * @return Value for property 'stakeId'.
     */
    public String getStakeId() {
        return stakeId;
    }

    /**
     * Setter for property 'stakeId'.
     *
     * @param stakeId Value to set for property 'stakeId'.
     */
    public void setStakeId(String stakeId) {
        this.stakeId = stakeId;
    }

    /**
     * Getter for property 'stakeName'.
     *
     * @return Value for property 'stakeName'.
     */
    public String getStakeName() {
        return stakeName;
    }

    /**
     * Setter for property 'stakeName'.
     *
     * @param stakeName Value to set for property 'stakeName'.
     */
    public void setStakeName(String stakeName) {
        this.stakeName = stakeName;
    }

    /**
     * Getter for property 'stakeType'.
     *
     * @return Value for property 'stakeType'.
     */
    public String getStakeType() {
        return stakeType;
    }

    /**
     * Setter for property 'stakeType'.
     *
     * @param stakeType Value to set for property 'stakeType'.
     */
    public void setStakeType(String stakeType) {
        this.stakeType = stakeType;
    }

    /**
     * Getter for property 'stakeNum'.
     *
     * @return Value for property 'stakeNum'.
     */
    public Integer getStakeNum() {
        return stakeNum;
    }

    /**
     * Setter for property 'stakeNum'.
     *
     * @param stakeNum Value to set for property 'stakeNum'.
     */
    public void setStakeNum(Integer stakeNum) {
        this.stakeNum = stakeNum;
    }

    /**
     * Getter for property 'stakeLength'.
     *
     * @return Value for property 'stakeLength'.
     */
    public Double getStakeLength() {
        return stakeLength;
    }

    /**
     * Setter for property 'stakeLength'.
     *
     * @param stakeLength Value to set for property 'stakeLength'.
     */
    public void setStakeLength(Double stakeLength) {
        this.stakeLength = stakeLength;
    }

    /**
     * Getter for property 'lon'.
     *
     * @return Value for property 'lon'.
     */
    public Double getLon() {
        return lon;
    }

    /**
     * Setter for property 'lon'.
     *
     * @param lon Value to set for property 'lon'.
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * Getter for property 'lat'.
     *
     * @return Value for property 'lat'.
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Setter for property 'lat'.
     *
     * @param lat Value to set for property 'lat'.
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }
}
