package com.manage.dao;

import com.manage.model.User;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapping extends MyMapper<User> {

    User findById(@Param("id") Long userId);

    User findByPhone(@Param("phone") String phone);

    Integer addUser(@Param("user") User user);

    Integer updateRole(@Param("role") String role, @Param("id") Long id);

    Integer updateByUserId(@Param("role") String role, @Param("companyId") Long companyId, @Param("id") Long id);
    
    Integer updateSex(@Param("sex") String sex, @Param("id") Long id);
}