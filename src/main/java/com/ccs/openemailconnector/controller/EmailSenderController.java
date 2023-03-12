package com.ccs.openemailconnector.controller;

import com.ccs.openemailconnector.model.MessageModel;
import com.ccs.openemailconnector.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EmailSenderController {

    @Autowired
    private MessageSenderService messageSenderService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody MessageModel message){
        try{
            messageSenderService.sendMessage(message);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
