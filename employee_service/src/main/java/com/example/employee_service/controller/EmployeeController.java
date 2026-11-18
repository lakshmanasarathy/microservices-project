package com.example.employee_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.response.EmployeeResponse;
import com.example.employee_service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    EmployeeService service;

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int id) {
        EmployeeResponse empres = service.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(empres);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        repo.save(employee);
        return employee.getName() + " added successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        repo.deleteById(id);
        return "Employee with id " + id + " deleted successfully";
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return repo.findAll();
    }
}