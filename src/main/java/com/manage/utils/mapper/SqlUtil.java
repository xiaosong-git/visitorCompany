package com.manage.utils.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2017/8/13.
 */
public class SqlUtil {

    /**
     * ID拼接
     * @param ids
     * @return
     */
    public static List<String> getIdsList(String ids){
        List<String> idList = new ArrayList<String>();

        String[] str=ids.split(",");
        for (int i=0;i<str.length;i++){
            idList.add(str[i]);
            //System.out.println(str[i]);
        }
        return idList;
    }

    /**
     * 不是自己的ID拼接
     * @param ids
     * @return
     */
    public static List<String> getNoIdsList(String id ,String ids){
        List<String> idList = new ArrayList<String>();

        String[] str=ids.split(",");
        for (int i=0;i<str.length;i++){
            if (!str[i].equals(id)){
                idList.add(str[i]);
            }
        }
        return idList;
    }

}
