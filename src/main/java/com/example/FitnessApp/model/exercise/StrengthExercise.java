package com.example.FitnessApp.model.exercise;

import com.example.FitnessApp.model.training.StrengthTraining;
import com.example.FitnessApp.model.training.Training;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@DiscriminatorValue("STRENGTH")
@NoArgsConstructor
public class StrengthExercise extends Exercise {
    private Muscle muscle;
    private int rpe;
    private int sets;
    private int reps;
    private double weight;
    private double estimatedOneRepMax;
    @ManyToOne
    @JoinColumn(name = "training_id")
    @Setter
    private StrengthTraining training;

    public StrengthExercise(String name, String equipment, Muscle muscle, int RPE, int sets, int reps, double weight, double estimatedOneRepMax) {
        super(name, equipment);
        this.muscle = muscle;
        this.rpe = RPE;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.estimatedOneRepMax = estimatedOneRepMax;
    }
}