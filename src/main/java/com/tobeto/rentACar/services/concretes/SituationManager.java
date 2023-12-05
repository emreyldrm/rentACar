package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.repositories.SituationRepository;
import com.tobeto.rentACar.services.abstracts.SituationService;
import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GetListSituationResponse> getByNameDto(String name) {
        return situationRepository.findAll()
                .stream()
                .filter(situation -> situation.getSituationName().equals(name))
                .map(situation -> new GetListSituationResponse(situation.getSituationName()))
                .toList();
        //return situationRepository.findByNameDto(name);
    }

    @Override
    public List<GetListSituationResponse> getAllSituationsDto() {
        return situationRepository.findAllSituationsDto();
    }
}
