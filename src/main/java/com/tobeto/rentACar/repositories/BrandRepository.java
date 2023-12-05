package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    //Derived Query Methods => depends on function naming conventions
    //Derived Query only works with Entity
    List<Brand> findByNameStartingWith(String name);

    //Custom Query => written with JPQL
    @Query("Select new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) " +
            "FROM Brand b WHERE b.name LIKE ?1%")// ?1 equals :name
    List<GetListBrandResponse> findByNameStartingWithDto(String name);
    @Query("Select new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) " +
            "FROM Brand b")
    List<GetListBrandResponse> findAllBrandsDto();
}
