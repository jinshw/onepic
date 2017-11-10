package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DirectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DirectInfoExample() {
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

        public Criteria andDirectNoIsNull() {
            addCriterion("direct_no is null");
            return (Criteria) this;
        }

        public Criteria andDirectNoIsNotNull() {
            addCriterion("direct_no is not null");
            return (Criteria) this;
        }

        public Criteria andDirectNoEqualTo(String value) {
            addCriterion("direct_no =", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoNotEqualTo(String value) {
            addCriterion("direct_no <>", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoGreaterThan(String value) {
            addCriterion("direct_no >", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoGreaterThanOrEqualTo(String value) {
            addCriterion("direct_no >=", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoLessThan(String value) {
            addCriterion("direct_no <", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoLessThanOrEqualTo(String value) {
            addCriterion("direct_no <=", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoLike(String value) {
            addCriterion("direct_no like", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoNotLike(String value) {
            addCriterion("direct_no not like", value, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoIn(List<String> values) {
            addCriterion("direct_no in", values, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoNotIn(List<String> values) {
            addCriterion("direct_no not in", values, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoBetween(String value1, String value2) {
            addCriterion("direct_no between", value1, value2, "directNo");
            return (Criteria) this;
        }

        public Criteria andDirectNoNotBetween(String value1, String value2) {
            addCriterion("direct_no not between", value1, value2, "directNo");
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

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andDirectAddIsNull() {
            addCriterion("direct_add is null");
            return (Criteria) this;
        }

        public Criteria andDirectAddIsNotNull() {
            addCriterion("direct_add is not null");
            return (Criteria) this;
        }

        public Criteria andDirectAddEqualTo(String value) {
            addCriterion("direct_add =", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddNotEqualTo(String value) {
            addCriterion("direct_add <>", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddGreaterThan(String value) {
            addCriterion("direct_add >", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddGreaterThanOrEqualTo(String value) {
            addCriterion("direct_add >=", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddLessThan(String value) {
            addCriterion("direct_add <", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddLessThanOrEqualTo(String value) {
            addCriterion("direct_add <=", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddLike(String value) {
            addCriterion("direct_add like", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddNotLike(String value) {
            addCriterion("direct_add not like", value, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddIn(List<String> values) {
            addCriterion("direct_add in", values, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddNotIn(List<String> values) {
            addCriterion("direct_add not in", values, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddBetween(String value1, String value2) {
            addCriterion("direct_add between", value1, value2, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectAddNotBetween(String value1, String value2) {
            addCriterion("direct_add not between", value1, value2, "directAdd");
            return (Criteria) this;
        }

        public Criteria andDirectTelIsNull() {
            addCriterion("direct_tel is null");
            return (Criteria) this;
        }

        public Criteria andDirectTelIsNotNull() {
            addCriterion("direct_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDirectTelEqualTo(String value) {
            addCriterion("direct_tel =", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelNotEqualTo(String value) {
            addCriterion("direct_tel <>", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelGreaterThan(String value) {
            addCriterion("direct_tel >", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelGreaterThanOrEqualTo(String value) {
            addCriterion("direct_tel >=", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelLessThan(String value) {
            addCriterion("direct_tel <", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelLessThanOrEqualTo(String value) {
            addCriterion("direct_tel <=", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelLike(String value) {
            addCriterion("direct_tel like", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelNotLike(String value) {
            addCriterion("direct_tel not like", value, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelIn(List<String> values) {
            addCriterion("direct_tel in", values, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelNotIn(List<String> values) {
            addCriterion("direct_tel not in", values, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelBetween(String value1, String value2) {
            addCriterion("direct_tel between", value1, value2, "directTel");
            return (Criteria) this;
        }

        public Criteria andDirectTelNotBetween(String value1, String value2) {
            addCriterion("direct_tel not between", value1, value2, "directTel");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNull() {
            addCriterion("project_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNotNull() {
            addCriterion("project_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyEqualTo(Float value) {
            addCriterion("project_money =", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotEqualTo(Float value) {
            addCriterion("project_money <>", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThan(Float value) {
            addCriterion("project_money >", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("project_money >=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThan(Float value) {
            addCriterion("project_money <", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThanOrEqualTo(Float value) {
            addCriterion("project_money <=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIn(List<Float> values) {
            addCriterion("project_money in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotIn(List<Float> values) {
            addCriterion("project_money not in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyBetween(Float value1, Float value2) {
            addCriterion("project_money between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotBetween(Float value1, Float value2) {
            addCriterion("project_money not between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectAddIsNull() {
            addCriterion("project_add is null");
            return (Criteria) this;
        }

        public Criteria andProjectAddIsNotNull() {
            addCriterion("project_add is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAddEqualTo(String value) {
            addCriterion("project_add =", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddNotEqualTo(String value) {
            addCriterion("project_add <>", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddGreaterThan(String value) {
            addCriterion("project_add >", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddGreaterThanOrEqualTo(String value) {
            addCriterion("project_add >=", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddLessThan(String value) {
            addCriterion("project_add <", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddLessThanOrEqualTo(String value) {
            addCriterion("project_add <=", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddLike(String value) {
            addCriterion("project_add like", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddNotLike(String value) {
            addCriterion("project_add not like", value, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddIn(List<String> values) {
            addCriterion("project_add in", values, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddNotIn(List<String> values) {
            addCriterion("project_add not in", values, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddBetween(String value1, String value2) {
            addCriterion("project_add between", value1, value2, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andProjectAddNotBetween(String value1, String value2) {
            addCriterion("project_add not between", value1, value2, "projectAdd");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIsNull() {
            addCriterion("leader_tel is null");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIsNotNull() {
            addCriterion("leader_tel is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderTelEqualTo(String value) {
            addCriterion("leader_tel =", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotEqualTo(String value) {
            addCriterion("leader_tel <>", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelGreaterThan(String value) {
            addCriterion("leader_tel >", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelGreaterThanOrEqualTo(String value) {
            addCriterion("leader_tel >=", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLessThan(String value) {
            addCriterion("leader_tel <", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLessThanOrEqualTo(String value) {
            addCriterion("leader_tel <=", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLike(String value) {
            addCriterion("leader_tel like", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotLike(String value) {
            addCriterion("leader_tel not like", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIn(List<String> values) {
            addCriterion("leader_tel in", values, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotIn(List<String> values) {
            addCriterion("leader_tel not in", values, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelBetween(String value1, String value2) {
            addCriterion("leader_tel between", value1, value2, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotBetween(String value1, String value2) {
            addCriterion("leader_tel not between", value1, value2, "leaderTel");
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

        public Criteria andPropertyAIsNull() {
            addCriterion("property_a is null");
            return (Criteria) this;
        }

        public Criteria andPropertyAIsNotNull() {
            addCriterion("property_a is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyAEqualTo(Float value) {
            addCriterion("property_a =", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotEqualTo(Float value) {
            addCriterion("property_a <>", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThan(Float value) {
            addCriterion("property_a >", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThanOrEqualTo(Float value) {
            addCriterion("property_a >=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThan(Float value) {
            addCriterion("property_a <", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThanOrEqualTo(Float value) {
            addCriterion("property_a <=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAIn(List<Float> values) {
            addCriterion("property_a in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotIn(List<Float> values) {
            addCriterion("property_a not in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyABetween(Float value1, Float value2) {
            addCriterion("property_a between", value1, value2, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotBetween(Float value1, Float value2) {
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

        public Criteria andPropertyCEqualTo(String value) {
            addCriterion("property_c =", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotEqualTo(String value) {
            addCriterion("property_c <>", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCGreaterThan(String value) {
            addCriterion("property_c >", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCGreaterThanOrEqualTo(String value) {
            addCriterion("property_c >=", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCLessThan(String value) {
            addCriterion("property_c <", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCLessThanOrEqualTo(String value) {
            addCriterion("property_c <=", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCLike(String value) {
            addCriterion("property_c like", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotLike(String value) {
            addCriterion("property_c not like", value, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCIn(List<String> values) {
            addCriterion("property_c in", values, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotIn(List<String> values) {
            addCriterion("property_c not in", values, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCBetween(String value1, String value2) {
            addCriterion("property_c between", value1, value2, "propertyC");
            return (Criteria) this;
        }

        public Criteria andPropertyCNotBetween(String value1, String value2) {
            addCriterion("property_c not between", value1, value2, "propertyC");
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

        public Criteria andRoleTypeIsNull() {
            addCriterion("role_type is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("role_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(Integer value) {
            addCriterion("role_type =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(Integer value) {
            addCriterion("role_type <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(Integer value) {
            addCriterion("role_type >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_type >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(Integer value) {
            addCriterion("role_type <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("role_type <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<Integer> values) {
            addCriterion("role_type in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<Integer> values) {
            addCriterion("role_type not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(Integer value1, Integer value2) {
            addCriterion("role_type between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("role_type not between", value1, value2, "roleType");
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