package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetAllSituationsResponse;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationByNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SituationRepository extends JpaRepository<Situation, Integer> {
    @Query("Select new com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationByNameResponse" +
            "(s.situationName) " +
            "FROM Situation s " +
            "WHERE s.situationName = :name")
    List<GetListSituationByNameResponse> findByNameDto(String name);
    @Query("Select new com.tobeto.rentACar.services.dtos.situation.concretes.GetAllSituationsResponse" +
            "(s.situationName) " +
            "FROM Situation s")
    List<GetAllSituationsResponse> findAllSituationsDto();
}
