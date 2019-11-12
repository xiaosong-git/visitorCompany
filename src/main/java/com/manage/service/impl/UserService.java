package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.UserMapping;
import com.manage.model.User;
import com.manage.service.IUserAccountService;
import com.manage.service.IUserService;
import com.manage.utils.RedisUtil;
import com.manage.utils.StringUtil;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by L on 2017/8/8.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapping userMapping;

    /**
     * 根据用户id查询详情
     * @param userId
     */
    @Override
    public User findById(Long userId) throws Exception {
        return userMapping.findById(userId);
    }

    /**
     * 根据phone查询是否存在
     * @param phone
     * @return
     */
    @Override
    public User findByPhone(String phone) throws Exception {
        return userMapping.findByPhone(phone);
    }

    @Override
    public Integer addUser(User user) throws Exception {
        return userMapping.addUser(user);
    }

    @Override
    public Integer updateRole(String role, Long id) throws Exception {
        return userMapping.updateRole(role, id);
    }

    @Override
    public Integer updateByUserId(String role, Long companyId, Long id) throws Exception {
        return userMapping.updateByUserId(role, companyId, id);
    }

	@Override
	public Integer updateSex(String sex, Long id) throws Exception {
		// TODO Auto-generated method stub
		return userMapping.updateSex(sex, id);
	}
}
