package com.manage.service.impl;

import com.manage.dao.OrgMapping;
import com.manage.model.Org;
import com.manage.service.IOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService implements IOrgService {

    @Autowired
    private OrgMapping orgMapping;

    @Override
    public Org findById(Long orgId) throws Exception {
        return orgMapping.selectByPrimaryKey(orgId);
    }
}
