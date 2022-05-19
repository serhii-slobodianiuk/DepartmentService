package com.slobodianiuk.departmentservice.controller.error;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {
    private String message;
    private String date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
