package com.tobeto.rentACar.services.dtos.situation.abstracts;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSituationRequest {
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
