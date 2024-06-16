package com.example.FitnessApp.model.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@DiscriminatorValue("CARDIO")
@Getter
@NoArgsConstructor
public class CardioExercise extends Exercise {
    private double distance;
    private Duration duration;
    private double tempo;
    private Cardio type;

    public CardioExercise(String name, String equipment, String instructions, double distance, Duration duration, double tempo, Cardio type) {
        super(name, equipment, instructions);
        this.distance = distance;
        this.duration = duration;
        this.tempo = tempo;
        this.type = type;
    }
}