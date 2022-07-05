package com.spring.sa.token.exception;


import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author ZhangJi
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e, HttpServletRequest request) {
        return SaResult.error(e.getMessage());
    }

}

