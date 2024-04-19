package com.booking.hotel.exception.hotel;

import com.booking.hotel.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class HotelNotFoundException extends ApiException {
    public HotelNotFoundException(String msg, HttpStatus status){
        super(msg, status);
    }
}
