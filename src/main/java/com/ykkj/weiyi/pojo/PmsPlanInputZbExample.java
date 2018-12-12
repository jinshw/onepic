package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsPlanInputZbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanInputZbExample() {
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

        public Criteria andEntityIdIsNull() {
            addCriterion("entity_id is null");
            return (Criteria) this;
        }

        public Criteria andEntityIdIsNotNull() {
            addCriterion("entity_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntityIdEqualTo(String value) {
            addCriterion("entity_id =", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotEqualTo(String value) {
            addCriterion("entity_id <>", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThan(String value) {
            addCriterion("entity_id >", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThanOrEqualTo(String value) {
            addCriterion("entity_id >=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThan(String value) {
            addCriterion("entity_id <", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThanOrEqualTo(String value) {
            addCriterion("entity_id <=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLike(String value) {
            addCriterion("entity_id like", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotLike(String value) {
            addCriterion("entity_id not like", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdIn(List<String> values) {
            addCriterion("entity_id in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotIn(List<String> values) {
            addCriterion("entity_id not in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdBetween(String value1, String value2) {
            addCriterion("entity_id between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotBetween(String value1, String value2) {
            addCriterion("entity_id not between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNull() {
            addCriterion("entity_type is null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNotNull() {
            addCriterion("entity_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeEqualTo(String value) {
            addCriterion("entity_type =", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotEqualTo(String value) {
            addCriterion("entity_type <>", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThan(String value) {
            addCriterion("entity_type >", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("entity_type >=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThan(String value) {
            addCriterion("entity_type <", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThanOrEqualTo(String value) {
            addCriterion("entity_type <=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLike(String value) {
            addCriterion("entity_type like", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotLike(String value) {
            addCriterion("entity_type not like", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIn(List<String> values) {
            addCriterion("entity_type in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotIn(List<String> values) {
            addCriterion("entity_type not in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeBetween(String value1, String value2) {
            addCriterion("entity_type between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotBetween(String value1, String value2) {
            addCriterion("entity_type not between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Long value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Long value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Long value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Long value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Long value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Long value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Long> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Long> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Long value1, Long value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Long value1, Long value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Long value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Long value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Long value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Long value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Long value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Long value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Long> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Long> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Long value1, Long value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Long value1, Long value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andIsSuanceIsNull() {
            addCriterion("is_suance is null");
            return (Criteria) this;
        }

        public Criteria andIsSuanceIsNotNull() {
            addCriterion("is_suance is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuanceEqualTo(Long value) {
            addCriterion("is_suance =", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceNotEqualTo(Long value) {
            addCriterion("is_suance <>", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceGreaterThan(Long value) {
            addCriterion("is_suance >", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceGreaterThanOrEqualTo(Long value) {
            addCriterion("is_suance >=", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceLessThan(Long value) {
            addCriterion("is_suance <", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceLessThanOrEqualTo(Long value) {
            addCriterion("is_suance <=", value, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceIn(List<Long> values) {
            addCriterion("is_suance in", values, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceNotIn(List<Long> values) {
            addCriterion("is_suance not in", values, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceBetween(Long value1, Long value2) {
            addCriterion("is_suance between", value1, value2, "isSuance");
            return (Criteria) this;
        }

        public Criteria andIsSuanceNotBetween(Long value1, Long value2) {
            addCriterion("is_suance not between", value1, value2, "isSuance");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleIsNull() {
            addCriterion("update_people is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleIsNotNull() {
            addCriterion("update_people is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleEqualTo(String value) {
            addCriterion("update_people =", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleNotEqualTo(String value) {
            addCriterion("update_people <>", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleGreaterThan(String value) {
            addCriterion("update_people >", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("update_people >=", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleLessThan(String value) {
            addCriterion("update_people <", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleLessThanOrEqualTo(String value) {
            addCriterion("update_people <=", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleLike(String value) {
            addCriterion("update_people like", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleNotLike(String value) {
            addCriterion("update_people not like", value, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleIn(List<String> values) {
            addCriterion("update_people in", values, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleNotIn(List<String> values) {
            addCriterion("update_people not in", values, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleBetween(String value1, String value2) {
            addCriterion("update_people between", value1, value2, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdatePeopleNotBetween(String value1, String value2) {
            addCriterion("update_people not between", value1, value2, "updatePeople");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIsNull() {
            addCriterion("update_action is null");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIsNotNull() {
            addCriterion("update_action is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateActionEqualTo(String value) {
            addCriterion("update_action =", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotEqualTo(String value) {
            addCriterion("update_action <>", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionGreaterThan(String value) {
            addCriterion("update_action >", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionGreaterThanOrEqualTo(String value) {
            addCriterion("update_action >=", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLessThan(String value) {
            addCriterion("update_action <", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLessThanOrEqualTo(String value) {
            addCriterion("update_action <=", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLike(String value) {
            addCriterion("update_action like", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotLike(String value) {
            addCriterion("update_action not like", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIn(List<String> values) {
            addCriterion("update_action in", values, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotIn(List<String> values) {
            addCriterion("update_action not in", values, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionBetween(String value1, String value2) {
            addCriterion("update_action between", value1, value2, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotBetween(String value1, String value2) {
            addCriterion("update_action not between", value1, value2, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Long value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Long value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Long value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Long value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Long value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Long> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Long> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Long value1, Long value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Long value1, Long value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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

        public Criteria andPropertyAEqualTo(String value) {
            addCriterion("property_a =", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotEqualTo(String value) {
            addCriterion("property_a <>", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThan(String value) {
            addCriterion("property_a >", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAGreaterThanOrEqualTo(String value) {
            addCriterion("property_a >=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThan(String value) {
            addCriterion("property_a <", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALessThanOrEqualTo(String value) {
            addCriterion("property_a <=", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyALike(String value) {
            addCriterion("property_a like", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotLike(String value) {
            addCriterion("property_a not like", value, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyAIn(List<String> values) {
            addCriterion("property_a in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotIn(List<String> values) {
            addCriterion("property_a not in", values, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyABetween(String value1, String value2) {
            addCriterion("property_a between", value1, value2, "propertyA");
            return (Criteria) this;
        }

        public Criteria andPropertyANotBetween(String value1, String value2) {
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

        public Criteria andRealStartDateIsNull() {
            addCriterion("real_start_date is null");
            return (Criteria) this;
        }

        public Criteria andRealStartDateIsNotNull() {
            addCriterion("real_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andRealStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("real_start_date =", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("real_start_date <>", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("real_start_date >", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("real_start_date >=", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateLessThan(Date value) {
            addCriterionForJDBCDate("real_start_date <", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("real_start_date <=", value, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("real_start_date in", values, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("real_start_date not in", values, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("real_start_date between", value1, value2, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("real_start_date not between", value1, value2, "realStartDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateIsNull() {
            addCriterion("real_end_date is null");
            return (Criteria) this;
        }

        public Criteria andRealEndDateIsNotNull() {
            addCriterion("real_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andRealEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("real_end_date =", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("real_end_date <>", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("real_end_date >", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("real_end_date >=", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateLessThan(Date value) {
            addCriterionForJDBCDate("real_end_date <", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("real_end_date <=", value, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("real_end_date in", values, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("real_end_date not in", values, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("real_end_date between", value1, value2, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andRealEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("real_end_date not between", value1, value2, "realEndDate");
            return (Criteria) this;
        }

        public Criteria andIsSuenoIsNull() {
            addCriterion("is_sueno is null");
            return (Criteria) this;
        }

        public Criteria andIsSuenoIsNotNull() {
            addCriterion("is_sueno is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuenoEqualTo(Long value) {
            addCriterion("is_sueno =", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoNotEqualTo(Long value) {
            addCriterion("is_sueno <>", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoGreaterThan(Long value) {
            addCriterion("is_sueno >", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoGreaterThanOrEqualTo(Long value) {
            addCriterion("is_sueno >=", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoLessThan(Long value) {
            addCriterion("is_sueno <", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoLessThanOrEqualTo(Long value) {
            addCriterion("is_sueno <=", value, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoIn(List<Long> values) {
            addCriterion("is_sueno in", values, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoNotIn(List<Long> values) {
            addCriterion("is_sueno not in", values, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoBetween(Long value1, Long value2) {
            addCriterion("is_sueno between", value1, value2, "isSueno");
            return (Criteria) this;
        }

        public Criteria andIsSuenoNotBetween(Long value1, Long value2) {
            addCriterion("is_sueno not between", value1, value2, "isSueno");
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

        public Criteria andSubmitManIsNull() {
            addCriterion("submit_man is null");
            return (Criteria) this;
        }

        public Criteria andSubmitManIsNotNull() {
            addCriterion("submit_man is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitManEqualTo(String value) {
            addCriterion("submit_man =", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManNotEqualTo(String value) {
            addCriterion("submit_man <>", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManGreaterThan(String value) {
            addCriterion("submit_man >", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManGreaterThanOrEqualTo(String value) {
            addCriterion("submit_man >=", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManLessThan(String value) {
            addCriterion("submit_man <", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManLessThanOrEqualTo(String value) {
            addCriterion("submit_man <=", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManLike(String value) {
            addCriterion("submit_man like", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManNotLike(String value) {
            addCriterion("submit_man not like", value, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManIn(List<String> values) {
            addCriterion("submit_man in", values, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManNotIn(List<String> values) {
            addCriterion("submit_man not in", values, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManBetween(String value1, String value2) {
            addCriterion("submit_man between", value1, value2, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitManNotBetween(String value1, String value2) {
            addCriterion("submit_man not between", value1, value2, "submitMan");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterionForJDBCDate("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterionForJDBCDate("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterionForJDBCDate("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("submit_time not between", value1, value2, "submitTime");
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