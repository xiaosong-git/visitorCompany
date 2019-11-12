package com.manage.dao;

import com.manage.model.Company;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyMapping extends MyMapper<Company> {

    Company findById(@Param("id") Integer id) throws Exception;

    Integer updateApplyType(@Param("id") Long id, @Param("applyType") String applyType);
}