package com.manage.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/11.
 */
public class ResponseUtil {

    public static void sendFailJson(HttpServletResponse response, String message)
            throws Exception
    {
        Map result = new HashMap();
        result.put("code", "fail");
        result.put("message", message);
        String json = JSONObject.toJSONString(result);
        responseJson(response, json);
    }

    public static Map<String, Object> makeSuccessJson() throws Exception {
        Map result = new HashMap();
        result.put("code", "success");
        result.put("message", "操作成功");
        return result;
    }

    public static void responseJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter out = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
