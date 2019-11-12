package com.manage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_system_param")
public class SystemParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String param_name;

    private String param_text;

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
     * @return param_name
     */
    public String getParam_name() {
        return param_name;
    }

    /**
     * @param param_name
     */
    public void setParam_name(String param_name) {
        this.param_name = param_name == null ? null : param_name.trim();
    }

    /**
     * @return param_text
     */
    public String getParam_text() {
        return param_text;
    }

    /**
     * @param param_text
     */
    public void setParam_text(String param_text) {
        this.param_text = param_text == null ? null : param_text.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}