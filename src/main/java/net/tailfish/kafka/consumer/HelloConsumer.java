package net.tailfish.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloConsumer.class);

    @KafkaListener(topics = {"hello-topic"})
    public void helloTopic(ConsumerRecord<String, String> record, Acknowledgment ack,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        LOGGER.info("[测试数据]：topic={},partition={},value={}",record.topic(),record.partition(),record.value());

        LOGGER.info("topic={},partition={},value={} 执行完成，提交已完成操作",record.topic(),record.partition(),record.value());
        ack.acknowledge();
    }


    @KafkaListener(topics = {"jz_topic"})
    public void helloJzTopic(ConsumerRecord<String, String> record, Acknowledgment ack,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        LOGGER.info("[测试数据]：topic={},partition={},value={}",record.topic(),record.partition(),record.value());

    }
}
