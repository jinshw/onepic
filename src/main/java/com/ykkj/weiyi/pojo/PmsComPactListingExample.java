package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsComPactListingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsComPactListingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSectIdIsNull() {
            addCriterion("sect_id is null");
            return (Criteria) this;
        }

        public Criteria andSectIdIsNotNull() {
            addCriterion("sect_id is not null");
            return (Criteria) this;
        }

        public Criteria andSectIdEqualTo(String value) {
            addCriterion("sect_id =", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdNotEqualTo(String value) {
            addCriterion("sect_id <>", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdGreaterThan(String value) {
            addCriterion("sect_id >", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdGreaterThanOrEqualTo(String value) {
            addCriterion("sect_id >=", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdLessThan(String value) {
            addCriterion("sect_id <", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdLessThanOrEqualTo(String value) {
            addCriterion("sect_id <=", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdLike(String value) {
            addCriterion("sect_id like", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdNotLike(String value) {
            addCriterion("sect_id not like", value, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdIn(List<String> values) {
            addCriterion("sect_id in", values, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdNotIn(List<String> values) {
            addCriterion("sect_id not in", values, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdBetween(String value1, String value2) {
            addCriterion("sect_id between", value1, value2, "sectId");
            return (Criteria) this;
        }

        public Criteria andSectIdNotBetween(String value1, String value2) {
            addCriterion("sect_id not between", value1, value2, "sectId");
            return (Criteria) this;
        }

        public Criteria andListingIsbnIsNull() {
            addCriterion("listing_isbn is null");
            return (Criteria) this;
        }

        public Criteria andListingIsbnIsNotNull() {
            addCriterion("listing_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andListingIsbnEqualTo(String value) {
            addCriterion("listing_isbn =", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnNotEqualTo(String value) {
            addCriterion("listing_isbn <>", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnGreaterThan(String value) {
            addCriterion("listing_isbn >", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("listing_isbn >=", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnLessThan(String value) {
            addCriterion("listing_isbn <", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnLessThanOrEqualTo(String value) {
            addCriterion("listing_isbn <=", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnLike(String value) {
            addCriterion("listing_isbn like", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnNotLike(String value) {
            addCriterion("listing_isbn not like", value, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnIn(List<String> values) {
            addCriterion("listing_isbn in", values, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnNotIn(List<String> values) {
            addCriterion("listing_isbn not in", values, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnBetween(String value1, String value2) {
            addCriterion("listing_isbn between", value1, value2, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingIsbnNotBetween(String value1, String value2) {
            addCriterion("listing_isbn not between", value1, value2, "listingIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnIsNull() {
            addCriterion("listing_parent_isbn is null");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnIsNotNull() {
            addCriterion("listing_parent_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnEqualTo(String value) {
            addCriterion("listing_parent_isbn =", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnNotEqualTo(String value) {
            addCriterion("listing_parent_isbn <>", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnGreaterThan(String value) {
            addCriterion("listing_parent_isbn >", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("listing_parent_isbn >=", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnLessThan(String value) {
            addCriterion("listing_parent_isbn <", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnLessThanOrEqualTo(String value) {
            addCriterion("listing_parent_isbn <=", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnLike(String value) {
            addCriterion("listing_parent_isbn like", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnNotLike(String value) {
            addCriterion("listing_parent_isbn not like", value, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnIn(List<String> values) {
            addCriterion("listing_parent_isbn in", values, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnNotIn(List<String> values) {
            addCriterion("listing_parent_isbn not in", values, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnBetween(String value1, String value2) {
            addCriterion("listing_parent_isbn between", value1, value2, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingParentIsbnNotBetween(String value1, String value2) {
            addCriterion("listing_parent_isbn not between", value1, value2, "listingParentIsbn");
            return (Criteria) this;
        }

        public Criteria andListingNoIsNull() {
            addCriterion("listing_no is null");
            return (Criteria) this;
        }

        public Criteria andListingNoIsNotNull() {
            addCriterion("listing_no is not null");
            return (Criteria) this;
        }

        public Criteria andListingNoEqualTo(String value) {
            addCriterion("listing_no =", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotEqualTo(String value) {
            addCriterion("listing_no <>", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoGreaterThan(String value) {
            addCriterion("listing_no >", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoGreaterThanOrEqualTo(String value) {
            addCriterion("listing_no >=", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLessThan(String value) {
            addCriterion("listing_no <", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLessThanOrEqualTo(String value) {
            addCriterion("listing_no <=", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLike(String value) {
            addCriterion("listing_no like", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotLike(String value) {
            addCriterion("listing_no not like", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoIn(List<String> values) {
            addCriterion("listing_no in", values, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotIn(List<String> values) {
            addCriterion("listing_no not in", values, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoBetween(String value1, String value2) {
            addCriterion("listing_no between", value1, value2, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotBetween(String value1, String value2) {
            addCriterion("listing_no not between", value1, value2, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNameIsNull() {
            addCriterion("listing_name is null");
            return (Criteria) this;
        }

        public Criteria andListingNameIsNotNull() {
            addCriterion("listing_name is not null");
            return (Criteria) this;
        }

        public Criteria andListingNameEqualTo(String value) {
            addCriterion("listing_name =", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameNotEqualTo(String value) {
            addCriterion("listing_name <>", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameGreaterThan(String value) {
            addCriterion("listing_name >", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameGreaterThanOrEqualTo(String value) {
            addCriterion("listing_name >=", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameLessThan(String value) {
            addCriterion("listing_name <", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameLessThanOrEqualTo(String value) {
            addCriterion("listing_name <=", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameLike(String value) {
            addCriterion("listing_name like", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameNotLike(String value) {
            addCriterion("listing_name not like", value, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameIn(List<String> values) {
            addCriterion("listing_name in", values, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameNotIn(List<String> values) {
            addCriterion("listing_name not in", values, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameBetween(String value1, String value2) {
            addCriterion("listing_name between", value1, value2, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingNameNotBetween(String value1, String value2) {
            addCriterion("listing_name not between", value1, value2, "listingName");
            return (Criteria) this;
        }

        public Criteria andListingUnitIsNull() {
            addCriterion("listing_unit is null");
            return (Criteria) this;
        }

        public Criteria andListingUnitIsNotNull() {
            addCriterion("listing_unit is not null");
            return (Criteria) this;
        }

        public Criteria andListingUnitEqualTo(String value) {
            addCriterion("listing_unit =", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitNotEqualTo(String value) {
            addCriterion("listing_unit <>", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitGreaterThan(String value) {
            addCriterion("listing_unit >", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitGreaterThanOrEqualTo(String value) {
            addCriterion("listing_unit >=", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitLessThan(String value) {
            addCriterion("listing_unit <", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitLessThanOrEqualTo(String value) {
            addCriterion("listing_unit <=", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitLike(String value) {
            addCriterion("listing_unit like", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitNotLike(String value) {
            addCriterion("listing_unit not like", value, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitIn(List<String> values) {
            addCriterion("listing_unit in", values, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitNotIn(List<String> values) {
            addCriterion("listing_unit not in", values, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitBetween(String value1, String value2) {
            addCriterion("listing_unit between", value1, value2, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingUnitNotBetween(String value1, String value2) {
            addCriterion("listing_unit not between", value1, value2, "listingUnit");
            return (Criteria) this;
        }

        public Criteria andListingAmountIsNull() {
            addCriterion("listing_amount is null");
            return (Criteria) this;
        }

        public Criteria andListingAmountIsNotNull() {
            addCriterion("listing_amount is not null");
            return (Criteria) this;
        }

        public Criteria andListingAmountEqualTo(BigDecimal value) {
            addCriterion("listing_amount =", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountNotEqualTo(BigDecimal value) {
            addCriterion("listing_amount <>", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountGreaterThan(BigDecimal value) {
            addCriterion("listing_amount >", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_amount >=", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountLessThan(BigDecimal value) {
            addCriterion("listing_amount <", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_amount <=", value, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountIn(List<BigDecimal> values) {
            addCriterion("listing_amount in", values, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountNotIn(List<BigDecimal> values) {
            addCriterion("listing_amount not in", values, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_amount between", value1, value2, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_amount not between", value1, value2, "listingAmount");
            return (Criteria) this;
        }

        public Criteria andListingAmount2IsNull() {
            addCriterion("listing_amount2 is null");
            return (Criteria) this;
        }

        public Criteria andListingAmount2IsNotNull() {
            addCriterion("listing_amount2 is not null");
            return (Criteria) this;
        }

        public Criteria andListingAmount2EqualTo(BigDecimal value) {
            addCriterion("listing_amount2 =", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2NotEqualTo(BigDecimal value) {
            addCriterion("listing_amount2 <>", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2GreaterThan(BigDecimal value) {
            addCriterion("listing_amount2 >", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_amount2 >=", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2LessThan(BigDecimal value) {
            addCriterion("listing_amount2 <", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_amount2 <=", value, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2In(List<BigDecimal> values) {
            addCriterion("listing_amount2 in", values, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2NotIn(List<BigDecimal> values) {
            addCriterion("listing_amount2 not in", values, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_amount2 between", value1, value2, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingAmount2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_amount2 not between", value1, value2, "listingAmount2");
            return (Criteria) this;
        }

        public Criteria andListingPriceIsNull() {
            addCriterion("listing_price is null");
            return (Criteria) this;
        }

        public Criteria andListingPriceIsNotNull() {
            addCriterion("listing_price is not null");
            return (Criteria) this;
        }

        public Criteria andListingPriceEqualTo(BigDecimal value) {
            addCriterion("listing_price =", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceNotEqualTo(BigDecimal value) {
            addCriterion("listing_price <>", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceGreaterThan(BigDecimal value) {
            addCriterion("listing_price >", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_price >=", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceLessThan(BigDecimal value) {
            addCriterion("listing_price <", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_price <=", value, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceIn(List<BigDecimal> values) {
            addCriterion("listing_price in", values, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceNotIn(List<BigDecimal> values) {
            addCriterion("listing_price not in", values, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_price between", value1, value2, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_price not between", value1, value2, "listingPrice");
            return (Criteria) this;
        }

        public Criteria andListingMoneyIsNull() {
            addCriterion("listing_money is null");
            return (Criteria) this;
        }

        public Criteria andListingMoneyIsNotNull() {
            addCriterion("listing_money is not null");
            return (Criteria) this;
        }

        public Criteria andListingMoneyEqualTo(BigDecimal value) {
            addCriterion("listing_money =", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyNotEqualTo(BigDecimal value) {
            addCriterion("listing_money <>", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyGreaterThan(BigDecimal value) {
            addCriterion("listing_money >", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_money >=", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyLessThan(BigDecimal value) {
            addCriterion("listing_money <", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("listing_money <=", value, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyIn(List<BigDecimal> values) {
            addCriterion("listing_money in", values, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyNotIn(List<BigDecimal> values) {
            addCriterion("listing_money not in", values, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_money between", value1, value2, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("listing_money not between", value1, value2, "listingMoney");
            return (Criteria) this;
        }

        public Criteria andListingLevelIsNull() {
            addCriterion("listing_level is null");
            return (Criteria) this;
        }

        public Criteria andListingLevelIsNotNull() {
            addCriterion("listing_level is not null");
            return (Criteria) this;
        }

        public Criteria andListingLevelEqualTo(Long value) {
            addCriterion("listing_level =", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelNotEqualTo(Long value) {
            addCriterion("listing_level <>", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelGreaterThan(Long value) {
            addCriterion("listing_level >", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelGreaterThanOrEqualTo(Long value) {
            addCriterion("listing_level >=", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelLessThan(Long value) {
            addCriterion("listing_level <", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelLessThanOrEqualTo(Long value) {
            addCriterion("listing_level <=", value, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelIn(List<Long> values) {
            addCriterion("listing_level in", values, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelNotIn(List<Long> values) {
            addCriterion("listing_level not in", values, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelBetween(Long value1, Long value2) {
            addCriterion("listing_level between", value1, value2, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andListingLevelNotBetween(Long value1, Long value2) {
            addCriterion("listing_level not between", value1, value2, "listingLevel");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNull() {
            addCriterion("has_child is null");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNotNull() {
            addCriterion("has_child is not null");
            return (Criteria) this;
        }

        public Criteria andHasChildEqualTo(Long value) {
            addCriterion("has_child =", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotEqualTo(Long value) {
            addCriterion("has_child <>", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThan(Long value) {
            addCriterion("has_child >", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThanOrEqualTo(Long value) {
            addCriterion("has_child >=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThan(Long value) {
            addCriterion("has_child <", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThanOrEqualTo(Long value) {
            addCriterion("has_child <=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildIn(List<Long> values) {
            addCriterion("has_child in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotIn(List<Long> values) {
            addCriterion("has_child not in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildBetween(Long value1, Long value2) {
            addCriterion("has_child between", value1, value2, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotBetween(Long value1, Long value2) {
            addCriterion("has_child not between", value1, value2, "hasChild");
            return (Criteria) this;
        }

        public Criteria andPropertyAIsNull() {
            addCriterion("property_a is null");
            return (Criteria) this;
        }

        public Criteria andPropertyAIsNotNull() {
            addCriterion("property_a is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyAEqualTo(String value) {
            addCriterion("property_a =", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotEqualTo(String value) {
            addCriterion("property_a <>", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThan(String value) {
            addCriterion("property_a >", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThanOrEqualTo(String value) {
            addCriterion("property_a >=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThan(String value) {
            addCriterion("property_a <", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThanOrEqualTo(String value) {
            addCriterion("property_a <=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALike(String value) {
            addCriterion("property_a like", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotLike(String value) {
            addCriterion("property_a not like", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAIn(List<String> values) {
            addCriterion("property_a in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotIn(List<String> values) {
            addCriterion("property_a not in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyABetween(String value1, String value2) {
            addCriterion("property_a between", value1, value2, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotBetween(String value1, String value2) {
            addCriterion("property_a not between", value1, value2, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyBIsNull() {
            addCriterion("property_b is null");
            return (Criteria) this;
        }

        public Criteria andPropertyBIsNotNull() {
            addCriterion("property_b is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyBEqualTo(String value) {
            addCriterion("property_b =", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBNotEqualTo(String value) {
            addCriterion("property_b <>", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBGreaterThan(String value) {
            addCriterion("property_b >", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBGreaterThanOrEqualTo(String value) {
            addCriterion("property_b >=", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBLessThan(String value) {
            addCriterion("property_b <", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBLessThanOrEqualTo(String value) {
            addCriterion("property_b <=", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBLike(String value) {
            addCriterion("property_b like", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBNotLike(String value) {
            addCriterion("property_b not like", value, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBIn(List<String> values) {
            addCriterion("property_b in", values, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBNotIn(List<String> values) {
            addCriterion("property_b not in", values, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBBetween(String value1, String value2) {
            addCriterion("property_b between", value1, value2, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyBNotBetween(String value1, String value2) {
            addCriterion("property_b not between", value1, value2, "propertyB");
            return (Criteria) this;
        }

        public Criteria andPropertyCIsNull() {
            addCriterion("property_c is null");
            return (Criteria) this;
        }

        public Criteria andPropertyCIsNotNull() {
            addCriterion("property_c is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyCEqualTo(BigDecimal value) {
            addCriterion("property_c =", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotEqualTo(BigDecimal value) {
            addCriterion("property_c <>", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCGreaterThan(BigDecimal value) {
            addCriterion("property_c >", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("property_c >=", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCLessThan(BigDecimal value) {
            addCriterion("property_c <", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCLessThanOrEqualTo(BigDecimal value) {
            addCriterion("property_c <=", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCIn(List<BigDecimal> values) {
            addCriterion("property_c in", values, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotIn(List<BigDecimal> values) {
            addCriterion("property_c not in", values, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("property_c between", value1, value2, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("property_c not between", value1, value2, "propertyC");
            return (Criteria) this;
        }

        public Criteria andInsterTimeIsNull() {
            addCriterion("inster_time is null");
            return (Criteria) this;
        }

        public Criteria andInsterTimeIsNotNull() {
            addCriterion("inster_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsterTimeEqualTo(Date value) {
            addCriterion("inster_time =", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeNotEqualTo(Date value) {
            addCriterion("inster_time <>", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeGreaterThan(Date value) {
            addCriterion("inster_time >", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inster_time >=", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeLessThan(Date value) {
            addCriterion("inster_time <", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeLessThanOrEqualTo(Date value) {
            addCriterion("inster_time <=", value, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeIn(List<Date> values) {
            addCriterion("inster_time in", values, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeNotIn(List<Date> values) {
            addCriterion("inster_time not in", values, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeBetween(Date value1, Date value2) {
            addCriterion("inster_time between", value1, value2, "insterTime");
            return (Criteria) this;
        }

        public Criteria andInsterTimeNotBetween(Date value1, Date value2) {
            addCriterion("inster_time not between", value1, value2, "insterTime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creattime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creattime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creattime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creattime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creattime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creattime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creattime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creattime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creattime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creattime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creattime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creattime not between", value1, value2, "creattime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}