package com.spring.webflux.service;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.hutool.core.map.MapUtil;
import com.spring.webflux.bean.MingYueUser;
import com.spring.webflux.client.RootWebClient;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Strive
 */
@Service
public class MingYueUserService {

    /**
     * 模拟用户存储
     */
    private static final Map<Long, MingYueUser> USER_MAP = MapUtil.newHashMap();

    static {
        USER_MAP.put(1L, MingYueUser.builder().userId(1L).username("mingyue").build());
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    public MingYueUser queryUserById(Long userId) {
        return USER_MAP.get(userId);
    }

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    RootWebClient rootWebClient = new RootWebClient();

    @SneakyThrows
    public String selectResult() {
        // WebFlux异步调用，同步会报错
        Future future = executorService.submit(() -> rootWebClient.res());
        String res = (String) future.get();
//        executorService.shutdown();
//        String res = new RootWebClient().res();
        return res;
    }
}
