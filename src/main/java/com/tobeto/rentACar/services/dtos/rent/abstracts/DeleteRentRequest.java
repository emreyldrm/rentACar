package com.tobeto.rentACar.services.dtos.rent.abstracts;


import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRentRequest {
    @Positive(message = "ID must be a positive number")
    private int id;
    @Positive(message = "ID must be a positive number")
    private int carId;

}
