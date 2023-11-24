package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.SituationService;
import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/situations")
public class SituationController {
    private final SituationService situationService;

    public SituationController(SituationService situationService) {
        this.situationService = situationService;
    }

    @PostMapping
    private void add(@RequestBody AddSituationRequest request){
        situationService.add(request);
    }
    @PutMapping
    private void update(@RequestBody UpdateSituationRequest request){
        situationService.update(request);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteSituationRequest request){
        situationService.delete(request);
    }


}
