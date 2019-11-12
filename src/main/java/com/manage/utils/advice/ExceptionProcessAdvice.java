package com.manage.utils.advice;

import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
@RestController
public class ExceptionProcessAdvice {
    // 对这个异常的统一处理，返回值 和Controller的返回规则一样
    @ExceptionHandler(MultipartException.class)
    public Result handleAll(Throwable t){
        return ResultData.unDataResult("fail", "图片文件过大");
    }
}
