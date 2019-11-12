package com.manage.service;

import com.manage.model.User;
import com.manage.utils.result.Result;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface IUserService {

    /**
     * 根据用户id查询详情
     * @param userId
     * @return
     */
    public User findById(Long userId)throws Exception;

    /**
     * 根据phone查询是否存在
     * @param phone
     * @return
     */
    public User findByPhone(String phone)throws Exception;

    public Integer addUser(User user)throws Exception;

    public Integer updateRole(String role, Long id)throws Exception;

    public Integer updateByUserId(String role, Long companyId, Long id)throws Exception;
    
    public Integer updateSex(String sex, Long id)throws Exception;
}
