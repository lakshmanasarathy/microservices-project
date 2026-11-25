package com.example.employee_service.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.feignclient.AddressClient;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.response.AddressResponse;
import com.example.employee_service.response.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    ModelMapper mmap;

    @Autowired
    AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = repo.findById(id).get();
        EmployeeResponse empres = mmap.map(employee, EmployeeResponse.class);
        ResponseEntity<AddressResponse> addresEntity = addressClient.getAddressEmployeeById(id);
        AddressResponse addres = addresEntity.getBody();
        empres.setAddressResponse(addres);
        return empres;
    }

}
