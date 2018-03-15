package com.ykkj.weiyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PmsQingdanJiliangExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsQingdanJiliangExample() {
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

        public Criteria andQihIsNull() {
            addCriterion("qih is null");
            return (Criteria) this;
        }

        public Criteria andQihIsNotNull() {
            addCriterion("qih is not null");
            return (Criteria) this;
        }

        public Criteria andQihEqualTo(String value) {
            addCriterion("qih =", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihNotEqualTo(String value) {
            addCriterion("qih <>", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihGreaterThan(String value) {
            addCriterion("qih >", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihGreaterThanOrEqualTo(String value) {
            addCriterion("qih >=", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihLessThan(String value) {
            addCriterion("qih <", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihLessThanOrEqualTo(String value) {
            addCriterion("qih <=", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihLike(String value) {
            addCriterion("qih like", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihNotLike(String value) {
            addCriterion("qih not like", value, "qih");
            return (Criteria) this;
        }

        public Criteria andQihIn(List<String> values) {
            addCriterion("qih in", values, "qih");
            return (Criteria) this;
        }

        public Criteria andQihNotIn(List<String> values) {
            addCriterion("qih not in", values, "qih");
            return (Criteria) this;
        }

        public Criteria andQihBetween(String value1, String value2) {
            addCriterion("qih between", value1, value2, "qih");
            return (Criteria) this;
        }

        public Criteria andQihNotBetween(String value1, String value2) {
            addCriterion("qih not between", value1, value2, "qih");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(String value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(String value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(String value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(String value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(String value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLike(String value) {
            addCriterion("p_id like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotLike(String value) {
            addCriterion("p_id not like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<String> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<String> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(String value1, String value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(String value1, String value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdIsNull() {
            addCriterion("wbs_listing_id is null");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdIsNotNull() {
            addCriterion("wbs_listing_id is not null");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdEqualTo(String value) {
            addCriterion("wbs_listing_id =", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdNotEqualTo(String value) {
            addCriterion("wbs_listing_id <>", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdGreaterThan(String value) {
            addCriterion("wbs_listing_id >", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_listing_id >=", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdLessThan(String value) {
            addCriterion("wbs_listing_id <", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdLessThanOrEqualTo(String value) {
            addCriterion("wbs_listing_id <=", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdLike(String value) {
            addCriterion("wbs_listing_id like", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdNotLike(String value) {
            addCriterion("wbs_listing_id not like", value, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdIn(List<String> values) {
            addCriterion("wbs_listing_id in", values, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdNotIn(List<String> values) {
            addCriterion("wbs_listing_id not in", values, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdBetween(String value1, String value2) {
            addCriterion("wbs_listing_id between", value1, value2, "wbsListingId");
            return (Criteria) this;
        }

        public Criteria andWbsListingIdNotBetween(String value1, String value2) {
            addCriterion("wbs_listing_id not between", value1, value2, "wbsListingId");
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

        public Criteria andSectIsbnIsNull() {
            addCriterion("sect_isbn is null");
            return (Criteria) this;
        }

        public Criteria andSectIsbnIsNotNull() {
            addCriterion("sect_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andSectIsbnEqualTo(String value) {
            addCriterion("sect_isbn =", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnNotEqualTo(String value) {
            addCriterion("sect_isbn <>", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnGreaterThan(String value) {
            addCriterion("sect_isbn >", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("sect_isbn >=", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnLessThan(String value) {
            addCriterion("sect_isbn <", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnLessThanOrEqualTo(String value) {
            addCriterion("sect_isbn <=", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnLike(String value) {
            addCriterion("sect_isbn like", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnNotLike(String value) {
            addCriterion("sect_isbn not like", value, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnIn(List<String> values) {
            addCriterion("sect_isbn in", values, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnNotIn(List<String> values) {
            addCriterion("sect_isbn not in", values, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnBetween(String value1, String value2) {
            addCriterion("sect_isbn between", value1, value2, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andSectIsbnNotBetween(String value1, String value2) {
            addCriterion("sect_isbn not between", value1, value2, "sectIsbn");
            return (Criteria) this;
        }

        public Criteria andFbfxIsNull() {
            addCriterion("fbfx is null");
            return (Criteria) this;
        }

        public Criteria andFbfxIsNotNull() {
            addCriterion("fbfx is not null");
            return (Criteria) this;
        }

        public Criteria andFbfxEqualTo(String value) {
            addCriterion("fbfx =", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxNotEqualTo(String value) {
            addCriterion("fbfx <>", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxGreaterThan(String value) {
            addCriterion("fbfx >", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxGreaterThanOrEqualTo(String value) {
            addCriterion("fbfx >=", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxLessThan(String value) {
            addCriterion("fbfx <", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxLessThanOrEqualTo(String value) {
            addCriterion("fbfx <=", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxLike(String value) {
            addCriterion("fbfx like", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxNotLike(String value) {
            addCriterion("fbfx not like", value, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxIn(List<String> values) {
            addCriterion("fbfx in", values, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxNotIn(List<String> values) {
            addCriterion("fbfx not in", values, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxBetween(String value1, String value2) {
            addCriterion("fbfx between", value1, value2, "fbfx");
            return (Criteria) this;
        }

        public Criteria andFbfxNotBetween(String value1, String value2) {
            addCriterion("fbfx not between", value1, value2, "fbfx");
            return (Criteria) this;
        }

        public Criteria andQdbhIsNull() {
            addCriterion("qdbh is null");
            return (Criteria) this;
        }

        public Criteria andQdbhIsNotNull() {
            addCriterion("qdbh is not null");
            return (Criteria) this;
        }

        public Criteria andQdbhEqualTo(String value) {
            addCriterion("qdbh =", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhNotEqualTo(String value) {
            addCriterion("qdbh <>", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhGreaterThan(String value) {
            addCriterion("qdbh >", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhGreaterThanOrEqualTo(String value) {
            addCriterion("qdbh >=", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhLessThan(String value) {
            addCriterion("qdbh <", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhLessThanOrEqualTo(String value) {
            addCriterion("qdbh <=", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhLike(String value) {
            addCriterion("qdbh like", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhNotLike(String value) {
            addCriterion("qdbh not like", value, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhIn(List<String> values) {
            addCriterion("qdbh in", values, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhNotIn(List<String> values) {
            addCriterion("qdbh not in", values, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhBetween(String value1, String value2) {
            addCriterion("qdbh between", value1, value2, "qdbh");
            return (Criteria) this;
        }

        public Criteria andQdbhNotBetween(String value1, String value2) {
            addCriterion("qdbh not between", value1, value2, "qdbh");
            return (Criteria) this;
        }

        public Criteria andListingNoIsNull() {
            addCriterion("listing_no is null");
            return (Criteria) this;
        }

        public Criteria andListingNoIsNotNull() {
            addCriterion("listing_no is not null");
            return (Criteria) this;
        }

        public Criteria andListingNoEqualTo(String value) {
            addCriterion("listing_no =", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotEqualTo(String value) {
            addCriterion("listing_no <>", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoGreaterThan(String value) {
            addCriterion("listing_no >", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoGreaterThanOrEqualTo(String value) {
            addCriterion("listing_no >=", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLessThan(String value) {
            addCriterion("listing_no <", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLessThanOrEqualTo(String value) {
            addCriterion("listing_no <=", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoLike(String value) {
            addCriterion("listing_no like", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotLike(String value) {
            addCriterion("listing_no not like", value, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoIn(List<String> values) {
            addCriterion("listing_no in", values, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotIn(List<String> values) {
            addCriterion("listing_no not in", values, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoBetween(String value1, String value2) {
            addCriterion("listing_no between", value1, value2, "listingNo");
            return (Criteria) this;
        }

        public Criteria andListingNoNotBetween(String value1, String value2) {
            addCriterion("listing_no not between", value1, value2, "listingNo");
            return (Criteria) this;
        }

        public Criteria andQdmcIsNull() {
            addCriterion("qdmc is null");
            return (Criteria) this;
        }

        public Criteria andQdmcIsNotNull() {
            addCriterion("qdmc is not null");
            return (Criteria) this;
        }

        public Criteria andQdmcEqualTo(String value) {
            addCriterion("qdmc =", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcNotEqualTo(String value) {
            addCriterion("qdmc <>", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcGreaterThan(String value) {
            addCriterion("qdmc >", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcGreaterThanOrEqualTo(String value) {
            addCriterion("qdmc >=", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcLessThan(String value) {
            addCriterion("qdmc <", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcLessThanOrEqualTo(String value) {
            addCriterion("qdmc <=", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcLike(String value) {
            addCriterion("qdmc like", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcNotLike(String value) {
            addCriterion("qdmc not like", value, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcIn(List<String> values) {
            addCriterion("qdmc in", values, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcNotIn(List<String> values) {
            addCriterion("qdmc not in", values, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcBetween(String value1, String value2) {
            addCriterion("qdmc between", value1, value2, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQdmcNotBetween(String value1, String value2) {
            addCriterion("qdmc not between", value1, value2, "qdmc");
            return (Criteria) this;
        }

        public Criteria andQddwIsNull() {
            addCriterion("qddw is null");
            return (Criteria) this;
        }

        public Criteria andQddwIsNotNull() {
            addCriterion("qddw is not null");
            return (Criteria) this;
        }

        public Criteria andQddwEqualTo(String value) {
            addCriterion("qddw =", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwNotEqualTo(String value) {
            addCriterion("qddw <>", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwGreaterThan(String value) {
            addCriterion("qddw >", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwGreaterThanOrEqualTo(String value) {
            addCriterion("qddw >=", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwLessThan(String value) {
            addCriterion("qddw <", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwLessThanOrEqualTo(String value) {
            addCriterion("qddw <=", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwLike(String value) {
            addCriterion("qddw like", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwNotLike(String value) {
            addCriterion("qddw not like", value, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwIn(List<String> values) {
            addCriterion("qddw in", values, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwNotIn(List<String> values) {
            addCriterion("qddw not in", values, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwBetween(String value1, String value2) {
            addCriterion("qddw between", value1, value2, "qddw");
            return (Criteria) this;
        }

        public Criteria andQddwNotBetween(String value1, String value2) {
            addCriterion("qddw not between", value1, value2, "qddw");
            return (Criteria) this;
        }

        public Criteria andHtdjIsNull() {
            addCriterion("htdj is null");
            return (Criteria) this;
        }

        public Criteria andHtdjIsNotNull() {
            addCriterion("htdj is not null");
            return (Criteria) this;
        }

        public Criteria andHtdjEqualTo(BigDecimal value) {
            addCriterion("htdj =", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjNotEqualTo(BigDecimal value) {
            addCriterion("htdj <>", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjGreaterThan(BigDecimal value) {
            addCriterion("htdj >", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("htdj >=", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjLessThan(BigDecimal value) {
            addCriterion("htdj <", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("htdj <=", value, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjIn(List<BigDecimal> values) {
            addCriterion("htdj in", values, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjNotIn(List<BigDecimal> values) {
            addCriterion("htdj not in", values, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htdj between", value1, value2, "htdj");
            return (Criteria) this;
        }

        public Criteria andHtdjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htdj not between", value1, value2, "htdj");
            return (Criteria) this;
        }

        public Criteria andListingVersionIsNull() {
            addCriterion("listing_version is null");
            return (Criteria) this;
        }

        public Criteria andListingVersionIsNotNull() {
            addCriterion("listing_version is not null");
            return (Criteria) this;
        }

        public Criteria andListingVersionEqualTo(Long value) {
            addCriterion("listing_version =", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionNotEqualTo(Long value) {
            addCriterion("listing_version <>", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionGreaterThan(Long value) {
            addCriterion("listing_version >", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("listing_version >=", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionLessThan(Long value) {
            addCriterion("listing_version <", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionLessThanOrEqualTo(Long value) {
            addCriterion("listing_version <=", value, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionIn(List<Long> values) {
            addCriterion("listing_version in", values, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionNotIn(List<Long> values) {
            addCriterion("listing_version not in", values, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionBetween(Long value1, Long value2) {
            addCriterion("listing_version between", value1, value2, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andListingVersionNotBetween(Long value1, Long value2) {
            addCriterion("listing_version not between", value1, value2, "listingVersion");
            return (Criteria) this;
        }

        public Criteria andHtslIsNull() {
            addCriterion("htsl is null");
            return (Criteria) this;
        }

        public Criteria andHtslIsNotNull() {
            addCriterion("htsl is not null");
            return (Criteria) this;
        }

        public Criteria andHtslEqualTo(BigDecimal value) {
            addCriterion("htsl =", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslNotEqualTo(BigDecimal value) {
            addCriterion("htsl <>", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslGreaterThan(BigDecimal value) {
            addCriterion("htsl >", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl >=", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslLessThan(BigDecimal value) {
            addCriterion("htsl <", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("htsl <=", value, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslIn(List<BigDecimal> values) {
            addCriterion("htsl in", values, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslNotIn(List<BigDecimal> values) {
            addCriterion("htsl not in", values, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl between", value1, value2, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htsl not between", value1, value2, "htsl");
            return (Criteria) this;
        }

        public Criteria andHtjeIsNull() {
            addCriterion("htje is null");
            return (Criteria) this;
        }

        public Criteria andHtjeIsNotNull() {
            addCriterion("htje is not null");
            return (Criteria) this;
        }

        public Criteria andHtjeEqualTo(BigDecimal value) {
            addCriterion("htje =", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeNotEqualTo(BigDecimal value) {
            addCriterion("htje <>", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeGreaterThan(BigDecimal value) {
            addCriterion("htje >", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("htje >=", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeLessThan(BigDecimal value) {
            addCriterion("htje <", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("htje <=", value, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeIn(List<BigDecimal> values) {
            addCriterion("htje in", values, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeNotIn(List<BigDecimal> values) {
            addCriterion("htje not in", values, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htje between", value1, value2, "htje");
            return (Criteria) this;
        }

        public Criteria andHtjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("htje not between", value1, value2, "htje");
            return (Criteria) this;
        }

        public Criteria andWbsBhIsNull() {
            addCriterion("wbs_bh is null");
            return (Criteria) this;
        }

        public Criteria andWbsBhIsNotNull() {
            addCriterion("wbs_bh is not null");
            return (Criteria) this;
        }

        public Criteria andWbsBhEqualTo(String value) {
            addCriterion("wbs_bh =", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhNotEqualTo(String value) {
            addCriterion("wbs_bh <>", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhGreaterThan(String value) {
            addCriterion("wbs_bh >", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_bh >=", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhLessThan(String value) {
            addCriterion("wbs_bh <", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhLessThanOrEqualTo(String value) {
            addCriterion("wbs_bh <=", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhLike(String value) {
            addCriterion("wbs_bh like", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhNotLike(String value) {
            addCriterion("wbs_bh not like", value, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhIn(List<String> values) {
            addCriterion("wbs_bh in", values, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhNotIn(List<String> values) {
            addCriterion("wbs_bh not in", values, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhBetween(String value1, String value2) {
            addCriterion("wbs_bh between", value1, value2, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBhNotBetween(String value1, String value2) {
            addCriterion("wbs_bh not between", value1, value2, "wbsBh");
            return (Criteria) this;
        }

        public Criteria andWbsBaneIsNull() {
            addCriterion("wbs_bane is null");
            return (Criteria) this;
        }

        public Criteria andWbsBaneIsNotNull() {
            addCriterion("wbs_bane is not null");
            return (Criteria) this;
        }

        public Criteria andWbsBaneEqualTo(String value) {
            addCriterion("wbs_bane =", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneNotEqualTo(String value) {
            addCriterion("wbs_bane <>", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneGreaterThan(String value) {
            addCriterion("wbs_bane >", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_bane >=", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneLessThan(String value) {
            addCriterion("wbs_bane <", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneLessThanOrEqualTo(String value) {
            addCriterion("wbs_bane <=", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneLike(String value) {
            addCriterion("wbs_bane like", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneNotLike(String value) {
            addCriterion("wbs_bane not like", value, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneIn(List<String> values) {
            addCriterion("wbs_bane in", values, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneNotIn(List<String> values) {
            addCriterion("wbs_bane not in", values, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneBetween(String value1, String value2) {
            addCriterion("wbs_bane between", value1, value2, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andWbsBaneNotBetween(String value1, String value2) {
            addCriterion("wbs_bane not between", value1, value2, "wbsBane");
            return (Criteria) this;
        }

        public Criteria andJllxIsNull() {
            addCriterion("jllx is null");
            return (Criteria) this;
        }

        public Criteria andJllxIsNotNull() {
            addCriterion("jllx is not null");
            return (Criteria) this;
        }

        public Criteria andJllxEqualTo(Long value) {
            addCriterion("jllx =", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxNotEqualTo(Long value) {
            addCriterion("jllx <>", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxGreaterThan(Long value) {
            addCriterion("jllx >", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxGreaterThanOrEqualTo(Long value) {
            addCriterion("jllx >=", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxLessThan(Long value) {
            addCriterion("jllx <", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxLessThanOrEqualTo(Long value) {
            addCriterion("jllx <=", value, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxIn(List<Long> values) {
            addCriterion("jllx in", values, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxNotIn(List<Long> values) {
            addCriterion("jllx not in", values, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxBetween(Long value1, Long value2) {
            addCriterion("jllx between", value1, value2, "jllx");
            return (Criteria) this;
        }

        public Criteria andJllxNotBetween(Long value1, Long value2) {
            addCriterion("jllx not between", value1, value2, "jllx");
            return (Criteria) this;
        }

        public Criteria andBgpzwhIsNull() {
            addCriterion("bgpzwh is null");
            return (Criteria) this;
        }

        public Criteria andBgpzwhIsNotNull() {
            addCriterion("bgpzwh is not null");
            return (Criteria) this;
        }

        public Criteria andBgpzwhEqualTo(String value) {
            addCriterion("bgpzwh =", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhNotEqualTo(String value) {
            addCriterion("bgpzwh <>", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhGreaterThan(String value) {
            addCriterion("bgpzwh >", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhGreaterThanOrEqualTo(String value) {
            addCriterion("bgpzwh >=", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhLessThan(String value) {
            addCriterion("bgpzwh <", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhLessThanOrEqualTo(String value) {
            addCriterion("bgpzwh <=", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhLike(String value) {
            addCriterion("bgpzwh like", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhNotLike(String value) {
            addCriterion("bgpzwh not like", value, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhIn(List<String> values) {
            addCriterion("bgpzwh in", values, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhNotIn(List<String> values) {
            addCriterion("bgpzwh not in", values, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhBetween(String value1, String value2) {
            addCriterion("bgpzwh between", value1, value2, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andBgpzwhNotBetween(String value1, String value2) {
            addCriterion("bgpzwh not between", value1, value2, "bgpzwh");
            return (Criteria) this;
        }

        public Criteria andJlslIsNull() {
            addCriterion("jlsl is null");
            return (Criteria) this;
        }

        public Criteria andJlslIsNotNull() {
            addCriterion("jlsl is not null");
            return (Criteria) this;
        }

        public Criteria andJlslEqualTo(BigDecimal value) {
            addCriterion("jlsl =", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslNotEqualTo(BigDecimal value) {
            addCriterion("jlsl <>", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslGreaterThan(BigDecimal value) {
            addCriterion("jlsl >", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jlsl >=", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslLessThan(BigDecimal value) {
            addCriterion("jlsl <", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jlsl <=", value, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslIn(List<BigDecimal> values) {
            addCriterion("jlsl in", values, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslNotIn(List<BigDecimal> values) {
            addCriterion("jlsl not in", values, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlsl between", value1, value2, "jlsl");
            return (Criteria) this;
        }

        public Criteria andJlslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlsl not between", value1, value2, "jlsl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlIsNull() {
            addCriterion("qzbgjl is null");
            return (Criteria) this;
        }

        public Criteria andQzbgjlIsNotNull() {
            addCriterion("qzbgjl is not null");
            return (Criteria) this;
        }

        public Criteria andQzbgjlEqualTo(BigDecimal value) {
            addCriterion("qzbgjl =", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlNotEqualTo(BigDecimal value) {
            addCriterion("qzbgjl <>", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlGreaterThan(BigDecimal value) {
            addCriterion("qzbgjl >", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qzbgjl >=", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlLessThan(BigDecimal value) {
            addCriterion("qzbgjl <", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qzbgjl <=", value, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlIn(List<BigDecimal> values) {
            addCriterion("qzbgjl in", values, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlNotIn(List<BigDecimal> values) {
            addCriterion("qzbgjl not in", values, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qzbgjl between", value1, value2, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andQzbgjlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qzbgjl not between", value1, value2, "qzbgjl");
            return (Criteria) this;
        }

        public Criteria andJljeIsNull() {
            addCriterion("jlje is null");
            return (Criteria) this;
        }

        public Criteria andJljeIsNotNull() {
            addCriterion("jlje is not null");
            return (Criteria) this;
        }

        public Criteria andJljeEqualTo(BigDecimal value) {
            addCriterion("jlje =", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotEqualTo(BigDecimal value) {
            addCriterion("jlje <>", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeGreaterThan(BigDecimal value) {
            addCriterion("jlje >", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jlje >=", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeLessThan(BigDecimal value) {
            addCriterion("jlje <", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jlje <=", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeIn(List<BigDecimal> values) {
            addCriterion("jlje in", values, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotIn(List<BigDecimal> values) {
            addCriterion("jlje not in", values, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlje between", value1, value2, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlje not between", value1, value2, "jlje");
            return (Criteria) this;
        }

        public Criteria andQzzhIsNull() {
            addCriterion("qzzh is null");
            return (Criteria) this;
        }

        public Criteria andQzzhIsNotNull() {
            addCriterion("qzzh is not null");
            return (Criteria) this;
        }

        public Criteria andQzzhEqualTo(String value) {
            addCriterion("qzzh =", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhNotEqualTo(String value) {
            addCriterion("qzzh <>", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhGreaterThan(String value) {
            addCriterion("qzzh >", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhGreaterThanOrEqualTo(String value) {
            addCriterion("qzzh >=", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhLessThan(String value) {
            addCriterion("qzzh <", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhLessThanOrEqualTo(String value) {
            addCriterion("qzzh <=", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhLike(String value) {
            addCriterion("qzzh like", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhNotLike(String value) {
            addCriterion("qzzh not like", value, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhIn(List<String> values) {
            addCriterion("qzzh in", values, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhNotIn(List<String> values) {
            addCriterion("qzzh not in", values, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhBetween(String value1, String value2) {
            addCriterion("qzzh between", value1, value2, "qzzh");
            return (Criteria) this;
        }

        public Criteria andQzzhNotBetween(String value1, String value2) {
            addCriterion("qzzh not between", value1, value2, "qzzh");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andThIsNull() {
            addCriterion("th is null");
            return (Criteria) this;
        }

        public Criteria andThIsNotNull() {
            addCriterion("th is not null");
            return (Criteria) this;
        }

        public Criteria andThEqualTo(String value) {
            addCriterion("th =", value, "th");
            return (Criteria) this;
        }

        public Criteria andThNotEqualTo(String value) {
            addCriterion("th <>", value, "th");
            return (Criteria) this;
        }

        public Criteria andThGreaterThan(String value) {
            addCriterion("th >", value, "th");
            return (Criteria) this;
        }

        public Criteria andThGreaterThanOrEqualTo(String value) {
            addCriterion("th >=", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLessThan(String value) {
            addCriterion("th <", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLessThanOrEqualTo(String value) {
            addCriterion("th <=", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLike(String value) {
            addCriterion("th like", value, "th");
            return (Criteria) this;
        }

        public Criteria andThNotLike(String value) {
            addCriterion("th not like", value, "th");
            return (Criteria) this;
        }

        public Criteria andThIn(List<String> values) {
            addCriterion("th in", values, "th");
            return (Criteria) this;
        }

        public Criteria andThNotIn(List<String> values) {
            addCriterion("th not in", values, "th");
            return (Criteria) this;
        }

        public Criteria andThBetween(String value1, String value2) {
            addCriterion("th between", value1, value2, "th");
            return (Criteria) this;
        }

        public Criteria andThNotBetween(String value1, String value2) {
            addCriterion("th not between", value1, value2, "th");
            return (Criteria) this;
        }

        public Criteria andCtwzIsNull() {
            addCriterion("ctwz is null");
            return (Criteria) this;
        }

        public Criteria andCtwzIsNotNull() {
            addCriterion("ctwz is not null");
            return (Criteria) this;
        }

        public Criteria andCtwzEqualTo(String value) {
            addCriterion("ctwz =", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzNotEqualTo(String value) {
            addCriterion("ctwz <>", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzGreaterThan(String value) {
            addCriterion("ctwz >", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzGreaterThanOrEqualTo(String value) {
            addCriterion("ctwz >=", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzLessThan(String value) {
            addCriterion("ctwz <", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzLessThanOrEqualTo(String value) {
            addCriterion("ctwz <=", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzLike(String value) {
            addCriterion("ctwz like", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzNotLike(String value) {
            addCriterion("ctwz not like", value, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzIn(List<String> values) {
            addCriterion("ctwz in", values, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzNotIn(List<String> values) {
            addCriterion("ctwz not in", values, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzBetween(String value1, String value2) {
            addCriterion("ctwz between", value1, value2, "ctwz");
            return (Criteria) this;
        }

        public Criteria andCtwzNotBetween(String value1, String value2) {
            addCriterion("ctwz not between", value1, value2, "ctwz");
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

        public Criteria andJldbhSIsNull() {
            addCriterion("jldbh_s is null");
            return (Criteria) this;
        }

        public Criteria andJldbhSIsNotNull() {
            addCriterion("jldbh_s is not null");
            return (Criteria) this;
        }

        public Criteria andJldbhSEqualTo(String value) {
            addCriterion("jldbh_s =", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSNotEqualTo(String value) {
            addCriterion("jldbh_s <>", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSGreaterThan(String value) {
            addCriterion("jldbh_s >", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSGreaterThanOrEqualTo(String value) {
            addCriterion("jldbh_s >=", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSLessThan(String value) {
            addCriterion("jldbh_s <", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSLessThanOrEqualTo(String value) {
            addCriterion("jldbh_s <=", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSLike(String value) {
            addCriterion("jldbh_s like", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSNotLike(String value) {
            addCriterion("jldbh_s not like", value, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSIn(List<String> values) {
            addCriterion("jldbh_s in", values, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSNotIn(List<String> values) {
            addCriterion("jldbh_s not in", values, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSBetween(String value1, String value2) {
            addCriterion("jldbh_s between", value1, value2, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhSNotBetween(String value1, String value2) {
            addCriterion("jldbh_s not between", value1, value2, "jldbhS");
            return (Criteria) this;
        }

        public Criteria andJldbhIsNull() {
            addCriterion("jldbh is null");
            return (Criteria) this;
        }

        public Criteria andJldbhIsNotNull() {
            addCriterion("jldbh is not null");
            return (Criteria) this;
        }

        public Criteria andJldbhEqualTo(Long value) {
            addCriterion("jldbh =", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhNotEqualTo(Long value) {
            addCriterion("jldbh <>", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhGreaterThan(Long value) {
            addCriterion("jldbh >", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhGreaterThanOrEqualTo(Long value) {
            addCriterion("jldbh >=", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhLessThan(Long value) {
            addCriterion("jldbh <", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhLessThanOrEqualTo(Long value) {
            addCriterion("jldbh <=", value, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhIn(List<Long> values) {
            addCriterion("jldbh in", values, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhNotIn(List<Long> values) {
            addCriterion("jldbh not in", values, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhBetween(Long value1, Long value2) {
            addCriterion("jldbh between", value1, value2, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJldbhNotBetween(Long value1, Long value2) {
            addCriterion("jldbh not between", value1, value2, "jldbh");
            return (Criteria) this;
        }

        public Criteria andJgzhIsNull() {
            addCriterion("jgzh is null");
            return (Criteria) this;
        }

        public Criteria andJgzhIsNotNull() {
            addCriterion("jgzh is not null");
            return (Criteria) this;
        }

        public Criteria andJgzhEqualTo(String value) {
            addCriterion("jgzh =", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhNotEqualTo(String value) {
            addCriterion("jgzh <>", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhGreaterThan(String value) {
            addCriterion("jgzh >", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhGreaterThanOrEqualTo(String value) {
            addCriterion("jgzh >=", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhLessThan(String value) {
            addCriterion("jgzh <", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhLessThanOrEqualTo(String value) {
            addCriterion("jgzh <=", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhLike(String value) {
            addCriterion("jgzh like", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhNotLike(String value) {
            addCriterion("jgzh not like", value, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhIn(List<String> values) {
            addCriterion("jgzh in", values, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhNotIn(List<String> values) {
            addCriterion("jgzh not in", values, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhBetween(String value1, String value2) {
            addCriterion("jgzh between", value1, value2, "jgzh");
            return (Criteria) this;
        }

        public Criteria andJgzhNotBetween(String value1, String value2) {
            addCriterion("jgzh not between", value1, value2, "jgzh");
            return (Criteria) this;
        }

        public Criteria andZjdbhIsNull() {
            addCriterion("zjdbh is null");
            return (Criteria) this;
        }

        public Criteria andZjdbhIsNotNull() {
            addCriterion("zjdbh is not null");
            return (Criteria) this;
        }

        public Criteria andZjdbhEqualTo(String value) {
            addCriterion("zjdbh =", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhNotEqualTo(String value) {
            addCriterion("zjdbh <>", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhGreaterThan(String value) {
            addCriterion("zjdbh >", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhGreaterThanOrEqualTo(String value) {
            addCriterion("zjdbh >=", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhLessThan(String value) {
            addCriterion("zjdbh <", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhLessThanOrEqualTo(String value) {
            addCriterion("zjdbh <=", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhLike(String value) {
            addCriterion("zjdbh like", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhNotLike(String value) {
            addCriterion("zjdbh not like", value, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhIn(List<String> values) {
            addCriterion("zjdbh in", values, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhNotIn(List<String> values) {
            addCriterion("zjdbh not in", values, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhBetween(String value1, String value2) {
            addCriterion("zjdbh between", value1, value2, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andZjdbhNotBetween(String value1, String value2) {
            addCriterion("zjdbh not between", value1, value2, "zjdbh");
            return (Criteria) this;
        }

        public Criteria andJlrqIsNull() {
            addCriterion("jlrq is null");
            return (Criteria) this;
        }

        public Criteria andJlrqIsNotNull() {
            addCriterion("jlrq is not null");
            return (Criteria) this;
        }

        public Criteria andJlrqEqualTo(Date value) {
            addCriterionForJDBCDate("jlrq =", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("jlrq <>", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqGreaterThan(Date value) {
            addCriterionForJDBCDate("jlrq >", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("jlrq >=", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqLessThan(Date value) {
            addCriterionForJDBCDate("jlrq <", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("jlrq <=", value, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqIn(List<Date> values) {
            addCriterionForJDBCDate("jlrq in", values, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("jlrq not in", values, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("jlrq between", value1, value2, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("jlrq not between", value1, value2, "jlrq");
            return (Criteria) this;
        }

        public Criteria andJlyIsNull() {
            addCriterion("jly is null");
            return (Criteria) this;
        }

        public Criteria andJlyIsNotNull() {
            addCriterion("jly is not null");
            return (Criteria) this;
        }

        public Criteria andJlyEqualTo(String value) {
            addCriterion("jly =", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyNotEqualTo(String value) {
            addCriterion("jly <>", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyGreaterThan(String value) {
            addCriterion("jly >", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyGreaterThanOrEqualTo(String value) {
            addCriterion("jly >=", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyLessThan(String value) {
            addCriterion("jly <", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyLessThanOrEqualTo(String value) {
            addCriterion("jly <=", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyLike(String value) {
            addCriterion("jly like", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyNotLike(String value) {
            addCriterion("jly not like", value, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyIn(List<String> values) {
            addCriterion("jly in", values, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyNotIn(List<String> values) {
            addCriterion("jly not in", values, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyBetween(String value1, String value2) {
            addCriterion("jly between", value1, value2, "jly");
            return (Criteria) this;
        }

        public Criteria andJlyNotBetween(String value1, String value2) {
            addCriterion("jly not between", value1, value2, "jly");
            return (Criteria) this;
        }

        public Criteria andJlhdslIsNull() {
            addCriterion("jlhdsl is null");
            return (Criteria) this;
        }

        public Criteria andJlhdslIsNotNull() {
            addCriterion("jlhdsl is not null");
            return (Criteria) this;
        }

        public Criteria andJlhdslEqualTo(BigDecimal value) {
            addCriterion("jlhdsl =", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslNotEqualTo(BigDecimal value) {
            addCriterion("jlhdsl <>", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslGreaterThan(BigDecimal value) {
            addCriterion("jlhdsl >", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jlhdsl >=", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslLessThan(BigDecimal value) {
            addCriterion("jlhdsl <", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jlhdsl <=", value, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslIn(List<BigDecimal> values) {
            addCriterion("jlhdsl in", values, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslNotIn(List<BigDecimal> values) {
            addCriterion("jlhdsl not in", values, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlhdsl between", value1, value2, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andJlhdslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jlhdsl not between", value1, value2, "jlhdsl");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumIsNull() {
            addCriterion("all_finished_num is null");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumIsNotNull() {
            addCriterion("all_finished_num is not null");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumEqualTo(BigDecimal value) {
            addCriterion("all_finished_num =", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumNotEqualTo(BigDecimal value) {
            addCriterion("all_finished_num <>", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumGreaterThan(BigDecimal value) {
            addCriterion("all_finished_num >", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_finished_num >=", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumLessThan(BigDecimal value) {
            addCriterion("all_finished_num <", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_finished_num <=", value, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumIn(List<BigDecimal> values) {
            addCriterion("all_finished_num in", values, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumNotIn(List<BigDecimal> values) {
            addCriterion("all_finished_num not in", values, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_finished_num between", value1, value2, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andAllFinishedNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_finished_num not between", value1, value2, "allFinishedNum");
            return (Criteria) this;
        }

        public Criteria andZjplIsNull() {
            addCriterion("zjpl is null");
            return (Criteria) this;
        }

        public Criteria andZjplIsNotNull() {
            addCriterion("zjpl is not null");
            return (Criteria) this;
        }

        public Criteria andZjplEqualTo(Long value) {
            addCriterion("zjpl =", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplNotEqualTo(Long value) {
            addCriterion("zjpl <>", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplGreaterThan(Long value) {
            addCriterion("zjpl >", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplGreaterThanOrEqualTo(Long value) {
            addCriterion("zjpl >=", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplLessThan(Long value) {
            addCriterion("zjpl <", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplLessThanOrEqualTo(Long value) {
            addCriterion("zjpl <=", value, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplIn(List<Long> values) {
            addCriterion("zjpl in", values, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplNotIn(List<Long> values) {
            addCriterion("zjpl not in", values, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplBetween(Long value1, Long value2) {
            addCriterion("zjpl between", value1, value2, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjplNotBetween(Long value1, Long value2) {
            addCriterion("zjpl not between", value1, value2, "zjpl");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhIsNull() {
            addCriterion("zjzjdbh is null");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhIsNotNull() {
            addCriterion("zjzjdbh is not null");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhEqualTo(String value) {
            addCriterion("zjzjdbh =", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhNotEqualTo(String value) {
            addCriterion("zjzjdbh <>", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhGreaterThan(String value) {
            addCriterion("zjzjdbh >", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhGreaterThanOrEqualTo(String value) {
            addCriterion("zjzjdbh >=", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhLessThan(String value) {
            addCriterion("zjzjdbh <", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhLessThanOrEqualTo(String value) {
            addCriterion("zjzjdbh <=", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhLike(String value) {
            addCriterion("zjzjdbh like", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhNotLike(String value) {
            addCriterion("zjzjdbh not like", value, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhIn(List<String> values) {
            addCriterion("zjzjdbh in", values, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhNotIn(List<String> values) {
            addCriterion("zjzjdbh not in", values, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhBetween(String value1, String value2) {
            addCriterion("zjzjdbh between", value1, value2, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andZjzjdbhNotBetween(String value1, String value2) {
            addCriterion("zjzjdbh not between", value1, value2, "zjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjplIsNull() {
            addCriterion("cjpl is null");
            return (Criteria) this;
        }

        public Criteria andCjplIsNotNull() {
            addCriterion("cjpl is not null");
            return (Criteria) this;
        }

        public Criteria andCjplEqualTo(Long value) {
            addCriterion("cjpl =", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplNotEqualTo(Long value) {
            addCriterion("cjpl <>", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplGreaterThan(Long value) {
            addCriterion("cjpl >", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplGreaterThanOrEqualTo(Long value) {
            addCriterion("cjpl >=", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplLessThan(Long value) {
            addCriterion("cjpl <", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplLessThanOrEqualTo(Long value) {
            addCriterion("cjpl <=", value, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplIn(List<Long> values) {
            addCriterion("cjpl in", values, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplNotIn(List<Long> values) {
            addCriterion("cjpl not in", values, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplBetween(Long value1, Long value2) {
            addCriterion("cjpl between", value1, value2, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjplNotBetween(Long value1, Long value2) {
            addCriterion("cjpl not between", value1, value2, "cjpl");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhIsNull() {
            addCriterion("cjzjdbh is null");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhIsNotNull() {
            addCriterion("cjzjdbh is not null");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhEqualTo(String value) {
            addCriterion("cjzjdbh =", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhNotEqualTo(String value) {
            addCriterion("cjzjdbh <>", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhGreaterThan(String value) {
            addCriterion("cjzjdbh >", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhGreaterThanOrEqualTo(String value) {
            addCriterion("cjzjdbh >=", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhLessThan(String value) {
            addCriterion("cjzjdbh <", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhLessThanOrEqualTo(String value) {
            addCriterion("cjzjdbh <=", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhLike(String value) {
            addCriterion("cjzjdbh like", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhNotLike(String value) {
            addCriterion("cjzjdbh not like", value, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhIn(List<String> values) {
            addCriterion("cjzjdbh in", values, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhNotIn(List<String> values) {
            addCriterion("cjzjdbh not in", values, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhBetween(String value1, String value2) {
            addCriterion("cjzjdbh between", value1, value2, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andCjzjdbhNotBetween(String value1, String value2) {
            addCriterion("cjzjdbh not between", value1, value2, "cjzjdbh");
            return (Criteria) this;
        }

        public Criteria andJyplhjIsNull() {
            addCriterion("jyplhj is null");
            return (Criteria) this;
        }

        public Criteria andJyplhjIsNotNull() {
            addCriterion("jyplhj is not null");
            return (Criteria) this;
        }

        public Criteria andJyplhjEqualTo(Long value) {
            addCriterion("jyplhj =", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjNotEqualTo(Long value) {
            addCriterion("jyplhj <>", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjGreaterThan(Long value) {
            addCriterion("jyplhj >", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjGreaterThanOrEqualTo(Long value) {
            addCriterion("jyplhj >=", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjLessThan(Long value) {
            addCriterion("jyplhj <", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjLessThanOrEqualTo(Long value) {
            addCriterion("jyplhj <=", value, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjIn(List<Long> values) {
            addCriterion("jyplhj in", values, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjNotIn(List<Long> values) {
            addCriterion("jyplhj not in", values, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjBetween(Long value1, Long value2) {
            addCriterion("jyplhj between", value1, value2, "jyplhj");
            return (Criteria) this;
        }

        public Criteria andJyplhjNotBetween(Long value1, Long value2) {
            addCriterion("jyplhj not between", value1, value2, "jyplhj");
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

        public Criteria andJllshIsNull() {
            addCriterion("jllsh is null");
            return (Criteria) this;
        }

        public Criteria andJllshIsNotNull() {
            addCriterion("jllsh is not null");
            return (Criteria) this;
        }

        public Criteria andJllshEqualTo(String value) {
            addCriterion("jllsh =", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshNotEqualTo(String value) {
            addCriterion("jllsh <>", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshGreaterThan(String value) {
            addCriterion("jllsh >", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshGreaterThanOrEqualTo(String value) {
            addCriterion("jllsh >=", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshLessThan(String value) {
            addCriterion("jllsh <", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshLessThanOrEqualTo(String value) {
            addCriterion("jllsh <=", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshLike(String value) {
            addCriterion("jllsh like", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshNotLike(String value) {
            addCriterion("jllsh not like", value, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshIn(List<String> values) {
            addCriterion("jllsh in", values, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshNotIn(List<String> values) {
            addCriterion("jllsh not in", values, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshBetween(String value1, String value2) {
            addCriterion("jllsh between", value1, value2, "jllsh");
            return (Criteria) this;
        }

        public Criteria andJllshNotBetween(String value1, String value2) {
            addCriterion("jllsh not between", value1, value2, "jllsh");
            return (Criteria) this;
        }

        public Criteria andCqlxIsNull() {
            addCriterion("cqlx is null");
            return (Criteria) this;
        }

        public Criteria andCqlxIsNotNull() {
            addCriterion("cqlx is not null");
            return (Criteria) this;
        }

        public Criteria andCqlxEqualTo(String value) {
            addCriterion("cqlx =", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxNotEqualTo(String value) {
            addCriterion("cqlx <>", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxGreaterThan(String value) {
            addCriterion("cqlx >", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxGreaterThanOrEqualTo(String value) {
            addCriterion("cqlx >=", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxLessThan(String value) {
            addCriterion("cqlx <", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxLessThanOrEqualTo(String value) {
            addCriterion("cqlx <=", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxLike(String value) {
            addCriterion("cqlx like", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxNotLike(String value) {
            addCriterion("cqlx not like", value, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxIn(List<String> values) {
            addCriterion("cqlx in", values, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxNotIn(List<String> values) {
            addCriterion("cqlx not in", values, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxBetween(String value1, String value2) {
            addCriterion("cqlx between", value1, value2, "cqlx");
            return (Criteria) this;
        }

        public Criteria andCqlxNotBetween(String value1, String value2) {
            addCriterion("cqlx not between", value1, value2, "cqlx");
            return (Criteria) this;
        }

        public Criteria andGcnrIsNull() {
            addCriterion("gcnr is null");
            return (Criteria) this;
        }

        public Criteria andGcnrIsNotNull() {
            addCriterion("gcnr is not null");
            return (Criteria) this;
        }

        public Criteria andGcnrEqualTo(String value) {
            addCriterion("gcnr =", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrNotEqualTo(String value) {
            addCriterion("gcnr <>", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrGreaterThan(String value) {
            addCriterion("gcnr >", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrGreaterThanOrEqualTo(String value) {
            addCriterion("gcnr >=", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrLessThan(String value) {
            addCriterion("gcnr <", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrLessThanOrEqualTo(String value) {
            addCriterion("gcnr <=", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrLike(String value) {
            addCriterion("gcnr like", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrNotLike(String value) {
            addCriterion("gcnr not like", value, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrIn(List<String> values) {
            addCriterion("gcnr in", values, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrNotIn(List<String> values) {
            addCriterion("gcnr not in", values, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrBetween(String value1, String value2) {
            addCriterion("gcnr between", value1, value2, "gcnr");
            return (Criteria) this;
        }

        public Criteria andGcnrNotBetween(String value1, String value2) {
            addCriterion("gcnr not between", value1, value2, "gcnr");
            return (Criteria) this;
        }

        public Criteria andBgsjthIsNull() {
            addCriterion("bgsjth is null");
            return (Criteria) this;
        }

        public Criteria andBgsjthIsNotNull() {
            addCriterion("bgsjth is not null");
            return (Criteria) this;
        }

        public Criteria andBgsjthEqualTo(String value) {
            addCriterion("bgsjth =", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthNotEqualTo(String value) {
            addCriterion("bgsjth <>", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthGreaterThan(String value) {
            addCriterion("bgsjth >", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthGreaterThanOrEqualTo(String value) {
            addCriterion("bgsjth >=", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthLessThan(String value) {
            addCriterion("bgsjth <", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthLessThanOrEqualTo(String value) {
            addCriterion("bgsjth <=", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthLike(String value) {
            addCriterion("bgsjth like", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthNotLike(String value) {
            addCriterion("bgsjth not like", value, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthIn(List<String> values) {
            addCriterion("bgsjth in", values, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthNotIn(List<String> values) {
            addCriterion("bgsjth not in", values, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthBetween(String value1, String value2) {
            addCriterion("bgsjth between", value1, value2, "bgsjth");
            return (Criteria) this;
        }

        public Criteria andBgsjthNotBetween(String value1, String value2) {
            addCriterion("bgsjth not between", value1, value2, "bgsjth");
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