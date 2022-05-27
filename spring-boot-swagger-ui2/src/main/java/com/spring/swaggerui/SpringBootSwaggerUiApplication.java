package com.spring.swaggerui;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户信息管理")
@RestController
@RequestMapping("hello")
@SpringBootApplication
public class SpringBootSwaggerUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerUiApplication.class, args);
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public String userList() {
        return "xxx";
    }
}
