package com.spring.mybatis.service;

import com.spring.mybatis.bean.User;

import java.util.List;
import java.util.Map;

public interface DemoServcie {
    List<User> selectById();
    Map<String, String> selectMap();
    List<Map<String, String>> selectListMap();
    List selectList();
}
