package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
