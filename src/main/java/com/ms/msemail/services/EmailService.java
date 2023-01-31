package com.ms.msemail.services;

import com.ms.msemail.dto.EmailDto;
import com.ms.msemail.model.Email;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<Email> sendEmail(EmailDto dto);
}
