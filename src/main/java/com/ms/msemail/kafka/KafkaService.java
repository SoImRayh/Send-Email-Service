package com.ms.msemail.kafka;

import com.ms.msemail.services.EmailService;
import dev.rayh.contracts.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final EmailService emailService;

    @KafkaListener(id = "email-consumer", topics = "email")
    public void consume ( EmailEvent event){
        emailService.sendEmail(event);
    }
}
