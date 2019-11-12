package com.manage.utils.advice;

import com.manage.controller.base.BaseController;
import com.manage.utils.VerifyUtil;
import com.manage.utils.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * 异常捕获类
 * Created by L on 2017/8/12.
 */
@ControllerAdvice
public class MyControllerAdvice extends BaseController {

    private final Logger log = LoggerFactory.getLogger(MyControllerAdvice.class);
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Happy Summer");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));
        String str = sw.toString();
        log.error("----------****************--------------出现异常----------------***************-------------");
        log.error("异常时间："+ VerifyUtil.getNowDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        log.error("errorMessage---" + ex.getMessage()+"--exString---"+ex.toString());
        log.error("堆栈信息："+str);
        log.error("--------------***************--------打印异常结束----------------************---------------");
        //return Result.unDataResult("499",ex.getMessage());
        return Result.unDataResult("fail","系统异常");
    }

}
