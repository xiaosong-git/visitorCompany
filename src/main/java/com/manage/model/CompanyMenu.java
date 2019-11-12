package com.manage.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "t_company_menu")
public class CompanyMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menu_code;

    private String menu_name;

    private String menu_url;

    private Long sid;

    private String istop;

    private String menu_icon;

    private String sstatus;

    private String relation_no;

    private String remarks;

    private String isshortcut;

    private String iconImgUrl;

    //非数据库映射字段
    @Transient
    private List<CompanyButton> buttons;

    public List<CompanyButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<CompanyButton> buttons) {
        this.buttons = buttons;
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
     * @return menu_code
     */
    public String getMenu_code() {
        return menu_code;
    }

    /**
     * @param menu_code
     */
    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code == null ? null : menu_code.trim();
    }

    /**
     * @return menu_name
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * @param menu_name
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    /**
     * @return menu_url
     */
    public String getMenu_url() {
        return menu_url;
    }

    /**
     * @param menu_url
     */
    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url == null ? null : menu_url.trim();
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
     * @return menu_icon
     */
    public String getMenu_icon() {
        return menu_icon;
    }

    /**
     * @param menu_icon
     */
    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon == null ? null : menu_icon.trim();
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
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * @return isshortcut
     */
    public String getIsshortcut() {
        return isshortcut;
    }

    /**
     * @param isshortcut
     */
    public void setIsshortcut(String isshortcut) {
        this.isshortcut = isshortcut == null ? null : isshortcut.trim();
    }

    /**
     * @return iconImgUrl
     */
    public String getIconImgUrl() {
        return iconImgUrl;
    }

    /**
     * @param iconImgUrl
     */
    public void setIconImgUrl(String iconImgUrl) {
        this.iconImgUrl = iconImgUrl == null ? null : iconImgUrl.trim();
    }
}