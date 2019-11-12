package com.manage.service;

import com.manage.model.Company;

import java.util.List;

public interface ICompanyService {

    /**
     * 根据id查询公司
     * @param id
     * @return
     * @throws Exception
     */
    public Company findById(Integer id) throws Exception;

    public Integer updateApplyType(Long id, String applyType) throws Exception;
}
