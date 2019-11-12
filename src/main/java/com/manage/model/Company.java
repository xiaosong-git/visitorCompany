package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 创建日期yyyy-mm-dd
     */
    private String createDate;

    /**
     * 创建时间HH:mm:ss
     */
    private String createTime;

    /**
     * 联系人手机号
     */
    private String phone;

    /**
     * 联系人
     */
    private String name;

    /**
     * 审核类型:(manage:管理员审核,front:前台审核,staff:员工自己审核)
     */
    private String applyType;

    /**
     * 法人身份证
     */
    private String corporationID;

    /**
     * 营业执照号
     */
    private String licenceNo;

    /**
     * 公司地址
     */
    private String addr;

    /**
     * 大楼id
     */
    private Long orgId;

    //扩展
    @Transient
    private String org_name;

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取公司编码
     *
     * @return companyCode - 公司编码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置公司编码
     *
     * @param companyCode 公司编码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    /**
     * 获取公司名
     *
     * @return companyName - 公司名
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名
     *
     * @param companyName 公司名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取创建日期yyyy-mm-dd
     *
     * @return createDate - 创建日期yyyy-mm-dd
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期yyyy-mm-dd
     *
     * @param createDate 创建日期yyyy-mm-dd
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 获取创建时间HH:mm:ss
     *
     * @return createTime - 创建时间HH:mm:ss
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间HH:mm:ss
     *
     * @param createTime 创建时间HH:mm:ss
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取联系人手机号
     *
     * @return phone - 联系人手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系人手机号
     *
     * @param phone 联系人手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取联系人
     *
     * @return name - 联系人
     */
    public String getName() {
        return name;
    }

    /**
     * 设置联系人
     *
     * @param name 联系人
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取审核类型:(manage:管理员审核,front:前台审核,staff:员工自己审核)
     *
     * @return applyType - 审核类型:(manage:管理员审核,front:前台审核,staff:员工自己审核)
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * 设置审核类型:(manage:管理员审核,front:前台审核,staff:员工自己审核)
     *
     * @param applyType 审核类型:(manage:管理员审核,front:前台审核,staff:员工自己审核)
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * 获取法人身份证
     *
     * @return corporationID - 法人身份证
     */
    public String getCorporationID() {
        return corporationID;
    }

    /**
     * 设置法人身份证
     *
     * @param corporationID 法人身份证
     */
    public void setCorporationID(String corporationID) {
        this.corporationID = corporationID == null ? null : corporationID.trim();
    }

    /**
     * 获取营业执照号
     *
     * @return licenceNo - 营业执照号
     */
    public String getLicenceNo() {
        return licenceNo;
    }

    /**
     * 设置营业执照号
     *
     * @param licenceNo 营业执照号
     */
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo == null ? null : licenceNo.trim();
    }

    /**
     * 获取公司地址
     *
     * @return addr - 公司地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置公司地址
     *
     * @param addr 公司地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取大楼id
     *
     * @return orgId - 大楼id
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置大楼id
     *
     * @param orgId 大楼id
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}