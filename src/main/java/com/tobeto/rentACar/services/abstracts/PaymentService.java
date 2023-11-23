package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;

public interface PaymentService {
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest request);
    void delete(DeletePaymentRequest request);
}
