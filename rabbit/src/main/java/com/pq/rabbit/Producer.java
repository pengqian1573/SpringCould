package com.pq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class Producer implements  RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    public  void  sendMsg(String content){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(Config.EXCHANGE_A, Config.ROUTINGKEY_A, content, correlationId);

    }


    public void sendAll(String content) {
        rabbitTemplate.convertAndSend("fanoutExchange","", content);
    }

    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
        System.out.println(" 回调id:" + correlationData +" ack " +ack  +" cause " + cause);
        if (ack) {
            System.err.println("消息成功消费");
        } else {
            System.err.println("消息消费失败:" + cause);

        }
    }
}
