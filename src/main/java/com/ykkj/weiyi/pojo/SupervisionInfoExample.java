package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SupervisionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupervisionInfoExample() {
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

        public Criteria andDirectIdIsNull() {
            addCriterion("direct_id is null");
            return (Criteria) this;
        }

        public Criteria andDirectIdIsNotNull() {
            addCriterion("direct_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirectIdEqualTo(String value) {
            addCriterion("direct_id =", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdNotEqualTo(String value) {
            addCriterion("direct_id <>", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdGreaterThan(String value) {
            addCriterion("direct_id >", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdGreaterThanOrEqualTo(String value) {
            addCriterion("direct_id >=", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdLessThan(String value) {
            addCriterion("direct_id <", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdLessThanOrEqualTo(String value) {
            addCriterion("direct_id <=", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdLike(String value) {
            addCriterion("direct_id like", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdNotLike(String value) {
            addCriterion("direct_id not like", value, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdIn(List<String> values) {
            addCriterion("direct_id in", values, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdNotIn(List<String> values) {
            addCriterion("direct_id not in", values, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdBetween(String value1, String value2) {
            addCriterion("direct_id between", value1, value2, "directId");
            return (Criteria) this;
        }

        public Criteria andDirectIdNotBetween(String value1, String value2) {
            addCriterion("direct_id not between", value1, value2, "directId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdIsNull() {
            addCriterion("sys_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdIsNotNull() {
            addCriterion("sys_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdEqualTo(String value) {
            addCriterion("sys_dept_id =", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdNotEqualTo(String value) {
            addCriterion("sys_dept_id <>", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdGreaterThan(String value) {
            addCriterion("sys_dept_id >", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_dept_id >=", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdLessThan(String value) {
            addCriterion("sys_dept_id <", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdLessThanOrEqualTo(String value) {
            addCriterion("sys_dept_id <=", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdLike(String value) {
            addCriterion("sys_dept_id like", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdNotLike(String value) {
            addCriterion("sys_dept_id not like", value, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdIn(List<String> values) {
            addCriterion("sys_dept_id in", values, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdNotIn(List<String> values) {
            addCriterion("sys_dept_id not in", values, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdBetween(String value1, String value2) {
            addCriterion("sys_dept_id between", value1, value2, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSysDeptIdNotBetween(String value1, String value2) {
            addCriterion("sys_dept_id not between", value1, value2, "sysDeptId");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoIsNull() {
            addCriterion("supervision_no is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoIsNotNull() {
            addCriterion("supervision_no is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoEqualTo(String value) {
            addCriterion("supervision_no =", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoNotEqualTo(String value) {
            addCriterion("supervision_no <>", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoGreaterThan(String value) {
            addCriterion("supervision_no >", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_no >=", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoLessThan(String value) {
            addCriterion("supervision_no <", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoLessThanOrEqualTo(String value) {
            addCriterion("supervision_no <=", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoLike(String value) {
            addCriterion("supervision_no like", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoNotLike(String value) {
            addCriterion("supervision_no not like", value, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoIn(List<String> values) {
            addCriterion("supervision_no in", values, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoNotIn(List<String> values) {
            addCriterion("supervision_no not in", values, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoBetween(String value1, String value2) {
            addCriterion("supervision_no between", value1, value2, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionNoNotBetween(String value1, String value2) {
            addCriterion("supervision_no not between", value1, value2, "supervisionNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameIsNull() {
            addCriterion("supervision_short_name is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameIsNotNull() {
            addCriterion("supervision_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameEqualTo(String value) {
            addCriterion("supervision_short_name =", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameNotEqualTo(String value) {
            addCriterion("supervision_short_name <>", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameGreaterThan(String value) {
            addCriterion("supervision_short_name >", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_short_name >=", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameLessThan(String value) {
            addCriterion("supervision_short_name <", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameLessThanOrEqualTo(String value) {
            addCriterion("supervision_short_name <=", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameLike(String value) {
            addCriterion("supervision_short_name like", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameNotLike(String value) {
            addCriterion("supervision_short_name not like", value, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameIn(List<String> values) {
            addCriterion("supervision_short_name in", values, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameNotIn(List<String> values) {
            addCriterion("supervision_short_name not in", values, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameBetween(String value1, String value2) {
            addCriterion("supervision_short_name between", value1, value2, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionShortNameNotBetween(String value1, String value2) {
            addCriterion("supervision_short_name not between", value1, value2, "supervisionShortName");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddIsNull() {
            addCriterion("supervision_add is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddIsNotNull() {
            addCriterion("supervision_add is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddEqualTo(String value) {
            addCriterion("supervision_add =", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddNotEqualTo(String value) {
            addCriterion("supervision_add <>", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddGreaterThan(String value) {
            addCriterion("supervision_add >", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_add >=", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddLessThan(String value) {
            addCriterion("supervision_add <", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddLessThanOrEqualTo(String value) {
            addCriterion("supervision_add <=", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddLike(String value) {
            addCriterion("supervision_add like", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddNotLike(String value) {
            addCriterion("supervision_add not like", value, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddIn(List<String> values) {
            addCriterion("supervision_add in", values, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddNotIn(List<String> values) {
            addCriterion("supervision_add not in", values, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddBetween(String value1, String value2) {
            addCriterion("supervision_add between", value1, value2, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andSupervisionAddNotBetween(String value1, String value2) {
            addCriterion("supervision_add not between", value1, value2, "supervisionAdd");
            return (Criteria) this;
        }

        public Criteria andServicePeriodIsNull() {
            addCriterion("service_period is null");
            return (Criteria) this;
        }

        public Criteria andServicePeriodIsNotNull() {
            addCriterion("service_period is not null");
            return (Criteria) this;
        }

        public Criteria andServicePeriodEqualTo(String value) {
            addCriterion("service_period =", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodNotEqualTo(String value) {
            addCriterion("service_period <>", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodGreaterThan(String value) {
            addCriterion("service_period >", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("service_period >=", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodLessThan(String value) {
            addCriterion("service_period <", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodLessThanOrEqualTo(String value) {
            addCriterion("service_period <=", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodLike(String value) {
            addCriterion("service_period like", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodNotLike(String value) {
            addCriterion("service_period not like", value, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodIn(List<String> values) {
            addCriterion("service_period in", values, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodNotIn(List<String> values) {
            addCriterion("service_period not in", values, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodBetween(String value1, String value2) {
            addCriterion("service_period between", value1, value2, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andServicePeriodNotBetween(String value1, String value2) {
            addCriterion("service_period not between", value1, value2, "servicePeriod");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNull() {
            addCriterion("director_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNotNull() {
            addCriterion("director_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameEqualTo(String value) {
            addCriterion("director_name =", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotEqualTo(String value) {
            addCriterion("director_name <>", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThan(String value) {
            addCriterion("director_name >", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThanOrEqualTo(String value) {
            addCriterion("director_name >=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThan(String value) {
            addCriterion("director_name <", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThanOrEqualTo(String value) {
            addCriterion("director_name <=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLike(String value) {
            addCriterion("director_name like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotLike(String value) {
            addCriterion("director_name not like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIn(List<String> values) {
            addCriterion("director_name in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotIn(List<String> values) {
            addCriterion("director_name not in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameBetween(String value1, String value2) {
            addCriterion("director_name between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotBetween(String value1, String value2) {
            addCriterion("director_name not between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorTelIsNull() {
            addCriterion("director_tel is null");
            return (Criteria) this;
        }

        public Criteria andDirectorTelIsNotNull() {
            addCriterion("director_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorTelEqualTo(String value) {
            addCriterion("director_tel =", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelNotEqualTo(String value) {
            addCriterion("director_tel <>", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelGreaterThan(String value) {
            addCriterion("director_tel >", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelGreaterThanOrEqualTo(String value) {
            addCriterion("director_tel >=", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelLessThan(String value) {
            addCriterion("director_tel <", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelLessThanOrEqualTo(String value) {
            addCriterion("director_tel <=", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelLike(String value) {
            addCriterion("director_tel like", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelNotLike(String value) {
            addCriterion("director_tel not like", value, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelIn(List<String> values) {
            addCriterion("director_tel in", values, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelNotIn(List<String> values) {
            addCriterion("director_tel not in", values, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelBetween(String value1, String value2) {
            addCriterion("director_tel between", value1, value2, "directorTel");
            return (Criteria) this;
        }

        public Criteria andDirectorTelNotBetween(String value1, String value2) {
            addCriterion("director_tel not between", value1, value2, "directorTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelIsNull() {
            addCriterion("supervision_tel is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelIsNotNull() {
            addCriterion("supervision_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelEqualTo(String value) {
            addCriterion("supervision_tel =", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelNotEqualTo(String value) {
            addCriterion("supervision_tel <>", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelGreaterThan(String value) {
            addCriterion("supervision_tel >", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_tel >=", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelLessThan(String value) {
            addCriterion("supervision_tel <", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelLessThanOrEqualTo(String value) {
            addCriterion("supervision_tel <=", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelLike(String value) {
            addCriterion("supervision_tel like", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelNotLike(String value) {
            addCriterion("supervision_tel not like", value, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelIn(List<String> values) {
            addCriterion("supervision_tel in", values, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelNotIn(List<String> values) {
            addCriterion("supervision_tel not in", values, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelBetween(String value1, String value2) {
            addCriterion("supervision_tel between", value1, value2, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSupervisionTelNotBetween(String value1, String value2) {
            addCriterion("supervision_tel not between", value1, value2, "supervisionTel");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointIsNull() {
            addCriterion("sect_begin_point is null");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointIsNotNull() {
            addCriterion("sect_begin_point is not null");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointEqualTo(String value) {
            addCriterion("sect_begin_point =", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointNotEqualTo(String value) {
            addCriterion("sect_begin_point <>", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointGreaterThan(String value) {
            addCriterion("sect_begin_point >", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointGreaterThanOrEqualTo(String value) {
            addCriterion("sect_begin_point >=", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointLessThan(String value) {
            addCriterion("sect_begin_point <", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointLessThanOrEqualTo(String value) {
            addCriterion("sect_begin_point <=", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointLike(String value) {
            addCriterion("sect_begin_point like", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointNotLike(String value) {
            addCriterion("sect_begin_point not like", value, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointIn(List<String> values) {
            addCriterion("sect_begin_point in", values, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointNotIn(List<String> values) {
            addCriterion("sect_begin_point not in", values, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointBetween(String value1, String value2) {
            addCriterion("sect_begin_point between", value1, value2, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectBeginPointNotBetween(String value1, String value2) {
            addCriterion("sect_begin_point not between", value1, value2, "sectBeginPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointIsNull() {
            addCriterion("sect_end_point is null");
            return (Criteria) this;
        }

        public Criteria andSectEndPointIsNotNull() {
            addCriterion("sect_end_point is not null");
            return (Criteria) this;
        }

        public Criteria andSectEndPointEqualTo(String value) {
            addCriterion("sect_end_point =", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointNotEqualTo(String value) {
            addCriterion("sect_end_point <>", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointGreaterThan(String value) {
            addCriterion("sect_end_point >", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointGreaterThanOrEqualTo(String value) {
            addCriterion("sect_end_point >=", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointLessThan(String value) {
            addCriterion("sect_end_point <", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointLessThanOrEqualTo(String value) {
            addCriterion("sect_end_point <=", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointLike(String value) {
            addCriterion("sect_end_point like", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointNotLike(String value) {
            addCriterion("sect_end_point not like", value, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointIn(List<String> values) {
            addCriterion("sect_end_point in", values, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointNotIn(List<String> values) {
            addCriterion("sect_end_point not in", values, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointBetween(String value1, String value2) {
            addCriterion("sect_end_point between", value1, value2, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andSectEndPointNotBetween(String value1, String value2) {
            addCriterion("sect_end_point not between", value1, value2, "sectEndPoint");
            return (Criteria) this;
        }

        public Criteria andUploadIdIsNull() {
            addCriterion("upload_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadIdIsNotNull() {
            addCriterion("upload_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIdEqualTo(String value) {
            addCriterion("upload_id =", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotEqualTo(String value) {
            addCriterion("upload_id <>", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdGreaterThan(String value) {
            addCriterion("upload_id >", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdGreaterThanOrEqualTo(String value) {
            addCriterion("upload_id >=", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdLessThan(String value) {
            addCriterion("upload_id <", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdLessThanOrEqualTo(String value) {
            addCriterion("upload_id <=", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdLike(String value) {
            addCriterion("upload_id like", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotLike(String value) {
            addCriterion("upload_id not like", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdIn(List<String> values) {
            addCriterion("upload_id in", values, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotIn(List<String> values) {
            addCriterion("upload_id not in", values, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdBetween(String value1, String value2) {
            addCriterion("upload_id between", value1, value2, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotBetween(String value1, String value2) {
            addCriterion("upload_id not between", value1, value2, "uploadId");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoIsNull() {
            addCriterion("supervision_pact_no is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoIsNotNull() {
            addCriterion("supervision_pact_no is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoEqualTo(String value) {
            addCriterion("supervision_pact_no =", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoNotEqualTo(String value) {
            addCriterion("supervision_pact_no <>", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoGreaterThan(String value) {
            addCriterion("supervision_pact_no >", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_pact_no >=", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoLessThan(String value) {
            addCriterion("supervision_pact_no <", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoLessThanOrEqualTo(String value) {
            addCriterion("supervision_pact_no <=", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoLike(String value) {
            addCriterion("supervision_pact_no like", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoNotLike(String value) {
            addCriterion("supervision_pact_no not like", value, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoIn(List<String> values) {
            addCriterion("supervision_pact_no in", values, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoNotIn(List<String> values) {
            addCriterion("supervision_pact_no not in", values, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoBetween(String value1, String value2) {
            addCriterion("supervision_pact_no between", value1, value2, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andSupervisionPactNoNotBetween(String value1, String value2) {
            addCriterion("supervision_pact_no not between", value1, value2, "supervisionPactNo");
            return (Criteria) this;
        }

        public Criteria andPactMoneyIsNull() {
            addCriterion("pact_money is null");
            return (Criteria) this;
        }

        public Criteria andPactMoneyIsNotNull() {
            addCriterion("pact_money is not null");
            return (Criteria) this;
        }

        public Criteria andPactMoneyEqualTo(BigDecimal value) {
            addCriterion("pact_money =", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyNotEqualTo(BigDecimal value) {
            addCriterion("pact_money <>", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyGreaterThan(BigDecimal value) {
            addCriterion("pact_money >", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pact_money >=", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyLessThan(BigDecimal value) {
            addCriterion("pact_money <", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pact_money <=", value, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyIn(List<BigDecimal> values) {
            addCriterion("pact_money in", values, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyNotIn(List<BigDecimal> values) {
            addCriterion("pact_money not in", values, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pact_money between", value1, value2, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pact_money not between", value1, value2, "pactMoney");
            return (Criteria) this;
        }

        public Criteria andPactPeriodIsNull() {
            addCriterion("pact_period is null");
            return (Criteria) this;
        }

        public Criteria andPactPeriodIsNotNull() {
            addCriterion("pact_period is not null");
            return (Criteria) this;
        }

        public Criteria andPactPeriodEqualTo(String value) {
            addCriterion("pact_period =", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodNotEqualTo(String value) {
            addCriterion("pact_period <>", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodGreaterThan(String value) {
            addCriterion("pact_period >", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("pact_period >=", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodLessThan(String value) {
            addCriterion("pact_period <", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodLessThanOrEqualTo(String value) {
            addCriterion("pact_period <=", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodLike(String value) {
            addCriterion("pact_period like", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodNotLike(String value) {
            addCriterion("pact_period not like", value, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodIn(List<String> values) {
            addCriterion("pact_period in", values, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodNotIn(List<String> values) {
            addCriterion("pact_period not in", values, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodBetween(String value1, String value2) {
            addCriterion("pact_period between", value1, value2, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andPactPeriodNotBetween(String value1, String value2) {
            addCriterion("pact_period not between", value1, value2, "pactPeriod");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("bank_no in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("bank_no not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAIsNull() {
            addCriterion("superv_property_a is null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAIsNotNull() {
            addCriterion("superv_property_a is not null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAEqualTo(String value) {
            addCriterion("superv_property_a =", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyANotEqualTo(String value) {
            addCriterion("superv_property_a <>", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAGreaterThan(String value) {
            addCriterion("superv_property_a >", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAGreaterThanOrEqualTo(String value) {
            addCriterion("superv_property_a >=", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyALessThan(String value) {
            addCriterion("superv_property_a <", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyALessThanOrEqualTo(String value) {
            addCriterion("superv_property_a <=", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyALike(String value) {
            addCriterion("superv_property_a like", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyANotLike(String value) {
            addCriterion("superv_property_a not like", value, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyAIn(List<String> values) {
            addCriterion("superv_property_a in", values, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyANotIn(List<String> values) {
            addCriterion("superv_property_a not in", values, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyABetween(String value1, String value2) {
            addCriterion("superv_property_a between", value1, value2, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyANotBetween(String value1, String value2) {
            addCriterion("superv_property_a not between", value1, value2, "supervPropertyA");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBIsNull() {
            addCriterion("superv_property_b is null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBIsNotNull() {
            addCriterion("superv_property_b is not null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBEqualTo(String value) {
            addCriterion("superv_property_b =", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBNotEqualTo(String value) {
            addCriterion("superv_property_b <>", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBGreaterThan(String value) {
            addCriterion("superv_property_b >", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBGreaterThanOrEqualTo(String value) {
            addCriterion("superv_property_b >=", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBLessThan(String value) {
            addCriterion("superv_property_b <", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBLessThanOrEqualTo(String value) {
            addCriterion("superv_property_b <=", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBLike(String value) {
            addCriterion("superv_property_b like", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBNotLike(String value) {
            addCriterion("superv_property_b not like", value, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBIn(List<String> values) {
            addCriterion("superv_property_b in", values, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBNotIn(List<String> values) {
            addCriterion("superv_property_b not in", values, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBBetween(String value1, String value2) {
            addCriterion("superv_property_b between", value1, value2, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyBNotBetween(String value1, String value2) {
            addCriterion("superv_property_b not between", value1, value2, "supervPropertyB");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCIsNull() {
            addCriterion("superv_property_c is null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCIsNotNull() {
            addCriterion("superv_property_c is not null");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCEqualTo(String value) {
            addCriterion("superv_property_c =", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCNotEqualTo(String value) {
            addCriterion("superv_property_c <>", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCGreaterThan(String value) {
            addCriterion("superv_property_c >", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCGreaterThanOrEqualTo(String value) {
            addCriterion("superv_property_c >=", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCLessThan(String value) {
            addCriterion("superv_property_c <", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCLessThanOrEqualTo(String value) {
            addCriterion("superv_property_c <=", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCLike(String value) {
            addCriterion("superv_property_c like", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCNotLike(String value) {
            addCriterion("superv_property_c not like", value, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCIn(List<String> values) {
            addCriterion("superv_property_c in", values, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCNotIn(List<String> values) {
            addCriterion("superv_property_c not in", values, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCBetween(String value1, String value2) {
            addCriterion("superv_property_c between", value1, value2, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSupervPropertyCNotBetween(String value1, String value2) {
            addCriterion("superv_property_c not between", value1, value2, "supervPropertyC");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNull() {
            addCriterion("sortorder is null");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNotNull() {
            addCriterion("sortorder is not null");
            return (Criteria) this;
        }

        public Criteria andSortorderEqualTo(Integer value) {
            addCriterion("sortorder =", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotEqualTo(Integer value) {
            addCriterion("sortorder <>", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThan(Integer value) {
            addCriterion("sortorder >", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortorder >=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThan(Integer value) {
            addCriterion("sortorder <", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThanOrEqualTo(Integer value) {
            addCriterion("sortorder <=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderIn(List<Integer> values) {
            addCriterion("sortorder in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotIn(List<Integer> values) {
            addCriterion("sortorder not in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderBetween(Integer value1, Integer value2) {
            addCriterion("sortorder between", value1, value2, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotBetween(Integer value1, Integer value2) {
            addCriterion("sortorder not between", value1, value2, "sortorder");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andZzhdjIsNull() {
            addCriterion("zzhdj is null");
            return (Criteria) this;
        }

        public Criteria andZzhdjIsNotNull() {
            addCriterion("zzhdj is not null");
            return (Criteria) this;
        }

        public Criteria andZzhdjEqualTo(String value) {
            addCriterion("zzhdj =", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjNotEqualTo(String value) {
            addCriterion("zzhdj <>", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjGreaterThan(String value) {
            addCriterion("zzhdj >", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjGreaterThanOrEqualTo(String value) {
            addCriterion("zzhdj >=", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjLessThan(String value) {
            addCriterion("zzhdj <", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjLessThanOrEqualTo(String value) {
            addCriterion("zzhdj <=", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjLike(String value) {
            addCriterion("zzhdj like", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjNotLike(String value) {
            addCriterion("zzhdj not like", value, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjIn(List<String> values) {
            addCriterion("zzhdj in", values, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjNotIn(List<String> values) {
            addCriterion("zzhdj not in", values, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjBetween(String value1, String value2) {
            addCriterion("zzhdj between", value1, value2, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZzhdjNotBetween(String value1, String value2) {
            addCriterion("zzhdj not between", value1, value2, "zzhdj");
            return (Criteria) this;
        }

        public Criteria andZhshhmIsNull() {
            addCriterion("zhshhm is null");
            return (Criteria) this;
        }

        public Criteria andZhshhmIsNotNull() {
            addCriterion("zhshhm is not null");
            return (Criteria) this;
        }

        public Criteria andZhshhmEqualTo(String value) {
            addCriterion("zhshhm =", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmNotEqualTo(String value) {
            addCriterion("zhshhm <>", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmGreaterThan(String value) {
            addCriterion("zhshhm >", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmGreaterThanOrEqualTo(String value) {
            addCriterion("zhshhm >=", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmLessThan(String value) {
            addCriterion("zhshhm <", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmLessThanOrEqualTo(String value) {
            addCriterion("zhshhm <=", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmLike(String value) {
            addCriterion("zhshhm like", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmNotLike(String value) {
            addCriterion("zhshhm not like", value, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmIn(List<String> values) {
            addCriterion("zhshhm in", values, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmNotIn(List<String> values) {
            addCriterion("zhshhm not in", values, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmBetween(String value1, String value2) {
            addCriterion("zhshhm between", value1, value2, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andZhshhmNotBetween(String value1, String value2) {
            addCriterion("zhshhm not between", value1, value2, "zhshhm");
            return (Criteria) this;
        }

        public Criteria andYyzhzhIsNull() {
            addCriterion("yyzhzh is null");
            return (Criteria) this;
        }

        public Criteria andYyzhzhIsNotNull() {
            addCriterion("yyzhzh is not null");
            return (Criteria) this;
        }

        public Criteria andYyzhzhEqualTo(String value) {
            addCriterion("yyzhzh =", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhNotEqualTo(String value) {
            addCriterion("yyzhzh <>", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhGreaterThan(String value) {
            addCriterion("yyzhzh >", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhGreaterThanOrEqualTo(String value) {
            addCriterion("yyzhzh >=", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhLessThan(String value) {
            addCriterion("yyzhzh <", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhLessThanOrEqualTo(String value) {
            addCriterion("yyzhzh <=", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhLike(String value) {
            addCriterion("yyzhzh like", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhNotLike(String value) {
            addCriterion("yyzhzh not like", value, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhIn(List<String> values) {
            addCriterion("yyzhzh in", values, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhNotIn(List<String> values) {
            addCriterion("yyzhzh not in", values, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhBetween(String value1, String value2) {
            addCriterion("yyzhzh between", value1, value2, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andYyzhzhNotBetween(String value1, String value2) {
            addCriterion("yyzhzh not between", value1, value2, "yyzhzh");
            return (Criteria) this;
        }

        public Criteria andChzhhmIsNull() {
            addCriterion("chzhhm is null");
            return (Criteria) this;
        }

        public Criteria andChzhhmIsNotNull() {
            addCriterion("chzhhm is not null");
            return (Criteria) this;
        }

        public Criteria andChzhhmEqualTo(String value) {
            addCriterion("chzhhm =", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmNotEqualTo(String value) {
            addCriterion("chzhhm <>", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmGreaterThan(String value) {
            addCriterion("chzhhm >", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmGreaterThanOrEqualTo(String value) {
            addCriterion("chzhhm >=", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmLessThan(String value) {
            addCriterion("chzhhm <", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmLessThanOrEqualTo(String value) {
            addCriterion("chzhhm <=", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmLike(String value) {
            addCriterion("chzhhm like", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmNotLike(String value) {
            addCriterion("chzhhm not like", value, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmIn(List<String> values) {
            addCriterion("chzhhm in", values, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmNotIn(List<String> values) {
            addCriterion("chzhhm not in", values, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmBetween(String value1, String value2) {
            addCriterion("chzhhm between", value1, value2, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andChzhhmNotBetween(String value1, String value2) {
            addCriterion("chzhhm not between", value1, value2, "chzhhm");
            return (Criteria) this;
        }

        public Criteria andZhgrshIsNull() {
            addCriterion("zhgrsh is null");
            return (Criteria) this;
        }

        public Criteria andZhgrshIsNotNull() {
            addCriterion("zhgrsh is not null");
            return (Criteria) this;
        }

        public Criteria andZhgrshEqualTo(Integer value) {
            addCriterion("zhgrsh =", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshNotEqualTo(Integer value) {
            addCriterion("zhgrsh <>", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshGreaterThan(Integer value) {
            addCriterion("zhgrsh >", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhgrsh >=", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshLessThan(Integer value) {
            addCriterion("zhgrsh <", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshLessThanOrEqualTo(Integer value) {
            addCriterion("zhgrsh <=", value, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshIn(List<Integer> values) {
            addCriterion("zhgrsh in", values, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshNotIn(List<Integer> values) {
            addCriterion("zhgrsh not in", values, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshBetween(Integer value1, Integer value2) {
            addCriterion("zhgrsh between", value1, value2, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhgrshNotBetween(Integer value1, Integer value2) {
            addCriterion("zhgrsh not between", value1, value2, "zhgrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshIsNull() {
            addCriterion("zhyjshrsh is null");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshIsNotNull() {
            addCriterion("zhyjshrsh is not null");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshEqualTo(Integer value) {
            addCriterion("zhyjshrsh =", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshNotEqualTo(Integer value) {
            addCriterion("zhyjshrsh <>", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshGreaterThan(Integer value) {
            addCriterion("zhyjshrsh >", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhyjshrsh >=", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshLessThan(Integer value) {
            addCriterion("zhyjshrsh <", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshLessThanOrEqualTo(Integer value) {
            addCriterion("zhyjshrsh <=", value, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshIn(List<Integer> values) {
            addCriterion("zhyjshrsh in", values, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshNotIn(List<Integer> values) {
            addCriterion("zhyjshrsh not in", values, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshBetween(Integer value1, Integer value2) {
            addCriterion("zhyjshrsh between", value1, value2, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andZhyjshrshNotBetween(Integer value1, Integer value2) {
            addCriterion("zhyjshrsh not between", value1, value2, "zhyjshrsh");
            return (Criteria) this;
        }

        public Criteria andYjdzhIsNull() {
            addCriterion("yjdzh is null");
            return (Criteria) this;
        }

        public Criteria andYjdzhIsNotNull() {
            addCriterion("yjdzh is not null");
            return (Criteria) this;
        }

        public Criteria andYjdzhEqualTo(String value) {
            addCriterion("yjdzh =", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhNotEqualTo(String value) {
            addCriterion("yjdzh <>", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhGreaterThan(String value) {
            addCriterion("yjdzh >", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhGreaterThanOrEqualTo(String value) {
            addCriterion("yjdzh >=", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhLessThan(String value) {
            addCriterion("yjdzh <", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhLessThanOrEqualTo(String value) {
            addCriterion("yjdzh <=", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhLike(String value) {
            addCriterion("yjdzh like", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhNotLike(String value) {
            addCriterion("yjdzh not like", value, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhIn(List<String> values) {
            addCriterion("yjdzh in", values, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhNotIn(List<String> values) {
            addCriterion("yjdzh not in", values, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhBetween(String value1, String value2) {
            addCriterion("yjdzh between", value1, value2, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andYjdzhNotBetween(String value1, String value2) {
            addCriterion("yjdzh not between", value1, value2, "yjdzh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshIsNull() {
            addCriterion("jlgchshzgrsh is null");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshIsNotNull() {
            addCriterion("jlgchshzgrsh is not null");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshEqualTo(Integer value) {
            addCriterion("jlgchshzgrsh =", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshNotEqualTo(Integer value) {
            addCriterion("jlgchshzgrsh <>", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshGreaterThan(Integer value) {
            addCriterion("jlgchshzgrsh >", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("jlgchshzgrsh >=", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshLessThan(Integer value) {
            addCriterion("jlgchshzgrsh <", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshLessThanOrEqualTo(Integer value) {
            addCriterion("jlgchshzgrsh <=", value, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshIn(List<Integer> values) {
            addCriterion("jlgchshzgrsh in", values, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshNotIn(List<Integer> values) {
            addCriterion("jlgchshzgrsh not in", values, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshBetween(Integer value1, Integer value2) {
            addCriterion("jlgchshzgrsh between", value1, value2, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andJlgchshzgrshNotBetween(Integer value1, Integer value2) {
            addCriterion("jlgchshzgrsh not between", value1, value2, "jlgchshzgrsh");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsIsNull() {
            addCriterion("chbjzhrs is null");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsIsNotNull() {
            addCriterion("chbjzhrs is not null");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsEqualTo(Integer value) {
            addCriterion("chbjzhrs =", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsNotEqualTo(Integer value) {
            addCriterion("chbjzhrs <>", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsGreaterThan(Integer value) {
            addCriterion("chbjzhrs >", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("chbjzhrs >=", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsLessThan(Integer value) {
            addCriterion("chbjzhrs <", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsLessThanOrEqualTo(Integer value) {
            addCriterion("chbjzhrs <=", value, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsIn(List<Integer> values) {
            addCriterion("chbjzhrs in", values, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsNotIn(List<Integer> values) {
            addCriterion("chbjzhrs not in", values, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsBetween(Integer value1, Integer value2) {
            addCriterion("chbjzhrs between", value1, value2, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbjzhrsNotBetween(Integer value1, Integer value2) {
            addCriterion("chbjzhrs not between", value1, value2, "chbjzhrs");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshIsNull() {
            addCriterion("chbzhjzhrsh is null");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshIsNotNull() {
            addCriterion("chbzhjzhrsh is not null");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshEqualTo(Integer value) {
            addCriterion("chbzhjzhrsh =", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshNotEqualTo(Integer value) {
            addCriterion("chbzhjzhrsh <>", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshGreaterThan(Integer value) {
            addCriterion("chbzhjzhrsh >", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("chbzhjzhrsh >=", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshLessThan(Integer value) {
            addCriterion("chbzhjzhrsh <", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshLessThanOrEqualTo(Integer value) {
            addCriterion("chbzhjzhrsh <=", value, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshIn(List<Integer> values) {
            addCriterion("chbzhjzhrsh in", values, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshNotIn(List<Integer> values) {
            addCriterion("chbzhjzhrsh not in", values, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshBetween(Integer value1, Integer value2) {
            addCriterion("chbzhjzhrsh between", value1, value2, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChbzhjzhrshNotBetween(Integer value1, Integer value2) {
            addCriterion("chbzhjzhrsh not between", value1, value2, "chbzhjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshIsNull() {
            addCriterion("chtjzhrsh is null");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshIsNotNull() {
            addCriterion("chtjzhrsh is not null");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshEqualTo(Integer value) {
            addCriterion("chtjzhrsh =", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshNotEqualTo(Integer value) {
            addCriterion("chtjzhrsh <>", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshGreaterThan(Integer value) {
            addCriterion("chtjzhrsh >", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("chtjzhrsh >=", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshLessThan(Integer value) {
            addCriterion("chtjzhrsh <", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshLessThanOrEqualTo(Integer value) {
            addCriterion("chtjzhrsh <=", value, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshIn(List<Integer> values) {
            addCriterion("chtjzhrsh in", values, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshNotIn(List<Integer> values) {
            addCriterion("chtjzhrsh not in", values, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshBetween(Integer value1, Integer value2) {
            addCriterion("chtjzhrsh between", value1, value2, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andChtjzhrshNotBetween(Integer value1, Integer value2) {
            addCriterion("chtjzhrsh not between", value1, value2, "chtjzhrsh");
            return (Criteria) this;
        }

        public Criteria andDwfzrIsNull() {
            addCriterion("dwfzr is null");
            return (Criteria) this;
        }

        public Criteria andDwfzrIsNotNull() {
            addCriterion("dwfzr is not null");
            return (Criteria) this;
        }

        public Criteria andDwfzrEqualTo(String value) {
            addCriterion("dwfzr =", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotEqualTo(String value) {
            addCriterion("dwfzr <>", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrGreaterThan(String value) {
            addCriterion("dwfzr >", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrGreaterThanOrEqualTo(String value) {
            addCriterion("dwfzr >=", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLessThan(String value) {
            addCriterion("dwfzr <", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLessThanOrEqualTo(String value) {
            addCriterion("dwfzr <=", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLike(String value) {
            addCriterion("dwfzr like", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotLike(String value) {
            addCriterion("dwfzr not like", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrIn(List<String> values) {
            addCriterion("dwfzr in", values, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotIn(List<String> values) {
            addCriterion("dwfzr not in", values, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrBetween(String value1, String value2) {
            addCriterion("dwfzr between", value1, value2, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotBetween(String value1, String value2) {
            addCriterion("dwfzr not between", value1, value2, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andFzrdhIsNull() {
            addCriterion("fzrdh is null");
            return (Criteria) this;
        }

        public Criteria andFzrdhIsNotNull() {
            addCriterion("fzrdh is not null");
            return (Criteria) this;
        }

        public Criteria andFzrdhEqualTo(String value) {
            addCriterion("fzrdh =", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotEqualTo(String value) {
            addCriterion("fzrdh <>", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhGreaterThan(String value) {
            addCriterion("fzrdh >", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhGreaterThanOrEqualTo(String value) {
            addCriterion("fzrdh >=", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLessThan(String value) {
            addCriterion("fzrdh <", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLessThanOrEqualTo(String value) {
            addCriterion("fzrdh <=", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLike(String value) {
            addCriterion("fzrdh like", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotLike(String value) {
            addCriterion("fzrdh not like", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhIn(List<String> values) {
            addCriterion("fzrdh in", values, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotIn(List<String> values) {
            addCriterion("fzrdh not in", values, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhBetween(String value1, String value2) {
            addCriterion("fzrdh between", value1, value2, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotBetween(String value1, String value2) {
            addCriterion("fzrdh not between", value1, value2, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andDwybIsNull() {
            addCriterion("dwyb is null");
            return (Criteria) this;
        }

        public Criteria andDwybIsNotNull() {
            addCriterion("dwyb is not null");
            return (Criteria) this;
        }

        public Criteria andDwybEqualTo(String value) {
            addCriterion("dwyb =", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybNotEqualTo(String value) {
            addCriterion("dwyb <>", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybGreaterThan(String value) {
            addCriterion("dwyb >", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybGreaterThanOrEqualTo(String value) {
            addCriterion("dwyb >=", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybLessThan(String value) {
            addCriterion("dwyb <", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybLessThanOrEqualTo(String value) {
            addCriterion("dwyb <=", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybLike(String value) {
            addCriterion("dwyb like", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybNotLike(String value) {
            addCriterion("dwyb not like", value, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybIn(List<String> values) {
            addCriterion("dwyb in", values, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybNotIn(List<String> values) {
            addCriterion("dwyb not in", values, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybBetween(String value1, String value2) {
            addCriterion("dwyb between", value1, value2, "dwyb");
            return (Criteria) this;
        }

        public Criteria andDwybNotBetween(String value1, String value2) {
            addCriterion("dwyb not between", value1, value2, "dwyb");
            return (Criteria) this;
        }

        public Criteria andFzrzhwIsNull() {
            addCriterion("fzrzhw is null");
            return (Criteria) this;
        }

        public Criteria andFzrzhwIsNotNull() {
            addCriterion("fzrzhw is not null");
            return (Criteria) this;
        }

        public Criteria andFzrzhwEqualTo(String value) {
            addCriterion("fzrzhw =", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwNotEqualTo(String value) {
            addCriterion("fzrzhw <>", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwGreaterThan(String value) {
            addCriterion("fzrzhw >", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwGreaterThanOrEqualTo(String value) {
            addCriterion("fzrzhw >=", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwLessThan(String value) {
            addCriterion("fzrzhw <", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwLessThanOrEqualTo(String value) {
            addCriterion("fzrzhw <=", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwLike(String value) {
            addCriterion("fzrzhw like", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwNotLike(String value) {
            addCriterion("fzrzhw not like", value, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwIn(List<String> values) {
            addCriterion("fzrzhw in", values, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwNotIn(List<String> values) {
            addCriterion("fzrzhw not in", values, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwBetween(String value1, String value2) {
            addCriterion("fzrzhw between", value1, value2, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andFzrzhwNotBetween(String value1, String value2) {
            addCriterion("fzrzhw not between", value1, value2, "fzrzhw");
            return (Criteria) this;
        }

        public Criteria andSxhthIsNull() {
            addCriterion("sxhth is null");
            return (Criteria) this;
        }

        public Criteria andSxhthIsNotNull() {
            addCriterion("sxhth is not null");
            return (Criteria) this;
        }

        public Criteria andSxhthEqualTo(String value) {
            addCriterion("sxhth =", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthNotEqualTo(String value) {
            addCriterion("sxhth <>", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthGreaterThan(String value) {
            addCriterion("sxhth >", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthGreaterThanOrEqualTo(String value) {
            addCriterion("sxhth >=", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthLessThan(String value) {
            addCriterion("sxhth <", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthLessThanOrEqualTo(String value) {
            addCriterion("sxhth <=", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthLike(String value) {
            addCriterion("sxhth like", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthNotLike(String value) {
            addCriterion("sxhth not like", value, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthIn(List<String> values) {
            addCriterion("sxhth in", values, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthNotIn(List<String> values) {
            addCriterion("sxhth not in", values, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthBetween(String value1, String value2) {
            addCriterion("sxhth between", value1, value2, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxhthNotBetween(String value1, String value2) {
            addCriterion("sxhth not between", value1, value2, "sxhth");
            return (Criteria) this;
        }

        public Criteria andSxlchIsNull() {
            addCriterion("sxlch is null");
            return (Criteria) this;
        }

        public Criteria andSxlchIsNotNull() {
            addCriterion("sxlch is not null");
            return (Criteria) this;
        }

        public Criteria andSxlchEqualTo(BigDecimal value) {
            addCriterion("sxlch =", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchNotEqualTo(BigDecimal value) {
            addCriterion("sxlch <>", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchGreaterThan(BigDecimal value) {
            addCriterion("sxlch >", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sxlch >=", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchLessThan(BigDecimal value) {
            addCriterion("sxlch <", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sxlch <=", value, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchIn(List<BigDecimal> values) {
            addCriterion("sxlch in", values, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchNotIn(List<BigDecimal> values) {
            addCriterion("sxlch not in", values, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxlch between", value1, value2, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxlchNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxlch not between", value1, value2, "sxlch");
            return (Criteria) this;
        }

        public Criteria andSxldzjIsNull() {
            addCriterion("sxldzj is null");
            return (Criteria) this;
        }

        public Criteria andSxldzjIsNotNull() {
            addCriterion("sxldzj is not null");
            return (Criteria) this;
        }

        public Criteria andSxldzjEqualTo(BigDecimal value) {
            addCriterion("sxldzj =", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjNotEqualTo(BigDecimal value) {
            addCriterion("sxldzj <>", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjGreaterThan(BigDecimal value) {
            addCriterion("sxldzj >", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sxldzj >=", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjLessThan(BigDecimal value) {
            addCriterion("sxldzj <", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sxldzj <=", value, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjIn(List<BigDecimal> values) {
            addCriterion("sxldzj in", values, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjNotIn(List<BigDecimal> values) {
            addCriterion("sxldzj not in", values, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxldzj between", value1, value2, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andSxldzjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxldzj not between", value1, value2, "sxldzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjIsNull() {
            addCriterion("jlftbzj is null");
            return (Criteria) this;
        }

        public Criteria andJlftbzjIsNotNull() {
            addCriterion("jlftbzj is not null");
            return (Criteria) this;
        }

        public Criteria andJlftbzjEqualTo(BigDecimal value) {
            addCriterion("jlftbzj =", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjNotEqualTo(BigDecimal value) {
            addCriterion("jlftbzj <>", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjGreaterThan(BigDecimal value) {
            addCriterion("jlftbzj >", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jlftbzj >=", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjLessThan(BigDecimal value) {
            addCriterion("jlftbzj <", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jlftbzj <=", value, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjIn(List<BigDecimal> values) {
            addCriterion("jlftbzj in", values, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjNotIn(List<BigDecimal> values) {
            addCriterion("jlftbzj not in", values, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlftbzj between", value1, value2, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlftbzjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlftbzj not between", value1, value2, "jlftbzj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjIsNull() {
            addCriterion("jlfjbj is null");
            return (Criteria) this;
        }

        public Criteria andJlfjbjIsNotNull() {
            addCriterion("jlfjbj is not null");
            return (Criteria) this;
        }

        public Criteria andJlfjbjEqualTo(BigDecimal value) {
            addCriterion("jlfjbj =", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjNotEqualTo(BigDecimal value) {
            addCriterion("jlfjbj <>", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjGreaterThan(BigDecimal value) {
            addCriterion("jlfjbj >", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jlfjbj >=", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjLessThan(BigDecimal value) {
            addCriterion("jlfjbj <", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jlfjbj <=", value, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjIn(List<BigDecimal> values) {
            addCriterion("jlfjbj in", values, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjNotIn(List<BigDecimal> values) {
            addCriterion("jlfjbj not in", values, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlfjbj between", value1, value2, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andJlfjbjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlfjbj not between", value1, value2, "jlfjbj");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqIsNull() {
            addCriterion("shgjdfwq is null");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqIsNotNull() {
            addCriterion("shgjdfwq is not null");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqEqualTo(BigDecimal value) {
            addCriterion("shgjdfwq =", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqNotEqualTo(BigDecimal value) {
            addCriterion("shgjdfwq <>", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqGreaterThan(BigDecimal value) {
            addCriterion("shgjdfwq >", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shgjdfwq >=", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqLessThan(BigDecimal value) {
            addCriterion("shgjdfwq <", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shgjdfwq <=", value, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqIn(List<BigDecimal> values) {
            addCriterion("shgjdfwq in", values, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqNotIn(List<BigDecimal> values) {
            addCriterion("shgjdfwq not in", values, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shgjdfwq between", value1, value2, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andShgjdfwqNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shgjdfwq not between", value1, value2, "shgjdfwq");
            return (Criteria) this;
        }

        public Criteria andKshrqIsNull() {
            addCriterion("kshrq is null");
            return (Criteria) this;
        }

        public Criteria andKshrqIsNotNull() {
            addCriterion("kshrq is not null");
            return (Criteria) this;
        }

        public Criteria andKshrqEqualTo(Date value) {
            addCriterionForJDBCDate("kshrq =", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("kshrq <>", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqGreaterThan(Date value) {
            addCriterionForJDBCDate("kshrq >", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kshrq >=", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqLessThan(Date value) {
            addCriterionForJDBCDate("kshrq <", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kshrq <=", value, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqIn(List<Date> values) {
            addCriterionForJDBCDate("kshrq in", values, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("kshrq not in", values, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kshrq between", value1, value2, "kshrq");
            return (Criteria) this;
        }

        public Criteria andKshrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kshrq not between", value1, value2, "kshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqIsNull() {
            addCriterion("jshrq is null");
            return (Criteria) this;
        }

        public Criteria andJshrqIsNotNull() {
            addCriterion("jshrq is not null");
            return (Criteria) this;
        }

        public Criteria andJshrqEqualTo(Date value) {
            addCriterionForJDBCDate("jshrq =", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("jshrq <>", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqGreaterThan(Date value) {
            addCriterionForJDBCDate("jshrq >", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("jshrq >=", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqLessThan(Date value) {
            addCriterionForJDBCDate("jshrq <", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("jshrq <=", value, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqIn(List<Date> values) {
            addCriterionForJDBCDate("jshrq in", values, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("jshrq not in", values, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("jshrq between", value1, value2, "jshrq");
            return (Criteria) this;
        }

        public Criteria andJshrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("jshrq not between", value1, value2, "jshrq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqIsNull() {
            addCriterion("qxzrfwq is null");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqIsNotNull() {
            addCriterion("qxzrfwq is not null");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqEqualTo(Long value) {
            addCriterion("qxzrfwq =", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqNotEqualTo(Long value) {
            addCriterion("qxzrfwq <>", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqGreaterThan(Long value) {
            addCriterion("qxzrfwq >", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqGreaterThanOrEqualTo(Long value) {
            addCriterion("qxzrfwq >=", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqLessThan(Long value) {
            addCriterion("qxzrfwq <", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqLessThanOrEqualTo(Long value) {
            addCriterion("qxzrfwq <=", value, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqIn(List<Long> values) {
            addCriterion("qxzrfwq in", values, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqNotIn(List<Long> values) {
            addCriterion("qxzrfwq not in", values, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqBetween(Long value1, Long value2) {
            addCriterion("qxzrfwq between", value1, value2, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andQxzrfwqNotBetween(Long value1, Long value2) {
            addCriterion("qxzrfwq not between", value1, value2, "qxzrfwq");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlIsNull() {
            addCriterion("htjlryshl is null");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlIsNotNull() {
            addCriterion("htjlryshl is not null");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlEqualTo(Integer value) {
            addCriterion("htjlryshl =", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlNotEqualTo(Integer value) {
            addCriterion("htjlryshl <>", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlGreaterThan(Integer value) {
            addCriterion("htjlryshl >", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlGreaterThanOrEqualTo(Integer value) {
            addCriterion("htjlryshl >=", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlLessThan(Integer value) {
            addCriterion("htjlryshl <", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlLessThanOrEqualTo(Integer value) {
            addCriterion("htjlryshl <=", value, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlIn(List<Integer> values) {
            addCriterion("htjlryshl in", values, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlNotIn(List<Integer> values) {
            addCriterion("htjlryshl not in", values, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlBetween(Integer value1, Integer value2) {
            addCriterion("htjlryshl between", value1, value2, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andHtjlryshlNotBetween(Integer value1, Integer value2) {
            addCriterion("htjlryshl not between", value1, value2, "htjlryshl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslIsNull() {
            addCriterion("zhyjljyshrysl is null");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslIsNotNull() {
            addCriterion("zhyjljyshrysl is not null");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslEqualTo(Integer value) {
            addCriterion("zhyjljyshrysl =", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslNotEqualTo(Integer value) {
            addCriterion("zhyjljyshrysl <>", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslGreaterThan(Integer value) {
            addCriterion("zhyjljyshrysl >", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhyjljyshrysl >=", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslLessThan(Integer value) {
            addCriterion("zhyjljyshrysl <", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslLessThanOrEqualTo(Integer value) {
            addCriterion("zhyjljyshrysl <=", value, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslIn(List<Integer> values) {
            addCriterion("zhyjljyshrysl in", values, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslNotIn(List<Integer> values) {
            addCriterion("zhyjljyshrysl not in", values, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslBetween(Integer value1, Integer value2) {
            addCriterion("zhyjljyshrysl between", value1, value2, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZhyjljyshryslNotBetween(Integer value1, Integer value2) {
            addCriterion("zhyjljyshrysl not between", value1, value2, "zhyjljyshrysl");
            return (Criteria) this;
        }

        public Criteria andZjbdzhIsNull() {
            addCriterion("zjbdzh is null");
            return (Criteria) this;
        }

        public Criteria andZjbdzhIsNotNull() {
            addCriterion("zjbdzh is not null");
            return (Criteria) this;
        }

        public Criteria andZjbdzhEqualTo(String value) {
            addCriterion("zjbdzh =", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhNotEqualTo(String value) {
            addCriterion("zjbdzh <>", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhGreaterThan(String value) {
            addCriterion("zjbdzh >", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhGreaterThanOrEqualTo(String value) {
            addCriterion("zjbdzh >=", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhLessThan(String value) {
            addCriterion("zjbdzh <", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhLessThanOrEqualTo(String value) {
            addCriterion("zjbdzh <=", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhLike(String value) {
            addCriterion("zjbdzh like", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhNotLike(String value) {
            addCriterion("zjbdzh not like", value, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhIn(List<String> values) {
            addCriterion("zjbdzh in", values, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhNotIn(List<String> values) {
            addCriterion("zjbdzh not in", values, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhBetween(String value1, String value2) {
            addCriterion("zjbdzh between", value1, value2, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andZjbdzhNotBetween(String value1, String value2) {
            addCriterion("zjbdzh not between", value1, value2, "zjbdzh");
            return (Criteria) this;
        }

        public Criteria andGzjbybIsNull() {
            addCriterion("gzjbyb is null");
            return (Criteria) this;
        }

        public Criteria andGzjbybIsNotNull() {
            addCriterion("gzjbyb is not null");
            return (Criteria) this;
        }

        public Criteria andGzjbybEqualTo(String value) {
            addCriterion("gzjbyb =", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybNotEqualTo(String value) {
            addCriterion("gzjbyb <>", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybGreaterThan(String value) {
            addCriterion("gzjbyb >", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybGreaterThanOrEqualTo(String value) {
            addCriterion("gzjbyb >=", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybLessThan(String value) {
            addCriterion("gzjbyb <", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybLessThanOrEqualTo(String value) {
            addCriterion("gzjbyb <=", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybLike(String value) {
            addCriterion("gzjbyb like", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybNotLike(String value) {
            addCriterion("gzjbyb not like", value, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybIn(List<String> values) {
            addCriterion("gzjbyb in", values, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybNotIn(List<String> values) {
            addCriterion("gzjbyb not in", values, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybBetween(String value1, String value2) {
            addCriterion("gzjbyb between", value1, value2, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andGzjbybNotBetween(String value1, String value2) {
            addCriterion("gzjbyb not between", value1, value2, "gzjbyb");
            return (Criteria) this;
        }

        public Criteria andZjblxdhIsNull() {
            addCriterion("zjblxdh is null");
            return (Criteria) this;
        }

        public Criteria andZjblxdhIsNotNull() {
            addCriterion("zjblxdh is not null");
            return (Criteria) this;
        }

        public Criteria andZjblxdhEqualTo(String value) {
            addCriterion("zjblxdh =", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhNotEqualTo(String value) {
            addCriterion("zjblxdh <>", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhGreaterThan(String value) {
            addCriterion("zjblxdh >", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhGreaterThanOrEqualTo(String value) {
            addCriterion("zjblxdh >=", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhLessThan(String value) {
            addCriterion("zjblxdh <", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhLessThanOrEqualTo(String value) {
            addCriterion("zjblxdh <=", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhLike(String value) {
            addCriterion("zjblxdh like", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhNotLike(String value) {
            addCriterion("zjblxdh not like", value, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhIn(List<String> values) {
            addCriterion("zjblxdh in", values, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhNotIn(List<String> values) {
            addCriterion("zjblxdh not in", values, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhBetween(String value1, String value2) {
            addCriterion("zjblxdh between", value1, value2, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andZjblxdhNotBetween(String value1, String value2) {
            addCriterion("zjblxdh not between", value1, value2, "zjblxdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmIsNull() {
            addCriterion("xmxtrxm is null");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmIsNotNull() {
            addCriterion("xmxtrxm is not null");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmEqualTo(String value) {
            addCriterion("xmxtrxm =", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmNotEqualTo(String value) {
            addCriterion("xmxtrxm <>", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmGreaterThan(String value) {
            addCriterion("xmxtrxm >", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmGreaterThanOrEqualTo(String value) {
            addCriterion("xmxtrxm >=", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmLessThan(String value) {
            addCriterion("xmxtrxm <", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmLessThanOrEqualTo(String value) {
            addCriterion("xmxtrxm <=", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmLike(String value) {
            addCriterion("xmxtrxm like", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmNotLike(String value) {
            addCriterion("xmxtrxm not like", value, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmIn(List<String> values) {
            addCriterion("xmxtrxm in", values, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmNotIn(List<String> values) {
            addCriterion("xmxtrxm not in", values, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmBetween(String value1, String value2) {
            addCriterion("xmxtrxm between", value1, value2, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrxmNotBetween(String value1, String value2) {
            addCriterion("xmxtrxm not between", value1, value2, "xmxtrxm");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhIsNull() {
            addCriterion("xmxtrdh is null");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhIsNotNull() {
            addCriterion("xmxtrdh is not null");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhEqualTo(String value) {
            addCriterion("xmxtrdh =", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhNotEqualTo(String value) {
            addCriterion("xmxtrdh <>", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhGreaterThan(String value) {
            addCriterion("xmxtrdh >", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhGreaterThanOrEqualTo(String value) {
            addCriterion("xmxtrdh >=", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhLessThan(String value) {
            addCriterion("xmxtrdh <", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhLessThanOrEqualTo(String value) {
            addCriterion("xmxtrdh <=", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhLike(String value) {
            addCriterion("xmxtrdh like", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhNotLike(String value) {
            addCriterion("xmxtrdh not like", value, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhIn(List<String> values) {
            addCriterion("xmxtrdh in", values, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhNotIn(List<String> values) {
            addCriterion("xmxtrdh not in", values, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhBetween(String value1, String value2) {
            addCriterion("xmxtrdh between", value1, value2, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andXmxtrdhNotBetween(String value1, String value2) {
            addCriterion("xmxtrdh not between", value1, value2, "xmxtrdh");
            return (Criteria) this;
        }

        public Criteria andBjrqIsNull() {
            addCriterion("bjrq is null");
            return (Criteria) this;
        }

        public Criteria andBjrqIsNotNull() {
            addCriterion("bjrq is not null");
            return (Criteria) this;
        }

        public Criteria andBjrqEqualTo(Date value) {
            addCriterionForJDBCDate("bjrq =", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("bjrq <>", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqGreaterThan(Date value) {
            addCriterionForJDBCDate("bjrq >", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bjrq >=", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqLessThan(Date value) {
            addCriterionForJDBCDate("bjrq <", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bjrq <=", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqIn(List<Date> values) {
            addCriterionForJDBCDate("bjrq in", values, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("bjrq not in", values, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bjrq between", value1, value2, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bjrq not between", value1, value2, "bjrq");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01IsNull() {
            addCriterion("money_value01 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01IsNotNull() {
            addCriterion("money_value01 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01EqualTo(BigDecimal value) {
            addCriterion("money_value01 =", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01NotEqualTo(BigDecimal value) {
            addCriterion("money_value01 <>", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01GreaterThan(BigDecimal value) {
            addCriterion("money_value01 >", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value01 >=", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01LessThan(BigDecimal value) {
            addCriterion("money_value01 <", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value01 <=", value, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01In(List<BigDecimal> values) {
            addCriterion("money_value01 in", values, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01NotIn(List<BigDecimal> values) {
            addCriterion("money_value01 not in", values, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value01 between", value1, value2, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue01NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value01 not between", value1, value2, "moneyValue01");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02IsNull() {
            addCriterion("money_value02 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02IsNotNull() {
            addCriterion("money_value02 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02EqualTo(BigDecimal value) {
            addCriterion("money_value02 =", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02NotEqualTo(BigDecimal value) {
            addCriterion("money_value02 <>", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02GreaterThan(BigDecimal value) {
            addCriterion("money_value02 >", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value02 >=", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02LessThan(BigDecimal value) {
            addCriterion("money_value02 <", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value02 <=", value, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02In(List<BigDecimal> values) {
            addCriterion("money_value02 in", values, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02NotIn(List<BigDecimal> values) {
            addCriterion("money_value02 not in", values, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value02 between", value1, value2, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue02NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value02 not between", value1, value2, "moneyValue02");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03IsNull() {
            addCriterion("money_value03 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03IsNotNull() {
            addCriterion("money_value03 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03EqualTo(BigDecimal value) {
            addCriterion("money_value03 =", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03NotEqualTo(BigDecimal value) {
            addCriterion("money_value03 <>", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03GreaterThan(BigDecimal value) {
            addCriterion("money_value03 >", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value03 >=", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03LessThan(BigDecimal value) {
            addCriterion("money_value03 <", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value03 <=", value, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03In(List<BigDecimal> values) {
            addCriterion("money_value03 in", values, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03NotIn(List<BigDecimal> values) {
            addCriterion("money_value03 not in", values, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value03 between", value1, value2, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue03NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value03 not between", value1, value2, "moneyValue03");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04IsNull() {
            addCriterion("money_value04 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04IsNotNull() {
            addCriterion("money_value04 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04EqualTo(BigDecimal value) {
            addCriterion("money_value04 =", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04NotEqualTo(BigDecimal value) {
            addCriterion("money_value04 <>", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04GreaterThan(BigDecimal value) {
            addCriterion("money_value04 >", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value04 >=", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04LessThan(BigDecimal value) {
            addCriterion("money_value04 <", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value04 <=", value, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04In(List<BigDecimal> values) {
            addCriterion("money_value04 in", values, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04NotIn(List<BigDecimal> values) {
            addCriterion("money_value04 not in", values, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value04 between", value1, value2, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue04NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value04 not between", value1, value2, "moneyValue04");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05IsNull() {
            addCriterion("money_value05 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05IsNotNull() {
            addCriterion("money_value05 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05EqualTo(BigDecimal value) {
            addCriterion("money_value05 =", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05NotEqualTo(BigDecimal value) {
            addCriterion("money_value05 <>", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05GreaterThan(BigDecimal value) {
            addCriterion("money_value05 >", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value05 >=", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05LessThan(BigDecimal value) {
            addCriterion("money_value05 <", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value05 <=", value, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05In(List<BigDecimal> values) {
            addCriterion("money_value05 in", values, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05NotIn(List<BigDecimal> values) {
            addCriterion("money_value05 not in", values, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value05 between", value1, value2, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue05NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value05 not between", value1, value2, "moneyValue05");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06IsNull() {
            addCriterion("money_value06 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06IsNotNull() {
            addCriterion("money_value06 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06EqualTo(BigDecimal value) {
            addCriterion("money_value06 =", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06NotEqualTo(BigDecimal value) {
            addCriterion("money_value06 <>", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06GreaterThan(BigDecimal value) {
            addCriterion("money_value06 >", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value06 >=", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06LessThan(BigDecimal value) {
            addCriterion("money_value06 <", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value06 <=", value, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06In(List<BigDecimal> values) {
            addCriterion("money_value06 in", values, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06NotIn(List<BigDecimal> values) {
            addCriterion("money_value06 not in", values, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value06 between", value1, value2, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue06NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value06 not between", value1, value2, "moneyValue06");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07IsNull() {
            addCriterion("money_value07 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07IsNotNull() {
            addCriterion("money_value07 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07EqualTo(BigDecimal value) {
            addCriterion("money_value07 =", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07NotEqualTo(BigDecimal value) {
            addCriterion("money_value07 <>", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07GreaterThan(BigDecimal value) {
            addCriterion("money_value07 >", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value07 >=", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07LessThan(BigDecimal value) {
            addCriterion("money_value07 <", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value07 <=", value, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07In(List<BigDecimal> values) {
            addCriterion("money_value07 in", values, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07NotIn(List<BigDecimal> values) {
            addCriterion("money_value07 not in", values, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value07 between", value1, value2, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue07NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value07 not between", value1, value2, "moneyValue07");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08IsNull() {
            addCriterion("money_value08 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08IsNotNull() {
            addCriterion("money_value08 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08EqualTo(BigDecimal value) {
            addCriterion("money_value08 =", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08NotEqualTo(BigDecimal value) {
            addCriterion("money_value08 <>", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08GreaterThan(BigDecimal value) {
            addCriterion("money_value08 >", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value08 >=", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08LessThan(BigDecimal value) {
            addCriterion("money_value08 <", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value08 <=", value, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08In(List<BigDecimal> values) {
            addCriterion("money_value08 in", values, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08NotIn(List<BigDecimal> values) {
            addCriterion("money_value08 not in", values, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value08 between", value1, value2, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue08NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value08 not between", value1, value2, "moneyValue08");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09IsNull() {
            addCriterion("money_value09 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09IsNotNull() {
            addCriterion("money_value09 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09EqualTo(BigDecimal value) {
            addCriterion("money_value09 =", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09NotEqualTo(BigDecimal value) {
            addCriterion("money_value09 <>", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09GreaterThan(BigDecimal value) {
            addCriterion("money_value09 >", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value09 >=", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09LessThan(BigDecimal value) {
            addCriterion("money_value09 <", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value09 <=", value, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09In(List<BigDecimal> values) {
            addCriterion("money_value09 in", values, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09NotIn(List<BigDecimal> values) {
            addCriterion("money_value09 not in", values, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value09 between", value1, value2, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue09NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value09 not between", value1, value2, "moneyValue09");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10IsNull() {
            addCriterion("money_value10 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10IsNotNull() {
            addCriterion("money_value10 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10EqualTo(BigDecimal value) {
            addCriterion("money_value10 =", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10NotEqualTo(BigDecimal value) {
            addCriterion("money_value10 <>", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10GreaterThan(BigDecimal value) {
            addCriterion("money_value10 >", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value10 >=", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10LessThan(BigDecimal value) {
            addCriterion("money_value10 <", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value10 <=", value, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10In(List<BigDecimal> values) {
            addCriterion("money_value10 in", values, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10NotIn(List<BigDecimal> values) {
            addCriterion("money_value10 not in", values, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value10 between", value1, value2, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue10NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value10 not between", value1, value2, "moneyValue10");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11IsNull() {
            addCriterion("money_value11 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11IsNotNull() {
            addCriterion("money_value11 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11EqualTo(BigDecimal value) {
            addCriterion("money_value11 =", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11NotEqualTo(BigDecimal value) {
            addCriterion("money_value11 <>", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11GreaterThan(BigDecimal value) {
            addCriterion("money_value11 >", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value11 >=", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11LessThan(BigDecimal value) {
            addCriterion("money_value11 <", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value11 <=", value, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11In(List<BigDecimal> values) {
            addCriterion("money_value11 in", values, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11NotIn(List<BigDecimal> values) {
            addCriterion("money_value11 not in", values, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value11 between", value1, value2, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andMoneyValue11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value11 not between", value1, value2, "moneyValue11");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNull() {
            addCriterion("role_type is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("role_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(String value) {
            addCriterion("role_type =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(String value) {
            addCriterion("role_type <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(String value) {
            addCriterion("role_type >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("role_type >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(String value) {
            addCriterion("role_type <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(String value) {
            addCriterion("role_type <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLike(String value) {
            addCriterion("role_type like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotLike(String value) {
            addCriterion("role_type not like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<String> values) {
            addCriterion("role_type in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<String> values) {
            addCriterion("role_type not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(String value1, String value2) {
            addCriterion("role_type between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(String value1, String value2) {
            addCriterion("role_type not between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12IsNull() {
            addCriterion("money_value12 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12IsNotNull() {
            addCriterion("money_value12 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12EqualTo(BigDecimal value) {
            addCriterion("money_value12 =", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12NotEqualTo(BigDecimal value) {
            addCriterion("money_value12 <>", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12GreaterThan(BigDecimal value) {
            addCriterion("money_value12 >", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value12 >=", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12LessThan(BigDecimal value) {
            addCriterion("money_value12 <", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value12 <=", value, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12In(List<BigDecimal> values) {
            addCriterion("money_value12 in", values, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12NotIn(List<BigDecimal> values) {
            addCriterion("money_value12 not in", values, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value12 between", value1, value2, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue12NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value12 not between", value1, value2, "moneyValue12");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13IsNull() {
            addCriterion("money_value13 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13IsNotNull() {
            addCriterion("money_value13 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13EqualTo(BigDecimal value) {
            addCriterion("money_value13 =", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13NotEqualTo(BigDecimal value) {
            addCriterion("money_value13 <>", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13GreaterThan(BigDecimal value) {
            addCriterion("money_value13 >", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value13 >=", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13LessThan(BigDecimal value) {
            addCriterion("money_value13 <", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value13 <=", value, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13In(List<BigDecimal> values) {
            addCriterion("money_value13 in", values, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13NotIn(List<BigDecimal> values) {
            addCriterion("money_value13 not in", values, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value13 between", value1, value2, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue13NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value13 not between", value1, value2, "moneyValue13");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14IsNull() {
            addCriterion("money_value14 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14IsNotNull() {
            addCriterion("money_value14 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14EqualTo(BigDecimal value) {
            addCriterion("money_value14 =", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14NotEqualTo(BigDecimal value) {
            addCriterion("money_value14 <>", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14GreaterThan(BigDecimal value) {
            addCriterion("money_value14 >", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value14 >=", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14LessThan(BigDecimal value) {
            addCriterion("money_value14 <", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value14 <=", value, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14In(List<BigDecimal> values) {
            addCriterion("money_value14 in", values, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14NotIn(List<BigDecimal> values) {
            addCriterion("money_value14 not in", values, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value14 between", value1, value2, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value14 not between", value1, value2, "moneyValue14");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15IsNull() {
            addCriterion("money_value15 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15IsNotNull() {
            addCriterion("money_value15 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15EqualTo(BigDecimal value) {
            addCriterion("money_value15 =", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15NotEqualTo(BigDecimal value) {
            addCriterion("money_value15 <>", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15GreaterThan(BigDecimal value) {
            addCriterion("money_value15 >", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value15 >=", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15LessThan(BigDecimal value) {
            addCriterion("money_value15 <", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value15 <=", value, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15In(List<BigDecimal> values) {
            addCriterion("money_value15 in", values, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15NotIn(List<BigDecimal> values) {
            addCriterion("money_value15 not in", values, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value15 between", value1, value2, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue15NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value15 not between", value1, value2, "moneyValue15");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16IsNull() {
            addCriterion("money_value16 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16IsNotNull() {
            addCriterion("money_value16 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16EqualTo(BigDecimal value) {
            addCriterion("money_value16 =", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16NotEqualTo(BigDecimal value) {
            addCriterion("money_value16 <>", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16GreaterThan(BigDecimal value) {
            addCriterion("money_value16 >", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value16 >=", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16LessThan(BigDecimal value) {
            addCriterion("money_value16 <", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value16 <=", value, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16In(List<BigDecimal> values) {
            addCriterion("money_value16 in", values, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16NotIn(List<BigDecimal> values) {
            addCriterion("money_value16 not in", values, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value16 between", value1, value2, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue16NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value16 not between", value1, value2, "moneyValue16");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17IsNull() {
            addCriterion("money_value17 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17IsNotNull() {
            addCriterion("money_value17 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17EqualTo(BigDecimal value) {
            addCriterion("money_value17 =", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17NotEqualTo(BigDecimal value) {
            addCriterion("money_value17 <>", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17GreaterThan(BigDecimal value) {
            addCriterion("money_value17 >", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value17 >=", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17LessThan(BigDecimal value) {
            addCriterion("money_value17 <", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value17 <=", value, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17In(List<BigDecimal> values) {
            addCriterion("money_value17 in", values, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17NotIn(List<BigDecimal> values) {
            addCriterion("money_value17 not in", values, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value17 between", value1, value2, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue17NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value17 not between", value1, value2, "moneyValue17");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18IsNull() {
            addCriterion("money_value18 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18IsNotNull() {
            addCriterion("money_value18 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18EqualTo(BigDecimal value) {
            addCriterion("money_value18 =", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18NotEqualTo(BigDecimal value) {
            addCriterion("money_value18 <>", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18GreaterThan(BigDecimal value) {
            addCriterion("money_value18 >", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value18 >=", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18LessThan(BigDecimal value) {
            addCriterion("money_value18 <", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value18 <=", value, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18In(List<BigDecimal> values) {
            addCriterion("money_value18 in", values, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18NotIn(List<BigDecimal> values) {
            addCriterion("money_value18 not in", values, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value18 between", value1, value2, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue18NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value18 not between", value1, value2, "moneyValue18");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19IsNull() {
            addCriterion("money_value19 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19IsNotNull() {
            addCriterion("money_value19 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19EqualTo(BigDecimal value) {
            addCriterion("money_value19 =", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19NotEqualTo(BigDecimal value) {
            addCriterion("money_value19 <>", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19GreaterThan(BigDecimal value) {
            addCriterion("money_value19 >", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value19 >=", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19LessThan(BigDecimal value) {
            addCriterion("money_value19 <", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value19 <=", value, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19In(List<BigDecimal> values) {
            addCriterion("money_value19 in", values, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19NotIn(List<BigDecimal> values) {
            addCriterion("money_value19 not in", values, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value19 between", value1, value2, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue19NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value19 not between", value1, value2, "moneyValue19");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20IsNull() {
            addCriterion("money_value20 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20IsNotNull() {
            addCriterion("money_value20 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20EqualTo(BigDecimal value) {
            addCriterion("money_value20 =", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20NotEqualTo(BigDecimal value) {
            addCriterion("money_value20 <>", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20GreaterThan(BigDecimal value) {
            addCriterion("money_value20 >", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value20 >=", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20LessThan(BigDecimal value) {
            addCriterion("money_value20 <", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value20 <=", value, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20In(List<BigDecimal> values) {
            addCriterion("money_value20 in", values, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20NotIn(List<BigDecimal> values) {
            addCriterion("money_value20 not in", values, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value20 between", value1, value2, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue20NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value20 not between", value1, value2, "moneyValue20");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21IsNull() {
            addCriterion("money_value21 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21IsNotNull() {
            addCriterion("money_value21 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21EqualTo(BigDecimal value) {
            addCriterion("money_value21 =", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21NotEqualTo(BigDecimal value) {
            addCriterion("money_value21 <>", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21GreaterThan(BigDecimal value) {
            addCriterion("money_value21 >", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value21 >=", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21LessThan(BigDecimal value) {
            addCriterion("money_value21 <", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value21 <=", value, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21In(List<BigDecimal> values) {
            addCriterion("money_value21 in", values, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21NotIn(List<BigDecimal> values) {
            addCriterion("money_value21 not in", values, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value21 between", value1, value2, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue21NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value21 not between", value1, value2, "moneyValue21");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22IsNull() {
            addCriterion("money_value22 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22IsNotNull() {
            addCriterion("money_value22 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22EqualTo(BigDecimal value) {
            addCriterion("money_value22 =", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22NotEqualTo(BigDecimal value) {
            addCriterion("money_value22 <>", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22GreaterThan(BigDecimal value) {
            addCriterion("money_value22 >", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value22 >=", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22LessThan(BigDecimal value) {
            addCriterion("money_value22 <", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value22 <=", value, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22In(List<BigDecimal> values) {
            addCriterion("money_value22 in", values, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22NotIn(List<BigDecimal> values) {
            addCriterion("money_value22 not in", values, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value22 between", value1, value2, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue22NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value22 not between", value1, value2, "moneyValue22");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23IsNull() {
            addCriterion("money_value23 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23IsNotNull() {
            addCriterion("money_value23 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23EqualTo(BigDecimal value) {
            addCriterion("money_value23 =", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23NotEqualTo(BigDecimal value) {
            addCriterion("money_value23 <>", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23GreaterThan(BigDecimal value) {
            addCriterion("money_value23 >", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value23 >=", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23LessThan(BigDecimal value) {
            addCriterion("money_value23 <", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value23 <=", value, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23In(List<BigDecimal> values) {
            addCriterion("money_value23 in", values, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23NotIn(List<BigDecimal> values) {
            addCriterion("money_value23 not in", values, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value23 between", value1, value2, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue23NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value23 not between", value1, value2, "moneyValue23");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24IsNull() {
            addCriterion("money_value24 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24IsNotNull() {
            addCriterion("money_value24 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24EqualTo(BigDecimal value) {
            addCriterion("money_value24 =", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotEqualTo(BigDecimal value) {
            addCriterion("money_value24 <>", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24GreaterThan(BigDecimal value) {
            addCriterion("money_value24 >", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value24 >=", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24LessThan(BigDecimal value) {
            addCriterion("money_value24 <", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value24 <=", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24In(List<BigDecimal> values) {
            addCriterion("money_value24 in", values, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotIn(List<BigDecimal> values) {
            addCriterion("money_value24 not in", values, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value24 between", value1, value2, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value24 not between", value1, value2, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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

        public Criteria andInserttimeEqualTo(String value) {
            addCriterion("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(String value) {
            addCriterion("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(String value) {
            addCriterion("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(String value) {
            addCriterion("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(String value) {
            addCriterion("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(String value) {
            addCriterion("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLike(String value) {
            addCriterion("inserttime like", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotLike(String value) {
            addCriterion("inserttime not like", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<String> values) {
            addCriterion("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<String> values) {
            addCriterion("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(String value1, String value2) {
            addCriterion("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(String value1, String value2) {
            addCriterion("inserttime not between", value1, value2, "inserttime");
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