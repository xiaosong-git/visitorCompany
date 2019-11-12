package com.manage.dao;

import com.manage.model.DictItem;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictItemMapping extends MyMapper<DictItem> {

    /**
     * 根据大类dict_code查找小类
     * @param dict_code
     * @return
     */
    public List<DictItem> findDictItemByDictCode(@Param("dict_code") String dict_code);

    /**
     * 根据id修改item_text
     * @param id
     * @param item_text
     * @return
     */
    public int editDictItem(@Param("id") String id, @Param("item_text") String item_text);

    /**
     * 添加小类字典参数
     * @param dictItem
     * @return
     */
    public int addDictItem(@Param("dictItem") DictItem dictItem);

    /**
     * 根据id删除字典信息
     * @param ids
     * @return
     */
    public int deleteDictItem(@Param("ids") List<Long> ids);
}