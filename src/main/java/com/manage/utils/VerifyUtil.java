package com.manage.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by L on 2017/8/13.
 */
public class VerifyUtil {

    /**
      * 判断是否为整数
      * @param str 传入的字符串
      * @return 是整数返回true,否则返回false
    */
    public static boolean isInteger(String str) {
        if (str!=null && !str.equals("")){
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            return pattern.matcher(str).matches();
        }
        return false;
    }

    /**
     * 去除空格
     * @param str
     * @return 返回去除后的字符串
     */
    public static String wipeBlank(String str) {
        if(str!=null && !"".equals(str.trim())){
            str=str.trim();
        }
        return str;
    }

    /**
     * 获取格式化日期
     * @param date
     * @param format
     * @return
     */
    public static String getNowDate(Date date, String format){
        SimpleDateFormat df = new SimpleDateFormat(format);//设置日期格式
       return df.format(date);// new Date()为获取当前系统时间
    }

    /**
     * 判断对象中的属性是否为空
     * @param obj
     * @return
     * @throws Exception
     */
    public static Boolean checkObjFieldIsNull(Object obj) throws Exception{
        Boolean flag = false;
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(obj) == null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                //......
                //这里可以给空字段初始化，及其他操作
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 将电话号码中间部分替换为****
     * @param phone 电话号码
     * @return
     */
    public static String subPhone(String phone){
        if(phone == null){
            return null;
        }
        Integer len = phone.length();
        if(len < 11){
            return phone;
        }
        String result = phone.substring(0, 3) + "****" + phone.substring(len-4,len);
        return result;
    }

}
