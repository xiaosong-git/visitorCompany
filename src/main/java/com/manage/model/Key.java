package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_key")
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 密钥的key
     */
    @Column(name = "workKey")
    private String workKey;

    /**
     * 状态，normal正常，disable:禁用
     */
    private String cstatus;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private String createDate;

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
     * 获取密钥的key
     *
     * @return workKey - 密钥的key
     */
    public String getWorkKey() {
        return workKey;
    }

    /**
     * 设置密钥的key
     *
     * @param workKey 密钥的key
     */
    public void setWorkKey(String workKey) {
        this.workKey = workKey == null ? null : workKey.trim();
    }

    /**
     * 获取状态，normal正常，disable:禁用
     *
     * @return cstatus - 状态，normal正常，disable:禁用
     */
    public String getCstatus() {
        return cstatus;
    }

    /**
     * 设置状态，normal正常，disable:禁用
     *
     * @param cstatus 状态，normal正常，disable:禁用
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus == null ? null : cstatus.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }
}