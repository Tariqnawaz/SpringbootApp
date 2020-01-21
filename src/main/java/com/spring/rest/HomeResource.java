package com.spring.rest;

import com.spring.SpringbootappApplication;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class HomeResource {
	public static Logger logger = LoggerFactory.getLogger(HomeResource.class);
	private final CountDownLatch latch = new CountDownLatch(3);


	private KafkaTemplate<String, String> template;

	public HomeResource(KafkaTemplate<String, String> template) {
		this.template = template;
	}

	@GetMapping("/")
	public String index() {
		String topic = "thing1";
		String msg = "Bismillahi-rehmanir-rahim";
		template.send(topic,msg);
		return "Greetings from Spring Boot!";
	}


	@KafkaListener(topics = "myTopic")
	@GetMapping("/api/home")
    public String homeInit() {
        System.out.println("home controller..home");
        return "Welcome to HOME page of your application.. Alhumdulilah";
    }

	/*@KafkaListener(topics = "thing1")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info(cr.toString());
		latch.countDown();
	}*/

	@KafkaListener(topics = "thing1")
	public void listen(@Payload String message) {
		logger.info("received message='{}'", message);
	}



}
