package com.manage.service.impl;

import com.manage.dao.DictItemMapping;
import com.manage.model.DictItem;
import com.manage.service.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictItemService")
public class DictItemService implements IDictItemService {
    @Autowired
    private DictItemMapping dictItemMapping;

    /**
     * 根据大类dict_code查找小类
     * @param dict_code
     * @return
     */
    @Override
    public List<DictItem> findDictItemByDictCode(String dict_code) {
        return dictItemMapping.findDictItemByDictCode(dict_code);
    }

    /**
     * 根据id修改item_text
     * @param id
     * @param item_text
     * @return
     */
    @Override
    public int editDictItem(String id, String item_text) {
        return dictItemMapping.editDictItem(id,item_text);
    }

    /**
     * 添加小类字典参数
     * @param dictItem
     * @return
     */
    @Override
    public int addDictItem(DictItem dictItem) {
        return dictItemMapping.addDictItem(dictItem);
    }

    /**
     * 根据id删除字典信息
     * @param ids
     * @return
     */
    @Override
    public int deleteDictItem(List<Long> ids) {
        return dictItemMapping.deleteDictItem(ids);
    }
}
