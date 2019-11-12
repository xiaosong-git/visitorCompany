package com.manage.service.impl;

import com.manage.dao.CompanyAuthRangeMapping;
import com.manage.model.CompanyAuthRange;
import com.manage.service.ICompanyAuthRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2017/8/9.
 */
@Service
public class CompanyAuthRangeService implements ICompanyAuthRangeService {

    @Autowired
    private CompanyAuthRangeMapping companyAuthRangeMapping;

    /*
     * 作用：获取该角色的所有菜单
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<CompanyAuthRange> findAllByRoleId(String roleId) throws Exception {
        return companyAuthRangeMapping.findAllByRoleId(roleId);
    }

    /**
     * 作用：获取该角色的所有按钮
     * @param roleId
     * @param menuId
     * @return
     * @throws Exception
     */
    @Override
    public List<CompanyAuthRange> findAllButton(String roleId, String menuId) throws Exception {
        return companyAuthRangeMapping.findAllButton(roleId,menuId);
    }

    /**
     * 作用：获取该角色
     * @param menu_id
     * @param button_id
     * @param role_id
     * @return
     * @throws Exception
     */
    @Override
    public CompanyAuthRange findByAuthAgentRange(Long menu_id, Long button_id, Long role_id) throws Exception {
        List<CompanyAuthRange> list = companyAuthRangeMapping.findByAuthAgentRange(menu_id, button_id, role_id);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 作用：删除该角色的权限
     * @param role_id
     * @return
     * @throws Exception
     */
    @Override
    public void deleteByRoleId(Long role_id) throws Exception {
        companyAuthRangeMapping.deleteByRoleId(role_id);
    }

    /**
     * 作用：批量添加
     * @param authAgentRanges
     * @return
     * @throws Exception
     */
    @Override
    public Integer batchInsert(List<CompanyAuthRange> authAgentRanges) throws Exception{
        return companyAuthRangeMapping.batchInsert(authAgentRanges);
    }

}
