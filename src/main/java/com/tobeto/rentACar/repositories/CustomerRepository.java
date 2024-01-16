package com.tobeto.rentACar.repositories;


import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByMail(final String mail);
    //Custom Query Methods
    @Query("Select new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerContactResponse" +
            "(c.phone, c.mail, new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse(c.fName, c.lName, c.age) ) " +
            "FROM Customer c " +
            "WHERE c.fName = :fName")
    List<GetListCustomerContactResponse> findByFirstNameDto(String fName);
    @Query("Select new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse" +
            "(c.fName, c.lName, c.age) " +
            "FROM Customer c ")
    List<GetListCustomerResponse> findAllCustomersDto();
    boolean existsCustomerByMail(String mail);
}
