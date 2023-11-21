package com.tobeto.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Car> cars;

}
