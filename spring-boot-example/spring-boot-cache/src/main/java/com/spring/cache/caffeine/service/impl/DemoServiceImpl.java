package com.spring.cache.caffeine.service.impl;

import com.spring.cache.cache.CacheConstants;
import com.spring.cache.caffeine.service.DemoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Caching(
            cacheable = @Cacheable("CacheConstants.GET_USER"),
            evict = {
                    @CacheEvict("CacheConstants.GET_DYNAMIC")
            })
    @Override
    public String findUser() {

        return null;
    }

    @Cacheable(value = CacheConstants.GET_USER, key = "'user' + #userId", sync = true)
    @CacheEvict
    public String getUserByUserId(Integer userId) {
        System.out.println("查询了数据库");
        return "sddf";
    }

}
