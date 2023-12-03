package com.tobeto.rentACar.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerByFirstNameResponse {
    private String fName;
    private String lName;
    private int age;
    private int licenseYear;
}
