package com.manage.dao;


import java.util.List;

import com.github.pagehelper.Page;
import com.manage.model.yaoRecord;
import com.manage.model.yaoRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface yaoRecordMapper {

    int countByExample(yaoRecordExample example);

    int deleteByExample(yaoRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(yaoRecord record);

    int insertSelective(yaoRecord record);

    List<yaoRecord> selectByExample(yaoRecordExample example);

    yaoRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") yaoRecord record, @Param("example") yaoRecordExample example);

    int updateByExample(@Param("record") yaoRecord record, @Param("example") yaoRecordExample example);

    int updateByPrimaryKeySelective(yaoRecord record);

    int updateByPrimaryKey(yaoRecord record);

    Page<yaoRecord> findByPage();

}