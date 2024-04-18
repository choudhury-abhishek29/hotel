package com.booking.hotel.dto;

import com.booking.hotel.model.Address;
import com.booking.hotel.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelRequest {
    private String name;
    private Address address;
    private List<Room> rooms;
}
