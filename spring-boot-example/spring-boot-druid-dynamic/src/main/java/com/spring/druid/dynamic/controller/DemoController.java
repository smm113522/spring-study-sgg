package com.spring.druid.dynamic.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.spring.druid.dynamic.aspectj.lang.annotation.DataSource;
import com.spring.druid.dynamic.aspectj.lang.enums.DataSourceType;
import com.spring.druid.dynamic.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    DemoMapper service;

    @GetMapping("/index")
    public String index() {
        List<Map<String, String>> list = service.select();
        return "sss" + JSONUtils.toJSONString(list);
    }

    @RequestMapping("/sayHelloByMaster")
    @ResponseBody
    @DataSource(value = DataSourceType.MASTER)
    public String sayHelloByMaster() {
        return "Master say Hello World for you!";
    }

    @RequestMapping("/sayHelloBySlave")
    @ResponseBody
    @DataSource(value = DataSourceType.SLAVE)
    public String sayHelloBySlave() {
        return "Slave say Hello World for you!";
    }

    @GetMapping("/index1")
    @DataSource(value = DataSourceType.MASTER)
    public String index1() {
        List<Map<String, String>> list = service.select();
        return "sss" + JSONUtils.toJSONString(list);
    }

    @GetMapping("/index2")
    @DataSource(value = DataSourceType.SLAVE)
    public String index2() {
        List<Map<String, String>> list = service.select();
        return "sss" + JSONUtils.toJSONString(list);
    }
}
