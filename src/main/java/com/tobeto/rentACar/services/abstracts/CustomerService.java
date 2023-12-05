package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    List<GetListCustomerContactResponse> getByFirstNameDto(String fName);
    List<GetListCustomerResponse> getAllCustomersDto();
}
