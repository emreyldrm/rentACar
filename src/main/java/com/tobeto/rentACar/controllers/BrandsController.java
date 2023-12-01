package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandService brandService;

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
    @GetMapping
    private List<Brand> getByName(@RequestParam String name){
        return brandService.getByName(name);
    }
    @GetMapping("dto")
    private List<GetListBrandResponse> getByNameDto(@RequestParam String name){
        return brandService.getByNameDto(name);
    }
    @GetMapping("allBrands")
    private List<GetAllBrandsResponse> getAllBrandsDto(){
        return brandService.getAllBrandsDto();
    }


}
