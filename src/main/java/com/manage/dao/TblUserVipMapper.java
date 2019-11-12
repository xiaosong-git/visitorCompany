package com.manage.dao;

import com.manage.model.TblUserVip;
import com.manage.model.TblUserVipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TblUserVipMapper {
    int countByExample(TblUserVipExample example);

    int deleteByExample(TblUserVipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblUserVip record);

    int insertSelective(TblUserVip record);

    List<TblUserVip> selectByExample(TblUserVipExample example);

    TblUserVip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblUserVip record, @Param("example") TblUserVipExample example);

    int updateByExample(@Param("record") TblUserVip record, @Param("example") TblUserVipExample example);

    int updateByPrimaryKeySelective(TblUserVip record);

    int updateByPrimaryKey(TblUserVip record);

    List<TblUserVip> findByPage(@Param("realName") String realName);

    Integer deleteVipUser(@Param("ids") List<Integer> ids);
}