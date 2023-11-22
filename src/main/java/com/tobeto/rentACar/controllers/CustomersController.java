package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Customer customer){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setFName(customer.getFName());
        customerToUpdate.setLName(customer.getLName());
        customerToUpdate.setAge(customer.getAge());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setMail(customer.getMail());
        customerToUpdate.setLicenseYear(customer.getLicenseYear());
        customerRepository.save(customerToUpdate);

    }


}
