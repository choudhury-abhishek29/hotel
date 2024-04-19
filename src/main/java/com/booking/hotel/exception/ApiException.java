package com.booking.hotel.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{
    private HttpStatus status;

    public ApiException(String msg, HttpStatus status){
        super(msg);
        this.status = status;
    }
}
