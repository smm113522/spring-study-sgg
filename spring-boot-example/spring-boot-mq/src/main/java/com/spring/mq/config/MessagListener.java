package com.spring.mq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessagListener {

    @RabbitListener(queues = "firstQueue")
    public void firstConsumer(String txt){
        System.out.println(txt);
    }

}
