package com.ccs.openemailconnector.service;

import com.ccs.openemailconnector.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    private final String EMAIL_RECEPIENT = "yoandy56@gmail.com";
    private final String EMAIL_SENDER = "openemailconnectornotification@gmail.com";
    private SimpleMailMessage outboundMessage;
    @Autowired
    JavaMailSender javaMailSender;


    public void sendMessage(MessageModel message){
        outboundMessage = new SimpleMailMessage();
        String body = "Client's name: " + message.getName() +
                "\n\nClient's email: " + message.getFrom() +
                "\n\nClient's phone number: " + message.getPhone() +
                "\n\n" + message.getBody();
        String signature = "Message sent using CCS Open Email Connector App.";

        outboundMessage.setTo(EMAIL_RECEPIENT);
        outboundMessage.setCc("alexmar19190@gmail.com", "chris08tm@gmail.com");
        outboundMessage.setFrom(EMAIL_SENDER);
        outboundMessage.setSubject(message.getSubject());
        outboundMessage.setText(body + "\n\n" + signature);
        javaMailSender.send(outboundMessage);
        sendConfirmationEmail(message.getFrom());
    }

    private void sendConfirmationEmail(String clientEmail){
        SimpleMailMessage confirmationMessage = new SimpleMailMessage();
        String subject = "Confirmation ** DO NOT REPLY **";
        String body = "Thank you for reaching out, \n\n" +
                "An agent will be reaching out to you soon. " +
                "This is an automated message, please do not reply to this email.";
        String signature = "Message sent using CCS Open Email Connector App.";

        confirmationMessage.setTo(clientEmail);
        confirmationMessage.setFrom(EMAIL_SENDER);
        confirmationMessage.setSubject(subject);
        confirmationMessage.setText(body + "\n\n" + signature);
        javaMailSender.send(confirmationMessage);
    }
}
