package com.manage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manage.dao.yaoRecordMapper;
import com.manage.model.yaoRecord;
import com.manage.service.YaoyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YaoyueServiceImpl implements YaoyueService {

    @Autowired
    private yaoRecordMapper yaoRecordMapper;

    @Override
    public Page<yaoRecord> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return yaoRecordMapper.findByPage();
    }
}
