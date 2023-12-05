package com.tobeto.rentACar.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerContactResponse {
    private String phone;
    private String mail;
    private GetListCustomerResponse customer;
}
