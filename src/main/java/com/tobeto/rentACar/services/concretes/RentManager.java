package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.entities.Rent;
import com.tobeto.rentACar.repositories.RentRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.abstracts.RentService;
import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentManager implements RentService {

    private final RentRepository rentRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final PaymentService paymentService;

    @Override
    public void add(AddRentRequest request) {
        Rent rent = new Rent();
        rent.setPickUpDate(request.getPickUpDate());
        rent.setDropOffDate(request.getDropOffDate());

        Customer customer = customerService.getById(request.getCustomerId());
        rent.setCustomer(customer);

        Car car = carService.getById(request.getCarId());
        rent.setCar(car);

        PaymentMethod payment = paymentService.getById(request.getPaymentId());
        rent.setPaymentMethod(payment);

        rentRepository.save(rent);
    }

    @Override
    public void update(UpdateRentRequest request) {
        Rent rentToUpdate = rentRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Update Error : There is no rent with this id!"));
        rentToUpdate.setPickUpDate(request.getPickUpDate());
        rentToUpdate.setDropOffDate(request.getDropOffDate());
        rentRepository.save(rentToUpdate);
    }

    @Override
    public void delete(DeleteRentRequest request) {
        Rent rentToDelete = rentRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Delete Error : There is no rent with this id!"));
        rentRepository.delete(rentToDelete);
    }

    @Override
    public List<GetListRentResponse> getByCustomerName(String customerName) {
        return rentRepository.findByCustomerDto(customerName);
    }

    @Override
    public List<GetListRentResponse> getByBrandName(String brandName) {
        return rentRepository.findByBrandDto(brandName);
    }

    @Override
    public List<GetListRentResponse> getByPayMethod(String payName) {
        return rentRepository.findByPayMethodDto(payName)
                .stream()
                .filter(car -> car.getCar().getDailyPrice().compareTo(new BigDecimal("1000")) > 0)
                .collect(Collectors.toList());
    }
}
