package com.spring.sa.token.config;


import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.util.SaResult;
import com.spring.sa.token.exception.DefaultExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SaRouteInterceptor saAnnotationInterceptor = new SaRouteInterceptor((req, res, handler) -> {

        });
        registry.addInterceptor(saAnnotationInterceptor)
                .addPathPatterns("/**");
    }

}


