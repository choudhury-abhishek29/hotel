package com.booking.hotel.repository;

import com.booking.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> { //for extending, CrudRepository interface can also be used
    public List<Room> findByHotelId(Long hotelId);
}
