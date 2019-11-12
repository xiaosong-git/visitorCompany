package com.manage.service;

import com.manage.model.CompanySection;

import java.util.List;

public interface ICompanySectionService {

    /**
     * 分页查询公司部门
     * @param companyId
     * @param sectionName
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<CompanySection> findByPage(long companyId, String sectionName, int pageNo, int pageSize)throws Exception;

    /**
     * 插入公司数据
     * @param companySection
     * @return
     * @throws Exception
     */
    public Integer add(CompanySection companySection)throws Exception;

    /**
     * 修改公司数据
     * @param companySection
     * @return
     * @throws Exception
     */
    public Integer update(CompanySection companySection)throws Exception;

    /**
     * 删除公司数据
     * @param ids
     * @return
     * @throws Exception
     */
    public Integer del(List<Long> ids)throws Exception;

    /**
     * 根据单个参数名查找
     * @param paramName
     * @param paramText
     * @return
     */
    public CompanySection findByParam(String paramName, String paramText) throws Exception;

    /**
     * 分页查询公司部门
     * @param companyId
     * @return
     * @throws Exception
     */
    public List<CompanySection> findByAll(long companyId)throws Exception;
    /**
     * 根据部门名称和公司id来查询公司部门
     * @param paramName
     * @param companyId
     * @return
     * @throws Exception
     */
    public CompanySection findBySectionNameAndcompanyId(String sectionName, Long companyId) throws Exception;
}
