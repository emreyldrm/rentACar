package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerContactResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public void add(AddCustomerRequest request) {
        if(customerRepository.existsCustomerByMail(request.getMail()))
            throw new RuntimeException("Add Error : Such an email is already registered!");

//        Customer customer = new Customer();
//        customer.setFName(request.getFName());
//        customer.setLName(request.getLName());
//        customer.setMail(request.getMail());
//        customer.setLicenseYear(request.getLicenseYear());
//        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Update Error : There is no customer with this id!"));
        customerToUpdate.setPhone(request.getPhone());
        customerToUpdate.setMail(request.getMail());
        customerRepository.save(customerToUpdate);

    }

    @Override
    public void delete(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Delete Error : There is no customer with this id!"));
        customerRepository.delete(customerToDelete);

    }

    @Override
    public List<GetListCustomerContactResponse> getByFirstNameDto(String fName) {
        return customerRepository.findByFirstNameDto(fName);
    }

    @Override
    public List<GetListCustomerResponse> getAllCustomersDto() {
        return customerRepository.findAllCustomersDto()
                .stream()
                .filter(customer -> customer.getAge() > 23)
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no customer with this id!"));
    }
}
