package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.PaymentService;
import com.tobeto.rentACar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/payMethods")
public class PaymentMethodsController {
    private final PaymentService paymentService;

    public PaymentMethodsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    private void add(@RequestBody @Valid AddPaymentRequest request){
        paymentService.add(request);
    }
    @PutMapping
    private void update(@RequestBody @Valid UpdatePaymentRequest request){
        paymentService.update(request);
    }
    @DeleteMapping
    private void delete(@RequestBody @Valid DeletePaymentRequest request){
        paymentService.delete(request);
    }
    @GetMapping("dto/payName")
    private List<GetListPaymentResponse> getByPayNameDto(@RequestParam String name){
        return paymentService.getByNameDto(name);
    }
    @GetMapping("allPayMethods")
    private List<GetListPaymentResponse> getAllPaymentsDto(){
        return paymentService.getAllPaymentsDto();
    }
}
