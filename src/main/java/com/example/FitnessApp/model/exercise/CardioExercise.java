package com.example.FitnessApp.model.exercise;

import com.example.FitnessApp.model.training.CardioTraining;
import com.example.FitnessApp.model.training.Training;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "training_id")
    private CardioTraining training;

    public CardioExercise(String name, String equipment, double distance, Duration duration, double tempo, Cardio type) {
        super(name, equipment);
        this.distance = distance;
        this.duration = duration;
        this.tempo = tempo;
        this.type = type;
    }
}