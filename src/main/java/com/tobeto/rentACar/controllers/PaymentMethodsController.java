package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/payMethods")
public class PaymentMethodsController {
    private final PaymentService paymentService;

    public PaymentMethodsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    private void add(@RequestBody AddPaymentRequest request){
        paymentService.add(request);
    }
    @PutMapping
    private void update(@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
    }
    @DeleteMapping
    private void delete(@RequestBody DeletePaymentRequest request){
        paymentService.delete(request);
    }
}
