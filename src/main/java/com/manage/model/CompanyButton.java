package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_company_button")
public class CompanyButton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String btnName;

    private String btnCode;

    private String actionUrl;

    private Long menuId;

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
     * @return btnName
     */
    public String getBtnName() {
        return btnName;
    }

    /**
     * @param btnName
     */
    public void setBtnName(String btnName) {
        this.btnName = btnName == null ? null : btnName.trim();
    }

    /**
     * @return btnCode
     */
    public String getBtnCode() {
        return btnCode;
    }

    /**
     * @param btnCode
     */
    public void setBtnCode(String btnCode) {
        this.btnCode = btnCode == null ? null : btnCode.trim();
    }

    /**
     * @return actionUrl
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * @param actionUrl
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }

    /**
     * @return menuId
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}