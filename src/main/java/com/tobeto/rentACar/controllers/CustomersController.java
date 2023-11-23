package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;



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
}
