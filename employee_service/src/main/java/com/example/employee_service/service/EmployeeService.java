package com.example.employee_service.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.response.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    ModelMapper mmap;

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = repo.findById(id).get();
        EmployeeResponse empres = mmap.map(employee, EmployeeResponse.class);
        return empres;
    }

}
