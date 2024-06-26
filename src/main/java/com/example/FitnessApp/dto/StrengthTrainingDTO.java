package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.StrengthExercise;
import com.example.FitnessApp.model.training.StrengthTraining;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class StrengthTrainingDTO {
    private int id;
    private LocalDate date;
    private String title;
    private Duration duration;
    @Setter
    private double weight;
    @Setter
    private int exercisesCount;
    @Setter
    private int sets;
    @Setter
    private int reps;
    @Setter
    private Set<StrengthExerciseDTO> exercises;
    @Setter
    private String user;

    public StrengthTraining toModel() {
        Set<StrengthExercise> exercisesModel = exercises.stream()
                .map(StrengthExerciseDTO::toModel)
                .collect(Collectors.toSet());
        return new StrengthTraining(user, date, title, duration, weight, exercisesCount, sets, reps, exercisesModel);
    }

    public StrengthTrainingDTO(StrengthTraining source) {
        this.id = source.getId();
        this.date = source.getDate();
        this.title = source.getTitle();
        this.duration = source.getDuration();
        this.weight = source.getWeight();
        this.exercisesCount = source.getExercisesCount();
        this.sets = source.getSets();
        this.reps = source.getReps();
        this.exercises = source.getExercises().stream()
                .map(StrengthExerciseDTO::new)
                .collect(Collectors.toSet());
    }

    public StrengthTrainingDTO(LocalDate date, String title, Duration duration, Set<StrengthExerciseDTO> exercises) {
        this.date = date;
        this.title = title;
        this.duration = duration;
        this.exercises = exercises;
    }
}