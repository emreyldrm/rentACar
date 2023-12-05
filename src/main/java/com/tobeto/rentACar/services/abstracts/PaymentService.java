package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest request);
    void delete(DeletePaymentRequest request);
    List<GetListPaymentResponse> getByNameDto(String name);
    List<GetListPaymentResponse> getAllPaymentsDto();
}
