package com.example.FitnessApp.controller;

import com.example.FitnessApp.dto.StrengthExerciseDTO;
import com.example.FitnessApp.dto.StrengthTrainingDTO;
import com.example.FitnessApp.service.ExerciseService;
import com.example.FitnessApp.service.TrainingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ControllerIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TrainingService trainingService;

    @MockBean
    private ExerciseService exerciseService;  // Remove this if not needed in any test.

    private MockMvc mockMvc;

    @Autowired
    private Controller controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testNewStrengthTraining() throws Exception {
        // Given
        StrengthExerciseDTO exercise1 = new StrengthExerciseDTO("Squat", "Barbell", "Instructions", "legs", 8, 3, 10, 100.0);
        StrengthExerciseDTO exercise2 = new StrengthExerciseDTO("Bench Press", "Barbell", "Instructions", "chest", 7, 4, 8, 80.0);

        HashSet<StrengthExerciseDTO> exercises = new HashSet<>();
        exercises.add(exercise1);
        exercises.add(exercise2);

        StrengthTrainingDTO dto = new StrengthTrainingDTO(LocalDate.now(), "Workout 1", Duration.ofHours(1), exercises);

        Mockito.when(trainingService.createStrengthTraining(any(StrengthTrainingDTO.class))).thenReturn(dto);

        // When
        mockMvc.perform(post("/strength")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }
}
