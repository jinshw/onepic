package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsPlanTzkz01Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz01Example() {
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

        public Criteria andMonitorDeptIsNull() {
            addCriterion("monitor_dept is null");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptIsNotNull() {
            addCriterion("monitor_dept is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptEqualTo(String value) {
            addCriterion("monitor_dept =", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptNotEqualTo(String value) {
            addCriterion("monitor_dept <>", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptGreaterThan(String value) {
            addCriterion("monitor_dept >", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_dept >=", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptLessThan(String value) {
            addCriterion("monitor_dept <", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptLessThanOrEqualTo(String value) {
            addCriterion("monitor_dept <=", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptLike(String value) {
            addCriterion("monitor_dept like", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptNotLike(String value) {
            addCriterion("monitor_dept not like", value, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptIn(List<String> values) {
            addCriterion("monitor_dept in", values, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptNotIn(List<String> values) {
            addCriterion("monitor_dept not in", values, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptBetween(String value1, String value2) {
            addCriterion("monitor_dept between", value1, value2, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMonitorDeptNotBetween(String value1, String value2) {
            addCriterion("monitor_dept not between", value1, value2, "monitorDept");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyIsNull() {
            addCriterion("mt_pact_money is null");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyIsNotNull() {
            addCriterion("mt_pact_money is not null");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyEqualTo(BigDecimal value) {
            addCriterion("mt_pact_money =", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyNotEqualTo(BigDecimal value) {
            addCriterion("mt_pact_money <>", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyGreaterThan(BigDecimal value) {
            addCriterion("mt_pact_money >", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mt_pact_money >=", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyLessThan(BigDecimal value) {
            addCriterion("mt_pact_money <", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mt_pact_money <=", value, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyIn(List<BigDecimal> values) {
            addCriterion("mt_pact_money in", values, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyNotIn(List<BigDecimal> values) {
            addCriterion("mt_pact_money not in", values, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mt_pact_money between", value1, value2, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMtPactMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mt_pact_money not between", value1, value2, "mtPactMoney");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderIsNull() {
            addCriterion("monitorLeader is null");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderIsNotNull() {
            addCriterion("monitorLeader is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderEqualTo(String value) {
            addCriterion("monitorLeader =", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderNotEqualTo(String value) {
            addCriterion("monitorLeader <>", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderGreaterThan(String value) {
            addCriterion("monitorLeader >", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderGreaterThanOrEqualTo(String value) {
            addCriterion("monitorLeader >=", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderLessThan(String value) {
            addCriterion("monitorLeader <", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderLessThanOrEqualTo(String value) {
            addCriterion("monitorLeader <=", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderLike(String value) {
            addCriterion("monitorLeader like", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderNotLike(String value) {
            addCriterion("monitorLeader not like", value, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderIn(List<String> values) {
            addCriterion("monitorLeader in", values, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderNotIn(List<String> values) {
            addCriterion("monitorLeader not in", values, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderBetween(String value1, String value2) {
            addCriterion("monitorLeader between", value1, value2, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andMonitorleaderNotBetween(String value1, String value2) {
            addCriterion("monitorLeader not between", value1, value2, "monitorleader");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptIsNull() {
            addCriterion("inspection_dept is null");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptIsNotNull() {
            addCriterion("inspection_dept is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptEqualTo(String value) {
            addCriterion("inspection_dept =", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptNotEqualTo(String value) {
            addCriterion("inspection_dept <>", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptGreaterThan(String value) {
            addCriterion("inspection_dept >", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_dept >=", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptLessThan(String value) {
            addCriterion("inspection_dept <", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptLessThanOrEqualTo(String value) {
            addCriterion("inspection_dept <=", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptLike(String value) {
            addCriterion("inspection_dept like", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptNotLike(String value) {
            addCriterion("inspection_dept not like", value, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptIn(List<String> values) {
            addCriterion("inspection_dept in", values, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptNotIn(List<String> values) {
            addCriterion("inspection_dept not in", values, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptBetween(String value1, String value2) {
            addCriterion("inspection_dept between", value1, value2, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andInspectionDeptNotBetween(String value1, String value2) {
            addCriterion("inspection_dept not between", value1, value2, "inspectionDept");
            return (Criteria) this;
        }

        public Criteria andIpMoneyIsNull() {
            addCriterion("ip_money is null");
            return (Criteria) this;
        }

        public Criteria andIpMoneyIsNotNull() {
            addCriterion("ip_money is not null");
            return (Criteria) this;
        }

        public Criteria andIpMoneyEqualTo(BigDecimal value) {
            addCriterion("ip_money =", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ip_money <>", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyGreaterThan(BigDecimal value) {
            addCriterion("ip_money >", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ip_money >=", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyLessThan(BigDecimal value) {
            addCriterion("ip_money <", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ip_money <=", value, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyIn(List<BigDecimal> values) {
            addCriterion("ip_money in", values, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ip_money not in", values, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ip_money between", value1, value2, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andIpMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ip_money not between", value1, value2, "ipMoney");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderIsNull() {
            addCriterion("inspection_leader is null");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderIsNotNull() {
            addCriterion("inspection_leader is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderEqualTo(String value) {
            addCriterion("inspection_leader =", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderNotEqualTo(String value) {
            addCriterion("inspection_leader <>", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderGreaterThan(String value) {
            addCriterion("inspection_leader >", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_leader >=", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderLessThan(String value) {
            addCriterion("inspection_leader <", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderLessThanOrEqualTo(String value) {
            addCriterion("inspection_leader <=", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderLike(String value) {
            addCriterion("inspection_leader like", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderNotLike(String value) {
            addCriterion("inspection_leader not like", value, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderIn(List<String> values) {
            addCriterion("inspection_leader in", values, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderNotIn(List<String> values) {
            addCriterion("inspection_leader not in", values, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderBetween(String value1, String value2) {
            addCriterion("inspection_leader between", value1, value2, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andInspectionLeaderNotBetween(String value1, String value2) {
            addCriterion("inspection_leader not between", value1, value2, "inspectionLeader");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptIsNull() {
            addCriterion("director_dept is null");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptIsNotNull() {
            addCriterion("director_dept is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptEqualTo(String value) {
            addCriterion("director_dept =", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptNotEqualTo(String value) {
            addCriterion("director_dept <>", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptGreaterThan(String value) {
            addCriterion("director_dept >", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptGreaterThanOrEqualTo(String value) {
            addCriterion("director_dept >=", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptLessThan(String value) {
            addCriterion("director_dept <", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptLessThanOrEqualTo(String value) {
            addCriterion("director_dept <=", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptLike(String value) {
            addCriterion("director_dept like", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptNotLike(String value) {
            addCriterion("director_dept not like", value, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptIn(List<String> values) {
            addCriterion("director_dept in", values, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptNotIn(List<String> values) {
            addCriterion("director_dept not in", values, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptBetween(String value1, String value2) {
            addCriterion("director_dept between", value1, value2, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDirectorDeptNotBetween(String value1, String value2) {
            addCriterion("director_dept not between", value1, value2, "directorDept");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyIsNull() {
            addCriterion("dtpact_money is null");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyIsNotNull() {
            addCriterion("dtpact_money is not null");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyEqualTo(BigDecimal value) {
            addCriterion("dtpact_money =", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyNotEqualTo(BigDecimal value) {
            addCriterion("dtpact_money <>", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyGreaterThan(BigDecimal value) {
            addCriterion("dtpact_money >", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dtpact_money >=", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyLessThan(BigDecimal value) {
            addCriterion("dtpact_money <", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dtpact_money <=", value, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyIn(List<BigDecimal> values) {
            addCriterion("dtpact_money in", values, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyNotIn(List<BigDecimal> values) {
            addCriterion("dtpact_money not in", values, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dtpact_money between", value1, value2, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDtpactMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dtpact_money not between", value1, value2, "dtpactMoney");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderIsNull() {
            addCriterion("directo_leader is null");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderIsNotNull() {
            addCriterion("directo_leader is not null");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderEqualTo(String value) {
            addCriterion("directo_leader =", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderNotEqualTo(String value) {
            addCriterion("directo_leader <>", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderGreaterThan(String value) {
            addCriterion("directo_leader >", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("directo_leader >=", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderLessThan(String value) {
            addCriterion("directo_leader <", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderLessThanOrEqualTo(String value) {
            addCriterion("directo_leader <=", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderLike(String value) {
            addCriterion("directo_leader like", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderNotLike(String value) {
            addCriterion("directo_leader not like", value, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderIn(List<String> values) {
            addCriterion("directo_leader in", values, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderNotIn(List<String> values) {
            addCriterion("directo_leader not in", values, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderBetween(String value1, String value2) {
            addCriterion("directo_leader between", value1, value2, "directoLeader");
            return (Criteria) this;
        }

        public Criteria andDirectoLeaderNotBetween(String value1, String value2) {
            addCriterion("directo_leader not between", value1, value2, "directoLeader");
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

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(Long value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(Long value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(Long value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(Long value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(Long value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(Long value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<Long> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<Long> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(Long value1, Long value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(Long value1, Long value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationIsNull() {
            addCriterion("project_plan_duration is null");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationIsNotNull() {
            addCriterion("project_plan_duration is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationEqualTo(Long value) {
            addCriterion("project_plan_duration =", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotEqualTo(Long value) {
            addCriterion("project_plan_duration <>", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationGreaterThan(Long value) {
            addCriterion("project_plan_duration >", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("project_plan_duration >=", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationLessThan(Long value) {
            addCriterion("project_plan_duration <", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationLessThanOrEqualTo(Long value) {
            addCriterion("project_plan_duration <=", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationIn(List<Long> values) {
            addCriterion("project_plan_duration in", values, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotIn(List<Long> values) {
            addCriterion("project_plan_duration not in", values, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationBetween(Long value1, Long value2) {
            addCriterion("project_plan_duration between", value1, value2, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotBetween(Long value1, Long value2) {
            addCriterion("project_plan_duration not between", value1, value2, "projectPlanDuration");
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