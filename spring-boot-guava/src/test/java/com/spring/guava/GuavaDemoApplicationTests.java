package com.spring.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class GuavaDemoApplicationTests {

    @Test
    void contextLoads() {
        ImmutableList<String> imutableUserList = ImmutableList.<String>builder()
                .add("jiangxi")
                .add("nanchang")
                .build();
//        imutableUserList.add("x");
        System.out.printf(imutableUserList.toString());
    }

    @Test
    void RateLimiterLoads() {
        RateLimiter rateLimiter = RateLimiter.create(2);
//        double acquire = rateLimiter.acquire(1);
//        double acquire1 = rateLimiter.acquire(2);
//        double acquire2 = rateLimiter.acquire(3);
//        System.out.println("" + acquire);
//        System.out.println("" + acquire1);
//        System.out.println("" + acquire2);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // 获得令牌
                boolean b = rateLimiter.tryAcquire();
                if (b)
                    System.out.println(LocalDateTime.now());
            }).start();
        }
    }

}
