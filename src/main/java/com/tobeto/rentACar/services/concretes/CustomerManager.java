package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.responses.GetAllCustomersByContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerByFirstNameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFName(request.getFName());
        customer.setLName(request.getLName());
        customer.setMail(request.getMail());
        customer.setLicenseYear(request.getLicenseYear());
        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.findById(request.getId()).orElseThrow();
        customerToUpdate.setPhone(request.getPhone());
        customerToUpdate.setMail(request.getMail());
        customerRepository.save(customerToUpdate);

    }

    @Override
    public void delete(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);

    }

    @Override
    public List<GetListCustomerByFirstNameResponse> getByFirstNameDto(String fName) {
        return customerRepository.findByFirstNameDto(fName);
    }

    @Override
    public List<GetAllCustomersByContactResponse> getAllCustomersDto() {
        return customerRepository.findAllCustomersDto();
    }
}
