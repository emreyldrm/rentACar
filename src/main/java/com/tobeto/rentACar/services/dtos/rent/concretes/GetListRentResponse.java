package com.tobeto.rentACar.services.dtos.rent.concretes;


import com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentResponse {
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private GetListCustomerResponse customer;
    private GetListCarResponse car;
    private GetListPaymentResponse payment;
}
