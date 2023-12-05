package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse;
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

    @GetMapping
    private List<Car> getByModelYear(@RequestParam int year){
        return carService.getByModelYear(year);
    }
    @GetMapping("dto/modelYear")
    private List<GetListCarResponse> getByModelYearDto(@RequestParam int modelYear){
        return carService.getByModelYearDto(modelYear);
    }
    @GetMapping("dto/situation")
    private List<GetListCarResponse> getBySituationDto(@RequestParam String situation){
        return carService.getBySituationDto(situation);
    }
    @GetMapping("allCars")
    private List<GetListCarResponse> getAllCarsDto(){
        return carService.getAllCarsDto();
    }
}
