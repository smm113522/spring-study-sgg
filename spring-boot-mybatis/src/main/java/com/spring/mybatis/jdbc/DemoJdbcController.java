package com.spring.mybatis.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * https://www.jianshu.com/p/9fe587ae94e9
 * jdbc 使用
 */
@RestController
@RequestMapping("/jdbc")
public class DemoJdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/4")
    public List index4() {
        return jdbcTemplate.queryForList("select * from user");
    }
}
