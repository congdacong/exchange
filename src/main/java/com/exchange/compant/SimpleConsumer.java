package com.exchange.compant;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SimpleConsumer {

//    @RabbitListener(queues = "simple.1")
//    public void processMessage2(@Payload String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
//        System.out.println(message);
//        try{
//            channel.basicAck(tag,false);
//        }catch(IOException e){
//            try {
//                channel.basicNack(tag, false, true);
//                return;
//            }catch(IOException e1){
//                e1.printStackTrace();
//            }
//        }finally {
//            System.out.println("end");
//        }
//    }
}
