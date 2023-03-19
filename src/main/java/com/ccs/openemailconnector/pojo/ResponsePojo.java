package com.ccs.openemailconnector.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePojo {
    private String status;
    private String message;
    private String dateTime;
}
