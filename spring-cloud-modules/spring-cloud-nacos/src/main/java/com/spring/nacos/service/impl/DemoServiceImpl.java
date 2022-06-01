package com.spring.nacos.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.nacos.demain.User;
import com.spring.nacos.mapper.UserMapper;
import com.spring.nacos.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserMapper mapper;

    @Override
    public String demoText() {
        List<User> users = mapper.selectList(new QueryWrapper<>());
        return JSON.toJSONString("12" + users);
    }
}
