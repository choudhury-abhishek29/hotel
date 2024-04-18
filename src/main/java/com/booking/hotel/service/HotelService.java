package com.booking.hotel.service;

import com.booking.hotel.model.Hotel;
import com.booking.hotel.model.ROOM_TYPE;
import com.booking.hotel.model.Room;
import com.booking.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final AddressService addressService;
    private final RoomService roomService;

    @Autowired
    public HotelService(HotelRepository hotelRepository, AddressService addressService, RoomService roomService) {
        this.hotelRepository = hotelRepository;
        this.addressService = addressService;
        this.roomService = roomService;
    }
    public List<Hotel> getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();
        for(Hotel h : allHotels) {
            HashMap<ROOM_TYPE, Integer> roomCounts = new HashMap<ROOM_TYPE, Integer>();
            for(Room r : h.getRooms())
                roomCounts.put(r.getType(), roomCounts.getOrDefault(r.getType(),0)+1);
            h.setRoomCounts(roomCounts);
        }
        return allHotels;
    }

    public String addHotel(Hotel hotel)
    {
        Hotel savedHotel = hotelRepository.save(hotel);

        return "Hotel added : "+savedHotel.getName()+":"+savedHotel.getId();
    }
}
