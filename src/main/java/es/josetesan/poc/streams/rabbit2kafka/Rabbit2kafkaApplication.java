package es.josetesan.poc.streams.rabbit2kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;


/**
 * @See https://www.baeldung.com/spring-cloud-stream
 */
@SpringBootApplication
@EnableBinding(Processor.class)
public class Rabbit2kafkaApplication {


	private static final Logger LOGGER = LoggerFactory.getLogger(Rabbit2kafkaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Rabbit2kafkaApplication.class, args);
	}



	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Object handleMessage(Object message) {
		LOGGER.info("Handling message {}",message);
		return message;
	}

}
