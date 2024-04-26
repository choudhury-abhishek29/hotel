package com.booking.hotel.service;

import com.booking.hotel.dto.HotelRequest;
import com.booking.hotel.dto.HotelResponse;
import com.booking.hotel.exception.ExceptionMessages;
import com.booking.hotel.exception.hotel.HotelNotFoundException;
import com.booking.hotel.model.Address;
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
    private final AddressService addressService;

    @Autowired
    private HotelResponse response;



    @Autowired
    public HotelService(HotelRepository hotelRepository, AddressService addressService, RoomService roomService) {
        this.hotelRepository = hotelRepository;
        this.addressService = addressService;
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

    public String addHotel(Hotel hotel) {
        Hotel savedHotel = hotelRepository.save(hotel);
        return "Hotel added : "+savedHotel.getName()+":"+savedHotel.getId();
    }

    public String deleteHotel(Long hotelId) {
        Optional<Hotel> oh = hotelRepository.findById(hotelId);
        Hotel h = oh.orElseThrow(()-> new HotelNotFoundException(ExceptionMessages.HOTEL_NOT_FOUND.getValue(), ExceptionMessages.HOTEL_NOT_FOUND.getStatus()));

        hotelRepository.deleteById(hotelId);
        return "Hotel with id : "+hotelId+" deleted";
    }

    public String updateHotel(HotelRequest hotelUpdates, Long hotelId){
        Hotel hotel =  hotelRepository.findById(hotelId).get();
        if(hotelUpdates.getName()!=null)
            hotel.setName(hotelUpdates.getName());

        if(hotelUpdates.getAddress()!=null){
            Address address = addressService.getAddress(hotel.getAddress().getId()).get();
            addressService.updateAddress(hotelUpdates.getAddress(), address.getId());
        }


        if(hotelUpdates.getRooms()!=null)
            hotel.setRooms(hotelUpdates.getRooms());

        Hotel savedHotel = hotelRepository.save(hotel);

        return "Hotel updated : "+savedHotel.getName()+":"+savedHotel.getId();
    }

    private HashMap<ROOM_TYPE, Integer> countRooms(List<Room> rooms){
        HashMap<ROOM_TYPE, Integer> roomCounts = new HashMap<ROOM_TYPE, Integer>();
        for(Room r : rooms)
            roomCounts.put(r.getType(), roomCounts.getOrDefault(r.getType(),0)+1);

        return roomCounts;
    }
}
