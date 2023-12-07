package com.tobeto.rentACar.services.dtos.situation.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class DeleteSituationRequest {
    private int id;
    private String name;
}
