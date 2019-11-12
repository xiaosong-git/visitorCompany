package com.manage.service;

/**
 * Created LZ Administrator on 2017/8/18.
 */
public interface IParamsService {
    /**
     * 通过 参数名 获取 参数值
     * @param paramName 参数名
     * @return
     *
     */
    public String findByParamName(String paramName) throws Exception;
}
