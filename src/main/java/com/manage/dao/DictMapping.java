package com.manage.dao;

import com.manage.model.Dict;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictMapping extends MyMapper<Dict> {
    /**
     * 作用：获取所有的大类字典参数信息
     * @return
     * @throws Exception
     */
    public List<Dict> findAllDict() throws Exception;
}