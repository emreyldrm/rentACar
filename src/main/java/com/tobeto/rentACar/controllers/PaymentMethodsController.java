package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.repositories.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payMethods")
public class PaymentMethodsController {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodsController(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping
    public List<PaymentMethod> getAll(){
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        return paymentMethods;
    }
    @GetMapping("{id}")
    public PaymentMethod getById(@PathVariable int id){
        return paymentMethodRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentMethod paymentMethod){
        paymentMethodRepository.save(paymentMethod);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        PaymentMethod paymentMethodToDelete = paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodRepository.delete(paymentMethodToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody PaymentMethod paymentMethod){
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodToUpdate.setPaymentName(paymentMethod.getPaymentName());
        paymentMethodRepository.save(paymentMethodToUpdate);

    }
}
