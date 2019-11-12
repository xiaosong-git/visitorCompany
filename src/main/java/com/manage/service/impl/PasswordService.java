package com.manage.service.impl;

import com.manage.service.IParamsService;
import com.manage.service.IPasswordService;
import com.manage.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service("passwordService")
public class PasswordService implements IPasswordService {
    @Autowired
    private IParamsService paramsService;
    /**
     * 限制用户在一定时间内密码输入错误的次数
     * @param userId 用户Id
     * @return
     */
    public boolean isErrInputOutOfLimit(String userId) throws Exception{
        String maxErrorInputSyspwdLimit = paramsService.findByParamName("maxErrorInputSyspwdLimit");
        Integer limit = Integer.parseInt(maxErrorInputSyspwdLimit);
        String num = RedisUtil.getStrVal("ErrInputOutOfLimit_companyOper_"+userId, 9);
        if(num == null){
            return false;
        }
        if(Long.valueOf(num) >= limit){
            return true;
        }
        return false;
    }

    @Override
    public Long addErrInputNum(String userId) throws Exception{
        /**
         * 获取限制参数
         */
        Integer time = Integer.valueOf(paramsService.findByParamName("errorInputSyspwdWaitTime"));
        Integer limit = Integer.valueOf(paramsService.findByParamName("maxErrorInputSyspwdLimit"));

        Long num  = RedisUtil.incr("ErrInputOutOfLimit_companyOper_"+userId, 9, time*60);
        return limit - num;
    }

    @Override
    public void resetPwdInputNum(String userId) throws Exception {
        /**
         * 获取限制参数
         */
        Integer time = Integer.valueOf(paramsService.findByParamName("errorInputSyspwdWaitTime"));
        RedisUtil.setStr("ErrInputOutOfLimit_companyOper_"+userId, "0", 9, time*60);
    }
}
