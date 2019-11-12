package com.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.CompanyPostMapping;
import com.manage.model.CompanyPost;
import com.manage.service.ICompanyPostService;

@Service
public class CompanyPostService implements ICompanyPostService{
	@Autowired
	private CompanyPostMapping companyPostMapping;
	@Override
	public CompanyPost findByName(String postName) throws Exception {
		// TODO Auto-generated method stub
		return companyPostMapping.findByName(postName);
	}

}
