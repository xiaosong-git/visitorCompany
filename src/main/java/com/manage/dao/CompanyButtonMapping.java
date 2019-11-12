package com.manage.dao;

import com.manage.model.CompanyButton;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyButtonMapping extends MyMapper<CompanyButton> {

    CompanyButton findById(Long id);

    List<CompanyButton> findByMenuId(Long menuId);
}