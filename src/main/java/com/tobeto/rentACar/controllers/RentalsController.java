package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RentService;
import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByBrandResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByCustomerResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByPayMethodResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @GetMapping("dto/customer")
    private List<GetListRentByCustomerResponse> getByCustomerName(@RequestParam String customerName){
        return rentService.getByCustomerName(customerName);
    }
    @GetMapping("dto/brand")
    private List<GetListRentByBrandResponse> getByBrandName(@RequestParam String brandName){
        return rentService.getByBrandName(brandName);
    }
    @GetMapping("dto/payment")
    private List<GetListRentByPayMethodResponse> getByPayMethod(@RequestParam String payName){
        return rentService.getByPayMethod(payName);
    }

}
