package com.manage.service;


import com.manage.model.TblUser;

import java.util.List;

public interface UserVipService {
    public List<TblUser> findByPage(String realName, int pageNo, int pageSize) throws Exception;

    public Integer deleteNews(List<Integer> ids) throws Exception;
}
