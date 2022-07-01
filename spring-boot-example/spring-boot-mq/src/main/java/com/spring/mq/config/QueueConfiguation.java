package com.spring.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguation {

    @Bean(name = "firstQueue")
    public Queue firstQueue(){
        return new Queue("first-Queue");
    }

}
