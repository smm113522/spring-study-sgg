package com.spring.mq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue firstQueue() {
        return new Queue("TopicFirstQueue", true);
    }

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue secondQueue() {
        return new Queue("TopicSecondQueue", true);
    }

    /**
     * 创建 Topic交换器
     * @return
     */
    @Bean
    public TopicExchange CustomTopicExchange() {
        return new TopicExchange("CustomTopicExchange");
    }

    /**
     * 将交换器与队列绑定，设定匹配键
     * @return
     */
    @Bean
    public Binding bindingFirst() {
        return BindingBuilder.bind(firstQueue()).to(CustomTopicExchange()).with("custom.topic.#");
    }

    /**
     * 将交换器与队列绑定，设定匹配键
     * @return
     */
    @Bean
    public Binding bindingSecond() {
        return BindingBuilder.bind(secondQueue()).to(CustomTopicExchange()).with("custom.topic.second");
    }

}

