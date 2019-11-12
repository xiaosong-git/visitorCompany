package com.manage.service.impl;

import com.manage.dao.DictMapping;
import com.manage.model.Dict;
import com.manage.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictService")
public class DictService implements IDictService {
    @Autowired
    private DictMapping dictMapping;

    /**
     * 作用：获取所有的大类字典参数信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Dict> findAllDict() throws Exception {
        return dictMapping.findAllDict();
    }
}
