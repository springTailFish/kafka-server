package net.tailfish.kafka;

import net.tailfish.kafka.properties.KafkaConsumerProperties;
import net.tailfish.kafka.properties.KafkaProducerProperties;
import net.tailfish.kafka.properties.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({KafkaProperties.class,KafkaProducerProperties.class, KafkaConsumerProperties.class})
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
