package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.CompanySectionMapping;
import com.manage.model.CompanySection;
import com.manage.service.ICompanySectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanySectionService implements ICompanySectionService {

    @Autowired
    private CompanySectionMapping companySectionMapping;

    @Override
    public List<CompanySection> findByPage(long companyId, String sectionName, int pageNo, int pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return companySectionMapping.findByPage(companyId, sectionName);
    }

    @Override
    public Integer add(CompanySection companySection) throws Exception {
        return companySectionMapping.add(companySection);
    }

    @Override
    public Integer update(CompanySection companySection) throws Exception {
        return companySectionMapping.update(companySection);
    }

    @Override
    public Integer del(List<Long> ids) throws Exception {
        return companySectionMapping.del(ids);
    }

    @Override
    public CompanySection findByParam(String paramName, String paramText) throws Exception {
        return companySectionMapping.findByParam(paramName,paramText);
    }

    @Override
    public List<CompanySection> findByAll(long companyId) throws Exception {
        return companySectionMapping.findByAll(companyId);
    }

	@Override
	public CompanySection findBySectionNameAndcompanyId(String sectionName, Long companyId) throws Exception {
		// TODO Auto-generated method stub
		return companySectionMapping.findBySectionNameAndcompanyId(sectionName,companyId);
	}
}
