package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(DeleteBrandRequest request);
    List<Brand> getByName(String name);
    List<GetListBrandResponse> getByNameDto(String name);
    List<GetAllBrandsResponse> getAllBrandsDto();
}
