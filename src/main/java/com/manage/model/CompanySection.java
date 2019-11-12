package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_company_section")
public class CompanySection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门编码
     */
    private String sectionCode;

    /**
     * 部门名称
     */
    private String sectionName;

    /**
     * 公司Id
     */
    private Long companyId;

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
     * 获取部门编码
     *
     * @return sectionCode - 部门编码
     */
    public String getSectionCode() {
        return sectionCode;
    }

    /**
     * 设置部门编码
     *
     * @param sectionCode 部门编码
     */
    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode == null ? null : sectionCode.trim();
    }

    /**
     * 获取部门名称
     *
     * @return sectionName - 部门名称
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * 设置部门名称
     *
     * @param sectionName 部门名称
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    /**
     * 获取公司Id
     *
     * @return companyId - 公司Id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司Id
     *
     * @param companyId 公司Id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}