package com.booking.hotel.controller;

import com.booking.hotel.model.ROOM_STATUS;
import com.booking.hotel.model.Room;
import com.booking.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping(path = "/findRoomsByHotel")
    public List<Room> getRoomByHotelId(@RequestParam("hotel_id") Long hotelId){
        return roomService.getRoomByHotelId(hotelId);
    }

    @GetMapping(path = "/{roomId}")
    public Room getRoomById(@PathVariable("roomId") Long roomId){
        return roomService.getRoomByRoomId(roomId);
    }
    @PutMapping(path = "/updateRoomStatus")
    public Room updateRoomStatus(@RequestParam("room_id") Long roomId, @RequestParam("room_status") ROOM_STATUS newRoomStatus){
        return roomService.updateRoomStatus(roomId, newRoomStatus);
    }


}
