package com.booking.hotel.exception.room;

import com.booking.hotel.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RoomNotFoundException extends ApiException {
    public RoomNotFoundException(String msg, HttpStatus status){
        super(msg, status);
    }
}
