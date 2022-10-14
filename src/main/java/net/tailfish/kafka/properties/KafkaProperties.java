package net.tailfish.kafka.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

    /**
     * kafka 服务地址，多个使用 , 隔开
     */
    private List<String> bootstrapServers = new ArrayList(Collections.singletonList("localhost:9092"));

    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }
}
