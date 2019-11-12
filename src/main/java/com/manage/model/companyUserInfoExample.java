package com.manage.model;

import java.util.ArrayList;
import java.util.List;

public class companyUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public companyUserInfoExample() {
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

        public Criteria andCompanycodeIsNull() {
            addCriterion("companyCode is null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIsNotNull() {
            addCriterion("companyCode is not null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeEqualTo(String value) {
            addCriterion("companyCode =", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotEqualTo(String value) {
            addCriterion("companyCode <>", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThan(String value) {
            addCriterion("companyCode >", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThanOrEqualTo(String value) {
            addCriterion("companyCode >=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThan(String value) {
            addCriterion("companyCode <", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThanOrEqualTo(String value) {
            addCriterion("companyCode <=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLike(String value) {
            addCriterion("companyCode like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotLike(String value) {
            addCriterion("companyCode not like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIn(List<String> values) {
            addCriterion("companyCode in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotIn(List<String> values) {
            addCriterion("companyCode not in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeBetween(String value1, String value2) {
            addCriterion("companyCode between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotBetween(String value1, String value2) {
            addCriterion("companyCode not between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyName =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyName <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyName like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyName not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyName in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyname");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applyType is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applyType is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(String value) {
            addCriterion("applyType =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(String value) {
            addCriterion("applyType <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(String value) {
            addCriterion("applyType >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(String value) {
            addCriterion("applyType >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(String value) {
            addCriterion("applyType <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(String value) {
            addCriterion("applyType <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLike(String value) {
            addCriterion("applyType like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotLike(String value) {
            addCriterion("applyType not like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<String> values) {
            addCriterion("applyType in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<String> values) {
            addCriterion("applyType not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(String value1, String value2) {
            addCriterion("applyType between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(String value1, String value2) {
            addCriterion("applyType not between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNull() {
            addCriterion("corporationID is null");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNotNull() {
            addCriterion("corporationID is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationidEqualTo(String value) {
            addCriterion("corporationID =", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotEqualTo(String value) {
            addCriterion("corporationID <>", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThan(String value) {
            addCriterion("corporationID >", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThanOrEqualTo(String value) {
            addCriterion("corporationID >=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThan(String value) {
            addCriterion("corporationID <", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThanOrEqualTo(String value) {
            addCriterion("corporationID <=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLike(String value) {
            addCriterion("corporationID like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotLike(String value) {
            addCriterion("corporationID not like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidIn(List<String> values) {
            addCriterion("corporationID in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotIn(List<String> values) {
            addCriterion("corporationID not in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidBetween(String value1, String value2) {
            addCriterion("corporationID between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotBetween(String value1, String value2) {
            addCriterion("corporationID not between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andLicencenoIsNull() {
            addCriterion("licenceNo is null");
            return (Criteria) this;
        }

        public Criteria andLicencenoIsNotNull() {
            addCriterion("licenceNo is not null");
            return (Criteria) this;
        }

        public Criteria andLicencenoEqualTo(String value) {
            addCriterion("licenceNo =", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoNotEqualTo(String value) {
            addCriterion("licenceNo <>", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoGreaterThan(String value) {
            addCriterion("licenceNo >", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoGreaterThanOrEqualTo(String value) {
            addCriterion("licenceNo >=", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoLessThan(String value) {
            addCriterion("licenceNo <", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoLessThanOrEqualTo(String value) {
            addCriterion("licenceNo <=", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoLike(String value) {
            addCriterion("licenceNo like", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoNotLike(String value) {
            addCriterion("licenceNo not like", value, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoIn(List<String> values) {
            addCriterion("licenceNo in", values, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoNotIn(List<String> values) {
            addCriterion("licenceNo not in", values, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoBetween(String value1, String value2) {
            addCriterion("licenceNo between", value1, value2, "licenceno");
            return (Criteria) this;
        }

        public Criteria andLicencenoNotBetween(String value1, String value2) {
            addCriterion("licenceNo not between", value1, value2, "licenceno");
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

        public Criteria andCompanyfloorIsNull() {
            addCriterion("companyFloor is null");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorIsNotNull() {
            addCriterion("companyFloor is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorEqualTo(String value) {
            addCriterion("companyFloor =", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorNotEqualTo(String value) {
            addCriterion("companyFloor <>", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorGreaterThan(String value) {
            addCriterion("companyFloor >", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorGreaterThanOrEqualTo(String value) {
            addCriterion("companyFloor >=", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorLessThan(String value) {
            addCriterion("companyFloor <", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorLessThanOrEqualTo(String value) {
            addCriterion("companyFloor <=", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorLike(String value) {
            addCriterion("companyFloor like", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorNotLike(String value) {
            addCriterion("companyFloor not like", value, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorIn(List<String> values) {
            addCriterion("companyFloor in", values, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorNotIn(List<String> values) {
            addCriterion("companyFloor not in", values, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorBetween(String value1, String value2) {
            addCriterion("companyFloor between", value1, value2, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloorNotBetween(String value1, String value2) {
            addCriterion("companyFloor not between", value1, value2, "companyfloor");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2IsNull() {
            addCriterion("companyFloor2 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2IsNotNull() {
            addCriterion("companyFloor2 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2EqualTo(String value) {
            addCriterion("companyFloor2 =", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2NotEqualTo(String value) {
            addCriterion("companyFloor2 <>", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2GreaterThan(String value) {
            addCriterion("companyFloor2 >", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2GreaterThanOrEqualTo(String value) {
            addCriterion("companyFloor2 >=", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2LessThan(String value) {
            addCriterion("companyFloor2 <", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2LessThanOrEqualTo(String value) {
            addCriterion("companyFloor2 <=", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2Like(String value) {
            addCriterion("companyFloor2 like", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2NotLike(String value) {
            addCriterion("companyFloor2 not like", value, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2In(List<String> values) {
            addCriterion("companyFloor2 in", values, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2NotIn(List<String> values) {
            addCriterion("companyFloor2 not in", values, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2Between(String value1, String value2) {
            addCriterion("companyFloor2 between", value1, value2, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andCompanyfloor2NotBetween(String value1, String value2) {
            addCriterion("companyFloor2 not between", value1, value2, "companyfloor2");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueIsNull() {
            addCriterion("isyaoyue is null");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueIsNotNull() {
            addCriterion("isyaoyue is not null");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueEqualTo(String value) {
            addCriterion("isyaoyue =", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueNotEqualTo(String value) {
            addCriterion("isyaoyue <>", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueGreaterThan(String value) {
            addCriterion("isyaoyue >", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueGreaterThanOrEqualTo(String value) {
            addCriterion("isyaoyue >=", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueLessThan(String value) {
            addCriterion("isyaoyue <", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueLessThanOrEqualTo(String value) {
            addCriterion("isyaoyue <=", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueLike(String value) {
            addCriterion("isyaoyue like", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueNotLike(String value) {
            addCriterion("isyaoyue not like", value, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueIn(List<String> values) {
            addCriterion("isyaoyue in", values, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueNotIn(List<String> values) {
            addCriterion("isyaoyue not in", values, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueBetween(String value1, String value2) {
            addCriterion("isyaoyue between", value1, value2, "isyaoyue");
            return (Criteria) this;
        }

        public Criteria andIsyaoyueNotBetween(String value1, String value2) {
            addCriterion("isyaoyue not between", value1, value2, "isyaoyue");
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