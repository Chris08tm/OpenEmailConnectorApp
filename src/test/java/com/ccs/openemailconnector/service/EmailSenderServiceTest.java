package com.ccs.openemailconnector.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
public class EmailSenderServiceTest {
    @Mock
    JavaMailSender javaMailSender;

    @Mock
    SimpleMailMessage mailMessage;

    @InjectMocks
    private MessageSenderService messageSenderService;

    @Test
    void sendMessageSuccessfully(){

    }

}
