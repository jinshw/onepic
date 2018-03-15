package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectInfoExample() {
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

        public Criteria andSupervisionIdIsNull() {
            addCriterion("supervision_id is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdIsNotNull() {
            addCriterion("supervision_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdEqualTo(String value) {
            addCriterion("supervision_id =", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdNotEqualTo(String value) {
            addCriterion("supervision_id <>", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdGreaterThan(String value) {
            addCriterion("supervision_id >", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_id >=", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdLessThan(String value) {
            addCriterion("supervision_id <", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdLessThanOrEqualTo(String value) {
            addCriterion("supervision_id <=", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdLike(String value) {
            addCriterion("supervision_id like", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdNotLike(String value) {
            addCriterion("supervision_id not like", value, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdIn(List<String> values) {
            addCriterion("supervision_id in", values, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdNotIn(List<String> values) {
            addCriterion("supervision_id not in", values, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdBetween(String value1, String value2) {
            addCriterion("supervision_id between", value1, value2, "supervisionId");
            return (Criteria) this;
        }

        public Criteria andSupervisionIdNotBetween(String value1, String value2) {
            addCriterion("supervision_id not between", value1, value2, "supervisionId");
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

        public Criteria andSectShortNameIsNull() {
            addCriterion("sect_short_name is null");
            return (Criteria) this;
        }

        public Criteria andSectShortNameIsNotNull() {
            addCriterion("sect_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andSectShortNameEqualTo(String value) {
            addCriterion("sect_short_name =", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameNotEqualTo(String value) {
            addCriterion("sect_short_name <>", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameGreaterThan(String value) {
            addCriterion("sect_short_name >", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("sect_short_name >=", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameLessThan(String value) {
            addCriterion("sect_short_name <", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameLessThanOrEqualTo(String value) {
            addCriterion("sect_short_name <=", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameLike(String value) {
            addCriterion("sect_short_name like", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameNotLike(String value) {
            addCriterion("sect_short_name not like", value, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameIn(List<String> values) {
            addCriterion("sect_short_name in", values, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameNotIn(List<String> values) {
            addCriterion("sect_short_name not in", values, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameBetween(String value1, String value2) {
            addCriterion("sect_short_name between", value1, value2, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectShortNameNotBetween(String value1, String value2) {
            addCriterion("sect_short_name not between", value1, value2, "sectShortName");
            return (Criteria) this;
        }

        public Criteria andSectNoIsNull() {
            addCriterion("sect_no is null");
            return (Criteria) this;
        }

        public Criteria andSectNoIsNotNull() {
            addCriterion("sect_no is not null");
            return (Criteria) this;
        }

        public Criteria andSectNoEqualTo(String value) {
            addCriterion("sect_no =", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoNotEqualTo(String value) {
            addCriterion("sect_no <>", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoGreaterThan(String value) {
            addCriterion("sect_no >", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoGreaterThanOrEqualTo(String value) {
            addCriterion("sect_no >=", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoLessThan(String value) {
            addCriterion("sect_no <", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoLessThanOrEqualTo(String value) {
            addCriterion("sect_no <=", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoLike(String value) {
            addCriterion("sect_no like", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoNotLike(String value) {
            addCriterion("sect_no not like", value, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoIn(List<String> values) {
            addCriterion("sect_no in", values, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoNotIn(List<String> values) {
            addCriterion("sect_no not in", values, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoBetween(String value1, String value2) {
            addCriterion("sect_no between", value1, value2, "sectNo");
            return (Criteria) this;
        }

        public Criteria andSectNoNotBetween(String value1, String value2) {
            addCriterion("sect_no not between", value1, value2, "sectNo");
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

        public Criteria andSuperDeptNameIsNull() {
            addCriterion("super_dept_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameIsNotNull() {
            addCriterion("super_dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameEqualTo(String value) {
            addCriterion("super_dept_name =", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameNotEqualTo(String value) {
            addCriterion("super_dept_name <>", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameGreaterThan(String value) {
            addCriterion("super_dept_name >", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("super_dept_name >=", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameLessThan(String value) {
            addCriterion("super_dept_name <", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameLessThanOrEqualTo(String value) {
            addCriterion("super_dept_name <=", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameLike(String value) {
            addCriterion("super_dept_name like", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameNotLike(String value) {
            addCriterion("super_dept_name not like", value, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameIn(List<String> values) {
            addCriterion("super_dept_name in", values, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameNotIn(List<String> values) {
            addCriterion("super_dept_name not in", values, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameBetween(String value1, String value2) {
            addCriterion("super_dept_name between", value1, value2, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andSuperDeptNameNotBetween(String value1, String value2) {
            addCriterion("super_dept_name not between", value1, value2, "superDeptName");
            return (Criteria) this;
        }

        public Criteria andCompAddIsNull() {
            addCriterion("comp_add is null");
            return (Criteria) this;
        }

        public Criteria andCompAddIsNotNull() {
            addCriterion("comp_add is not null");
            return (Criteria) this;
        }

        public Criteria andCompAddEqualTo(String value) {
            addCriterion("comp_add =", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddNotEqualTo(String value) {
            addCriterion("comp_add <>", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddGreaterThan(String value) {
            addCriterion("comp_add >", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddGreaterThanOrEqualTo(String value) {
            addCriterion("comp_add >=", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddLessThan(String value) {
            addCriterion("comp_add <", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddLessThanOrEqualTo(String value) {
            addCriterion("comp_add <=", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddLike(String value) {
            addCriterion("comp_add like", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddNotLike(String value) {
            addCriterion("comp_add not like", value, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddIn(List<String> values) {
            addCriterion("comp_add in", values, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddNotIn(List<String> values) {
            addCriterion("comp_add not in", values, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddBetween(String value1, String value2) {
            addCriterion("comp_add between", value1, value2, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompAddNotBetween(String value1, String value2) {
            addCriterion("comp_add not between", value1, value2, "compAdd");
            return (Criteria) this;
        }

        public Criteria andCompTelIsNull() {
            addCriterion("comp_tel is null");
            return (Criteria) this;
        }

        public Criteria andCompTelIsNotNull() {
            addCriterion("comp_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCompTelEqualTo(String value) {
            addCriterion("comp_tel =", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelNotEqualTo(String value) {
            addCriterion("comp_tel <>", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelGreaterThan(String value) {
            addCriterion("comp_tel >", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelGreaterThanOrEqualTo(String value) {
            addCriterion("comp_tel >=", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelLessThan(String value) {
            addCriterion("comp_tel <", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelLessThanOrEqualTo(String value) {
            addCriterion("comp_tel <=", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelLike(String value) {
            addCriterion("comp_tel like", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelNotLike(String value) {
            addCriterion("comp_tel not like", value, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelIn(List<String> values) {
            addCriterion("comp_tel in", values, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelNotIn(List<String> values) {
            addCriterion("comp_tel not in", values, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelBetween(String value1, String value2) {
            addCriterion("comp_tel between", value1, value2, "compTel");
            return (Criteria) this;
        }

        public Criteria andCompTelNotBetween(String value1, String value2) {
            addCriterion("comp_tel not between", value1, value2, "compTel");
            return (Criteria) this;
        }

        public Criteria andSectTypeIsNull() {
            addCriterion("sect_type is null");
            return (Criteria) this;
        }

        public Criteria andSectTypeIsNotNull() {
            addCriterion("sect_type is not null");
            return (Criteria) this;
        }

        public Criteria andSectTypeEqualTo(String value) {
            addCriterion("sect_type =", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeNotEqualTo(String value) {
            addCriterion("sect_type <>", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeGreaterThan(String value) {
            addCriterion("sect_type >", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sect_type >=", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeLessThan(String value) {
            addCriterion("sect_type <", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeLessThanOrEqualTo(String value) {
            addCriterion("sect_type <=", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeLike(String value) {
            addCriterion("sect_type like", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeNotLike(String value) {
            addCriterion("sect_type not like", value, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeIn(List<String> values) {
            addCriterion("sect_type in", values, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeNotIn(List<String> values) {
            addCriterion("sect_type not in", values, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeBetween(String value1, String value2) {
            addCriterion("sect_type between", value1, value2, "sectType");
            return (Criteria) this;
        }

        public Criteria andSectTypeNotBetween(String value1, String value2) {
            addCriterion("sect_type not between", value1, value2, "sectType");
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

        public Criteria andChainLengthIsNull() {
            addCriterion("chain_length is null");
            return (Criteria) this;
        }

        public Criteria andChainLengthIsNotNull() {
            addCriterion("chain_length is not null");
            return (Criteria) this;
        }

        public Criteria andChainLengthEqualTo(BigDecimal value) {
            addCriterion("chain_length =", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthNotEqualTo(BigDecimal value) {
            addCriterion("chain_length <>", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthGreaterThan(BigDecimal value) {
            addCriterion("chain_length >", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("chain_length >=", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthLessThan(BigDecimal value) {
            addCriterion("chain_length <", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("chain_length <=", value, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthIn(List<BigDecimal> values) {
            addCriterion("chain_length in", values, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthNotIn(List<BigDecimal> values) {
            addCriterion("chain_length not in", values, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chain_length between", value1, value2, "chainLength");
            return (Criteria) this;
        }

        public Criteria andChainLengthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chain_length not between", value1, value2, "chainLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthIsNull() {
            addCriterion("sect_length is null");
            return (Criteria) this;
        }

        public Criteria andSectLengthIsNotNull() {
            addCriterion("sect_length is not null");
            return (Criteria) this;
        }

        public Criteria andSectLengthEqualTo(BigDecimal value) {
            addCriterion("sect_length =", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthNotEqualTo(BigDecimal value) {
            addCriterion("sect_length <>", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthGreaterThan(BigDecimal value) {
            addCriterion("sect_length >", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sect_length >=", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthLessThan(BigDecimal value) {
            addCriterion("sect_length <", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sect_length <=", value, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthIn(List<BigDecimal> values) {
            addCriterion("sect_length in", values, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthNotIn(List<BigDecimal> values) {
            addCriterion("sect_length not in", values, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sect_length between", value1, value2, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectLengthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sect_length not between", value1, value2, "sectLength");
            return (Criteria) this;
        }

        public Criteria andSectAddIsNull() {
            addCriterion("sect_add is null");
            return (Criteria) this;
        }

        public Criteria andSectAddIsNotNull() {
            addCriterion("sect_add is not null");
            return (Criteria) this;
        }

        public Criteria andSectAddEqualTo(String value) {
            addCriterion("sect_add =", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddNotEqualTo(String value) {
            addCriterion("sect_add <>", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddGreaterThan(String value) {
            addCriterion("sect_add >", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddGreaterThanOrEqualTo(String value) {
            addCriterion("sect_add >=", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddLessThan(String value) {
            addCriterion("sect_add <", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddLessThanOrEqualTo(String value) {
            addCriterion("sect_add <=", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddLike(String value) {
            addCriterion("sect_add like", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddNotLike(String value) {
            addCriterion("sect_add not like", value, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddIn(List<String> values) {
            addCriterion("sect_add in", values, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddNotIn(List<String> values) {
            addCriterion("sect_add not in", values, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddBetween(String value1, String value2) {
            addCriterion("sect_add between", value1, value2, "sectAdd");
            return (Criteria) this;
        }

        public Criteria andSectAddNotBetween(String value1, String value2) {
            addCriterion("sect_add not between", value1, value2, "sectAdd");
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

        public Criteria andPlanEndDayIsNull() {
            addCriterion("plan_end_day is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayIsNotNull() {
            addCriterion("plan_end_day is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end_day =", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end_day <>", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_end_day >", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end_day >=", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayLessThan(Date value) {
            addCriterionForJDBCDate("plan_end_day <", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end_day <=", value, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayIn(List<Date> values) {
            addCriterionForJDBCDate("plan_end_day in", values, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_end_day not in", values, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_end_day between", value1, value2, "planEndDay");
            return (Criteria) this;
        }

        public Criteria andPlanEndDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_end_day not between", value1, value2, "planEndDay");
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

        public Criteria andLagDayEqualTo(String value) {
            addCriterion("lag_day =", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotEqualTo(String value) {
            addCriterion("lag_day <>", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayGreaterThan(String value) {
            addCriterion("lag_day >", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayGreaterThanOrEqualTo(String value) {
            addCriterion("lag_day >=", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayLessThan(String value) {
            addCriterion("lag_day <", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayLessThanOrEqualTo(String value) {
            addCriterion("lag_day <=", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayLike(String value) {
            addCriterion("lag_day like", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotLike(String value) {
            addCriterion("lag_day not like", value, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayIn(List<String> values) {
            addCriterion("lag_day in", values, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotIn(List<String> values) {
            addCriterion("lag_day not in", values, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayBetween(String value1, String value2) {
            addCriterion("lag_day between", value1, value2, "lagDay");
            return (Criteria) this;
        }

        public Criteria andLagDayNotBetween(String value1, String value2) {
            addCriterion("lag_day not between", value1, value2, "lagDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayIsNull() {
            addCriterion("begin_token_day is null");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayIsNotNull() {
            addCriterion("begin_token_day is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayEqualTo(Date value) {
            addCriterionForJDBCDate("begin_token_day =", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_token_day <>", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_token_day >", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_token_day >=", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayLessThan(Date value) {
            addCriterionForJDBCDate("begin_token_day <", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_token_day <=", value, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayIn(List<Date> values) {
            addCriterionForJDBCDate("begin_token_day in", values, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_token_day not in", values, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_token_day between", value1, value2, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andBeginTokenDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_token_day not between", value1, value2, "beginTokenDay");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleIsNull() {
            addCriterion("superv_people is null");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleIsNotNull() {
            addCriterion("superv_people is not null");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleEqualTo(String value) {
            addCriterion("superv_people =", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleNotEqualTo(String value) {
            addCriterion("superv_people <>", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleGreaterThan(String value) {
            addCriterion("superv_people >", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("superv_people >=", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleLessThan(String value) {
            addCriterion("superv_people <", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleLessThanOrEqualTo(String value) {
            addCriterion("superv_people <=", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleLike(String value) {
            addCriterion("superv_people like", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleNotLike(String value) {
            addCriterion("superv_people not like", value, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleIn(List<String> values) {
            addCriterion("superv_people in", values, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleNotIn(List<String> values) {
            addCriterion("superv_people not in", values, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleBetween(String value1, String value2) {
            addCriterion("superv_people between", value1, value2, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSupervPeopleNotBetween(String value1, String value2) {
            addCriterion("superv_people not between", value1, value2, "supervPeople");
            return (Criteria) this;
        }

        public Criteria andSectLeaderIsNull() {
            addCriterion("sect_leader is null");
            return (Criteria) this;
        }

        public Criteria andSectLeaderIsNotNull() {
            addCriterion("sect_leader is not null");
            return (Criteria) this;
        }

        public Criteria andSectLeaderEqualTo(String value) {
            addCriterion("sect_leader =", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderNotEqualTo(String value) {
            addCriterion("sect_leader <>", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderGreaterThan(String value) {
            addCriterion("sect_leader >", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("sect_leader >=", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderLessThan(String value) {
            addCriterion("sect_leader <", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderLessThanOrEqualTo(String value) {
            addCriterion("sect_leader <=", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderLike(String value) {
            addCriterion("sect_leader like", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderNotLike(String value) {
            addCriterion("sect_leader not like", value, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderIn(List<String> values) {
            addCriterion("sect_leader in", values, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderNotIn(List<String> values) {
            addCriterion("sect_leader not in", values, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderBetween(String value1, String value2) {
            addCriterion("sect_leader between", value1, value2, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderNotBetween(String value1, String value2) {
            addCriterion("sect_leader not between", value1, value2, "sectLeader");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelIsNull() {
            addCriterion("sect_leader_tel is null");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelIsNotNull() {
            addCriterion("sect_leader_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelEqualTo(String value) {
            addCriterion("sect_leader_tel =", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelNotEqualTo(String value) {
            addCriterion("sect_leader_tel <>", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelGreaterThan(String value) {
            addCriterion("sect_leader_tel >", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelGreaterThanOrEqualTo(String value) {
            addCriterion("sect_leader_tel >=", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelLessThan(String value) {
            addCriterion("sect_leader_tel <", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelLessThanOrEqualTo(String value) {
            addCriterion("sect_leader_tel <=", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelLike(String value) {
            addCriterion("sect_leader_tel like", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelNotLike(String value) {
            addCriterion("sect_leader_tel not like", value, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelIn(List<String> values) {
            addCriterion("sect_leader_tel in", values, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelNotIn(List<String> values) {
            addCriterion("sect_leader_tel not in", values, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelBetween(String value1, String value2) {
            addCriterion("sect_leader_tel between", value1, value2, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectLeaderTelNotBetween(String value1, String value2) {
            addCriterion("sect_leader_tel not between", value1, value2, "sectLeaderTel");
            return (Criteria) this;
        }

        public Criteria andSectEngineerIsNull() {
            addCriterion("sect_engineer is null");
            return (Criteria) this;
        }

        public Criteria andSectEngineerIsNotNull() {
            addCriterion("sect_engineer is not null");
            return (Criteria) this;
        }

        public Criteria andSectEngineerEqualTo(String value) {
            addCriterion("sect_engineer =", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerNotEqualTo(String value) {
            addCriterion("sect_engineer <>", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerGreaterThan(String value) {
            addCriterion("sect_engineer >", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerGreaterThanOrEqualTo(String value) {
            addCriterion("sect_engineer >=", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerLessThan(String value) {
            addCriterion("sect_engineer <", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerLessThanOrEqualTo(String value) {
            addCriterion("sect_engineer <=", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerLike(String value) {
            addCriterion("sect_engineer like", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerNotLike(String value) {
            addCriterion("sect_engineer not like", value, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerIn(List<String> values) {
            addCriterion("sect_engineer in", values, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerNotIn(List<String> values) {
            addCriterion("sect_engineer not in", values, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerBetween(String value1, String value2) {
            addCriterion("sect_engineer between", value1, value2, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectEngineerNotBetween(String value1, String value2) {
            addCriterion("sect_engineer not between", value1, value2, "sectEngineer");
            return (Criteria) this;
        }

        public Criteria andSectPactNoIsNull() {
            addCriterion("sect_pact_no is null");
            return (Criteria) this;
        }

        public Criteria andSectPactNoIsNotNull() {
            addCriterion("sect_pact_no is not null");
            return (Criteria) this;
        }

        public Criteria andSectPactNoEqualTo(String value) {
            addCriterion("sect_pact_no =", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoNotEqualTo(String value) {
            addCriterion("sect_pact_no <>", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoGreaterThan(String value) {
            addCriterion("sect_pact_no >", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoGreaterThanOrEqualTo(String value) {
            addCriterion("sect_pact_no >=", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoLessThan(String value) {
            addCriterion("sect_pact_no <", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoLessThanOrEqualTo(String value) {
            addCriterion("sect_pact_no <=", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoLike(String value) {
            addCriterion("sect_pact_no like", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoNotLike(String value) {
            addCriterion("sect_pact_no not like", value, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoIn(List<String> values) {
            addCriterion("sect_pact_no in", values, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoNotIn(List<String> values) {
            addCriterion("sect_pact_no not in", values, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoBetween(String value1, String value2) {
            addCriterion("sect_pact_no between", value1, value2, "sectPactNo");
            return (Criteria) this;
        }

        public Criteria andSectPactNoNotBetween(String value1, String value2) {
            addCriterion("sect_pact_no not between", value1, value2, "sectPactNo");
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

        public Criteria andMoneyValue24EqualTo(Long value) {
            addCriterion("money_value24 =", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotEqualTo(Long value) {
            addCriterion("money_value24 <>", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24GreaterThan(Long value) {
            addCriterion("money_value24 >", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24GreaterThanOrEqualTo(Long value) {
            addCriterion("money_value24 >=", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24LessThan(Long value) {
            addCriterion("money_value24 <", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24LessThanOrEqualTo(Long value) {
            addCriterion("money_value24 <=", value, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24In(List<Long> values) {
            addCriterion("money_value24 in", values, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotIn(List<Long> values) {
            addCriterion("money_value24 not in", values, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24Between(Long value1, Long value2) {
            addCriterion("money_value24 between", value1, value2, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andMoneyValue24NotBetween(Long value1, Long value2) {
            addCriterion("money_value24 not between", value1, value2, "moneyValue24");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAIsNull() {
            addCriterion("sect_property_a is null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAIsNotNull() {
            addCriterion("sect_property_a is not null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAEqualTo(String value) {
            addCriterion("sect_property_a =", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyANotEqualTo(String value) {
            addCriterion("sect_property_a <>", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAGreaterThan(String value) {
            addCriterion("sect_property_a >", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAGreaterThanOrEqualTo(String value) {
            addCriterion("sect_property_a >=", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyALessThan(String value) {
            addCriterion("sect_property_a <", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyALessThanOrEqualTo(String value) {
            addCriterion("sect_property_a <=", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyALike(String value) {
            addCriterion("sect_property_a like", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyANotLike(String value) {
            addCriterion("sect_property_a not like", value, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyAIn(List<String> values) {
            addCriterion("sect_property_a in", values, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyANotIn(List<String> values) {
            addCriterion("sect_property_a not in", values, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyABetween(String value1, String value2) {
            addCriterion("sect_property_a between", value1, value2, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyANotBetween(String value1, String value2) {
            addCriterion("sect_property_a not between", value1, value2, "sectPropertyA");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBIsNull() {
            addCriterion("sect_property_b is null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBIsNotNull() {
            addCriterion("sect_property_b is not null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBEqualTo(String value) {
            addCriterion("sect_property_b =", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBNotEqualTo(String value) {
            addCriterion("sect_property_b <>", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBGreaterThan(String value) {
            addCriterion("sect_property_b >", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBGreaterThanOrEqualTo(String value) {
            addCriterion("sect_property_b >=", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBLessThan(String value) {
            addCriterion("sect_property_b <", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBLessThanOrEqualTo(String value) {
            addCriterion("sect_property_b <=", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBLike(String value) {
            addCriterion("sect_property_b like", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBNotLike(String value) {
            addCriterion("sect_property_b not like", value, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBIn(List<String> values) {
            addCriterion("sect_property_b in", values, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBNotIn(List<String> values) {
            addCriterion("sect_property_b not in", values, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBBetween(String value1, String value2) {
            addCriterion("sect_property_b between", value1, value2, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyBNotBetween(String value1, String value2) {
            addCriterion("sect_property_b not between", value1, value2, "sectPropertyB");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCIsNull() {
            addCriterion("sect_property_c is null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCIsNotNull() {
            addCriterion("sect_property_c is not null");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCEqualTo(String value) {
            addCriterion("sect_property_c =", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCNotEqualTo(String value) {
            addCriterion("sect_property_c <>", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCGreaterThan(String value) {
            addCriterion("sect_property_c >", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCGreaterThanOrEqualTo(String value) {
            addCriterion("sect_property_c >=", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCLessThan(String value) {
            addCriterion("sect_property_c <", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCLessThanOrEqualTo(String value) {
            addCriterion("sect_property_c <=", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCLike(String value) {
            addCriterion("sect_property_c like", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCNotLike(String value) {
            addCriterion("sect_property_c not like", value, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCIn(List<String> values) {
            addCriterion("sect_property_c in", values, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCNotIn(List<String> values) {
            addCriterion("sect_property_c not in", values, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCBetween(String value1, String value2) {
            addCriterion("sect_property_c between", value1, value2, "sectPropertyC");
            return (Criteria) this;
        }

        public Criteria andSectPropertyCNotBetween(String value1, String value2) {
            addCriterion("sect_property_c not between", value1, value2, "sectPropertyC");
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

        public Criteria andCompleteMoneyIsNull() {
            addCriterion("complete_money is null");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyIsNotNull() {
            addCriterion("complete_money is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyEqualTo(String value) {
            addCriterion("complete_money =", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyNotEqualTo(String value) {
            addCriterion("complete_money <>", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyGreaterThan(String value) {
            addCriterion("complete_money >", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("complete_money >=", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyLessThan(String value) {
            addCriterion("complete_money <", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyLessThanOrEqualTo(String value) {
            addCriterion("complete_money <=", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyLike(String value) {
            addCriterion("complete_money like", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyNotLike(String value) {
            addCriterion("complete_money not like", value, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyIn(List<String> values) {
            addCriterion("complete_money in", values, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyNotIn(List<String> values) {
            addCriterion("complete_money not in", values, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyBetween(String value1, String value2) {
            addCriterion("complete_money between", value1, value2, "completeMoney");
            return (Criteria) this;
        }

        public Criteria andCompleteMoneyNotBetween(String value1, String value2) {
            addCriterion("complete_money not between", value1, value2, "completeMoney");
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

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25IsNull() {
            addCriterion("money_value25 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25IsNotNull() {
            addCriterion("money_value25 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25EqualTo(BigDecimal value) {
            addCriterion("money_value25 =", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25NotEqualTo(BigDecimal value) {
            addCriterion("money_value25 <>", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25GreaterThan(BigDecimal value) {
            addCriterion("money_value25 >", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value25 >=", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25LessThan(BigDecimal value) {
            addCriterion("money_value25 <", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value25 <=", value, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25In(List<BigDecimal> values) {
            addCriterion("money_value25 in", values, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25NotIn(List<BigDecimal> values) {
            addCriterion("money_value25 not in", values, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value25 between", value1, value2, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue25NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value25 not between", value1, value2, "moneyValue25");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26IsNull() {
            addCriterion("money_value26 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26IsNotNull() {
            addCriterion("money_value26 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26EqualTo(BigDecimal value) {
            addCriterion("money_value26 =", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26NotEqualTo(BigDecimal value) {
            addCriterion("money_value26 <>", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26GreaterThan(BigDecimal value) {
            addCriterion("money_value26 >", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value26 >=", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26LessThan(BigDecimal value) {
            addCriterion("money_value26 <", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value26 <=", value, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26In(List<BigDecimal> values) {
            addCriterion("money_value26 in", values, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26NotIn(List<BigDecimal> values) {
            addCriterion("money_value26 not in", values, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value26 between", value1, value2, "moneyValue26");
            return (Criteria) this;
        }

        public Criteria andMoneyValue26NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value26 not between", value1, value2, "moneyValue26");
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

        public Criteria andChshyzhryrshIsNull() {
            addCriterion("chshyzhryrsh is null");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshIsNotNull() {
            addCriterion("chshyzhryrsh is not null");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshEqualTo(Integer value) {
            addCriterion("chshyzhryrsh =", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshNotEqualTo(Integer value) {
            addCriterion("chshyzhryrsh <>", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshGreaterThan(Integer value) {
            addCriterion("chshyzhryrsh >", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshGreaterThanOrEqualTo(Integer value) {
            addCriterion("chshyzhryrsh >=", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshLessThan(Integer value) {
            addCriterion("chshyzhryrsh <", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshLessThanOrEqualTo(Integer value) {
            addCriterion("chshyzhryrsh <=", value, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshIn(List<Integer> values) {
            addCriterion("chshyzhryrsh in", values, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshNotIn(List<Integer> values) {
            addCriterion("chshyzhryrsh not in", values, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshBetween(Integer value1, Integer value2) {
            addCriterion("chshyzhryrsh between", value1, value2, "chshyzhryrsh");
            return (Criteria) this;
        }

        public Criteria andChshyzhryrshNotBetween(Integer value1, Integer value2) {
            addCriterion("chshyzhryrsh not between", value1, value2, "chshyzhryrsh");
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

        public Criteria andZygczgjhjIsNull() {
            addCriterion("zygczgjhj is null");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjIsNotNull() {
            addCriterion("zygczgjhj is not null");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjEqualTo(BigDecimal value) {
            addCriterion("zygczgjhj =", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjNotEqualTo(BigDecimal value) {
            addCriterion("zygczgjhj <>", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjGreaterThan(BigDecimal value) {
            addCriterion("zygczgjhj >", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zygczgjhj >=", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjLessThan(BigDecimal value) {
            addCriterion("zygczgjhj <", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zygczgjhj <=", value, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjIn(List<BigDecimal> values) {
            addCriterion("zygczgjhj in", values, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjNotIn(List<BigDecimal> values) {
            addCriterion("zygczgjhj not in", values, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zygczgjhj between", value1, value2, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andZygczgjhjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zygczgjhj not between", value1, value2, "zygczgjhj");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31IsNull() {
            addCriterion("money_value31 is null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31IsNotNull() {
            addCriterion("money_value31 is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31EqualTo(BigDecimal value) {
            addCriterion("money_value31 =", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31NotEqualTo(BigDecimal value) {
            addCriterion("money_value31 <>", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31GreaterThan(BigDecimal value) {
            addCriterion("money_value31 >", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value31 >=", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31LessThan(BigDecimal value) {
            addCriterion("money_value31 <", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31LessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_value31 <=", value, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31In(List<BigDecimal> values) {
            addCriterion("money_value31 in", values, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31NotIn(List<BigDecimal> values) {
            addCriterion("money_value31 not in", values, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value31 between", value1, value2, "moneyValue31");
            return (Criteria) this;
        }

        public Criteria andMoneyValue31NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_value31 not between", value1, value2, "moneyValue31");
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