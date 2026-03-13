package com.ms.msemail.services;

import com.ms.msemail.dto.EmailDto;
import com.ms.msemail.model.Email;
import dev.rayh.contracts.EmailEvent;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<Email> sendEmail(EmailDto dto);

    void sendEmail(EmailEvent event);
}
