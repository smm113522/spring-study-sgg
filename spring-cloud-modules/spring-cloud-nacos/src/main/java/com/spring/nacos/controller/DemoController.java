package com.spring.nacos.controller;

import com.spring.nacos.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DemoController {

    /**
     * 配置正常了hello
     * 错误了就是123
     */
    @Value("${a.text:123}")
    private String hello;

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public String index() {
        return demoService.demoText() + "---" + hello;
    }

}
