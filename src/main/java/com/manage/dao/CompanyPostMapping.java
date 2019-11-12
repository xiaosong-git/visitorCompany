package com.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.manage.model.CompanyPost;
import com.manage.utils.mapper.MyMapper;

@Mapper
public interface CompanyPostMapping extends MyMapper<CompanyPost> {
       CompanyPost findByName(@Param("postName") String postName);
}
