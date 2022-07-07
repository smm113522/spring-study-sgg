package com.spring.mq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue CustomFanoutQueue() {
        return new Queue("CustomFanoutQueue", true);
    }

    /**
     * Fanout 交换器
     *
     * @return
     */
    @Bean
    public FanoutExchange CustomFanoutExchange() {
        return new FanoutExchange("CustomFanoutExchange");
    }

    /**
     * 队列与交换器绑定
     *
     * @return
     */
    @Bean
    public Binding FirstFanoutBinding() {
        return BindingBuilder.bind(CustomFanoutQueue()).to(CustomFanoutExchange());
    }

}
