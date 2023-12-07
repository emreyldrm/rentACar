package com.tobeto.rentACar.services.dtos.car.requests;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @Min(value=2015, message = "The model year could be at least 2015.")
    private int modelYear;
    @NotBlank(message = "This field cannot be left blank")
    private String modelName;
    @Positive(message = "Daily Price must be a positive number")
    private BigDecimal dailyPrice;
    @Positive(message = "ID must be a positive number")
    private int brandId;
    @Positive(message = "ID must be a positive number")
    private int situationId;

}
