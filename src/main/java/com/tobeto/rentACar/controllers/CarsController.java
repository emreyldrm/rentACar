package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    private void add(@RequestBody AddCarRequest request){
        carService.add(request);
    }
    @PutMapping
    private void update(@RequestBody UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping("{id}")
    private void delete(@RequestBody DeleteCarRequest request){
        carService.delete(request);
    }
}
