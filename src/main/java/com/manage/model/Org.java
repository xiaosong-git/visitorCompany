package com.manage.model;

import com.manage.model.base.Base;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

@Table(name = "t_org")
@NameStyle(value = Style.normal)
public class Org extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String org_code;

    private String org_name;

    private Long sid;

    private String istop;

    private String org_icon;

    private String relation_no;

    private String sstatus;
    //@Column(name = "orgType")
    private String orgType;
    //@Column(name = "realName")
    private String realName;

    private String phone;

    private String addr;
    //@Column(name = "createDate")
    private String createDate;
    //@Column(name = "province")
    private String province;
    //@Column(name = "city")
    private String city;
    //@Column(name = "area")
    private String area;

    @Transient
    private String orgTypeName;
    @Transient
    private String s_name;
    @Transient
    private String superiorOrgName;

    public String getSuperiorOrgName() {
        return superiorOrgName;
    }

    public void setSuperiorOrgName(String superiorOrgName) {
        this.superiorOrgName = superiorOrgName;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
     * @return org_code
     */
    public String getOrg_code() {
        return org_code;
    }

    /**
     * @param org_code
     */
    public void setOrg_code(String org_code) {
        this.org_code = org_code == null ? null : org_code.trim();
    }

    /**
     * @return org_name
     */
    public String getOrg_name() {
        return org_name;
    }

    /**
     * @param org_name
     */
    public void setOrg_name(String org_name) {
        this.org_name = org_name == null ? null : org_name.trim();
    }

    /**
     * @return sid
     */
    public Long getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(Long sid) {
        this.sid = sid;
    }

    /**
     * @return istop
     */
    public String getIstop() {
        return istop;
    }

    /**
     * @param istop
     */
    public void setIstop(String istop) {
        this.istop = istop == null ? null : istop.trim();
    }

    /**
     * @return org_icon
     */
    public String getOrg_icon() {
        return org_icon;
    }

    /**
     * @param org_icon
     */
    public void setOrg_icon(String org_icon) {
        this.org_icon = org_icon == null ? null : org_icon.trim();
    }

    /**
     * @return relation_no
     */
    public String getRelation_no() {
        return relation_no;
    }

    /**
     * @param relation_no
     */
    public void setRelation_no(String relation_no) {
        this.relation_no = relation_no == null ? null : relation_no.trim();
    }

    /**
     * @return sstatus
     */
    public String getSstatus() {
        return sstatus;
    }

    /**
     * @param sstatus
     */
    public void setSstatus(String sstatus) {
        this.sstatus = sstatus == null ? null : sstatus.trim();
    }

    /**
     * @return orgType
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * @param orgType
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * @return realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * @return createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", org_code='" + org_code + '\'' +
                ", org_name='" + org_name + '\'' +
                ", sid=" + sid +
                ", istop='" + istop + '\'' +
                ", org_icon='" + org_icon + '\'' +
                ", relation_no='" + relation_no + '\'' +
                ", sstatus='" + sstatus + '\'' +
                ", orgType='" + orgType + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                ", createDate='" + createDate + '\'' +
                ", province=" + province +
                ", city=" + city +
                ", area=" + area +
                '}';
    }
}