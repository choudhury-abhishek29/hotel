package com.booking.hotel.service;

import com.booking.hotel.model.Room;
import com.booking.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
