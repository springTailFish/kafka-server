package net.tailfish.kafka.properties;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka.producer")
public class KafkaProducerProperties {

    /**
     * 是否开启 生产者
     */
    private boolean enable;
    /**
     * topic
     */
    private String topic;

    /**
     * 重试次数
     */
    private Integer retries;

    /**
     * 应答级别:多少个分区副本备份完成时向生产者发送ack确认(可选0、1、all/-1)
     */
    private String acks;

    /**
     * 批量大小
     */
    private String batchSize;

    /**
     * 延迟发送时长， 立即发送请设置为0
     */
    private String lingerMs;

    /**
     * 生产端缓冲区大小
     */
    private String bufferMemory;

    /**
     * Key 序列化 ： org.apache.kafka.common.serialization.StringSerializer
     */
    private Class<?> keySerializer = StringSerializer.class;

    /**
     * value 序列化 org.apache.kafka.common.serialization.StringSerializer
     */
    private Class<?> valueSerializer = StringSerializer.class;

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getLingerMs() {
        return lingerMs;
    }

    public void setLingerMs(String lingerMs) {
        this.lingerMs = lingerMs;
    }

    public String getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(String bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public Class<?> getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(Class<?> keySerializer) {
        this.keySerializer = keySerializer;
    }

    public Class<?> getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(Class<?> valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
}
