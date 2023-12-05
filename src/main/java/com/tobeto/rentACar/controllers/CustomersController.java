package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private void add(@RequestBody AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping
    private void update(@RequestBody UpdateCustomerRequest request){
        customerService.update(request);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteCustomerRequest request){
        customerService.delete(request);
    }
    @GetMapping("dto/fName")
    private List<GetListCustomerContactResponse> getByFirstNameDto(@RequestParam String fName){
        return customerService.getByFirstNameDto(fName);
    }
    @GetMapping("allCustomers")
    private List<GetListCustomerResponse> getAllCustomersDto(){
        return customerService.getAllCustomersDto();
    }
}
