package com.tobeto.rentACar.services.dtos.brand.requests;

import lombok.Data;

@Data
public class DeleteBrandRequest {
    private int id;
    private String name;
}
