package com.tobeto.rentACar.services.dtos.payment.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
