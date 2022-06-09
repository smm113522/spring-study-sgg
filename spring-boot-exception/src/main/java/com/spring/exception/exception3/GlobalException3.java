package com.spring.exception.exception3;

import com.spring.exception.exception1.ErrorRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义HandlerExceptionResolver对象处理异常
 * 必须要实现HandlerExceptionResolver
 */
@Configuration
public class GlobalException3 implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图的跳转
        if (e instanceof NullPointerException) {
            mv.setViewName("error5");
        }
        if (e instanceof ArithmeticException) {
            mv.setViewName("error6");
        }
        if (e instanceof ErrorRequestException) {
            mv.setViewName("error7");
        }
        mv.addObject("error", e.toString());
        return mv;
    }

}
