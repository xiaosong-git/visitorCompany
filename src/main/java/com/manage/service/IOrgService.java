package com.manage.service;

import com.manage.model.Org;

import java.util.List;

public interface IOrgService {

    public Org findById(Long orgId) throws Exception;
}
