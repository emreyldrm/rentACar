package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentByNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {

    @Query("Select new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentByNameResponse" +
            "(p.paymentName) " +
            "FROM PaymentMethod p " +
            "WHERE p.paymentName = :name")
    List<GetListPaymentByNameResponse> findByNameDto(String name);
    @Query("Select new com.tobeto.rentACar.services.dtos.payment.responses.GetAllPaymentsResponse" +
            "(p.paymentName) " +
            "FROM PaymentMethod p")
    List<GetAllPaymentsResponse> findAllPaymentsDto();
}
