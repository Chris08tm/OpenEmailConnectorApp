package com.ccs.openemailconnector.controller;

import com.ccs.openemailconnector.model.MessageModel;
import com.ccs.openemailconnector.pojo.ResponsePojo;
import com.ccs.openemailconnector.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class EmailSenderController {

    @Autowired
    private MessageSenderService messageSenderService;

    @PostMapping("/send")
    public ResponsePojo sendEmail(@RequestBody MessageModel message){
        ResponsePojo response = new ResponsePojo();
        SimpleDateFormat dtFormater = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a zzz");
        try{
            messageSenderService.sendMessage(message);
            response.setStatus("Success");
            response.setDateTime(dtFormater.format(new Date(System.currentTimeMillis())));
            response.setMessage("Email sent successfully");
            return response;
        } catch (Exception e) {
            response.setStatus("Failure");
            response.setDateTime(dtFormater.format(new Date(System.currentTimeMillis())));
            response.setMessage("Exception occurred: " + e.getMessage());
            return response;
        }
    }
}
