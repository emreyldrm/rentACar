package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setModelYear(request.getModelYear());
        car.setModelName(request.getModelName());
        car.setDailyPrice(request.getDailyPrice());
        car.setBrand(request.getBrand());
        car.setSituation(request.getSituation());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        carToUpdate.setDailyPrice(request.getDailyPrice());
        carToUpdate.setColor(request.getColor());
        carToUpdate.setSituation(request.getSituation());
        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow();
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
}
