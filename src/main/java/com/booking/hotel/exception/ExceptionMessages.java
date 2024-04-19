package com.booking.hotel.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionMessages {
    HOTEL_NOT_FOUND("Hotel Not Found", HttpStatus.NOT_FOUND);

    private final String value;
    private final HttpStatus status;

    private ExceptionMessages(String value, HttpStatus status){
        this.value = value;
        this.status = status;
    }
}
