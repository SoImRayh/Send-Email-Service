package com.ms.msemail.controller;

import com.ms.msemail.dto.EmailDto;
import com.ms.msemail.model.Email;
import com.ms.msemail.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService service;

    @Value("$SYSTEM")
    public String teste;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping("send-email/")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto dto){
        return service.sendEmail(dto);
    }
}
