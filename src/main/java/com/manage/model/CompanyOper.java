package com.manage.model;

import javax.persistence.*;

@Table(name = "t_company_oper")
public class CompanyOper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oper_name;

    private Long company_id;

    private Long role_id;

    private String pwd;

    /**
     * 0:正常；1:禁止
     */
    private String sstatus;

    private String login_name;

    //非数据库字段
    @Transient
    private String token;
    @Transient
    private String statusName;
    @Transient
    private String roleName;
    @Transient
    private String imageServerUrl;
    @Transient
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
     * @return oper_name
     */
    public String getOper_name() {
        return oper_name;
    }

    /**
     * @param oper_name
     */
    public void setOper_name(String oper_name) {
        this.oper_name = oper_name == null ? null : oper_name.trim();
    }

    /**
     * @return company_id
     */
    public Long getCompany_id() {
        return company_id;
    }

    /**
     * @param company_id
     */
    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    /**
     * @return role_id
     */
    public Long getRole_id() {
        return role_id;
    }

    /**
     * @param role_id
     */
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 获取0:正常；1:禁止
     *
     * @return sstatus - 0:正常；1:禁止
     */
    public String getSstatus() {
        return sstatus;
    }

    /**
     * 设置0:正常；1:禁止
     *
     * @param sstatus 0:正常；1:禁止
     */
    public void setSstatus(String sstatus) {
        this.sstatus = sstatus == null ? null : sstatus.trim();
    }

    /**
     * @return login_name
     */
    public String getLogin_name() {
        return login_name;
    }

    /**
     * @param login_name
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
    }
}