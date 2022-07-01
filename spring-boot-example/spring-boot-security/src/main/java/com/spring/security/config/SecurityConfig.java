package com.spring.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //权限设置
        //permitall 设置所有人都可以访问主页
        //hasrole  设置什么样的人 可以访问什么样的界面
        http
                .authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        http.csrf().disable();
        //没有权限 默认跳到登录页面
        http.formLogin().loginPage("/tologin");
        //注销 并跳到首页
        http.logout().logoutSuccessUrl("/");
        //记住我功能
        http.rememberMe().rememberMeParameter("remember");

    }
}
