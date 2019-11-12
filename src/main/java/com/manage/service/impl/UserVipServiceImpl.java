package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.TblUserMapper;
import com.manage.dao.TblUserVipMapper;
import com.manage.model.TblUser;
import com.manage.service.UserVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVipServiceImpl implements UserVipService {

    @Autowired
    private TblUserMapper userMapper;

    public List<TblUser> findByPage(String realName, int pageNo, int pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findByPage("%"+realName+"%");
    }

    public Integer deleteNews(List<Integer> ids) throws Exception {
        return userMapper.deleteVipUser(ids);
    }
}
