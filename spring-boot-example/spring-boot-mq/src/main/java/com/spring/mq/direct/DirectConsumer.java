package com.spring.mq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DirectConsumer {

    @RabbitListener(queues = "CustomDirectQueue")
    @RabbitHandler
    public void process(Map message) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[consumer-1]从队列 [CustomDirectQueue] 收到消息：" + message.toString());
    }

    @RabbitListener(queues = "CustomDirectQueue")
    @RabbitHandler
    public void process2(Map message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[consumer-2]从队列 [CustomDirectQueue] 收到消息：" + message.toString());
    }

}

