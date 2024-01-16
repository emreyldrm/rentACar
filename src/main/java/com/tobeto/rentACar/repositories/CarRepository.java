package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    //Derived Query Method
    List<Car> findByModelYear(int year);

    //Custom Query Methods
    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse" +
            "(c.id, c.modelYear, c.modelName, s.situationName, c.dailyPrice, new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ) " +
            "FROM Car c " +
            "JOIN c.brand b " +
            "JOIN c.situation s " +
            "WHERE c.modelYear = :modelYear")
    List<GetListCarResponse> findByModelYearDto(int modelYear);
    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse" +
            "(c.id, c.modelYear, c.modelName, s.situationName, c.dailyPrice, new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ) " +
            "FROM Car c " +
            "JOIN c.brand b " +
            "JOIN c.situation s " +
            "WHERE s.situationName = :situation")
    List<GetListCarResponse> findBySituationDto(String situation);

    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse" +
            "(c.id, c.modelYear, c.modelName, s.situationName, c.dailyPrice, new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ) " +
            "FROM Car c " +
            "JOIN c.brand b " +
            "JOIN c.situation s ")
    List<GetListCarResponse> findAllCarsDto();

}
