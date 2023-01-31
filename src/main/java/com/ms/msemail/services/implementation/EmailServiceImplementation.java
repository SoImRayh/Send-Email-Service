package com.ms.msemail.services.implementation;

import com.ms.msemail.dto.EmailDto;
import com.ms.msemail.enums.StatusEmail;
import com.ms.msemail.model.Email;
import com.ms.msemail.repositories.EmailRepository;
import com.ms.msemail.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImplementation implements EmailService {

    private final EmailRepository repository;
    private final JavaMailSender emailSender;

    public EmailServiceImplementation(EmailRepository repository, JavaMailSender emailSender) {
        this.repository = repository;
        this.emailSender = emailSender;
    }

    @Override
    public ResponseEntity<Email> sendEmail(EmailDto dto) {
        Email email = new Email();
        BeanUtils.copyProperties(dto, email);

        email.setSendDateemail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            System.out.println("\n"+e.getMessage());
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            repository.save(email);
        }

        return new ResponseEntity<>(email, HttpStatusCode.valueOf(200));
    }
}
