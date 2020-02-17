package com.exchange.compant;

import com.exchange.content.Content;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FanoutConsumer {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.1",autoDelete = "false"),
            exchange = @Exchange(value = "EXCHANGE_QUEUE",ignoreDeclarationExceptions = "true", type = ExchangeTypes.FANOUT)))
    public void listen1(String msg,Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws InterruptedException {
        Thread.sleep(2000);
        try{
            channel.basicAck(tag,false);
            System.out.println("广播订阅模式1 接收到消息：" + msg);
        }catch(Exception e){
            try {
                channel.basicNack(tag, false, true);
                return;
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.2"),
            exchange = @Exchange(value = "EXCHANGE_QUEUE",ignoreDeclarationExceptions = "true", type = ExchangeTypes.FANOUT)))
    public void listen2(String msg,Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws InterruptedException {
        try{
            channel.basicAck(tag,false);
            System.out.println("广播订阅模式2 接收到消息：" + msg);
        }catch(Exception e){
            try {
                channel.basicNack(tag, false, true);
                return;
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
