package com.ms.msemail.kafka;

import dev.rayh.contracts.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {


    @KafkaListener(id = "email-consumer", topics = "email")
    public void consume ( EmailEvent event){
        System.out.println("Evento recebido,"+ event);
    }
}
