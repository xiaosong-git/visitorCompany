package com.manage.dao;

import com.manage.model.CompanyMenu;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMenuMapping extends MyMapper<CompanyMenu> {

    List<CompanyMenu> selectAll();
}