package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentByNameResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest request);
    void delete(DeletePaymentRequest request);
    List<GetListPaymentByNameResponse> getByNameDto(String name);
    List<GetAllPaymentsResponse> getAllPaymentsDto();
}
