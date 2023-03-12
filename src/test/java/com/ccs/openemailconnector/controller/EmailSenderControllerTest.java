package com.ccs.openemailconnector.controller;

import com.ccs.openemailconnector.service.MessageSenderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(EmailSenderController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class EmailSenderControllerTest {
    @MockBean
    private MessageSenderService messageSenderService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void sendEmailFailure() throws Exception {
        String messageBody = "{\"from\" : \"chris@gmail.com\",\"subject\" : \"Important message\",\"body\" : \"Se me esta callendo la casa, me hace falta ayuda pronto. thanks!\"}";

        doThrow(new RuntimeException()).when(messageSenderService).sendMessage(any());
        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders
                .post("/send")
                .contentType(MediaType.APPLICATION_JSON)
                .content(messageBody));

        resultAction.andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
