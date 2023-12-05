package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rent;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse" +
            "(r.pickUpDate, r.dropOffDate," +
            " new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse(cs.fName, cs.lName, cs.age)," +
            " new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse(c.modelYear, c.modelName, s.situationName, c.dailyPrice, " +
            " new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ), " +
            " new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse(p.paymentName) ) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN r.paymentMethod p " +
            "JOIN c.situation s " +
            "JOIN c.brand b " +
            "WHERE cs.fName = :customerName")
    List<GetListRentResponse> findByCustomerDto(String customerName);
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse" +
            "(r.pickUpDate, r.dropOffDate," +
            " new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse(cs.fName, cs.lName, cs.age)," +
            " new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse(c.modelYear, c.modelName, s.situationName, c.dailyPrice, " +
            " new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ), " +
            " new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse(p.paymentName) ) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN r.paymentMethod p " +
            "JOIN c.situation s " +
            "JOIN c.brand b " +
            "WHERE b.name = :brandName")
    List<GetListRentResponse> findByBrandDto(String brandName);
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse" +
            "(r.pickUpDate, r.dropOffDate," +
            " new com.tobeto.rentACar.services.dtos.customer.responses.GetListCustomerResponse(cs.fName, cs.lName, cs.age)," +
            " new com.tobeto.rentACar.services.dtos.car.responses.GetListCarResponse(c.modelYear, c.modelName, s.situationName, c.dailyPrice, " +
            " new com.tobeto.rentACar.services.dtos.brand.responses.GetListBrandResponse(b.name) ), " +
            " new com.tobeto.rentACar.services.dtos.payment.responses.GetListPaymentResponse(p.paymentName) ) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN r.paymentMethod p " +
            "JOIN c.situation s " +
            "JOIN c.brand b " +
            "WHERE p.paymentName = :payName")
    List<GetListRentResponse> findByPayMethodDto(String payName);
}
