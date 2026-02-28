package com.ms.msemail.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaBeans {
    @Bean
    public NewTopic topic (){
        return TopicBuilder.name("email").partitions(10).replicas(1).build();
    }
}
