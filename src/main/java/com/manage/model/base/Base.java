package com.manage.model.base;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by L on 2017/8/4.
 */
public class Base implements Serializable {

//    @Id
//    @Column(name = "Id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer pageSize = 10;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
