package com.manage.dao;

import com.manage.model.Org;
import com.manage.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrgMapping extends MyMapper<Org> {

    List<Org> findByPageLeft(@Param("org") Org org);

    /**
     * 统计其下机构数
     * @param relationNo
     * @return
     */
    Long countOrgByOrg(@Param("relationNo") String relationNo, @Param("createDate") String createDate);

    /**
     * 机构详情
     * @param orgId
     * @return
     */
    Org findByIdUnion(Long orgId);

    /**
     * 根据单个参数名查找
     * @param paramName
     * @param paramText
     * @return
     */
    Org findByParam(@Param("paramName") String paramName, @Param("paramText") String paramText);

    Integer insertSelectiveGetKey(Org org);

    /**
     * 查询当前代理商下所有的代理商
     * @param id
     * @return
     */
    List<Org> findSubordinateOrg(Long id);

    /**
     * 查询当前代理商的所有下级代理商
     * @param sid
     * @return
     */
    List<Org> findOrgSid(@Param("sid") String sid);

    /**
     * 查询操作员下的所有机构
     * @param operId 操作员Id
     * @return
     */
    List<Org> findByOperId(@Param("operId") Long operId, @Param("orgName") String orgName);

    /**
     * 通过relation_no查询操作员
     * @param relation_no
     * @return
     */
    Org findByRelationNo(@Param("relation_no") String relation_no);

    void batchDelete(@Param("ids") List<String> ids);

    Org findByPhone(@Param("phone") String phone);

    Integer updateStatus(@Param("org") Org org);

    List<Org> getAllOrg(@Param("relation_no") String relation_no);
}