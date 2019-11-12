package com.manage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_dict_item")
public class DictItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dict_code;

    private String item_code;

    private String item_text;

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
     * @return item_code
     */
    public String getItem_code() {
        return item_code;
    }

    /**
     * @param item_code
     */
    public void setItem_code(String item_code) {
        this.item_code = item_code == null ? null : item_code.trim();
    }

    /**
     * @return item_text
     */
    public String getItem_text() {
        return item_text;
    }

    /**
     * @param item_text
     */
    public void setItem_text(String item_text) {
        this.item_text = item_text == null ? null : item_text.trim();
    }
}