package com.manage.service;

/**
 * 错误输入密码的Service
 * Created by LZ on 2017/7/26.
 */
public interface IPasswordService{
    /**
     * 限制用户在一定时间内密码输入错误的次数
     * @param userId 用户Id
     * @return
     */
    boolean isErrInputOutOfLimit(String userId) throws Exception;

    /**
     * 累加错误输入密码次数
     * @param userId 用户Id
     * @return
     */
    Long addErrInputNum(String userId) throws Exception;

    /**
     * 重置允许用户输入错误密码的次数
     * @param userId 用户Id
     */
    void resetPwdInputNum(String userId) throws Exception;
}
