package com.manage.service;

import com.manage.model.CompanyMenu;

import java.util.List;

/**
 * Created by L on 2017/8/3.
 */
public interface ICompanyMenuService {

    public int insert(CompanyMenu record);

    public List<CompanyMenu> findAll() throws Exception;
}
