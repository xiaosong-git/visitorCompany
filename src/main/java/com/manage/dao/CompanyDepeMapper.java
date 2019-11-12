package com.manage.dao;


import java.util.List;

import com.manage.model.CompanyDepe;
import com.manage.model.CompanyDepeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CompanyDepeMapper {
    int countByExample(CompanyDepeExample example);

    int deleteByExample(CompanyDepeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CompanyDepe record);

    int insertSelective(CompanyDepe record);

    List<CompanyDepe> selectByExample(CompanyDepeExample example);

    CompanyDepe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompanyDepe record, @Param("example") CompanyDepeExample example);

    int updateByExample(@Param("record") CompanyDepe record, @Param("example") CompanyDepeExample example);

    int updateByPrimaryKeySelective(CompanyDepe record);

    int updateByPrimaryKey(CompanyDepe record);
}