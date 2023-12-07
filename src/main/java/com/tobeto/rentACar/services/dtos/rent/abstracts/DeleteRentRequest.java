package com.tobeto.rentACar.services.dtos.rent.abstracts;


import lombok.Data;

@Data
public class DeleteRentRequest {
    private int id;
    private int carId;

}
