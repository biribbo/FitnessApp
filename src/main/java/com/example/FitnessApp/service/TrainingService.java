package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.CardioTrainingDTO;
import com.example.FitnessApp.dto.StrengthTrainingDTO;
import com.example.FitnessApp.model.training.CardioTraining;
import com.example.FitnessApp.model.training.StrengthTraining;
import com.example.FitnessApp.model.training.Training;
import com.example.FitnessApp.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<StrengthTrainingDTO> readAllStrengthTrainings() {
        List<Training> result = trainingRepository.findAll();
        return result.stream()
                .filter(training -> training instanceof StrengthTraining)
                .map(training -> new StrengthTrainingDTO((StrengthTraining) training))
                .collect(Collectors.toList());
    }

    public List<CardioTrainingDTO> readAllCardioTrainings() {
        List<Training> result = trainingRepository.findAll();
        return result.stream()
                .filter(training -> training instanceof CardioTraining)
                .map(training -> new CardioTrainingDTO((CardioTraining) training))
                .collect(Collectors.toList());
    }
}
