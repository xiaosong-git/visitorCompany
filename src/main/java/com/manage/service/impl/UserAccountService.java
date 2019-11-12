package com.manage.service.impl;

import com.manage.dao.UserAccountMapping;
import com.manage.model.UserAccount;
import com.manage.service.IUserAccountService;
import com.manage.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements IUserAccountService {

    @Autowired
    private UserAccountMapping userAccountMapping;

    @Override
    public Integer addUserAccount(UserAccount userAccount) throws Exception {
        return userAccountMapping.addUserAccount(userAccount);
    }
}
