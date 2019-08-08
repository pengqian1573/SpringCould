package com.pq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = Config.QUEUE_A)
public class Consumer {

    @RabbitHandler
    public void  hander(String message){
        System.out.println("Consumer A : " + message);
    }
}
