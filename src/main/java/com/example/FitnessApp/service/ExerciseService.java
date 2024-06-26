package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.CardioExerciseDTO;
import com.example.FitnessApp.dto.StrengthExerciseDTO;
import com.example.FitnessApp.model.exercise.CardioExercise;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import com.example.FitnessApp.model.training.Training;
import com.example.FitnessApp.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void calculateOneRepMax(StrengthExerciseDTO strengthExerciseDTO) {
        System.out.println("exercise parsing began");
        int reps = strengthExerciseDTO.getReps() + 10 - strengthExerciseDTO.getRpe();
        double weight = strengthExerciseDTO.getWeight();
        double brzyckiFormula = weight / (1.0278 - 0.0278 * reps);
        double epleysFormula = weight * (1 + 0.0333 * reps);
        double landersFormula = (100 * weight)/(101.3 - 2.67123 * reps);
        double lombardisFormula = weight * Math.pow(reps, 0.1);
        double arithmeticMean = (brzyckiFormula + epleysFormula + landersFormula + lombardisFormula) / 4;
        strengthExerciseDTO.setEstimatedOneRepMax(arithmeticMean);
        System.out.println("exercise parsing finished");
    }

    public void createExercise(Object exerciseDTO) {
        if (exerciseDTO instanceof StrengthExerciseDTO) {
            StrengthExercise exercise = ((StrengthExerciseDTO) exerciseDTO).toModel();
            exerciseRepository.save(exercise);
        } else if (exerciseDTO instanceof CardioExerciseDTO) {
            CardioExercise exercise = ((CardioExerciseDTO) exerciseDTO).toModel();
            exerciseRepository.save(exercise);
        }
    }
}