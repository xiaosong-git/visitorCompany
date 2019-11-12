package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.CompanySectionMapping;
import com.manage.dao.CompanyUserMapping;
import com.manage.model.CompanySection;
import com.manage.model.CompanyUser;
import com.manage.service.ICompanySectionService;
import com.manage.service.ICompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyUserService implements ICompanyUserService {

    @Autowired
    private CompanyUserMapping companyUserMapping;

    @Override
    public List<CompanyUser> findByPage(Long companyId, String companyName, String sectionName, String userName, int pageNo, int pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return companyUserMapping.findByPage(companyId, companyName, sectionName, userName);
    }

    @Override
    public Integer add(CompanyUser companyUser) throws Exception {
        return companyUserMapping.add(companyUser);
    }

    @Override
    public Integer update(CompanyUser companyUser) throws Exception {
        return companyUserMapping.update(companyUser);
    }

    @Override
    public Integer del(List<Long> ids) throws Exception {
        Integer i = companyUserMapping.del(ids);
        Integer b = companyUserMapping.updateCreaDate(ids);
        Integer c =companyUserMapping.updateCreateTime(ids);
        return i+b+c;
    }

    @Override
    public  List<CompanyUser> findBySectionId(Long sectionId) throws Exception {
        return companyUserMapping.findBySectionId(sectionId);
    }

    @Override
    public CompanyUser findById(Long id) throws Exception {
        return companyUserMapping.findById(id);
    }

    @Override
    public CompanyUser findByUserId(Long userId) throws Exception {
        List<CompanyUser> companyUser = companyUserMapping.findByUserId(userId);
        if (companyUser == null){
            return null;
        }else{
            return companyUser.get(0);
        }
    }
}
