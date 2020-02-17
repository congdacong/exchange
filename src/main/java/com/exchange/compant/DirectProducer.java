package com.exchange.compant;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 最终找到的实现类是：RabbitTemplate
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * Direct模式
     * @param
     */
    public void send(){
        String messageA = "路由订阅模式A";
        String messageB = "路由订阅模式B";
        rabbitTemplate.convertAndSend("Direct_QUEUE","A",messageA);
        rabbitTemplate.convertAndSend("Direct_QUEUE","B",messageB);
    }
}
