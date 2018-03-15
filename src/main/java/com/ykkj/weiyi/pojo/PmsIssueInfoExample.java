package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsIssueInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsIssueInfoExample() {
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

        public Criteria andIssueNoIsNull() {
            addCriterion("issue_no is null");
            return (Criteria) this;
        }

        public Criteria andIssueNoIsNotNull() {
            addCriterion("issue_no is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNoEqualTo(String value) {
            addCriterion("issue_no =", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotEqualTo(String value) {
            addCriterion("issue_no <>", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThan(String value) {
            addCriterion("issue_no >", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThanOrEqualTo(String value) {
            addCriterion("issue_no >=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThan(String value) {
            addCriterion("issue_no <", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThanOrEqualTo(String value) {
            addCriterion("issue_no <=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLike(String value) {
            addCriterion("issue_no like", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotLike(String value) {
            addCriterion("issue_no not like", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoIn(List<String> values) {
            addCriterion("issue_no in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotIn(List<String> values) {
            addCriterion("issue_no not in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoBetween(String value1, String value2) {
            addCriterion("issue_no between", value1, value2, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotBetween(String value1, String value2) {
            addCriterion("issue_no not between", value1, value2, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNameIsNull() {
            addCriterion("issue_name is null");
            return (Criteria) this;
        }

        public Criteria andIssueNameIsNotNull() {
            addCriterion("issue_name is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNameEqualTo(String value) {
            addCriterion("issue_name =", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameNotEqualTo(String value) {
            addCriterion("issue_name <>", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameGreaterThan(String value) {
            addCriterion("issue_name >", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameGreaterThanOrEqualTo(String value) {
            addCriterion("issue_name >=", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameLessThan(String value) {
            addCriterion("issue_name <", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameLessThanOrEqualTo(String value) {
            addCriterion("issue_name <=", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameLike(String value) {
            addCriterion("issue_name like", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameNotLike(String value) {
            addCriterion("issue_name not like", value, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameIn(List<String> values) {
            addCriterion("issue_name in", values, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameNotIn(List<String> values) {
            addCriterion("issue_name not in", values, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameBetween(String value1, String value2) {
            addCriterion("issue_name between", value1, value2, "issueName");
            return (Criteria) this;
        }

        public Criteria andIssueNameNotBetween(String value1, String value2) {
            addCriterion("issue_name not between", value1, value2, "issueName");
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

        public Criteria andCurrentMoneyPlanIsNull() {
            addCriterion("current_money_plan is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanIsNotNull() {
            addCriterion("current_money_plan is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanEqualTo(BigDecimal value) {
            addCriterion("current_money_plan =", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanNotEqualTo(BigDecimal value) {
            addCriterion("current_money_plan <>", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanGreaterThan(BigDecimal value) {
            addCriterion("current_money_plan >", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_money_plan >=", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanLessThan(BigDecimal value) {
            addCriterion("current_money_plan <", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_money_plan <=", value, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanIn(List<BigDecimal> values) {
            addCriterion("current_money_plan in", values, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanNotIn(List<BigDecimal> values) {
            addCriterion("current_money_plan not in", values, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_money_plan between", value1, value2, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andCurrentMoneyPlanNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_money_plan not between", value1, value2, "currentMoneyPlan");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIsNull() {
            addCriterion("is_current is null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIsNotNull() {
            addCriterion("is_current is not null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentEqualTo(Long value) {
            addCriterion("is_current =", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotEqualTo(Long value) {
            addCriterion("is_current <>", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentGreaterThan(Long value) {
            addCriterion("is_current >", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentGreaterThanOrEqualTo(Long value) {
            addCriterion("is_current >=", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentLessThan(Long value) {
            addCriterion("is_current <", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentLessThanOrEqualTo(Long value) {
            addCriterion("is_current <=", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIn(List<Long> values) {
            addCriterion("is_current in", values, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotIn(List<Long> values) {
            addCriterion("is_current not in", values, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentBetween(Long value1, Long value2) {
            addCriterion("is_current between", value1, value2, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotBetween(Long value1, Long value2) {
            addCriterion("is_current not between", value1, value2, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andPlanPerIsNull() {
            addCriterion("plan_per is null");
            return (Criteria) this;
        }

        public Criteria andPlanPerIsNotNull() {
            addCriterion("plan_per is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPerEqualTo(BigDecimal value) {
            addCriterion("plan_per =", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerNotEqualTo(BigDecimal value) {
            addCriterion("plan_per <>", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerGreaterThan(BigDecimal value) {
            addCriterion("plan_per >", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_per >=", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerLessThan(BigDecimal value) {
            addCriterion("plan_per <", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_per <=", value, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerIn(List<BigDecimal> values) {
            addCriterion("plan_per in", values, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerNotIn(List<BigDecimal> values) {
            addCriterion("plan_per not in", values, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_per between", value1, value2, "planPer");
            return (Criteria) this;
        }

        public Criteria andPlanPerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_per not between", value1, value2, "planPer");
            return (Criteria) this;
        }

        public Criteria andBpmStatusIsNull() {
            addCriterion("bpm_status is null");
            return (Criteria) this;
        }

        public Criteria andBpmStatusIsNotNull() {
            addCriterion("bpm_status is not null");
            return (Criteria) this;
        }

        public Criteria andBpmStatusEqualTo(String value) {
            addCriterion("bpm_status =", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusNotEqualTo(String value) {
            addCriterion("bpm_status <>", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusGreaterThan(String value) {
            addCriterion("bpm_status >", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bpm_status >=", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusLessThan(String value) {
            addCriterion("bpm_status <", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusLessThanOrEqualTo(String value) {
            addCriterion("bpm_status <=", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusLike(String value) {
            addCriterion("bpm_status like", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusNotLike(String value) {
            addCriterion("bpm_status not like", value, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusIn(List<String> values) {
            addCriterion("bpm_status in", values, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusNotIn(List<String> values) {
            addCriterion("bpm_status not in", values, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBetween(String value1, String value2) {
            addCriterion("bpm_status between", value1, value2, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusNotBetween(String value1, String value2) {
            addCriterion("bpm_status not between", value1, value2, "bpmStatus");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakIsNull() {
            addCriterion("bpm_status_bak is null");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakIsNotNull() {
            addCriterion("bpm_status_bak is not null");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakEqualTo(String value) {
            addCriterion("bpm_status_bak =", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakNotEqualTo(String value) {
            addCriterion("bpm_status_bak <>", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakGreaterThan(String value) {
            addCriterion("bpm_status_bak >", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakGreaterThanOrEqualTo(String value) {
            addCriterion("bpm_status_bak >=", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakLessThan(String value) {
            addCriterion("bpm_status_bak <", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakLessThanOrEqualTo(String value) {
            addCriterion("bpm_status_bak <=", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakLike(String value) {
            addCriterion("bpm_status_bak like", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakNotLike(String value) {
            addCriterion("bpm_status_bak not like", value, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakIn(List<String> values) {
            addCriterion("bpm_status_bak in", values, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakNotIn(List<String> values) {
            addCriterion("bpm_status_bak not in", values, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakBetween(String value1, String value2) {
            addCriterion("bpm_status_bak between", value1, value2, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmStatusBakNotBetween(String value1, String value2) {
            addCriterion("bpm_status_bak not between", value1, value2, "bpmStatusBak");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdIsNull() {
            addCriterion("bpm_node_id is null");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdIsNotNull() {
            addCriterion("bpm_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdEqualTo(String value) {
            addCriterion("bpm_node_id =", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdNotEqualTo(String value) {
            addCriterion("bpm_node_id <>", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdGreaterThan(String value) {
            addCriterion("bpm_node_id >", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("bpm_node_id >=", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdLessThan(String value) {
            addCriterion("bpm_node_id <", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdLessThanOrEqualTo(String value) {
            addCriterion("bpm_node_id <=", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdLike(String value) {
            addCriterion("bpm_node_id like", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdNotLike(String value) {
            addCriterion("bpm_node_id not like", value, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdIn(List<String> values) {
            addCriterion("bpm_node_id in", values, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdNotIn(List<String> values) {
            addCriterion("bpm_node_id not in", values, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdBetween(String value1, String value2) {
            addCriterion("bpm_node_id between", value1, value2, "bpmNodeId");
            return (Criteria) this;
        }

        public Criteria andBpmNodeIdNotBetween(String value1, String value2) {
            addCriterion("bpm_node_id not between", value1, value2, "bpmNodeId");
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