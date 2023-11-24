package com.tobeto.rentACar.services.dtos.rent.abstracts;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.entities.PaymentMethod;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddRentRequest {
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private Customer customer;
    private Car car;
    private PaymentMethod pay;
}
