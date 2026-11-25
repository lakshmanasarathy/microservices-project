package com.example.employee_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee_service.response.AddressResponse;

@FeignClient(name = "address-service", url = "http://localhost:8082", path = "/address-api/api/")
public interface AddressClient {
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressEmployeeById(@PathVariable("employeeId") int id);
}
