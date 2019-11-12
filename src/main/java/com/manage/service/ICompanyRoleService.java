package com.manage.service;

import com.manage.model.CompanyRole;

import java.util.List;

/**
 * Created by L on 2017/8/8.
 */
public interface ICompanyRoleService {

    /**
     * 查询本级以及下级的角色 LZ
     * @param relation_no 登录的操作员的relation_no
     * @return
     * @throws Exception
     */
    public List<CompanyRole> findLowerRole(String relation_no) throws Exception;

    /**
     * 通过角色Id查询
     * @param roleId 角色Id
     * @return
     * @throws Exception
     */
    public CompanyRole findById(Long roleId) throws Exception;

    /**
     * 作用：删除
     * @param id
     * @throws Exception
     */
    public void batchDelete(String id) throws Exception;

    /**
     * 作用：添加信息
     * @param role
     * @return
     * @throws Exception
     */
    public Integer add(CompanyRole role) throws Exception;

    /**
     * 作用：修改
     * @param role
     * @return
     * @throws Exception
     */
    public Integer update(CompanyRole role) throws Exception;

    /**
     * 作用：查看是否有下级
     * @param role_relation_no
     * @return
     * @throws Exception
     */
    public CompanyRole findByRoleRelationNo(String role_relation_no) throws Exception;

    /**
     * 作用：查看是否有下级
     * @param role_relation_no
     * @return
     * @throws Exception
     */
    public List<CompanyRole> findByAllRelationNo(String role_relation_no) throws Exception;
}
