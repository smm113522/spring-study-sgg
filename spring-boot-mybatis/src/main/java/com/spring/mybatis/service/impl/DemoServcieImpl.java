package com.spring.mybatis.service.impl;

import com.spring.mybatis.bean.User;
import com.spring.mybatis.dao.UserMapper;
import com.spring.mybatis.service.DemoServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DemoServcieImpl implements DemoServcie {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectById() {
        List<User> list = userMapper.select();
        return list;
    }

    public Map<String, String> selectMap() {
        Map<String, String> map = userMapper.selectMap();
        return map;
    }

    public List<Map<String, String>> selectListMap() {
        List<Map<String, String>> map = userMapper.selectListMap();
        return map;
    }

    public List selectList() {
        return userMapper.selectList();
    }
}
