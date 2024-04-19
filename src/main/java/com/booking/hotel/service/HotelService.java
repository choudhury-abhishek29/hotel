package com.booking.hotel.service;

import com.booking.hotel.dto.HotelResponse;
import com.booking.hotel.exception.ExceptionMessages;
import com.booking.hotel.exception.hotel.HotelNotFoundException;
import com.booking.hotel.model.Hotel;
import com.booking.hotel.model.ROOM_TYPE;
import com.booking.hotel.model.Room;
import com.booking.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    private HotelResponse response;



    @Autowired
    public HotelService(HotelRepository hotelRepository, AddressService addressService, RoomService roomService) {
        this.hotelRepository = hotelRepository;
    }
    public List<HotelResponse> getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();
        List<HotelResponse> hotelResult = new ArrayList<>();
        for(Hotel h : allHotels) {
            hotelResult.add(new HotelResponse(h.getId(), h.getName(), h.getAddress(), countRooms(h.getRooms())));
        }
        return hotelResult;
    }

    public HotelResponse getHotel(Long hotelId) {
        Optional<Hotel> oh = hotelRepository.findById(hotelId);
        Hotel h = oh.orElseThrow(()-> new HotelNotFoundException(ExceptionMessages.HOTEL_NOT_FOUND.getValue(), ExceptionMessages.HOTEL_NOT_FOUND.getStatus()));

        response.setId(h.getId());
        response.setName(h.getName());
        response.setAddress(h.getAddress());
        response.setRoomCounts(countRooms(h.getRooms()));
        return response;
    }

    public String addHotel(Hotel hotel)
    {
        Hotel savedHotel = hotelRepository.save(hotel);

        return "Hotel added : "+savedHotel.getName()+":"+savedHotel.getId();
    }

    private HashMap<ROOM_TYPE, Integer> countRooms(List<Room> rooms){
        HashMap<ROOM_TYPE, Integer> roomCounts = new HashMap<ROOM_TYPE, Integer>();
        for(Room r : rooms)
            roomCounts.put(r.getType(), roomCounts.getOrDefault(r.getType(),0)+1);

        return roomCounts;
    }
}
