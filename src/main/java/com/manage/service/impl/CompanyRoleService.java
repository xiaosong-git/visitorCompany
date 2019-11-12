package com.manage.service.impl;

import com.manage.dao.CompanyRoleMapping;
import com.manage.model.CompanyRole;
import com.manage.service.ICompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2017/8/8.
 */
@Service
public class CompanyRoleService implements ICompanyRoleService {

    @Autowired
    private CompanyRoleMapping companyRoleMapping;

    /**
     * 查询本级以及下级的角色 LZ
     * @param relation_no 登录的操作员的relation_no
     * @return
     * @throws Exception
     */
    @Override
    public List<CompanyRole> findLowerRole(String relation_no) throws Exception {
        if(relation_no != null){
            return companyRoleMapping.findLowerRole(relation_no+"%");
        }
        return null;
    }
    /**
     * 通过角色Id查询
     * @param roleId 角色Id
     * @return
     * @throws Exception
     */
    @Override
    public CompanyRole findById(Long roleId) throws Exception {
        if(roleId != null){
            return companyRoleMapping.findById(roleId);
        }
        return null;
    }

    /**
     * 作用：删除
     * @param id
     * @throws Exception
     */
    @Override
    public void batchDelete(String id) throws Exception {
        companyRoleMapping.batchDelete(id);
    }

    /**
     * 作用：添加信息
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(CompanyRole role) throws Exception {
        return companyRoleMapping.add(role);
    }

    /**
     * 作用：修改
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(CompanyRole role) throws Exception {
        return companyRoleMapping.update(role);
    }

    /**
     * 作用：查看是否有下级
     * @param role_relation_no
     * @return
     * @throws Exception
     */
    @Override
    public CompanyRole findByRoleRelationNo(String role_relation_no) throws Exception {
        List<CompanyRole> roles = companyRoleMapping.findByRoleRelationNo(role_relation_no);
        if(roles.size() > 0){
            return roles.get(0);
        }
        return null;
    }

    /**
     * 作用：查看是否有下级
     * @param role_relation_no
     * @return
     * @throws Exception
     */
    @Override
    public List<CompanyRole> findByAllRelationNo(String role_relation_no) throws Exception {
        return companyRoleMapping.findByAllRelationNo(role_relation_no);
    }
}
