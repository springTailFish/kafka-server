package net.tailfish.kafka.properties;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.listener.ContainerProperties;


@ConfigurationProperties(prefix = "kafka.consumer")
public class KafkaConsumerProperties {

    /**
     * 是否开启 消费者
     */
    private boolean enable;

    /**
     * Topic
     */
    private String topic;

    /**
     * 默认的消费组ID
     */
    private String groupId;

    /**
     * 是否自动提交offset
     */
    private boolean enableAutoCommit;

    /**
     * 提交offset延时(接收到消息后多久提交offset)
     */
    private Integer autoCommitInterval;

    /**
     * 可选项
     *  <p> earliest:当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费 </p>
     *  <p> latest:当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据 </p>
     *  <p> none:topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常  </p>
     */
    private AutoOffsetReset autoOffsetReset;

    /**
     * key 反序列化 org.apache.kafka.common.serialization.StringDeserializer
     */
    private Class<?> keyDeserializer = StringDeserializer.class;

    /**
     * value 反序列化  org.apache.kafka.common.serialization.StringDeserializer
     */
    private Class<?> valueDeserializer = StringDeserializer.class;

    /**
     * session 超时时间
     */
    private String sessionTimeoutMs;

    /**
     * 提交方式
     */
    private ContainerProperties.AckMode ackMode;

    /**
     * 消费方式
     */
    public enum AutoOffsetReset {
        earliest,
        latest,
        none
    }

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public Integer getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(Integer autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public AutoOffsetReset getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(AutoOffsetReset autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public Class<?> getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(Class<?> keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public Class<?> getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(Class<?> valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public String getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(String sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public ContainerProperties.AckMode getAckMode() {
        return ackMode;
    }

    public void setAckMode(ContainerProperties.AckMode ackMode) {
        this.ackMode = ackMode;
    }
}
