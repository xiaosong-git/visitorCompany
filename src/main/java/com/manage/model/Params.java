package com.manage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_params")
public class Params {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 参数名 唯一
     */
    private String paramName;

    /**
     * 参数值
     */
    private String paramText;

    /**
     * 说明
     */
    private String remark;

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
     * 获取参数名 唯一
     *
     * @return paramName - 参数名 唯一
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置参数名 唯一
     *
     * @param paramName 参数名 唯一
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * 获取参数值
     *
     * @return paramText - 参数值
     */
    public String getParamText() {
        return paramText;
    }

    /**
     * 设置参数值
     *
     * @param paramText 参数值
     */
    public void setParamText(String paramText) {
        this.paramText = paramText == null ? null : paramText.trim();
    }

    /**
     * 获取说明
     *
     * @return remark - 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置说明
     *
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}