package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.StrengthExerciseDTO;
import com.example.FitnessApp.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @Test
    void testCreateExercise() {
        // Given
        StrengthExerciseDTO strengthExerciseDTO = new StrengthExerciseDTO("Squat", "Barbell", "Instructions", "quadriceps", 8, 3, 10, 100.0);

        // When
        exerciseService.createExercise(strengthExerciseDTO);

        // Then
        verify(exerciseRepository, times(1)).save(any());
    }
}