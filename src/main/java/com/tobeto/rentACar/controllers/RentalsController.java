package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Rent;
import com.tobeto.rentACar.repositories.RentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    public final RentRepository rentRepository;

    public RentalsController(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @GetMapping
    public List<Rent> getAll(){
        List<Rent> rents = rentRepository.findAll();
        return rents;
    }
    @GetMapping("{id}")
    public Rent getById(@PathVariable int id){
        return rentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rent rent){
        rentRepository.save(rent);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rent rentToDelete = rentRepository.findById(id).orElseThrow();
        rentRepository.delete(rentToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Rent rent){
        Rent rentToUpdate = rentRepository.findById(id).orElseThrow();
        rentToUpdate.setPickUpDate(rent.getPickUpDate());
        rentToUpdate.setDropOffDate(rent.getDropOffDate());
        rentToUpdate.setCustomer(rent.getCustomer());
        rentToUpdate.setCar(rent.getCar());
        rentToUpdate.setPaymentMethod(rent.getPaymentMethod());
        rentRepository.save(rentToUpdate);

    }
}
