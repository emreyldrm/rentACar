package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {

    @Query("Select new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse" +
            "(p.paymentName) " +
            "FROM PaymentMethod p " +
            "WHERE p.paymentName = :name")
    List<GetListPaymentResponse> findByNameDto(String name);
    @Query("Select new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse" +
            "(p.paymentName) " +
            "FROM PaymentMethod p")
    List<GetListPaymentResponse> findAllPaymentsDto();
    boolean existsPaymentMethodByPaymentName(String name);
}
