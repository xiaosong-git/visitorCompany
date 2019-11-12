package com.manage.dao;

import com.manage.model.SystemParam;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemParamMapping extends MyMapper<SystemParam> {
    /**
     * 作用：获取所有的系统参数信息
     * @return
     * @throws Exception
     */
    public List<SystemParam> findAllSystemParam() throws Exception;

    /**
     * 作用：修改系统参数信息
     * @return
     * @throws Exception
     */
    public int updateSystemParam(@Param("systemParam") SystemParam systemParam) throws Exception;

    /**
     * 根据变量名取参数值
     * @param paramName
     * @return
     */
    public SystemParam systemParam(@Param("paramName") String paramName) throws Exception;
}