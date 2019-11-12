package com.manage.model;

public class TblUser {
    private Long id;

    private Long orgid;

    private String relationno;

    private String realname;

    private String sex;

    private String nicename;

    private String loginname;

    private String idtype;

    private String idno;

    private String phone;

    private String createdate;

    private String createtime;

    private String province;

    private String city;

    private String area;

    private String addr;

    private String isauth;

    private String authdate;

    private String authtime;

    private String idfrontimgurl;

    private String idoppositeimgurl;

    private String idhandleimgurl;

    private String bankcardimgurl;

    private String headimgurl;

    private String token;

    private String issettranspwd;

    private String qrcodeurl;

    private Long companyid;

    private String role;

    private String workkey;

    private String failreason;

    private String solecode;

    private String validitydate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getRelationno() {
        return relationno;
    }

    public void setRelationno(String relationno) {
        this.relationno = relationno == null ? null : relationno.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename == null ? null : nicename.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getIsauth() {
        return isauth;
    }

    public void setIsauth(String isauth) {
        this.isauth = isauth == null ? null : isauth.trim();
    }

    public String getAuthdate() {
        return authdate;
    }

    public void setAuthdate(String authdate) {
        this.authdate = authdate == null ? null : authdate.trim();
    }

    public String getAuthtime() {
        return authtime;
    }

    public void setAuthtime(String authtime) {
        this.authtime = authtime == null ? null : authtime.trim();
    }

    public String getIdfrontimgurl() {
        return idfrontimgurl;
    }

    public void setIdfrontimgurl(String idfrontimgurl) {
        this.idfrontimgurl = idfrontimgurl == null ? null : idfrontimgurl.trim();
    }

    public String getIdoppositeimgurl() {
        return idoppositeimgurl;
    }

    public void setIdoppositeimgurl(String idoppositeimgurl) {
        this.idoppositeimgurl = idoppositeimgurl == null ? null : idoppositeimgurl.trim();
    }

    public String getIdhandleimgurl() {
        return idhandleimgurl;
    }

    public void setIdhandleimgurl(String idhandleimgurl) {
        this.idhandleimgurl = idhandleimgurl == null ? null : idhandleimgurl.trim();
    }

    public String getBankcardimgurl() {
        return bankcardimgurl;
    }

    public void setBankcardimgurl(String bankcardimgurl) {
        this.bankcardimgurl = bankcardimgurl == null ? null : bankcardimgurl.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getIssettranspwd() {
        return issettranspwd;
    }

    public void setIssettranspwd(String issettranspwd) {
        this.issettranspwd = issettranspwd == null ? null : issettranspwd.trim();
    }

    public String getQrcodeurl() {
        return qrcodeurl;
    }

    public void setQrcodeurl(String qrcodeurl) {
        this.qrcodeurl = qrcodeurl == null ? null : qrcodeurl.trim();
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getWorkkey() {
        return workkey;
    }

    public void setWorkkey(String workkey) {
        this.workkey = workkey == null ? null : workkey.trim();
    }

    public String getFailreason() {
        return failreason;
    }

    public void setFailreason(String failreason) {
        this.failreason = failreason == null ? null : failreason.trim();
    }

    public String getSolecode() {
        return solecode;
    }

    public void setSolecode(String solecode) {
        this.solecode = solecode == null ? null : solecode.trim();
    }

    public String getValiditydate() {
        return validitydate;
    }

    public void setValiditydate(String validitydate) {
        this.validitydate = validitydate == null ? null : validitydate.trim();
    }
}