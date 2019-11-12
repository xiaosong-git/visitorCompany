package com.manage.service;

import com.manage.model.CompanyAuth;
import com.manage.model.CompanyRole;

import java.util.List;

/**
 * 权限接口
 * Created by L on 2017/8/9.
 */
public interface ICompanyAuthService {

    public CompanyRole findCompanyRole(Long roleId) throws Exception;

    public int insert(CompanyAuth record);

    public CompanyAuth selectBybtnIdAndRoleIdAndMenuId(Long buttonId, Long roleId, Long menuId);

    public int batchInsert(List<CompanyAuth> auths);

    public void batchDelete(String ids);

    public void deleteByRoleid(Long roleId);
}
