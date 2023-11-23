package com.tobeto.rentACar.services.dtos.customer.requests;

import lombok.Data;

@Data
public class AddCustomerRequest {

    private String fName;
    private String lName;
    private String mail;
    private int licenseYear;

}
