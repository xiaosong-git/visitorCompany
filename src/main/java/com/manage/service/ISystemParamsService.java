package com.manage.service;

import com.manage.model.SystemParam;

import java.util.List;

/**
 * Created LZ Administrator on 2017/8/18.
 */
public interface ISystemParamsService {

    /**20180609
     * 根据变量名取参数值
     * @param paramName
     * @return
     */
    public SystemParam findByParamName(String paramName) throws Exception;
}
