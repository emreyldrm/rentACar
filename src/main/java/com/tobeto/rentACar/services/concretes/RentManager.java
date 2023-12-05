package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Rent;
import com.tobeto.rentACar.repositories.RentRepository;
import com.tobeto.rentACar.services.abstracts.RentService;
import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentManager implements RentService {

    private final RentRepository rentRepository;

    public RentManager(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public void add(AddRentRequest request) {
        Rent rent = new Rent();
        rent.setPickUpDate(request.getPickUpDate());
        rent.setDropOffDate(request.getDropOffDate());
        rent.setCustomer(request.getCustomer());
        rent.setCar(request.getCar());
        rent.setPaymentMethod(request.getPay());
        rentRepository.save(rent);
    }

    @Override
    public void update(UpdateRentRequest request) {
        Rent rentToUpdate = rentRepository.findById(request.getId()).orElseThrow();
        rentToUpdate.setPickUpDate(request.getPickUpDate());
        rentToUpdate.setDropOffDate(request.getDropOffDate());
        rentRepository.save(rentToUpdate);
    }

    @Override
    public void delete(DeleteRentRequest request) {
        Rent rentToDelete = rentRepository.findById(request.getId()).orElseThrow();
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
        return rentRepository.findByPayMethodDto(payName);
    }
}
