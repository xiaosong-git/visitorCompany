package com.manage.dao;

import com.manage.model.CompanyUser;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyUserMapping extends MyMapper<CompanyUser> {

    List<CompanyUser> findByPage(@Param("companyId") Long companyId, @Param("companyName") String companyName, @Param("sectionName") String sectionName, @Param("userName") String userName);

    Integer add(@Param("companyUser") CompanyUser companyUser);

    Integer update(@Param("companyUser") CompanyUser companyUser);

    Integer del(@Param("ids") List<Long> ids);

    Integer updateCreaDate(@Param("ids") List<Long> ids);

    Integer updateCreateTime(@Param("ids") List<Long> ids);

    List<CompanyUser> findBySectionId(@Param("sectionId") Long sectionId);

    CompanyUser findById(@Param("id") Long id);

    List<CompanyUser> findByUserId(@Param("userId") Long userId);
}