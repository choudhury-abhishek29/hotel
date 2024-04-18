package com.booking.hotel.config;

import com.booking.hotel.model.ADDRESS_TYPE;
import com.booking.hotel.model.Address;
import com.booking.hotel.repository.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AddressConfig {
//    @Bean
//    CommandLineRunner cli(AddressRepository repository) {
//        return args -> {
//            Address a1 = new Address(
//                    "2601 Hilltop Dr",
//                    "room 1001",
//                    "Richmond",
//                    "CA",
//                    "USA",
//                    94806,
//                    ADDRESS_TYPE.HOTEL
//            );


//            List<Address> addresses = repository.saveAll(List.of(a1));
//            for(Address addr : addresses)
//                System.out.println("Address added. Id : "+addr.getId());

//        };
//    }
}
