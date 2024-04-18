package com.booking.hotel.controller;

import com.booking.hotel.dto.HotelRequest;
import com.booking.hotel.model.Hotel;
import com.booking.hotel.model.Room;
import com.booking.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

//    @Autowired
//    private Hotel hotel;

    @Autowired
    public HotelController(HotelService hotelService)
    {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "hotels")
    public List<Hotel> getAllHotels()
    {
        return hotelService.getAllHotels();
    }

    @PostMapping(path = "/hotel")
    public String addHotel(@RequestBody HotelRequest request)
    {
        Hotel hotel = new Hotel();
        hotel.setName(request.getName());
        hotel.setAddress(request.getAddress());
        hotel.setRooms(request.getRooms());

        return hotelService.addHotel(hotel);
    }


}
