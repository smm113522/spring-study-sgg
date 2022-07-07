package com.spring.mq.topic;

import com.spring.mq.utils.MqUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RequestMapping("/producer")
@RestController
public class TopicController {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MqUtils mqUtils;

    @GetMapping("topic/send/{type}")
    public String sendTopicMessage(@PathVariable String type) {
        int i = 0;
        while(i < 10) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("message_id", UUID.randomUUID());
            map.put("message_msg", "这是一条消息数据");
            map.put("message_num", ++i);
            map.put("message_created_time", new Date());
            map.put("routing_key", "custom.topic." + type);
//            rabbitTemplate.convertAndSend("CustomTopicExchange", "custom.topic." + type, map);
            mqUtils.convertAndSend("CustomTopicExchange", "custom.topic." + type, map);
        }
        return "【topic】发送成功";
    }

}
