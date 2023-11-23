package com.tobeto.rentACar.services.dtos.customer.requests;

import lombok.Data;

@Data
public class DeleteCustomerRequest {

    private int id;
    private String fName;
    private String lName;
}
