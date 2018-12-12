package com.ykkj.weiyi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsPlanTzkz06Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsPlanTzkz06Example() {
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

        public Criteria andXiangmuIsbnIsNull() {
            addCriterion("xiangmu_isbn is null");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnIsNotNull() {
            addCriterion("xiangmu_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnEqualTo(String value) {
            addCriterion("xiangmu_isbn =", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnNotEqualTo(String value) {
            addCriterion("xiangmu_isbn <>", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnGreaterThan(String value) {
            addCriterion("xiangmu_isbn >", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmu_isbn >=", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnLessThan(String value) {
            addCriterion("xiangmu_isbn <", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnLessThanOrEqualTo(String value) {
            addCriterion("xiangmu_isbn <=", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnLike(String value) {
            addCriterion("xiangmu_isbn like", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnNotLike(String value) {
            addCriterion("xiangmu_isbn not like", value, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnIn(List<String> values) {
            addCriterion("xiangmu_isbn in", values, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnNotIn(List<String> values) {
            addCriterion("xiangmu_isbn not in", values, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnBetween(String value1, String value2) {
            addCriterion("xiangmu_isbn between", value1, value2, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuIsbnNotBetween(String value1, String value2) {
            addCriterion("xiangmu_isbn not between", value1, value2, "xiangmuIsbn");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameIsNull() {
            addCriterion("xiangmu_name is null");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameIsNotNull() {
            addCriterion("xiangmu_name is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameEqualTo(String value) {
            addCriterion("xiangmu_name =", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameNotEqualTo(String value) {
            addCriterion("xiangmu_name <>", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameGreaterThan(String value) {
            addCriterion("xiangmu_name >", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmu_name >=", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameLessThan(String value) {
            addCriterion("xiangmu_name <", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameLessThanOrEqualTo(String value) {
            addCriterion("xiangmu_name <=", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameLike(String value) {
            addCriterion("xiangmu_name like", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameNotLike(String value) {
            addCriterion("xiangmu_name not like", value, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameIn(List<String> values) {
            addCriterion("xiangmu_name in", values, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameNotIn(List<String> values) {
            addCriterion("xiangmu_name not in", values, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameBetween(String value1, String value2) {
            addCriterion("xiangmu_name between", value1, value2, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andXiangmuNameNotBetween(String value1, String value2) {
            addCriterion("xiangmu_name not between", value1, value2, "xiangmuName");
            return (Criteria) this;
        }

        public Criteria andTbdwIsNull() {
            addCriterion("tbdw is null");
            return (Criteria) this;
        }

        public Criteria andTbdwIsNotNull() {
            addCriterion("tbdw is not null");
            return (Criteria) this;
        }

        public Criteria andTbdwEqualTo(String value) {
            addCriterion("tbdw =", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwNotEqualTo(String value) {
            addCriterion("tbdw <>", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwGreaterThan(String value) {
            addCriterion("tbdw >", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwGreaterThanOrEqualTo(String value) {
            addCriterion("tbdw >=", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwLessThan(String value) {
            addCriterion("tbdw <", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwLessThanOrEqualTo(String value) {
            addCriterion("tbdw <=", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwLike(String value) {
            addCriterion("tbdw like", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwNotLike(String value) {
            addCriterion("tbdw not like", value, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwIn(List<String> values) {
            addCriterion("tbdw in", values, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwNotIn(List<String> values) {
            addCriterion("tbdw not in", values, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwBetween(String value1, String value2) {
            addCriterion("tbdw between", value1, value2, "tbdw");
            return (Criteria) this;
        }

        public Criteria andTbdwNotBetween(String value1, String value2) {
            addCriterion("tbdw not between", value1, value2, "tbdw");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmIsNull() {
            addCriterion("xmzhzxm is null");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmIsNotNull() {
            addCriterion("xmzhzxm is not null");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmEqualTo(String value) {
            addCriterion("xmzhzxm =", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmNotEqualTo(String value) {
            addCriterion("xmzhzxm <>", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmGreaterThan(String value) {
            addCriterion("xmzhzxm >", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmGreaterThanOrEqualTo(String value) {
            addCriterion("xmzhzxm >=", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmLessThan(String value) {
            addCriterion("xmzhzxm <", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmLessThanOrEqualTo(String value) {
            addCriterion("xmzhzxm <=", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmLike(String value) {
            addCriterion("xmzhzxm like", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmNotLike(String value) {
            addCriterion("xmzhzxm not like", value, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmIn(List<String> values) {
            addCriterion("xmzhzxm in", values, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmNotIn(List<String> values) {
            addCriterion("xmzhzxm not in", values, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmBetween(String value1, String value2) {
            addCriterion("xmzhzxm between", value1, value2, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzxmNotBetween(String value1, String value2) {
            addCriterion("xmzhzxm not between", value1, value2, "xmzhzxm");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhIsNull() {
            addCriterion("xmzhzdh is null");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhIsNotNull() {
            addCriterion("xmzhzdh is not null");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhEqualTo(String value) {
            addCriterion("xmzhzdh =", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhNotEqualTo(String value) {
            addCriterion("xmzhzdh <>", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhGreaterThan(String value) {
            addCriterion("xmzhzdh >", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhGreaterThanOrEqualTo(String value) {
            addCriterion("xmzhzdh >=", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhLessThan(String value) {
            addCriterion("xmzhzdh <", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhLessThanOrEqualTo(String value) {
            addCriterion("xmzhzdh <=", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhLike(String value) {
            addCriterion("xmzhzdh like", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhNotLike(String value) {
            addCriterion("xmzhzdh not like", value, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhIn(List<String> values) {
            addCriterion("xmzhzdh in", values, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhNotIn(List<String> values) {
            addCriterion("xmzhzdh not in", values, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhBetween(String value1, String value2) {
            addCriterion("xmzhzdh between", value1, value2, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzdhNotBetween(String value1, String value2) {
            addCriterion("xmzhzdh not between", value1, value2, "xmzhzdh");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjIsNull() {
            addCriterion("xmzhzsj is null");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjIsNotNull() {
            addCriterion("xmzhzsj is not null");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjEqualTo(String value) {
            addCriterion("xmzhzsj =", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjNotEqualTo(String value) {
            addCriterion("xmzhzsj <>", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjGreaterThan(String value) {
            addCriterion("xmzhzsj >", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjGreaterThanOrEqualTo(String value) {
            addCriterion("xmzhzsj >=", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjLessThan(String value) {
            addCriterion("xmzhzsj <", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjLessThanOrEqualTo(String value) {
            addCriterion("xmzhzsj <=", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjLike(String value) {
            addCriterion("xmzhzsj like", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjNotLike(String value) {
            addCriterion("xmzhzsj not like", value, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjIn(List<String> values) {
            addCriterion("xmzhzsj in", values, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjNotIn(List<String> values) {
            addCriterion("xmzhzsj not in", values, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjBetween(String value1, String value2) {
            addCriterion("xmzhzsj between", value1, value2, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andXmzhzsjNotBetween(String value1, String value2) {
            addCriterion("xmzhzsj not between", value1, value2, "xmzhzsj");
            return (Criteria) this;
        }

        public Criteria andZgxmIsNull() {
            addCriterion("zgxm is null");
            return (Criteria) this;
        }

        public Criteria andZgxmIsNotNull() {
            addCriterion("zgxm is not null");
            return (Criteria) this;
        }

        public Criteria andZgxmEqualTo(String value) {
            addCriterion("zgxm =", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmNotEqualTo(String value) {
            addCriterion("zgxm <>", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmGreaterThan(String value) {
            addCriterion("zgxm >", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmGreaterThanOrEqualTo(String value) {
            addCriterion("zgxm >=", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmLessThan(String value) {
            addCriterion("zgxm <", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmLessThanOrEqualTo(String value) {
            addCriterion("zgxm <=", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmLike(String value) {
            addCriterion("zgxm like", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmNotLike(String value) {
            addCriterion("zgxm not like", value, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmIn(List<String> values) {
            addCriterion("zgxm in", values, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmNotIn(List<String> values) {
            addCriterion("zgxm not in", values, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmBetween(String value1, String value2) {
            addCriterion("zgxm between", value1, value2, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgxmNotBetween(String value1, String value2) {
            addCriterion("zgxm not between", value1, value2, "zgxm");
            return (Criteria) this;
        }

        public Criteria andZgdhIsNull() {
            addCriterion("zgdh is null");
            return (Criteria) this;
        }

        public Criteria andZgdhIsNotNull() {
            addCriterion("zgdh is not null");
            return (Criteria) this;
        }

        public Criteria andZgdhEqualTo(String value) {
            addCriterion("zgdh =", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhNotEqualTo(String value) {
            addCriterion("zgdh <>", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhGreaterThan(String value) {
            addCriterion("zgdh >", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhGreaterThanOrEqualTo(String value) {
            addCriterion("zgdh >=", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhLessThan(String value) {
            addCriterion("zgdh <", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhLessThanOrEqualTo(String value) {
            addCriterion("zgdh <=", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhLike(String value) {
            addCriterion("zgdh like", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhNotLike(String value) {
            addCriterion("zgdh not like", value, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhIn(List<String> values) {
            addCriterion("zgdh in", values, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhNotIn(List<String> values) {
            addCriterion("zgdh not in", values, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhBetween(String value1, String value2) {
            addCriterion("zgdh between", value1, value2, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgdhNotBetween(String value1, String value2) {
            addCriterion("zgdh not between", value1, value2, "zgdh");
            return (Criteria) this;
        }

        public Criteria andZgsjIsNull() {
            addCriterion("zgsj is null");
            return (Criteria) this;
        }

        public Criteria andZgsjIsNotNull() {
            addCriterion("zgsj is not null");
            return (Criteria) this;
        }

        public Criteria andZgsjEqualTo(String value) {
            addCriterion("zgsj =", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjNotEqualTo(String value) {
            addCriterion("zgsj <>", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjGreaterThan(String value) {
            addCriterion("zgsj >", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjGreaterThanOrEqualTo(String value) {
            addCriterion("zgsj >=", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjLessThan(String value) {
            addCriterion("zgsj <", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjLessThanOrEqualTo(String value) {
            addCriterion("zgsj <=", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjLike(String value) {
            addCriterion("zgsj like", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjNotLike(String value) {
            addCriterion("zgsj not like", value, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjIn(List<String> values) {
            addCriterion("zgsj in", values, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjNotIn(List<String> values) {
            addCriterion("zgsj not in", values, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjBetween(String value1, String value2) {
            addCriterion("zgsj between", value1, value2, "zgsj");
            return (Criteria) this;
        }

        public Criteria andZgsjNotBetween(String value1, String value2) {
            addCriterion("zgsj not between", value1, value2, "zgsj");
            return (Criteria) this;
        }

        public Criteria andFzrxmIsNull() {
            addCriterion("fzrxm is null");
            return (Criteria) this;
        }

        public Criteria andFzrxmIsNotNull() {
            addCriterion("fzrxm is not null");
            return (Criteria) this;
        }

        public Criteria andFzrxmEqualTo(String value) {
            addCriterion("fzrxm =", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotEqualTo(String value) {
            addCriterion("fzrxm <>", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmGreaterThan(String value) {
            addCriterion("fzrxm >", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmGreaterThanOrEqualTo(String value) {
            addCriterion("fzrxm >=", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLessThan(String value) {
            addCriterion("fzrxm <", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLessThanOrEqualTo(String value) {
            addCriterion("fzrxm <=", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLike(String value) {
            addCriterion("fzrxm like", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotLike(String value) {
            addCriterion("fzrxm not like", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmIn(List<String> values) {
            addCriterion("fzrxm in", values, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotIn(List<String> values) {
            addCriterion("fzrxm not in", values, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmBetween(String value1, String value2) {
            addCriterion("fzrxm between", value1, value2, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotBetween(String value1, String value2) {
            addCriterion("fzrxm not between", value1, value2, "fzrxm");
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

        public Criteria andFzrsjIsNull() {
            addCriterion("fzrsj is null");
            return (Criteria) this;
        }

        public Criteria andFzrsjIsNotNull() {
            addCriterion("fzrsj is not null");
            return (Criteria) this;
        }

        public Criteria andFzrsjEqualTo(String value) {
            addCriterion("fzrsj =", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjNotEqualTo(String value) {
            addCriterion("fzrsj <>", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjGreaterThan(String value) {
            addCriterion("fzrsj >", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjGreaterThanOrEqualTo(String value) {
            addCriterion("fzrsj >=", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjLessThan(String value) {
            addCriterion("fzrsj <", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjLessThanOrEqualTo(String value) {
            addCriterion("fzrsj <=", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjLike(String value) {
            addCriterion("fzrsj like", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjNotLike(String value) {
            addCriterion("fzrsj not like", value, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjIn(List<String> values) {
            addCriterion("fzrsj in", values, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjNotIn(List<String> values) {
            addCriterion("fzrsj not in", values, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjBetween(String value1, String value2) {
            addCriterion("fzrsj between", value1, value2, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andFzrsjNotBetween(String value1, String value2) {
            addCriterion("fzrsj not between", value1, value2, "fzrsj");
            return (Criteria) this;
        }

        public Criteria andRyxmIsNull() {
            addCriterion("ryxm is null");
            return (Criteria) this;
        }

        public Criteria andRyxmIsNotNull() {
            addCriterion("ryxm is not null");
            return (Criteria) this;
        }

        public Criteria andRyxmEqualTo(String value) {
            addCriterion("ryxm =", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmNotEqualTo(String value) {
            addCriterion("ryxm <>", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmGreaterThan(String value) {
            addCriterion("ryxm >", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmGreaterThanOrEqualTo(String value) {
            addCriterion("ryxm >=", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmLessThan(String value) {
            addCriterion("ryxm <", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmLessThanOrEqualTo(String value) {
            addCriterion("ryxm <=", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmLike(String value) {
            addCriterion("ryxm like", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmNotLike(String value) {
            addCriterion("ryxm not like", value, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmIn(List<String> values) {
            addCriterion("ryxm in", values, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmNotIn(List<String> values) {
            addCriterion("ryxm not in", values, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmBetween(String value1, String value2) {
            addCriterion("ryxm between", value1, value2, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRyxmNotBetween(String value1, String value2) {
            addCriterion("ryxm not between", value1, value2, "ryxm");
            return (Criteria) this;
        }

        public Criteria andRydhIsNull() {
            addCriterion("rydh is null");
            return (Criteria) this;
        }

        public Criteria andRydhIsNotNull() {
            addCriterion("rydh is not null");
            return (Criteria) this;
        }

        public Criteria andRydhEqualTo(String value) {
            addCriterion("rydh =", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhNotEqualTo(String value) {
            addCriterion("rydh <>", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhGreaterThan(String value) {
            addCriterion("rydh >", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhGreaterThanOrEqualTo(String value) {
            addCriterion("rydh >=", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhLessThan(String value) {
            addCriterion("rydh <", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhLessThanOrEqualTo(String value) {
            addCriterion("rydh <=", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhLike(String value) {
            addCriterion("rydh like", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhNotLike(String value) {
            addCriterion("rydh not like", value, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhIn(List<String> values) {
            addCriterion("rydh in", values, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhNotIn(List<String> values) {
            addCriterion("rydh not in", values, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhBetween(String value1, String value2) {
            addCriterion("rydh between", value1, value2, "rydh");
            return (Criteria) this;
        }

        public Criteria andRydhNotBetween(String value1, String value2) {
            addCriterion("rydh not between", value1, value2, "rydh");
            return (Criteria) this;
        }

        public Criteria andRysjIsNull() {
            addCriterion("rysj is null");
            return (Criteria) this;
        }

        public Criteria andRysjIsNotNull() {
            addCriterion("rysj is not null");
            return (Criteria) this;
        }

        public Criteria andRysjEqualTo(String value) {
            addCriterion("rysj =", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjNotEqualTo(String value) {
            addCriterion("rysj <>", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjGreaterThan(String value) {
            addCriterion("rysj >", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjGreaterThanOrEqualTo(String value) {
            addCriterion("rysj >=", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjLessThan(String value) {
            addCriterion("rysj <", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjLessThanOrEqualTo(String value) {
            addCriterion("rysj <=", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjLike(String value) {
            addCriterion("rysj like", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjNotLike(String value) {
            addCriterion("rysj not like", value, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjIn(List<String> values) {
            addCriterion("rysj in", values, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjNotIn(List<String> values) {
            addCriterion("rysj not in", values, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjBetween(String value1, String value2) {
            addCriterion("rysj between", value1, value2, "rysj");
            return (Criteria) this;
        }

        public Criteria andRysjNotBetween(String value1, String value2) {
            addCriterion("rysj not between", value1, value2, "rysj");
            return (Criteria) this;
        }

        public Criteria andRyqqIsNull() {
            addCriterion("ryqq is null");
            return (Criteria) this;
        }

        public Criteria andRyqqIsNotNull() {
            addCriterion("ryqq is not null");
            return (Criteria) this;
        }

        public Criteria andRyqqEqualTo(String value) {
            addCriterion("ryqq =", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqNotEqualTo(String value) {
            addCriterion("ryqq <>", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqGreaterThan(String value) {
            addCriterion("ryqq >", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqGreaterThanOrEqualTo(String value) {
            addCriterion("ryqq >=", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqLessThan(String value) {
            addCriterion("ryqq <", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqLessThanOrEqualTo(String value) {
            addCriterion("ryqq <=", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqLike(String value) {
            addCriterion("ryqq like", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqNotLike(String value) {
            addCriterion("ryqq not like", value, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqIn(List<String> values) {
            addCriterion("ryqq in", values, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqNotIn(List<String> values) {
            addCriterion("ryqq not in", values, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqBetween(String value1, String value2) {
            addCriterion("ryqq between", value1, value2, "ryqq");
            return (Criteria) this;
        }

        public Criteria andRyqqNotBetween(String value1, String value2) {
            addCriterion("ryqq not between", value1, value2, "ryqq");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNull() {
            addCriterion("sort_order is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(String value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(String value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(String value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(String value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(String value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(String value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLike(String value) {
            addCriterion("sort_order like", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotLike(String value) {
            addCriterion("sort_order not like", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<String> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<String> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(String value1, String value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(String value1, String value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andChuShiIsNull() {
            addCriterion("chu_shi is null");
            return (Criteria) this;
        }

        public Criteria andChuShiIsNotNull() {
            addCriterion("chu_shi is not null");
            return (Criteria) this;
        }

        public Criteria andChuShiEqualTo(Long value) {
            addCriterion("chu_shi =", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiNotEqualTo(Long value) {
            addCriterion("chu_shi <>", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiGreaterThan(Long value) {
            addCriterion("chu_shi >", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiGreaterThanOrEqualTo(Long value) {
            addCriterion("chu_shi >=", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiLessThan(Long value) {
            addCriterion("chu_shi <", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiLessThanOrEqualTo(Long value) {
            addCriterion("chu_shi <=", value, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiIn(List<Long> values) {
            addCriterion("chu_shi in", values, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiNotIn(List<Long> values) {
            addCriterion("chu_shi not in", values, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiBetween(Long value1, Long value2) {
            addCriterion("chu_shi between", value1, value2, "chuShi");
            return (Criteria) this;
        }

        public Criteria andChuShiNotBetween(Long value1, Long value2) {
            addCriterion("chu_shi not between", value1, value2, "chuShi");
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