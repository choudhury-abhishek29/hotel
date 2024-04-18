package com.booking.hotel.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Room {
    @Id
    @SequenceGenerator(
            name = "room_id_sequence",
            sequenceName = "room_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_id_sequence"
    )
    Long id;

//    @ManyToOne(targetEntity = Hotel.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "hotel_id")
//    Hotel hotel;

    @Enumerated(EnumType.STRING)
    ROOM_TYPE type;

    @Enumerated(EnumType.STRING)
    ROOM_STATUS status;

}
