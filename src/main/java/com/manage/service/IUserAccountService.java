package com.manage.service;

import com.manage.model.UserAccount;

public interface IUserAccountService {

    /**
     * 插入用户账户信息
     * @param userAccount
     * @return
     * @throws Exception
     */
    public Integer addUserAccount(UserAccount userAccount) throws Exception;
}
