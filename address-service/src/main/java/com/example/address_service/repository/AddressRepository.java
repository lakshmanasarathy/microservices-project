package com.example.address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.address_service.entity.Address;

@Repository
public interface AddressRepository
        extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1, ea.lane2,ea.state, ea.zip FROM employee_service.address ea join employee_service.employee e on e.id = employee_id")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
