package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    private List<Car> getAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    @GetMapping("{id}")
    private Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    private void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setModelName(car.getModelName());
        carToUpdate.setDailyPrice(car.getDailyPrice());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setSituation(car.getSituation());
        carRepository.save(carToUpdate);

    }
}
