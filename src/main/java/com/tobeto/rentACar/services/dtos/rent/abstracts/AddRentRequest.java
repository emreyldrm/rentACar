package com.tobeto.rentACar.services.dtos.rent.abstracts;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddRentRequest {
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private int customerId;
    private int carId;
    private int paymentId;
}
