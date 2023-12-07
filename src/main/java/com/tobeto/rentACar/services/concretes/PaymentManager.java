package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.repositories.PaymentMethodRepository;
import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PaymentManager implements PaymentService {
    private final PaymentMethodRepository paymentRepository;

    public PaymentManager(PaymentMethodRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request) {
        if(paymentRepository.existsPaymentMethodByPaymentName(request.getName()))
            throw new RuntimeException("Add Error : This payment is already exists!");

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentName(request.getName());
        paymentRepository.save(paymentMethod);
    }

    @Override
    public void update(UpdatePaymentRequest request) {
        PaymentMethod payMethodToUpdate = paymentRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Update Error : There is no payment with this id!"));
        payMethodToUpdate.setPaymentName(request.getName());
        paymentRepository.save(payMethodToUpdate);

    }

    @Override
    public void delete(DeletePaymentRequest request) {
        PaymentMethod payMethodToDelete = paymentRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Delete Error : There is no payment with this id!"));
        paymentRepository.delete(payMethodToDelete);

    }

    @Override
    public List<GetListPaymentResponse> getByNameDto(String name) {
        return paymentRepository.findByNameDto(name);
    }

    @Override
    public List<GetListPaymentResponse> getAllPaymentsDto() {
        return paymentRepository.findAllPaymentsDto()
                .stream()
                .sorted(Comparator.comparing(GetListPaymentResponse::getName))
                .toList();
    }

    @Override
    public PaymentMethod getById(int id) {
        return paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no payment with this id!"));
    }
}
