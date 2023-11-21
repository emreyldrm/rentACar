package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "rentals")
@Entity
public class Rent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "pick_up_date")
    private LocalDateTime pickUpDate;
    @Column(name = "drop_off_date")
    private LocalDateTime dropOffDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentMethod paymentMethod;
}
