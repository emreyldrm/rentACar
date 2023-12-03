package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.SituationService;
import com.tobeto.rentACar.services.dtos.situation.abstracts.AddSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.DeleteSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.abstracts.UpdateSituationRequest;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetAllSituationsResponse;
import com.tobeto.rentACar.services.dtos.situation.concretes.GetListSituationByNameResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @GetMapping("dto/paymentName")
    private List<GetListSituationByNameResponse> getByNameDto(@RequestParam String name){
        return situationService.getByNameDto(name);
    }
    @GetMapping("allSituations")
    private List<GetAllSituationsResponse> getByNameDto(){
        return situationService.getAllSituationsDto();
    }
}
