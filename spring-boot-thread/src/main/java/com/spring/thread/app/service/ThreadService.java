package com.spring.thread.app.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    /**
     * 会执行，但是不会 返回数据
     *
     * @return
     */
    @Async("taskExecutor")
    public String threadActive() {
        try {
            Thread.sleep(10000);
            System.out.println("执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "xxx";
    }

}
