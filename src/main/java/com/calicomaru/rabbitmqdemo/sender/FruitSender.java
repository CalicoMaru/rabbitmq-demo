package com.calicomaru.rabbitmqdemo.sender;

import com.calicomaru.rabbitmqdemo.model.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FruitSender {

    Logger log = LoggerFactory.getLogger(this.getClass());
    Fruit fruit = new Fruit("Melon", 19.99);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFruitMessage(){

        rabbitTemplate.convertAndSend("haha.haha", fruit);

        log.debug("Msg Sent");

    }
}
