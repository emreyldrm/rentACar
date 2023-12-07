package com.tobeto.rentACar.services.dtos.car.requests;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private BigDecimal dailyPrice;
    private int brandId;
    private int situationId;

}
