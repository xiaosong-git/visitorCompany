package com.manage.service;

import com.manage.model.CompanyPost;

public interface ICompanyPostService {
	/**
	 * 通过岗位名称来查找岗位id
	 * @param postName
	 * @return
	 * @throws Exception
	 */
     public CompanyPost findByName(String postName) throws Exception;
}
