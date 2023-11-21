package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "situations")
@Entity
public class Situation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "situation_name")
    private String situationName;
    @OneToMany(mappedBy = "situation")
    private List<Car> cars;

}
