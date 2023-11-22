package com.tobeto.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "situations")
@Entity
@Getter
@Setter
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
