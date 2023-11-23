package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.repositories.PaymentMethodRepository;
import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager implements PaymentService {
    private final PaymentMethodRepository paymentRepository;

    public PaymentManager(PaymentMethodRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentName(request.getName());
        paymentRepository.save(paymentMethod);
    }

    @Override
    public void update(UpdatePaymentRequest request) {
        PaymentMethod payMethodToUpdate = paymentRepository.findById(request.getId()).orElseThrow();
        payMethodToUpdate.setPaymentName(request.getName());
        paymentRepository.save(payMethodToUpdate);

    }

    @Override
    public void delete(DeletePaymentRequest request) {
        PaymentMethod payMethodToDelete = paymentRepository.findById(request.getId()).orElseThrow();
        paymentRepository.delete(payMethodToDelete);

    }
}
