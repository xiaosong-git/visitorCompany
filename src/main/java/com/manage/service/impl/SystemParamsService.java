package com.manage.service.impl;

import com.manage.dao.SystemParamMapping;
import com.manage.model.SystemParam;
import com.manage.service.ISystemParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZ on 2017/8/18.
 */
@Service()
public class SystemParamsService implements ISystemParamsService {
    @Autowired
    private SystemParamMapping systemParamMapping;

    /**
     * 根据变量名取参数值
     * @param paramName
     * @return
     */
    public SystemParam findByParamName(String paramName)throws Exception{
        return systemParamMapping.systemParam(paramName);
    }
}
