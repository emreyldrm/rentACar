package com.tobeto.rentACar.services.dtos.rent.abstracts;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateRentRequest {
    private int id;
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
}
