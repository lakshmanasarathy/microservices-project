package com.example.address_service.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address_service.entity.Address;
import com.example.address_service.repository.AddressRepository;
import com.example.address_service.response.AddressResponse;

@Service
public class AddressService {

    @Autowired
    AddressRepository repo;

    @Autowired
    ModelMapper mmap;

    public AddressResponse getAddressByEmployeeId(int employeeId) {
        Address add = repo.findAddressByEmployeeId(employeeId);
        AddressResponse ares = mmap.map(add, AddressResponse.class);
        return ares;
    }
}
