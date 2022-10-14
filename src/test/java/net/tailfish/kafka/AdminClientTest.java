package net.tailfish.kafka;

import com.alibaba.fastjson2.JSON;
import org.apache.kafka.clients.admin.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class AdminClientTest {

    public final static String TOPIC_NAME = "jz_topic";


    @Test
    public void testAdminClient() throws ExecutionException, InterruptedException {

        createTopic();
//        listTopics();

    }

    /**
     * 创建 Topic 实例
     */
    public static void createTopic(){
        AdminClient adminClient = adminClient();

        //副本因子，副本数量
        Short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME,1,rs);
        CreateTopicsResult topicsResult = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("topicsResult = " + JSON.toJSON(topicsResult));
    }

    /**
     * 获取Topic 列表
     */
    public static void listTopics() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> names = listTopicsResult.names().get();
        names.stream().forEach(System.out::println);
    }


    public static AdminClient adminClient(){
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.139.132:9092");

        AdminClient adminClient = AdminClient.create(properties);

        return adminClient;
    }
}
