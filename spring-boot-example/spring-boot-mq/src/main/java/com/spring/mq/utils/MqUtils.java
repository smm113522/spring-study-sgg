package com.spring.mq.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqUtils {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSend(String var1, String var2, Object map){
        rabbitTemplate.convertAndSend(var1, var2, map);
    }
}
