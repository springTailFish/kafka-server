package net.tailfish.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class SendResultListener implements ProducerListener<String,String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendResultListener.class);

    @Override
    public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
        LOGGER.info("topic {} 发送成功,key:{},value:{}", producerRecord.topic(),producerRecord.key(),producerRecord.value());
    }

    @Override
    public void onError(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata, Exception exception) {
        LOGGER.info("topic {} 发送失败,key:{},value:{}，message:{}", producerRecord.topic(),producerRecord.key(),producerRecord.value(),exception.getMessage());
    }
}
