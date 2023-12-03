package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.responses.GetAllCustomersByContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerByFirstNameResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    List<GetListCustomerByFirstNameResponse> getByFirstNameDto(String fName);
    List<GetAllCustomersByContactResponse> getAllCustomersDto();
}
