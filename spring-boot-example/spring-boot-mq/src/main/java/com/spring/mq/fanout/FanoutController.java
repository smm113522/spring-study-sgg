package com.spring.mq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RequestMapping("/producer")
@RestController
public class FanoutController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 访问
     * http://localhost:8090/producer/fanout/send
     * 发送消息
     *
     * @return
     */
    @GetMapping("fanout/send")
    public String sendFanoutMessage() {
        int i = 0;
        while (i < 5) {
            HashMap<String, Object> map = new HashMap();
            map.put("message_id", UUID.randomUUID());
            map.put("message_msg", "这是一条消息数据");
            map.put("message_num", ++i);
            map.put("message_created_time", new Date());
            rabbitTemplate.convertAndSend("CustomFanoutExchange", null, map);
        }
        return "发送成功";
    }

}
