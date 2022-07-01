package com.spring.guava.entbus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevmEventListener {
    private static Logger logger = LoggerFactory.getLogger(DevmEventListener.class);

    @Subscribe
    public void handleDevmCpuInfos(String cpuInfos) {
        logger.info("CPU信息处理={}", cpuInfos);
    }

    @Subscribe
    public void handleDevmMemoryInfos(Integer memoryInfos) {
        logger.info("内存信息处理={}", memoryInfos);
    }
}