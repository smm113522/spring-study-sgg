package com.spring.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicConsumer {

    @RabbitListener(queues = "TopicFirstQueue")
    public void process(Map message) {
        System.out.println("[consumer-11]从队列[TopicFirstQueue]中收到消息:" + message.toString());
    }

    @RabbitListener(queues = "TopicSecondQueue")
    public void process1(Map message) {
        System.out.println("[consumer-22]从队列[TopicSecondQueue]中收到消息:" + message.toString());
    }

}
