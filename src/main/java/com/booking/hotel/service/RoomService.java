package com.booking.hotel.service;

import com.booking.hotel.exception.ExceptionMessages;
import com.booking.hotel.exception.room.RoomNotFoundException;
import com.booking.hotel.model.ROOM_STATUS;
import com.booking.hotel.model.Room;
import com.booking.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> saveRooms(List<Room> rooms){
        return roomRepository.saveAll(rooms);
    }

    public Room getRoomByRoomId(Long roomId){
        Optional<Room> r = roomRepository.findById(roomId);
        Room room = r.orElseThrow(() -> new RoomNotFoundException(ExceptionMessages.ROOM_NOT_FOUND.getValue(), ExceptionMessages.ROOM_NOT_FOUND.getStatus()));
        return room;
    }

    public List<Room> getRoomByHotelId(Long hotelId){
        return roomRepository.findByHotelId(hotelId);
    }

    public Room updateRoomStatus(Long roomId, ROOM_STATUS newRoomStatus){
        Room room = getRoomByRoomId(roomId);
        room.setStatus(newRoomStatus);
        return roomRepository.save(room);
    }
}
