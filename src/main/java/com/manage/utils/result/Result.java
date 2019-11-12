package com.manage.utils.result;


import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 * @Date  2016/7/25 16:41
 * @author linyb
 */
public class Result {

    private String desc ="操作成功";   //返回提示信息
    private String sign = "success"; //成功或者失败  fail
    private Map<String,Object> verify;  //数据


    public Result(Integer result, String desc) {
        this.desc = desc;

    }
    public Result(String sign, String desc) {
        this.sign = sign;
        this.desc = desc;

    }

    public Result(){}

    public Map getVerify() {
        return verify;
    }

    public void setVerify(Map verify) {
        this.verify = verify;
    }


    /**
     * 没有返回数据
     * @Date  2016/7/25 17:18
     * @author linyb
     */
    public static Result unDataResult(String sign, String desc){
        Result result = new Result();
        Map map = new HashMap();
        map.put("sign",sign);
        map.put("desc",desc);
        result.verify = map;
        return result;
    }

    /**
     * 操作成功
     * @Date  2016/7/25 17:18
     * @author linyb
     */
    public static Result success(){
        return unDataResult("success","操作成功");
    }
    /**
     * 操作成功
     * @Date  2016/7/25 17:18
     * @author linyb
     */
    public static Result fail(){
        return unDataResult("fail","操作失败");
    }

}