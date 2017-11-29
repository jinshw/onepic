package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectInfoExample() {
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

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andBuildAddIsNull() {
            addCriterion("build_add is null");
            return (Criteria) this;
        }

        public Criteria andBuildAddIsNotNull() {
            addCriterion("build_add is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAddEqualTo(String value) {
            addCriterion("build_add =", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddNotEqualTo(String value) {
            addCriterion("build_add <>", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddGreaterThan(String value) {
            addCriterion("build_add >", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddGreaterThanOrEqualTo(String value) {
            addCriterion("build_add >=", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddLessThan(String value) {
            addCriterion("build_add <", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddLessThanOrEqualTo(String value) {
            addCriterion("build_add <=", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddLike(String value) {
            addCriterion("build_add like", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddNotLike(String value) {
            addCriterion("build_add not like", value, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddIn(List<String> values) {
            addCriterion("build_add in", values, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddNotIn(List<String> values) {
            addCriterion("build_add not in", values, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddBetween(String value1, String value2) {
            addCriterion("build_add between", value1, value2, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andBuildAddNotBetween(String value1, String value2) {
            addCriterion("build_add not between", value1, value2, "buildAdd");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelIsNull() {
            addCriterion("project_leader_tel is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelIsNotNull() {
            addCriterion("project_leader_tel is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelEqualTo(String value) {
            addCriterion("project_leader_tel =", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelNotEqualTo(String value) {
            addCriterion("project_leader_tel <>", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelGreaterThan(String value) {
            addCriterion("project_leader_tel >", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader_tel >=", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelLessThan(String value) {
            addCriterion("project_leader_tel <", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelLessThanOrEqualTo(String value) {
            addCriterion("project_leader_tel <=", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelLike(String value) {
            addCriterion("project_leader_tel like", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelNotLike(String value) {
            addCriterion("project_leader_tel not like", value, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelIn(List<String> values) {
            addCriterion("project_leader_tel in", values, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelNotIn(List<String> values) {
            addCriterion("project_leader_tel not in", values, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelBetween(String value1, String value2) {
            addCriterion("project_leader_tel between", value1, value2, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderTelNotBetween(String value1, String value2) {
            addCriterion("project_leader_tel not between", value1, value2, "projectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andEngineerIsNull() {
            addCriterion("engineer is null");
            return (Criteria) this;
        }

        public Criteria andEngineerIsNotNull() {
            addCriterion("engineer is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerEqualTo(String value) {
            addCriterion("engineer =", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerNotEqualTo(String value) {
            addCriterion("engineer <>", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerGreaterThan(String value) {
            addCriterion("engineer >", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerGreaterThanOrEqualTo(String value) {
            addCriterion("engineer >=", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerLessThan(String value) {
            addCriterion("engineer <", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerLessThanOrEqualTo(String value) {
            addCriterion("engineer <=", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerLike(String value) {
            addCriterion("engineer like", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerNotLike(String value) {
            addCriterion("engineer not like", value, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerIn(List<String> values) {
            addCriterion("engineer in", values, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerNotIn(List<String> values) {
            addCriterion("engineer not in", values, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerBetween(String value1, String value2) {
            addCriterion("engineer between", value1, value2, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerNotBetween(String value1, String value2) {
            addCriterion("engineer not between", value1, value2, "engineer");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIsNull() {
            addCriterion("engineer_tel is null");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIsNotNull() {
            addCriterion("engineer_tel is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerTelEqualTo(String value) {
            addCriterion("engineer_tel =", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotEqualTo(String value) {
            addCriterion("engineer_tel <>", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelGreaterThan(String value) {
            addCriterion("engineer_tel >", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_tel >=", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLessThan(String value) {
            addCriterion("engineer_tel <", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLessThanOrEqualTo(String value) {
            addCriterion("engineer_tel <=", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLike(String value) {
            addCriterion("engineer_tel like", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotLike(String value) {
            addCriterion("engineer_tel not like", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIn(List<String> values) {
            addCriterion("engineer_tel in", values, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotIn(List<String> values) {
            addCriterion("engineer_tel not in", values, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelBetween(String value1, String value2) {
            addCriterion("engineer_tel between", value1, value2, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotBetween(String value1, String value2) {
            addCriterion("engineer_tel not between", value1, value2, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andConductorNameIsNull() {
            addCriterion("conductor_name is null");
            return (Criteria) this;
        }

        public Criteria andConductorNameIsNotNull() {
            addCriterion("conductor_name is not null");
            return (Criteria) this;
        }

        public Criteria andConductorNameEqualTo(String value) {
            addCriterion("conductor_name =", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameNotEqualTo(String value) {
            addCriterion("conductor_name <>", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameGreaterThan(String value) {
            addCriterion("conductor_name >", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameGreaterThanOrEqualTo(String value) {
            addCriterion("conductor_name >=", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameLessThan(String value) {
            addCriterion("conductor_name <", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameLessThanOrEqualTo(String value) {
            addCriterion("conductor_name <=", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameLike(String value) {
            addCriterion("conductor_name like", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameNotLike(String value) {
            addCriterion("conductor_name not like", value, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameIn(List<String> values) {
            addCriterion("conductor_name in", values, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameNotIn(List<String> values) {
            addCriterion("conductor_name not in", values, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameBetween(String value1, String value2) {
            addCriterion("conductor_name between", value1, value2, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorNameNotBetween(String value1, String value2) {
            addCriterion("conductor_name not between", value1, value2, "conductorName");
            return (Criteria) this;
        }

        public Criteria andConductorAddIsNull() {
            addCriterion("conductor_add is null");
            return (Criteria) this;
        }

        public Criteria andConductorAddIsNotNull() {
            addCriterion("conductor_add is not null");
            return (Criteria) this;
        }

        public Criteria andConductorAddEqualTo(String value) {
            addCriterion("conductor_add =", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddNotEqualTo(String value) {
            addCriterion("conductor_add <>", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddGreaterThan(String value) {
            addCriterion("conductor_add >", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddGreaterThanOrEqualTo(String value) {
            addCriterion("conductor_add >=", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddLessThan(String value) {
            addCriterion("conductor_add <", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddLessThanOrEqualTo(String value) {
            addCriterion("conductor_add <=", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddLike(String value) {
            addCriterion("conductor_add like", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddNotLike(String value) {
            addCriterion("conductor_add not like", value, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddIn(List<String> values) {
            addCriterion("conductor_add in", values, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddNotIn(List<String> values) {
            addCriterion("conductor_add not in", values, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddBetween(String value1, String value2) {
            addCriterion("conductor_add between", value1, value2, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorAddNotBetween(String value1, String value2) {
            addCriterion("conductor_add not between", value1, value2, "conductorAdd");
            return (Criteria) this;
        }

        public Criteria andConductorTelIsNull() {
            addCriterion("conductor_tel is null");
            return (Criteria) this;
        }

        public Criteria andConductorTelIsNotNull() {
            addCriterion("conductor_tel is not null");
            return (Criteria) this;
        }

        public Criteria andConductorTelEqualTo(String value) {
            addCriterion("conductor_tel =", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelNotEqualTo(String value) {
            addCriterion("conductor_tel <>", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelGreaterThan(String value) {
            addCriterion("conductor_tel >", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelGreaterThanOrEqualTo(String value) {
            addCriterion("conductor_tel >=", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelLessThan(String value) {
            addCriterion("conductor_tel <", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelLessThanOrEqualTo(String value) {
            addCriterion("conductor_tel <=", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelLike(String value) {
            addCriterion("conductor_tel like", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelNotLike(String value) {
            addCriterion("conductor_tel not like", value, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelIn(List<String> values) {
            addCriterion("conductor_tel in", values, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelNotIn(List<String> values) {
            addCriterion("conductor_tel not in", values, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelBetween(String value1, String value2) {
            addCriterion("conductor_tel between", value1, value2, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andConductorTelNotBetween(String value1, String value2) {
            addCriterion("conductor_tel not between", value1, value2, "conductorTel");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerAddIsNull() {
            addCriterion("owner_add is null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddIsNotNull() {
            addCriterion("owner_add is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddEqualTo(String value) {
            addCriterion("owner_add =", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddNotEqualTo(String value) {
            addCriterion("owner_add <>", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddGreaterThan(String value) {
            addCriterion("owner_add >", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddGreaterThanOrEqualTo(String value) {
            addCriterion("owner_add >=", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddLessThan(String value) {
            addCriterion("owner_add <", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddLessThanOrEqualTo(String value) {
            addCriterion("owner_add <=", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddLike(String value) {
            addCriterion("owner_add like", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddNotLike(String value) {
            addCriterion("owner_add not like", value, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddIn(List<String> values) {
            addCriterion("owner_add in", values, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddNotIn(List<String> values) {
            addCriterion("owner_add not in", values, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddBetween(String value1, String value2) {
            addCriterion("owner_add between", value1, value2, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerAddNotBetween(String value1, String value2) {
            addCriterion("owner_add not between", value1, value2, "ownerAdd");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIsNull() {
            addCriterion("owner_tel is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIsNotNull() {
            addCriterion("owner_tel is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTelEqualTo(String value) {
            addCriterion("owner_tel =", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotEqualTo(String value) {
            addCriterion("owner_tel <>", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelGreaterThan(String value) {
            addCriterion("owner_tel >", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelGreaterThanOrEqualTo(String value) {
            addCriterion("owner_tel >=", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLessThan(String value) {
            addCriterion("owner_tel <", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLessThanOrEqualTo(String value) {
            addCriterion("owner_tel <=", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLike(String value) {
            addCriterion("owner_tel like", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotLike(String value) {
            addCriterion("owner_tel not like", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIn(List<String> values) {
            addCriterion("owner_tel in", values, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotIn(List<String> values) {
            addCriterion("owner_tel not in", values, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelBetween(String value1, String value2) {
            addCriterion("owner_tel between", value1, value2, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotBetween(String value1, String value2) {
            addCriterion("owner_tel not between", value1, value2, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andZxbmcIsNull() {
            addCriterion("zxbmc is null");
            return (Criteria) this;
        }

        public Criteria andZxbmcIsNotNull() {
            addCriterion("zxbmc is not null");
            return (Criteria) this;
        }

        public Criteria andZxbmcEqualTo(String value) {
            addCriterion("zxbmc =", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcNotEqualTo(String value) {
            addCriterion("zxbmc <>", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcGreaterThan(String value) {
            addCriterion("zxbmc >", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcGreaterThanOrEqualTo(String value) {
            addCriterion("zxbmc >=", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcLessThan(String value) {
            addCriterion("zxbmc <", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcLessThanOrEqualTo(String value) {
            addCriterion("zxbmc <=", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcLike(String value) {
            addCriterion("zxbmc like", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcNotLike(String value) {
            addCriterion("zxbmc not like", value, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcIn(List<String> values) {
            addCriterion("zxbmc in", values, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcNotIn(List<String> values) {
            addCriterion("zxbmc not in", values, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcBetween(String value1, String value2) {
            addCriterion("zxbmc between", value1, value2, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbmcNotBetween(String value1, String value2) {
            addCriterion("zxbmc not between", value1, value2, "zxbmc");
            return (Criteria) this;
        }

        public Criteria andZxbdzIsNull() {
            addCriterion("zxbdz is null");
            return (Criteria) this;
        }

        public Criteria andZxbdzIsNotNull() {
            addCriterion("zxbdz is not null");
            return (Criteria) this;
        }

        public Criteria andZxbdzEqualTo(String value) {
            addCriterion("zxbdz =", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzNotEqualTo(String value) {
            addCriterion("zxbdz <>", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzGreaterThan(String value) {
            addCriterion("zxbdz >", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzGreaterThanOrEqualTo(String value) {
            addCriterion("zxbdz >=", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzLessThan(String value) {
            addCriterion("zxbdz <", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzLessThanOrEqualTo(String value) {
            addCriterion("zxbdz <=", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzLike(String value) {
            addCriterion("zxbdz like", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzNotLike(String value) {
            addCriterion("zxbdz not like", value, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzIn(List<String> values) {
            addCriterion("zxbdz in", values, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzNotIn(List<String> values) {
            addCriterion("zxbdz not in", values, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzBetween(String value1, String value2) {
            addCriterion("zxbdz between", value1, value2, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdzNotBetween(String value1, String value2) {
            addCriterion("zxbdz not between", value1, value2, "zxbdz");
            return (Criteria) this;
        }

        public Criteria andZxbdhIsNull() {
            addCriterion("zxbdh is null");
            return (Criteria) this;
        }

        public Criteria andZxbdhIsNotNull() {
            addCriterion("zxbdh is not null");
            return (Criteria) this;
        }

        public Criteria andZxbdhEqualTo(String value) {
            addCriterion("zxbdh =", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhNotEqualTo(String value) {
            addCriterion("zxbdh <>", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhGreaterThan(String value) {
            addCriterion("zxbdh >", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhGreaterThanOrEqualTo(String value) {
            addCriterion("zxbdh >=", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhLessThan(String value) {
            addCriterion("zxbdh <", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhLessThanOrEqualTo(String value) {
            addCriterion("zxbdh <=", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhLike(String value) {
            addCriterion("zxbdh like", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhNotLike(String value) {
            addCriterion("zxbdh not like", value, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhIn(List<String> values) {
            addCriterion("zxbdh in", values, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhNotIn(List<String> values) {
            addCriterion("zxbdh not in", values, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhBetween(String value1, String value2) {
            addCriterion("zxbdh between", value1, value2, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andZxbdhNotBetween(String value1, String value2) {
            addCriterion("zxbdh not between", value1, value2, "zxbdh");
            return (Criteria) this;
        }

        public Criteria andTenderNameIsNull() {
            addCriterion("tender_name is null");
            return (Criteria) this;
        }

        public Criteria andTenderNameIsNotNull() {
            addCriterion("tender_name is not null");
            return (Criteria) this;
        }

        public Criteria andTenderNameEqualTo(String value) {
            addCriterion("tender_name =", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameNotEqualTo(String value) {
            addCriterion("tender_name <>", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameGreaterThan(String value) {
            addCriterion("tender_name >", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("tender_name >=", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameLessThan(String value) {
            addCriterion("tender_name <", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameLessThanOrEqualTo(String value) {
            addCriterion("tender_name <=", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameLike(String value) {
            addCriterion("tender_name like", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameNotLike(String value) {
            addCriterion("tender_name not like", value, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameIn(List<String> values) {
            addCriterion("tender_name in", values, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameNotIn(List<String> values) {
            addCriterion("tender_name not in", values, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameBetween(String value1, String value2) {
            addCriterion("tender_name between", value1, value2, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderNameNotBetween(String value1, String value2) {
            addCriterion("tender_name not between", value1, value2, "tenderName");
            return (Criteria) this;
        }

        public Criteria andTenderAddIsNull() {
            addCriterion("tender_add is null");
            return (Criteria) this;
        }

        public Criteria andTenderAddIsNotNull() {
            addCriterion("tender_add is not null");
            return (Criteria) this;
        }

        public Criteria andTenderAddEqualTo(String value) {
            addCriterion("tender_add =", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddNotEqualTo(String value) {
            addCriterion("tender_add <>", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddGreaterThan(String value) {
            addCriterion("tender_add >", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddGreaterThanOrEqualTo(String value) {
            addCriterion("tender_add >=", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddLessThan(String value) {
            addCriterion("tender_add <", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddLessThanOrEqualTo(String value) {
            addCriterion("tender_add <=", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddLike(String value) {
            addCriterion("tender_add like", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddNotLike(String value) {
            addCriterion("tender_add not like", value, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddIn(List<String> values) {
            addCriterion("tender_add in", values, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddNotIn(List<String> values) {
            addCriterion("tender_add not in", values, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddBetween(String value1, String value2) {
            addCriterion("tender_add between", value1, value2, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderAddNotBetween(String value1, String value2) {
            addCriterion("tender_add not between", value1, value2, "tenderAdd");
            return (Criteria) this;
        }

        public Criteria andTenderTelIsNull() {
            addCriterion("tender_tel is null");
            return (Criteria) this;
        }

        public Criteria andTenderTelIsNotNull() {
            addCriterion("tender_tel is not null");
            return (Criteria) this;
        }

        public Criteria andTenderTelEqualTo(String value) {
            addCriterion("tender_tel =", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelNotEqualTo(String value) {
            addCriterion("tender_tel <>", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelGreaterThan(String value) {
            addCriterion("tender_tel >", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelGreaterThanOrEqualTo(String value) {
            addCriterion("tender_tel >=", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelLessThan(String value) {
            addCriterion("tender_tel <", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelLessThanOrEqualTo(String value) {
            addCriterion("tender_tel <=", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelLike(String value) {
            addCriterion("tender_tel like", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelNotLike(String value) {
            addCriterion("tender_tel not like", value, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelIn(List<String> values) {
            addCriterion("tender_tel in", values, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelNotIn(List<String> values) {
            addCriterion("tender_tel not in", values, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelBetween(String value1, String value2) {
            addCriterion("tender_tel between", value1, value2, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andTenderTelNotBetween(String value1, String value2) {
            addCriterion("tender_tel not between", value1, value2, "tenderTel");
            return (Criteria) this;
        }

        public Criteria andDesignNameIsNull() {
            addCriterion("design_name is null");
            return (Criteria) this;
        }

        public Criteria andDesignNameIsNotNull() {
            addCriterion("design_name is not null");
            return (Criteria) this;
        }

        public Criteria andDesignNameEqualTo(String value) {
            addCriterion("design_name =", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameNotEqualTo(String value) {
            addCriterion("design_name <>", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameGreaterThan(String value) {
            addCriterion("design_name >", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameGreaterThanOrEqualTo(String value) {
            addCriterion("design_name >=", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameLessThan(String value) {
            addCriterion("design_name <", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameLessThanOrEqualTo(String value) {
            addCriterion("design_name <=", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameLike(String value) {
            addCriterion("design_name like", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameNotLike(String value) {
            addCriterion("design_name not like", value, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameIn(List<String> values) {
            addCriterion("design_name in", values, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameNotIn(List<String> values) {
            addCriterion("design_name not in", values, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameBetween(String value1, String value2) {
            addCriterion("design_name between", value1, value2, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignNameNotBetween(String value1, String value2) {
            addCriterion("design_name not between", value1, value2, "designName");
            return (Criteria) this;
        }

        public Criteria andDesignAddIsNull() {
            addCriterion("design_add is null");
            return (Criteria) this;
        }

        public Criteria andDesignAddIsNotNull() {
            addCriterion("design_add is not null");
            return (Criteria) this;
        }

        public Criteria andDesignAddEqualTo(String value) {
            addCriterion("design_add =", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddNotEqualTo(String value) {
            addCriterion("design_add <>", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddGreaterThan(String value) {
            addCriterion("design_add >", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddGreaterThanOrEqualTo(String value) {
            addCriterion("design_add >=", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddLessThan(String value) {
            addCriterion("design_add <", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddLessThanOrEqualTo(String value) {
            addCriterion("design_add <=", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddLike(String value) {
            addCriterion("design_add like", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddNotLike(String value) {
            addCriterion("design_add not like", value, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddIn(List<String> values) {
            addCriterion("design_add in", values, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddNotIn(List<String> values) {
            addCriterion("design_add not in", values, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddBetween(String value1, String value2) {
            addCriterion("design_add between", value1, value2, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignAddNotBetween(String value1, String value2) {
            addCriterion("design_add not between", value1, value2, "designAdd");
            return (Criteria) this;
        }

        public Criteria andDesignTelIsNull() {
            addCriterion("design_tel is null");
            return (Criteria) this;
        }

        public Criteria andDesignTelIsNotNull() {
            addCriterion("design_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDesignTelEqualTo(String value) {
            addCriterion("design_tel =", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelNotEqualTo(String value) {
            addCriterion("design_tel <>", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelGreaterThan(String value) {
            addCriterion("design_tel >", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelGreaterThanOrEqualTo(String value) {
            addCriterion("design_tel >=", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelLessThan(String value) {
            addCriterion("design_tel <", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelLessThanOrEqualTo(String value) {
            addCriterion("design_tel <=", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelLike(String value) {
            addCriterion("design_tel like", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelNotLike(String value) {
            addCriterion("design_tel not like", value, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelIn(List<String> values) {
            addCriterion("design_tel in", values, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelNotIn(List<String> values) {
            addCriterion("design_tel not in", values, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelBetween(String value1, String value2) {
            addCriterion("design_tel between", value1, value2, "designTel");
            return (Criteria) this;
        }

        public Criteria andDesignTelNotBetween(String value1, String value2) {
            addCriterion("design_tel not between", value1, value2, "designTel");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedIsNull() {
            addCriterion("project_totalInversted is null");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedIsNotNull() {
            addCriterion("project_totalInversted is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedEqualTo(BigDecimal value) {
            addCriterion("project_totalInversted =", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedNotEqualTo(BigDecimal value) {
            addCriterion("project_totalInversted <>", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedGreaterThan(BigDecimal value) {
            addCriterion("project_totalInversted >", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_totalInversted >=", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedLessThan(BigDecimal value) {
            addCriterion("project_totalInversted <", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_totalInversted <=", value, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedIn(List<BigDecimal> values) {
            addCriterion("project_totalInversted in", values, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedNotIn(List<BigDecimal> values) {
            addCriterion("project_totalInversted not in", values, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_totalInversted between", value1, value2, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalinverstedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_totalInversted not between", value1, value2, "projectTotalinversted");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenIsNull() {
            addCriterion("project_total_len is null");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenIsNotNull() {
            addCriterion("project_total_len is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenEqualTo(BigDecimal value) {
            addCriterion("project_total_len =", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenNotEqualTo(BigDecimal value) {
            addCriterion("project_total_len <>", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenGreaterThan(BigDecimal value) {
            addCriterion("project_total_len >", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_total_len >=", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenLessThan(BigDecimal value) {
            addCriterion("project_total_len <", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_total_len <=", value, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenIn(List<BigDecimal> values) {
            addCriterion("project_total_len in", values, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenNotIn(List<BigDecimal> values) {
            addCriterion("project_total_len not in", values, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_total_len between", value1, value2, "projectTotalLen");
            return (Criteria) this;
        }

        public Criteria andProjectTotalLenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_total_len not between", value1, value2, "projectTotalLen");
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

        public Criteria andProjectPlanDurationEqualTo(Integer value) {
            addCriterion("project_plan_duration =", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotEqualTo(Integer value) {
            addCriterion("project_plan_duration <>", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationGreaterThan(Integer value) {
            addCriterion("project_plan_duration >", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_plan_duration >=", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationLessThan(Integer value) {
            addCriterion("project_plan_duration <", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationLessThanOrEqualTo(Integer value) {
            addCriterion("project_plan_duration <=", value, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationIn(List<Integer> values) {
            addCriterion("project_plan_duration in", values, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotIn(List<Integer> values) {
            addCriterion("project_plan_duration not in", values, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationBetween(Integer value1, Integer value2) {
            addCriterion("project_plan_duration between", value1, value2, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andProjectPlanDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("project_plan_duration not between", value1, value2, "projectPlanDuration");
            return (Criteria) this;
        }

        public Criteria andLagDayIsNull() {
            addCriterion("lag_day is null");
            return (Criteria) this;
        }

        public Criteria andLagDayIsNotNull() {
            addCriterion("lag_day is not null");
            return (Criteria) this;
        }

        public Criteria andLagDayEqualTo(Integer value) {
            addCriterion("lag_day =", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotEqualTo(Integer value) {
            addCriterion("lag_day <>", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayGreaterThan(Integer value) {
            addCriterion("lag_day >", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("lag_day >=", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayLessThan(Integer value) {
            addCriterion("lag_day <", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayLessThanOrEqualTo(Integer value) {
            addCriterion("lag_day <=", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayIn(List<Integer> values) {
            addCriterion("lag_day in", values, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotIn(List<Integer> values) {
            addCriterion("lag_day not in", values, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayBetween(Integer value1, Integer value2) {
            addCriterion("lag_day between", value1, value2, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotBetween(Integer value1, Integer value2) {
            addCriterion("lag_day not between", value1, value2, "lagDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayIsNull() {
            addCriterion("begin_day is null");
            return (Criteria) this;
        }

        public Criteria andBeginDayIsNotNull() {
            addCriterion("begin_day is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDayEqualTo(Date value) {
            addCriterionForJDBCDate("begin_day =", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_day <>", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_day >", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_day >=", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayLessThan(Date value) {
            addCriterionForJDBCDate("begin_day <", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_day <=", value, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayIn(List<Date> values) {
            addCriterionForJDBCDate("begin_day in", values, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_day not in", values, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_day between", value1, value2, "beginDay");
            return (Criteria) this;
        }

        public Criteria andBeginDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_day not between", value1, value2, "beginDay");
            return (Criteria) this;
        }

        public Criteria andEndDayIsNull() {
            addCriterion("end_day is null");
            return (Criteria) this;
        }

        public Criteria andEndDayIsNotNull() {
            addCriterion("end_day is not null");
            return (Criteria) this;
        }

        public Criteria andEndDayEqualTo(Date value) {
            addCriterionForJDBCDate("end_day =", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_day <>", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayGreaterThan(Date value) {
            addCriterionForJDBCDate("end_day >", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_day >=", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayLessThan(Date value) {
            addCriterionForJDBCDate("end_day <", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_day <=", value, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayIn(List<Date> values) {
            addCriterionForJDBCDate("end_day in", values, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_day not in", values, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_day between", value1, value2, "endDay");
            return (Criteria) this;
        }

        public Criteria andEndDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_day not between", value1, value2, "endDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayIsNull() {
            addCriterion("completion_day is null");
            return (Criteria) this;
        }

        public Criteria andCompletionDayIsNotNull() {
            addCriterion("completion_day is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionDayEqualTo(Date value) {
            addCriterionForJDBCDate("completion_day =", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("completion_day <>", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayGreaterThan(Date value) {
            addCriterionForJDBCDate("completion_day >", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_day >=", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayLessThan(Date value) {
            addCriterionForJDBCDate("completion_day <", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_day <=", value, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayIn(List<Date> values) {
            addCriterionForJDBCDate("completion_day in", values, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("completion_day not in", values, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_day between", value1, value2, "completionDay");
            return (Criteria) this;
        }

        public Criteria andCompletionDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_day not between", value1, value2, "completionDay");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateIsNull() {
            addCriterion("approve_estimate is null");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateIsNotNull() {
            addCriterion("approve_estimate is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateEqualTo(BigDecimal value) {
            addCriterion("approve_estimate =", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateNotEqualTo(BigDecimal value) {
            addCriterion("approve_estimate <>", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateGreaterThan(BigDecimal value) {
            addCriterion("approve_estimate >", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("approve_estimate >=", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateLessThan(BigDecimal value) {
            addCriterion("approve_estimate <", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("approve_estimate <=", value, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateIn(List<BigDecimal> values) {
            addCriterion("approve_estimate in", values, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateNotIn(List<BigDecimal> values) {
            addCriterion("approve_estimate not in", values, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approve_estimate between", value1, value2, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andApproveEstimateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approve_estimate not between", value1, value2, "approveEstimate");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(BigDecimal value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(BigDecimal value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(BigDecimal value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(BigDecimal value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<BigDecimal> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<BigDecimal> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget not between", value1, value2, "budget");
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

        public Criteria andProjectPropertyAIsNull() {
            addCriterion("project_property_a is null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyAIsNotNull() {
            addCriterion("project_property_a is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyAEqualTo(String value) {
            addCriterion("project_property_a =", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyANotEqualTo(String value) {
            addCriterion("project_property_a <>", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyAGreaterThan(String value) {
            addCriterion("project_property_a >", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyAGreaterThanOrEqualTo(String value) {
            addCriterion("project_property_a >=", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyALessThan(String value) {
            addCriterion("project_property_a <", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyALessThanOrEqualTo(String value) {
            addCriterion("project_property_a <=", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyALike(String value) {
            addCriterion("project_property_a like", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyANotLike(String value) {
            addCriterion("project_property_a not like", value, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyAIn(List<String> values) {
            addCriterion("project_property_a in", values, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyANotIn(List<String> values) {
            addCriterion("project_property_a not in", values, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyABetween(String value1, String value2) {
            addCriterion("project_property_a between", value1, value2, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyANotBetween(String value1, String value2) {
            addCriterion("project_property_a not between", value1, value2, "projectPropertyA");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBIsNull() {
            addCriterion("project_property_b is null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBIsNotNull() {
            addCriterion("project_property_b is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBEqualTo(String value) {
            addCriterion("project_property_b =", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBNotEqualTo(String value) {
            addCriterion("project_property_b <>", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBGreaterThan(String value) {
            addCriterion("project_property_b >", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBGreaterThanOrEqualTo(String value) {
            addCriterion("project_property_b >=", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBLessThan(String value) {
            addCriterion("project_property_b <", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBLessThanOrEqualTo(String value) {
            addCriterion("project_property_b <=", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBLike(String value) {
            addCriterion("project_property_b like", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBNotLike(String value) {
            addCriterion("project_property_b not like", value, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBIn(List<String> values) {
            addCriterion("project_property_b in", values, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBNotIn(List<String> values) {
            addCriterion("project_property_b not in", values, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBBetween(String value1, String value2) {
            addCriterion("project_property_b between", value1, value2, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBNotBetween(String value1, String value2) {
            addCriterion("project_property_b not between", value1, value2, "projectPropertyB");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCIsNull() {
            addCriterion("project_property_c is null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCIsNotNull() {
            addCriterion("project_property_c is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCEqualTo(String value) {
            addCriterion("project_property_c =", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCNotEqualTo(String value) {
            addCriterion("project_property_c <>", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCGreaterThan(String value) {
            addCriterion("project_property_c >", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCGreaterThanOrEqualTo(String value) {
            addCriterion("project_property_c >=", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCLessThan(String value) {
            addCriterion("project_property_c <", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCLessThanOrEqualTo(String value) {
            addCriterion("project_property_c <=", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCLike(String value) {
            addCriterion("project_property_c like", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCNotLike(String value) {
            addCriterion("project_property_c not like", value, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCIn(List<String> values) {
            addCriterion("project_property_c in", values, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCNotIn(List<String> values) {
            addCriterion("project_property_c not in", values, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCBetween(String value1, String value2) {
            addCriterion("project_property_c between", value1, value2, "projectPropertyC");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyCNotBetween(String value1, String value2) {
            addCriterion("project_property_c not between", value1, value2, "projectPropertyC");
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

        public Criteria andXmlxdzhIsNull() {
            addCriterion("xmlxdzh is null");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhIsNotNull() {
            addCriterion("xmlxdzh is not null");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhEqualTo(String value) {
            addCriterion("xmlxdzh =", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhNotEqualTo(String value) {
            addCriterion("xmlxdzh <>", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhGreaterThan(String value) {
            addCriterion("xmlxdzh >", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhGreaterThanOrEqualTo(String value) {
            addCriterion("xmlxdzh >=", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhLessThan(String value) {
            addCriterion("xmlxdzh <", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhLessThanOrEqualTo(String value) {
            addCriterion("xmlxdzh <=", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhLike(String value) {
            addCriterion("xmlxdzh like", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhNotLike(String value) {
            addCriterion("xmlxdzh not like", value, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhIn(List<String> values) {
            addCriterion("xmlxdzh in", values, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhNotIn(List<String> values) {
            addCriterion("xmlxdzh not in", values, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhBetween(String value1, String value2) {
            addCriterion("xmlxdzh between", value1, value2, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxdzhNotBetween(String value1, String value2) {
            addCriterion("xmlxdzh not between", value1, value2, "xmlxdzh");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmIsNull() {
            addCriterion("xmlxrxm is null");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmIsNotNull() {
            addCriterion("xmlxrxm is not null");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmEqualTo(String value) {
            addCriterion("xmlxrxm =", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmNotEqualTo(String value) {
            addCriterion("xmlxrxm <>", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmGreaterThan(String value) {
            addCriterion("xmlxrxm >", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmGreaterThanOrEqualTo(String value) {
            addCriterion("xmlxrxm >=", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmLessThan(String value) {
            addCriterion("xmlxrxm <", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmLessThanOrEqualTo(String value) {
            addCriterion("xmlxrxm <=", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmLike(String value) {
            addCriterion("xmlxrxm like", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmNotLike(String value) {
            addCriterion("xmlxrxm not like", value, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmIn(List<String> values) {
            addCriterion("xmlxrxm in", values, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmNotIn(List<String> values) {
            addCriterion("xmlxrxm not in", values, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmBetween(String value1, String value2) {
            addCriterion("xmlxrxm between", value1, value2, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andXmlxrxmNotBetween(String value1, String value2) {
            addCriterion("xmlxrxm not between", value1, value2, "xmlxrxm");
            return (Criteria) this;
        }

        public Criteria andLxrdhIsNull() {
            addCriterion("lxrdh is null");
            return (Criteria) this;
        }

        public Criteria andLxrdhIsNotNull() {
            addCriterion("lxrdh is not null");
            return (Criteria) this;
        }

        public Criteria andLxrdhEqualTo(String value) {
            addCriterion("lxrdh =", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhNotEqualTo(String value) {
            addCriterion("lxrdh <>", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhGreaterThan(String value) {
            addCriterion("lxrdh >", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhGreaterThanOrEqualTo(String value) {
            addCriterion("lxrdh >=", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhLessThan(String value) {
            addCriterion("lxrdh <", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhLessThanOrEqualTo(String value) {
            addCriterion("lxrdh <=", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhLike(String value) {
            addCriterion("lxrdh like", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhNotLike(String value) {
            addCriterion("lxrdh not like", value, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhIn(List<String> values) {
            addCriterion("lxrdh in", values, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhNotIn(List<String> values) {
            addCriterion("lxrdh not in", values, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhBetween(String value1, String value2) {
            addCriterion("lxrdh between", value1, value2, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andLxrdhNotBetween(String value1, String value2) {
            addCriterion("lxrdh not between", value1, value2, "lxrdh");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldIsNull() {
            addCriterion("xmzhgdwjfgld is null");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldIsNotNull() {
            addCriterion("xmzhgdwjfgld is not null");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldEqualTo(String value) {
            addCriterion("xmzhgdwjfgld =", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldNotEqualTo(String value) {
            addCriterion("xmzhgdwjfgld <>", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldGreaterThan(String value) {
            addCriterion("xmzhgdwjfgld >", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldGreaterThanOrEqualTo(String value) {
            addCriterion("xmzhgdwjfgld >=", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldLessThan(String value) {
            addCriterion("xmzhgdwjfgld <", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldLessThanOrEqualTo(String value) {
            addCriterion("xmzhgdwjfgld <=", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldLike(String value) {
            addCriterion("xmzhgdwjfgld like", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldNotLike(String value) {
            addCriterion("xmzhgdwjfgld not like", value, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldIn(List<String> values) {
            addCriterion("xmzhgdwjfgld in", values, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldNotIn(List<String> values) {
            addCriterion("xmzhgdwjfgld not in", values, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldBetween(String value1, String value2) {
            addCriterion("xmzhgdwjfgld between", value1, value2, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andXmzhgdwjfgldNotBetween(String value1, String value2) {
            addCriterion("xmzhgdwjfgld not between", value1, value2, "xmzhgdwjfgld");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhIsNull() {
            addCriterion("chbshjpfwh is null");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhIsNotNull() {
            addCriterion("chbshjpfwh is not null");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhEqualTo(String value) {
            addCriterion("chbshjpfwh =", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhNotEqualTo(String value) {
            addCriterion("chbshjpfwh <>", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhGreaterThan(String value) {
            addCriterion("chbshjpfwh >", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhGreaterThanOrEqualTo(String value) {
            addCriterion("chbshjpfwh >=", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhLessThan(String value) {
            addCriterion("chbshjpfwh <", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhLessThanOrEqualTo(String value) {
            addCriterion("chbshjpfwh <=", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhLike(String value) {
            addCriterion("chbshjpfwh like", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhNotLike(String value) {
            addCriterion("chbshjpfwh not like", value, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhIn(List<String> values) {
            addCriterion("chbshjpfwh in", values, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhNotIn(List<String> values) {
            addCriterion("chbshjpfwh not in", values, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhBetween(String value1, String value2) {
            addCriterion("chbshjpfwh between", value1, value2, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfwhNotBetween(String value1, String value2) {
            addCriterion("chbshjpfwh not between", value1, value2, "chbshjpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhIsNull() {
            addCriterion("shgtpfwh is null");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhIsNotNull() {
            addCriterion("shgtpfwh is not null");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhEqualTo(String value) {
            addCriterion("shgtpfwh =", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhNotEqualTo(String value) {
            addCriterion("shgtpfwh <>", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhGreaterThan(String value) {
            addCriterion("shgtpfwh >", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhGreaterThanOrEqualTo(String value) {
            addCriterion("shgtpfwh >=", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhLessThan(String value) {
            addCriterion("shgtpfwh <", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhLessThanOrEqualTo(String value) {
            addCriterion("shgtpfwh <=", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhLike(String value) {
            addCriterion("shgtpfwh like", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhNotLike(String value) {
            addCriterion("shgtpfwh not like", value, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhIn(List<String> values) {
            addCriterion("shgtpfwh in", values, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhNotIn(List<String> values) {
            addCriterion("shgtpfwh not in", values, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhBetween(String value1, String value2) {
            addCriterion("shgtpfwh between", value1, value2, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andShgtpfwhNotBetween(String value1, String value2) {
            addCriterion("shgtpfwh not between", value1, value2, "shgtpfwh");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjIsNull() {
            addCriterion("chbshjpfshj is null");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjIsNotNull() {
            addCriterion("chbshjpfshj is not null");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjEqualTo(Date value) {
            addCriterionForJDBCDate("chbshjpfshj =", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjNotEqualTo(Date value) {
            addCriterionForJDBCDate("chbshjpfshj <>", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjGreaterThan(Date value) {
            addCriterionForJDBCDate("chbshjpfshj >", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("chbshjpfshj >=", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjLessThan(Date value) {
            addCriterionForJDBCDate("chbshjpfshj <", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("chbshjpfshj <=", value, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjIn(List<Date> values) {
            addCriterionForJDBCDate("chbshjpfshj in", values, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjNotIn(List<Date> values) {
            addCriterionForJDBCDate("chbshjpfshj not in", values, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("chbshjpfshj between", value1, value2, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andChbshjpfshjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("chbshjpfshj not between", value1, value2, "chbshjpfshj");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqIsNull() {
            addCriterion("shgtpfrq is null");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqIsNotNull() {
            addCriterion("shgtpfrq is not null");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqEqualTo(Date value) {
            addCriterionForJDBCDate("shgtpfrq =", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("shgtpfrq <>", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqGreaterThan(Date value) {
            addCriterionForJDBCDate("shgtpfrq >", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shgtpfrq >=", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqLessThan(Date value) {
            addCriterionForJDBCDate("shgtpfrq <", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shgtpfrq <=", value, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqIn(List<Date> values) {
            addCriterionForJDBCDate("shgtpfrq in", values, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("shgtpfrq not in", values, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shgtpfrq between", value1, value2, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andShgtpfrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shgtpfrq not between", value1, value2, "shgtpfrq");
            return (Criteria) this;
        }

        public Criteria andQdzhhIsNull() {
            addCriterion("qdzhh is null");
            return (Criteria) this;
        }

        public Criteria andQdzhhIsNotNull() {
            addCriterion("qdzhh is not null");
            return (Criteria) this;
        }

        public Criteria andQdzhhEqualTo(String value) {
            addCriterion("qdzhh =", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhNotEqualTo(String value) {
            addCriterion("qdzhh <>", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhGreaterThan(String value) {
            addCriterion("qdzhh >", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhGreaterThanOrEqualTo(String value) {
            addCriterion("qdzhh >=", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhLessThan(String value) {
            addCriterion("qdzhh <", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhLessThanOrEqualTo(String value) {
            addCriterion("qdzhh <=", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhLike(String value) {
            addCriterion("qdzhh like", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhNotLike(String value) {
            addCriterion("qdzhh not like", value, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhIn(List<String> values) {
            addCriterion("qdzhh in", values, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhNotIn(List<String> values) {
            addCriterion("qdzhh not in", values, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhBetween(String value1, String value2) {
            addCriterion("qdzhh between", value1, value2, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andQdzhhNotBetween(String value1, String value2) {
            addCriterion("qdzhh not between", value1, value2, "qdzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhIsNull() {
            addCriterion("jshzhh is null");
            return (Criteria) this;
        }

        public Criteria andJshzhhIsNotNull() {
            addCriterion("jshzhh is not null");
            return (Criteria) this;
        }

        public Criteria andJshzhhEqualTo(String value) {
            addCriterion("jshzhh =", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhNotEqualTo(String value) {
            addCriterion("jshzhh <>", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhGreaterThan(String value) {
            addCriterion("jshzhh >", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhGreaterThanOrEqualTo(String value) {
            addCriterion("jshzhh >=", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhLessThan(String value) {
            addCriterion("jshzhh <", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhLessThanOrEqualTo(String value) {
            addCriterion("jshzhh <=", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhLike(String value) {
            addCriterion("jshzhh like", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhNotLike(String value) {
            addCriterion("jshzhh not like", value, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhIn(List<String> values) {
            addCriterion("jshzhh in", values, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhNotIn(List<String> values) {
            addCriterion("jshzhh not in", values, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhBetween(String value1, String value2) {
            addCriterion("jshzhh between", value1, value2, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshzhhNotBetween(String value1, String value2) {
            addCriterion("jshzhh not between", value1, value2, "jshzhh");
            return (Criteria) this;
        }

        public Criteria andJshgmIsNull() {
            addCriterion("jshgm is null");
            return (Criteria) this;
        }

        public Criteria andJshgmIsNotNull() {
            addCriterion("jshgm is not null");
            return (Criteria) this;
        }

        public Criteria andJshgmEqualTo(String value) {
            addCriterion("jshgm =", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmNotEqualTo(String value) {
            addCriterion("jshgm <>", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmGreaterThan(String value) {
            addCriterion("jshgm >", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmGreaterThanOrEqualTo(String value) {
            addCriterion("jshgm >=", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmLessThan(String value) {
            addCriterion("jshgm <", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmLessThanOrEqualTo(String value) {
            addCriterion("jshgm <=", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmLike(String value) {
            addCriterion("jshgm like", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmNotLike(String value) {
            addCriterion("jshgm not like", value, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmIn(List<String> values) {
            addCriterion("jshgm in", values, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmNotIn(List<String> values) {
            addCriterion("jshgm not in", values, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmBetween(String value1, String value2) {
            addCriterion("jshgm between", value1, value2, "jshgm");
            return (Criteria) this;
        }

        public Criteria andJshgmNotBetween(String value1, String value2) {
            addCriterion("jshgm not between", value1, value2, "jshgm");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhIsNull() {
            addCriterion("zhyjshbzh is null");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhIsNotNull() {
            addCriterion("zhyjshbzh is not null");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhEqualTo(String value) {
            addCriterion("zhyjshbzh =", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhNotEqualTo(String value) {
            addCriterion("zhyjshbzh <>", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhGreaterThan(String value) {
            addCriterion("zhyjshbzh >", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhGreaterThanOrEqualTo(String value) {
            addCriterion("zhyjshbzh >=", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhLessThan(String value) {
            addCriterion("zhyjshbzh <", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhLessThanOrEqualTo(String value) {
            addCriterion("zhyjshbzh <=", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhLike(String value) {
            addCriterion("zhyjshbzh like", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhNotLike(String value) {
            addCriterion("zhyjshbzh not like", value, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhIn(List<String> values) {
            addCriterion("zhyjshbzh in", values, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhNotIn(List<String> values) {
            addCriterion("zhyjshbzh not in", values, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhBetween(String value1, String value2) {
            addCriterion("zhyjshbzh between", value1, value2, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andZhyjshbzhNotBetween(String value1, String value2) {
            addCriterion("zhyjshbzh not between", value1, value2, "zhyjshbzh");
            return (Criteria) this;
        }

        public Criteria andJshdwIsNull() {
            addCriterion("jshdw is null");
            return (Criteria) this;
        }

        public Criteria andJshdwIsNotNull() {
            addCriterion("jshdw is not null");
            return (Criteria) this;
        }

        public Criteria andJshdwEqualTo(String value) {
            addCriterion("jshdw =", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwNotEqualTo(String value) {
            addCriterion("jshdw <>", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwGreaterThan(String value) {
            addCriterion("jshdw >", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwGreaterThanOrEqualTo(String value) {
            addCriterion("jshdw >=", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwLessThan(String value) {
            addCriterion("jshdw <", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwLessThanOrEqualTo(String value) {
            addCriterion("jshdw <=", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwLike(String value) {
            addCriterion("jshdw like", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwNotLike(String value) {
            addCriterion("jshdw not like", value, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwIn(List<String> values) {
            addCriterion("jshdw in", values, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwNotIn(List<String> values) {
            addCriterion("jshdw not in", values, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwBetween(String value1, String value2) {
            addCriterion("jshdw between", value1, value2, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwNotBetween(String value1, String value2) {
            addCriterion("jshdw not between", value1, value2, "jshdw");
            return (Criteria) this;
        }

        public Criteria andJshdwdzIsNull() {
            addCriterion("jshdwdz is null");
            return (Criteria) this;
        }

        public Criteria andJshdwdzIsNotNull() {
            addCriterion("jshdwdz is not null");
            return (Criteria) this;
        }

        public Criteria andJshdwdzEqualTo(String value) {
            addCriterion("jshdwdz =", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzNotEqualTo(String value) {
            addCriterion("jshdwdz <>", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzGreaterThan(String value) {
            addCriterion("jshdwdz >", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzGreaterThanOrEqualTo(String value) {
            addCriterion("jshdwdz >=", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzLessThan(String value) {
            addCriterion("jshdwdz <", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzLessThanOrEqualTo(String value) {
            addCriterion("jshdwdz <=", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzLike(String value) {
            addCriterion("jshdwdz like", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzNotLike(String value) {
            addCriterion("jshdwdz not like", value, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzIn(List<String> values) {
            addCriterion("jshdwdz in", values, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzNotIn(List<String> values) {
            addCriterion("jshdwdz not in", values, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzBetween(String value1, String value2) {
            addCriterion("jshdwdz between", value1, value2, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdzNotBetween(String value1, String value2) {
            addCriterion("jshdwdz not between", value1, value2, "jshdwdz");
            return (Criteria) this;
        }

        public Criteria andJshdwdhIsNull() {
            addCriterion("jshdwdh is null");
            return (Criteria) this;
        }

        public Criteria andJshdwdhIsNotNull() {
            addCriterion("jshdwdh is not null");
            return (Criteria) this;
        }

        public Criteria andJshdwdhEqualTo(String value) {
            addCriterion("jshdwdh =", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhNotEqualTo(String value) {
            addCriterion("jshdwdh <>", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhGreaterThan(String value) {
            addCriterion("jshdwdh >", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhGreaterThanOrEqualTo(String value) {
            addCriterion("jshdwdh >=", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhLessThan(String value) {
            addCriterion("jshdwdh <", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhLessThanOrEqualTo(String value) {
            addCriterion("jshdwdh <=", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhLike(String value) {
            addCriterion("jshdwdh like", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhNotLike(String value) {
            addCriterion("jshdwdh not like", value, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhIn(List<String> values) {
            addCriterion("jshdwdh in", values, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhNotIn(List<String> values) {
            addCriterion("jshdwdh not in", values, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhBetween(String value1, String value2) {
            addCriterion("jshdwdh between", value1, value2, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andJshdwdhNotBetween(String value1, String value2) {
            addCriterion("jshdwdh not between", value1, value2, "jshdwdh");
            return (Criteria) this;
        }

        public Criteria andGchgmIsNull() {
            addCriterion("gchgm is null");
            return (Criteria) this;
        }

        public Criteria andGchgmIsNotNull() {
            addCriterion("gchgm is not null");
            return (Criteria) this;
        }

        public Criteria andGchgmEqualTo(String value) {
            addCriterion("gchgm =", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmNotEqualTo(String value) {
            addCriterion("gchgm <>", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmGreaterThan(String value) {
            addCriterion("gchgm >", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmGreaterThanOrEqualTo(String value) {
            addCriterion("gchgm >=", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmLessThan(String value) {
            addCriterion("gchgm <", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmLessThanOrEqualTo(String value) {
            addCriterion("gchgm <=", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmLike(String value) {
            addCriterion("gchgm like", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmNotLike(String value) {
            addCriterion("gchgm not like", value, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmIn(List<String> values) {
            addCriterion("gchgm in", values, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmNotIn(List<String> values) {
            addCriterion("gchgm not in", values, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmBetween(String value1, String value2) {
            addCriterion("gchgm between", value1, value2, "gchgm");
            return (Criteria) this;
        }

        public Criteria andGchgmNotBetween(String value1, String value2) {
            addCriterion("gchgm not between", value1, value2, "gchgm");
            return (Criteria) this;
        }

        public Criteria andJshbzhIsNull() {
            addCriterion("jshbzh is null");
            return (Criteria) this;
        }

        public Criteria andJshbzhIsNotNull() {
            addCriterion("jshbzh is not null");
            return (Criteria) this;
        }

        public Criteria andJshbzhEqualTo(String value) {
            addCriterion("jshbzh =", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhNotEqualTo(String value) {
            addCriterion("jshbzh <>", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhGreaterThan(String value) {
            addCriterion("jshbzh >", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhGreaterThanOrEqualTo(String value) {
            addCriterion("jshbzh >=", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhLessThan(String value) {
            addCriterion("jshbzh <", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhLessThanOrEqualTo(String value) {
            addCriterion("jshbzh <=", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhLike(String value) {
            addCriterion("jshbzh like", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhNotLike(String value) {
            addCriterion("jshbzh not like", value, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhIn(List<String> values) {
            addCriterion("jshbzh in", values, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhNotIn(List<String> values) {
            addCriterion("jshbzh not in", values, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhBetween(String value1, String value2) {
            addCriterion("jshbzh between", value1, value2, "jshbzh");
            return (Criteria) this;
        }

        public Criteria andJshbzhNotBetween(String value1, String value2) {
            addCriterion("jshbzh not between", value1, value2, "jshbzh");
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnIsNull() {
            addCriterion("qianqixmisbn is null");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnIsNotNull() {
            addCriterion("qianqixmisbn is not null");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnEqualTo(String value) {
            addCriterion("qianqixmisbn =", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnNotEqualTo(String value) {
            addCriterion("qianqixmisbn <>", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnGreaterThan(String value) {
            addCriterion("qianqixmisbn >", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnGreaterThanOrEqualTo(String value) {
            addCriterion("qianqixmisbn >=", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnLessThan(String value) {
            addCriterion("qianqixmisbn <", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnLessThanOrEqualTo(String value) {
            addCriterion("qianqixmisbn <=", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnLike(String value) {
            addCriterion("qianqixmisbn like", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnNotLike(String value) {
            addCriterion("qianqixmisbn not like", value, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnIn(List<String> values) {
            addCriterion("qianqixmisbn in", values, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnNotIn(List<String> values) {
            addCriterion("qianqixmisbn not in", values, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnBetween(String value1, String value2) {
            addCriterion("qianqixmisbn between", value1, value2, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmisbnNotBetween(String value1, String value2) {
            addCriterion("qianqixmisbn not between", value1, value2, "qianqixmisbn");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcIsNull() {
            addCriterion("qianqixmmc is null");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcIsNotNull() {
            addCriterion("qianqixmmc is not null");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcEqualTo(String value) {
            addCriterion("qianqixmmc =", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcNotEqualTo(String value) {
            addCriterion("qianqixmmc <>", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcGreaterThan(String value) {
            addCriterion("qianqixmmc >", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcGreaterThanOrEqualTo(String value) {
            addCriterion("qianqixmmc >=", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcLessThan(String value) {
            addCriterion("qianqixmmc <", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcLessThanOrEqualTo(String value) {
            addCriterion("qianqixmmc <=", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcLike(String value) {
            addCriterion("qianqixmmc like", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcNotLike(String value) {
            addCriterion("qianqixmmc not like", value, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcIn(List<String> values) {
            addCriterion("qianqixmmc in", values, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcNotIn(List<String> values) {
            addCriterion("qianqixmmc not in", values, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcBetween(String value1, String value2) {
            addCriterion("qianqixmmc between", value1, value2, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andQianqixmmcNotBetween(String value1, String value2) {
            addCriterion("qianqixmmc not between", value1, value2, "qianqixmmc");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjIsNull() {
            addCriterion("bgxyqdshj is null");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjIsNotNull() {
            addCriterion("bgxyqdshj is not null");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjEqualTo(Date value) {
            addCriterionForJDBCDate("bgxyqdshj =", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjNotEqualTo(Date value) {
            addCriterionForJDBCDate("bgxyqdshj <>", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjGreaterThan(Date value) {
            addCriterionForJDBCDate("bgxyqdshj >", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bgxyqdshj >=", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjLessThan(Date value) {
            addCriterionForJDBCDate("bgxyqdshj <", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bgxyqdshj <=", value, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjIn(List<Date> values) {
            addCriterionForJDBCDate("bgxyqdshj in", values, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjNotIn(List<Date> values) {
            addCriterionForJDBCDate("bgxyqdshj not in", values, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bgxyqdshj between", value1, value2, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andBgxyqdshjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bgxyqdshj not between", value1, value2, "bgxyqdshj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjIsNull() {
            addCriterion("zhdbcfhj is null");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjIsNotNull() {
            addCriterion("zhdbcfhj is not null");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjEqualTo(BigDecimal value) {
            addCriterion("zhdbcfhj =", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjNotEqualTo(BigDecimal value) {
            addCriterion("zhdbcfhj <>", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjGreaterThan(BigDecimal value) {
            addCriterion("zhdbcfhj >", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zhdbcfhj >=", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjLessThan(BigDecimal value) {
            addCriterion("zhdbcfhj <", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zhdbcfhj <=", value, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjIn(List<BigDecimal> values) {
            addCriterion("zhdbcfhj in", values, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjNotIn(List<BigDecimal> values) {
            addCriterion("zhdbcfhj not in", values, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhdbcfhj between", value1, value2, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZhdbcfhjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhdbcfhj not between", value1, value2, "zhdbcfhj");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrIsNull() {
            addCriterion("zq_dzfzr is null");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrIsNotNull() {
            addCriterion("zq_dzfzr is not null");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrEqualTo(String value) {
            addCriterion("zq_dzfzr =", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrNotEqualTo(String value) {
            addCriterion("zq_dzfzr <>", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrGreaterThan(String value) {
            addCriterion("zq_dzfzr >", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrGreaterThanOrEqualTo(String value) {
            addCriterion("zq_dzfzr >=", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrLessThan(String value) {
            addCriterion("zq_dzfzr <", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrLessThanOrEqualTo(String value) {
            addCriterion("zq_dzfzr <=", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrLike(String value) {
            addCriterion("zq_dzfzr like", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrNotLike(String value) {
            addCriterion("zq_dzfzr not like", value, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrIn(List<String> values) {
            addCriterion("zq_dzfzr in", values, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrNotIn(List<String> values) {
            addCriterion("zq_dzfzr not in", values, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrBetween(String value1, String value2) {
            addCriterion("zq_dzfzr between", value1, value2, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqDzfzrNotBetween(String value1, String value2) {
            addCriterion("zq_dzfzr not between", value1, value2, "zqDzfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrIsNull() {
            addCriterion("zq_xsfzr is null");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrIsNotNull() {
            addCriterion("zq_xsfzr is not null");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrEqualTo(String value) {
            addCriterion("zq_xsfzr =", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrNotEqualTo(String value) {
            addCriterion("zq_xsfzr <>", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrGreaterThan(String value) {
            addCriterion("zq_xsfzr >", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrGreaterThanOrEqualTo(String value) {
            addCriterion("zq_xsfzr >=", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrLessThan(String value) {
            addCriterion("zq_xsfzr <", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrLessThanOrEqualTo(String value) {
            addCriterion("zq_xsfzr <=", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrLike(String value) {
            addCriterion("zq_xsfzr like", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrNotLike(String value) {
            addCriterion("zq_xsfzr not like", value, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrIn(List<String> values) {
            addCriterion("zq_xsfzr in", values, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrNotIn(List<String> values) {
            addCriterion("zq_xsfzr not in", values, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrBetween(String value1, String value2) {
            addCriterion("zq_xsfzr between", value1, value2, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqXsfzrNotBetween(String value1, String value2) {
            addCriterion("zq_xsfzr not between", value1, value2, "zqXsfzr");
            return (Criteria) this;
        }

        public Criteria andZqZhbldIsNull() {
            addCriterion("zq_zhbld is null");
            return (Criteria) this;
        }

        public Criteria andZqZhbldIsNotNull() {
            addCriterion("zq_zhbld is not null");
            return (Criteria) this;
        }

        public Criteria andZqZhbldEqualTo(String value) {
            addCriterion("zq_zhbld =", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldNotEqualTo(String value) {
            addCriterion("zq_zhbld <>", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldGreaterThan(String value) {
            addCriterion("zq_zhbld >", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldGreaterThanOrEqualTo(String value) {
            addCriterion("zq_zhbld >=", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldLessThan(String value) {
            addCriterion("zq_zhbld <", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldLessThanOrEqualTo(String value) {
            addCriterion("zq_zhbld <=", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldLike(String value) {
            addCriterion("zq_zhbld like", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldNotLike(String value) {
            addCriterion("zq_zhbld not like", value, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldIn(List<String> values) {
            addCriterion("zq_zhbld in", values, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldNotIn(List<String> values) {
            addCriterion("zq_zhbld not in", values, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldBetween(String value1, String value2) {
            addCriterion("zq_zhbld between", value1, value2, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqZhbldNotBetween(String value1, String value2) {
            addCriterion("zq_zhbld not between", value1, value2, "zqZhbld");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrIsNull() {
            addCriterion("zq_xmfzr is null");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrIsNotNull() {
            addCriterion("zq_xmfzr is not null");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrEqualTo(String value) {
            addCriterion("zq_xmfzr =", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrNotEqualTo(String value) {
            addCriterion("zq_xmfzr <>", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrGreaterThan(String value) {
            addCriterion("zq_xmfzr >", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrGreaterThanOrEqualTo(String value) {
            addCriterion("zq_xmfzr >=", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrLessThan(String value) {
            addCriterion("zq_xmfzr <", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrLessThanOrEqualTo(String value) {
            addCriterion("zq_xmfzr <=", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrLike(String value) {
            addCriterion("zq_xmfzr like", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrNotLike(String value) {
            addCriterion("zq_xmfzr not like", value, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrIn(List<String> values) {
            addCriterion("zq_xmfzr in", values, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrNotIn(List<String> values) {
            addCriterion("zq_xmfzr not in", values, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrBetween(String value1, String value2) {
            addCriterion("zq_xmfzr between", value1, value2, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andZqXmfzrNotBetween(String value1, String value2) {
            addCriterion("zq_xmfzr not between", value1, value2, "zqXmfzr");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesIsNull() {
            addCriterion("belong_cities is null");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesIsNotNull() {
            addCriterion("belong_cities is not null");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesEqualTo(String value) {
            addCriterion("belong_cities =", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesNotEqualTo(String value) {
            addCriterion("belong_cities <>", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesGreaterThan(String value) {
            addCriterion("belong_cities >", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesGreaterThanOrEqualTo(String value) {
            addCriterion("belong_cities >=", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesLessThan(String value) {
            addCriterion("belong_cities <", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesLessThanOrEqualTo(String value) {
            addCriterion("belong_cities <=", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesLike(String value) {
            addCriterion("belong_cities like", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesNotLike(String value) {
            addCriterion("belong_cities not like", value, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesIn(List<String> values) {
            addCriterion("belong_cities in", values, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesNotIn(List<String> values) {
            addCriterion("belong_cities not in", values, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesBetween(String value1, String value2) {
            addCriterion("belong_cities between", value1, value2, "belongCities");
            return (Criteria) this;
        }

        public Criteria andBelongCitiesNotBetween(String value1, String value2) {
            addCriterion("belong_cities not between", value1, value2, "belongCities");
            return (Criteria) this;
        }

        public Criteria andIssuanceIsNull() {
            addCriterion("issuance is null");
            return (Criteria) this;
        }

        public Criteria andIssuanceIsNotNull() {
            addCriterion("issuance is not null");
            return (Criteria) this;
        }

        public Criteria andIssuanceEqualTo(Integer value) {
            addCriterion("issuance =", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceNotEqualTo(Integer value) {
            addCriterion("issuance <>", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceGreaterThan(Integer value) {
            addCriterion("issuance >", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("issuance >=", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceLessThan(Integer value) {
            addCriterion("issuance <", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceLessThanOrEqualTo(Integer value) {
            addCriterion("issuance <=", value, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceIn(List<Integer> values) {
            addCriterion("issuance in", values, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceNotIn(List<Integer> values) {
            addCriterion("issuance not in", values, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceBetween(Integer value1, Integer value2) {
            addCriterion("issuance between", value1, value2, "issuance");
            return (Criteria) this;
        }

        public Criteria andIssuanceNotBetween(Integer value1, Integer value2) {
            addCriterion("issuance not between", value1, value2, "issuance");
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