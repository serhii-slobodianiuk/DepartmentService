package com.slobodianiuk.departmentservice.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleRuntimeExceptionException(IllegalArgumentException e) {
        return new ResponseEntity<>(buildResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLExceptionException(SQLException e) {
        return new ResponseEntity<>(buildResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleSQLExceptionException(NullPointerException e) {
        return new ResponseEntity<>(buildResponse(e), HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponse buildResponse(Exception e) {
        String message = e.getMessage();
        logger.error(message);
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(message);
        response.setDate(String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)));
        return response;
    }
}