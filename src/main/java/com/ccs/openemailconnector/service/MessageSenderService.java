package com.ccs.openemailconnector.service;

import com.ccs.openemailconnector.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    private final String EMAIL_RECEPIENT = "chris08tm@gmail.com";
    private final String EMAIL_SENDER = "openemailconnectornotification@gmail.com";
    private SimpleMailMessage outboundMessage;
    @Autowired
    JavaMailSender javaMailSender;


    public void sendMessage(MessageModel message){
        outboundMessage = new SimpleMailMessage();
        String body = "Message coming from: " + message.getFrom() + "\n" + message.getBody();
        String signature = "Message sent using CCS Open Email Connector App.";

        outboundMessage.setTo(EMAIL_RECEPIENT);
        outboundMessage.setFrom(EMAIL_SENDER);
        outboundMessage.setSubject(message.getSubject());
        outboundMessage.setText(body + "\n\n" + signature);
        javaMailSender.send(outboundMessage);
    }
}
