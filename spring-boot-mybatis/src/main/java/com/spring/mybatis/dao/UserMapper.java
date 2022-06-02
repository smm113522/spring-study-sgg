package com.spring.mybatis.dao;

import com.spring.mybatis.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> select();

    Map<String, String> selectMap();

    List<Map<String, String>> selectListMap();

    int delectUser(Integer id);

    List selectList();
}
