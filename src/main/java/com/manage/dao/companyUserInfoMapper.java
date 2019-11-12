package com.manage.dao;

import com.manage.model.companyUserInfo;
import com.manage.model.companyUserInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface companyUserInfoMapper {
    int countByExample(companyUserInfoExample example);

    int deleteByExample(companyUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(companyUserInfo record);

    int insertSelective(companyUserInfo record);

    List<companyUserInfo> selectByExample(companyUserInfoExample example);

    companyUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") companyUserInfo record, @Param("example") companyUserInfoExample example);

    int updateByExample(@Param("record") companyUserInfo record, @Param("example") companyUserInfoExample example);

    int updateByPrimaryKeySelective(companyUserInfo record);

    int updateByPrimaryKey(companyUserInfo record);
}