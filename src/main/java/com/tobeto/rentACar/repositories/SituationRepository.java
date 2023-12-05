package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SituationRepository extends JpaRepository<Situation, Integer> {
    @Query("Select new com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationResponse" +
            "(s.situationName) " +
            "FROM Situation s " +
            "WHERE s.situationName = :name")
    List<GetListSituationResponse> findByNameDto(String name);
    @Query("Select new com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationResponse" +
            "(s.situationName) " +
            "FROM Situation s")
    List<GetListSituationResponse> findAllSituationsDto();
}
