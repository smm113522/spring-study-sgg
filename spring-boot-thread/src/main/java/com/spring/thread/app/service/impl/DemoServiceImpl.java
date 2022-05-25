package com.spring.thread.app.service.impl;

import com.spring.thread.app.service.DemoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    @Async("taskExecutor")
    public String threadActive() {
        return null;
    }
}
