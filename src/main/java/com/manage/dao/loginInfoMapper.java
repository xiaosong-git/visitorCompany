package com.manage.dao;

import com.manage.model.loginInfo;
import com.manage.model.loginInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface loginInfoMapper {
    int countByExample(loginInfoExample example);

    int deleteByExample(loginInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(loginInfo record);

    int insertSelective(loginInfo record);

    List<loginInfo> selectByExample(loginInfoExample example);

    loginInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") loginInfo record, @Param("example") loginInfoExample example);

    int updateByExample(@Param("record") loginInfo record, @Param("example") loginInfoExample example);

    int updateByPrimaryKeySelective(loginInfo record);

    int updateByPrimaryKey(loginInfo record);
}