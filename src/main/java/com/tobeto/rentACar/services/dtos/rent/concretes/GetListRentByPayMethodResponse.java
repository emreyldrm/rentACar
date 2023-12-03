package com.tobeto.rentACar.services.dtos.rent.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentByPayMethodResponse {
    private String customerName;
    private String customerLastName;
    private String carBrandName;
    private String carModelName;
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private String payMethod;
}