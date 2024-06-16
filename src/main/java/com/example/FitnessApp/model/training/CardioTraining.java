package com.example.FitnessApp.model.training;

import com.example.FitnessApp.model.exercise.CardioExercise;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class CardioTraining extends Training {
    @OneToMany
    private Set<CardioExercise> exercises;
    private double distance;
    private double tempo;

    public CardioTraining(LocalDate date, String title, Duration duration, Set<CardioExercise> exercises, double distance, double tempo) {
        super(date, title, duration);
        this.exercises = exercises;
        this.distance = distance;
        this.tempo = tempo;
    }
}
