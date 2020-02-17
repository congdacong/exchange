package com.exchange.compant;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumer {
    /**
     * autoDelete = false 持久化队列
     * @param msg
     * @throws InterruptedException
     */
    @RabbitListener(bindings ={@QueueBinding(value = @Queue(value = "direct.1"),
            exchange =@Exchange(value = "Direct_QUEUE",type = ExchangeTypes.DIRECT),key = "A")})
    public void listen1(String msg) throws InterruptedException {
//        Thread.sleep(10000);
        System.out.println("A：" + msg);
    }

    @RabbitListener(bindings ={@QueueBinding(value = @Queue(value = "direct.2"),
            exchange =@Exchange(value = "Direct_QUEUE",type = ExchangeTypes.DIRECT),key = "B")})
    public void listen2(String msg) {
        System.out.println("B：" + msg);
    }

}
