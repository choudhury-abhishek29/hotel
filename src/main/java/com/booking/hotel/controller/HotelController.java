package com.booking.hotel.controller;

import com.booking.hotel.dto.HotelRequest;
import com.booking.hotel.dto.HotelResponse;
import com.booking.hotel.model.Hotel;
import com.booking.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    private Hotel hotel;

    @Autowired
    public HotelController(HotelService hotelService)
    {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "/all")
    public List<HotelResponse> getAllHotels(){
        return hotelService.getAllHotels();
    }
    @GetMapping(path = "/{hotelId}")
    public HotelResponse getHotel(@PathVariable("hotelId") Long hotelId) {
        return hotelService.getHotel(hotelId);

    }
    @DeleteMapping(path = "/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Long hotelId){
        return hotelService.deleteHotel(hotelId);
    }

    @PutMapping(path = "/{hotelId}")
    public String updateHotel(@RequestBody HotelRequest hotelUpdates, @PathVariable("hotelId") Long hotelId){
        return hotelService.updateHotel(hotelUpdates, hotelId);
    }


    @PostMapping(path = "/")
    public String addHotel(@RequestBody HotelRequest request){
        hotel.setName(request.getName());
        hotel.setAddress(request.getAddress());
        hotel.setRooms(request.getRooms());

        return hotelService.addHotel(hotel);
    }


}
