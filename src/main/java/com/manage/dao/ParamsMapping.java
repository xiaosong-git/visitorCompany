package com.manage.dao;

import com.manage.model.Params;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParamsMapping extends MyMapper<Params> {
    /**
     * 通过 参数名 获取 参数值
     * @param paramName 参数名
     * @return
     *
     */
    public String findByParamName(String paramName);
}