package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/brands")
public class BrandsController {

    public final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping
    private void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }
    @PutMapping("{id}")
    private void update(@RequestBody UpdateBrandRequest request){
        brandService.update(request);
    }
    @DeleteMapping("{id}")
    private void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
    }


}
