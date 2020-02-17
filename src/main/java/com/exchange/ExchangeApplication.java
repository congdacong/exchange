package com.exchange;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

    @Bean
    public Queue SimpleQueue1() {
        return new Queue("simple.1");
    }
    /**
     * 广播模式交换机
     * @return
     */
    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("EXCHANGE_QUEUE");
    }

    /**
     * 定向模式交换机
     * @return
     */
    public DirectExchange getDirectExchange(){
        return new DirectExchange("Direct_QUEUE");
    }


}
