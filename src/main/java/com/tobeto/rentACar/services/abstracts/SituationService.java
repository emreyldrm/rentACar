package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetAllSituationsResponse;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationByNameResponse;

import java.util.List;

public interface SituationService {

    void add(AddSituationRequest request);
    void update(UpdateSituationRequest request);
    void delete(DeleteSituationRequest request);
    List<GetListSituationByNameResponse> getByNameDto(String name);
    List<GetAllSituationsResponse> getAllSituationsDto();
}
