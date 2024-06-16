package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.CardioExerciseDTO;
import com.example.FitnessApp.dto.CardioTrainingDTO;
import com.example.FitnessApp.dto.StrengthExerciseDTO;
import com.example.FitnessApp.dto.StrengthTrainingDTO;
import com.example.FitnessApp.model.training.CardioTraining;
import com.example.FitnessApp.model.training.StrengthTraining;
import com.example.FitnessApp.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainingServiceTest {

    @Mock
    private TrainingRepository trainingRepository;

    @InjectMocks
    private TrainingService trainingService;

    @Test
    void testCreateStrengthTraining() {
        // Given
        StrengthExerciseDTO exercise1 = new StrengthExerciseDTO("Squat", "Barbell", "Instructions", "glutes", 8, 3, 10, 100.0);
        StrengthExerciseDTO exercise2 = new StrengthExerciseDTO("Bench Press", "Barbell", "Instructions", "chest", 7, 4, 8, 80.0);

        HashSet<StrengthExerciseDTO> exercises = new HashSet<>();
        exercises.add(exercise1);
        exercises.add(exercise2);

        StrengthTrainingDTO dto = new StrengthTrainingDTO(LocalDate.now(), "Workout 1", Duration.ofHours(1), exercises);

        // When
        when(trainingRepository.save(any(StrengthTraining.class))).thenReturn(new StrengthTraining());
        StrengthTrainingDTO result = trainingService.createStrengthTraining(dto);

        // Then
        assertEquals(2, result.getExercisesCount());
        assertEquals(7, result.getSets()); // 3 + 4
        assertEquals(62, result.getReps()); // (3 * 10) + (4 * 8)
        assertEquals(180.0, result.getWeight()); // 100.0 + 80.0

        verify(trainingRepository, times(1)).save(any(StrengthTraining.class));
    }

    @Test
    void testCreateCardioTraining() {
        // Given
        CardioExerciseDTO exercise1 = new CardioExerciseDTO("Running", "None", "Run fast", 5.0, Duration.ofMinutes(30), 10.0, "running");
        CardioExerciseDTO exercise2 = new CardioExerciseDTO("Cycling", "Bicycle", "Cycle hard", 10.0, Duration.ofMinutes(60), 20.0, "cycling");

        HashSet<CardioExerciseDTO> exercises = new HashSet<>();
        exercises.add(exercise1);
        exercises.add(exercise2);

        CardioTrainingDTO dto = new CardioTrainingDTO(LocalDate.now(), "Cardio Workout 1", Duration.ofHours(1), 15.0, 15.0, exercises);

        // When
        when(trainingRepository.save(any(CardioTraining.class))).thenReturn(new CardioTraining());
        CardioTrainingDTO result = trainingService.createCardioTraining(dto);

        // Then
        assertEquals(15.0, result.getDistance());
        assertEquals(15.0, result.getTempo());

        verify(trainingRepository, times(1)).save(any(CardioTraining.class));
    }
}
