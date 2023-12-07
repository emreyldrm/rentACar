package com.tobeto.rentACar.services.dtos.rent.abstracts;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentRequest {
    @Future(message = "Past rental dates cannot be used.")
    private LocalDateTime pickUpDate;
    @Future(message = "Past rental dates cannot be used.")
    private LocalDateTime dropOffDate;
    @Positive(message = "ID must be a positive number")
    private int customerId;
    @Positive(message = "ID must be a positive number")
    private int carId;
    @Positive(message = "ID must be a positive number")
    private int paymentId;
}
