package com.manage.utils;

import java.text.NumberFormat;
import java.util.Random;


public class NumberUtil {

    public static String getProgortion(Integer num1, Double num2){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((double)num1 /  num2 * 100);
        return result;
    }

    /**
     * 随机生成验证码
     * @Author linyb
     * @Date 2017/4/3 16:11
     */
    public static String getRandomCode(Integer length){
        char[] num = {'1','2','3','4','5','6','7','8','9'};
        String code = "";
        for (int i = 1 ;i <= length ;i++){
            code += num[new Random().nextInt(num.length)];
        }
        return code;
    }

    /**
     * 随机生成验证码
     * @Author linyb
     * @Date 2017/4/3 16:11
     */
    public static String getRandomWorkKey(Integer length){
        char[] num = {'1','2','3','4','5','6','7','8','9',
                      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','x','y','z','s','w',
                      'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','X','Y','Z','S','W'
        };
        String code = "";
        int len = num.length;
        for (int i = 1 ;i <= length ;i++){
            code += num[new Random().nextInt(len)];
        }
        return code;
    }

    public static  void main(String[] args){
        System.out.println(getRandomWorkKey(10));
    }



}
