package com.booking.hotel.config;

import com.booking.hotel.model.Hotel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelConfig {
    CommandLineRunner cli() {
        return args -> {
//            new Hotel()
        };
    }
}
