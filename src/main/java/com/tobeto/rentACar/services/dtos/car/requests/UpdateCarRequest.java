package com.tobeto.rentACar.services.dtos.car.requests;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateCarRequest {
    private int id;
    private String color;
    private BigDecimal dailyPrice;
    private int situationId;
}
