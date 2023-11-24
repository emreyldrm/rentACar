package com.tobeto.rentACar.services.dtos.rent.abstracts;

import com.tobeto.rentACar.entities.Car;
import lombok.Data;

@Data
public class DeleteRentRequest {
    private int id;
    private Car car;

}
