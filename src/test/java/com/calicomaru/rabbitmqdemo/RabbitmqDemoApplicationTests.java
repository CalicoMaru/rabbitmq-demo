package com.calicomaru.rabbitmqdemo;

import com.calicomaru.rabbitmqdemo.model.Fruit;
import com.calicomaru.rabbitmqdemo.receiver.FruitReceiver;
import com.calicomaru.rabbitmqdemo.sender.FruitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {

	Logger log = LoggerFactory.getLogger(this.getClass());


	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	FruitSender fruitSender;

	@Autowired
	FruitReceiver fruitReceiver;

//	@Before
//	public void testMsg(){
//		rabbitTemplate.convertAndSend("xswl.haha","haha.haha",new Fruit("Orange", 99.99));
//	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testMsgSend(){

		fruitSender.sendFruitMessage();
		//fruitReceiver.receiveFruitMessage();

	}

	@Test
	public void createDirectExchange(){
		amqpAdmin.declareExchange(new DirectExchange("xswl.haha", true,false));
		log.debug("Create exchange");
	}

	@Test
	public void createQueue(){
		amqpAdmin.declareQueue(new Queue("xswl.queue", true));
	}

	@Test
	public void createBinding(){
		amqpAdmin.declareBinding(new Binding("xswl.queue",
				Binding.DestinationType.QUEUE,
				"xswl.haha", "haha.haha",
				null));
	}


	@Test
	public void receiveMessage(){

		//System.out.println(rabbitTemplate.receiveAndConvert("xswl.queue"));

	}

	@Test
	public void sendMsgFanout(){
		//routeKey is empty since its fanout mode
		//rabbitTemplate.convertAndSend("xswl.haha","", new Fruit("Apple", 9.99));
	}

}
