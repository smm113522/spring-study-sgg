package com.spring.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /*第一个消息队列*/
    @Test
    void contextLoads() {
        amqpTemplate.convertAndSend("firstQueue", "", "123456");
    }

}
