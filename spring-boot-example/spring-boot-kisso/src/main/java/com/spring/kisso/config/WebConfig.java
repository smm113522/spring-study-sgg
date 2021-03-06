package com.spring.kisso.config;

import com.baomidou.kisso.web.interceptor.SSOSpringInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * <p>
 * WEB 初始化相关配置
 * </p>
 *
 * @author 青苗
 * @since 2017-08-08
 */
@ControllerAdvice
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // kisso 拦截器配置
        SSOSpringInterceptor ssoInterceptor = new SSOSpringInterceptor();
        ssoInterceptor.setHandlerInterceptor(new LoginHandlerInterceptor());
        registry.addInterceptor(ssoInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html");
    }
}
