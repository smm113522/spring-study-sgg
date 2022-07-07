package com.spring.mq.header;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/header")
public class HeaderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send1/{msg}")
    public void sendApi1(@PathVariable String msg) {
        send1(msg);
    }

    @GetMapping("/send2/{msg}")
    public void sendApi2(@PathVariable String msg) {
        send2(msg);
    }


    public void send1(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue1");
        messageProperties.setHeader("bindType", "whereAll");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息：" + msg);
        rabbitTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE, null, message);
    }


    public void send2(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue2");
        messageProperties.setHeader("bindType", "whereAny");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息：" + msg);
        rabbitTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE, null, message);

    }

}
