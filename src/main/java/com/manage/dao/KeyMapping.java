package com.manage.dao;

import com.manage.model.Key;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeyMapping extends MyMapper<Key> {

    Key findByStatus(String status);
}