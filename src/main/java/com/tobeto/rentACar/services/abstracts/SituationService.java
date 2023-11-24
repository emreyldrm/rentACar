package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;

public interface SituationService {

    void add(AddSituationRequest request);
    void update(UpdateSituationRequest request);
    void delete(DeleteSituationRequest request);
}
