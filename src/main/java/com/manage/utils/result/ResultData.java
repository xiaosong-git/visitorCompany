package com.manage.utils.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author linyb
 * @Date 2017/4/10 19:49
 */
public class ResultData extends Result {

    private Object data;  //数据

    private Object extraData;

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回数据
     * @Date  2016/7/25 17:18
     * @author linyb
     */
    public static ResultData dataResult(String sign, String desc, Object data){
        ResultData result = new ResultData();
        Map map = new HashMap();
        map.put("sign",sign);
        map.put("desc",desc);
        result.setVerify(map);
        result.data = data;
        //System.out.println(data+"里里面的");
        return result;
    }

    /**
     * 返回数据
     * @Date  2016/7/25 17:18
     * @author linyb
     */
    public static ResultData extraDataResult(String sign, String desc, Object data , Object extraData){
        ResultData result = new ResultData();
        Map map = new HashMap();
        map.put("sign",sign);
        map.put("desc",desc);
        result.setVerify(map);
        result.data = data;
        result.extraData = extraData;
        //System.out.println(data+"里里面的");
        return result;
    }
}
