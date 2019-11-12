package com.manage.service.impl;

import com.manage.dao.CompanyMapping;
import com.manage.model.Company;
import com.manage.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyMapping companyMapping;

    @Override
    public Company findById(Integer id) throws Exception {
        return companyMapping.findById(id);
    }

    @Override
    public Integer updateApplyType(Long id, String applyType) throws Exception {
        return companyMapping.updateApplyType(id, applyType);
    }
}
