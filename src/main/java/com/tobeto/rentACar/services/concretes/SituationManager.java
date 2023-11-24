package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.repositories.SituationRepository;
import com.tobeto.rentACar.services.abstracts.SituationService;
import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;
import org.springframework.stereotype.Service;

@Service
public class SituationManager implements SituationService {
    private final SituationRepository situationRepository;

    public SituationManager(SituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    @Override
    public void add(AddSituationRequest request) {
        Situation situation = new Situation();
        situation.setSituationName(request.getName());
        situationRepository.save(situation);

    }

    @Override
    public void update(UpdateSituationRequest request) {
        Situation situationToUpdate = situationRepository.findById(request.getId()).orElseThrow();
        situationToUpdate.setSituationName(request.getName());
        situationRepository.save(situationToUpdate);

    }

    @Override
    public void delete(DeleteSituationRequest request) {
        Situation situationToDelete = situationRepository.findById(request.getId()).orElseThrow();
        situationRepository.delete(situationToDelete);

    }
}
