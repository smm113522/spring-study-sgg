package com.spring.guava.entbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

public class DemoTest {


    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 1000;

    public static void main(String[] args) {
        // 异步非阻塞模式
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
        // 注册观察者,即事件处理类
        eventBus.register(new DevmEventListener());

//        eventBus.post("s");
        eventBus.post(123);

    }

}
