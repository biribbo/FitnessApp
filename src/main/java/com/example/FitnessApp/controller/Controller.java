package com.example.FitnessApp.controller;

import com.example.FitnessApp.dto.CardioTrainingDTO;
import com.example.FitnessApp.dto.StrengthTrainingDTO;
import com.example.FitnessApp.service.ExerciseService;
import com.example.FitnessApp.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class Controller {
    private final TrainingService trainingService;
    private final ExerciseService exerciseService;

    @Autowired
    public Controller(TrainingService trainingService, ExerciseService exerciseService) {
        this.trainingService = trainingService;
        this.exerciseService = exerciseService;
    }

    @GetMapping(path = "/strength")
    ResponseEntity<List<StrengthTrainingDTO>> getAllStrengthTrainings() {
        return ResponseEntity.ok(trainingService.readAllStrengthTrainings());
    }

    @GetMapping(path = "/cardio")
    ResponseEntity<List<CardioTrainingDTO>> getAllCardioTrainings() {
        return ResponseEntity.ok(trainingService.readAllCardioTrainings());
    }

    @PostMapping(path = "/strength")
    ResponseEntity<StrengthTrainingDTO> newStrengthTraining(@RequestBody StrengthTrainingDTO strengthTrainingDTO) {
        StrengthTrainingDTO created = trainingService.createStrengthTraining(strengthTrainingDTO);
        return ResponseEntity.created(URI.create("/strength/" + created.getId())).body(created);
    }

    @PostMapping(path = "/cardio")
    ResponseEntity<CardioTrainingDTO> newCardioTraining(@RequestBody CardioTrainingDTO cardioTrainingDTO) {
        cardioTrainingDTO.getExercises().forEach(exerciseService::createExercise);
        CardioTrainingDTO created = trainingService.createCardioTraining(cardioTrainingDTO);
        return ResponseEntity.created(URI.create("/strength/" + created.getId())).body(created);
    }
}