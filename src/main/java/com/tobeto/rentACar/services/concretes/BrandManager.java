package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    public final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {
        if(request.getName().length() < 3)
            throw new RuntimeException("Add Error: Brand name cannot be less than 3 digits!");
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Update Error : There is no brand with this id!"));
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Delete Error : There is no brand with this id!"));
        brandRepository.delete(brandToDelete);

    }

    @Override
    public List<Brand> getByName(String name) {
        return brandRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListBrandResponse> getByNameDto(String name) {
        return brandRepository.findByNameStartingWithDto(name);
    }

    @Override
    public List<GetListBrandResponse> getAllBrandsDto() {
        //with STREAM API
        return brandRepository.findAllBrandsDto().stream()
                .sorted(Comparator.comparing(GetListBrandResponse::getName))
                .toList();
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no brand with this id!"));
    }
}
