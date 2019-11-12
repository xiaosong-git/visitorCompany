package com.manage.dao;

import com.manage.model.CompanySection;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CompanySectionMapping extends MyMapper<CompanySection> {

    List<CompanySection> findByPage(@Param("companyId") long companyId, @Param("sectionName") String sectionName);

    List<CompanySection> findByAll(@Param("companyId") long companyId);

    Integer add(@Param("companySection") CompanySection companySection);

    Integer update(@Param("companySection") CompanySection companySection);

    Integer del(@Param("ids") List<Long> ids);

    /**
     * 根据单个参数名查找
     * @param paramName
     * @param paramText
     * @return
     */
    CompanySection findByParam(@Param("paramName") String paramName, @Param("paramText") String paramText);

    CompanySection findById(@Param("id") Integer id) throws Exception;

	CompanySection findBySectionNameAndcompanyId(@Param("sectionName") String sectionName, @Param("companyId") Long companyId);
}