package com.spring.kisso.config;

import com.baomidou.kisso.web.handler.SSOHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerInterceptor implements SSOHandlerInterceptor {

    @Override
    public boolean preTokenIsNullAjax(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean preTokenIsNull(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
