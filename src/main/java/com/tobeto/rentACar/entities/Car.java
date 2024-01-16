package com.tobeto.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "cars")
@Entity
@Getter
@Setter
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "daily_price")
    private BigDecimal dailyPrice;
    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "brand_id") //many to one hangi tablodaysan onunla ilgili sütunu belirt.
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "situation_id")
    private Situation situation;

    @OneToMany(mappedBy = "car")// one to many List<>, mappedBy =>
    @JsonIgnore
    private List<Rent> rents;
}
