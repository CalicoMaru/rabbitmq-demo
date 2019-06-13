package com.calicomaru.rabbitmqdemo.service;

import com.calicomaru.rabbitmqdemo.model.Fruit;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FruitMessageService {

    @RabbitListener(queues = "xswl.queue")
    public void receive(Fruit fruit){
        System.out.println("Message received " + fruit);
    }

    @RabbitListener(queues = "xswl.queue")
    public void receiveMsgHeader(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
