package com.exchange.compant;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WorkConsumer {

    @RabbitListener(queues = "simple.1")
    public void processMessage1(@Payload String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws InterruptedException, IOException {
        Thread.sleep(2000);
        channel.basicAck(tag,false);
        System.out.println(message+"1");
    }

    @RabbitListener(queues = "simple.1")
    public void processMessage2(@Payload String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException {
        Thread.sleep(1000);
        channel.basicAck(tag,false);
        System.out.println(message+"2");
    }
}
