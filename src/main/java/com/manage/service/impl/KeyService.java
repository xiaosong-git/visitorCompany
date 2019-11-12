package com.manage.service.impl;

import com.manage.dao.KeyMapping;
import com.manage.model.Key;
import com.manage.service.IKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by L on 2017/8/15.
 */
@Service
public class KeyService implements IKeyService {

    @Autowired
    private KeyMapping keyMapping;

    @Override
    public String findByStatusString(String status) throws Exception {
        Key key = keyMapping.findByStatus(status);
        if(key!=null){
            return key.getWorkKey();
        }
        return null;
    }

}
