package com.booking.hotel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> apiException(ApiException ae){
        return new ResponseEntity<>(Map.of("error",ae.getMessage(),"status",String.valueOf(ae.getStatus().value())), ae.getStatus());
    }
}