package com.spring.mq.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue CustomDirectQueue() {
        // 这里Queue对象有四个常用参数
        // name：消息队列命名。
        // durable：默认为false，是否持久化。持久化队列会被存储在磁盘上，当消息代理重启时仍然存在；否则当前连接有效。
        // exclusive：默认为false，只能被当前创建的连接使用，当连接关闭后队列即被删除，优先级高于durable。
        // autoDelete：默认为false，是否自动删除，当没有生产者或者消费者使用此队列，则队列自动删除。
        return new Queue("CustomDirectQueue", true);
    }

    /**
     * 创建 Direct交换器
     * @return
     */
    @Bean
    public DirectExchange CustomDirectExchange() {
        return new DirectExchange("CustomDirectExchange", true, false);
    }

    /**
     * 将交换器与队列绑定，设定匹配键
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(CustomDirectQueue()).to(CustomDirectExchange()).with("custom.direct.routing");
    }

}
