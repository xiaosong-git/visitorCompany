package com.manage.dao;

import com.manage.model.UserAccount;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAccountMapping extends MyMapper<UserAccount> {

    Integer addUserAccount(@Param("userAccount") UserAccount userAccount);
}