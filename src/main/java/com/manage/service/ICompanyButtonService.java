package com.manage.service;

import com.manage.model.CompanyButton;

import java.util.List;

/**
 * 按钮
 * Created by L on 2017/8/3.
 */
public interface ICompanyButtonService {

    public CompanyButton findById(Long id) throws Exception;

    public List<CompanyButton> findByMenuId(Long MenuId) throws Exception;

    public int insert(CompanyButton record);
}
