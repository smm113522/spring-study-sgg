package com.spring.druid.service.impl;

import com.spring.druid.mapper.UserMapper;
import com.spring.druid.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, String>> select() {
        return userMapper.select();
    }
}
