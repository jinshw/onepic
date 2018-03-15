package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdpzInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JdpzInfoExample() {
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

        public Criteria andZbCodeIsNull() {
            addCriterion("zb_code is null");
            return (Criteria) this;
        }

        public Criteria andZbCodeIsNotNull() {
            addCriterion("zb_code is not null");
            return (Criteria) this;
        }

        public Criteria andZbCodeEqualTo(String value) {
            addCriterion("zb_code =", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeNotEqualTo(String value) {
            addCriterion("zb_code <>", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeGreaterThan(String value) {
            addCriterion("zb_code >", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zb_code >=", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeLessThan(String value) {
            addCriterion("zb_code <", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeLessThanOrEqualTo(String value) {
            addCriterion("zb_code <=", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeLike(String value) {
            addCriterion("zb_code like", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeNotLike(String value) {
            addCriterion("zb_code not like", value, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeIn(List<String> values) {
            addCriterion("zb_code in", values, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeNotIn(List<String> values) {
            addCriterion("zb_code not in", values, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeBetween(String value1, String value2) {
            addCriterion("zb_code between", value1, value2, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbCodeNotBetween(String value1, String value2) {
            addCriterion("zb_code not between", value1, value2, "zbCode");
            return (Criteria) this;
        }

        public Criteria andZbYearIsNull() {
            addCriterion("zb_year is null");
            return (Criteria) this;
        }

        public Criteria andZbYearIsNotNull() {
            addCriterion("zb_year is not null");
            return (Criteria) this;
        }

        public Criteria andZbYearEqualTo(Long value) {
            addCriterion("zb_year =", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearNotEqualTo(Long value) {
            addCriterion("zb_year <>", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearGreaterThan(Long value) {
            addCriterion("zb_year >", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearGreaterThanOrEqualTo(Long value) {
            addCriterion("zb_year >=", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearLessThan(Long value) {
            addCriterion("zb_year <", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearLessThanOrEqualTo(Long value) {
            addCriterion("zb_year <=", value, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearIn(List<Long> values) {
            addCriterion("zb_year in", values, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearNotIn(List<Long> values) {
            addCriterion("zb_year not in", values, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearBetween(Long value1, Long value2) {
            addCriterion("zb_year between", value1, value2, "zbYear");
            return (Criteria) this;
        }

        public Criteria andZbYearNotBetween(Long value1, Long value2) {
            addCriterion("zb_year not between", value1, value2, "zbYear");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andZbNameIsNull() {
            addCriterion("zb_name is null");
            return (Criteria) this;
        }

        public Criteria andZbNameIsNotNull() {
            addCriterion("zb_name is not null");
            return (Criteria) this;
        }

        public Criteria andZbNameEqualTo(String value) {
            addCriterion("zb_name =", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameNotEqualTo(String value) {
            addCriterion("zb_name <>", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameGreaterThan(String value) {
            addCriterion("zb_name >", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameGreaterThanOrEqualTo(String value) {
            addCriterion("zb_name >=", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameLessThan(String value) {
            addCriterion("zb_name <", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameLessThanOrEqualTo(String value) {
            addCriterion("zb_name <=", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameLike(String value) {
            addCriterion("zb_name like", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameNotLike(String value) {
            addCriterion("zb_name not like", value, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameIn(List<String> values) {
            addCriterion("zb_name in", values, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameNotIn(List<String> values) {
            addCriterion("zb_name not in", values, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameBetween(String value1, String value2) {
            addCriterion("zb_name between", value1, value2, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbNameNotBetween(String value1, String value2) {
            addCriterion("zb_name not between", value1, value2, "zbName");
            return (Criteria) this;
        }

        public Criteria andZbUnitIsNull() {
            addCriterion("zb_unit is null");
            return (Criteria) this;
        }

        public Criteria andZbUnitIsNotNull() {
            addCriterion("zb_unit is not null");
            return (Criteria) this;
        }

        public Criteria andZbUnitEqualTo(String value) {
            addCriterion("zb_unit =", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitNotEqualTo(String value) {
            addCriterion("zb_unit <>", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitGreaterThan(String value) {
            addCriterion("zb_unit >", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitGreaterThanOrEqualTo(String value) {
            addCriterion("zb_unit >=", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitLessThan(String value) {
            addCriterion("zb_unit <", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitLessThanOrEqualTo(String value) {
            addCriterion("zb_unit <=", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitLike(String value) {
            addCriterion("zb_unit like", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitNotLike(String value) {
            addCriterion("zb_unit not like", value, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitIn(List<String> values) {
            addCriterion("zb_unit in", values, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitNotIn(List<String> values) {
            addCriterion("zb_unit not in", values, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitBetween(String value1, String value2) {
            addCriterion("zb_unit between", value1, value2, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbUnitNotBetween(String value1, String value2) {
            addCriterion("zb_unit not between", value1, value2, "zbUnit");
            return (Criteria) this;
        }

        public Criteria andZbPriceIsNull() {
            addCriterion("zb_price is null");
            return (Criteria) this;
        }

        public Criteria andZbPriceIsNotNull() {
            addCriterion("zb_price is not null");
            return (Criteria) this;
        }

        public Criteria andZbPriceEqualTo(String value) {
            addCriterion("zb_price =", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceNotEqualTo(String value) {
            addCriterion("zb_price <>", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceGreaterThan(String value) {
            addCriterion("zb_price >", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceGreaterThanOrEqualTo(String value) {
            addCriterion("zb_price >=", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceLessThan(String value) {
            addCriterion("zb_price <", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceLessThanOrEqualTo(String value) {
            addCriterion("zb_price <=", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceLike(String value) {
            addCriterion("zb_price like", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceNotLike(String value) {
            addCriterion("zb_price not like", value, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceIn(List<String> values) {
            addCriterion("zb_price in", values, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceNotIn(List<String> values) {
            addCriterion("zb_price not in", values, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceBetween(String value1, String value2) {
            addCriterion("zb_price between", value1, value2, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbPriceNotBetween(String value1, String value2) {
            addCriterion("zb_price not between", value1, value2, "zbPrice");
            return (Criteria) this;
        }

        public Criteria andZbTypeIsNull() {
            addCriterion("zb_type is null");
            return (Criteria) this;
        }

        public Criteria andZbTypeIsNotNull() {
            addCriterion("zb_type is not null");
            return (Criteria) this;
        }

        public Criteria andZbTypeEqualTo(Long value) {
            addCriterion("zb_type =", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeNotEqualTo(Long value) {
            addCriterion("zb_type <>", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeGreaterThan(Long value) {
            addCriterion("zb_type >", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("zb_type >=", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeLessThan(Long value) {
            addCriterion("zb_type <", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeLessThanOrEqualTo(Long value) {
            addCriterion("zb_type <=", value, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeIn(List<Long> values) {
            addCriterion("zb_type in", values, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeNotIn(List<Long> values) {
            addCriterion("zb_type not in", values, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeBetween(Long value1, Long value2) {
            addCriterion("zb_type between", value1, value2, "zbType");
            return (Criteria) this;
        }

        public Criteria andZbTypeNotBetween(Long value1, Long value2) {
            addCriterion("zb_type not between", value1, value2, "zbType");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("inserttime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("inserttime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("inserttime not between", value1, value2, "inserttime");
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