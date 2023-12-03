package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarByModelYearResponse;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarBySituationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    //Derived Query Method
    List<Car> findByModelYear(int year);

    //Custom Query Methods
    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetListCarByModelYearResponse" +
            "(c.modelYear, c.modelName, b.name) " +
            "FROM Car c " +
            "JOIN c.brand b " +
            "WHERE c.modelYear = :modelYear")
    List<GetListCarByModelYearResponse> findByModelYearDto(int modelYear);
    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetListCarBySituationResponse" +
            "(c.modelYear, b.name, c.modelName, s.situationName) " +
            "FROM Car c " +
            "JOIN c.brand b " +
            "JOIN c.situation s " +
            "WHERE s.situationName = :situation")
    List<GetListCarBySituationResponse> findBySituationDto(String situation);

    @Query("Select new com.tobeto.rentACar.services.dtos.car.responses.GetAllCarsResponse" +
            "(b.name, c.modelName, c.modelYear, c.dailyPrice) " +
            "FROM Car c " +
            "JOIN c.brand b")
    List<GetAllCarsResponse> findAllCarsDto();

}
