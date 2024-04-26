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

    public Address updateAddress(Address newAddress, Long addressId) {
        Address address = getAddress(addressId).get();//addressRepository.findById(addressId).get();
        if(newAddress.getLine1()!=null)
            address.setLine1(newAddress.getLine1());
        if(newAddress.getLine2()!=null)
            address.setLine2(newAddress.getLine2());
        if(newAddress.getCity()!=null)
            address.setCity(newAddress.getCity());
        if(newAddress.getState()!=null)
            address.setState(newAddress.getState());
        if(newAddress.getCountry()!=null)
            address.setCountry(newAddress.getCountry());
        if(newAddress.getZip()!=null)
            address.setZip(newAddress.getZip());

        return addressRepository.save(address);
    }
}
