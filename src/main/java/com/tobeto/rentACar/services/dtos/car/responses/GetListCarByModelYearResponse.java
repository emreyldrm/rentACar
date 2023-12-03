package com.tobeto.rentACar.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarByModelYearResponse {
    private int modelYear;
    private String modelName;
    private String brand;

}
