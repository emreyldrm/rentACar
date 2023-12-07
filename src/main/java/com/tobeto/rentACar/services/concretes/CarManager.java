package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.SituationService;
import com.tobeto.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;
    private final SituationService situationService;

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setModelYear(request.getModelYear());
        car.setModelName(request.getModelName());
        car.setDailyPrice(request.getDailyPrice());
        car.setColor("White");
        Brand brand = brandService.getById(request.getBrandId());
        car.setBrand(brand);
        Situation situation = situationService.getById(request.getSituationId());
        car.setSituation(situation);
        carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Update Error : There is no car with this id!"));
        carToUpdate.setDailyPrice(request.getDailyPrice());
        carToUpdate.setColor(request.getColor());
        Situation situation = situationService.getById(request.getSituationId());
        carToUpdate.setSituation(situation);
        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Delete Error : There is no car with this id!"));
        carRepository.delete(carToDelete);

    }

    @Override
    public List<Car> getByModelYear(int year) {
        return carRepository.findByModelYear(year);
    }

    @Override
    public List<GetListCarResponse> getByModelYearDto(int modelYear) {
        return carRepository.findByModelYearDto(modelYear);
    }

    @Override
    public List<GetListCarResponse> getBySituationDto(String situation) {
        return carRepository.findBySituationDto(situation);
    }

    @Override
    public List<GetListCarResponse> getAllCarsDto() {
        return carRepository.findAllCarsDto()
                .stream()
                .filter(car -> car.getDailyPrice().compareTo(new BigDecimal("1000")) > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no car with this id!"));
    }
}
