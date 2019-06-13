package com.calicomaru.rabbitmqdemo.receiver;

import com.calicomaru.rabbitmqdemo.model.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FruitReceiver {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "xswl.queue")
    public void receiveFruitMessage(){

        rabbitTemplate.receiveAndConvert("xswl.queue");

        System.out.println(rabbitTemplate.receiveAndConvert("xswl.queue"));

        log.debug("Msg Received");

    }

}
