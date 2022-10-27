package com.spring.microservice.addressService.service;

import com.spring.microservice.addressService.entity.Address;
import com.spring.microservice.addressService.repository.AddressRepository;
import com.spring.microservice.addressService.request.CreateAddressRequest;
import com.spring.microservice.addressService.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository  addressRepository;
    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());

        addressRepository.save(address);

        return  new AddressResponse(address);
    }

    public AddressResponse getById(long id) {

        Address address = addressRepository.findById(id).get();
        return new AddressResponse(address);

    }
}
