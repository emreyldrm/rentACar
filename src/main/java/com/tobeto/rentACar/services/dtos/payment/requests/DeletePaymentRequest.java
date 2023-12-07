package com.tobeto.rentACar.services.dtos.payment.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePaymentRequest {
    @Positive(message = "ID must be a positive number")
    private int id;
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
