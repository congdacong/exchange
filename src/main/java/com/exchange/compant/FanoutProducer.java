package com.exchange.compant;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class FanoutProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 最终找到的实现类是：RabbitTemplate
     */
    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * Fanout模式
     * @param
     */
    public void send(){
        for (int i = 0; i <20 ; i++) {
            rabbitTemplate.convertAndSend("EXCHANGE_QUEUE","","message");
        }
//        String messageA = "广播订阅模式A";
//        String messageB = "广播订阅模式B";
//        rabbitTemplate.convertAndSend("EXCHANGE_QUEUE","",messageA);
//        rabbitTemplate.convertAndSend("EXCHANGE_QUEUE","",messageB);
    }
}
