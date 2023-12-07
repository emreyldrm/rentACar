package com.tobeto.rentACar.services.dtos.car.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @Positive(message = "ID must be a positive number")
    private int id;
    @NotBlank(message = "This field cannot be left blank")
    private String color;
    @Positive(message = "Daily Price must be a positive number")
    private BigDecimal dailyPrice;
    @Positive(message = "ID must be a positive number")
    private int situationId;
}
