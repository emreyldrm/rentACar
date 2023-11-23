package com.tobeto.rentACar.services.dtos.car.requests;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.entities.Situation;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private BigDecimal dailyPrice;
    private Brand brand;
    private Situation situation;

}
