package com.spring.mq.header;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeaderConsumer {

    //    @RabbitListener(queues = "header.queue.1")
    @RabbitListener(queues = HeaderConfig.HEADER_QUEUE_1)
    public void receive1(String msg) {
        System.out.println("接收到 header.queue.1 发送的消息：" + msg);
    }

    @RabbitListener(queues = HeaderConfig.HEADER_QUEUE_2)
    public void receive2(String msg) {
        System.out.println("接收到 header.queue.2 发送的消息：" + msg);
    }
}
