package net.tailfish.kafka;

import org.apache.kafka.clients.producer.*;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerTest {

    public final static String TOPIC_NAME = "jz_topic";


    @Test
    public void testProducerApi() throws ExecutionException, InterruptedException {
//        producerSend();

        producerSyncSend();

    }


    /**
     * 异步发送
     */
    public static void producerSend(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.139.132:9092");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG,"3");
        properties.setProperty(ProducerConfig.ACKS_CONFIG,"1");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,"0");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");


        Producer<String,String> producer = new KafkaProducer(properties);

        //消息对象 ProducerRecord

        for(int i =0 ;i < 10;i++ ){
            ProducerRecord<String,String> record = new ProducerRecord<>(TOPIC_NAME,"k-"+i,"v-"+i);
            producer.send(record);
        }

        producer.close();
    }



    /**
     * 同步发送（异步阻塞发送）
     */
    public static void producerSyncSend() throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.139.132:9092");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG,"3");
        properties.setProperty(ProducerConfig.ACKS_CONFIG,"1");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,"0");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");


        Producer<String,String> producer = new KafkaProducer(properties);

        //消息对象 ProducerRecord

        for(int i =0 ;i < 10;i++ ){
            ProducerRecord<String,String> record = new ProducerRecord<>(TOPIC_NAME,"k-"+i,"v-"+i);
            Future<RecordMetadata> recordMetadataFuture = producer.send(record);
            RecordMetadata recordMetadata = recordMetadataFuture.get();
            System.out.println("key = " + record.key() + "partition = " + recordMetadata.partition() + "offset = "+ recordMetadata.offset());
        }

        producer.close();
    }
}
