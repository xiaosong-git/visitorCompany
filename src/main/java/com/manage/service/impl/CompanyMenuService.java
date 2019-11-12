package com.manage.service.impl;

import com.manage.dao.CompanyMenuMapping;
import com.manage.model.CompanyMenu;
import com.manage.service.ICompanyMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2017/8/9.
 */
@Service
public class CompanyMenuService implements ICompanyMenuService {

    @Autowired
    private CompanyMenuMapping companyMenuMapping;

    @Override
    public List<CompanyMenu> findAll() throws Exception{
        return companyMenuMapping.selectAll();
    }

    @Override
    public int insert(CompanyMenu record) {
        return companyMenuMapping.insert(record);
    }
}
