package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.CardioExercise;
import com.example.FitnessApp.model.training.CardioTraining;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
public class CardioTrainingDTO {
    private int id;
    private LocalDate date;
    private String title;
    private Duration duration;
    private float distance;
    private float tempo;
    private Set<CardioExercise> exercises;

    public CardioTraining toModel() {
        return new CardioTraining(date, title, duration, exercises, distance, tempo);
    }

    public CardioTrainingDTO(CardioTraining source) {
        this.id = source.getId();
        this.date = source.getDate();
        this.title = source.getTitle();
        this.duration = source.getDuration();
        this.distance = source.getDistance();
        this.tempo = source.getTempo();
        this.exercises = source.getExercises();
    }

    public CardioTrainingDTO(LocalDate date, String title, Duration duration, float distance, float tempo, Set<CardioExercise> exercises) {
        this.date = date;
        this.title = title;
        this.duration = duration;
        this.distance = distance;
        this.tempo = tempo;
        this.exercises = exercises;
    }
}