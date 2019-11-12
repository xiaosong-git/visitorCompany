package com.manage.dao;

import com.manage.model.CompanyAuth;
import com.manage.model.CompanyRole;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyAuthMapping extends MyMapper<CompanyAuth> {

    /**
     * 查找角色菜单 单向关联
     * @param roleId
     * @return
     */
    CompanyRole findMenu(Long roleId);

    CompanyAuth selectBybtnIdAndRoleIdAndMenuId(@Param("buttonId") Long buttonId, @Param("roleId") Long roleId, @Param("menuId") Long menuId);

    int batchInsert(List<CompanyAuth> authss);

    void batchDelete(@Param("ids") List<String> ids);

    void deleteByRoleid(Long roleId);
}