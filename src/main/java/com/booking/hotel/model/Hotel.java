package com.booking.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
@Component
@Scope(value = "prototype")
public class Hotel {
    @Id
    @SequenceGenerator( name = "hotel_id_sequence", sequenceName = "hotel_id_sequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "hotel_id_sequence")
    Long id;

    String name;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    Address address;

    /*
    * For one to many relation for address:
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="fk_hotel_id", referencedColumnName = "id")
        * name : name of the fk column in Address table
        * referencedColumnName : column to reference from Hotel table
        List<Address> address;

        remove the Hotel reference from Address class.
    * */


    @OneToMany(targetEntity=Room.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
//    @JsonIgnore
//    @OneToMany(mappedBy = "hotel")
    List<Room> rooms;

//    @Transient
//    HashMap<ROOM_TYPE, Integer> roomCounts;
}
