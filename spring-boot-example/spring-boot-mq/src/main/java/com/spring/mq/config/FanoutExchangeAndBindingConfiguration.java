package com.spring.mq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeAndBindingConfiguration {

    @Bean(name = "firstExchange")
    FanoutExchange getFanoutExchange() {
        return new FanoutExchange("first-exchange");
    }

    @Bean
    Binding bindingFirstChange(@Qualifier("firstQueue")Queue queue,
                               @Qualifier("firstExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

}
