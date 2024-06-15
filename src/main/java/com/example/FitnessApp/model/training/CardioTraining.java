package com.example.FitnessApp.model.training;

import com.example.FitnessApp.model.exercise.CardioExercise;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class CardioTraining extends Training {
    @ManyToMany
    private Set<CardioExercise> exercises;
    private float distance;
    private float tempo;

    public CardioTraining(LocalDate date, String title, Duration duration, Set<CardioExercise> exercises, float distance, float tempo) {
        super(date, title, duration);
        this.exercises = exercises;
        this.distance = distance;
        this.tempo = tempo;
    }
}
