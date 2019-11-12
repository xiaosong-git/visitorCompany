package com.manage.model;

public class companyUserInfo {
    private Long id;

    private String companycode;

    private String companyname;

    private String createdate;

    private String createtime;

    private String phone;

    private String name;

    private String applytype;

    private String corporationid;

    private String licenceno;

    private String addr;

    private Long orgid;

    private String companyfloor;

    private String companyfloor2;

    private String isyaoyue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode == null ? null : companycode.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype == null ? null : applytype.trim();
    }

    public String getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(String corporationid) {
        this.corporationid = corporationid == null ? null : corporationid.trim();
    }

    public String getLicenceno() {
        return licenceno;
    }

    public void setLicenceno(String licenceno) {
        this.licenceno = licenceno == null ? null : licenceno.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getCompanyfloor() {
        return companyfloor;
    }

    public void setCompanyfloor(String companyfloor) {
        this.companyfloor = companyfloor == null ? null : companyfloor.trim();
    }

    public String getCompanyfloor2() {
        return companyfloor2;
    }

    public void setCompanyfloor2(String companyfloor2) {
        this.companyfloor2 = companyfloor2 == null ? null : companyfloor2.trim();
    }

    public String getIsyaoyue() {
        return isyaoyue;
    }

    public void setIsyaoyue(String isyaoyue) {
        this.isyaoyue = isyaoyue == null ? null : isyaoyue.trim();
    }
}