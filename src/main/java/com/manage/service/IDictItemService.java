package com.manage.service;

import com.manage.model.DictItem;

import java.util.List;

public interface IDictItemService {
    /**
     * 根据大类dict_code查找小类
     * @param dict_code
     * @return
     */
    public List<DictItem> findDictItemByDictCode(String dict_code);

    /**
     * 根据id修改item_text
     * @param id
     * @param item_text
     * @return
     */
    public int editDictItem(String id, String item_text);

    /**
     * 添加小类字典参数
     * @param dictItem
     * @return
     */
    public int addDictItem(DictItem dictItem);

    /**
     * 根据id删除字典信息
     * @param ids
     * @return
     */
    public int deleteDictItem(List<Long> ids);
}
