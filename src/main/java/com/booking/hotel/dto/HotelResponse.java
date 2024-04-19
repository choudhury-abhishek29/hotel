package com.booking.hotel.dto;

import com.booking.hotel.model.Address;
import com.booking.hotel.model.ROOM_TYPE;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class HotelResponse {
    private Long id;
    private String name;
    private Address address;
    private HashMap<ROOM_TYPE, Integer> roomCounts;
}
