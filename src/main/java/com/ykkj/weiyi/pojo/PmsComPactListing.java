package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PmsComPactListing {
    private String id;

    private String sectId;

    private String listingIsbn;

    private String listingParentIsbn;

    private String listingNo;

    private String listingName;

    private String listingUnit;

    private BigDecimal listingAmount;

    private BigDecimal listingAmount2;

    private BigDecimal listingPrice;

    private BigDecimal listingMoney;

    private Long listingLevel;

    private Long hasChild;

    private String propertyA;

    private String propertyB;

    private BigDecimal propertyC;

    private Date insterTime;

    private Date creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSectId() {
        return sectId;
    }

    public void setSectId(String sectId) {
        this.sectId = sectId == null ? null : sectId.trim();
    }

    public String getListingIsbn() {
        return listingIsbn;
    }

    public void setListingIsbn(String listingIsbn) {
        this.listingIsbn = listingIsbn == null ? null : listingIsbn.trim();
    }

    public String getListingParentIsbn() {
        return listingParentIsbn;
    }

    public void setListingParentIsbn(String listingParentIsbn) {
        this.listingParentIsbn = listingParentIsbn == null ? null : listingParentIsbn.trim();
    }

    public String getListingNo() {
        return listingNo;
    }

    public void setListingNo(String listingNo) {
        this.listingNo = listingNo == null ? null : listingNo.trim();
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName == null ? null : listingName.trim();
    }

    public String getListingUnit() {
        return listingUnit;
    }

    public void setListingUnit(String listingUnit) {
        this.listingUnit = listingUnit == null ? null : listingUnit.trim();
    }

    public BigDecimal getListingAmount() {
        return listingAmount;
    }

    public void setListingAmount(BigDecimal listingAmount) {
        this.listingAmount = listingAmount;
    }

    public BigDecimal getListingAmount2() {
        return listingAmount2;
    }

    public void setListingAmount2(BigDecimal listingAmount2) {
        this.listingAmount2 = listingAmount2;
    }

    public BigDecimal getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(BigDecimal listingPrice) {
        this.listingPrice = listingPrice;
    }

    public BigDecimal getListingMoney() {
        return listingMoney;
    }

    public void setListingMoney(BigDecimal listingMoney) {
        this.listingMoney = listingMoney;
    }

    public Long getListingLevel() {
        return listingLevel;
    }

    public void setListingLevel(Long listingLevel) {
        this.listingLevel = listingLevel;
    }

    public Long getHasChild() {
        return hasChild;
    }

    public void setHasChild(Long hasChild) {
        this.hasChild = hasChild;
    }

    public String getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(String propertyA) {
        this.propertyA = propertyA == null ? null : propertyA.trim();
    }

    public String getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(String propertyB) {
        this.propertyB = propertyB == null ? null : propertyB.trim();
    }

    public BigDecimal getPropertyC() {
        return propertyC;
    }

    public void setPropertyC(BigDecimal propertyC) {
        this.propertyC = propertyC;
    }

    public Date getInsterTime() {
        return insterTime;
    }

    public void setInsterTime(Date insterTime) {
        this.insterTime = insterTime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}