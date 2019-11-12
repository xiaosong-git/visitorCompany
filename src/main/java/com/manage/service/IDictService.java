package com.manage.service;

import com.manage.model.Dict;

import java.util.List;

public interface IDictService {
    /**
     * 作用：获取所有的大类字典参数信息
     * @return
     * @throws Exception
     */
    public List<Dict> findAllDict() throws Exception;
}
