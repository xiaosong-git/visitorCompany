package com.manage.utils.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.manage.model.CompanyOper;
import com.manage.utils.result.Result;
import com.xdream.kernel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/4.
 */
@Configurable
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 用来存储不拦截的路径
     *
     */
    private static final String[] IGNORE_URI = {"/kaptcha","/login/","/companyAuth/getAuth","/yaoyue/getReason"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        try {
            //System.out.println("开始preHandle,判断请求是否需要拦截");
            boolean flag = false;
            String servletPath = request.getServletPath();
            System.out.println("请求路径是: "+servletPath);
            // 检测是否为需要拦截的请求
            for (String s : IGNORE_URI) {
                if (servletPath.contains(s)) {
                    //System.out.println("该请求不需要拦截");
                    flag = true;
                }
            }
            // 需要拦截处理的请求
            if (!flag) {
                // 获取存储在session域的用户
                CompanyOper oper = (CompanyOper) request.getSession().getAttribute("companyOper");
                if (oper == null) {
                    // 服务器内部转发，可以带回request
                    //request.getRequestDispatcher("/login").forward(request, response);
                    ResponseUtil.responseJson(response, JSONObject.toJSONString(Result.unDataResult("fail","请先登录！")));
                    flag = false;
                }
                else {
                    //System.out.println("拦截请求:用户已经登录，可以成功浏览网页");
                    flag = true;
                }
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //System.out.println("拦截请求之后");
        //System.out.println(handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //System.out.println("控制器处理完成之后");

    }

}
