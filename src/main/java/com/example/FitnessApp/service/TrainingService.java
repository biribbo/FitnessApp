package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.CardioExerciseDTO;
import com.example.FitnessApp.dto.CardioTrainingDTO;
import com.example.FitnessApp.dto.StrengthExerciseDTO;
import com.example.FitnessApp.dto.StrengthTrainingDTO;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import com.example.FitnessApp.model.training.CardioTraining;
import com.example.FitnessApp.model.training.StrengthTraining;
import com.example.FitnessApp.model.training.Training;
import com.example.FitnessApp.repository.TrainingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final ExerciseService exerciseService;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, ExerciseService exerciseService) {
        this.trainingRepository = trainingRepository;
        this.exerciseService = exerciseService;
    }

    public List<StrengthTrainingDTO> readAllStrengthTrainings() {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        List<Training> result = trainingRepository.findAllByUserId(user);
        for (Training training : result) {
            System.out.println(((StrengthTraining) training).getExercises());
        }
        return result.stream()
                .filter(training -> training instanceof StrengthTraining)
                .map(training -> new StrengthTrainingDTO((StrengthTraining) training))
                .collect(Collectors.toList());
    }

    public List<CardioTrainingDTO> readAllCardioTrainings() {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Training> result = trainingRepository.findAllByUserId(user);
        return result.stream()
                .filter(training -> training instanceof CardioTraining)
                .map(training -> new CardioTrainingDTO((CardioTraining) training))
                .collect(Collectors.toList());
    }
@Transactional
    public StrengthTrainingDTO createStrengthTraining(StrengthTrainingDTO strengthTrainingDTO) {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("training parsing began");
        int exercisesCount = strengthTrainingDTO.getExercises().size();
        int totalSets = strengthTrainingDTO.getExercises().stream()
                .mapToInt(StrengthExerciseDTO::getSets).sum();
        int totalReps = strengthTrainingDTO.getExercises().stream()
                .mapToInt(exercise -> exercise.getReps() * exercise.getSets()).sum();
        double totalWeight = strengthTrainingDTO.getExercises().stream()
                .mapToDouble(StrengthExerciseDTO::getWeight).sum();
    strengthTrainingDTO.setExercisesCount(exercisesCount);
    strengthTrainingDTO.setReps(totalReps);
    strengthTrainingDTO.setSets(totalSets);
    strengthTrainingDTO.setWeight(totalWeight);
    strengthTrainingDTO.setUser(user);
    StrengthTraining strengthTraining = strengthTrainingDTO.toModel();
    Set<StrengthExercise> exercises = strengthTrainingDTO.getExercises().stream()
            .map(dto -> {
                exerciseService.calculateOneRepMax(dto);
                StrengthExercise exercise = dto.toModel();
                exercise.setTraining(strengthTraining);  // Link the exercise to the training
                return exercise;
            })
            .collect(Collectors.toSet());
    strengthTraining.setExercises(exercises);
        trainingRepository.save(strengthTraining);

        return new StrengthTrainingDTO(strengthTraining);
    }

    public CardioTrainingDTO createCardioTraining(CardioTrainingDTO cardioTrainingDTO) {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        double totalDistance = cardioTrainingDTO.getExercises().stream()
                .mapToDouble(CardioExerciseDTO::getDistance).sum();
        double tempo = totalDistance / cardioTrainingDTO.getDuration().toHours();
        cardioTrainingDTO.setDistance(totalDistance);
        cardioTrainingDTO.setTempo(tempo);
        cardioTrainingDTO.setUser(user);
        CardioTraining cardioTraining = cardioTrainingDTO.toModel();
        trainingRepository.save(cardioTraining);
        return new CardioTrainingDTO(cardioTraining);
    }
}