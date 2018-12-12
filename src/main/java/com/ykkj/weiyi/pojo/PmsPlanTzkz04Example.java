package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsPlanTzkz04Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz04Example() {
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

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
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

        public Criteria andNmgByRsIsNull() {
            addCriterion("nmg_by_rs is null");
            return (Criteria) this;
        }

        public Criteria andNmgByRsIsNotNull() {
            addCriterion("nmg_by_rs is not null");
            return (Criteria) this;
        }

        public Criteria andNmgByRsEqualTo(Long value) {
            addCriterion("nmg_by_rs =", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsNotEqualTo(Long value) {
            addCriterion("nmg_by_rs <>", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsGreaterThan(Long value) {
            addCriterion("nmg_by_rs >", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsGreaterThanOrEqualTo(Long value) {
            addCriterion("nmg_by_rs >=", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsLessThan(Long value) {
            addCriterion("nmg_by_rs <", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsLessThanOrEqualTo(Long value) {
            addCriterion("nmg_by_rs <=", value, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsIn(List<Long> values) {
            addCriterion("nmg_by_rs in", values, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsNotIn(List<Long> values) {
            addCriterion("nmg_by_rs not in", values, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsBetween(Long value1, Long value2) {
            addCriterion("nmg_by_rs between", value1, value2, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgByRsNotBetween(Long value1, Long value2) {
            addCriterion("nmg_by_rs not between", value1, value2, "nmgByRs");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcIsNull() {
            addCriterion("nmg_jzby_ljrc is null");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcIsNotNull() {
            addCriterion("nmg_jzby_ljrc is not null");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcEqualTo(Long value) {
            addCriterion("nmg_jzby_ljrc =", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcNotEqualTo(Long value) {
            addCriterion("nmg_jzby_ljrc <>", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcGreaterThan(Long value) {
            addCriterion("nmg_jzby_ljrc >", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcGreaterThanOrEqualTo(Long value) {
            addCriterion("nmg_jzby_ljrc >=", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcLessThan(Long value) {
            addCriterion("nmg_jzby_ljrc <", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcLessThanOrEqualTo(Long value) {
            addCriterion("nmg_jzby_ljrc <=", value, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcIn(List<Long> values) {
            addCriterion("nmg_jzby_ljrc in", values, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcNotIn(List<Long> values) {
            addCriterion("nmg_jzby_ljrc not in", values, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcBetween(Long value1, Long value2) {
            addCriterion("nmg_jzby_ljrc between", value1, value2, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjrcNotBetween(Long value1, Long value2) {
            addCriterion("nmg_jzby_ljrc not between", value1, value2, "nmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andNmgBySrIsNull() {
            addCriterion("nmg_by_sr is null");
            return (Criteria) this;
        }

        public Criteria andNmgBySrIsNotNull() {
            addCriterion("nmg_by_sr is not null");
            return (Criteria) this;
        }

        public Criteria andNmgBySrEqualTo(BigDecimal value) {
            addCriterion("nmg_by_sr =", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrNotEqualTo(BigDecimal value) {
            addCriterion("nmg_by_sr <>", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrGreaterThan(BigDecimal value) {
            addCriterion("nmg_by_sr >", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nmg_by_sr >=", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrLessThan(BigDecimal value) {
            addCriterion("nmg_by_sr <", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nmg_by_sr <=", value, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrIn(List<BigDecimal> values) {
            addCriterion("nmg_by_sr in", values, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrNotIn(List<BigDecimal> values) {
            addCriterion("nmg_by_sr not in", values, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nmg_by_sr between", value1, value2, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgBySrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nmg_by_sr not between", value1, value2, "nmgBySr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrIsNull() {
            addCriterion("nmg_jzby_ljsr is null");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrIsNotNull() {
            addCriterion("nmg_jzby_ljsr is not null");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrEqualTo(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr =", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrNotEqualTo(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr <>", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrGreaterThan(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr >", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr >=", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrLessThan(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr <", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nmg_jzby_ljsr <=", value, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrIn(List<BigDecimal> values) {
            addCriterion("nmg_jzby_ljsr in", values, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrNotIn(List<BigDecimal> values) {
            addCriterion("nmg_jzby_ljsr not in", values, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nmg_jzby_ljsr between", value1, value2, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andNmgJzbyLjsrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nmg_jzby_ljsr not between", value1, value2, "nmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsIsNull() {
            addCriterion("ddnmg_by_rs is null");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsIsNotNull() {
            addCriterion("ddnmg_by_rs is not null");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsEqualTo(Long value) {
            addCriterion("ddnmg_by_rs =", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsNotEqualTo(Long value) {
            addCriterion("ddnmg_by_rs <>", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsGreaterThan(Long value) {
            addCriterion("ddnmg_by_rs >", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsGreaterThanOrEqualTo(Long value) {
            addCriterion("ddnmg_by_rs >=", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsLessThan(Long value) {
            addCriterion("ddnmg_by_rs <", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsLessThanOrEqualTo(Long value) {
            addCriterion("ddnmg_by_rs <=", value, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsIn(List<Long> values) {
            addCriterion("ddnmg_by_rs in", values, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsNotIn(List<Long> values) {
            addCriterion("ddnmg_by_rs not in", values, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsBetween(Long value1, Long value2) {
            addCriterion("ddnmg_by_rs between", value1, value2, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgByRsNotBetween(Long value1, Long value2) {
            addCriterion("ddnmg_by_rs not between", value1, value2, "ddnmgByRs");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcIsNull() {
            addCriterion("ddnmg_jzby_ljrc is null");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcIsNotNull() {
            addCriterion("ddnmg_jzby_ljrc is not null");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcEqualTo(Long value) {
            addCriterion("ddnmg_jzby_ljrc =", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcNotEqualTo(Long value) {
            addCriterion("ddnmg_jzby_ljrc <>", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcGreaterThan(Long value) {
            addCriterion("ddnmg_jzby_ljrc >", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcGreaterThanOrEqualTo(Long value) {
            addCriterion("ddnmg_jzby_ljrc >=", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcLessThan(Long value) {
            addCriterion("ddnmg_jzby_ljrc <", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcLessThanOrEqualTo(Long value) {
            addCriterion("ddnmg_jzby_ljrc <=", value, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcIn(List<Long> values) {
            addCriterion("ddnmg_jzby_ljrc in", values, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcNotIn(List<Long> values) {
            addCriterion("ddnmg_jzby_ljrc not in", values, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcBetween(Long value1, Long value2) {
            addCriterion("ddnmg_jzby_ljrc between", value1, value2, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjrcNotBetween(Long value1, Long value2) {
            addCriterion("ddnmg_jzby_ljrc not between", value1, value2, "ddnmgJzbyLjrc");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrIsNull() {
            addCriterion("ddnmg_br_sr is null");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrIsNotNull() {
            addCriterion("ddnmg_br_sr is not null");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_br_sr =", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrNotEqualTo(BigDecimal value) {
            addCriterion("ddnmg_br_sr <>", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrGreaterThan(BigDecimal value) {
            addCriterion("ddnmg_br_sr >", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_br_sr >=", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrLessThan(BigDecimal value) {
            addCriterion("ddnmg_br_sr <", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_br_sr <=", value, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrIn(List<BigDecimal> values) {
            addCriterion("ddnmg_br_sr in", values, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrNotIn(List<BigDecimal> values) {
            addCriterion("ddnmg_br_sr not in", values, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ddnmg_br_sr between", value1, value2, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgBrSrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ddnmg_br_sr not between", value1, value2, "ddnmgBrSr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrIsNull() {
            addCriterion("ddnmg_jzby_ljsr is null");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrIsNotNull() {
            addCriterion("ddnmg_jzby_ljsr is not null");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr =", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrNotEqualTo(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr <>", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrGreaterThan(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr >", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr >=", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrLessThan(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr <", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ddnmg_jzby_ljsr <=", value, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrIn(List<BigDecimal> values) {
            addCriterion("ddnmg_jzby_ljsr in", values, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrNotIn(List<BigDecimal> values) {
            addCriterion("ddnmg_jzby_ljsr not in", values, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ddnmg_jzby_ljsr between", value1, value2, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andDdnmgJzbyLjsrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ddnmg_jzby_ljsr not between", value1, value2, "ddnmgJzbyLjsr");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhIsNull() {
            addCriterion("lq_jzby_ljxh is null");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhIsNotNull() {
            addCriterion("lq_jzby_ljxh is not null");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhEqualTo(BigDecimal value) {
            addCriterion("lq_jzby_ljxh =", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhNotEqualTo(BigDecimal value) {
            addCriterion("lq_jzby_ljxh <>", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhGreaterThan(BigDecimal value) {
            addCriterion("lq_jzby_ljxh >", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_jzby_ljxh >=", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhLessThan(BigDecimal value) {
            addCriterion("lq_jzby_ljxh <", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_jzby_ljxh <=", value, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhIn(List<BigDecimal> values) {
            addCriterion("lq_jzby_ljxh in", values, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhNotIn(List<BigDecimal> values) {
            addCriterion("lq_jzby_ljxh not in", values, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_jzby_ljxh between", value1, value2, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andLqJzbyLjxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_jzby_ljxh not between", value1, value2, "lqJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnByXhIsNull() {
            addCriterion("sn_by_xh is null");
            return (Criteria) this;
        }

        public Criteria andSnByXhIsNotNull() {
            addCriterion("sn_by_xh is not null");
            return (Criteria) this;
        }

        public Criteria andSnByXhEqualTo(BigDecimal value) {
            addCriterion("sn_by_xh =", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhNotEqualTo(BigDecimal value) {
            addCriterion("sn_by_xh <>", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhGreaterThan(BigDecimal value) {
            addCriterion("sn_by_xh >", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_by_xh >=", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhLessThan(BigDecimal value) {
            addCriterion("sn_by_xh <", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_by_xh <=", value, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhIn(List<BigDecimal> values) {
            addCriterion("sn_by_xh in", values, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhNotIn(List<BigDecimal> values) {
            addCriterion("sn_by_xh not in", values, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_by_xh between", value1, value2, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnByXhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_by_xh not between", value1, value2, "snByXh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhIsNull() {
            addCriterion("sn_jzby_ljxh is null");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhIsNotNull() {
            addCriterion("sn_jzby_ljxh is not null");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhEqualTo(BigDecimal value) {
            addCriterion("sn_jzby_ljxh =", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhNotEqualTo(BigDecimal value) {
            addCriterion("sn_jzby_ljxh <>", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhGreaterThan(BigDecimal value) {
            addCriterion("sn_jzby_ljxh >", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_jzby_ljxh >=", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhLessThan(BigDecimal value) {
            addCriterion("sn_jzby_ljxh <", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_jzby_ljxh <=", value, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhIn(List<BigDecimal> values) {
            addCriterion("sn_jzby_ljxh in", values, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhNotIn(List<BigDecimal> values) {
            addCriterion("sn_jzby_ljxh not in", values, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_jzby_ljxh between", value1, value2, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andSnJzbyLjxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_jzby_ljxh not between", value1, value2, "snJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcByXhIsNull() {
            addCriterion("gc_by_xh is null");
            return (Criteria) this;
        }

        public Criteria andGcByXhIsNotNull() {
            addCriterion("gc_by_xh is not null");
            return (Criteria) this;
        }

        public Criteria andGcByXhEqualTo(BigDecimal value) {
            addCriterion("gc_by_xh =", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhNotEqualTo(BigDecimal value) {
            addCriterion("gc_by_xh <>", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhGreaterThan(BigDecimal value) {
            addCriterion("gc_by_xh >", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_by_xh >=", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhLessThan(BigDecimal value) {
            addCriterion("gc_by_xh <", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_by_xh <=", value, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhIn(List<BigDecimal> values) {
            addCriterion("gc_by_xh in", values, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhNotIn(List<BigDecimal> values) {
            addCriterion("gc_by_xh not in", values, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_by_xh between", value1, value2, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcByXhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_by_xh not between", value1, value2, "gcByXh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhIsNull() {
            addCriterion("gc_jzby_ljxh is null");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhIsNotNull() {
            addCriterion("gc_jzby_ljxh is not null");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhEqualTo(BigDecimal value) {
            addCriterion("gc_jzby_ljxh =", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhNotEqualTo(BigDecimal value) {
            addCriterion("gc_jzby_ljxh <>", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhGreaterThan(BigDecimal value) {
            addCriterion("gc_jzby_ljxh >", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_jzby_ljxh >=", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhLessThan(BigDecimal value) {
            addCriterion("gc_jzby_ljxh <", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_jzby_ljxh <=", value, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhIn(List<BigDecimal> values) {
            addCriterion("gc_jzby_ljxh in", values, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhNotIn(List<BigDecimal> values) {
            addCriterion("gc_jzby_ljxh not in", values, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_jzby_ljxh between", value1, value2, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andGcJzbyLjxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_jzby_ljxh not between", value1, value2, "gcJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyByXhIsNull() {
            addCriterion("ry_by_xh is null");
            return (Criteria) this;
        }

        public Criteria andRyByXhIsNotNull() {
            addCriterion("ry_by_xh is not null");
            return (Criteria) this;
        }

        public Criteria andRyByXhEqualTo(BigDecimal value) {
            addCriterion("ry_by_xh =", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhNotEqualTo(BigDecimal value) {
            addCriterion("ry_by_xh <>", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhGreaterThan(BigDecimal value) {
            addCriterion("ry_by_xh >", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_by_xh >=", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhLessThan(BigDecimal value) {
            addCriterion("ry_by_xh <", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_by_xh <=", value, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhIn(List<BigDecimal> values) {
            addCriterion("ry_by_xh in", values, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhNotIn(List<BigDecimal> values) {
            addCriterion("ry_by_xh not in", values, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_by_xh between", value1, value2, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyByXhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_by_xh not between", value1, value2, "ryByXh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhIsNull() {
            addCriterion("ry_jzby_ljxh is null");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhIsNotNull() {
            addCriterion("ry_jzby_ljxh is not null");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhEqualTo(BigDecimal value) {
            addCriterion("ry_jzby_ljxh =", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhNotEqualTo(BigDecimal value) {
            addCriterion("ry_jzby_ljxh <>", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhGreaterThan(BigDecimal value) {
            addCriterion("ry_jzby_ljxh >", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_jzby_ljxh >=", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhLessThan(BigDecimal value) {
            addCriterion("ry_jzby_ljxh <", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_jzby_ljxh <=", value, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhIn(List<BigDecimal> values) {
            addCriterion("ry_jzby_ljxh in", values, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhNotIn(List<BigDecimal> values) {
            addCriterion("ry_jzby_ljxh not in", values, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_jzby_ljxh between", value1, value2, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andRyJzbyLjxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_jzby_ljxh not between", value1, value2, "ryJzbyLjxh");
            return (Criteria) this;
        }

        public Criteria andShByXhIsNull() {
            addCriterion("sh_by_xh is null");
            return (Criteria) this;
        }

        public Criteria andShByXhIsNotNull() {
            addCriterion("sh_by_xh is not null");
            return (Criteria) this;
        }

        public Criteria andShByXhEqualTo(BigDecimal value) {
            addCriterion("sh_by_xh =", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhNotEqualTo(BigDecimal value) {
            addCriterion("sh_by_xh <>", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhGreaterThan(BigDecimal value) {
            addCriterion("sh_by_xh >", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_xh >=", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhLessThan(BigDecimal value) {
            addCriterion("sh_by_xh <", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_xh <=", value, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhIn(List<BigDecimal> values) {
            addCriterion("sh_by_xh in", values, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhNotIn(List<BigDecimal> values) {
            addCriterion("sh_by_xh not in", values, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_xh between", value1, value2, "shByXh");
            return (Criteria) this;
        }

        public Criteria andShByXhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_xh not between", value1, value2, "shByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhIsNull() {
            addCriterion("lq_by_xh is null");
            return (Criteria) this;
        }

        public Criteria andLqByXhIsNotNull() {
            addCriterion("lq_by_xh is not null");
            return (Criteria) this;
        }

        public Criteria andLqByXhEqualTo(BigDecimal value) {
            addCriterion("lq_by_xh =", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhNotEqualTo(BigDecimal value) {
            addCriterion("lq_by_xh <>", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhGreaterThan(BigDecimal value) {
            addCriterion("lq_by_xh >", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_by_xh >=", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhLessThan(BigDecimal value) {
            addCriterion("lq_by_xh <", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_by_xh <=", value, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhIn(List<BigDecimal> values) {
            addCriterion("lq_by_xh in", values, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhNotIn(List<BigDecimal> values) {
            addCriterion("lq_by_xh not in", values, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_by_xh between", value1, value2, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andLqByXhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_by_xh not between", value1, value2, "lqByXh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhIsNull() {
            addCriterion("sh_by_ljxh is null");
            return (Criteria) this;
        }

        public Criteria andShByLjxhIsNotNull() {
            addCriterion("sh_by_ljxh is not null");
            return (Criteria) this;
        }

        public Criteria andShByLjxhEqualTo(BigDecimal value) {
            addCriterion("sh_by_ljxh =", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhNotEqualTo(BigDecimal value) {
            addCriterion("sh_by_ljxh <>", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhGreaterThan(BigDecimal value) {
            addCriterion("sh_by_ljxh >", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_ljxh >=", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhLessThan(BigDecimal value) {
            addCriterion("sh_by_ljxh <", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_ljxh <=", value, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhIn(List<BigDecimal> values) {
            addCriterion("sh_by_ljxh in", values, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhNotIn(List<BigDecimal> values) {
            addCriterion("sh_by_ljxh not in", values, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_ljxh between", value1, value2, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andShByLjxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_ljxh not between", value1, value2, "shByLjxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhIsNull() {
            addCriterion("lq_by_zkgljxh is null");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhIsNotNull() {
            addCriterion("lq_by_zkgljxh is not null");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhEqualTo(BigDecimal value) {
            addCriterion("lq_by_zkgljxh =", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhNotEqualTo(BigDecimal value) {
            addCriterion("lq_by_zkgljxh <>", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhGreaterThan(BigDecimal value) {
            addCriterion("lq_by_zkgljxh >", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_by_zkgljxh >=", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhLessThan(BigDecimal value) {
            addCriterion("lq_by_zkgljxh <", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lq_by_zkgljxh <=", value, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhIn(List<BigDecimal> values) {
            addCriterion("lq_by_zkgljxh in", values, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhNotIn(List<BigDecimal> values) {
            addCriterion("lq_by_zkgljxh not in", values, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_by_zkgljxh between", value1, value2, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andLqByZkgljxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lq_by_zkgljxh not between", value1, value2, "lqByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhIsNull() {
            addCriterion("sn_by_zkgljxh is null");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhIsNotNull() {
            addCriterion("sn_by_zkgljxh is not null");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhEqualTo(BigDecimal value) {
            addCriterion("sn_by_zkgljxh =", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhNotEqualTo(BigDecimal value) {
            addCriterion("sn_by_zkgljxh <>", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhGreaterThan(BigDecimal value) {
            addCriterion("sn_by_zkgljxh >", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_by_zkgljxh >=", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhLessThan(BigDecimal value) {
            addCriterion("sn_by_zkgljxh <", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sn_by_zkgljxh <=", value, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhIn(List<BigDecimal> values) {
            addCriterion("sn_by_zkgljxh in", values, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhNotIn(List<BigDecimal> values) {
            addCriterion("sn_by_zkgljxh not in", values, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_by_zkgljxh between", value1, value2, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andSnByZkgljxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sn_by_zkgljxh not between", value1, value2, "snByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhIsNull() {
            addCriterion("gc_by_zkgljxh is null");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhIsNotNull() {
            addCriterion("gc_by_zkgljxh is not null");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhEqualTo(BigDecimal value) {
            addCriterion("gc_by_zkgljxh =", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhNotEqualTo(BigDecimal value) {
            addCriterion("gc_by_zkgljxh <>", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhGreaterThan(BigDecimal value) {
            addCriterion("gc_by_zkgljxh >", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_by_zkgljxh >=", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhLessThan(BigDecimal value) {
            addCriterion("gc_by_zkgljxh <", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gc_by_zkgljxh <=", value, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhIn(List<BigDecimal> values) {
            addCriterion("gc_by_zkgljxh in", values, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhNotIn(List<BigDecimal> values) {
            addCriterion("gc_by_zkgljxh not in", values, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_by_zkgljxh between", value1, value2, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andGcByZkgljxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gc_by_zkgljxh not between", value1, value2, "gcByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhIsNull() {
            addCriterion("ry_by_zkgljxh is null");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhIsNotNull() {
            addCriterion("ry_by_zkgljxh is not null");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhEqualTo(BigDecimal value) {
            addCriterion("ry_by_zkgljxh =", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhNotEqualTo(BigDecimal value) {
            addCriterion("ry_by_zkgljxh <>", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhGreaterThan(BigDecimal value) {
            addCriterion("ry_by_zkgljxh >", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_by_zkgljxh >=", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhLessThan(BigDecimal value) {
            addCriterion("ry_by_zkgljxh <", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ry_by_zkgljxh <=", value, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhIn(List<BigDecimal> values) {
            addCriterion("ry_by_zkgljxh in", values, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhNotIn(List<BigDecimal> values) {
            addCriterion("ry_by_zkgljxh not in", values, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_by_zkgljxh between", value1, value2, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andRyByZkgljxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ry_by_zkgljxh not between", value1, value2, "ryByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhIsNull() {
            addCriterion("sh_by_zkgljxh is null");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhIsNotNull() {
            addCriterion("sh_by_zkgljxh is not null");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhEqualTo(BigDecimal value) {
            addCriterion("sh_by_zkgljxh =", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhNotEqualTo(BigDecimal value) {
            addCriterion("sh_by_zkgljxh <>", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhGreaterThan(BigDecimal value) {
            addCriterion("sh_by_zkgljxh >", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_zkgljxh >=", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhLessThan(BigDecimal value) {
            addCriterion("sh_by_zkgljxh <", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sh_by_zkgljxh <=", value, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhIn(List<BigDecimal> values) {
            addCriterion("sh_by_zkgljxh in", values, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhNotIn(List<BigDecimal> values) {
            addCriterion("sh_by_zkgljxh not in", values, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_zkgljxh between", value1, value2, "shByZkgljxh");
            return (Criteria) this;
        }

        public Criteria andShByZkgljxhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sh_by_zkgljxh not between", value1, value2, "shByZkgljxh");
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