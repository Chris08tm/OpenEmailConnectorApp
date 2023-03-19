package com.ccs.openemailconnector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
    private String from;
    private String name;
    private String phone;
    private String subject;
    private String body;
}
