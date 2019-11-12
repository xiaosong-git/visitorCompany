package com.manage.dao;

import com.github.pagehelper.Page;
import com.manage.model.CompanyOper;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyOperMapping extends MyMapper<CompanyOper> {

    CompanyOper findByLoginName(@Param("login_name") String login_name);

    Integer updateByPwd(@Param("companyOper") CompanyOper companyOper);

    Integer addCompanyOper(@Param("companyOper") CompanyOper companyOper);

    Integer updateById(@Param("companyOper") CompanyOper companyOper);

    void batchDelete(@Param("ids") List<String> ids);

    Page<CompanyOper> findByPage(@Param("oper_name") String oper_name, @Param("company_id") Long company_id);
}