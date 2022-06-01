package com.spring.druid.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.spring.druid.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @GetMapping("/index")
    public String index() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(dataSource.getClass());
        //关闭连接
        connection.close();
        return "index";
    }

    @Autowired
    DemoService demoService;

    @GetMapping("/index1")
    public String index1() {
        List<Map<String, String>> select = demoService.select();
        String s = JSONUtils.toJSONString(select);
        return s;
    }

}
