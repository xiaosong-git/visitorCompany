package com.manage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manage.dao.CompanyOperMapping;
import com.manage.model.CompanyOper;
import com.manage.service.ICompanyOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyOperService implements ICompanyOperService {

    @Autowired
    private CompanyOperMapping companyOperMapping;

    @Override
    public CompanyOper findByLoginName(String loginName) throws Exception {
        return companyOperMapping.findByLoginName(loginName);
    }

    @Override
    public Integer updateByPwd(CompanyOper companyOper) {
        return companyOperMapping.updateByPwd(companyOper);
    }

    @Override
    public Integer addCompanyOper(CompanyOper companyOper) throws Exception {
        return companyOperMapping.addCompanyOper(companyOper);
    }

    @Override
    public Integer updateById(CompanyOper companyOper) throws Exception {
        return companyOperMapping.updateById(companyOper);
    }

    @Override
    public void batchDelete(List<String> ids) {
        companyOperMapping.batchDelete(ids);
    }

    @Override
    public Page<CompanyOper> findByPage(String oper_name, Long company_id, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return companyOperMapping.findByPage(oper_name, company_id);
    }
}
