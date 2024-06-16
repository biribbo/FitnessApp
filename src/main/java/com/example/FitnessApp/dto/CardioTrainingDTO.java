package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.CardioExercise;
import com.example.FitnessApp.model.training.CardioTraining;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CardioTrainingDTO {
    private int id;
    private LocalDate date;
    private String title;
    private Duration duration;
    @Setter
    private double distance;
    @Setter
    private double tempo;
    private Set<CardioExerciseDTO> exercises;

    public CardioTraining toModel() {
        Set<CardioExercise> exercisesModel = exercises.stream()
                .map(CardioExerciseDTO::toModel)
                .collect(Collectors.toSet());
        return new CardioTraining(date, title, duration, exercisesModel, distance, tempo);
    }

    public CardioTrainingDTO(CardioTraining source) {
        this.id = source.getId();
        this.date = source.getDate();
        this.title = source.getTitle();
        this.duration = source.getDuration();
        this.distance = source.getDistance();
        this.tempo = source.getTempo();
        this.exercises = source.getExercises().stream()
                .map(CardioExerciseDTO::new)
                .collect(Collectors.toSet());
    }

    public CardioTrainingDTO(LocalDate date, String title, Duration duration, double distance, double tempo, Set<CardioExerciseDTO> exercises) {
        this.date = date;
        this.title = title;
        this.duration = duration;
        this.distance = distance;
        this.tempo = tempo;
        this.exercises = exercises;
    }
}