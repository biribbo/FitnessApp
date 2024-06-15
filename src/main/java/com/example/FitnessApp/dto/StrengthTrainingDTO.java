package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.StrengthExercise;
import com.example.FitnessApp.model.training.StrengthTraining;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
public class StrengthTrainingDTO {
    private int id;
    private LocalDate date;
    private String title;
    private Duration duration;
    private int weight;
    private int exercisesCount;
    private int sets;
    private int reps;
    private Set<StrengthExercise> exercises;

    public StrengthTraining toModel() {
        return new StrengthTraining(date, title, duration, weight, exercisesCount, sets, reps, exercises);
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
        this.exercises = source.getExercises();
    }

    public StrengthTrainingDTO(LocalDate date, String title, Duration duration, int weight, int exercisesCount, int sets, int reps, Set<StrengthExercise> exercises) {
        this.date = date;
        this.title = title;
        this.duration = duration;
        this.weight = weight;
        this.exercisesCount = exercisesCount;
        this.sets = sets;
        this.reps = reps;
        this.exercises = exercises;
    }
}