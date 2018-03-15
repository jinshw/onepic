package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsPlanTzkz03Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz03Example() {
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

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("item like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("item not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("item not between", value1, value2, "item");
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

        public Criteria andGspfJineIsNull() {
            addCriterion("gspf_jine is null");
            return (Criteria) this;
        }

        public Criteria andGspfJineIsNotNull() {
            addCriterion("gspf_jine is not null");
            return (Criteria) this;
        }

        public Criteria andGspfJineEqualTo(BigDecimal value) {
            addCriterion("gspf_jine =", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineNotEqualTo(BigDecimal value) {
            addCriterion("gspf_jine <>", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineGreaterThan(BigDecimal value) {
            addCriterion("gspf_jine >", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gspf_jine >=", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineLessThan(BigDecimal value) {
            addCriterion("gspf_jine <", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gspf_jine <=", value, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineIn(List<BigDecimal> values) {
            addCriterion("gspf_jine in", values, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineNotIn(List<BigDecimal> values) {
            addCriterion("gspf_jine not in", values, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gspf_jine between", value1, value2, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andGspfJineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gspf_jine not between", value1, value2, "gspfJine");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzIsNull() {
            addCriterion("lastyear_wctz is null");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzIsNotNull() {
            addCriterion("lastyear_wctz is not null");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzEqualTo(BigDecimal value) {
            addCriterion("lastyear_wctz =", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzNotEqualTo(BigDecimal value) {
            addCriterion("lastyear_wctz <>", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzGreaterThan(BigDecimal value) {
            addCriterion("lastyear_wctz >", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lastyear_wctz >=", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzLessThan(BigDecimal value) {
            addCriterion("lastyear_wctz <", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lastyear_wctz <=", value, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzIn(List<BigDecimal> values) {
            addCriterion("lastyear_wctz in", values, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzNotIn(List<BigDecimal> values) {
            addCriterion("lastyear_wctz not in", values, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lastyear_wctz between", value1, value2, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andLastyearWctzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lastyear_wctz not between", value1, value2, "lastyearWctz");
            return (Criteria) this;
        }

        public Criteria andBnKhjhIsNull() {
            addCriterion("bn_khjh is null");
            return (Criteria) this;
        }

        public Criteria andBnKhjhIsNotNull() {
            addCriterion("bn_khjh is not null");
            return (Criteria) this;
        }

        public Criteria andBnKhjhEqualTo(BigDecimal value) {
            addCriterion("bn_khjh =", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhNotEqualTo(BigDecimal value) {
            addCriterion("bn_khjh <>", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhGreaterThan(BigDecimal value) {
            addCriterion("bn_khjh >", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bn_khjh >=", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhLessThan(BigDecimal value) {
            addCriterion("bn_khjh <", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bn_khjh <=", value, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhIn(List<BigDecimal> values) {
            addCriterion("bn_khjh in", values, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhNotIn(List<BigDecimal> values) {
            addCriterion("bn_khjh not in", values, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bn_khjh between", value1, value2, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andBnKhjhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bn_khjh not between", value1, value2, "bnKhjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhIsNull() {
            addCriterion("by_fjjh is null");
            return (Criteria) this;
        }

        public Criteria andByFjjhIsNotNull() {
            addCriterion("by_fjjh is not null");
            return (Criteria) this;
        }

        public Criteria andByFjjhEqualTo(BigDecimal value) {
            addCriterion("by_fjjh =", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhNotEqualTo(BigDecimal value) {
            addCriterion("by_fjjh <>", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhGreaterThan(BigDecimal value) {
            addCriterion("by_fjjh >", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("by_fjjh >=", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhLessThan(BigDecimal value) {
            addCriterion("by_fjjh <", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("by_fjjh <=", value, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhIn(List<BigDecimal> values) {
            addCriterion("by_fjjh in", values, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhNotIn(List<BigDecimal> values) {
            addCriterion("by_fjjh not in", values, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_fjjh between", value1, value2, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByFjjhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_fjjh not between", value1, value2, "byFjjh");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczIsNull() {
            addCriterion("by_wctz_sjcz is null");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczIsNotNull() {
            addCriterion("by_wctz_sjcz is not null");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczEqualTo(BigDecimal value) {
            addCriterion("by_wctz_sjcz =", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczNotEqualTo(BigDecimal value) {
            addCriterion("by_wctz_sjcz <>", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczGreaterThan(BigDecimal value) {
            addCriterion("by_wctz_sjcz >", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("by_wctz_sjcz >=", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczLessThan(BigDecimal value) {
            addCriterion("by_wctz_sjcz <", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczLessThanOrEqualTo(BigDecimal value) {
            addCriterion("by_wctz_sjcz <=", value, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczIn(List<BigDecimal> values) {
            addCriterion("by_wctz_sjcz in", values, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczNotIn(List<BigDecimal> values) {
            addCriterion("by_wctz_sjcz not in", values, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_wctz_sjcz between", value1, value2, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzSjczNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_wctz_sjcz not between", value1, value2, "byWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsIsNull() {
            addCriterion("by_wctz_zhgs is null");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsIsNotNull() {
            addCriterion("by_wctz_zhgs is not null");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsEqualTo(BigDecimal value) {
            addCriterion("by_wctz_zhgs =", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsNotEqualTo(BigDecimal value) {
            addCriterion("by_wctz_zhgs <>", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsGreaterThan(BigDecimal value) {
            addCriterion("by_wctz_zhgs >", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("by_wctz_zhgs >=", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsLessThan(BigDecimal value) {
            addCriterion("by_wctz_zhgs <", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("by_wctz_zhgs <=", value, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsIn(List<BigDecimal> values) {
            addCriterion("by_wctz_zhgs in", values, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsNotIn(List<BigDecimal> values) {
            addCriterion("by_wctz_zhgs not in", values, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_wctz_zhgs between", value1, value2, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andByWctzZhgsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_wctz_zhgs not between", value1, value2, "byWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczIsNull() {
            addCriterion("zby_wctz_sjcz is null");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczIsNotNull() {
            addCriterion("zby_wctz_sjcz is not null");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_sjcz =", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczNotEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_sjcz <>", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczGreaterThan(BigDecimal value) {
            addCriterion("zby_wctz_sjcz >", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_sjcz >=", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczLessThan(BigDecimal value) {
            addCriterion("zby_wctz_sjcz <", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_sjcz <=", value, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczIn(List<BigDecimal> values) {
            addCriterion("zby_wctz_sjcz in", values, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczNotIn(List<BigDecimal> values) {
            addCriterion("zby_wctz_sjcz not in", values, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zby_wctz_sjcz between", value1, value2, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzSjczNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zby_wctz_sjcz not between", value1, value2, "zbyWctzSjcz");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsIsNull() {
            addCriterion("zby_wctz_zhgs is null");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsIsNotNull() {
            addCriterion("zby_wctz_zhgs is not null");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_zhgs =", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsNotEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_zhgs <>", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsGreaterThan(BigDecimal value) {
            addCriterion("zby_wctz_zhgs >", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_zhgs >=", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsLessThan(BigDecimal value) {
            addCriterion("zby_wctz_zhgs <", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zby_wctz_zhgs <=", value, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsIn(List<BigDecimal> values) {
            addCriterion("zby_wctz_zhgs in", values, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsNotIn(List<BigDecimal> values) {
            addCriterion("zby_wctz_zhgs not in", values, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zby_wctz_zhgs between", value1, value2, "zbyWctzZhgs");
            return (Criteria) this;
        }

        public Criteria andZbyWctzZhgsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zby_wctz_zhgs not between", value1, value2, "zbyWctzZhgs");
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
            addCriterionForJDBCDate("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterionForJDBCDate("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterionForJDBCDate("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("inserttime not between", value1, value2, "inserttime");
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