package com.manage.service.impl;

import com.manage.dao.CompanyButtonMapping;
import com.manage.model.CompanyButton;
import com.manage.service.ICompanyButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2017/8/3.
 */
@Service
public class CompanyButtonService implements ICompanyButtonService {

    @Autowired
    private CompanyButtonMapping companyButtonMapping;

    public CompanyButton findById(Long id) throws Exception{
        return companyButtonMapping.findById(id);
    }

    @Override
    public List<CompanyButton> findByMenuId(Long menuId) throws Exception {
        return companyButtonMapping.findByMenuId(menuId);
    }

    @Override
    public int insert(CompanyButton record) {
        return companyButtonMapping.insert(record);
    }
}
