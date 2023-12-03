package com.tobeto.rentACar.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarBySituationResponse {
    private int modelYear;
    private String brand;
    private String modelName;
    private String situation;
}
