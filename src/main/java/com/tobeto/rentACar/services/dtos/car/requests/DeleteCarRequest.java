package com.tobeto.rentACar.services.dtos.car.requests;

import lombok.Data;

@Data
public class DeleteCarRequest {
    private int id;
    private String modelName;

}
