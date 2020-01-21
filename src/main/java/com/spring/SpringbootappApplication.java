package com.spring;

import com.spring.config.KafkaProducerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringbootappApplication implements CommandLineRunner
{
	public static Logger logger = LoggerFactory.getLogger(SpringbootappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
		System.out.println("app started");

		//this.template.send();
	}

	@Autowired
	KafkaProducerConfiguration kafkaProducerConfiguration;

	//private KafkaTemplate<String, String> template;

	@Override
	public void run(String... strings) throws Exception {
		/*String topic = "thing1";
		String msg = "Bismillahi-rehmanir-rahim";
		KafkaTemplate<String, String> template = kafkaProducerConfiguration.kafkaTemplate();
		template.send(topic,msg);*/
	}


	/*@Autowired
	private KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void run(String... args) throws Exception {
		this.template.send("myTopic", "foo1");
		this.template.send("myTopic", "foo2");
		this.template.send("myTopic", "foo3");
		latch.await(60, TimeUnit.SECONDS);
		logger.info("All received");
	}

	@KafkaListener(topics = "myTopic")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info(cr.toString());
		latch.countDown();
	}*/
}
