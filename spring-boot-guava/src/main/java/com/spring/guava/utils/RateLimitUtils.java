package com.spring.guava.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流算法集合
 */
@Slf4j
public class RateLimitUtils {

    //初始时间
    private static long startTime = System.currentTimeMillis();
    //初始计数值
    private static final AtomicInteger ZERO = new AtomicInteger(0);
    //时间窗口限制
    private static final long interval = 1000;
    //限制通过请求
    private static int limit = 100;
    //请求计数
    private AtomicInteger requestCount = ZERO;

    /**
     * 固定时间窗口算法
     * <p>
     *     可以使用在分布式环境下，使用单点存储计数值，比如redis、并且设置自动过期时间，这时候就可以统计整个集群的流量，并且进行限流。
     *     缺点是不能处理临界问题，或者说限流策略不够平滑；
     *     可能在限流临界点来了双倍的流量，c超过系统的限制；
     *     计数器限流允许出现 2permitsPerSecond 的突发流量，可以使用*滑动窗口算法去优化。
     * </p>
     * @return
     */
    public boolean tryAcquire() {
        long now = System.currentTimeMillis();
        //在时间窗口内
        if (now < startTime + interval) {
            //判断是否超过最大请求
            if (requestCount.get() < limit) {
                requestCount.incrementAndGet();
                return true;
            }
            log.info("当前时间窗口内已经超过最大请求数");
            return false;
        } else {
            //新一轮时间窗口开启，超时重置
            startTime = now;
            requestCount = ZERO;
            return true;
        }
    }

}