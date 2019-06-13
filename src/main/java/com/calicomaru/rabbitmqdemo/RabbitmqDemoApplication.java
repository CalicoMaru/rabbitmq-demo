package com.calicomaru.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqDemoApplication.class, args);
	}

	/**
	 *
	 * docker pull rabbitmq:3-management
	 *
	 * docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq rabbitmq:3-management
	 *
	 */

}
