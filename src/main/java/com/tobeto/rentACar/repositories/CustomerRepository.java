package com.tobeto.rentACar.repositories;


import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.responses.GetAllCustomersByContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerByFirstNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //Custom Query Methods
    @Query("Select new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerByFirstNameResponse" +
            "(c.fName, c.lName, c.age, c.licenseYear) " +
            "FROM Customer c " +
            "WHERE c.fName = :fName")
    List<GetListCustomerByFirstNameResponse> findByFirstNameDto(String fName);
    @Query("Select new com.tobeto.rentACar.services.dtos.customer.responses.GetAllCustomersByContactResponse" +
            "(c.fName, c.lName, c.phone, c.mail) " +
            "FROM Customer c ")
    List<GetAllCustomersByContactResponse> findAllCustomersDto();
}
