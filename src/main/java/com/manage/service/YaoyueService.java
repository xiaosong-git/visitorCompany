package com.manage.service;

import com.github.pagehelper.Page;
import com.manage.model.yaoRecord;

public interface YaoyueService {

    public Page<yaoRecord> findByPage(int pageNo, int pageSize);
}
