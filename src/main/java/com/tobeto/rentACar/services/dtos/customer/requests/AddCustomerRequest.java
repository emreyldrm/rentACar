package com.tobeto.rentACar.services.dtos.customer.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = "This field cannot be left blank")
    private String fName;
    @NotBlank(message = "This field cannot be left blank")
    private String lName;
    @NotBlank(message = "This field cannot be left blank")
    private String mail;
    @Min(value=2, message = "Driving license must be at least 2 years")
    private int licenseYear;

}
