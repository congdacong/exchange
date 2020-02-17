package com.exchange.compant;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 最终找到的实现类是：RabbitTemplate
     */
    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 简单模式
     * @param
     */
    public void send(){
        String message = "简单队列";
        rabbitTemplate.convertAndSend("simple.1",message);
    }
}
