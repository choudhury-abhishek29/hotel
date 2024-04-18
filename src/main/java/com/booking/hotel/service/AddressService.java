package com.booking.hotel.service;

import com.booking.hotel.model.Address;
import com.booking.hotel.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddress(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public Long saveAddress(Address address) { return addressRepository.save(address).getId(); }
}
