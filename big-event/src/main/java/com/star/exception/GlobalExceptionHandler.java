package com.star.exception;

import com.star.common.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Classname: GlobalExceptionHandler
 * @Date: 2024/11/26 19:31
 * @Author: 聂建强
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        // 使用三元表达式，如果堆栈里面有信息就返回堆栈的信息提示，否则返回"操作失败"
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage(): "操作失败");
    }
}
