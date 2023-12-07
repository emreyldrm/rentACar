package com.tobeto.rentACar.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
