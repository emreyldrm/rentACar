package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RentService;
import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentService rentService;

    public RentalsController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    private void add(@RequestBody AddRentRequest request){
        rentService.add(request);
    }
    @PutMapping
    private void update(@RequestBody UpdateRentRequest request){
        rentService.update(request);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteRentRequest request){
        rentService.delete(request);
    }

}
