package com.manage.service;

import com.manage.model.CompanyUser;

import java.util.List;

public interface ICompanyUserService {

    /**
     * 分页查询公司员工
     * @param companyId
     * @param companyName
     * @param sectionName
     * @param userName
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<CompanyUser> findByPage(Long companyId, String companyName, String sectionName, String userName, int pageNo, int pageSize)throws Exception;

    /**
     * 插入公司数据
     * @param companyUser
     * @return
     * @throws Exception
     */
    public Integer add(CompanyUser companyUser)throws Exception;

    /**
     * 修改公司数据
     * @param companyUser
     * @return
     * @throws Exception
     */
    public Integer update(CompanyUser companyUser)throws Exception;

    /**
     * 删除公司数据
     * @param ids
     * @return
     * @throws Exception
     */
    public Integer del(List<Long> ids)throws Exception;

    public  List<CompanyUser> findBySectionId(Long sectionId)throws Exception;

    public CompanyUser findById(Long id)throws Exception;

    public CompanyUser findByUserId(Long userId) throws Exception;
    
}
