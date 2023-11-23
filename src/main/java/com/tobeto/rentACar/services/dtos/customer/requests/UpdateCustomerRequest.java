package com.tobeto.rentACar.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private int id;
    private String phone;
    private String mail;

}
