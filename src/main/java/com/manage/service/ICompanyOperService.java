package com.manage.service;

import com.github.pagehelper.Page;
import com.manage.model.CompanyOper;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface ICompanyOperService {

    /**
     * 通过登录名查询操作员
     * @param loginName
     * @return
     * @throws Exception
     */
    CompanyOper findByLoginName(String loginName) throws Exception;

    /**
     * 修改密码
     * @param companyOper
     * @return
     */
    Integer updateByPwd(CompanyOper companyOper);

    /**
     * 添加数据
     * @param companyOper
     * @return
     * @throws Exception
     */
    Integer addCompanyOper(CompanyOper companyOper) throws Exception;

    /**
     * 修改操作员信息
     * @param companyOper
     * @return
     * @throws Exception
     */
    Integer updateById(CompanyOper companyOper) throws Exception;

    void batchDelete(List<String> ids);

    Page<CompanyOper> findByPage(String oper_name, Long company_id, int pageNo, int pageSize);
}
