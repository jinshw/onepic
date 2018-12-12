package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsPlanTzkz05Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz05Example() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
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

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(Long value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(Long value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(Long value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(Long value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(Long value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(Long value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<Long> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<Long> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(Long value1, Long value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(Long value1, Long value2) {
            addCriterion("sn not between", value1, value2, "sn");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Long value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Long value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Long value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Long value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Long value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Long> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Long> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Long value1, Long value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Long value1, Long value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsIsNull() {
            addCriterion("zhb_cy_rs is null");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsIsNotNull() {
            addCriterion("zhb_cy_rs is not null");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsEqualTo(Long value) {
            addCriterion("zhb_cy_rs =", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsNotEqualTo(Long value) {
            addCriterion("zhb_cy_rs <>", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsGreaterThan(Long value) {
            addCriterion("zhb_cy_rs >", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsGreaterThanOrEqualTo(Long value) {
            addCriterion("zhb_cy_rs >=", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsLessThan(Long value) {
            addCriterion("zhb_cy_rs <", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsLessThanOrEqualTo(Long value) {
            addCriterion("zhb_cy_rs <=", value, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsIn(List<Long> values) {
            addCriterion("zhb_cy_rs in", values, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsNotIn(List<Long> values) {
            addCriterion("zhb_cy_rs not in", values, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsBetween(Long value1, Long value2) {
            addCriterion("zhb_cy_rs between", value1, value2, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbCyRsNotBetween(Long value1, Long value2) {
            addCriterion("zhb_cy_rs not between", value1, value2, "zhbCyRs");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryIsNull() {
            addCriterion("zhb_qz_jsry is null");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryIsNotNull() {
            addCriterion("zhb_qz_jsry is not null");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryEqualTo(Long value) {
            addCriterion("zhb_qz_jsry =", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryNotEqualTo(Long value) {
            addCriterion("zhb_qz_jsry <>", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryGreaterThan(Long value) {
            addCriterion("zhb_qz_jsry >", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryGreaterThanOrEqualTo(Long value) {
            addCriterion("zhb_qz_jsry >=", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryLessThan(Long value) {
            addCriterion("zhb_qz_jsry <", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryLessThanOrEqualTo(Long value) {
            addCriterion("zhb_qz_jsry <=", value, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryIn(List<Long> values) {
            addCriterion("zhb_qz_jsry in", values, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryNotIn(List<Long> values) {
            addCriterion("zhb_qz_jsry not in", values, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryBetween(Long value1, Long value2) {
            addCriterion("zhb_qz_jsry between", value1, value2, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbQzJsryNotBetween(Long value1, Long value2) {
            addCriterion("zhb_qz_jsry not between", value1, value2, "zhbQzJsry");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsIsNull() {
            addCriterion("zhb_cydwjs is null");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsIsNotNull() {
            addCriterion("zhb_cydwjs is not null");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsEqualTo(Long value) {
            addCriterion("zhb_cydwjs =", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsNotEqualTo(Long value) {
            addCriterion("zhb_cydwjs <>", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsGreaterThan(Long value) {
            addCriterion("zhb_cydwjs >", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsGreaterThanOrEqualTo(Long value) {
            addCriterion("zhb_cydwjs >=", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsLessThan(Long value) {
            addCriterion("zhb_cydwjs <", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsLessThanOrEqualTo(Long value) {
            addCriterion("zhb_cydwjs <=", value, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsIn(List<Long> values) {
            addCriterion("zhb_cydwjs in", values, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsNotIn(List<Long> values) {
            addCriterion("zhb_cydwjs not in", values, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsBetween(Long value1, Long value2) {
            addCriterion("zhb_cydwjs between", value1, value2, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andZhbCydwjsNotBetween(Long value1, Long value2) {
            addCriterion("zhb_cydwjs not between", value1, value2, "zhbCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCyRyIsNull() {
            addCriterion("jl_cy_ry is null");
            return (Criteria) this;
        }

        public Criteria andJlCyRyIsNotNull() {
            addCriterion("jl_cy_ry is not null");
            return (Criteria) this;
        }

        public Criteria andJlCyRyEqualTo(Long value) {
            addCriterion("jl_cy_ry =", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyNotEqualTo(Long value) {
            addCriterion("jl_cy_ry <>", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyGreaterThan(Long value) {
            addCriterion("jl_cy_ry >", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyGreaterThanOrEqualTo(Long value) {
            addCriterion("jl_cy_ry >=", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyLessThan(Long value) {
            addCriterion("jl_cy_ry <", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyLessThanOrEqualTo(Long value) {
            addCriterion("jl_cy_ry <=", value, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyIn(List<Long> values) {
            addCriterion("jl_cy_ry in", values, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyNotIn(List<Long> values) {
            addCriterion("jl_cy_ry not in", values, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyBetween(Long value1, Long value2) {
            addCriterion("jl_cy_ry between", value1, value2, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlCyRyNotBetween(Long value1, Long value2) {
            addCriterion("jl_cy_ry not between", value1, value2, "jlCyRy");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryIsNull() {
            addCriterion("jl_qz_jsry is null");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryIsNotNull() {
            addCriterion("jl_qz_jsry is not null");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryEqualTo(Long value) {
            addCriterion("jl_qz_jsry =", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryNotEqualTo(Long value) {
            addCriterion("jl_qz_jsry <>", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryGreaterThan(Long value) {
            addCriterion("jl_qz_jsry >", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryGreaterThanOrEqualTo(Long value) {
            addCriterion("jl_qz_jsry >=", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryLessThan(Long value) {
            addCriterion("jl_qz_jsry <", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryLessThanOrEqualTo(Long value) {
            addCriterion("jl_qz_jsry <=", value, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryIn(List<Long> values) {
            addCriterion("jl_qz_jsry in", values, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryNotIn(List<Long> values) {
            addCriterion("jl_qz_jsry not in", values, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryBetween(Long value1, Long value2) {
            addCriterion("jl_qz_jsry between", value1, value2, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlQzJsryNotBetween(Long value1, Long value2) {
            addCriterion("jl_qz_jsry not between", value1, value2, "jlQzJsry");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsIsNull() {
            addCriterion("jl_cydwjs is null");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsIsNotNull() {
            addCriterion("jl_cydwjs is not null");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsEqualTo(Long value) {
            addCriterion("jl_cydwjs =", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsNotEqualTo(Long value) {
            addCriterion("jl_cydwjs <>", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsGreaterThan(Long value) {
            addCriterion("jl_cydwjs >", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsGreaterThanOrEqualTo(Long value) {
            addCriterion("jl_cydwjs >=", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsLessThan(Long value) {
            addCriterion("jl_cydwjs <", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsLessThanOrEqualTo(Long value) {
            addCriterion("jl_cydwjs <=", value, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsIn(List<Long> values) {
            addCriterion("jl_cydwjs in", values, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsNotIn(List<Long> values) {
            addCriterion("jl_cydwjs not in", values, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsBetween(Long value1, Long value2) {
            addCriterion("jl_cydwjs between", value1, value2, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andJlCydwjsNotBetween(Long value1, Long value2) {
            addCriterion("jl_cydwjs not between", value1, value2, "jlCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsIsNull() {
            addCriterion("syjc_cy_rs is null");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsIsNotNull() {
            addCriterion("syjc_cy_rs is not null");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsEqualTo(Long value) {
            addCriterion("syjc_cy_rs =", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsNotEqualTo(Long value) {
            addCriterion("syjc_cy_rs <>", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsGreaterThan(Long value) {
            addCriterion("syjc_cy_rs >", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsGreaterThanOrEqualTo(Long value) {
            addCriterion("syjc_cy_rs >=", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsLessThan(Long value) {
            addCriterion("syjc_cy_rs <", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsLessThanOrEqualTo(Long value) {
            addCriterion("syjc_cy_rs <=", value, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsIn(List<Long> values) {
            addCriterion("syjc_cy_rs in", values, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsNotIn(List<Long> values) {
            addCriterion("syjc_cy_rs not in", values, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsBetween(Long value1, Long value2) {
            addCriterion("syjc_cy_rs between", value1, value2, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcCyRsNotBetween(Long value1, Long value2) {
            addCriterion("syjc_cy_rs not between", value1, value2, "syjcCyRs");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryIsNull() {
            addCriterion("syjc_qz_jsry is null");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryIsNotNull() {
            addCriterion("syjc_qz_jsry is not null");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryEqualTo(Long value) {
            addCriterion("syjc_qz_jsry =", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryNotEqualTo(Long value) {
            addCriterion("syjc_qz_jsry <>", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryGreaterThan(Long value) {
            addCriterion("syjc_qz_jsry >", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryGreaterThanOrEqualTo(Long value) {
            addCriterion("syjc_qz_jsry >=", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryLessThan(Long value) {
            addCriterion("syjc_qz_jsry <", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryLessThanOrEqualTo(Long value) {
            addCriterion("syjc_qz_jsry <=", value, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryIn(List<Long> values) {
            addCriterion("syjc_qz_jsry in", values, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryNotIn(List<Long> values) {
            addCriterion("syjc_qz_jsry not in", values, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryBetween(Long value1, Long value2) {
            addCriterion("syjc_qz_jsry between", value1, value2, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcQzJsryNotBetween(Long value1, Long value2) {
            addCriterion("syjc_qz_jsry not between", value1, value2, "syjcQzJsry");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsIsNull() {
            addCriterion("syjc_cydwjs is null");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsIsNotNull() {
            addCriterion("syjc_cydwjs is not null");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsEqualTo(Long value) {
            addCriterion("syjc_cydwjs =", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsNotEqualTo(Long value) {
            addCriterion("syjc_cydwjs <>", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsGreaterThan(Long value) {
            addCriterion("syjc_cydwjs >", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsGreaterThanOrEqualTo(Long value) {
            addCriterion("syjc_cydwjs >=", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsLessThan(Long value) {
            addCriterion("syjc_cydwjs <", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsLessThanOrEqualTo(Long value) {
            addCriterion("syjc_cydwjs <=", value, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsIn(List<Long> values) {
            addCriterion("syjc_cydwjs in", values, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsNotIn(List<Long> values) {
            addCriterion("syjc_cydwjs not in", values, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsBetween(Long value1, Long value2) {
            addCriterion("syjc_cydwjs between", value1, value2, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSyjcCydwjsNotBetween(Long value1, Long value2) {
            addCriterion("syjc_cydwjs not between", value1, value2, "syjcCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsIsNull() {
            addCriterion("sg_cy_rs is null");
            return (Criteria) this;
        }

        public Criteria andSgCyRsIsNotNull() {
            addCriterion("sg_cy_rs is not null");
            return (Criteria) this;
        }

        public Criteria andSgCyRsEqualTo(Long value) {
            addCriterion("sg_cy_rs =", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsNotEqualTo(Long value) {
            addCriterion("sg_cy_rs <>", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsGreaterThan(Long value) {
            addCriterion("sg_cy_rs >", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_cy_rs >=", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsLessThan(Long value) {
            addCriterion("sg_cy_rs <", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsLessThanOrEqualTo(Long value) {
            addCriterion("sg_cy_rs <=", value, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsIn(List<Long> values) {
            addCriterion("sg_cy_rs in", values, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsNotIn(List<Long> values) {
            addCriterion("sg_cy_rs not in", values, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsBetween(Long value1, Long value2) {
            addCriterion("sg_cy_rs between", value1, value2, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgCyRsNotBetween(Long value1, Long value2) {
            addCriterion("sg_cy_rs not between", value1, value2, "sgCyRs");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryIsNull() {
            addCriterion("sg_qz_jsry is null");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryIsNotNull() {
            addCriterion("sg_qz_jsry is not null");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryEqualTo(Long value) {
            addCriterion("sg_qz_jsry =", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryNotEqualTo(Long value) {
            addCriterion("sg_qz_jsry <>", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryGreaterThan(Long value) {
            addCriterion("sg_qz_jsry >", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_qz_jsry >=", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryLessThan(Long value) {
            addCriterion("sg_qz_jsry <", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryLessThanOrEqualTo(Long value) {
            addCriterion("sg_qz_jsry <=", value, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryIn(List<Long> values) {
            addCriterion("sg_qz_jsry in", values, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryNotIn(List<Long> values) {
            addCriterion("sg_qz_jsry not in", values, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryBetween(Long value1, Long value2) {
            addCriterion("sg_qz_jsry between", value1, value2, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgQzJsryNotBetween(Long value1, Long value2) {
            addCriterion("sg_qz_jsry not between", value1, value2, "sgQzJsry");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsIsNull() {
            addCriterion("sg_cydwjs is null");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsIsNotNull() {
            addCriterion("sg_cydwjs is not null");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsEqualTo(Long value) {
            addCriterion("sg_cydwjs =", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsNotEqualTo(Long value) {
            addCriterion("sg_cydwjs <>", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsGreaterThan(Long value) {
            addCriterion("sg_cydwjs >", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_cydwjs >=", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsLessThan(Long value) {
            addCriterion("sg_cydwjs <", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsLessThanOrEqualTo(Long value) {
            addCriterion("sg_cydwjs <=", value, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsIn(List<Long> values) {
            addCriterion("sg_cydwjs in", values, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsNotIn(List<Long> values) {
            addCriterion("sg_cydwjs not in", values, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsBetween(Long value1, Long value2) {
            addCriterion("sg_cydwjs between", value1, value2, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andSgCydwjsNotBetween(Long value1, Long value2) {
            addCriterion("sg_cydwjs not between", value1, value2, "sgCydwjs");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzIsNull() {
            addCriterion("lqhntbhz is null");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzIsNotNull() {
            addCriterion("lqhntbhz is not null");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzEqualTo(Long value) {
            addCriterion("lqhntbhz =", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzNotEqualTo(Long value) {
            addCriterion("lqhntbhz <>", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzGreaterThan(Long value) {
            addCriterion("lqhntbhz >", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzGreaterThanOrEqualTo(Long value) {
            addCriterion("lqhntbhz >=", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzLessThan(Long value) {
            addCriterion("lqhntbhz <", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzLessThanOrEqualTo(Long value) {
            addCriterion("lqhntbhz <=", value, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzIn(List<Long> values) {
            addCriterion("lqhntbhz in", values, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzNotIn(List<Long> values) {
            addCriterion("lqhntbhz not in", values, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzBetween(Long value1, Long value2) {
            addCriterion("lqhntbhz between", value1, value2, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqhntbhzNotBetween(Long value1, Long value2) {
            addCriterion("lqhntbhz not between", value1, value2, "lqhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzIsNull() {
            addCriterion("snwdtbhz is null");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzIsNotNull() {
            addCriterion("snwdtbhz is not null");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzEqualTo(Long value) {
            addCriterion("snwdtbhz =", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzNotEqualTo(Long value) {
            addCriterion("snwdtbhz <>", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzGreaterThan(Long value) {
            addCriterion("snwdtbhz >", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzGreaterThanOrEqualTo(Long value) {
            addCriterion("snwdtbhz >=", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzLessThan(Long value) {
            addCriterion("snwdtbhz <", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzLessThanOrEqualTo(Long value) {
            addCriterion("snwdtbhz <=", value, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzIn(List<Long> values) {
            addCriterion("snwdtbhz in", values, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzNotIn(List<Long> values) {
            addCriterion("snwdtbhz not in", values, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzBetween(Long value1, Long value2) {
            addCriterion("snwdtbhz between", value1, value2, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnwdtbhzNotBetween(Long value1, Long value2) {
            addCriterion("snwdtbhz not between", value1, value2, "snwdtbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzIsNull() {
            addCriterion("snhntbhz is null");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzIsNotNull() {
            addCriterion("snhntbhz is not null");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzEqualTo(Long value) {
            addCriterion("snhntbhz =", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzNotEqualTo(Long value) {
            addCriterion("snhntbhz <>", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzGreaterThan(Long value) {
            addCriterion("snhntbhz >", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzGreaterThanOrEqualTo(Long value) {
            addCriterion("snhntbhz >=", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzLessThan(Long value) {
            addCriterion("snhntbhz <", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzLessThanOrEqualTo(Long value) {
            addCriterion("snhntbhz <=", value, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzIn(List<Long> values) {
            addCriterion("snhntbhz in", values, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzNotIn(List<Long> values) {
            addCriterion("snhntbhz not in", values, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzBetween(Long value1, Long value2) {
            addCriterion("snhntbhz between", value1, value2, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andSnhntbhzNotBetween(Long value1, Long value2) {
            addCriterion("snhntbhz not between", value1, value2, "snhntbhz");
            return (Criteria) this;
        }

        public Criteria andLqtpjIsNull() {
            addCriterion("lqtpj is null");
            return (Criteria) this;
        }

        public Criteria andLqtpjIsNotNull() {
            addCriterion("lqtpj is not null");
            return (Criteria) this;
        }

        public Criteria andLqtpjEqualTo(Long value) {
            addCriterion("lqtpj =", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjNotEqualTo(Long value) {
            addCriterion("lqtpj <>", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjGreaterThan(Long value) {
            addCriterion("lqtpj >", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjGreaterThanOrEqualTo(Long value) {
            addCriterion("lqtpj >=", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjLessThan(Long value) {
            addCriterion("lqtpj <", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjLessThanOrEqualTo(Long value) {
            addCriterion("lqtpj <=", value, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjIn(List<Long> values) {
            addCriterion("lqtpj in", values, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjNotIn(List<Long> values) {
            addCriterion("lqtpj not in", values, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjBetween(Long value1, Long value2) {
            addCriterion("lqtpj between", value1, value2, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andLqtpjNotBetween(Long value1, Long value2) {
            addCriterion("lqtpj not between", value1, value2, "lqtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjIsNull() {
            addCriterion("swtpj is null");
            return (Criteria) this;
        }

        public Criteria andSwtpjIsNotNull() {
            addCriterion("swtpj is not null");
            return (Criteria) this;
        }

        public Criteria andSwtpjEqualTo(Long value) {
            addCriterion("swtpj =", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjNotEqualTo(Long value) {
            addCriterion("swtpj <>", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjGreaterThan(Long value) {
            addCriterion("swtpj >", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjGreaterThanOrEqualTo(Long value) {
            addCriterion("swtpj >=", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjLessThan(Long value) {
            addCriterion("swtpj <", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjLessThanOrEqualTo(Long value) {
            addCriterion("swtpj <=", value, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjIn(List<Long> values) {
            addCriterion("swtpj in", values, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjNotIn(List<Long> values) {
            addCriterion("swtpj not in", values, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjBetween(Long value1, Long value2) {
            addCriterion("swtpj between", value1, value2, "swtpj");
            return (Criteria) this;
        }

        public Criteria andSwtpjNotBetween(Long value1, Long value2) {
            addCriterion("swtpj not between", value1, value2, "swtpj");
            return (Criteria) this;
        }

        public Criteria andYljIsNull() {
            addCriterion("ylj is null");
            return (Criteria) this;
        }

        public Criteria andYljIsNotNull() {
            addCriterion("ylj is not null");
            return (Criteria) this;
        }

        public Criteria andYljEqualTo(Long value) {
            addCriterion("ylj =", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljNotEqualTo(Long value) {
            addCriterion("ylj <>", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljGreaterThan(Long value) {
            addCriterion("ylj >", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljGreaterThanOrEqualTo(Long value) {
            addCriterion("ylj >=", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljLessThan(Long value) {
            addCriterion("ylj <", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljLessThanOrEqualTo(Long value) {
            addCriterion("ylj <=", value, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljIn(List<Long> values) {
            addCriterion("ylj in", values, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljNotIn(List<Long> values) {
            addCriterion("ylj not in", values, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljBetween(Long value1, Long value2) {
            addCriterion("ylj between", value1, value2, "ylj");
            return (Criteria) this;
        }

        public Criteria andYljNotBetween(Long value1, Long value2) {
            addCriterion("ylj not between", value1, value2, "ylj");
            return (Criteria) this;
        }

        public Criteria andPdlIsNull() {
            addCriterion("pdl is null");
            return (Criteria) this;
        }

        public Criteria andPdlIsNotNull() {
            addCriterion("pdl is not null");
            return (Criteria) this;
        }

        public Criteria andPdlEqualTo(Long value) {
            addCriterion("pdl =", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlNotEqualTo(Long value) {
            addCriterion("pdl <>", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlGreaterThan(Long value) {
            addCriterion("pdl >", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlGreaterThanOrEqualTo(Long value) {
            addCriterion("pdl >=", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlLessThan(Long value) {
            addCriterion("pdl <", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlLessThanOrEqualTo(Long value) {
            addCriterion("pdl <=", value, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlIn(List<Long> values) {
            addCriterion("pdl in", values, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlNotIn(List<Long> values) {
            addCriterion("pdl not in", values, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlBetween(Long value1, Long value2) {
            addCriterion("pdl between", value1, value2, "pdl");
            return (Criteria) this;
        }

        public Criteria andPdlNotBetween(Long value1, Long value2) {
            addCriterion("pdl not between", value1, value2, "pdl");
            return (Criteria) this;
        }

        public Criteria andWjjIsNull() {
            addCriterion("wjj is null");
            return (Criteria) this;
        }

        public Criteria andWjjIsNotNull() {
            addCriterion("wjj is not null");
            return (Criteria) this;
        }

        public Criteria andWjjEqualTo(Long value) {
            addCriterion("wjj =", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjNotEqualTo(Long value) {
            addCriterion("wjj <>", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjGreaterThan(Long value) {
            addCriterion("wjj >", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjGreaterThanOrEqualTo(Long value) {
            addCriterion("wjj >=", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjLessThan(Long value) {
            addCriterion("wjj <", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjLessThanOrEqualTo(Long value) {
            addCriterion("wjj <=", value, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjIn(List<Long> values) {
            addCriterion("wjj in", values, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjNotIn(List<Long> values) {
            addCriterion("wjj not in", values, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjBetween(Long value1, Long value2) {
            addCriterion("wjj between", value1, value2, "wjj");
            return (Criteria) this;
        }

        public Criteria andWjjNotBetween(Long value1, Long value2) {
            addCriterion("wjj not between", value1, value2, "wjj");
            return (Criteria) this;
        }

        public Criteria andZzjIsNull() {
            addCriterion("zzj is null");
            return (Criteria) this;
        }

        public Criteria andZzjIsNotNull() {
            addCriterion("zzj is not null");
            return (Criteria) this;
        }

        public Criteria andZzjEqualTo(Long value) {
            addCriterion("zzj =", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjNotEqualTo(Long value) {
            addCriterion("zzj <>", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjGreaterThan(Long value) {
            addCriterion("zzj >", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjGreaterThanOrEqualTo(Long value) {
            addCriterion("zzj >=", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjLessThan(Long value) {
            addCriterion("zzj <", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjLessThanOrEqualTo(Long value) {
            addCriterion("zzj <=", value, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjIn(List<Long> values) {
            addCriterion("zzj in", values, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjNotIn(List<Long> values) {
            addCriterion("zzj not in", values, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjBetween(Long value1, Long value2) {
            addCriterion("zzj between", value1, value2, "zzj");
            return (Criteria) this;
        }

        public Criteria andZzjNotBetween(Long value1, Long value2) {
            addCriterion("zzj not between", value1, value2, "zzj");
            return (Criteria) this;
        }

        public Criteria andClHjIsNull() {
            addCriterion("cl_hj is null");
            return (Criteria) this;
        }

        public Criteria andClHjIsNotNull() {
            addCriterion("cl_hj is not null");
            return (Criteria) this;
        }

        public Criteria andClHjEqualTo(Long value) {
            addCriterion("cl_hj =", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjNotEqualTo(Long value) {
            addCriterion("cl_hj <>", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjGreaterThan(Long value) {
            addCriterion("cl_hj >", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjGreaterThanOrEqualTo(Long value) {
            addCriterion("cl_hj >=", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjLessThan(Long value) {
            addCriterion("cl_hj <", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjLessThanOrEqualTo(Long value) {
            addCriterion("cl_hj <=", value, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjIn(List<Long> values) {
            addCriterion("cl_hj in", values, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjNotIn(List<Long> values) {
            addCriterion("cl_hj not in", values, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjBetween(Long value1, Long value2) {
            addCriterion("cl_hj between", value1, value2, "clHj");
            return (Criteria) this;
        }

        public Criteria andClHjNotBetween(Long value1, Long value2) {
            addCriterion("cl_hj not between", value1, value2, "clHj");
            return (Criteria) this;
        }

        public Criteria andClQzysIsNull() {
            addCriterion("cl_qzys is null");
            return (Criteria) this;
        }

        public Criteria andClQzysIsNotNull() {
            addCriterion("cl_qzys is not null");
            return (Criteria) this;
        }

        public Criteria andClQzysEqualTo(Long value) {
            addCriterion("cl_qzys =", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysNotEqualTo(Long value) {
            addCriterion("cl_qzys <>", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysGreaterThan(Long value) {
            addCriterion("cl_qzys >", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysGreaterThanOrEqualTo(Long value) {
            addCriterion("cl_qzys >=", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysLessThan(Long value) {
            addCriterion("cl_qzys <", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysLessThanOrEqualTo(Long value) {
            addCriterion("cl_qzys <=", value, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysIn(List<Long> values) {
            addCriterion("cl_qzys in", values, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysNotIn(List<Long> values) {
            addCriterion("cl_qzys not in", values, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysBetween(Long value1, Long value2) {
            addCriterion("cl_qzys between", value1, value2, "clQzys");
            return (Criteria) this;
        }

        public Criteria andClQzysNotBetween(Long value1, Long value2) {
            addCriterion("cl_qzys not between", value1, value2, "clQzys");
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
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
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