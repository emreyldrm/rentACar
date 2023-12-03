package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rent;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByBrandResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByCustomerResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByPayMethodResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByCustomerResponse" +
            "(cs.fName, cs.lName, b.name, c.modelName, r.pickUpDate, r.dropOffDate) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN c.brand b " +
            "WHERE cs.fName = :customerName")
    List<GetListRentByCustomerResponse> findByCustomerDto(String customerName);
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByBrandResponse" +
            "(cs.fName, cs.lName, b.name, c.modelName, r.pickUpDate, r.dropOffDate) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN c.brand b " +
            "WHERE b.name = :brandName")
    List<GetListRentByBrandResponse> findByBrandDto(String brandName);
    @Query("Select new com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByPayMethodResponse" +
            "(cs.fName, cs.lName, b.name, c.modelName, r.pickUpDate, r.dropOffDate, p.paymentName) " +
            "FROM Rent r " +
            "JOIN r.customer cs " +
            "JOIN r.car c " +
            "JOIN c.brand b " +
            "JOIN r.paymentMethod p " +
            "WHERE p.paymentName = :payName")
    List<GetListRentByPayMethodResponse> findByPayMethodDto(String payName);
}
