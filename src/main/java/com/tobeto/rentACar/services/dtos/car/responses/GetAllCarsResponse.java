package com.tobeto.rentACar.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
    private String brand;
    private String modelName;
    private int modelYear;
    private BigDecimal dailyPrice;
}
