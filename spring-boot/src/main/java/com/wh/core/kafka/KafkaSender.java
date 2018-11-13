package com.wh.core.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.wh.api.entity.UsersEntity;
import com.wh.utils.JsonUtil;

/**
 *  kafka服务提供者
* @ClassName: KafkaSender 
* @author wh
* @date 2018年8月29日 下午8:59:17
* =====================================
* @Component
 */
public class KafkaSender {
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String KAFKA_TOPIC = "test";
    
    public void send(UsersEntity users) {
        kafkaTemplate.send(KAFKA_TOPIC, JsonUtil.toJson(users));
    }
}