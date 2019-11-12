package com.manage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_dict")
public class Dict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dict_code;

    private String dict_text;

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
     * @return dict_code
     */
    public String getDict_code() {
        return dict_code;
    }

    /**
     * @param dict_code
     */
    public void setDict_code(String dict_code) {
        this.dict_code = dict_code == null ? null : dict_code.trim();
    }

    /**
     * @return dict_text
     */
    public String getDict_text() {
        return dict_text;
    }

    /**
     * @param dict_text
     */
    public void setDict_text(String dict_text) {
        this.dict_text = dict_text == null ? null : dict_text.trim();
    }
}