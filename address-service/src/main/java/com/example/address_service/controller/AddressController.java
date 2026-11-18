package com.example.address_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.address_service.response.AddressResponse;
import com.example.address_service.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    AddressService aService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getResponseById(@PathVariable("employeeId") int id) {
        AddressResponse ares = aService.getAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ares);
    }
}
