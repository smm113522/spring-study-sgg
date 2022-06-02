package com.spring.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.spring.mybatis.service.impl.DemoServcieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * mybatis 使用
 */
@RestController
public class DemoController {

    @Autowired
    DemoServcieImpl demoServcie;

    @GetMapping("/")
    public String index() {
        return JSON.toJSONString(demoServcie.selectById());
    }

    @GetMapping("/1")
    public String index1() {
        return JSON.toJSONString(demoServcie.selectMap());
    }

    @GetMapping("/2")
    public String index2() {
        return JSON.toJSONString(demoServcie.selectListMap());
    }

    @GetMapping("/3")
    public String index3() {
        return JSON.toJSONString(demoServcie.selectList());
    }



}
