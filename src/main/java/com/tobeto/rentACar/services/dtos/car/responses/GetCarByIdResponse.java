package com.tobeto.rentACar.services.dtos.car.responses;

import com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByIdResponse {
    private int id;
    private int modelYear;
    private String modelName;
    private String situation;
    private BigDecimal dailyPrice;
    private GetListBrandResponse brand;
}
