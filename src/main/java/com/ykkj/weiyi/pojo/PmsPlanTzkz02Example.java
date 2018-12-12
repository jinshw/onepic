package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsPlanTzkz02Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz02Example() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(String value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(String value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(String value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(String value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(String value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(String value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLike(String value) {
            addCriterion("m_id like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotLike(String value) {
            addCriterion("m_id not like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<String> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<String> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(String value1, String value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(String value1, String value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andJhbzIdIsNull() {
            addCriterion("jhbz_id is null");
            return (Criteria) this;
        }

        public Criteria andJhbzIdIsNotNull() {
            addCriterion("jhbz_id is not null");
            return (Criteria) this;
        }

        public Criteria andJhbzIdEqualTo(String value) {
            addCriterion("jhbz_id =", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdNotEqualTo(String value) {
            addCriterion("jhbz_id <>", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdGreaterThan(String value) {
            addCriterion("jhbz_id >", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdGreaterThanOrEqualTo(String value) {
            addCriterion("jhbz_id >=", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdLessThan(String value) {
            addCriterion("jhbz_id <", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdLessThanOrEqualTo(String value) {
            addCriterion("jhbz_id <=", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdLike(String value) {
            addCriterion("jhbz_id like", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdNotLike(String value) {
            addCriterion("jhbz_id not like", value, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdIn(List<String> values) {
            addCriterion("jhbz_id in", values, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdNotIn(List<String> values) {
            addCriterion("jhbz_id not in", values, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdBetween(String value1, String value2) {
            addCriterion("jhbz_id between", value1, value2, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andJhbzIdNotBetween(String value1, String value2) {
            addCriterion("jhbz_id not between", value1, value2, "jhbzId");
            return (Criteria) this;
        }

        public Criteria andIdTwoIsNull() {
            addCriterion("id_two is null");
            return (Criteria) this;
        }

        public Criteria andIdTwoIsNotNull() {
            addCriterion("id_two is not null");
            return (Criteria) this;
        }

        public Criteria andIdTwoEqualTo(String value) {
            addCriterion("id_two =", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotEqualTo(String value) {
            addCriterion("id_two <>", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoGreaterThan(String value) {
            addCriterion("id_two >", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoGreaterThanOrEqualTo(String value) {
            addCriterion("id_two >=", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoLessThan(String value) {
            addCriterion("id_two <", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoLessThanOrEqualTo(String value) {
            addCriterion("id_two <=", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoLike(String value) {
            addCriterion("id_two like", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotLike(String value) {
            addCriterion("id_two not like", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoIn(List<String> values) {
            addCriterion("id_two in", values, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotIn(List<String> values) {
            addCriterion("id_two not in", values, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoBetween(String value1, String value2) {
            addCriterion("id_two between", value1, value2, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotBetween(String value1, String value2) {
            addCriterion("id_two not between", value1, value2, "idTwo");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andHtsl1IsNull() {
            addCriterion("htsl1 is null");
            return (Criteria) this;
        }

        public Criteria andHtsl1IsNotNull() {
            addCriterion("htsl1 is not null");
            return (Criteria) this;
        }

        public Criteria andHtsl1EqualTo(BigDecimal value) {
            addCriterion("htsl1 =", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1NotEqualTo(BigDecimal value) {
            addCriterion("htsl1 <>", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1GreaterThan(BigDecimal value) {
            addCriterion("htsl1 >", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl1 >=", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1LessThan(BigDecimal value) {
            addCriterion("htsl1 <", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl1 <=", value, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1In(List<BigDecimal> values) {
            addCriterion("htsl1 in", values, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1NotIn(List<BigDecimal> values) {
            addCriterion("htsl1 not in", values, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl1 between", value1, value2, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl1 not between", value1, value2, "htsl1");
            return (Criteria) this;
        }

        public Criteria andHtsl2IsNull() {
            addCriterion("htsl2 is null");
            return (Criteria) this;
        }

        public Criteria andHtsl2IsNotNull() {
            addCriterion("htsl2 is not null");
            return (Criteria) this;
        }

        public Criteria andHtsl2EqualTo(BigDecimal value) {
            addCriterion("htsl2 =", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2NotEqualTo(BigDecimal value) {
            addCriterion("htsl2 <>", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2GreaterThan(BigDecimal value) {
            addCriterion("htsl2 >", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl2 >=", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2LessThan(BigDecimal value) {
            addCriterion("htsl2 <", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl2 <=", value, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2In(List<BigDecimal> values) {
            addCriterion("htsl2 in", values, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2NotIn(List<BigDecimal> values) {
            addCriterion("htsl2 not in", values, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl2 between", value1, value2, "htsl2");
            return (Criteria) this;
        }

        public Criteria andHtsl2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl2 not between", value1, value2, "htsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl1IsNull() {
            addCriterion("fhsl1 is null");
            return (Criteria) this;
        }

        public Criteria andFhsl1IsNotNull() {
            addCriterion("fhsl1 is not null");
            return (Criteria) this;
        }

        public Criteria andFhsl1EqualTo(BigDecimal value) {
            addCriterion("fhsl1 =", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1NotEqualTo(BigDecimal value) {
            addCriterion("fhsl1 <>", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1GreaterThan(BigDecimal value) {
            addCriterion("fhsl1 >", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fhsl1 >=", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1LessThan(BigDecimal value) {
            addCriterion("fhsl1 <", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fhsl1 <=", value, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1In(List<BigDecimal> values) {
            addCriterion("fhsl1 in", values, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1NotIn(List<BigDecimal> values) {
            addCriterion("fhsl1 not in", values, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fhsl1 between", value1, value2, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fhsl1 not between", value1, value2, "fhsl1");
            return (Criteria) this;
        }

        public Criteria andFhsl2IsNull() {
            addCriterion("fhsl2 is null");
            return (Criteria) this;
        }

        public Criteria andFhsl2IsNotNull() {
            addCriterion("fhsl2 is not null");
            return (Criteria) this;
        }

        public Criteria andFhsl2EqualTo(BigDecimal value) {
            addCriterion("fhsl2 =", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2NotEqualTo(BigDecimal value) {
            addCriterion("fhsl2 <>", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2GreaterThan(BigDecimal value) {
            addCriterion("fhsl2 >", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fhsl2 >=", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2LessThan(BigDecimal value) {
            addCriterion("fhsl2 <", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fhsl2 <=", value, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2In(List<BigDecimal> values) {
            addCriterion("fhsl2 in", values, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2NotIn(List<BigDecimal> values) {
            addCriterion("fhsl2 not in", values, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fhsl2 between", value1, value2, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andFhsl2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fhsl2 not between", value1, value2, "fhsl2");
            return (Criteria) this;
        }

        public Criteria andBnjh1IsNull() {
            addCriterion("bnjh1 is null");
            return (Criteria) this;
        }

        public Criteria andBnjh1IsNotNull() {
            addCriterion("bnjh1 is not null");
            return (Criteria) this;
        }

        public Criteria andBnjh1EqualTo(BigDecimal value) {
            addCriterion("bnjh1 =", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1NotEqualTo(BigDecimal value) {
            addCriterion("bnjh1 <>", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1GreaterThan(BigDecimal value) {
            addCriterion("bnjh1 >", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bnjh1 >=", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1LessThan(BigDecimal value) {
            addCriterion("bnjh1 <", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("bnjh1 <=", value, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1In(List<BigDecimal> values) {
            addCriterion("bnjh1 in", values, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1NotIn(List<BigDecimal> values) {
            addCriterion("bnjh1 not in", values, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("bnjh1 between", value1, value2, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bnjh1 not between", value1, value2, "bnjh1");
            return (Criteria) this;
        }

        public Criteria andBnjh2IsNull() {
            addCriterion("bnjh2 is null");
            return (Criteria) this;
        }

        public Criteria andBnjh2IsNotNull() {
            addCriterion("bnjh2 is not null");
            return (Criteria) this;
        }

        public Criteria andBnjh2EqualTo(BigDecimal value) {
            addCriterion("bnjh2 =", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2NotEqualTo(BigDecimal value) {
            addCriterion("bnjh2 <>", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2GreaterThan(BigDecimal value) {
            addCriterion("bnjh2 >", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bnjh2 >=", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2LessThan(BigDecimal value) {
            addCriterion("bnjh2 <", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("bnjh2 <=", value, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2In(List<BigDecimal> values) {
            addCriterion("bnjh2 in", values, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2NotIn(List<BigDecimal> values) {
            addCriterion("bnjh2 not in", values, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("bnjh2 between", value1, value2, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andBnjh2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bnjh2 not between", value1, value2, "bnjh2");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11IsNull() {
            addCriterion("zbyljwc11 is null");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11IsNotNull() {
            addCriterion("zbyljwc11 is not null");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11EqualTo(BigDecimal value) {
            addCriterion("zbyljwc11 =", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11NotEqualTo(BigDecimal value) {
            addCriterion("zbyljwc11 <>", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11GreaterThan(BigDecimal value) {
            addCriterion("zbyljwc11 >", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zbyljwc11 >=", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11LessThan(BigDecimal value) {
            addCriterion("zbyljwc11 <", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("zbyljwc11 <=", value, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11In(List<BigDecimal> values) {
            addCriterion("zbyljwc11 in", values, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11NotIn(List<BigDecimal> values) {
            addCriterion("zbyljwc11 not in", values, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("zbyljwc11 between", value1, value2, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zbyljwc11 not between", value1, value2, "zbyljwc11");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21IsNull() {
            addCriterion("zbyljwc21 is null");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21IsNotNull() {
            addCriterion("zbyljwc21 is not null");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21EqualTo(BigDecimal value) {
            addCriterion("zbyljwc21 =", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21NotEqualTo(BigDecimal value) {
            addCriterion("zbyljwc21 <>", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21GreaterThan(BigDecimal value) {
            addCriterion("zbyljwc21 >", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zbyljwc21 >=", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21LessThan(BigDecimal value) {
            addCriterion("zbyljwc21 <", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21LessThanOrEqualTo(BigDecimal value) {
            addCriterion("zbyljwc21 <=", value, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21In(List<BigDecimal> values) {
            addCriterion("zbyljwc21 in", values, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21NotIn(List<BigDecimal> values) {
            addCriterion("zbyljwc21 not in", values, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("zbyljwc21 between", value1, value2, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZbyljwc21NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zbyljwc21 not between", value1, value2, "zbyljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc11IsNull() {
            addCriterion("zncljwc11 is null");
            return (Criteria) this;
        }

        public Criteria andZncljwc11IsNotNull() {
            addCriterion("zncljwc11 is not null");
            return (Criteria) this;
        }

        public Criteria andZncljwc11EqualTo(BigDecimal value) {
            addCriterion("zncljwc11 =", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11NotEqualTo(BigDecimal value) {
            addCriterion("zncljwc11 <>", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11GreaterThan(BigDecimal value) {
            addCriterion("zncljwc11 >", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zncljwc11 >=", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11LessThan(BigDecimal value) {
            addCriterion("zncljwc11 <", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("zncljwc11 <=", value, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11In(List<BigDecimal> values) {
            addCriterion("zncljwc11 in", values, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11NotIn(List<BigDecimal> values) {
            addCriterion("zncljwc11 not in", values, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("zncljwc11 between", value1, value2, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zncljwc11 not between", value1, value2, "zncljwc11");
            return (Criteria) this;
        }

        public Criteria andZncljwc21IsNull() {
            addCriterion("zncljwc21 is null");
            return (Criteria) this;
        }

        public Criteria andZncljwc21IsNotNull() {
            addCriterion("zncljwc21 is not null");
            return (Criteria) this;
        }

        public Criteria andZncljwc21EqualTo(BigDecimal value) {
            addCriterion("zncljwc21 =", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21NotEqualTo(BigDecimal value) {
            addCriterion("zncljwc21 <>", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21GreaterThan(BigDecimal value) {
            addCriterion("zncljwc21 >", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zncljwc21 >=", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21LessThan(BigDecimal value) {
            addCriterion("zncljwc21 <", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21LessThanOrEqualTo(BigDecimal value) {
            addCriterion("zncljwc21 <=", value, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21In(List<BigDecimal> values) {
            addCriterion("zncljwc21 in", values, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21NotIn(List<BigDecimal> values) {
            addCriterion("zncljwc21 not in", values, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("zncljwc21 between", value1, value2, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andZncljwc21NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zncljwc21 not between", value1, value2, "zncljwc21");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterionForJDBCDate("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterionForJDBCDate("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterionForJDBCDate("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insert_time not between", value1, value2, "insertTime");
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
            addCriterionForJDBCDate("creattime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("creattime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterionForJDBCDate("creattime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creattime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterionForJDBCDate("creattime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creattime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterionForJDBCDate("creattime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("creattime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creattime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creattime not between", value1, value2, "creattime");
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