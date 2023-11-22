package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Situation;
import com.tobeto.rentACar.repositories.SituationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/situations")
public class SituationController {
    public final SituationRepository situationRepository;

    public SituationController(SituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    @GetMapping
    public List<Situation> getAll(){
        List<Situation> situations = situationRepository.findAll();
        return situations;
    }
    @GetMapping("{id}")
    public Situation getById(@PathVariable int id){
        return situationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Situation situation){
        situationRepository.save(situation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Situation situationToDelete = situationRepository.findById(id).orElseThrow();
        situationRepository.delete(situationToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Situation situation){
        Situation situationToUpdate = situationRepository.findById(id).orElseThrow();
        situationToUpdate.setSituationName(situation.getSituationName());
        situationRepository.save(situationToUpdate);

    }
}
