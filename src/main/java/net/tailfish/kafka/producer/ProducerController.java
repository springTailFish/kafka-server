package net.tailfish.kafka.producer;


import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/producer")
public class ProducerController {


    @Autowired
    private SendResultListener sendResultListener;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "sendMessage/{msg}")
    public Object sendMessage(@PathVariable("msg") String message){

        JSONObject jsonObject = JSONObject.of();
        jsonObject.put("result",200);

        //增加发送回调
        kafkaTemplate.setProducerListener(sendResultListener);
        kafkaTemplate.send("jz_topic",message);

        jsonObject.put("result",200);

        return jsonObject;

    }
}
