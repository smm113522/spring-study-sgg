package com.spring.mq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutConsumer {

    /**
     * 接受消息
     *
     * @param message
     */
    @RabbitListener(queues = "CustomFanoutQueue")
    @RabbitHandler
    private void process(Map message) {
        System.out.println("[fanout-consumer-1]从队列 [CustomFanoutQueue] 收到消息：" + message.toString());
    }

}
