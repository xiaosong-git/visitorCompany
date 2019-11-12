package com.manage.model;

import java.util.ArrayList;
import java.util.List;

public class TblUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblUserExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("orgId is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgId is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Long value) {
            addCriterion("orgId =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Long value) {
            addCriterion("orgId <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Long value) {
            addCriterion("orgId >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Long value) {
            addCriterion("orgId >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Long value) {
            addCriterion("orgId <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Long value) {
            addCriterion("orgId <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Long> values) {
            addCriterion("orgId in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Long> values) {
            addCriterion("orgId not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Long value1, Long value2) {
            addCriterion("orgId between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Long value1, Long value2) {
            addCriterion("orgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andRelationnoIsNull() {
            addCriterion("relationNo is null");
            return (Criteria) this;
        }

        public Criteria andRelationnoIsNotNull() {
            addCriterion("relationNo is not null");
            return (Criteria) this;
        }

        public Criteria andRelationnoEqualTo(String value) {
            addCriterion("relationNo =", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoNotEqualTo(String value) {
            addCriterion("relationNo <>", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoGreaterThan(String value) {
            addCriterion("relationNo >", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoGreaterThanOrEqualTo(String value) {
            addCriterion("relationNo >=", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoLessThan(String value) {
            addCriterion("relationNo <", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoLessThanOrEqualTo(String value) {
            addCriterion("relationNo <=", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoLike(String value) {
            addCriterion("relationNo like", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoNotLike(String value) {
            addCriterion("relationNo not like", value, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoIn(List<String> values) {
            addCriterion("relationNo in", values, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoNotIn(List<String> values) {
            addCriterion("relationNo not in", values, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoBetween(String value1, String value2) {
            addCriterion("relationNo between", value1, value2, "relationno");
            return (Criteria) this;
        }

        public Criteria andRelationnoNotBetween(String value1, String value2) {
            addCriterion("relationNo not between", value1, value2, "relationno");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realName is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realName is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realName =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realName <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realName >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realName >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realName <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realName <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realName like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realName not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realName in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realName not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realName between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realName not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNicenameIsNull() {
            addCriterion("niceName is null");
            return (Criteria) this;
        }

        public Criteria andNicenameIsNotNull() {
            addCriterion("niceName is not null");
            return (Criteria) this;
        }

        public Criteria andNicenameEqualTo(String value) {
            addCriterion("niceName =", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameNotEqualTo(String value) {
            addCriterion("niceName <>", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameGreaterThan(String value) {
            addCriterion("niceName >", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameGreaterThanOrEqualTo(String value) {
            addCriterion("niceName >=", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameLessThan(String value) {
            addCriterion("niceName <", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameLessThanOrEqualTo(String value) {
            addCriterion("niceName <=", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameLike(String value) {
            addCriterion("niceName like", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameNotLike(String value) {
            addCriterion("niceName not like", value, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameIn(List<String> values) {
            addCriterion("niceName in", values, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameNotIn(List<String> values) {
            addCriterion("niceName not in", values, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameBetween(String value1, String value2) {
            addCriterion("niceName between", value1, value2, "nicename");
            return (Criteria) this;
        }

        public Criteria andNicenameNotBetween(String value1, String value2) {
            addCriterion("niceName not between", value1, value2, "nicename");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("loginName is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginName =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginName <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginName >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginName >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginName <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginName <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginName like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginName not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginName in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginName not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginName between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginName not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNull() {
            addCriterion("idType is null");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNotNull() {
            addCriterion("idType is not null");
            return (Criteria) this;
        }

        public Criteria andIdtypeEqualTo(String value) {
            addCriterion("idType =", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotEqualTo(String value) {
            addCriterion("idType <>", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThan(String value) {
            addCriterion("idType >", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThanOrEqualTo(String value) {
            addCriterion("idType >=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThan(String value) {
            addCriterion("idType <", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThanOrEqualTo(String value) {
            addCriterion("idType <=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLike(String value) {
            addCriterion("idType like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotLike(String value) {
            addCriterion("idType not like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeIn(List<String> values) {
            addCriterion("idType in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotIn(List<String> values) {
            addCriterion("idType not in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeBetween(String value1, String value2) {
            addCriterion("idType between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotBetween(String value1, String value2) {
            addCriterion("idType not between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("idNO is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("idNO is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("idNO =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("idNO <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("idNO >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("idNO >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("idNO <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("idNO <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("idNO like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("idNO not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("idNO in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("idNO not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("idNO between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("idNO not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createDate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createDate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andIsauthIsNull() {
            addCriterion("isAuth is null");
            return (Criteria) this;
        }

        public Criteria andIsauthIsNotNull() {
            addCriterion("isAuth is not null");
            return (Criteria) this;
        }

        public Criteria andIsauthEqualTo(String value) {
            addCriterion("isAuth =", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotEqualTo(String value) {
            addCriterion("isAuth <>", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthGreaterThan(String value) {
            addCriterion("isAuth >", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthGreaterThanOrEqualTo(String value) {
            addCriterion("isAuth >=", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthLessThan(String value) {
            addCriterion("isAuth <", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthLessThanOrEqualTo(String value) {
            addCriterion("isAuth <=", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthLike(String value) {
            addCriterion("isAuth like", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotLike(String value) {
            addCriterion("isAuth not like", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthIn(List<String> values) {
            addCriterion("isAuth in", values, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotIn(List<String> values) {
            addCriterion("isAuth not in", values, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthBetween(String value1, String value2) {
            addCriterion("isAuth between", value1, value2, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotBetween(String value1, String value2) {
            addCriterion("isAuth not between", value1, value2, "isauth");
            return (Criteria) this;
        }

        public Criteria andAuthdateIsNull() {
            addCriterion("authDate is null");
            return (Criteria) this;
        }

        public Criteria andAuthdateIsNotNull() {
            addCriterion("authDate is not null");
            return (Criteria) this;
        }

        public Criteria andAuthdateEqualTo(String value) {
            addCriterion("authDate =", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateNotEqualTo(String value) {
            addCriterion("authDate <>", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateGreaterThan(String value) {
            addCriterion("authDate >", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateGreaterThanOrEqualTo(String value) {
            addCriterion("authDate >=", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateLessThan(String value) {
            addCriterion("authDate <", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateLessThanOrEqualTo(String value) {
            addCriterion("authDate <=", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateLike(String value) {
            addCriterion("authDate like", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateNotLike(String value) {
            addCriterion("authDate not like", value, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateIn(List<String> values) {
            addCriterion("authDate in", values, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateNotIn(List<String> values) {
            addCriterion("authDate not in", values, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateBetween(String value1, String value2) {
            addCriterion("authDate between", value1, value2, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthdateNotBetween(String value1, String value2) {
            addCriterion("authDate not between", value1, value2, "authdate");
            return (Criteria) this;
        }

        public Criteria andAuthtimeIsNull() {
            addCriterion("authTime is null");
            return (Criteria) this;
        }

        public Criteria andAuthtimeIsNotNull() {
            addCriterion("authTime is not null");
            return (Criteria) this;
        }

        public Criteria andAuthtimeEqualTo(String value) {
            addCriterion("authTime =", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeNotEqualTo(String value) {
            addCriterion("authTime <>", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeGreaterThan(String value) {
            addCriterion("authTime >", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeGreaterThanOrEqualTo(String value) {
            addCriterion("authTime >=", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeLessThan(String value) {
            addCriterion("authTime <", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeLessThanOrEqualTo(String value) {
            addCriterion("authTime <=", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeLike(String value) {
            addCriterion("authTime like", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeNotLike(String value) {
            addCriterion("authTime not like", value, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeIn(List<String> values) {
            addCriterion("authTime in", values, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeNotIn(List<String> values) {
            addCriterion("authTime not in", values, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeBetween(String value1, String value2) {
            addCriterion("authTime between", value1, value2, "authtime");
            return (Criteria) this;
        }

        public Criteria andAuthtimeNotBetween(String value1, String value2) {
            addCriterion("authTime not between", value1, value2, "authtime");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlIsNull() {
            addCriterion("idFrontImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlIsNotNull() {
            addCriterion("idFrontImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlEqualTo(String value) {
            addCriterion("idFrontImgUrl =", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlNotEqualTo(String value) {
            addCriterion("idFrontImgUrl <>", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlGreaterThan(String value) {
            addCriterion("idFrontImgUrl >", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("idFrontImgUrl >=", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlLessThan(String value) {
            addCriterion("idFrontImgUrl <", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlLessThanOrEqualTo(String value) {
            addCriterion("idFrontImgUrl <=", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlLike(String value) {
            addCriterion("idFrontImgUrl like", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlNotLike(String value) {
            addCriterion("idFrontImgUrl not like", value, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlIn(List<String> values) {
            addCriterion("idFrontImgUrl in", values, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlNotIn(List<String> values) {
            addCriterion("idFrontImgUrl not in", values, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlBetween(String value1, String value2) {
            addCriterion("idFrontImgUrl between", value1, value2, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdfrontimgurlNotBetween(String value1, String value2) {
            addCriterion("idFrontImgUrl not between", value1, value2, "idfrontimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlIsNull() {
            addCriterion("idOppositeImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlIsNotNull() {
            addCriterion("idOppositeImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlEqualTo(String value) {
            addCriterion("idOppositeImgUrl =", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlNotEqualTo(String value) {
            addCriterion("idOppositeImgUrl <>", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlGreaterThan(String value) {
            addCriterion("idOppositeImgUrl >", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("idOppositeImgUrl >=", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlLessThan(String value) {
            addCriterion("idOppositeImgUrl <", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlLessThanOrEqualTo(String value) {
            addCriterion("idOppositeImgUrl <=", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlLike(String value) {
            addCriterion("idOppositeImgUrl like", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlNotLike(String value) {
            addCriterion("idOppositeImgUrl not like", value, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlIn(List<String> values) {
            addCriterion("idOppositeImgUrl in", values, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlNotIn(List<String> values) {
            addCriterion("idOppositeImgUrl not in", values, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlBetween(String value1, String value2) {
            addCriterion("idOppositeImgUrl between", value1, value2, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdoppositeimgurlNotBetween(String value1, String value2) {
            addCriterion("idOppositeImgUrl not between", value1, value2, "idoppositeimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlIsNull() {
            addCriterion("idHandleImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlIsNotNull() {
            addCriterion("idHandleImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlEqualTo(String value) {
            addCriterion("idHandleImgUrl =", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlNotEqualTo(String value) {
            addCriterion("idHandleImgUrl <>", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlGreaterThan(String value) {
            addCriterion("idHandleImgUrl >", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("idHandleImgUrl >=", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlLessThan(String value) {
            addCriterion("idHandleImgUrl <", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlLessThanOrEqualTo(String value) {
            addCriterion("idHandleImgUrl <=", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlLike(String value) {
            addCriterion("idHandleImgUrl like", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlNotLike(String value) {
            addCriterion("idHandleImgUrl not like", value, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlIn(List<String> values) {
            addCriterion("idHandleImgUrl in", values, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlNotIn(List<String> values) {
            addCriterion("idHandleImgUrl not in", values, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlBetween(String value1, String value2) {
            addCriterion("idHandleImgUrl between", value1, value2, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andIdhandleimgurlNotBetween(String value1, String value2) {
            addCriterion("idHandleImgUrl not between", value1, value2, "idhandleimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlIsNull() {
            addCriterion("bankCardImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlIsNotNull() {
            addCriterion("bankCardImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlEqualTo(String value) {
            addCriterion("bankCardImgUrl =", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlNotEqualTo(String value) {
            addCriterion("bankCardImgUrl <>", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlGreaterThan(String value) {
            addCriterion("bankCardImgUrl >", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("bankCardImgUrl >=", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlLessThan(String value) {
            addCriterion("bankCardImgUrl <", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlLessThanOrEqualTo(String value) {
            addCriterion("bankCardImgUrl <=", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlLike(String value) {
            addCriterion("bankCardImgUrl like", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlNotLike(String value) {
            addCriterion("bankCardImgUrl not like", value, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlIn(List<String> values) {
            addCriterion("bankCardImgUrl in", values, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlNotIn(List<String> values) {
            addCriterion("bankCardImgUrl not in", values, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlBetween(String value1, String value2) {
            addCriterion("bankCardImgUrl between", value1, value2, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andBankcardimgurlNotBetween(String value1, String value2) {
            addCriterion("bankCardImgUrl not between", value1, value2, "bankcardimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNull() {
            addCriterion("headImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNotNull() {
            addCriterion("headImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlEqualTo(String value) {
            addCriterion("headImgUrl =", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotEqualTo(String value) {
            addCriterion("headImgUrl <>", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThan(String value) {
            addCriterion("headImgUrl >", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("headImgUrl >=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThan(String value) {
            addCriterion("headImgUrl <", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("headImgUrl <=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLike(String value) {
            addCriterion("headImgUrl like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotLike(String value) {
            addCriterion("headImgUrl not like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIn(List<String> values) {
            addCriterion("headImgUrl in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotIn(List<String> values) {
            addCriterion("headImgUrl not in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlBetween(String value1, String value2) {
            addCriterion("headImgUrl between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("headImgUrl not between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdIsNull() {
            addCriterion("isSetTransPwd is null");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdIsNotNull() {
            addCriterion("isSetTransPwd is not null");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdEqualTo(String value) {
            addCriterion("isSetTransPwd =", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdNotEqualTo(String value) {
            addCriterion("isSetTransPwd <>", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdGreaterThan(String value) {
            addCriterion("isSetTransPwd >", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdGreaterThanOrEqualTo(String value) {
            addCriterion("isSetTransPwd >=", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdLessThan(String value) {
            addCriterion("isSetTransPwd <", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdLessThanOrEqualTo(String value) {
            addCriterion("isSetTransPwd <=", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdLike(String value) {
            addCriterion("isSetTransPwd like", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdNotLike(String value) {
            addCriterion("isSetTransPwd not like", value, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdIn(List<String> values) {
            addCriterion("isSetTransPwd in", values, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdNotIn(List<String> values) {
            addCriterion("isSetTransPwd not in", values, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdBetween(String value1, String value2) {
            addCriterion("isSetTransPwd between", value1, value2, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andIssettranspwdNotBetween(String value1, String value2) {
            addCriterion("isSetTransPwd not between", value1, value2, "issettranspwd");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlIsNull() {
            addCriterion("qrcodeUrl is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlIsNotNull() {
            addCriterion("qrcodeUrl is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlEqualTo(String value) {
            addCriterion("qrcodeUrl =", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlNotEqualTo(String value) {
            addCriterion("qrcodeUrl <>", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlGreaterThan(String value) {
            addCriterion("qrcodeUrl >", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlGreaterThanOrEqualTo(String value) {
            addCriterion("qrcodeUrl >=", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlLessThan(String value) {
            addCriterion("qrcodeUrl <", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlLessThanOrEqualTo(String value) {
            addCriterion("qrcodeUrl <=", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlLike(String value) {
            addCriterion("qrcodeUrl like", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlNotLike(String value) {
            addCriterion("qrcodeUrl not like", value, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlIn(List<String> values) {
            addCriterion("qrcodeUrl in", values, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlNotIn(List<String> values) {
            addCriterion("qrcodeUrl not in", values, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlBetween(String value1, String value2) {
            addCriterion("qrcodeUrl between", value1, value2, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andQrcodeurlNotBetween(String value1, String value2) {
            addCriterion("qrcodeUrl not between", value1, value2, "qrcodeurl");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyId is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyId is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Long value) {
            addCriterion("companyId =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Long value) {
            addCriterion("companyId <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Long value) {
            addCriterion("companyId >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Long value) {
            addCriterion("companyId >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Long value) {
            addCriterion("companyId <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Long value) {
            addCriterion("companyId <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Long> values) {
            addCriterion("companyId in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Long> values) {
            addCriterion("companyId not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Long value1, Long value2) {
            addCriterion("companyId between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Long value1, Long value2) {
            addCriterion("companyId not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andWorkkeyIsNull() {
            addCriterion("workKey is null");
            return (Criteria) this;
        }

        public Criteria andWorkkeyIsNotNull() {
            addCriterion("workKey is not null");
            return (Criteria) this;
        }

        public Criteria andWorkkeyEqualTo(String value) {
            addCriterion("workKey =", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyNotEqualTo(String value) {
            addCriterion("workKey <>", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyGreaterThan(String value) {
            addCriterion("workKey >", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyGreaterThanOrEqualTo(String value) {
            addCriterion("workKey >=", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyLessThan(String value) {
            addCriterion("workKey <", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyLessThanOrEqualTo(String value) {
            addCriterion("workKey <=", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyLike(String value) {
            addCriterion("workKey like", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyNotLike(String value) {
            addCriterion("workKey not like", value, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyIn(List<String> values) {
            addCriterion("workKey in", values, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyNotIn(List<String> values) {
            addCriterion("workKey not in", values, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyBetween(String value1, String value2) {
            addCriterion("workKey between", value1, value2, "workkey");
            return (Criteria) this;
        }

        public Criteria andWorkkeyNotBetween(String value1, String value2) {
            addCriterion("workKey not between", value1, value2, "workkey");
            return (Criteria) this;
        }

        public Criteria andFailreasonIsNull() {
            addCriterion("failReason is null");
            return (Criteria) this;
        }

        public Criteria andFailreasonIsNotNull() {
            addCriterion("failReason is not null");
            return (Criteria) this;
        }

        public Criteria andFailreasonEqualTo(String value) {
            addCriterion("failReason =", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotEqualTo(String value) {
            addCriterion("failReason <>", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonGreaterThan(String value) {
            addCriterion("failReason >", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonGreaterThanOrEqualTo(String value) {
            addCriterion("failReason >=", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLessThan(String value) {
            addCriterion("failReason <", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLessThanOrEqualTo(String value) {
            addCriterion("failReason <=", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonLike(String value) {
            addCriterion("failReason like", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotLike(String value) {
            addCriterion("failReason not like", value, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonIn(List<String> values) {
            addCriterion("failReason in", values, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotIn(List<String> values) {
            addCriterion("failReason not in", values, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonBetween(String value1, String value2) {
            addCriterion("failReason between", value1, value2, "failreason");
            return (Criteria) this;
        }

        public Criteria andFailreasonNotBetween(String value1, String value2) {
            addCriterion("failReason not between", value1, value2, "failreason");
            return (Criteria) this;
        }

        public Criteria andSolecodeIsNull() {
            addCriterion("soleCode is null");
            return (Criteria) this;
        }

        public Criteria andSolecodeIsNotNull() {
            addCriterion("soleCode is not null");
            return (Criteria) this;
        }

        public Criteria andSolecodeEqualTo(String value) {
            addCriterion("soleCode =", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeNotEqualTo(String value) {
            addCriterion("soleCode <>", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeGreaterThan(String value) {
            addCriterion("soleCode >", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeGreaterThanOrEqualTo(String value) {
            addCriterion("soleCode >=", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeLessThan(String value) {
            addCriterion("soleCode <", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeLessThanOrEqualTo(String value) {
            addCriterion("soleCode <=", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeLike(String value) {
            addCriterion("soleCode like", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeNotLike(String value) {
            addCriterion("soleCode not like", value, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeIn(List<String> values) {
            addCriterion("soleCode in", values, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeNotIn(List<String> values) {
            addCriterion("soleCode not in", values, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeBetween(String value1, String value2) {
            addCriterion("soleCode between", value1, value2, "solecode");
            return (Criteria) this;
        }

        public Criteria andSolecodeNotBetween(String value1, String value2) {
            addCriterion("soleCode not between", value1, value2, "solecode");
            return (Criteria) this;
        }

        public Criteria andValiditydateIsNull() {
            addCriterion("validityDate is null");
            return (Criteria) this;
        }

        public Criteria andValiditydateIsNotNull() {
            addCriterion("validityDate is not null");
            return (Criteria) this;
        }

        public Criteria andValiditydateEqualTo(String value) {
            addCriterion("validityDate =", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateNotEqualTo(String value) {
            addCriterion("validityDate <>", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateGreaterThan(String value) {
            addCriterion("validityDate >", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateGreaterThanOrEqualTo(String value) {
            addCriterion("validityDate >=", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateLessThan(String value) {
            addCriterion("validityDate <", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateLessThanOrEqualTo(String value) {
            addCriterion("validityDate <=", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateLike(String value) {
            addCriterion("validityDate like", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateNotLike(String value) {
            addCriterion("validityDate not like", value, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateIn(List<String> values) {
            addCriterion("validityDate in", values, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateNotIn(List<String> values) {
            addCriterion("validityDate not in", values, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateBetween(String value1, String value2) {
            addCriterion("validityDate between", value1, value2, "validitydate");
            return (Criteria) this;
        }

        public Criteria andValiditydateNotBetween(String value1, String value2) {
            addCriterion("validityDate not between", value1, value2, "validitydate");
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