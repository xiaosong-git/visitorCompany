package com.manage.service.impl;

import com.manage.dao.CompanyAuthMapping;
import com.manage.model.CompanyAuth;
import com.manage.model.CompanyRole;
import com.manage.service.ICompanyAuthService;
import com.manage.utils.mapper.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限管理
 * Created by L on 2017/8/9.
 */
@Service
public class CompanyAuthService implements ICompanyAuthService {


    @Autowired
    private CompanyAuthMapping companyAuthMapping;

    /**
     * 获取角色对象 其中包含菜单集合
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public CompanyRole findCompanyRole(Long roleId) throws Exception {
        return companyAuthMapping.findMenu(roleId);
    }

    @Override
    public int insert(CompanyAuth record) {
        return companyAuthMapping.insert(record);
    }

    /**
     * 查询是否有这个权限
     * @param buttonId
     * @param roleId
     * @param menuId
     * @return
     */
    @Override
    public CompanyAuth selectBybtnIdAndRoleIdAndMenuId(Long buttonId, Long roleId, Long menuId) {
        return companyAuthMapping.selectBybtnIdAndRoleIdAndMenuId(buttonId,roleId,menuId);
    }

    @Override
    public int batchInsert(List<CompanyAuth> auths) {
        return companyAuthMapping.batchInsert(auths);
    }

    @Override
    public void batchDelete(String ids) {
        companyAuthMapping.batchDelete(SqlUtil.getIdsList(ids));
    }

    @Override
    public void deleteByRoleid(Long roleId) {
        companyAuthMapping.deleteByRoleid(roleId);
    }
}
