package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_company_post")
public class CompanyPost {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     /**
      * 自增id
      */
     private Long id;
     /**
      * 岗位代码
      */
     private String postCode;
     /**
      * 岗位名称
      */
     private String postName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}
}
