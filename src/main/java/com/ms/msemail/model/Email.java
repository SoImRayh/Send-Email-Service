package com.ms.msemail.model;

import com.ms.msemail.enums.StatusEmail;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Email {
    private static final long serialVersionUID = 1L;

    private Long emailId;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    private String text;

    private LocalDateTime sendDateemail;
    private StatusEmail statusEmail;
}
