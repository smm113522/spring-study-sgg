package com.spring.getway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    /**
     * 配置正常了hello
     * 错误了就是123
     */
    @Value("${project.text:123}")
    private String hello;

    /**
     * 测试
     * @return
     */
    @GetMapping("/")
    public String index() {
        return hello;
    }

}
