package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarByModelYearResponse;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarBySituationResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);

    List<Car> getByModelYear(int year);
    List<GetListCarByModelYearResponse> getByModelYearDto(int modelYear);
    List<GetListCarBySituationResponse> getBySituationDto(String situation);
    List<GetAllCarsResponse> getAllCarsDto();
}
